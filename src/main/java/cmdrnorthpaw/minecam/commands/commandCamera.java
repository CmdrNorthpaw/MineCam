package cmdrnorthpaw.minecam.commands;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class commandCamera implements CommandExecutor {
    public static GameMode mode = GameMode.SURVIVAL;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            Location position = player.getLocation();
            if (!player.hasPermission("minecam.use")) {
                player.sendMessage("You do not have permission to use this command");
                return true;

            }
            if (!(player.getGameMode() == GameMode.SPECTATOR)) {
                position = player.getLocation();
                mode = player.getGameMode();
                player.setGameMode(GameMode.SPECTATOR);
                player.sendMessage("Camera mode activated.");
                return true;
            }
            else {
                player.setGameMode(mode);
                player.sendMessage("Camera mode deactivated");
                player.teleport(position);
                player.sendMessage("You were teleported back to your original location");
                return true;
            }

        }
        return false;
    }
}
