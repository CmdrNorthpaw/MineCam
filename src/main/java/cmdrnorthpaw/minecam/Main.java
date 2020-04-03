package cmdrnorthpaw.minecam;

import cmdrnorthpaw.minecam.commands.commandCamera;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getCommand("camera").setExecutor(new commandCamera());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

    }
}
