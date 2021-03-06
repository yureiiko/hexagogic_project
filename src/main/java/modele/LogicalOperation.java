package modele;

import javafx.scene.paint.Color;

/**
 * Class LogicalOperation
 * @author Hexagoteam
 */
public class LogicalOperation {
    public String name;

    /**
     * Constructor LogicalOperation
     * @param parName String
     */
    public LogicalOperation(String parName) {
        name = parName;
    }

    /**
     * Method execute
     * @param v1 Boolean
     * @param v2 Boolean
     * @return boolean
     * Execute the logical operation between both boolean variables
     */
    public boolean execute(Boolean v1, Boolean v2) {
        switch (name) {
            case "AND" : return v1 && v2;
            case "NAND" : return !(v1 && v2);
            case "OR" : return v1 || v2;
            case "NOR" : return !(v1 || v2);
            case "XOR" : return v1 ^ v2;
            case "NXOR" : return !(v1 ^ v2);
            default: return v1;
        }
    }

    /**
     * Method getColor
     * @return Color
     * All operations are associate with a color
     */
    public Color getColor() {
        switch (name) {
            case "AND" : return Color.GREEN;
            case "NAND" : return Color.LIGHTGREEN;
            case "OR" : return Color.RED;
            case "NOR" : return Color.INDIANRED;
            case "XOR" : return Color.SKYBLUE;
            case "NXOR" : return Color.CYAN;
            default: return Color.WHITE;
        }
    }

    /**
     * Method toString
     * @return String
     * return the logical operation's name
     */
    public String toString() {
        return name;
    }

}
