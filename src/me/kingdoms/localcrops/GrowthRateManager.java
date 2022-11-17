package me.kingdoms.localcrops;

import org.bukkit.Material;
import org.bukkit.block.Block;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class GrowthRateManager {
    private static Map<Material, GrowthMap> maps;
    public static void initialize() {
        maps = new HashMap<>();
        maps.put(Material.WHEAT, new GrowthMap(new File(Main.dataFolderPath + "/wheat.config")));
        maps.put(Material.BEETROOT, new GrowthMap(new File(Main.dataFolderPath + "/beetroot.config")));
        maps.put(Material.CARROTS, new GrowthMap(new File(Main.dataFolderPath + "/carrots.config")));
        maps.put(Material.POTATOES, new GrowthMap(new File(Main.dataFolderPath + "/potatoes.config")));
    }

    public static double get(Block block) {
        return maps.get(block.getType()).get(block.getChunk().getX(), block.getChunk().getZ()) / 9.0;
    }
}
