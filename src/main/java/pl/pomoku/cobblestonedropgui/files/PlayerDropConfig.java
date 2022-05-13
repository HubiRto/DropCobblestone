package pl.pomoku.cobblestonedropgui.files;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class PlayerDropConfig {
    private static File file;
    private static FileConfiguration customFile;

    public static void setup() {
        file = new File(Bukkit.getServer().getPluginManager().getPlugin("Main").getDataFolder(), "drop_config.yml");
        if(!file.exists()) {
            try{
                file.createNewFile();
            }catch (IOException e) {

            }
            customFile = YamlConfiguration.loadConfiguration(file);
        }
    }
    public static FileConfiguration get() {
        return customFile;
    }
    public static void save() {
        try {
            customFile.save(file);
        }catch (IOException e) {
            System.out.println("Nie mozna zapisac pliku!");
        }
    }
    public static void reload() {
        customFile = YamlConfiguration.loadConfiguration(file);
    }
}
