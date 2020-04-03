package cmdrnorthpaw.minecam.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class commandCamera implements CommandExecutor {
    public static GameMode mode = GameMode.SURVIVAL;
    public static Location position = new Location(Bukkit.getServer().getWorlds().get(0), 0.0, 0.00, 0.00);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (!player.hasPermission("minecam.use")) {
                player.sendMessage(ChatColor.DARK_RED + "You do not have permission to use this command");
                return true;

            }
            if (!(player.getGameMode() == GameMode.SPECTATOR)) {
                position = player.getLocation();
                mode = player.getGameMode();
                player.setGameMode(GameMode.SPECTATOR);
                player.sendMessage(ChatColor.GREEN + "Camera mode activated.");
                return true;
            }
            else {
                player.setGameMode(mode);
                player.sendMessage(ChatColor.RED + "Camera mode deactivated");
                player.teleport(position);
                player.sendMessage(ChatColor.DARK_PURPLE + "You were teleported back to your original location");
                return true;
            }

        }
        else {
            sender.sendMessage("This command must be run as a player!");
        }
        return false;
    }
}
