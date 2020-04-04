package cmdrnorthpaw.minecam.commands;

import fr.mrmicky.fastparticle.FastParticle;
import fr.mrmicky.fastparticle.ParticleType;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import java.util.HashMap;
import java.util.Map;

public class commandCamera implements CommandExecutor {
    Map gamemodeDict = new HashMap<String, GameMode>();
    Map positionDict = new HashMap<String, Location>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (!player.hasPermission("minecam.use")) {
                player.sendMessage(ChatColor.DARK_RED + "You do not have permission to use this command");
                return true;

            }
            if (!(player.getGameMode() == GameMode.SPECTATOR)) {
                positionDict.put(player.getName(), player.getLocation());
                gamemodeDict.put(player.getName(), player.getGameMode());
                player.setGameMode(GameMode.SPECTATOR);
                player.sendMessage(ChatColor.GREEN + "Camera mode activated.");
                return true;
            }
            else {
                player.setGameMode((GameMode) gamemodeDict.get(player.getName()));
                player.sendMessage(ChatColor.RED + "Camera mode deactivated");
                if (!player.hasPermission("minecam.noTP")) {
                    player.teleport((Location) positionDict.get(player.getName()));
                    player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 2F, 1F);
                    FastParticle.spawnParticle(player, ParticleType.PORTAL, player.getLocation(), 50);
                    player.sendMessage(ChatColor.DARK_PURPLE + "You were teleported back to your original location");
                }
                return true;
            }

        }
        else {
            sender.sendMessage("This command must be run as a player!");
            return true;
        }
    }
}
