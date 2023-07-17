package me.nyaruko166.nyarukosplugincollection.utils;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;

public class Msg {

    public String replace(String message) {
        return message.replaceAll("&([0-9a-fk-or])", "\u00a7$1");
    }

    public void log(String message) {
        ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
        console.sendMessage(replace(message));
    }

    public void send(CommandSender sender, String message) {
        sender.sendMessage(replace(message));
    }

    public void chat(CommandSender sender, String message) {
        Bukkit.broadcastMessage(replace("&b" + sender.getName() + "&r") + ": " + replace(message));
    }

    public void broadCast(String message) {
        Bukkit.broadcastMessage(replace(message));
    }

}
