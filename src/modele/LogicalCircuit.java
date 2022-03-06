package modele;

import java.util.ArrayList;

/**
 * @author FLEURY CALAIS Pierre
 * Class LogicalCircuit
 */
public class LogicalCircuit {

    private ArrayList<StaticCell> beginCells = new ArrayList<StaticCell>();
    private ArrayList<Position> beginPosition = new ArrayList<Position>();

    private StaticCell endCell;
    private Position endPosition;

    /**
     * Constructor LogicalCircuit
     * @param parBeginCells [] StaticCell
     * @param parEndVar StaticCell
     */
    public LogicalCircuit(ArrayList<StaticCell> parBeginCells , StaticCell parEndVar) {
        /*for (int i=0 ; i<parBeginCells.size() ; i++) {
            beginCells.add(parBeginCells.get(i));
        }*/
        beginCells = parBeginCells;
        endCell = parEndVar;
    }

    /**
     * Constructor LogicalCircuit
     * @param parBeginCells ArrayList<StaticCell>
     * @param parBeginPosition ArrayList<Position>
     * @param parEndVar StaticCell
     * @param parEndPostion Position
     */
    public LogicalCircuit(ArrayList<StaticCell> parBeginCells, ArrayList<Position> parBeginPosition, StaticCell parEndVar, Position parEndPostion) {
        beginCells = parBeginCells;
        beginPosition = parBeginPosition;
        endCell = parEndVar;
        endPosition = parEndPostion;
    }

    /**
     * Method getBeginCells
     * @return ArrayList<StaticCell>
     * Return an ArrayList with all logical cells at the beginning
     */
    public ArrayList<StaticCell> getBeginCells() {
        return beginCells;
    }

    /**
     * Method getBeginCell
     * @param parInd int
     * @return LogicalCell
     * Return the begin cell with the given index
     */
    public LogicalCell getBeginCell(int parInd) {
        return beginCells.get(parInd);
    }

    /**
     * Method getEndVar
     * @return LogicaCell
     * Return the last LogicallCell
     */
    public LogicalCell getEndCell() {
        return endCell;
    }

    /**
     * Method getStaticPosition
     * @return ArrayList<Position>
     * Return an ArrayList with Position occupied by begin and en cells
     */
    public ArrayList<Position> getStaticPosition() {
        ArrayList<Position> out = new ArrayList<Position>(beginPosition);
        out.add(endPosition);
        return out;
    }

    /**
     * Method closeCircuit
     * @return boolean
     * Check if value at the end variable is what is expected
     */
    public boolean closeCircuit() {
        if (endCell.isGood()) {
            return true;
        }
        return false;
    }
}