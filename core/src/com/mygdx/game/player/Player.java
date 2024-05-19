package com.mygdx.game.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Player {

    public Vector2 position;
    public Vector2 positionBullet;
    public Sprite sprite;
    public Sprite spriteBullet;
    public final float speedBullet = 1000;
    private final float speed = 500;
    public Sound sound;

    public Player(Texture img, Texture imgBullet, Sound sound) {
        sprite = new Sprite(img);
        spriteBullet = new Sprite(imgBullet);
//        sprite.setColor(Color.GREEN);
        position = new Vector2(Gdx.graphics.getWidth()/2, 0);
        sprite.setScale(1);
        positionBullet = new Vector2(0, 10000);
        this.sound = sound;
    }

    public void update(float delta) {

        if (Gdx.input.isKeyPressed(Input.Keys.UP) && positionBullet.y >= Gdx.graphics.getHeight()) {
            positionBullet.x = position.x;
            positionBullet.y = 0;
            this.sound.play();
        }

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) position.x -= speed * delta;
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) position.x += speed * delta;

        if (position.x <= 0) position.x = 0;
        if (position.x + sprite.getWidth() >= Gdx.graphics.getWidth()) position.x = Gdx.graphics.getWidth() - sprite.getWidth();

        positionBullet.y += delta * speedBullet;

    }

    public void drow(SpriteBatch batch) {
        update(Gdx.graphics.getDeltaTime());
        sprite.setPosition(position.x, position.y);
        sprite.draw(batch);
        spriteBullet.setPosition(positionBullet.x, positionBullet.y);
        spriteBullet.draw(batch);
    }
}
