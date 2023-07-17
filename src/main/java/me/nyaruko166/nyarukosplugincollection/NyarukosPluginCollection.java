package me.nyaruko166.nyarukosplugincollection;

import me.nyaruko166.nyarukosplugincollection.command.CheckScore;
import me.nyaruko166.nyarukosplugincollection.event.BossEvents;
import me.nyaruko166.nyarukosplugincollection.utils.Msg;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class NyarukosPluginCollection extends JavaPlugin {

    String folderConfig = getDataFolder().toString();

    public static NyarukosPluginCollection plugin;

    Msg msg = new Msg();

    @Override
    public void onEnable() {
        plugin = this;
        msg.log("&bĐang bật plugin siêu cấp ProVjp của Nyaruko");
//        check(false, null);
        eventRegister();
        commandRegister();
        getConfig().options().copyDefaults();
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        msg.log("&cCút");
    }

    private void eventRegister() {
        getServer().getPluginManager().registerEvents(new BossEvents(), this);
    }

    private void commandRegister() {
//        getCommand("heal").setExecutor(new Heal());
        Objects.requireNonNull(getCommand("checkscore")).setExecutor(new CheckScore());
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("checkupdate")) {
//            if (sender instanceof Player) {
//                check(true, sender);
//                return true;
//            } else {
//                check(false, null);
//                return true;
//            }
        } else if (command.getName().equalsIgnoreCase("chat")) {
            if (args.length > 0) {
                String message = String.join(" ", args);
                // Lặp lại nội dung chat gần nhất
                msg.chat(sender, message);
            }
            return true;
        }
        return true;
    }

//    public void check(Boolean isPlayer, CommandSender sender) {
//        List<Plugin> lstPlugin = new ArrayList<>();
//        List<String> lstStr = getConfig().getList("ListPlugins");
//        if (isPlayer) {
//            msg.send(sender, "&bBắt đầu check update !!!");
//            for (Plugin x : lstPlugin) {
//                new PluginChecker(this, Integer.valueOf(x.getId())).getVersion(version -> {
//                    if (this.getDescription().getVersion().equals(version)) {
//                        msg.send(sender, "&a" + x.getTen() + " không có update mới.");
//                    } else {
//                        msg.send(sender, "&c" + x.getTen() + " có update mới.");
//                    }
//                });
//            }
//        } else {
//            msg.log("&bBắt đầu check update !!!");
//            for (Plugin x : lstPlugin) {
//                new PluginChecker(this, Integer.valueOf(x.getId())).getVersion(version -> {
//                    if (this.getDescription().getVersion().equals(version)) {
//                        msg.log("&a" + x.getTen() + " không có update mới.");
//                    } else {
//                        msg.log("&c" + x.getTen() + " có update mới.");
//                    }
//                });
//            }
//        }
//    }

}
