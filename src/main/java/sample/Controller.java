package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.*;

import modele.*;
import view.Tile;
import view.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * class Controller extends Application
 * @author FLEURY CALAIS Pierre
 */
public class Controller extends Application {
    int c=0; //unknow fonction
    private Stage mainStage = new Stage();
    private GameScene gameScene;

    private LevelRead allLevel = new LevelRead();
    private int chozenLevel;

    private Popup popup = new Popup();

    /**
     * Method getMainStage
     * @return Stage
     * Return the current stage
     */
    public Stage getMainStage() {
        return mainStage;
    }

    /**
     * Method static main
     * @param args String []
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane gamePane = new BorderPane();
        gameScene = new GameScene(this, gamePane,900, 800);
        this.setMenuStage();
    }

    /**
     * Method setMenuStage throws Exception
     * The current stage change for the MenuStage
     */
    public void setMenuStage() {
        mainStage.setTitle("Hexagogic");

        MenuPane menuPane = new MenuPane(this);
        MenuScene menuScene = new MenuScene(this, menuPane, Constants.high, Constants.with);

        mainStage.setScene(menuScene);
        mainStage.show();
    }

    /**
     * Method setSelectionStage
     * Display a panel to select the level
     */
    public void setSelectionStage() {
        SelectionPane selectionPane = new SelectionPane(this, allLevel.size());
        Scene selectionScene = new Scene(selectionPane, Constants.high, Constants.with);

        mainStage.setScene(selectionScene);
    }

    /**
     * Method setChozenLevel
     * @param parId int
     * Set the number of the level chozen by the player
     */
    public void setChozenLevel(int parId) {
        chozenLevel = parId;
    }

    /**
     * Method getChozenLevel
     * @return LogicalCircuit
     * Return the circuit with the number chozen by the player
     */
    public LogicalCircuit getChozenLevel() {
        return allLevel.getLevel(chozenLevel);
    }

    /**
     * Method setGameStage
     * The current stage change for the GameStage
     */
    public void setGameStage() {
        mainStage.setScene(gameScene);
        mainStage.show();
    }

    /**
     * Method setNewTile
     * @param parTile Tile
     * @param forbidden ArrayList (Position)
     * Set a new Tile in the GridGroup
     */
    public void setNewTile(Tile parTile, ArrayList <Position> forbidden) {
        Boolean allowed = true;
        Iterator iter = forbidden.iterator();
        while (iter.hasNext()) {
            if (iter.next().equals(parTile.getPosition())) {
                allowed = false;
            }
        }
        if (allowed!=false) {
            String ope = gameScene.getTileOperationPane().getSelectedOperation();
            if (ope=="ERASE") {
                parTile.setLogicalCell(null);
                System.exit(0);
            }
            LogicalCell newCell = new LogicalCell();
            newCell.setOperation(ope);
            ArrayList <Tile> bef = gameScene.getGridGroup().getBefore(parTile);
            iter = bef.iterator();
            int count = 0;
            while (iter.hasNext()) {
                Tile actu = (Tile) iter.next();
                if (actu.getLogicalCell() != null) {
                    if (count==0) {
                        actu.getLogicalCell().setNextCell1(newCell);
                        newCell.setInput1(actu.getLogicalCell().getOut());
                        count++;
                    }
                    else {
                        actu.getLogicalCell().setNextCell2(newCell);
                        newCell.setInput2(actu.getLogicalCell().getOut());
                    }
                }
            }
            ArrayList <Tile> aft = gameScene.getGridGroup().getAfter(parTile);
            iter = aft.iterator();
            count = 0;
            while (iter.hasNext()) {
                Tile actu = (Tile) iter.next();
                if (actu.getLogicalCell() != null) {
                    if (actu.getLogicalCell() instanceof StaticCell) {
                        ((StaticCell) actu.getLogicalCell()).setGivenVal(newCell.getOut());
                    }
                    if (count==0) {
                        actu.getLogicalCell().setInput1(newCell.getOut());
                    }
                    else {
                        actu.getLogicalCell().setInput2(newCell.getOut());
                    }
                }
            }
            parTile.setFill(newCell.getOperation().getColor());
            parTile.setLogicalCell(newCell);
        }
        System.out.println(gameScene.getGridGroup().closeCircuit());
        if (gameScene.getGridGroup().closeCircuit()) {
            Font font = new Font(25.0);
            Label win = new Label("YOU WIN");
            win.setFont(font);
            win.setTextFill(Color.RED);
            showPopup(win, mainStage.getX()+(mainStage.getX()/2), mainStage.getY()+(mainStage.getY()/2));
            this.setSelectionStage();
            hidePopup();
        }
    }

    /**
     * Method showPopup
     * @param parLabel Label
     * @param x double
     * @param y double
     * Show a Popup with the Label in parameter and the x, y position
     */
    public void showPopup(Label parLabel, double x, double y) {
        parLabel.setStyle("-fx-background-color: grey;");
        popup = new Popup();
        popup.getContent().add(parLabel);
        popup.show(mainStage, x, y);
    }

    /**
     * Method hidePopup
     * Hide the Popup
     */
    public void hidePopup() {
        popup.hide();
    }

    /**
     * Method setTutoStage
     * @throws IOException
     * The current stage is now the TutoStage
     */
    public void setTutoStage() throws IOException {
        TutoPane tutoPane = new TutoPane(this);
        TutoScene tutoScene = new TutoScene(this, tutoPane, 900, 800);
        mainStage.setScene(tutoScene);
        mainStage.show();
    }

    /**
     * Method update
     * Update the interface
     */
    public void update() {
        mainStage.show();
    }
}