package view;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import modele.Constants;
import sample.Controller;

import java.util.ArrayList;

/**
 * Class SelectionPane extends GridPane
 * @author FLEURY CALAIS Pierre
 */
public class SelectionPane extends GridPane {

    Controller controller;
    ArrayList<Button> listButton = new ArrayList<Button>();

    /**
     * Contructor SelectionPane
     * @param parController Controller
     * @param parNbButton int
     */
    public  SelectionPane(Controller parController, int parNbButton) {
        controller = parController;

        this.setHeight(Constants.high);
        this.setWidth(Constants.with);

        for (int i=0 ; i<=parNbButton ; i++) {
            Button newButton = new Button(String.valueOf(i));
            newButton.setPrefWidth(this.getWidth()/8);
            listButton.add(newButton);
            int l = i/8;
            this.add(newButton, i, l);
        }
    }
}
