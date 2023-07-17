package me.nyaruko166.nyarukosplugincollection.command;

import me.nyaruko166.nyarukosplugincollection.entity.DamageLog;
import me.nyaruko166.nyarukosplugincollection.repository.DamageLogRepository;
import me.nyaruko166.nyarukosplugincollection.utils.Msg;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class CheckScore implements CommandExecutor {

    Msg msg = new Msg();

    DamageLogRepository repository = new DamageLogRepository();

//    JsonStorage<Map<String, Double>> jsonStorageMap = new JsonStorage<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("checkscore")) {
            Player player = (Player) sender;
            List<DamageLog> lstDmgLog = repository.getAll();
            for (DamageLog x : lstDmgLog) {
                player.sendMessage(x.toString());
            }
//            Map<String, Double> mapDmg = jsonStorageMap.readJson("dmgMap");
//            player.sendMessage(String.valueOf(mapDmg.get(player.getName())));
            return true;
        }
//        else if (command.getName().equalsIgnoreCase("")) {
//
//        }
        return false;
    }
}
