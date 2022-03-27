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

    private String explications = null;

    /**
     * Constructor LogicalCircuit
     * @param parBeginCells ArrayList (StaticCell)
     * @param parBeginPosition ArrayList (Position)
     * @param parEndCell StaticCell
     * @param parEndPostion Position
     */
    public LogicalCircuit(ArrayList<StaticCell> parBeginCells, ArrayList<Position> parBeginPosition, StaticCell parEndCell, Position parEndPostion) {
        beginCells = parBeginCells;
        beginPosition = parBeginPosition;
        endCell = parEndCell;
        endPosition = parEndPostion;
    }

    /**
     * Method getBeginCells
     * @return ArrayList (StaticCell)
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
    public StaticCell getBeginCell(int parInd) {
        return beginCells.get(parInd);
    }

    /**
     * Method getBeginPostion
     * @return ArrayList (Position)
     * Return the position of all begin cells
     */
    public ArrayList<Position> getBeginPosition() {
        return beginPosition;
    }

    /**
     * Method getEndVar
     * @return LogicaCell
     * Return the last LogicallCell
     */
    public StaticCell getEndCell() {
        return endCell;
    }

    /**
     * Method getEndPostion
     * @return Position
     * Return the position of the end cell
     */
    public Position getEndPosition() {
        return endPosition;
    }

    /**
     * Method getStaticPosition
     * @return ArrayList (Position)
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

    /**
     * Method setExplications
     * @param parString
     * Change explications for the level's direction
     */
    public void setExplications(String parString) {
        this.explications = parString;
    }

    /**
     * Method getExplications
     * @return String
     * Return direction for the level
     */
    public String getExplications() {
        return this.explications;
    }
}
