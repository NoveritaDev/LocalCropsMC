package me.kingdoms.localcrops;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class GrowthMap {
    private char[][] rates;

    public GrowthMap(File file) {
        try {
            BufferedImage img = ImageIO.read(file);
            int width = img.getWidth();
            int height = img.getHeight();

            rates = new char[width][height];

            for (int x = 0; x < width; ++x) {
                for (int y = 0; y < height; ++y) {
                    Color c = new Color(img.getRGB(x,y));
                    char red_bounded = (char) (c.getRed() / 25.6);
                    rates[x][y] = red_bounded;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public char get(int x, int y) {
        if (x < 0 || x >= rates.length || y < 0 || y >= rates[0].length) {
            return 0;
        }
        return rates[x][y];
    }
}
