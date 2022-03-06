package modele;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class Constants
 * @author FLEURY CALAIS Pierre
 */
public final class Constants {

    public static String [] IMAGES = {
            "image/tuto/page1.jpg",
            "image/tuto/page2.jpg",
            "image/tuto/page3.jpg",
            "image/tuto/page4.jpg",
            "image/tuto/page5.jpg",
            "image/tuto/page6.jpg",
            "image/tuto/page7.jpg",
            "image/tuto/page8.jpg"} ;

    public static Color [] COLORS = {
            Color.BLUE,
            Color.RED
    };

    public static int high = 900;
    public static int with = 800;

    public static LogicalCircuit saveCircuit() {
        Boolean [] beginVal = {false, true};

        ArrayList<StaticCell> beginCells = new ArrayList<StaticCell>();
        for (int i=0 ; i<beginVal.length ; i++) {
            beginCells.add(new StaticCell(beginVal[i]));
        }

        Position[] tabBeginPos = {new Position(0,4), new Position(0,5)};

        ArrayList<Position> beginPos = new ArrayList<Position>(Arrays.asList(tabBeginPos));

        StaticCell endCell = new StaticCell(true);

        Position endPos = new Position(2,4);

        LogicalCircuit logicalCircuit = new LogicalCircuit(beginCells, beginPos, endCell, endPos);
        return logicalCircuit;
    }

}
