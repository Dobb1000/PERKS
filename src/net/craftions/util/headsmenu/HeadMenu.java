package net.craftions.util.headsmenu;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import net.craftions.util.events.handleMenuGUIClick;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.craftbukkit.libs.org.apache.commons.lang3.ObjectUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.AnvilInventory;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Field;
import java.util.Base64;
import java.util.HashMap;
import java.util.UUID;

public class HeadMenu implements Listener {
    public static HashMap<String, String> customhead = new HashMap<>();

    public static final String GUI_NAME = "§6§lHEADS";
    //private final String GUI_NAME = "§6§lPERKS";

    public static void openHeadGUI(Player player) {
        Inventory inventory = Bukkit.createInventory(null, 9 * 6, GUI_NAME);



        //null
        ItemStack none = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1);
        ItemMeta nonemeta = none.getItemMeta();
        //back
        ItemStack back = new ItemStack(Material.BARRIER, 1);
        ItemMeta backmeta = back.getItemMeta();
        //EYE
        ItemStack Eye = new ItemStack(Material.ENDER_EYE, 1);
        ItemMeta Eyemeta = back.getItemMeta();
        Eyemeta.setDisplayName("§4§lCustom");
        Eye.setItemMeta(Eyemeta);




        nonemeta.setDisplayName("§l§a");
        none.setItemMeta(nonemeta);
        for (int f = 36; f <= 44; f++) {
            inventory.setItem(f, none);
        }

        player.openInventory(inventory);

        if (player.hasPermission("perks.heads")) {

            backmeta.setDisplayName("§4Zurück");
            back.setItemMeta(backmeta);
            inventory.setItem(49, back);

        }
        if (player.hasPermission("perks.heads.team")) {
            inventory.setItem(0, getSkull("http://textures.minecraft.net/texture/4ea0c6e1b754e83f0e6e42900343a2dfe41dff342d8b062af532611b9ef6c99b", player));


            inventory.setItem(1, getSkull("MCTzOCK", player));



            inventory.setItem(2, getSkull("Sausefix", player));



            inventory.setItem(3, getSkull("DobbCraft", player));



            inventory.setItem(4, getSkull("_Mister_Mystic_", player));

        }
        if (player.hasPermission("perks.heads.furniture")) {
            inventory.setItem(9, getSkull("http://textures.minecraft.net/texture/dd3e0d14a51906f447f00d1be7392a45835c7d47c26bb914bd535fe2902504df", player));
            inventory.setItem(10, getSkull("http://textures.minecraft.net/texture/d3b919f040922eb17733b42d216b7cdefeaea366be14c1ae6993ca7e5909e0f0", player));
            inventory.setItem(11, getSkull("http://textures.minecraft.net/texture/b6857e9876a3644debbf1fd7345a48f999705e0a993a1304928fd06c1b3f1f94", player)); //3
            inventory.setItem(12, getSkull("http://textures.minecraft.net/texture/78ee61a640826ee3878ecf5648a576fcba6472f0e6421850a2d3ad028e53d2ea", player));
            inventory.setItem(13, getSkull("http://textures.minecraft.net/texture/d623988a70c8658a3f79a71738b2ad37673dae132d65035761a64e080b8de831", player));
            inventory.setItem(14, getSkull("http://textures.minecraft.net/texture/972fb52a550c5cc635175807838c8874f97a8d0d9c878f956c1f71f743a8ecc5", player));
            inventory.setItem(15, getSkull("http://textures.minecraft.net/texture/46d2b51f7cd553f2f6e8ad55bfd5ce2073190267123f94253b39b40799bcc198", player));




        }





        if (player.hasPermission("perks.heads.custom")) {




            //player.sendMessage(customhead.get(player.getName()));
            try {
                if (!customhead.get(player.getName()).equals(null)) {
                    inventory.setItem(35, getSkull(customhead.get(player.getName()), player));
                }
            } catch (NullPointerException e) {

                inventory.setItem(35, Eye);
            }




        }




