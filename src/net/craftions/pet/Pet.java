package net.craftions.pet;

import net.craftions.main.Main;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftCreature;
import org.bukkit.entity.*;

import java.util.List;

public class Pet {


    public Pet(){

    }

    public EntityType createPet(Player player, EntityType type) {

        if (type == EntityType.WOLF) {
            Wolf wolf = (Wolf) player.getWorld().spawnEntity(player.getLocation(), type);

            wolf.setBreed(false);
            wolf.setCustomName(ChatColor.YELLOW + player.getName() + "'s Wolf");
            wolf.setCustomNameVisible(true);
            wolf.setHealth(wolf.getMaxHealth());
            wolf.setCanPickupItems(false);
            wolf.setCollarColor(DyeColor.GRAY);
            wolf.setAngry(false);
            wolf.setSilent(true);
            wolf.setCollidable(false);
            wolf.setOwner(player);
            Main.wolfs.put(player.getName(), wolf);


        }else if (type == EntityType.SHEEP) {
            Sheep sheep = (Sheep) player.getWorld().spawnEntity(player.getLocation(), type);
            sheep.setBaby();
            sheep.setBreed(false);
            sheep.setCustomName(ChatColor.YELLOW + player.getName() + "'s Sheep");
            sheep.setCustomNameVisible(true);
            sheep.setHealth(sheep.getMaxHealth());
            sheep.setPersistent(true);
            sheep.setCanPickupItems(false);
            sheep.setSilent(true);
            sheep.setFallDistance(0);
            Main.sheep.put(player.getName() ,sheep);

        }else if (type == EntityType.CHICKEN) {
            Chicken chicken = (Chicken) player.getWorld().spawnEntity(player.getLocation(), type);
            chicken.setBreed(false);
            chicken.setCustomName(ChatColor.YELLOW + player.getName() + "'s Chicken");
            chicken.setCustomNameVisible(true);
            chicken.setHealth(chicken.getMaxHealth());
            chicken.setPersistent(true);
            chicken.setCanPickupItems(false);
            chicken.setSilent(true);
            chicken.setFallDistance(0);
            Main.chicken.put(player.getName() ,chicken);

        }  else if (type == EntityType.PIG) {
            Pig pig = (Pig) player.getWorld().spawnEntity(player.getLocation(), type);
            pig.setBaby();
            pig.setBreed(false);
            pig.setCustomName(ChatColor.YELLOW + player.getName() + "'s Pig");
            pig.setCustomNameVisible(true);
            pig.setHealth(10.0);
            pig.setPersistent(true);
            pig.setCanPickupItems(false);
            pig.setSilent(true);
            pig.setFallDistance(0);
            Main.pig.put(player.getName(), pig);

        }else if (type == EntityType.COW) {
            Cow cow = (Cow) player.getWorld().spawnEntity(player.getLocation(), type);
            cow.setBaby();
            cow.setBreed(false);
            cow.setCustomName(ChatColor.YELLOW + player.getName() + "'s Cow");
            cow.setCustomNameVisible(true);
            cow.setHealth(cow.getMaxHealth());
            cow.setCanPickupItems(false);
            cow.setSilent(true);
            Main.cow.put(player.getName(), cow);

        } else if (type == EntityType.BEE) {
            Bee bee = (Bee) player.getWorld().spawnEntity(player.getLocation(), type);
            //bee.setBaby();
            bee.setBreed(false);
            bee.setCustomName(ChatColor.YELLOW + player.getName() + "'s Bee");
            bee.setCustomNameVisible(true);
            bee.setHealth(bee.getMaxHealth());
            bee.setCanPickupItems(false);
            bee.setSilent(true);
            bee.setHasNectar(true);
            Main.bee.put(player.getName(), bee);

        } else if (type == EntityType.PIGLIN) {
            Piglin piglin = (Piglin) player.getWorld().spawnEntity(player.getLocation(), type);
            //bee.setBaby();
            piglin.setBreed(false);
            piglin.setCustomName(ChatColor.YELLOW + player.getName() + "'s Piglin");
            piglin.setCustomNameVisible(true);
            piglin.setHealth(piglin.getMaxHealth());
            piglin.setCanPickupItems(false);
            piglin.setSilent(true);
            piglin.setIsAbleToHunt(false);
            piglin.setBaby();
            piglin.setImmuneToZombification(true);
            piglin.setSilent(true);

            Main.piglin.put(player.getName(), piglin);

        }else if (type == EntityType.ZOGLIN) {
            Zoglin zoglin = (Zoglin) player.getWorld().spawnEntity(player.getLocation(), type);
            //bee.setBaby();
            zoglin.setBreed(false);
            zoglin.setCustomName(ChatColor.YELLOW + player.getName() + "'s Zoglin");
            zoglin.setCustomNameVisible(true);
            zoglin.setHealth(zoglin.getMaxHealth());
            zoglin.setCanPickupItems(false);
            zoglin.setSilent(true);
            zoglin.setNoDamageTicks(0);
            zoglin.setBaby();
            zoglin.setSilent(true);
            zoglin.setTarget(null);
            Main.zoglin.put(player.getName(), zoglin);

        }else if (type == EntityType.HOGLIN) {
            Hoglin hoglin = (Hoglin) player.getWorld().spawnEntity(player.getLocation(), type);
            //bee.setBaby();
            hoglin.setBreed(false);
            hoglin.setCustomName(ChatColor.YELLOW + player.getName() + "'s Hoglin");
            hoglin.setCustomNameVisible(true);
            hoglin.setHealth(hoglin.getMaxHealth());
            hoglin.setCanPickupItems(false);
            hoglin.setSilent(true);
            hoglin.setNoDamageTicks(0);
            hoglin.setBaby();
            hoglin.setSilent(true);
            hoglin.setImmuneToZombification(true);
            hoglin.setIsAbleToBeHunted(false);
            hoglin.setTarget(null);
            Main.hoglin.put(player.getName(), hoglin);

        }else {

            Entity entity = (Entity) player.getWorld().spawnEntity(player.getLocation(), type);
            entity.setCustomName(player.getName());
            entity.setCustomNameVisible(true);
            entity.setInvulnerable(true);
            Main.pets.put(player.getName(), entity);
        }


        return type;
    }
    public void followPlayer(Creature creature,Player player,double Speed){
        Location location = player.getLocation();
        List<Entity> entities =player.getWorld().getEntities();
        for (Entity entity : entities) {

            if (entity instanceof Wolf) {
                if (Main.wolfs.get(player.getName()) == entity) {
                    if (!((Wolf) entity).isSitting()) {


                        if (location.distanceSquared(creature.getLocation()) > 100) {
                            if (!player.isOnGround()) {
                                return;
                            }
                            creature.teleport(location);
                        } else {
                            ((CraftCreature) creature).getHandle().getNavigation().a(location.getX(), location.getY(), location.getZ(), Speed);
                        }
                    }
                }

            }else if (entity instanceof Cow) {
                if (Main.cow.get(player.getName()) == entity) {

                    if (location.distanceSquared(creature.getLocation()) > 100) {
                        if (!player.isOnGround()) {
                            return;
                        }
                        creature.teleport(location);
                    } else {
                        ((CraftCreature) creature).getHandle().getNavigation().a(location.getX(), location.getY(), location.getZ(), Speed);
                    }
                }
            }else if (entity instanceof Chicken) {
                if (Main.chicken.get(player.getName()) == entity) {

                    if (location.distanceSquared(creature.getLocation()) > 100) {
                        if (!player.isOnGround()) {
                            return;
                        }
                        creature.teleport(location);
                    } else {
                        ((CraftCreature) creature).getHandle().getNavigation().a(location.getX(), location.getY(), location.getZ(), Speed);
                    }
                }

            }else if (entity instanceof Sheep) {
                if (Main.sheep.get(player.getName()) == entity) {

                    if (location.distanceSquared(creature.getLocation()) > 100) {
                        if (!player.isOnGround()) {
                            return;
                        }
                        creature.teleport(location);
                    } else {
                        ((CraftCreature) creature).getHandle().getNavigation().a(location.getX(), location.getY(), location.getZ(), Speed);
                    }
                }

            } else if (entity instanceof Pig) {
                if (Main.pig.get(player.getName()) == entity) {

                    if (location.distanceSquared(creature.getLocation()) > 100) {
                        if (!player.isOnGround()) {
                            return;
                        }
                        creature.teleport(location);
                    } else {
                        ((CraftCreature) creature).getHandle().getNavigation().a(location.getX(), location.getY(), location.getZ(), Speed);
                    }
                }

            } else if (entity instanceof Bee) {
                if (Main.bee.get(player.getName()) == entity) {
                    location.setY(location.getY() + 2);

                    if (location.distanceSquared(creature.getLocation()) > 100) {
                        if (!player.isOnGround()) {
                            return;
                        }


                        creature.teleport(location);
                    } else {
                        ((CraftCreature) creature).getHandle().getNavigation().a(location.getX(), location.getY(), location.getZ(), Speed);
                    }
                }

            }else if (entity instanceof Piglin) {
                if (Main.piglin.get(player.getName()) == entity) {

                    if (location.distanceSquared(creature.getLocation()) > 100) {
                        if (!player.isOnGround()) {
                            return;
                        }


                        creature.teleport(location);
                    } else {
                        ((CraftCreature) creature).getHandle().getNavigation().a(location.getX(), location.getY(), location.getZ(), Speed);
                    }
                }

            }else if (entity instanceof Zoglin) {
                if (Main.zoglin.get(player.getName()) == entity) {

                    if (location.distanceSquared(creature.getLocation()) > 100) {
                        if (!player.isOnGround()) {
                            return;
                        }


                        creature.teleport(location);
                    } else {
                        ((CraftCreature) creature).getHandle().getNavigation().a(location.getX(), location.getY(), location.getZ(), Speed);
                    }
                }

            }else if (entity instanceof Hoglin) {
                if (Main.hoglin.get(player.getName()) == entity) {

                    if (location.distanceSquared(creature.getLocation()) > 100) {
                        if (!player.isOnGround()) {
                            return;
                        }


                        creature.teleport(location);
                    } else {
                        ((CraftCreature) creature).getHandle().getNavigation().a(location.getX(), location.getY(), location.getZ(), Speed);
                    }
                }

            }


        }
        }




