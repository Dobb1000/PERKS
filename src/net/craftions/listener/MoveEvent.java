package net.craftions.listener;

import net.craftions.main.Main;
import net.craftions.pet.Pet;
import org.bukkit.entity.Creature;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wolf;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.List;

public class MoveEvent implements Listener {


    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        Player player = (Player) event.getPlayer();
        if (Main.pets.containsKey(player.getName())) {
            new Pet().followPlayer((Creature) Main.pets.get(player.getName()), player, 1.6);
        }if (Main.wolfs.containsKey(player.getName())) {
            new Pet().followPlayer(Main.wolfs.get(player.getName()), player, 1.6);
        }if (Main.pig.containsKey(player.getName())) {
            new Pet().followPlayer(Main.pig.get(player.getName()), player, 1.6);
        }if (Main.bee.containsKey(player.getName())) {
            new Pet().followPlayer(Main.bee.get(player.getName()), player, 1.6);
        }if (Main.piglin.containsKey(player.getName())) {
            new Pet().followPlayer(Main.piglin.get(player.getName()), player, 0.8);
        }if (Main.zoglin.containsKey(player.getName())) {
            new Pet().followPlayer(Main.zoglin.get(player.getName()), player, 1.6);
        }if (Main.hoglin.containsKey(player.getName())) {
            new Pet().followPlayer(Main.hoglin.get(player.getName()), player, 1.6);
        }if (Main.cow.containsKey(player.getName())) {
            new Pet().followPlayer(Main.cow.get(player.getName()), player, 1.6);
        }if (Main.sheep.containsKey(player.getName())) {
            new Pet().followPlayer(Main.sheep.get(player.getName()), player, 1.6);
        }if (Main.chicken.containsKey(player.getName())) {
            new Pet().followPlayer(Main.chicken.get(player.getName()), player, 1.6);
        }




    }
}
