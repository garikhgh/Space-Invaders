package com.mygdx.game.player;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Alien {
    public Vector2 position;
    public Vector2 initialPosition;
    public Sprite sprite;
    public Boolean alive = true;
    public Sound sound;

    public Alien(Vector2 position, Texture img, Sound sound) {
        this.initialPosition = position;
        this.position = position;
        this.sprite = new Sprite(img);
        this.sound = sound;
    }
    public void draw(SpriteBatch batch) {
        sprite.setPosition(position.x, position.y);
        sprite.draw(batch);
    }
}
