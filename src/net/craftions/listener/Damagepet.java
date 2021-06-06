package net.craftions.listener;

import net.craftions.main.Main;
import net.craftions.pet.Pet;
import org.apache.logging.log4j.core.appender.AppenderLoggingException;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class Damagepet implements Listener {


    @EventHandler
    public void onpetDamage(EntityDamageByEntityEvent event) {

        if (event.getDamager().getType() == EntityType.PLAYER) {

            if (event.getEntity().getType() == EntityType.HOGLIN || event.getEntity().getType() == EntityType.ZOGLIN || event.getEntity().getType() == EntityType.PIGLIN ||
                    event.getEntity().getType() == EntityType.BEE ||event.getEntity().getType() == EntityType.WOLF||event.getEntity().getType() == EntityType.PIG || event.getEntity().getType() == EntityType.COW
            || event.getEntity().getType() == EntityType.SHEEP || event.getEntity().getType() == EntityType.CHICKEN) {
                new Pet().removepet((Player) event.getDamager(), "none");
                event.setCancelled(true);


            }
        }
        if (event.getDamager().getType() == EntityType.HOGLIN || event.getDamager().getType() == EntityType.ZOGLIN || event.getDamager().getType() == EntityType.PIGLIN ||
                event.getDamager().getType() == EntityType.BEE ||event.getDamager().getType() == EntityType.WOLF) {

            if (event.getEntity().getType() == EntityType.PLAYER) {
                event.setCancelled(true);


            }
        }





    }
}
