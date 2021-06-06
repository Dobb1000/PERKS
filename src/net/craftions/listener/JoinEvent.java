package net.craftions.listener;

import net.craftions.main.Main;
import net.craftions.pet.Pet;
import net.craftions.util.events.handleMenuGUIClick;
import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wolf;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class JoinEvent implements Listener {


    @EventHandler
    public void OnJoin(PlayerJoinEvent event) {
        if(event.getPlayer().hasPermission("perks.trails.totem")) {
            handleMenuGUIClick.Totemparticle.put(event.getPlayer(), false);
        }
        if(event.getPlayer().hasPermission("perks.trails.medbay")) {
            handleMenuGUIClick.medbay.put(event.getPlayer(), false);
        }
        if (event.getPlayer().hasPermission("perks.trails.Dot")) {
            handleMenuGUIClick.Dot.put(event.getPlayer(), "off");
        }
        if(event.getPlayer().hasPermission("perks.trails.firepolygon")) {
            handleMenuGUIClick.firepolygon.put(event.getPlayer(), false);
        }
        if(event.getPlayer().hasPermission("perks.trails.drill")) {
            handleMenuGUIClick.drill.put(event.getPlayer(), false);
        }
        if(event.getPlayer().hasPermission("perks.trails.drill")) {
            handleMenuGUIClick.sphereparticle.put(event.getPlayer(), false);
        }


        ItemStack i = new ItemStack(Material.CLOCK);
        ItemMeta im = i.getItemMeta();
        im.setDisplayName("§6§lPERKS");
        i.setItemMeta(im);
        event.getPlayer().getInventory().setItem(8,i);



            Plugin plugin = Main.getInstance();
            plugin.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {

                //drill
                double drillradius = 5;

                boolean down = false;
                float y = 0;

                Player player = event.getPlayer();
                World world = player.getWorld();

                Particle.DustOptions dustOptions = new Particle.DustOptions(Color.fromRGB(0, 127, 255), 1);
                Particle.DustOptions greendustOptions = new Particle.DustOptions(Color.fromRGB(151, 255, 8), 1);
                Particle.DustOptions reddustOptions = new Particle.DustOptions(Color.fromRGB(255, 0, 0), 1);
                Particle.DustOptions greydustOptions = new Particle.DustOptions(Color.fromRGB(220,220,220), 1);
                Location loc, first, second;

                //Totem
                double var = 0;
                int points = 8; // the amount of points the polygon should have.

                public void run() {













                    Location playerloc = player.getLocation();
                    if (event.getPlayer().isFlying()) {
                        if (handleMenuGUIClick.Totemparticle.get(event.getPlayer())) {
                            if (player.hasPermission("perks.trails.Totem")) {
                                var += Math.PI / 16;
                                loc = player.getLocation();
                                first = loc.clone().add(cos(var), sin(var) + 1, sin(var));
                                second = loc.clone().add(cos(var + Math.PI), sin(var) + 1, sin(var + Math.PI));


                                world.spawnParticle(Particle.TOTEM, first, 0);
                                world.spawnParticle(Particle.TOTEM, second, 0);
                            }
                        }
                        if (player.hasPermission("perks.trails.Dot")) {
                            if (handleMenuGUIClick.Dot.get(event.getPlayer()) == "Blue") {
                                Particle.DustOptions dustOptions = new Particle.DustOptions(Color.fromRGB(0, 0, 255), 1);
                                world.spawnParticle(Particle.REDSTONE, player.getLocation(), 50, dustOptions);
                            } else if (handleMenuGUIClick.Dot.get(event.getPlayer()) == "Green") {
                                Particle.DustOptions dustOptions = new Particle.DustOptions(Color.fromRGB(64, 255, 0), 1);
                                world.spawnParticle(Particle.REDSTONE, player.getLocation(), 50, dustOptions);

                            } else if (handleMenuGUIClick.Dot.get(event.getPlayer()) == "Red") {
                                Particle.DustOptions dustOptions = new Particle.DustOptions(Color.fromRGB(255, 0, 0), 1);
                                world.spawnParticle(Particle.REDSTONE, player.getLocation(), 50, dustOptions);

                            } else if (handleMenuGUIClick.Dot.get(event.getPlayer()) == "Violet") {
                                Particle.DustOptions dustOptions = new Particle.DustOptions(Color.fromRGB(128, 0, 255), 1);
                                world.spawnParticle(Particle.REDSTONE, player.getLocation(), 50, dustOptions);

                            } else if (handleMenuGUIClick.Dot.get(event.getPlayer()) == "Black") {
                                Particle.DustOptions dustOptions = new Particle.DustOptions(Color.fromRGB(0, 0, 0), 1);
                                world.spawnParticle(Particle.REDSTONE, player.getLocation(), 50, dustOptions);

                            } else if (handleMenuGUIClick.Dot.get(event.getPlayer()) == "White") {
                                Particle.DustOptions dustOptions = new Particle.DustOptions(Color.fromRGB(255, 255, 255), 1);
                                world.spawnParticle(Particle.REDSTONE, player.getLocation(), 50, dustOptions);
                            }


                        }
                    } else {

                        if (player.hasPermission("perks.trails.medbay")) {
                            if (handleMenuGUIClick.medbay.get(event.getPlayer())) {
                                if (y >= 2) {
                                    down = true;
                                }
                                if (y <= 0) {

                                    down = false;
                                }

                                if (down) {
                                    y -= 0.01;

                                } else {

                                    y += 0.01;
                                }
                                loc = player.getLocation();
                                for (int degree = 0; degree <= 360; degree++) {
                                    double radians = Math.toRadians(degree);
                                    double x = cos(radians);
                                    double z = sin(radians);
                                    first = loc.clone().add(x, y, z);
                                    world.spawnParticle(Particle.REDSTONE, first, 20, greendustOptions);
                                }
                            }
                        }



                        if (player.hasPermission("perks.trails.firepolygon")) {
                            if (handleMenuGUIClick.firepolygon.get(event.getPlayer())) {
                                double playeryaw = player.getLocation().getYaw();
                                for (int iteration = 0; iteration < points; iteration++) {
                                    double angle = 360.0 / points * iteration;
                                    double nextAngle = 360.0 / points * (iteration + 1); // the angle for the next point.
                                    angle = Math.toRadians(angle);
                                    nextAngle = Math.toRadians(nextAngle); // convert to radians.
                                    double x = cos(angle);
                                    double z = sin(angle);
                                    double x2 = cos(nextAngle);
                                    double z2 = sin(nextAngle);
                                    double deltaX = x2 - x; // get the x-difference between the points.
                                    double deltaZ = z2 - z; // get the z-difference between the points.
                                    double distance = Math.sqrt((deltaX - x) * (deltaX - x) + (deltaZ - z) * (deltaZ - z));

                                    for (double d = 0; d < distance - 1; d += 1) {
                                        world.spawnParticle(Particle.FLAME, playerloc.clone().add(x + deltaX * d, 0, z + deltaZ * d ), 0);
                                    }
                                }
                            }
                        }
                        if (player.hasPermission("perks.trails.sphere")) {
                            if (handleMenuGUIClick.sphereparticle.get(event.getPlayer())) {

                                for (double i = 0; i <= Math.PI; i += Math.PI / 10) {
                                    double radius = Math.sin(i);
                                    double y = Math.cos(i);
                                    for (double a = 0; a < Math.PI * 2; a+= Math.PI / 5) {
                                        double x = Math.cos(a) * radius;
                                        double z = Math.sin(a) * radius;

                                        world.spawnParticle(Particle.VILLAGER_HAPPY, playerloc.clone().add(x,y + 1,z) , 20);
                                    }
                                }
                            }
                        }

                        if (player.hasPermission("perks.trails.drill")) {
                            if (handleMenuGUIClick.drill.get(event.getPlayer())) {
                                for (double y = 5; y >= 0; y -= 0.007) {
                                    drillradius = y / 3;
                                    double x = drillradius * Math.cos(3 * y);
                                    double z = drillradius * Math.sin(3 * y);

                                    double y2 = 5 - y;


                                    world.spawnParticle(Particle.REDSTONE, playerloc.clone().add(x, y2, z), 0, greydustOptions);
                                }

                                for (double y = 5; y >= 0; y -= 0.007) {
                                    drillradius = y / 3;
                                    double x = -(drillradius * Math.cos(3 * y));
                                    double z = -(drillradius * Math.sin(3 * y));

                                    double y2 = 5 - y;

                                    world.spawnParticle(Particle.REDSTONE, playerloc.clone().add(x, y2, z), 10, greydustOptions);

                                }
                            }
                        }







                            }
                        }














    }, 0L, 1L);





    }
}
