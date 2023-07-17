package me.nyaruko166.nyarukosplugincollection.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Consumer;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

@Data
@AllArgsConstructor
public class PluginChecker {

    private final JavaPlugin plugin;

    private final int resourceID;

    public void getVersion(final Consumer<String> consumer) {
        Bukkit.getScheduler().runTaskAsynchronously(this.plugin, () -> {
            try (InputStream is = new URL("https://api.spigotmc.org/legacy/update.php?resource=" + this.resourceID)
                    .openStream(); Scanner scanner = new Scanner(is)) {
                if (scanner.hasNext()) {
                    consumer.accept(scanner.next());
                }
            } catch (IOException e) {
                plugin.getLogger().info("Check update lỗi: " + e.getMessage());
            }
        });
    }

}
