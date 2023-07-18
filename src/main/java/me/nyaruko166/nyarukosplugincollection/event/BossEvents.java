package me.nyaruko166.nyarukosplugincollection.event;

import me.nyaruko166.nyarukosplugincollection.utils.JsonStorage;
import me.nyaruko166.nyarukosplugincollection.utils.Msg;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;

import java.util.HashMap;
import java.util.Map;

public class BossEvents implements Listener {

    Map<String, Double> dmgMap = new HashMap<>();

    Msg msg = new Msg();

    JsonStorage<Map<String, Double>> jsonStorageMap = new JsonStorage<>();

    @EventHandler
    public void getDamage(EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof EnderDragon && e.getDamager() instanceof Player) {
            String playerName = e.getDamager().getName();
            if (dmgMap.containsKey(playerName)) {
                Double totalDmg = dmgMap.get(playerName) + e.getDamage();
                Math.round(totalDmg);
                dmgMap.put(playerName, totalDmg);
            } else {
                dmgMap.put(playerName, e.getDamage());
            }
        }
    }

    @EventHandler
    public void onKill(EntityDeathEvent e) {
        if (e.getEntity() instanceof EnderDragon) {
            msg.broadCast("&eRồng ngu đã oẳng");
            LivingEntity livingEntity = e.getEntity();
            Player player = livingEntity.getKiller();
            if (player == null) {
                Bukkit.broadcastMessage(ChatColor.RED + "Vãi Lồn Mày Dùng Giường À?");
            } else {
//                plugin.getConfig().set("score", player.getName() + ": " + 1);
//                plugin.getConfig().s;
                msg.broadCast("&c&lMột sát long nhân mới đã xuất hiện");
                msg.broadCast("&bVới danh xưng là: &e" + player.getName());
                for (String x : dmgMap.keySet()) {

                    Bukkit.broadcastMessage(ChatColor.RED + "Thống kê sát thương");
                    Bukkit.broadcastMessage(ChatColor.GOLD + "Số sát thương " + x + " đã gây ra: " + dmgMap.get(x));
                    jsonStorageMap.writeToJson(dmgMap, "dmgMap");
                }
                dmgMap.clear();
            }
        }
    }


}
