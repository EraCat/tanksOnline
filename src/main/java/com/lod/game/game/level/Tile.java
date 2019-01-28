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

    public TileType getType() {
        return type;
    }
}
