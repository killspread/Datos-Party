package com.partyInterface;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class LoseStarController {

    @FXML protected Label targetText;

    /**
     * Sets the targetText label value
     * @param target the value to be set
     */
    public void initData(String target){
        this.targetText.setText(target);
    }
}
