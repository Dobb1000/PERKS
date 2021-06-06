package net.craftions.commands;

import net.craftions.util.headsmenu.HeadMenu;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CustomHead implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (args.length == 0) {

        sender.sendMessage("§6§lCustom-Head\n§a/Customhead add <Playername/Head>\n§4/Customhead clear");
        return true;
        }

        switch (args[0].toLowerCase()) {
            case "add": {
                HeadMenu.customhead.clear();
                HeadMenu.customhead.putIfAbsent(sender.getName(), args[1]);
                sender.sendMessage("§aDein Custom head wurde auf: §4§l" + args[1] + " §agesetzt.");
                break;
            }
            case "clear": {
                HeadMenu.customhead.clear();
                sender.sendMessage("§aDein Custom head wurde gecleart");
                break;
            }



        }




        return false;
    }
}