        public void removepet(Player player, String notthisentity) {
            List<Entity> entities =player.getWorld().getEntities();

            for (Entity entity : entities) {

                if (entity instanceof Pig) {
                    if (!(entity.getType().toString() == notthisentity)) {
                        if (Main.pig.get(player.getName()) == entity) {

                            entity.remove();
                        }
                    }
                }
                if (entity instanceof Cow) {
                    if (!(entity.getType().toString() == notthisentity)) {
                        if (Main.cow.get(player.getName()) == entity) {

                            entity.remove();
                        }
                    }
                }
                if (entity instanceof Wolf) {
                    if (!(entity.getType().toString() == notthisentity)) {
                    if (Main.wolfs.get(player.getName()) == entity) {

                        entity.remove();
                    }
                    }
                }
                if (entity instanceof Bee) {
                    if (!(entity.getType().toString() == notthisentity)) {
                    if (Main.bee.get(player.getName()) == entity) {

                        entity.remove();
                    }
                    }
                }
                if (entity instanceof Piglin) {
                    if (!(entity.getType().toString() == notthisentity)) {
                        if (Main.piglin.get(player.getName()) == entity) {

                            entity.remove();
                        }
                    }
                }
                if (entity instanceof Zoglin) {
                    if (!(entity.getType().toString() == notthisentity)) {
                        if (Main.zoglin.get(player.getName()) == entity) {

                            entity.remove();
                        }
                    }
                }
                if (entity instanceof Hoglin) {
                    if (!(entity.getType().toString() == notthisentity)) {
                        if (Main.hoglin.get(player.getName()) == entity) {

                            entity.remove();
                        }
                    }
                }
                if (entity instanceof Sheep) {
                    if (!(entity.getType().toString() == notthisentity)) {
                        if (Main.sheep.get(player.getName()) == entity) {

                            entity.remove();
                        }
                    }
                }
                if (entity instanceof Chicken) {
                    if (!(entity.getType().toString() == notthisentity)) {
                        if (Main.chicken.get(player.getName()) == entity) {

                            entity.remove();
                        }
                    }
                }



            }
    }





}