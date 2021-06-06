package net.craftions.util.petsmenu;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import net.craftions.main.Main;
import net.craftions.util.events.handleMenuGUIClick;
import org.bukkit.*;
import org.bukkit.craftbukkit.libs.org.apache.commons.lang3.ObjectUtils;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.AnvilInventory;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkEffectMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Field;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class PetsMenu implements Listener {

    public static final String GUI_NAME = "§6§lPets";
    private ItemMeta greymeta;
    //private final String GUI_NAME = "§6§lPERKS";

    public static void openPetsMenu(Player player) {
        Inventory inventory = Bukkit.createInventory(null, 9 * 6, GUI_NAME);


        //null
        ItemStack none = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1);
        ItemMeta nonemeta = none.getItemMeta();
        //back
        ItemStack back = new ItemStack(Material.BARRIER, 1);
        ItemMeta backmeta = back.getItemMeta();
        //dog-gray
        ItemStack dog = new ItemStack(Material.NAME_TAG, 1);
        ItemMeta dogmeta = back.getItemMeta();


        nonemeta.setDisplayName("§l§a");
        none.setItemMeta(nonemeta);
        for (int f = 36; f <= 44; f++) {
            inventory.setItem(f, none);
        }

        player.openInventory(inventory);

        if (player.hasPermission("perks.pets")) {

            backmeta.setDisplayName("§4Zurück");
            back.setItemMeta(backmeta);
            inventory.setItem(49, back);

        }


        if (player.hasPermission("perks.pets.wolf")) {
            List<Entity> entities = player.getWorld().getEntities();
            for (Entity entity : entities) {

                if (entity instanceof Wolf) {
                    if (Main.wolfs.get(player.getName()) == entity) {
                        inventory.setItem(0, getSkull("http://textures.minecraft.net/texture/69d1d3113ec43ac2961dd59f28175fb4718873c6c448dfca8722317d67", player));


                    }
                } else {
                    inventory.setItem(0, getSkull("http://textures.minecraft.net/texture/69d1d3113ec43ac2961dd59f28175fb4718873c6c448dfca8722317d67", player));

                }


            }

        }
        if (player.hasPermission("perks.pets.pig")) {
            List<Entity> entities = player.getWorld().getEntities();
            for (Entity entity : entities) {

                if (entity instanceof Pig) {
                    if (Main.pig.get(player.getName()) == entity) {
                        inventory.setItem(1, getSkull("http://textures.minecraft.net/texture/621668ef7cb79dd9c22ce3d1f3f4cb6e2559893b6df4a469514e667c16aa4", player));


                    }
                } else {
                    inventory.setItem(1, getSkull("http://textures.minecraft.net/texture/621668ef7cb79dd9c22ce3d1f3f4cb6e2559893b6df4a469514e667c16aa4", player));

                }


            }

        }
        if (player.hasPermission("perks.pets.bee")) {
            List<Entity> entities = player.getWorld().getEntities();
            for (Entity entity : entities) {

                if (entity instanceof Bee) {
                    if (Main.bee.get(player.getName()) == entity) {
                        inventory.setItem(2, getSkull("http://textures.minecraft.net/texture/b6857e9876a3644debbf1fd7345a48f999705e0a993a1304928fd06c1b3f1f94", player));

                    }
                    }else{
                        inventory.setItem(2, getSkull("http://textures.minecraft.net/texture/b6857e9876a3644debbf1fd7345a48f999705e0a993a1304928fd06c1b3f1f94", player));

                }


            }

        }
        if (player.hasPermission("perks.pets.piglin")) {
            List<Entity> entities = player.getWorld().getEntities();
            for (Entity entity : entities) {

                if (entity instanceof Piglin) {
                    if (Main.piglin.get(player.getName()) == entity) {
                        inventory.setItem(3, getSkull("http://textures.minecraft.net/texture/9f18107d275f1cb3a9f973e5928d5879fa40328ff3258054db6dd3e7c0ca6330", player));

                    }
                }else{
                    inventory.setItem(3, getSkull("http://textures.minecraft.net/texture/9f18107d275f1cb3a9f973e5928d5879fa40328ff3258054db6dd3e7c0ca6330", player));

                }


            }

        }
        if (player.hasPermission("perks.pets.zoglin")) {
            List<Entity> entities = player.getWorld().getEntities();
            for (Entity entity : entities) {

                if (entity instanceof Zoglin) {
                    if (Main.zoglin.get(player.getName()) == entity) {
                        inventory.setItem(4, getSkull("http://textures.minecraft.net/texture/e67e18602e03035ad68967ce090235d8996663fb9ea47578d3a7ebbc42a5ccf9", player));

                    }
                }else{
                    inventory.setItem(4, getSkull("http://textures.minecraft.net/texture/e67e18602e03035ad68967ce090235d8996663fb9ea47578d3a7ebbc42a5ccf9", player));

                }


            }

        }
        if (player.hasPermission("perks.pets.hoglin")) {
            List<Entity> entities = player.getWorld().getEntities();
            for (Entity entity : entities) {

                if (entity instanceof Hoglin) {
                    if (Main.zoglin.get(player.getName()) == entity) {
                        inventory.setItem(5, getSkull("http://textures.minecraft.net/texture/9bb9bc0f01dbd762a08d9e77c08069ed7c95364aa30ca1072208561b730e8d75", player));

                    }
                }else{
                    inventory.setItem(5, getSkull("http://textures.minecraft.net/texture/9bb9bc0f01dbd762a08d9e77c08069ed7c95364aa30ca1072208561b730e8d75", player));

                }


            }

        }
        if (player.hasPermission("perks.pets.cow")) {
            List<Entity> entities = player.getWorld().getEntities();
            for (Entity entity : entities) {

                if (entity instanceof Cow) {
                    if (Main.cow.get(player.getName()) == entity) {
                        inventory.setItem(6, getSkull("http://textures.minecraft.net/texture/5d6c6eda942f7f5f71c3161c7306f4aed307d82895f9d2b07ab4525718edc5", player));

                    }
                }else{
                    inventory.setItem(6, getSkull("http://textures.minecraft.net/texture/5d6c6eda942f7f5f71c3161c7306f4aed307d82895f9d2b07ab4525718edc5", player));

                }


            }

        }
        if (player.hasPermission("perks.pets.sheep")) {
            List<Entity> entities = player.getWorld().getEntities();
            for (Entity entity : entities) {

                if (entity instanceof Sheep) {
                    if (Main.sheep.get(player.getName()) == entity) {
                        inventory.setItem(7, getSkull("http://textures.minecraft.net/texture/f31f9ccc6b3e32ecf13b8a11ac29cd33d18c95fc73db8a66c5d657ccb8be70", player));

                    }
                }else{
                    inventory.setItem(7, getSkull("http://textures.minecraft.net/texture/f31f9ccc6b3e32ecf13b8a11ac29cd33d18c95fc73db8a66c5d657ccb8be70", player));

                }


            }

        }
        if (player.hasPermission("perks.pets.chicken")) {
            List<Entity> entities = player.getWorld().getEntities();
            for (Entity entity : entities) {

                if (entity instanceof Chicken) {
                    if (Main.chicken.get(player.getName()) == entity) {
                        inventory.setItem(8, getSkull("http://textures.minecraft.net/texture/1638469a599ceef7207537603248a9ab11ff591fd378bea4735b346a7fae893", player));

                    }
                }else{
                    inventory.setItem(8, getSkull("http://textures.minecraft.net/texture/1638469a599ceef7207537603248a9ab11ff591fd378bea4735b346a7fae893", player));

                }


            }

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

            if (url == "http://textures.minecraft.net/texture/621668ef7cb79dd9c22ce3d1f3f4cb6e2559893b6df4a469514e667c16aa4") {
                        itemMeta.setDisplayName("§d§lPigpet");
            }
            if (url == "http://textures.minecraft.net/texture/b6857e9876a3644debbf1fd7345a48f999705e0a993a1304928fd06c1b3f1f94") {
                            itemMeta.setDisplayName("§e§lBeepet");
            }
            if (url == "http://textures.minecraft.net/texture/9f18107d275f1cb3a9f973e5928d5879fa40328ff3258054db6dd3e7c0ca6330") {

                itemMeta.setDisplayName("§c§lPiglinpet");
            }
            if (url == "http://textures.minecraft.net/texture/e67e18602e03035ad68967ce090235d8996663fb9ea47578d3a7ebbc42a5ccf9") {

                itemMeta.setDisplayName("§5§lZoglinpet");
            }
            if (url == "http://textures.minecraft.net/texture/9bb9bc0f01dbd762a08d9e77c08069ed7c95364aa30ca1072208561b730e8d75") {

                itemMeta.setDisplayName("§9§lHoglinpet");
            }
            if (url == "http://textures.minecraft.net/texture/5d6c6eda942f7f5f71c3161c7306f4aed307d82895f9d2b07ab4525718edc5") {

                itemMeta.setDisplayName("§1§lCowpet");
            }
            if (url == "http://textures.minecraft.net/texture/f31f9ccc6b3e32ecf13b8a11ac29cd33d18c95fc73db8a66c5d657ccb8be70") {

                itemMeta.setDisplayName("§f§lSheeppet");
            }
            if (url == "http://textures.minecraft.net/texture/1638469a599ceef7207537603248a9ab11ff591fd378bea4735b346a7fae893") {

                itemMeta.setDisplayName("§b§lChickenpet");
            }
            if (url == "http://textures.minecraft.net/texture/69d1d3113ec43ac2961dd59f28175fb4718873c6c448dfca8722317d67") {

                itemMeta.setDisplayName("§8§lDogpet");
            }

        } else {

            itemMeta.setOwner(url);
        }
        item.setItemMeta(itemMeta);
        //return item;
        return item;
    }





}