package net.craftions.commands;



import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class Fly implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;
        if(player.hasPermission("perks.commands.fly")){
                if(player.getAllowFlight() == false){
                    player.sendMessage(ChatColor.GREEN + "Du kannst nun fliegen.");
                    player.setAllowFlight(true);
                    return true;
                }
                player.setAllowFlight(false);
                player.sendMessage(ChatColor.RED + "Du kannst nun nicht mehr fliegen.");
                return true;
            }
        return true;
        }
}
