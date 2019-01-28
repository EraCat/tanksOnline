package com.lod.game.game;

import com.lod.game.io.Input;

import java.awt.*;

public abstract class Entity {
    public final EntityType type;

    protected float x;
    protected float y;

    public Entity(EntityType type, float x, float y) {
        this.type = type;
        this.x = x;
        this.y = y;
    }

    public abstract void update(Input input);

    public abstract void render(Graphics2D graphics);
}
