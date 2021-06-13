package net.craftions.util.particles;

import net.craftions.util.events.handleMenuGUIClick;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.entity.Player;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class Firepolygon {



    public static void firepolygonparticle(Player player) {
        World world = player.getWorld();
        Location loc, first;
        loc = player.getLocation();


        if (player.hasPermission("perks.trails.firepolygon")) {
            if (handleMenuGUIClick.firepolygon.get(player)) {
                double playeryaw = player.getLocation().getYaw();
                for (int iteration = 0; iteration < 8; iteration++) {
                    double angle = 360.0 / 8 * iteration;
                    double nextAngle = 360.0 / 8 * (iteration + 1); // the angle for the next point.
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
                        world.spawnParticle(Particle.FLAME, loc.clone().add(x + deltaX * d, 0, z + deltaZ * d ), 0);
                    }
                }
            }
        }
    }


}
