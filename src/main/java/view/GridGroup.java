package view;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import modele.*;
import sample.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Class GridGroup extends Group
 * @author KOSIN Alexandre
 */
public class GridGroup extends Group {
    private Controller controller;
    private LogicalCircuit logicalCircuit;
    private ArrayList<Tile> allTiles = new ArrayList<Tile>();

    private ArrayList<Position> forbidden = new ArrayList<Position>();

    private int high = 1600 ; //1440 ;
    private int width = 1700 ; //2560 ;

    private int sizeX = width /2;
    private int sizeY = high /2 ;

    private int raduisHexa = 30 ;
    private int nbRow = (int) Math.round(sizeX /(raduisHexa *Math.sqrt(3)))-1 ;
    private int nbCol = (int) Math.round(sizeY/60)-1 ;

    /**
     * Construstor GridGroup
     * @param parController Controller
     */
    public GridGroup(Controller parController) {
        super();
        controller = parController;

        for(int i = 1; i <= nbCol; i++) {
            double[][] coordsHexa = coordsHexa(-20,(Math.sqrt(3)* raduisHexa +(2* raduisHexa -Math.sqrt(3)* raduisHexa))*i-30, nbRow) ;
            for(int j = 0; j < nbRow; j++) {
                double [] coordsPoint = coordsPoint(coordsHexa[0][j],coordsHexa[1][j]) ;
                Tile tile = new Tile(controller, coordsPoint, new Position(j,i), Color.WHITE);
                allTiles.add(tile);
                tile.setOnMouseClicked( event -> {
                    System.out.println(tile.getPosition());
                    controller.setNewTile(tile, forbidden);
                });
                this.getChildren().add(tile);
            }
        }

        logicalCircuit = controller.getChozenLevel();
        this.createCircuit(logicalCircuit.getBeginCells(),
                logicalCircuit.getBeginPosition(),
                (StaticCell) logicalCircuit.getEndCell(),
                logicalCircuit.getEndPosition());
    }

    /**
     * Method coordsPoint
     * @param x double
     * @param y double
     * @return double []
     */
    private double[] coordsPoint(double x, double y) {
        double[] coordX = new double[6];
        double[] coordY = new double[6];

        double [] coords = new double[12];
        int j=0;

        for(int i = 0; i < 6 ; i++) {
            coordX[i] = x + (raduisHexa *Math.cos(((Math.PI/180)*(60*i)))) ;
            coords[j]=coordX[i];
            j++;

            coordY[i] = y + (raduisHexa *Math.sin(((Math.PI/180)*(60*i)))) ;
            coords[j]=coordY[i];
            j++;
        }

        return coords ;
    }

    /**
     * Method coordsHexa
     * @param departX double
     * @param departY double
     * @param nombreHexa int
     * @return double[][]
     */
    private double[][] coordsHexa(double departX,double departY, int nombreHexa){
        double[] coordX = new double[nombreHexa];
        double[] coordY = new double[nombreHexa];
        double pointX = departX ;
        double pointY = departY ;

        for(int i = 0; i < nombreHexa ; i++) {
            switch(i%2) {
                case(0):
                    pointX += (2* raduisHexa)*Math.cos(((Math.PI/180)*30)) ;
                    pointY += (2* raduisHexa)*Math.sin(((Math.PI/180)*30)) ;
                    coordX[i] = pointX ;
                    coordY[i] = pointY ;
                    break ;
                case(1):
                    pointX += (2* raduisHexa)*Math.cos(((Math.PI/180)*-30)) ;
                    pointY += (2* raduisHexa)*Math.sin(((Math.PI/180)*-30)) ;
                    coordX[i] = pointX ;
                    coordY[i] = pointY ;
            }
        }
        double[][] coords = {coordX,coordY};
        return coords ;
    }

    /**
     * Method createCircuit
     * @param parBeginCell ArrayList<StaticCell>
     * @param parBeginPos ArrayList<Position>
     * @param parEndCell StaticCell
     * @param parEndPos Position
     */
    public void createCircuit(ArrayList<StaticCell> parBeginCell, ArrayList<Position> parBeginPos, StaticCell parEndCell, Position parEndPos) {
        for (int i=0 ; i<parBeginCell.size() ; i++) {
            Tile beginTile = this.getTile(parBeginPos.get(i));
            beginTile.setLogicalCell(parBeginCell.get(i));
            beginTile.setFill(Color.GREY);
        }

        Tile endTile = this.getTile(parEndPos);
        endTile.setLogicalCell(parEndCell);
        endTile.setFill(Color.GREY);
    }

    /**
     * Method getTile
     * @param parPosition Position
     * @return Tile
     * Return the Tile with the given Position
     */
    public Tile getTile(Position parPosition) {
        Iterator<Tile> iter = allTiles.iterator();
        while (iter.hasNext()) {
            Tile actu = iter.next();
            if (actu.getPosition().equals(parPosition)) {
                return actu;
            }
        }
        return null;
    }

    /**
     * Method getBefore
     * @param parTile Tile
     * @return ArrayList<Tile>
     * Return all Tile before the given Tile
     */
    public ArrayList<Tile> getBefore(Tile parTile) {
        ArrayList<Tile> out = new ArrayList<Tile>();
        Position [] bef = parTile.getPosition().getBefore();
        for (int i=0 ; i<bef.length ; i++) {
            out.add(this.getTile(bef[i]));
        }
        return out;
    }

    /**
     * Method getAfter
     * @param parTile Tile
     * @return ArrayList<Tile>
     * Return all Tile after the given Tile
     */
    public ArrayList<Tile> getAfter(Tile parTile) {
        ArrayList<Tile> out = new ArrayList<Tile>();
        Position [] aft = parTile.getPosition().getAfter();
        for (int i=0 ; i<aft.length ; i++) {
            out.add(this.getTile(aft[i]));
        }
        return out;
    }

    /**
     * Method getForbiddenPos
     * @return ArrayList <Position>
     * Return Tile's Position that can't be changed. Begin and end Tile
     */
    public ArrayList<Position> getForbiddenPos() {
        //return forbidden;
        return logicalCircuit.getStaticPosition();
    }

    /**
     * Method closeCircuit
     * @return boolean
     * Check if the LogicalCircuit can close correctly
     */
    public boolean closeCircuit() {
        return logicalCircuit.closeCircuit();
    }

}
