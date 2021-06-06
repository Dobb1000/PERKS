package net.craftions.util.events;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import net.craftions.config.Config;
import net.craftions.main.Main;
import net.craftions.pet.Pet;
import net.craftions.util.headsmenu.HeadMenu;
import net.craftions.util.mainmenu.Menu;
import net.craftions.util.petsmenu.PetsMenu;
import net.craftions.util.trailsmenu.TrailMenu;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.awt.*;
import java.lang.reflect.Field;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class handleMenuGUIClick implements Listener {
    public static HashMap<Player, Boolean> Totemparticle = new HashMap<>();
    public static HashMap<Player, String> Dot = new HashMap<>();
    public static HashMap<Player, Boolean> medbay = new HashMap<>();
    public static HashMap<Player, Boolean> firepolygon = new HashMap<>();
    public static HashMap<Player, Boolean> sphereparticle = new HashMap<>();
    public static HashMap<Player, Boolean> drill = new HashMap<>();



    @EventHandler
    public void handleMenuGUIClick(InventoryClickEvent event) {
        if (!(event.getWhoClicked().getGameMode() == GameMode.CREATIVE)) {
            event.setCancelled(true);
        }
        if (event.getCurrentItem() == null) {
            return;
        }
        if (!(event.getWhoClicked() instanceof Player)) {
            return;
        }

        Player player = (Player) event.getWhoClicked();

        if (event.getView().getTitle().equals(Menu.GUI_NAME)) {


            event.setCancelled(true);
            //fly
            if (player.hasPermission("perks.commands.fly")) {
                if (event.getCurrentItem().getType() == Material.ELYTRA) {
                    if (player.getAllowFlight() == false) {
                        player.sendMessage(ChatColor.GREEN + "Du kannst nun fliegen.");
                        player.setAllowFlight(true);
                        Menu.openGUI(player);
                        return;
                    }
                    player.setAllowFlight(false);
                    player.sendMessage(ChatColor.RED + "Du kannst nun nicht mehr fliegen.");
                    Menu.openGUI(player);
                    return;
                }
            }


            //speed
            if (player.hasPermission("perks.commands.speed")) {
                if (event.getCurrentItem().getType() == Material.DIAMOND_BOOTS) {
                    if (player.getWalkSpeed() == 0.2f) {
                        player.setWalkSpeed(0.35f);
                        player.sendMessage(ChatColor.GREEN + "Du bist nun schneller.");
                        Menu.openGUI(player);
                        return;
                    }

                    player.setWalkSpeed(0.2f);
                    player.sendMessage(ChatColor.RED + "Du bist nun langsamer.");
                    Menu.openGUI(player);
                    return;
                }
            }

            //glow
            if (player.hasPermission("perks.commands.glow")) {
                if (event.getCurrentItem().getType() == Material.GLASS) {
                    if (!player.hasPotionEffect(PotionEffectType.GLOWING)) {
                        player.addPotionEffect((new PotionEffect(PotionEffectType.GLOWING, 19999980, 1, false, false)));
                        player.sendMessage(ChatColor.GREEN + "Du Leuchtest nun.");
                        Menu.openGUI(player);
                        return;
                    }

                    player.removePotionEffect(PotionEffectType.GLOWING);
                    player.sendMessage(ChatColor.RED + "Du Leuchtest nicht mehr.");
                    Menu.openGUI(player);
                    return;
                }
            }
            Menu.openGUI(player);
            Menu.openGUI(player);
            if (player.hasPermission("perks.trails")) {
                if (event.getCurrentItem().getType() == Material.RED_DYE) {

                    TrailMenu.openTrailGUI(player);
                }
            }

            if (player.hasPermission("perks.Heads")) {
                if (event.getCurrentItem().getType() == Material.PLAYER_HEAD) {
                    if (event.getCurrentItem().getItemMeta().getDisplayName().contains("§6§lHeads")) {
                        HeadMenu.openHeadGUI(player);
                        HeadMenu.openHeadGUI(player);
                    }


                }

            }

            if (player.hasPermission("perks.pets")) {
                if (event.getCurrentItem().getType() == Material.VILLAGER_SPAWN_EGG) {
                    if (event.getCurrentItem().getItemMeta().getDisplayName().contains("§3§lPets")) {
                        PetsMenu.openPetsMenu(player);
                        PetsMenu.openPetsMenu(player);
                    }


                }

            }


        } else if (event.getView().getTitle().equals(TrailMenu.GUI_NAME)) {

            event.setCancelled(true);

            if (player.hasPermission("perks.trails")) {
                if (event.getCurrentItem().getType() == Material.BARRIER) {
                    Menu.openGUI(player);
                }
            }

            if (player.hasPermission("perks.trails.Totem")) {
                if (event.getCurrentItem().getType() == Material.TOTEM_OF_UNDYING) {
                    if (Totemparticle.get(((Player) event.getWhoClicked()).getPlayer())) {
                        Totemparticle.put(((Player) event.getWhoClicked()).getPlayer(), false);
                        TrailMenu.openTrailGUI(player);
                        return;
                    }

                    Totemparticle.put(((Player) event.getWhoClicked()).getPlayer(), true);
                    TrailMenu.openTrailGUI(player);
                    return;

                }


            }
            if (player.hasPermission("perks.trails.medbay")) {
                if (event.getCurrentItem().getType() == Material.LIME_STAINED_GLASS_PANE) {
                    if (medbay.get(((Player) event.getWhoClicked()).getPlayer())) {
                        medbay.put(((Player) event.getWhoClicked()).getPlayer(), false);
                        TrailMenu.openTrailGUI(player);
                        return;
                    }

                    medbay.put(((Player) event.getWhoClicked()).getPlayer(), true);
                    TrailMenu.openTrailGUI(player);
                    return;

                }
            }

            if (player.hasPermission("perks.trails.firepolygon")) {
                if (event.getCurrentItem().getType() == Material.FIRE_CHARGE) {
                    if (firepolygon.get(((Player) event.getWhoClicked()).getPlayer())) {
                        firepolygon.put(((Player) event.getWhoClicked()).getPlayer(), false);
                        TrailMenu.openTrailGUI(player);
                        return;
                    }

                    firepolygon.put(((Player) event.getWhoClicked()).getPlayer(), true);
                    TrailMenu.openTrailGUI(player);
                    return;

                }
            }
            if (player.hasPermission("perks.trails.drill")) {
                if (event.getCurrentItem().getType() == Material.HOPPER) {
                    if (drill.get(((Player) event.getWhoClicked()).getPlayer())) {
                        drill.put(((Player) event.getWhoClicked()).getPlayer(), false);
                        TrailMenu.openTrailGUI(player);
                        return;
                    }

                    drill.put(((Player) event.getWhoClicked()).getPlayer(), true);
                    TrailMenu.openTrailGUI(player);
                    return;

                }
            }

            if (player.hasPermission("perks.trails.sphere")) {
                if (event.getCurrentItem().getType() == Material.SLIME_BALL) {
                    if (sphereparticle.get(((Player) event.getWhoClicked()).getPlayer())) {
                        sphereparticle.put(((Player) event.getWhoClicked()).getPlayer(), false);
                        TrailMenu.openTrailGUI(player);
                        return;
                    }

                    sphereparticle.put(((Player) event.getWhoClicked()).getPlayer(), true);
                    TrailMenu.openTrailGUI(player);
                    return;

                }
            }

            if (player.hasPermission("perks.trails.Dot")) {
                if (event.getCurrentItem().getType() == Material.WHITE_DYE || event.getCurrentItem().getType() == Material.BLUE_DYE || event.getCurrentItem().getType() == Material.LIME_DYE || event.getCurrentItem().getType() == Material.RED_DYE || event.getCurrentItem().getType() == Material.PURPLE_DYE || event.getCurrentItem().getType() == Material.BLACK_DYE || event.getCurrentItem().getType() == Material.WHITE_DYE || event.getCurrentItem().getType() == Material.BLACK_DYE || event.getCurrentItem().getType() == Material.GRAY_DYE) {
                    if (Dot.get(((Player) event.getWhoClicked()).getPlayer()) == "off") {
                        Dot.put(((Player) event.getWhoClicked()).getPlayer(), "Blue");
                        TrailMenu.openTrailGUI(player);
                        return;
                    } else if (Dot.get(((Player) event.getWhoClicked()).getPlayer()) == "Blue") {
                        Dot.put(((Player) event.getWhoClicked()).getPlayer(), "Green");
                        TrailMenu.openTrailGUI(player);
                        return;

                    } else if (Dot.get(((Player) event.getWhoClicked()).getPlayer()) == "Green") {
                        Dot.put(((Player) event.getWhoClicked()).getPlayer(), "Red");
                        TrailMenu.openTrailGUI(player);
                        return;
                    } else if (Dot.get(((Player) event.getWhoClicked()).getPlayer()) == "Red") {
                        Dot.put(((Player) event.getWhoClicked()).getPlayer(), "Violet");
                        TrailMenu.openTrailGUI(player);
                        return;
                    } else if (Dot.get(((Player) event.getWhoClicked()).getPlayer()) == "Violet") {
                        Dot.put(((Player) event.getWhoClicked()).getPlayer(), "Black");
                        TrailMenu.openTrailGUI(player);
                        return;
                    } else if (Dot.get(((Player) event.getWhoClicked()).getPlayer()) == "Black") {
                        Dot.put(((Player) event.getWhoClicked()).getPlayer(), "White");
                        TrailMenu.openTrailGUI(player);
                        return;
                    } else if (Dot.get(((Player) event.getWhoClicked()).getPlayer()) == "White") {
                        Dot.put(((Player) event.getWhoClicked()).getPlayer(), "off");
                        TrailMenu.openTrailGUI(player);
                        return;
                    }


                }


            }


        } else if (event.getView().getTitle().equals(HeadMenu.GUI_NAME)) {
            event.setCancelled(true);


            if (player.hasPermission("perks.Heads.team")) {
                if (event.getCurrentItem().getType() == Material.PLAYER_HEAD) {
                    if (event.getCurrentItem().getItemMeta().getDisplayName().contains("§4§lDobbCraft")) {

                        event.getWhoClicked().getInventory().setHelmet(getSkull("DobbCraft"));
                        event.getWhoClicked().sendMessage("§6Dein Kopf wurde auf: " + event.getCurrentItem().getItemMeta().getDisplayName() + " §6gesetzt.");
                        return;
                    }
                }
            }
            if (player.hasPermission("perks.Heads.team")) {
                if (event.getCurrentItem().getType() == Material.PLAYER_HEAD) {
                    if (event.getCurrentItem().getItemMeta().getDisplayName().contains("§6§lMCTzOCK")) {


                        event.getWhoClicked().getInventory().setHelmet(getSkull("MCTzOCK"));
                        event.getWhoClicked().sendMessage("§6Dein Kopf wurde auf: " + event.getCurrentItem().getItemMeta().getDisplayName() + " §6gesetzt.");
                        return;
                    }
                }
            }
            if (player.hasPermission("perks.heads.team")) {
                if (event.getCurrentItem().getType() == Material.PLAYER_HEAD) {
                    if (event.getCurrentItem().getItemMeta().getDisplayName().contains("§3§lSausefix")) {

                        event.getWhoClicked().getInventory().setHelmet(getSkull("Sausefix"));
                        event.getWhoClicked().sendMessage("§6Dein Kopf wurde auf: " + event.getCurrentItem().getItemMeta().getDisplayName() + " §6gesetzt.");
                        return;
                    }
                }
            }

            if (player.hasPermission("perks.heads.team")) {
                if (event.getCurrentItem().getType() == Material.PLAYER_HEAD) {
                    if (event.getCurrentItem().getItemMeta().getDisplayName().contains("§3§l_Mister_Mystic_")) {

                        event.getWhoClicked().getInventory().setHelmet(getSkull("_Mister_Mystic_"));
                        event.getWhoClicked().sendMessage("§6Dein Kopf wurde auf: " + event.getCurrentItem().getItemMeta().getDisplayName() + " §6gesetzt.");
                        return;
                    }
                }
            }


            if (player.hasPermission("perks.heads.custom")) {
                if (event.getCurrentItem().getType() == Material.ENDER_EYE) {
                    event.getWhoClicked().sendMessage("§6§lCustom-Head\n§a/Customhead add <Playername/Head>\n§4/Customhead clear");
                    event.getWhoClicked().closeInventory();
                    return;
                }

            }
            if (player.hasPermission("perks.heads.custom")) {
                try {
                    if (event.getCurrentItem().getType() == Material.PLAYER_HEAD) {
                        if (event.getCurrentItem().getItemMeta().getDisplayName().contains(HeadMenu.customhead.get(player.getName()))) {
                            event.getWhoClicked().getInventory().setHelmet(getSkull(HeadMenu.customhead.get(player.getName())));
                            event.getWhoClicked().sendMessage("§6Dein Kopf wurde auf: §4§l" + event.getCurrentItem().getItemMeta().getDisplayName() + " §6gesetzt.");
                            return;
                        }
                    }
                } catch (NullPointerException e) {

                }

            }


            if (player.hasPermission("perks.Heads.furniture")) {
                if (event.getCurrentItem().getType() == Material.PLAYER_HEAD) {
                    if (event.getCurrentItem().getItemMeta().getDisplayName().contains("§4§lRedstone")) {

                        event.getWhoClicked().getInventory().setHelmet(getSkull("http://textures.minecraft.net/texture/dd3e0d14a51906f447f00d1be7392a45835c7d47c26bb914bd535fe2902504df"));
                        event.getWhoClicked().sendMessage("§6Dein Kopf wurde auf: " + event.getCurrentItem().getItemMeta().getDisplayName() + " §6gesetzt.");
                        return;
                    }
                }
                if (event.getCurrentItem().getType() == Material.PLAYER_HEAD) {
                    if (event.getCurrentItem().getItemMeta().getDisplayName().contains("§6§lVillager with head")) {

                        event.getWhoClicked().getInventory().setHelmet(getSkull("http://textures.minecraft.net/texture/d3b919f040922eb17733b42d216b7cdefeaea366be14c1ae6993ca7e5909e0f0"));
                        event.getWhoClicked().sendMessage("§6Dein Kopf wurde auf: " + event.getCurrentItem().getItemMeta().getDisplayName() + " §6gesetzt.");
                        return;
                    }
                }
                if (event.getCurrentItem().getType() == Material.PLAYER_HEAD) {
                    if (event.getCurrentItem().getItemMeta().getDisplayName().contains("§3§lBeeOfficer")) {

                        event.getWhoClicked().getInventory().setHelmet(getSkull("http://textures.minecraft.net/texture/b6857e9876a3644debbf1fd7345a48f999705e0a993a1304928fd06c1b3f1f94"));
                        event.getWhoClicked().sendMessage("§6Dein Kopf wurde auf: " + event.getCurrentItem().getItemMeta().getDisplayName() + " §6gesetzt.");
                        return;
                    }
                }
                if (event.getCurrentItem().getType() == Material.PLAYER_HEAD) {
                    if (event.getCurrentItem().getItemMeta().getDisplayName().contains("§2§lClube Steve")) {

                        event.getWhoClicked().getInventory().setHelmet(getSkull("http://textures.minecraft.net/texture/78ee61a640826ee3878ecf5648a576fcba6472f0e6421850a2d3ad028e53d2ea"));
                        event.getWhoClicked().sendMessage("§6Dein Kopf wurde auf: " + event.getCurrentItem().getItemMeta().getDisplayName() + " §6gesetzt.");
                        return;
                    }
                }
                if (event.getCurrentItem().getType() == Material.PLAYER_HEAD) {
                    if (event.getCurrentItem().getItemMeta().getDisplayName().contains("§9§lOfficer")) {

                        event.getWhoClicked().getInventory().setHelmet(getSkull("http://textures.minecraft.net/texture/d623988a70c8658a3f79a71738b2ad37673dae132d65035761a64e080b8de831"));
                        event.getWhoClicked().sendMessage("§6Dein Kopf wurde auf: " + event.getCurrentItem().getItemMeta().getDisplayName() + " §6gesetzt.");
                        return;
                    }
                }
                if (event.getCurrentItem().getType() == Material.PLAYER_HEAD) {
                    if (event.getCurrentItem().getItemMeta().getDisplayName().contains("§4§lEnderOfficer")) {

                        event.getWhoClicked().getInventory().setHelmet(getSkull("http://textures.minecraft.net/texture/972fb52a550c5cc635175807838c8874f97a8d0d9c878f956c1f71f743a8ecc5"));
                        event.getWhoClicked().sendMessage("§6Dein Kopf wurde auf: " + event.getCurrentItem().getItemMeta().getDisplayName() + " §6gesetzt.");
                        return;
                    }
                }
                if (event.getCurrentItem().getType() == Material.PLAYER_HEAD) {
                    if (event.getCurrentItem().getItemMeta().getDisplayName().contains("§9§lCaptainRex")) {

                        event.getWhoClicked().getInventory().setHelmet(getSkull("http://textures.minecraft.net/texture/46d2b51f7cd553f2f6e8ad55bfd5ce2073190267123f94253b39b40799bcc198"));
                        event.getWhoClicked().sendMessage("§6Dein Kopf wurde auf: " + event.getCurrentItem().getItemMeta().getDisplayName() + " §6gesetzt.");
                        return;
                    }
                }


            }
            if (player.hasPermission("perks.Heads")) {
                if (event.getCurrentItem().getType() == Material.PLAYER_HEAD) {
                    if (event.getCurrentItem().getItemMeta().getDisplayName().contains("§6§lClear")) {

                        ItemStack itemStack = new ItemStack(Material.AIR, 1);
                        event.getWhoClicked().getInventory().setHelmet(itemStack);
                        event.getWhoClicked().sendMessage("§4Dein Kopf wurde resettet.");


                    }
                }
            }


            if (player.hasPermission("perks.heads")) {
                if (event.getCurrentItem().getType() == Material.BARRIER) {

                    Menu.openGUI(player);
                    return;
                }

            }

        } else if (event.getView().getTitle().equals(PetsMenu.GUI_NAME)) {

            if (player.hasPermission("perks.pets")) {
                if (event.getCurrentItem().getType() == Material.BARRIER) {

                    Menu.openGUI(player);
                    return;
                }

            }
            if (player.hasPermission("perks.pets.wolf")) {
                if (event.getCurrentItem().getType() == Material.PLAYER_HEAD) {
                    if (event.getCurrentItem().getItemMeta().getDisplayName().contains("§8§lDogpet")) {
                        List<Entity> entities = player.getWorld().getEntities();
                        for (Entity entity : entities) {

                            if (entity instanceof Wolf) {
                                if (Main.wolfs.get(player.getName()) == entity) {
                                    if (((Wolf) entity).getCollarColor() == DyeColor.GRAY) {
                                        entity.remove();
                                        event.setCancelled(true);
                                        return;


                                    }
                                }
                            }
                        }

                        new Pet().removepet(player, "WOLF");
                        Bukkit.getScheduler().runTaskLater(Main.plugin, new Runnable() {
                            public void run() {
                                EntityType entityType = new Pet().createPet(player, EntityType.WOLF);
                            }
                        }, 2);

                    }
                }
            }
            if (player.hasPermission("perks.pets.pig")) {
                if (event.getCurrentItem().getType() == Material.PLAYER_HEAD) {
                    if (event.getCurrentItem().getItemMeta().getDisplayName().contains("§d§lPigpet")) {
                        List<Entity> entities = player.getWorld().getEntities();
                        for (Entity entity : entities) {

                            if (entity instanceof Pig) {
                                if (Main.pig.get(player.getName()) == entity) {
                                    entity.remove();
                                    event.setCancelled(true);

                                    return;
                                }
                            }
                        }
                        new Pet().removepet(player, "PIG");

                        Bukkit.getScheduler().runTaskLater(Main.plugin, new Runnable() {
                            public void run() {
                                EntityType entityType = new Pet().createPet(player, EntityType.PIG);
                            }
                        }, 2);

                    }


                }
            }
            if (player.hasPermission("perks.pets.bee")) {
                if (event.getCurrentItem().getType() == Material.PLAYER_HEAD) {
                    if (event.getCurrentItem().getItemMeta().getDisplayName().contains("§e§lBeepet")) {
                        List<Entity> entities = player.getWorld().getEntities();
                        for (Entity entity : entities) {

                            if (entity instanceof Bee) {
                                if (Main.bee.get(player.getName()) == entity) {
                                    entity.remove();
                                    event.setCancelled(true);
                                    return;
                                }
                            }
                        }

                        new Pet().removepet(player, "BEE");
                        Bukkit.getScheduler().runTaskLater(Main.plugin, new Runnable() {
                            public void run() {
                                EntityType entityType = new Pet().createPet(player, EntityType.BEE);
                            }
                        }, 2);

                    }


                }
            }
            if (player.hasPermission("perks.pets.piglin")) {
                if (event.getCurrentItem().getType() == Material.PLAYER_HEAD) {
                    if (event.getCurrentItem().getItemMeta().getDisplayName().contains("§c§lPiglinpet")) {
                        List<Entity> entities = player.getWorld().getEntities();
                        for (Entity entity : entities) {

                            if (entity instanceof Piglin) {
                                if (Main.piglin.get(player.getName()) == entity) {
                                    entity.remove();
                                    event.setCancelled(true);
                                    return;
                                }
                            }
                        }

                        new Pet().removepet(player, "PIGLIN");
                        Bukkit.getScheduler().runTaskLater(Main.plugin, new Runnable() {
                            public void run() {
                                EntityType entityType = new Pet().createPet(player, EntityType.PIGLIN);
                            }
                        }, 2);

                    }


                }
            }
            if (player.hasPermission("perks.pets.zoglin")) {
                if (event.getCurrentItem().getType() == Material.PLAYER_HEAD) {
                    if (event.getCurrentItem().getItemMeta().getDisplayName().contains("§5§lZoglinpet")) {
                        List<Entity> entities = player.getWorld().getEntities();
                        for (Entity entity : entities) {

                            if (entity instanceof Zoglin) {
                                if (Main.zoglin.get(player.getName()) == entity) {
                                    entity.remove();
                                    event.setCancelled(true);
                                    return;
                                }
                            }
                        }

                        new Pet().removepet(player, "ZOGLIN");
                        Bukkit.getScheduler().runTaskLater(Main.plugin, new Runnable() {
                            public void run() {
                                EntityType entityType = new Pet().createPet(player, EntityType.ZOGLIN);
                            }
                        }, 2);

                    }


                }
            }
            if (player.hasPermission("perks.pets.hoglin")) {
                if (event.getCurrentItem().getType() == Material.PLAYER_HEAD) {
                    if (event.getCurrentItem().getItemMeta().getDisplayName().contains("§9§lHoglinpet")) {
                        List<Entity> entities = player.getWorld().getEntities();
                        for (Entity entity : entities) {

                            if (entity instanceof Hoglin) {
                                if (Main.hoglin.get(player.getName()) == entity) {
                                    entity.remove();
                                    event.setCancelled(true);
                                    return;
                                }
                            }
                        }

                        new Pet().removepet(player, "HOGLIN");
                        Bukkit.getScheduler().runTaskLater(Main.plugin, new Runnable() {
                            public void run() {
                                EntityType entityType = new Pet().createPet(player, EntityType.HOGLIN);
                            }
                        }, 2);

                    }


                }
            }
            if (player.hasPermission("perks.pets.cow")) {
                if (event.getCurrentItem().getType() == Material.PLAYER_HEAD) {
                    if (event.getCurrentItem().getItemMeta().getDisplayName().contains("§1§lCowpet")) {
                        List<Entity> entities = player.getWorld().getEntities();
                        for (Entity entity : entities) {

                            if (entity instanceof Cow) {
                                if (Main.cow.get(player.getName()) == entity) {
                                    entity.remove();
                                    event.setCancelled(true);
                                    return;
                                }
                            }
                        }

                        new Pet().removepet(player, "COW");
                        Bukkit.getScheduler().runTaskLater(Main.plugin, new Runnable() {
                            public void run() {
                                EntityType entityType = new Pet().createPet(player, EntityType.COW);
                            }
                        }, 2);

                    }


                }
            }
            if (player.hasPermission("perks.pets.sheep")) {
                if (event.getCurrentItem().getType() == Material.PLAYER_HEAD) {
                    if (event.getCurrentItem().getItemMeta().getDisplayName().contains("§f§lSheeppet")) {
                        List<Entity> entities = player.getWorld().getEntities();
                        for (Entity entity : entities) {

                            if (entity instanceof Sheep) {
                                if (Main.sheep.get(player.getName()) == entity) {
                                    entity.remove();
                                    event.setCancelled(true);
                                    return;
                                }
                            }
                        }

                        new Pet().removepet(player, "SHEEP");
                        Bukkit.getScheduler().runTaskLater(Main.plugin, new Runnable() {
                            public void run() {
                                EntityType entityType = new Pet().createPet(player, EntityType.SHEEP);
                            }
                        }, 2);

                    }


                }
            }
            if (player.hasPermission("perks.pets.chicken")) {
                if (event.getCurrentItem().getType() == Material.PLAYER_HEAD) {
                    if (event.getCurrentItem().getItemMeta().getDisplayName().contains("§b§lChickenpet")) {
                        List<Entity> entities = player.getWorld().getEntities();
                        for (Entity entity : entities) {

                            if (entity instanceof Chicken) {
                                if (Main.chicken.get(player.getName()) == entity) {
                                    entity.remove();
                                    event.setCancelled(true);
                                    return;
                                }
                            }
                        }

                        new Pet().removepet(player, "CHICKEN");
                        Bukkit.getScheduler().runTaskLater(Main.plugin, new Runnable() {
                            public void run() {
                                EntityType entityType = new Pet().createPet(player, EntityType.CHICKEN);
                            }
                        }, 2);

                    }


                }
            }
            event.setCancelled(true);
        }

            }
















    public static ItemStack getSkull(String url) {
        ItemStack item = new ItemStack(Material.PLAYER_HEAD, 1, (short) 3);
        if(url.isEmpty())
            return item;
        SkullMeta itemMeta = (SkullMeta) item.getItemMeta();


        if (url.startsWith("http")) {
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
        } else {

            if (url == "DobbCraft") {
                itemMeta.setDisplayName("§4§lDobbCraft");
            }
            if (url == "MCTzOCK") {
                itemMeta.setDisplayName("§6§lMCTzOCK");
            }
            if (url == "Sausefix") {
                itemMeta.setDisplayName("§3§lSausefix");
            }
            if (url == "_Mister_Mystic_") {
                itemMeta.setDisplayName("§3§l_Mister_Mystic_");
            }



            itemMeta.setOwner(url);
        }
        item.setItemMeta(itemMeta);
        //return item;
        return item;
    }



    }