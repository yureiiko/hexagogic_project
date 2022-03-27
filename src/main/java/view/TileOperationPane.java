package view;

import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.TilePane;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import modele.Constants;
import modele.LogicalCircuit;
import modele.LogicalOperation;
import modele.RadioOperationButton;
import sample.*;

/**
 * class TileOperationPane extends TilePane
 * @author FLEURY CALAIS Pierre
 */
public class TileOperationPane extends TilePane {
    ToggleGroup radioGroup = new ToggleGroup();
    Controller controller;

    /**
     * Constructor TileOperationPane
     * @param listOpe String []
     */
    public TileOperationPane(String [] listOpe, Controller parController) {
        super();
        controller = parController;
        for (int i=0 ; i<listOpe.length ; i++) {
            RadioOperationButton opeButton = new RadioOperationButton(listOpe[i]);
            LogicalOperation lo = new LogicalOperation(listOpe[i]);
            opeButton.setTextFill(lo.getColor());
            if (i==0) {
                opeButton.setSelected(true);
            }
            opeButton.setToggleGroup(radioGroup);
            this.getChildren().add(opeButton);
        }
        RadioButton radioButton = new RadioButton("ERASE");
        radioButton.setTextFill(Color.WHITE);
        radioButton.setToggleGroup(radioGroup);
        this.getChildren().add(radioButton);
    }

    /**
     * Method getSelectedOperation
     * @return String
     * Return the selected RadioButton in String format
     */
    public String getSelectedOperation() {
        return this.radioGroup.getSelectedToggle().toString();
    }

}
