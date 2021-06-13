package net.craftions.util.trailsmenu;

import net.craftions.util.events.handleMenuGUIClick;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class TrailMenu implements Listener {


    public static final String GUI_NAME = "§6§lTrails";
    //private final String GUI_NAME = "§6§lPERKS";

    public static void openTrailGUI(Player player) {
        Inventory inventory = Bukkit.createInventory(null, 9 * 6, GUI_NAME);

        //SPEED

        ItemStack speed = new ItemStack(Material.DIAMOND_BOOTS, 1);
        ItemMeta speedmeta = speed.getItemMeta();

        ItemStack speednoperm = new ItemStack(Material.LEATHER_BOOTS, 1);
        ItemMeta speedmetanoperm = speednoperm.getItemMeta();

        //FLY

        ItemStack totem = new ItemStack(Material.TOTEM_OF_UNDYING, 1);
        ItemMeta totemmeta = totem.getItemMeta();

        ItemStack flynoperm = new ItemStack(Material.ELYTRA, 1);
        ItemMeta flymetanoperm = flynoperm.getItemMeta();

        //null
        ItemStack none = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1);
        ItemMeta nonemeta = none.getItemMeta();
        //back
        ItemStack back = new ItemStack(Material.BARRIER, 1);
        ItemMeta backmeta = back.getItemMeta();

        //Dot
        ItemStack Dot_none = new ItemStack(Material.GRAY_DYE, 1);
        ItemStack Dot_white = new ItemStack(Material.WHITE_DYE, 1);
        ItemStack Dot_black = new ItemStack(Material.BLACK_DYE, 1);
        ItemStack Dot_green = new ItemStack(Material.LIME_DYE, 1);
        ItemStack Dot_violett = new ItemStack(Material.PURPLE_DYE, 1);
        ItemStack Dot_blue = new ItemStack(Material.BLUE_DYE, 1);
        ItemStack Dot_red = new ItemStack(Material.RED_DYE, 1);
        ItemMeta DotMETA = Dot_none.getItemMeta();

        //medbay
        ItemStack medbay = new ItemStack(Material.LIME_STAINED_GLASS_PANE, 1);
        ItemMeta medbaymeta = totem.getItemMeta();
        //firepolygon
        ItemStack firepolygon = new ItemStack(Material.FIRE_CHARGE, 1);
        ItemMeta firepolygonmeta = totem.getItemMeta();

        //Drill
        ItemStack drill = new ItemStack(Material.HOPPER, 1);
        ItemMeta drillmeta = totem.getItemMeta();
        //Sphere
        ItemStack sphere = new ItemStack(Material.SLIME_BALL, 1);
        ItemMeta spheremeta = totem.getItemMeta();


        nonemeta.setDisplayName("§l§a");
        none.setItemMeta(nonemeta);
        for (int f = 36; f <= 44; f++) {
            inventory.setItem(f, none);
        }

        player.openInventory(inventory);
        if (player.hasPermission("perks.trails")) {

            backmeta.setDisplayName("§4Zurück");
            back.setItemMeta(backmeta);
            inventory.setItem(49, back);

        }

        if (player.hasPermission("perks.trails.totem")) {

            if (handleMenuGUIClick.Totemparticle.get(player.getPlayer())) {
                totemmeta.setDisplayName("§4Totem Trail");
                totem.setItemMeta(totemmeta);
                inventory.setItem(0, totem);

            } else {

                totemmeta.setDisplayName("§aTotem Trail");
                totem.setItemMeta(totemmeta);
                inventory.setItem(0, totem);
            }
        }
        if (player.hasPermission("perks.trails.Dot")) {
            if (handleMenuGUIClick.Dot.get(player.getPlayer()) == "off") {
                DotMETA.setDisplayName(ChatColor.GRAY + "Keinen ausgewählt.");
                Dot_none.setItemMeta(DotMETA);
                inventory.setItem(1, Dot_none);
            } else if (handleMenuGUIClick.Dot.get(player.getPlayer()) == "Blue") {
                DotMETA.setDisplayName(ChatColor.BLUE + "Blau ausgewählt.");
                Dot_blue.setItemMeta(DotMETA);
                inventory.setItem(1, Dot_blue);

            } else if (handleMenuGUIClick.Dot.get(player.getPlayer()) == "Green") {
                DotMETA.setDisplayName(ChatColor.GREEN + "Grün ausgewählt.");
                Dot_green.setItemMeta(DotMETA);
                inventory.setItem(1, Dot_green);


            } else if (handleMenuGUIClick.Dot.get(player.getPlayer()) == "Red") {
                DotMETA.setDisplayName(ChatColor.RED + "Rot ausgewählt.");
                Dot_red.setItemMeta(DotMETA);
                inventory.setItem(1, Dot_red);


            } else if (handleMenuGUIClick.Dot.get(player.getPlayer()) == "Violet") {
                DotMETA.setDisplayName(ChatColor.DARK_PURPLE + "Violett ausgewählt.");
                Dot_violett.setItemMeta(DotMETA);
                inventory.setItem(1, Dot_violett);


            } else if (handleMenuGUIClick.Dot.get(player.getPlayer()) == "Black") {
                DotMETA.setDisplayName(ChatColor.BLACK + "Schwarz ausgewählt.");
                Dot_black.setItemMeta(DotMETA);
                inventory.setItem(1, Dot_black);


            } else if (handleMenuGUIClick.Dot.get(player.getPlayer()) == "White") {
                DotMETA.setDisplayName(ChatColor.WHITE + "Weiß ausgewählt.");
                Dot_white.setItemMeta(DotMETA);
                inventory.setItem(1, Dot_white);

            }
        }

        if (player.hasPermission("perks.trails.medbay")) {

            if (handleMenuGUIClick.medbay.get(player.getPlayer())) {
                medbaymeta.setDisplayName("§4Medbay");
                medbay.setItemMeta(medbaymeta);
                inventory.setItem(18, medbay);

            } else {

                medbaymeta.setDisplayName("§aMedbay");
                medbay.setItemMeta(medbaymeta);
                inventory.setItem(18, medbay);
            }
        }

        if (player.hasPermission("perks.trails.firepolygon")) {

            if (handleMenuGUIClick.firepolygon.get(player.getPlayer())) {
                firepolygonmeta.setDisplayName("§4Feuerpolygon");
                firepolygon.setItemMeta(firepolygonmeta);
                inventory.setItem(19, firepolygon);

            } else {

                firepolygonmeta.setDisplayName("§aFeuerpolygon");
                firepolygon.setItemMeta(firepolygonmeta);
                inventory.setItem(19, firepolygon);
            }

        }

        if (player.hasPermission("perks.trails.drill")) {

            if (handleMenuGUIClick.drill.get(player.getPlayer())) {
                drillmeta.setDisplayName("§4Bohrer");
                drill.setItemMeta(drillmeta);
                inventory.setItem(20, drill);

            } else {

                drillmeta.setDisplayName("§aBohrer");
                drill.setItemMeta(drillmeta);
                inventory.setItem(20, drill);
            }

        }
        if (player.hasPermission("perks.trails.sphere")) {

            if (handleMenuGUIClick.drill.get(player.getPlayer())) {
                drillmeta.setDisplayName("§4Sphere");
                sphere.setItemMeta(drillmeta);
                inventory.setItem(21, sphere);

            } else {

                drillmeta.setDisplayName("§aSphere");
                sphere.setItemMeta(drillmeta);
                inventory.setItem(21, sphere);
            }

        }




        player.openInventory(inventory);
    }




}
