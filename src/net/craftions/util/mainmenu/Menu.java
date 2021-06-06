package net.craftions.util.mainmenu;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import com.mysql.fabric.xmlrpc.base.Array;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.block.Skull;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Base64;
import java.util.UUID;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Menu implements Listener {


    public static final String GUI_NAME = "§6§lPERKS";
    //private final String GUI_NAME = "§6§lPERKS";

    public static void openGUI(Player player) {
        Inventory inventory = Bukkit.createInventory(null, 9*6, GUI_NAME);

        //SPEED

        ItemStack speed = new ItemStack(Material.DIAMOND_BOOTS,1);
        ItemMeta speedmeta = speed.getItemMeta();

        ItemStack speednoperm = new ItemStack(Material.LEATHER_BOOTS,1);
        ItemMeta speedmetanoperm = speednoperm.getItemMeta();

        //FLY

        ItemStack fly = new ItemStack(Material.ELYTRA,1);
        ItemMeta flymeta = fly.getItemMeta();

        ItemStack flynoperm = new ItemStack(Material.ELYTRA,1);
        ItemMeta flymetanoperm = flynoperm.getItemMeta();

        //GLOW

        ItemStack glow = new ItemStack(Material.GLASS,1);
        ItemMeta glowmeta = fly.getItemMeta();

        ItemStack glownoperm = new ItemStack(Material.BLACK_STAINED_GLASS,1);
        ItemMeta glowmetanoperm = flynoperm.getItemMeta();

        //null
        ItemStack none = new ItemStack(Material.BLACK_STAINED_GLASS_PANE,1);
        ItemMeta nonemeta = none.getItemMeta();
        //Trail
        ItemStack trail = new ItemStack(Material.RED_DYE,1);
        ItemMeta trailmeta = trail.getItemMeta();

        ItemStack trailnoperm = new ItemStack(Material.GRAY_DYE,1);
        ItemMeta trailnopermmeta = trailnoperm.getItemMeta();
        //pets
        ItemStack Pets = new ItemStack(Material.VILLAGER_SPAWN_EGG, 1);
        ItemMeta petsmeta = Pets.getItemMeta();
        petsmeta.setDisplayName("§3§lPets");
        Pets.setItemMeta(petsmeta);



        nonemeta.setDisplayName("§l§a");
        none.setItemMeta(nonemeta);
        for(int f = 36; f <= 44; f++) {
        inventory.setItem(f, none);
        }

        player.openInventory(inventory);
        if (player.hasPermission("perks.trails")){

            trailmeta.setDisplayName("§6§lTrails");
            trail.setItemMeta(trailmeta);
            inventory.setItem(49, trail);

        } else {
            trailnopermmeta.setDisplayName("§4Keine Berechtigung");
            trailnoperm.setItemMeta(trailnopermmeta);
            inventory.setItem(49, trailnoperm);
        }


        if(player.hasPermission("perks.commands.fly")){

            if(player.getAllowFlight() == false){
                flymeta.setDisplayName("§l§aFly an");}
            else {
                flymeta.setDisplayName("§l§4Fly aus");
            }
            fly.setItemMeta(flymeta);
            inventory.setItem(2, fly);

        } else {
            flymetanoperm.setDisplayName("§l§4Keine Berechtigung");
            flynoperm.setItemMeta(flymetanoperm);
            inventory.setItem(2, flynoperm);
        }
        if(player.hasPermission("perks.commands.glow")){

            if(!player.hasPotionEffect(PotionEffectType.GLOWING)){
                glowmeta.setDisplayName("§l§aGlow an");
            } else {
                glowmeta.setDisplayName("§l§4Glow aus");
            }
            glow.setItemMeta(glowmeta);
            inventory.setItem(6, glow);

        } else {
            glowmetanoperm.setDisplayName("§l§4Keine Berechtigung");
            glownoperm.setItemMeta(glowmetanoperm);
            inventory.setItem(6, glownoperm);
        }

        if(player.hasPermission("perks.commands.speed")){



            if (player.getWalkSpeed() == 0.2f) {
            speedmeta.setDisplayName("§l§aSpeed an");}
            else {
                speedmeta.setDisplayName("§l§4Speed aus");
            }


            speed.setItemMeta(speedmeta);
            inventory.setItem(4, speed);
        }else {
            speedmetanoperm.setDisplayName("§l§4Keine Berechtigung");
            speednoperm.setItemMeta(speedmetanoperm);
            inventory.setItem(4, speednoperm);

        }

        if (player.hasPermission("perks.heads")) {
        inventory.setItem(50, getSkull("http://textures.minecraft.net/texture/10f96d9b72303f37279fa9c2cc23ee6f8db6823685b626b56ed53b674b6b0"));}
        else {

            inventory.setItem(50, getSkull("http://textures.minecraft.net/texture/665c97d028aef38d7f688e25e5b4833565e520e8b1eb4bcb00dd84971b2ad897"));

        }
        if (player.hasPermission("perks.pets")) {

            inventory.setItem(48, Pets);
        }else {
            inventory.setItem(48, trailnoperm);
        }

    }





    public static ItemStack getSkull(String url) {
        ItemStack item = new ItemStack(Material.PLAYER_HEAD, 1, (short) 3);
        if(url.isEmpty())
            return item;


        SkullMeta itemMeta = (SkullMeta) item.getItemMeta();
        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
        byte[] encodedData = Base64.getEncoder().encode(String.format("{textures:{SKIN:{url:\"%s\"}}}", url).getBytes());
        profile.getProperties().put("textures", new Property("textures", new String(encodedData)));
        Field profileField = null;
        try
        {
            profileField = itemMeta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(itemMeta, profile);
        }
        catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException e)
        {
            e.printStackTrace();
        }
        if (url == "http://textures.minecraft.net/texture/10f96d9b72303f37279fa9c2cc23ee6f8db6823685b626b56ed53b674b6b0") {
            itemMeta.setDisplayName("§6§lHeads");
        }
        if (url == "http://textures.minecraft.net/texture/665c97d028aef38d7f688e25e5b4833565e520e8b1eb4bcb00dd84971b2ad897") {
            itemMeta.setDisplayName("§4Keine Berechtigung");
        }
        item.setItemMeta(itemMeta);
        //return item;
        return item;
    }




}
