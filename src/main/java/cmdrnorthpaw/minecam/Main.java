package cmdrnorthpaw.minecam;

import cmdrnorthpaw.minecam.commands.commandCamera;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public final class Main extends JavaPlugin {
    public Map gamemodeDict = new HashMap<String, GameMode>();
    public Map positionDict = new HashMap<String, Location>();
    public File dataFile = new File(getDataFolder(), "data.yml");
    public FileConfiguration data = YamlConfiguration.loadConfiguration(dataFile);

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getCommand("camera").setExecutor(new commandCamera());
        createYmls();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        saveData();
    }

    private void createYmls() {
        if (!getDataFolder().exists()) {
            getDataFolder().mkdirs();
        }
        File config = new File(getDataFolder(), "config.yml");
        if (!config.exists()) {
            getLogger().info("Creating new config.yml");
            saveDefaultConfig();
        }
        File data = new File(getDataFolder(), "data.yml");
        if (!data.exists()) {
            getLogger().info("Creating new data.yml");
            try {
             data.createNewFile();
            }
            catch (java.io.IOException e) {
            getLogger().info("Error creating data.yml. Data will not be saved");
            }
        }
    }

    private void saveData() {
        gamemodeDict.forEach((key, value) -> data.set("gamemodes." + key, value));
        positionDict.forEach((key, value) -> data.set("positions." + key, value));
        try {
            data.save(dataFile);
        } catch (java.io.IOException e){
            getLogger().info("Data file was not able to save!");
        }
    }

    private void loadData() {
        data.getConfigurationSection("gamemode").getKeys(false).forEach(key ->{
            
        } );
    }
}
