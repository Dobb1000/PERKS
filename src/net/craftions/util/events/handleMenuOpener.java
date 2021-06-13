package net.craftions.util.events;

import net.craftions.util.headsmenu.HeadMenu;
import net.craftions.util.mainmenu.Menu;
import net.craftions.util.petsmenu.PetsMenu;
import net.craftions.util.trailsmenu.TrailMenu;
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


                if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK) {
                    if (!(event.getPlayer().getOpenInventory().getTitle().equals(Menu.GUI_NAME)
                            || event.getPlayer().getOpenInventory().getTitle().equals(PetsMenu.GUI_NAME)
                            || event.getPlayer().getOpenInventory().getTitle().equals(TrailMenu.GUI_NAME) ||
                            event.getPlayer().getOpenInventory().getTitle().equals(HeadMenu.GUI_NAME))) {
                    Menu.openGUI(event.getPlayer());
                    Menu.openGUI(event.getPlayer());
                }

                }
            }
        }else {return;}

    }
}
