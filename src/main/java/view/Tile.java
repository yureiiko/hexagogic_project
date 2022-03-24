package view;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import modele.LogicalCell;
import modele.Position;
import sample.Controller;

/**
 * @author FLEURY CALAIS Pierre
 * Class Tile extends Polygon
 */
public class Tile extends Polygon {
    private Controller controller;
    private double [] points;
    private Position position;

    private LogicalCell logicalCell = null;

    /**
     * Constructor Tile
     * @param parController Controller
     * @param parPoints double []
     * @param parPosition Position
     * @param parColor Color
     */
    public Tile(Controller parController, double [] parPoints, Position parPosition, Color parColor) {
        super(parPoints);
        this.setFill(parColor);
        controller = parController;
        points = parPoints;
        position = parPosition;
        this.setOnMouseEntered( event -> {
            if (this.getLogicalCell()!=null) {
                if (this.getLogicalCell().getOperation()!=null) {
                    controller.showPopup(new Label(this.getLogicalCell().getOperation().toString()), event.getScreenX(), event.getSceneY());
                }
                else {
                    controller.showPopup(new Label(this.logicalCell.getOut().toString()), event.getScreenX(), event.getScreenY());
                }
            }
        });
        this.setOnMouseExited( event -> {
            controller.hidePopup();
        });
    }

    /**
     * Method setLogicalCell
     * @param parCell LogicalCell
     * Change the Tile's LogicalCell
     */
    public void setLogicalCell(LogicalCell parCell) {
        logicalCell = parCell;
    }

    /**
     * Method getLogicalCell
     * @return LogicalCell
     * Return the Tile's LogicalCell
     */
    public LogicalCell getLogicalCell() {
        return logicalCell;
    }

    /**
     * Method getPosition
     * @return Position
     * Return the Tile's Position
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Method getAllPoints
     * @return double []
     * Return all angle points of the hexagonal tile
     */
    public double [] getAllPoints() {
        return points;
    }

    /**
     * Method getStringValue
     * @return String
     */
    public String getStringValue() {
        if (logicalCell.getExpectedVal() != null) {
            return logicalCell.getExpectedVal().toString();
        }
        return logicalCell.getOut().toString();
    }
}
