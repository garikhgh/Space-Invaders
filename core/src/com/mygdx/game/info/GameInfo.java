package com.mygdx.game.info;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.constants.Constants;

public class GameInfo {

    Integer explodedEnemyCount;
    Label explodedEnemy;
    Label stageLevel;
    Label worldLabel;
    Label killedEnemy;



    private Viewport viewport;
    public Stage stage;

    public GameInfo(SpriteBatch spriteBatch) {
        viewport = new FillViewport(Constants.V_WIDTH, Constants.V_HEIGHT);
        stage = new Stage(viewport, spriteBatch);
        Table generalInfo = new Table();
        generalInfo.top();
        generalInfo.setFillParent(true);

        worldLabel = new Label("World", new Label.LabelStyle(new BitmapFont(), Color.BLACK));
        killedEnemy = new Label("Killed Enemy", new Label.LabelStyle(new BitmapFont(), Color.BLACK));
        explodedEnemy = new Label(String.format("%03d", explodedEnemyCount), new Label.LabelStyle(new BitmapFont(), Color.BLACK));
        stageLevel = new Label("1-1", new Label.LabelStyle(new BitmapFont(), Color.BLACK));

        generalInfo.add(worldLabel).expandX().padTop(10);
        generalInfo.add(killedEnemy).expandX().padTop(10);
        generalInfo.row();
        generalInfo.add(stageLevel).expandX().padTop(10);
        generalInfo.add(explodedEnemy).expandX().padTop(10);
        stage.addActor(generalInfo);
    }
}
