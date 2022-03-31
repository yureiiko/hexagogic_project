package sample;

import modele.LogicalCircuit;
import modele.Position;
import modele.StaticCell;
import view.GridGroup;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class CreateLevel
 * @author FLEURY CALAIS Pierre
 */

/***WARNING***/ // Only modify charcters between /******/ like number true or false

public class CreateLevel {

    static public void main(String [] args) {
        LevelRead levelRead = new LevelRead();
        System.out.println(levelRead.size());

        /***Begin Cells tab***/
        Boolean [] beginVal = {true, true};
        /******/
        ArrayList<StaticCell> beginCells = new ArrayList<StaticCell>();
        for (int i=0 ; i<beginVal.length ; i++) {
            beginCells.add(new StaticCell(beginVal[i]));
        }

        /***Position of Begin Cells***/
        Position[] tabBeginPos = {new Position(0,4), new Position(0,5)};
        /******/
        ArrayList<Position> beginPos = new ArrayList<Position>(Arrays.asList(tabBeginPos));

        /***End Cells***/
        StaticCell endCell = new StaticCell(true);
        /******/

        /***Position of the End Cell***/
        Position endPos = new Position(2,4);
        /******/

        /***Direction for the level***/
        String dir = "Use only two first operation tile";
        /******/

        System.out.println("Attributs created");
        LogicalCircuit logicalCircuit = new LogicalCircuit(beginCells, beginPos, endCell, endPos);
        logicalCircuit.setExplications(dir);

        System.out.println("Level Created");
        levelRead.addLevel(logicalCircuit);
        System.out.println(levelRead.size()+"\n end");
    }

}
