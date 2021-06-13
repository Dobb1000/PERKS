package net.craftions.util.particles;

import net.craftions.util.events.handleMenuGUIClick;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class Drill {

    private static double drillradius = 5;
    private static Particle.DustOptions dustOptions = new Particle.DustOptions(Color.fromRGB(0, 127, 255), 1);
    private static Particle.DustOptions greendustOptions = new Particle.DustOptions(Color.fromRGB(151, 255, 8), 1);
    private static Particle.DustOptions reddustOptions = new Particle.DustOptions(Color.fromRGB(255, 0, 0), 1);
    private static Particle.DustOptions greydustOptions = new Particle.DustOptions(Color.fromRGB(220,220,220), 1);


    public static void drillparticle(Player player) {
        World world = player.getWorld();
        Location loc, first;
        loc = player.getLocation();

        if (player.hasPermission("perks.trails.drill")) {
            if (handleMenuGUIClick.drill.get(player)) {
                for (double y = 5; y >= 0; y -= 0.007) {
                    drillradius = y / 3;
                    double x = drillradius * Math.cos(3 * y);
                    double z = drillradius * Math.sin(3 * y);

                    double y2 = 5 - y;


                    world.spawnParticle(Particle.REDSTONE, loc.clone().add(x, y2, z), 0, greydustOptions);
                }

                for (double y = 5; y >= 0; y -= 0.007) {
                    drillradius = y / 3;
                    double x = -(drillradius * Math.cos(3 * y));
                    double z = -(drillradius * Math.sin(3 * y));

                    double y2 = 5 - y;

                    world.spawnParticle(Particle.REDSTONE, loc.clone().add(x, y2, z), 10, greydustOptions);

                }
            }
        }


    }
}
