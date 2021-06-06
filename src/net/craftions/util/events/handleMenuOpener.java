package net.craftions.util.events;

import net.craftions.util.mainmenu.Menu;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class handleMenuOpener implements Listener {


    @EventHandler
    public void handleMenuOpener(PlayerInteractEvent event) {
        if(event.getMaterial() == Material.CLOCK) {
            if (event.getItem().getItemMeta().getDisplayName().equals("§6§lPERKS")) {


                if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
                    Menu.openGUI(event.getPlayer());
                    Menu.openGUI(event.getPlayer());

                }
            }
        }else {return;}

    }
}
