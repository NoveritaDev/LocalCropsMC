package me.kingdoms.localcrops;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    final static String dataFolderPath = "./plugins/LocalCrops";

    @Override
    public void onEnable() {
        GrowthRateManager.initialize();
        Bukkit.getPluginManager().registerEvents(new Listeners(), this);
    }

}
