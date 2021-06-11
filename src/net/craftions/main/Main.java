package net.craftions.main;

import net.craftions.TabCompleter.CustomHeadTab;
import net.craftions.commands.*;
import net.craftions.listener.Damagepet;
import net.craftions.listener.JoinEvent;
import net.craftions.listener.MoveEvent;
import net.craftions.listener.QuitEvent;
import net.craftions.pet.Pet;
import net.craftions.util.events.handleMenuGUIClick;
import net.craftions.util.events.handleMenuOpener;
import net.craftions.util.mainmenu.Menu;
import org.bukkit.Bukkit;
import org.bukkit.entity.*;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.HashMap;

public class Main extends JavaPlugin {


    private static Main instance;

    public static HashMap<String, Entity> pets = new HashMap<String, Entity>();
    public static HashMap<String, Wolf> wolfs = new HashMap<String, Wolf>();
    public static HashMap<String, Pig> pig = new HashMap<String, Pig>();
    public static HashMap<String, Bee> bee = new HashMap<String, Bee>();
    public static HashMap<String, Piglin> piglin = new HashMap<String, Piglin>();
    public static HashMap<String, Zoglin> zoglin = new HashMap<String, Zoglin>();
    public static HashMap<String, Hoglin> hoglin = new HashMap<String, Hoglin>();
    public static HashMap<String, Cow> cow = new HashMap<String, Cow>();
    public static HashMap<String, Sheep> sheep = new HashMap<String, Sheep>();
    public static HashMap<String, Chicken> chicken = new HashMap<String, Chicken>();

    public static Plugin plugin;




    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onEnable() {
        this.plugin = this;
        PluginManager manager = Bukkit.getPluginManager();
        File menuConf = new File("./plugins/lobby/menu.yml");
        manager.registerEvents(new Menu(), this);
        manager.registerEvents(new JoinEvent(), this);
        manager.registerEvents(new handleMenuGUIClick(), this);
        manager.registerEvents(new handleMenuOpener(), this);
        manager.registerEvents(new MoveEvent(), this);
        manager.registerEvents(new QuitEvent(), this);
        manager.registerEvents(new Damagepet(), this);
        //Commands
        getCommand("fly").setExecutor(new Fly());
        getCommand("speed").setExecutor(new Speed());
        getCommand("glow").setExecutor(new Glow());
        getCommand("customhead").setExecutor(new CustomHead());
        //TabCompleter
        getCommand("customhead").setTabCompleter(new CustomHeadTab());
        System.out.println("PERKS loaded!");

    }

    @Override
    public void onDisable() {



            for (Player p : Bukkit.getOnlinePlayers()) {
                new Pet().removepet(p, "none");
                p.kickPlayer("§c§lCraftions §7-> You have been kicked because the server was §areloaded. §7Please §arejoin§7!");
            }
            System.out.println("PERKS unloaded!");

    }


    public static Main getInstance() {
        return instance;
    }


}
