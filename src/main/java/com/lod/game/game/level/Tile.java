package com.lod.game.game.level;

import com.lod.game.utils.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {

    private BufferedImage image;
    private TileType type;

    public Tile(BufferedImage image, int scate, TileType type) {
        this.type = type;
        this.image = Utils.resize(image, image.getWidth() * scate, image.getHeight() * scate);
    }

    public void render(Graphics2D graphics, int x, int y) {
        graphics.drawImage(image, x , y, null);
    }

    public void renderGrass(Graphics2D graphics, int x, int y) {
        if (type == TileType.GRASS) {
            for (int i = 0; i < image.getWidth(); i++) {
                for (int j = 0; j < image.getHeight(); j++) {
                    int pixel = image.getRGB(i, j);
                    if ((pixel & 0x00FFFFFF) < 100000) {
                        image.setRGB(i, j, pixel & 0x00FFFFFF);
                    }
                }
            }
        }
        graphics.drawImage(image, x , y, null);
    }

    public TileType getType() {
        return type;
    }
}