        if (player.hasPermission("perks.heads")) {

            inventory.setItem(53, getSkull("http://textures.minecraft.net/texture/beb588b21a6f98ad1ff4e085c552dcb050efc9cab427f46048f18fc803475f7", player));

        }






        player.openInventory(inventory);







    }
    public static ItemStack getSkull(String url, Player player) {
        ItemStack item = new ItemStack(Material.PLAYER_HEAD, 1, (short) 3);
        if(url.isEmpty())
            return item;
        SkullMeta itemMeta = (SkullMeta) item.getItemMeta();

        if (url.startsWith("http")) {
            GameProfile profile = new GameProfile(UUID.randomUUID(), null);
            byte[] encodedData = Base64.getEncoder().encode(String.format("{textures:{SKIN:{url:\"%s\"}}}", url).getBytes());
            profile.getProperties().put("textures", new Property("textures", new String(encodedData)));
            Field profileField = null;
            try {
                profileField = itemMeta.getClass().getDeclaredField("profile");
                profileField.setAccessible(true);
                profileField.set(itemMeta, profile);
            } catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException e) {
                e.printStackTrace();
            }

            if (url == "http://textures.minecraft.net/texture/beb588b21a6f98ad1ff4e085c552dcb050efc9cab427f46048f18fc803475f7") {
                itemMeta.setDisplayName("§6§lClear");
            }
            if (url == "http://textures.minecraft.net/texture/dd3e0d14a51906f447f00d1be7392a45835c7d47c26bb914bd535fe2902504df") {
                itemMeta.setDisplayName("§4§lRedstone");
            }
            if (url == "http://textures.minecraft.net/texture/d3b919f040922eb17733b42d216b7cdefeaea366be14c1ae6993ca7e5909e0f0") {
                itemMeta.setDisplayName("§6§lVillager with head");
            }
            if (url == "http://textures.minecraft.net/texture/b6857e9876a3644debbf1fd7345a48f999705e0a993a1304928fd06c1b3f1f94") {
                itemMeta.setDisplayName("§3§lBeeOfficer");
            }
            if (url == "http://textures.minecraft.net/texture/78ee61a640826ee3878ecf5648a576fcba6472f0e6421850a2d3ad028e53d2ea") {
                itemMeta.setDisplayName("§2§lClube Steve");
            }
            if (url == "http://textures.minecraft.net/texture/d623988a70c8658a3f79a71738b2ad37673dae132d65035761a64e080b8de831") {
                itemMeta.setDisplayName("§9§lOfficer");
            }
            if (url == "http://textures.minecraft.net/texture/972fb52a550c5cc635175807838c8874f97a8d0d9c878f956c1f71f743a8ecc5") {
                itemMeta.setDisplayName("§4§lEnderOfficer");
            }
            if (url == "http://textures.minecraft.net/texture/46d2b51f7cd553f2f6e8ad55bfd5ce2073190267123f94253b39b40799bcc198") {
                itemMeta.setDisplayName("§9§lCaptainRex");
            }

            if (url == "http://textures.minecraft.net/texture/4ea0c6e1b754e83f0e6e42900343a2dfe41dff342d8b062af532611b9ef6c99b") {
                itemMeta.setDisplayName("§4§lCraftions Team:");
            }











        } else {

        if (url == "DobbCraft") {
            itemMeta.setDisplayName("§4§lDobbCraft");
        }
        else if (url == "MCTzOCK") {
            itemMeta.setDisplayName("§6§lMCTzOCK");
        }
        else if (url == "Sausefix") {
            itemMeta.setDisplayName("§3§lSausefix");
        }
        else if (url == "_Mister_Mystic_") {
            itemMeta.setDisplayName("§3§l_Mister_Mystic_");
            }else {
            itemMeta.setDisplayName(customhead.get(player.getName()));
        }
            itemMeta.setOwner(url);
        }
        item.setItemMeta(itemMeta);
        //return item;
        return item;
    }





}