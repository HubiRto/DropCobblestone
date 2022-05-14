package pl.pomoku.cobblestonedropgui.files;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class PlayerDropConfig {
    private static File file;
    private static FileConfiguration configFile;

    public static void setup() {
        //file = new File(Bukkit.getServer().getPluginManager().getPlugin("Main").getDataFolder(), "player_drop_config.yml");
        file = new File("plugins\\CobbleStoneDropGUI", "player_drop_config.yml");
        if(!file.exists()) {
            try{
                file.createNewFile();
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
        configFile = YamlConfiguration.loadConfiguration(file);
    }
    public static FileConfiguration get(){
        return configFile;
    }
    public static void save() {
        try{
            configFile.save(file);
        }catch (IOException e) {
            System.out.println("Nie mozna zapisac pliku!");
        }
    }
    public static void reload() {

        configFile = YamlConfiguration.loadConfiguration(file);
    }
}
