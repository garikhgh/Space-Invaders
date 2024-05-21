package com.mygdx.game.button;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class CreateButton {
    private CreateButton() {}

    private static boolean isClicked;
    private TextButton button;

    public static TextButton CreateNewTextButton(Skin skin, String buttonMessage) {
        CreateButton createButton =  new CreateButton(skin, buttonMessage);
        return createButton.getButton();
    }
    public static boolean isButtonClicked() {
        return isClicked;
    }

    private TextButton getButton() {
        return button;
    }

    private CreateButton(Skin skin, String buttonMessage) {
        button = new TextButton(buttonMessage, skin, "default");
        button.setWidth(200);
        button.setHeight(50);
        button.addListener(new CustomClickListener());
    }


    private class CustomClickListener extends ClickListener {

        @Override
        public void clicked(InputEvent event, float x, float y){
            isClicked = true;
        }
    }
}
