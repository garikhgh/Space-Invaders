package com.mygdx.game.button;

import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class CreateDialog {
    private CreateDialog(){}

    private Dialog dialog;

    public static Dialog createDialog(String title, String text, Skin skin, Button... buttons) {
        CreateDialog createDialog = new CreateDialog(title, text, skin, buttons);
        return createDialog.getDialog();
    }


    private CreateDialog(String title, String text, Skin skin, Button... buttons) {
        dialog = new Dialog(title, skin);
        dialog.text(text);
        for (Button button: buttons) {
            dialog.button(button, true);
        }

    }

    public Dialog getDialog() {
        return dialog;
    }
}
