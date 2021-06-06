package net.craftions.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Speed implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {

            sender.sendMessage("Du Bist kein Spieler, du kannst diesen Command nur als Spieler verwenden");
            return true;

        }
        Player player = (Player) sender;
        if(cmd.getName().equalsIgnoreCase("speed")){
            if(!sender.hasPermission("perks.commands.speed")){
                sender.sendMessage(ChatColor.DARK_RED + "You Dont Have Permissions For Using This Command.");
                return true;
            }



            if (player.getWalkSpeed() == 0.2f) {
                player.setWalkSpeed(0.35f);
                sender.sendMessage(ChatColor.GREEN + "Du bist nun schneller.");
                return true;
            }

            player.setWalkSpeed(0.2f);
            sender.sendMessage(ChatColor.RED + "Du bist nun langsamer.");
            return true;
        }
        return true;
    }
}
