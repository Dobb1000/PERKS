package net.craftions.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Glow implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {


            Player player = (Player) sender;

            if (!player.hasPotionEffect(PotionEffectType.GLOWING)) {
                player.addPotionEffect((new PotionEffect(PotionEffectType.GLOWING, 19999980, 1, false, false)));
                player.sendMessage("§aDu Leuchtest nun.");
                return true;
            }

            player.removePotionEffect(PotionEffectType.GLOWING);
            player.sendMessage( ChatColor.RED + "Du Leuchtest nicht mehr.");

        return true;
    }



}
