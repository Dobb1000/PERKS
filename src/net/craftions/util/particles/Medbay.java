package net.craftions.util.particles;

import net.craftions.util.events.handleMenuGUIClick;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.entity.Player;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class Medbay {
    private static boolean down = false;
    private static float y = 0;
    private static Particle.DustOptions dustOptions = new Particle.DustOptions(Color.fromRGB(0, 127, 255), 1);
    private static Particle.DustOptions greendustOptions = new Particle.DustOptions(Color.fromRGB(151, 255, 8), 1);
    private static Particle.DustOptions reddustOptions = new Particle.DustOptions(Color.fromRGB(255, 0, 0), 1);
    private static Particle.DustOptions greydustOptions = new Particle.DustOptions(Color.fromRGB(220,220,220), 1);



    public static void Medbayparticle(Player player) {
        World world = player.getWorld();
        Location loc, first;
        loc = player.getLocation();

        if (player.hasPermission("perks.trails.medbay")) {
            if (handleMenuGUIClick.medbay.get(player)) {
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
                    world.spawnParticle(Particle.REDSTONE, first, 6, greendustOptions);
                }
            }
        }


    }
}
