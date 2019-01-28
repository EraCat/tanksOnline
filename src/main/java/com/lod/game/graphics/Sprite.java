package com.lod.game.graphics;

import com.lod.game.utils.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Sprite {
    private SpriteSheet sheet;
    private float scale;
    private BufferedImage image;

    public Sprite(SpriteSheet sheet, float scale) {
        this.scale = scale;
        this.sheet = sheet;
        image = sheet.getSprite(0);
        image = Utils.resize(this.image, (int) (image.getWidth() * scale), (int) (image.getHeight() * scale));
    }

    public void render(Graphics2D g, float x, float y) {
        g.drawImage(image, (int) (x), (int) (y), null);
    }
}