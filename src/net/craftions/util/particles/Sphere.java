package net.craftions.util.particles;

import net.craftions.util.events.handleMenuGUIClick;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class Sphere {



    public static void sphereparticle(Player player) {
        World world = player.getWorld();
        Location loc, first;
        loc = player.getLocation();

        if (player.hasPermission("perks.trails.sphere")) {
            if (handleMenuGUIClick.sphereparticle.get(player)) {

                for (double i = 0; i <= Math.PI; i += Math.PI / 10) {
                    double radius = Math.sin(i);
                    double y = Math.cos(i);
                    for (double a = 0; a < Math.PI * 2; a+= Math.PI / 5) {
                        double x = Math.cos(a) * radius;
                        double z = Math.sin(a) * radius;

                        world.spawnParticle(Particle.VILLAGER_HAPPY, loc.clone().add(x,y + 1,z) , 20);
                    }
                }
            }
        }



    }
}
