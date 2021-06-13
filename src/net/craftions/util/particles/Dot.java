package net.craftions.util.particles;

import net.craftions.util.events.handleMenuGUIClick;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class Dot {



    public static void dotparticle(Player player) {
        World world = player.getWorld();
        Location loc = player.getLocation();

        if (player.hasPermission("perks.trails.Dot")) {
            if (handleMenuGUIClick.Dot.get(player) == "Blue") {
                Particle.DustOptions dustOptions = new Particle.DustOptions(Color.fromRGB(0, 0, 255), 1);
                world.spawnParticle(Particle.REDSTONE, player.getLocation(), 50, dustOptions);
            } else if (handleMenuGUIClick.Dot.get(player) == "Green") {
                Particle.DustOptions dustOptions = new Particle.DustOptions(Color.fromRGB(64, 255, 0), 1);
                world.spawnParticle(Particle.REDSTONE, player.getLocation(), 50, dustOptions);

            } else if (handleMenuGUIClick.Dot.get(player) == "Red") {
                Particle.DustOptions dustOptions = new Particle.DustOptions(Color.fromRGB(255, 0, 0), 1);
                world.spawnParticle(Particle.REDSTONE, player.getLocation(), 50, dustOptions);

            } else if (handleMenuGUIClick.Dot.get(player) == "Violet") {
                Particle.DustOptions dustOptions = new Particle.DustOptions(Color.fromRGB(128, 0, 255), 1);
                world.spawnParticle(Particle.REDSTONE, player.getLocation(), 50, dustOptions);

            } else if (handleMenuGUIClick.Dot.get(player) == "Black") {
                Particle.DustOptions dustOptions = new Particle.DustOptions(Color.fromRGB(0, 0, 0), 1);
                world.spawnParticle(Particle.REDSTONE, player.getLocation(), 50, dustOptions);

            } else if (handleMenuGUIClick.Dot.get(player) == "White") {
                Particle.DustOptions dustOptions = new Particle.DustOptions(Color.fromRGB(255, 255, 255), 1);
                world.spawnParticle(Particle.REDSTONE, player.getLocation(), 50, dustOptions);
            }


        }




    }
}
