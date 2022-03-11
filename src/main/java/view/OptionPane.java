package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import sample.Controller;

/**
 * Class MenuPane extends BorderPane
 * @author FLEURY CALAIS Pierre
 */
public class OptionPane extends BorderPane {
    private Controller controller;
    private Button breakButton = new Button("Break");
    //private TextField valueDisplay = new TextField();

    /**
     * Constructor MenuPane
     * @param parController Controller
     */
    public OptionPane(Controller parController) {
        controller = parController;
        breakButton.setOnMouseClicked( event -> {
            controller.setMenuStage();
        });
        this.setRight(breakButton);
        //valueDisplay.setEditable(false);
        //this.setLeft(valueDisplay);
    }

    /*public void displayValue(String parString) {
        valueDisplay.setText(parString);
    }*/

}
