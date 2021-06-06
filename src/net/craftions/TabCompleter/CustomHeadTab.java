package net.craftions.TabCompleter;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CustomHeadTab implements TabCompleter {
    List<String> arguments = new ArrayList<String>();

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        if (arguments.isEmpty()) {

            arguments.add("add");
            arguments.add("clear");
        }

        List<String> result = new ArrayList<String>();
        if (args.length == 1) {
            for (String a : arguments) {
                if (a.toLowerCase().startsWith(args[0].toLowerCase()))
                    result.add(a);
            }
            return result;
        }


        return null;
    }
}
