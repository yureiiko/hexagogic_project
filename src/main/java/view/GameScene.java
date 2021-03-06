package view;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import sample.Controller;

/**
 * Class GameScene
 * @author FLEURY CALAIS Pierre
 */
public class GameScene extends Scene {
    private Controller controller;
    private BorderPane gamePane;
    private GridGroup gridGroup/* = new GridGroup(controller)*/;
    private OptionPane optionPane;

    /**
     * Constructor GameScene
     * @param parController Controller
     * @param parGamePane BorderPane
     * @param parHigh int
     * @param parWidth int
     */
    public GameScene(Controller parController, BorderPane parGamePane, int parHigh, int parWidth) {
        super(parGamePane, parHigh, parWidth);
        this.setFill(Color.BLACK);
        controller = parController;
        gamePane = parGamePane;
        gamePane.setStyle("-fx-background-color: black;");

        optionPane = new OptionPane(controller);
        gamePane.setBottom(optionPane);

        Pane gridPane = new Pane();
        gridGroup = new GridGroup(controller);
        gridPane.getChildren().add(gridGroup);
        gamePane.setCenter(gridPane);

        String [] opeList = {"AND", "NAND", "OR", "NOR", "XOR", "NXOR"} ;
        TileOperationPane tileOpe = new TileOperationPane(opeList, controller);
        gamePane.setRight(tileOpe);
    }

    /**
     * Method getGamePane
     * @return BorderPane
     * Return the game Panel
     */
    public BorderPane getGamePane() {
        return gamePane;
    }

    /**
     * Method getGridGroup
     * @return GridGroup
     * Return the GridGroup with the hexagonal grid
     */
    public GridGroup getGridGroup() {
        return gridGroup;
    }

    /**
     * Method getTileOperationPane
     * @return TileOperationPane
     * Return the TileOperationPane
     */
    public TileOperationPane getTileOperationPane() {
        return (TileOperationPane) gamePane.getRight();
    }

    /**
     * Method getOptionPane
     * @return OptionPane
     * Return the OptionPane at the bottom of the gamePane
     */
    public OptionPane getOptionPane() {
        return optionPane;
    }

}
