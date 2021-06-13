package net.craftions.util.particles;

import net.craftions.util.events.handleMenuGUIClick;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.entity.Player;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class Totem {

    private static double var = 0;
    //Totem
    // the amount of points the polygon should have.



    public static void totemparticle (Player player) {

        World world = player.getWorld();
        Location loc, first, second;
        loc = player.getLocation();
        if (handleMenuGUIClick.Totemparticle.get(player)) {
            if (player.hasPermission("perks.trails.Totem")) {


                var += Math.PI / 16;
                loc = player.getLocation();
                first = loc.clone().add(cos(var), sin(var) + 1, sin(var));
                second = loc.clone().add(cos(var + Math.PI), sin(var) + 1, sin(var + Math.PI));


                world.spawnParticle(Particle.TOTEM, first, 0);
                world.spawnParticle(Particle.TOTEM, second, 0);
            }
        }



    }



}
