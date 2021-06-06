package net.craftions.listener;

import net.craftions.main.Main;
import net.craftions.pet.Pet;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wolf;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.List;

public class QuitEvent implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent event){
        Player player = (Player)event.getPlayer();
        if(Main.pets.containsKey(player.getName())){
            Main.pets.get(player.getName()).remove();

        }
        new Pet().removepet(player, "none");



    }
}
