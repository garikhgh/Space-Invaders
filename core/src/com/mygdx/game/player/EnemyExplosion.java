package com.mygdx.game.player;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class EnemyExplosion {
    public Sprite sprite;

    public EnemyExplosion(Texture img) {
        this.sprite = new Sprite(img);
    }
    public void draw(SpriteBatch batch, Vector2 position) {
        this.sprite.setPosition(position.x, position.y);
        this.sprite.draw(batch);
    }
}
