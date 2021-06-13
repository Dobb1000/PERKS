package net.craftions.listener;

import net.craftions.main.Main;
import net.craftions.pet.Pet;
import net.craftions.util.events.handleMenuGUIClick;
import net.craftions.util.particles.*;
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



                int points = 8;
                Player player = event.getPlayer();
                World world = player.getWorld();

                Particle.DustOptions dustOptions = new Particle.DustOptions(Color.fromRGB(0, 127, 255), 1);
                Particle.DustOptions greendustOptions = new Particle.DustOptions(Color.fromRGB(151, 255, 8), 1);
                Particle.DustOptions reddustOptions = new Particle.DustOptions(Color.fromRGB(255, 0, 0), 1);
                Particle.DustOptions greydustOptions = new Particle.DustOptions(Color.fromRGB(220,220,220), 1);
                Location loc, first, second;



                public void run() {
                    Location playerloc = player.getLocation();
                    if (player.isFlying()) {
                        Totem.totemparticle(player);
                        Dot.dotparticle(player);
                    } else {
                        Medbay.Medbayparticle(player);
                        Firepolygon.firepolygonparticle(player);
                        Drill.drillparticle(player);
                        Sphere.sphereparticle(player);
                            }
                        }
    }, 0L, 1L);





    }
}
