package cmdrnorthpaw.minecam.commands;

import org.bukkit.Color;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class commandCamera implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (!player.hasPermission("minecam.use")) {
                player.sendMessage("You do not have permission to use this command");
                return true;

            }
            if (!(player.getGameMode() == GameMode.SPECTATOR)) {
                Location position = player.getLocation();
                GameMode mode = player.getGameMode();
                player.setGameMode(GameMode.SPECTATOR);
                player.sendMessage("Camera mode activated.");
                return true;
            }
            else {
                player.sendMessage("You can't run this command as a spectator!");
            }

        }
        return false;
    }
}
