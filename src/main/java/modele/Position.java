package modele;

import javafx.geometry.Pos;

/**
 * @author FLEURY CALAIS Pierre
 * Class Position
 */
public class Position {
    private int row;
    private int col;

    /**
     * Constructor Position
     * @param parRow int
     * @param parCol int
     */
    public Position(int parCol, int parRow) {
        row = parRow;
        col = parCol;
    }

    /**
     * Constructor Position
     */
    public Position() {}

    /**
     * Method getAll
     * @return int []
     * Return point coordinates
     */
    public int [] getAll() {
        return new int[]{row, col};
    }

    /**
     * Method getBefore
     * @return Position []
     * Return all point before the object in an hexagonal grid
     */
    public Position [] getBefore() {
        Position [] out = new Position[2];
        Position before1 = new Position(this.col-1, this.row-1);
        out[0] = before1;
        Position before2 = new Position(this.col-1, this.row);
        out[1] = before2;
        return out;
    }

    /**
     * Method getAfter
     * @return Position []
     * Return all point after the object in an hexagonal grid
     */
    public Position [] getAfter() {
        Position [] out = new Position[2];
        Position after1 = new Position(this.col+1, this.row-1);
        out[0] = after1;
        Position after2 = new Position(this.col+1, this.row);
        out[1] = after2;
        return out;
    }

    /**
     * Method equals
     * @param parPosition Position
     * @return boolean
     * Compare two points
     */
    public boolean equals(Position parPosition) {
        return this.getAll()[0] == parPosition.getAll()[0] && this.getAll()[1] == parPosition.getAll()[1];
    }

    /**
     * Method toString
     * @return String
     * Return coordinates in a String format
     */
    public String toString() {
        return "[" + col + ";" + row + "]";
    }

}
