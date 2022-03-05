package view;

import javafx.scene.Scene;
import javafx.scene.paint.Color;
import sample.Controller;

/**
 * Class MenuScene extends Scene
 * @author FLEURY CALAIS Pierre
 */
public class MenuScene extends Scene {
    private Controller controller;
    private MenuPane menuPane;

    /**
     * Constructor MenuScene
     * @param parController Controller
     * @param parMenuPane MenuPane
     * @param parHigh int
     * @param parWidth int
     */
    public MenuScene(Controller parController, MenuPane parMenuPane, int parHigh, int parWidth) {
        super(parMenuPane, parHigh, parWidth);
        controller = parController;
        menuPane = parMenuPane;
        this.setFill(Color.BLACK);
    }

    /**
     * Method getMenuPane
     * @return MenuPane
     * Return the menu Panel
     */
    public MenuPane getMenuPane() {
        return menuPane;
    }

}
