package me.nyaruko166.nyarukosplugincollection.command;

import me.nyaruko166.nyarukosplugincollection.utils.Msg;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Heal implements CommandExecutor {

    Msg msg = new Msg();

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            player.setHealth(20);
            msg.send(commandSender, "&cHealed!!");
        }
        return true;
    }
}
