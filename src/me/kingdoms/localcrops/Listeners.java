package me.kingdoms.localcrops;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockGrowEvent;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Listeners implements Listener {
    private final Set<Material> plants;
    private final Random rng;

    public Listeners() {
        plants = new HashSet<>();
        plants.add(Material.WHEAT);
        plants.add(Material.BEETROOT);
        plants.add(Material.CARROTS);
        plants.add(Material.POTATOES);
        //plants.add(Material.SUGAR_CANE);
        //plants.add(Material.CACTUS);
        //plants.add(Material.MELON_STEM);
        //plants.add(Material.PUMPKIN_STEM);

        rng = new Random();
    }

    @EventHandler
    private void onGrowth(BlockGrowEvent event) {
        if (event.getBlock().getWorld().getBlockAt(event.getBlock().getLocation()).getLightFromSky() < 10) {
            event.setCancelled(true);
        } else {
            Block block = event.getBlock();
            if (plants.contains(block.getType())) {
                double threshold = GrowthRateManager.get(block);
                double value = rng.nextDouble();
                Bukkit.broadcastMessage(String.format("%.2f, %.2f %s", threshold,value, block.getType()));
                if (value > threshold) {
                    event.setCancelled(true);
                }
            } else {
                Bukkit.getLogger().info("Growth event for unknown block: " + block.getType().name());
            }
        }
    }
}
