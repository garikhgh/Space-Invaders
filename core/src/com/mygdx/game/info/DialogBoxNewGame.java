package com.mygdx.game.info;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.button.CreateDialog;
import com.mygdx.game.button.CreateButton;

public class DialogBoxNewGame {

    private boolean isClicked;

    private Stage stage;
    private Skin skin;
    private TextButton buttonPlay;
    private TextButton buttonCancel;

    public DialogBoxNewGame() {
        skin = new Skin(Gdx.files.internal("ui/metal-ui.json"));
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        buttonPlay = CreateButton.CreateNewTextButton(skin, "Play");
        buttonCancel = CreateButton.CreateNewTextButton(skin, "Cancel");

        Dialog dialog = CreateDialog.createDialog("Title", "Would you like to play", skin, buttonPlay, buttonCancel);

        stage.addActor(dialog);
        dialog.show(stage);
    }

    public boolean isClicked() {
        return CreateButton.isButtonClicked();
    }

    public void dialogDraw() {
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();

    }
    public void dialogDispose() {
        stage.dispose();
        skin.dispose();
    }
}
