package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.player.Alien;
import com.mygdx.game.player.Player;
import com.mygdx.game.utils.TextureUtils;

public class SpaceInvaders extends ApplicationAdapter {

    int numWithAliens = 11;
    int numHeightAliens = 5;
    int spacingAliens = 48;

    int minXAlien;
    int minYAlien;
    int maxXAlien;
    int maxYAlien;

    int directionAliens = 1;
    int speedAliens = 200;

    int amountOfAliveAliens = 0;
    SpriteBatch batch;
    Texture img;
    Texture imgBullet;
    Texture alien;
    Player player;
    Alien[] alienList;

    Vector2 offsetAliens = new Vector2();

    @Override
    public void create() {
        batch = new SpriteBatch();
        img = TextureUtils.readRocket("rocket.png", 75, 75);
        imgBullet = TextureUtils.readRocket("bullet.png", 75, 75);
        alien = TextureUtils.readRocket("alien.png", 48, 48);
        player = new Player(img, imgBullet);
        alienList = new Alien[numWithAliens * numHeightAliens];
        int pos = 0;
        for (int i = 0; i < numHeightAliens; i++) {
            for (int j = 0; j < numWithAliens; j++) {

                Vector2 position = new Vector2(j * spacingAliens, i * spacingAliens);
                position.x += (float) Gdx.graphics.getWidth() / 2;
                position.y += Gdx.graphics.getHeight();
                position.x -= ((float) numWithAliens / 2) * spacingAliens;
                position.y -= numHeightAliens * spacingAliens;
                alienList[pos] = new Alien(position, alien);
                pos++;
            }
        }
    }

    @Override
    public void render() {
        float deltaTime = Gdx.graphics.getDeltaTime();
        ScreenUtils.clear(1, 1, 1, 1);
        batch.begin();
        player.drow(batch);

        for (Alien value : alienList) {
            if (value.alive) {

                if (player.spriteBullet.getBoundingRectangle().overlaps(value.sprite.getBoundingRectangle())) {
                    player.positionBullet.y = 1000;
                    value.alive = false;
                    break;
                }
            }

        }
        minXAlien = 10000;
        minYAlien = 10000;
        maxXAlien = 0;
        maxYAlien = 0;
        for (int i = 0; i < alienList.length; i++) {

            if (alienList[i].alive) {
                int indexX = i % numWithAliens;
                int indexY = i % numHeightAliens;

                if (indexX > maxXAlien) maxXAlien = indexX;
                if (indexX < minXAlien) minXAlien = indexX;
                if (indexY > maxYAlien) maxYAlien = indexY;
                if (indexY < minYAlien) minYAlien = indexY;
                amountOfAliveAliens++;
            }

        }
        if (amountOfAliveAliens == 0) {
            for (Alien value : alienList) {
                value.alive = true;
            }
            offsetAliens = new Vector2(0, 0);
        }
        offsetAliens.x += directionAliens * deltaTime * speedAliens;

        if (alienList[maxXAlien].position.x >= Gdx.graphics.getWidth() - alienList[maxXAlien].sprite.getWidth()) {
            directionAliens = -1;
            offsetAliens.y -= alienList[0].sprite.getHeight() * 0.2f;
            speedAliens += 10;

        }
        if (alienList[minXAlien].position.x <= 0) {
            directionAliens = 1;
            offsetAliens.y -= alienList[0].sprite.getHeight() * 0.2f;
            speedAliens += 10;
        }

        for (Alien alien : alienList) {
            alien.position = new Vector2(alien.initialPosition.x + offsetAliens.x, alien.initialPosition.y + offsetAliens.y);
            if (alien.alive) {
                alien.draw(batch);
                if (alien.sprite.getBoundingRectangle().overlaps(player.sprite.getBoundingRectangle())) {
                    Gdx.app.exit();
                }
            }
        }
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
    }


}
