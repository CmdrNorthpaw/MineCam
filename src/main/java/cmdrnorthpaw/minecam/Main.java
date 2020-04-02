package cmdrnorthpaw.minecam;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

    }

    public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
        if (str.equalsIgnoreCase("s")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("You must run this command as a player!");
                return true;

            }
            Player player = (Player) sender;
            if (player.hasPermission("minecam.use")) {
               player.sendMessage("If you are reading this, then my plugin works!");
            }
        }
        return false;
    }
}
