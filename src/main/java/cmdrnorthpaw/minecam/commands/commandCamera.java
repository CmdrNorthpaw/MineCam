package cmdrnorthpaw.minecam.commands;

import cmdrnorthpaw.minecam.Main;
import fr.mrmicky.fastparticle.FastParticle;
import fr.mrmicky.fastparticle.ParticleType;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import sun.nio.ch.FileKey;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class commandCamera implements CommandExecutor {
    Main main = new Main();
    FileConfiguration data = YamlConfiguration.loadConfiguration(new File(main.getDataFolder(), "data.yml"));

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (!player.hasPermission("minecam.use")) {
                player.sendMessage(ChatColor.DARK_RED + "You do not have permission to use this command");
                return true;

            }
            if (!(player.getGameMode() == GameMode.SPECTATOR)) {
                main.positionDict.put(player.getName(), player.getLocation());
                main.gamemodeDict.put(player.getName(), player.getGameMode());
                player.setGameMode(GameMode.SPECTATOR);
                player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 999999, 0));
                player.sendMessage(ChatColor.GREEN + "Camera mode activated.");
                return true;
            }
            else {
                player.setGameMode((GameMode) main.gamemodeDict.get(player.getName()));
                player.removePotionEffect(PotionEffectType.NIGHT_VISION);
                player.sendMessage(ChatColor.RED + "Camera mode deactivated");
                if (!player.hasPermission("minecam.noTP")) {
                    player.teleport((Location) main.positionDict.get(player.getName()));
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
