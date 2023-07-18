package me.nyaruko166.nyarukosplugincollection.command;

import me.lordierclaw.util.ListTable;
import me.lordierclaw.util.Table;
import me.nyaruko166.nyarukosplugincollection.entity.DamageLog;
import me.nyaruko166.nyarukosplugincollection.repository.DamageLogRepository;
import me.nyaruko166.nyarukosplugincollection.utils.Msg;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;

import static me.nyaruko166.nyarukosplugincollection.NyarukosPluginCollection.plugin;

public class CheckScore implements CommandExecutor {

    String folderData = plugin.getDataFolder() + "/";

    Msg msg = new Msg();

    DamageLogRepository repository = new DamageLogRepository();

//    JsonStorage<Map<String, Double>> jsonStorageMap = new JsonStorage<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("checkscore")) {
            Player player = (Player) sender;
            List<DamageLog> lstDmgLog = repository.getAll();
            //Def
            ListTable<DamageLog> lstTable = new ListTable<>(List.of("Player Name", "Total Damage", "Date"), new ListTable.ObjectExporter<DamageLog>() {
                @Override
                public Collection<?> exportObjectToRow(DamageLog damageLog) {
                    return List.of(damageLog.getPlayerName(), damageLog.getTotalDamage(), damageLog.getDateEnded());
                }
            });

            for (DamageLog x : lstDmgLog) {
                lstTable.add(new DamageLog(null, x.getPlayerName(), x.getTotalDamage(), null, x.getDateEnded()));
//                player.sendMessage(x.getPlayerName() + x.getTotalDamage() + x.getDateEnded());
            }

            Table table = lstTable.getTable();
            try {
                Font font = Font.createFont(Font.TRUETYPE_FONT, Files.newInputStream(Paths.get(folderData + "Minecraftia-Regular.ttf"))).deriveFont(Font.BOLD, 240f);
                table.setFont(font);
            } catch (FontFormatException | IOException e) {
                throw new RuntimeException(e);
            }


            table.setStyle(Table.STYLE_ADVANCED);
            if (player != null) {
                player.sendMessage(table.toString());
            } else {
                ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
                console.sendMessage(table.toString());
            }


//            player.sendMessage(table.toString().toUpperCase());

//            try (FileWriter fw = new FileWriter(plugin.getDataFolder().toString() + "/styleadv.txt")) {
//                fw.write(String.valueOf(table));
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }

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
