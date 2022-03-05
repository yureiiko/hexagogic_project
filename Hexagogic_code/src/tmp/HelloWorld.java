package tmp;

import java.lang.Math ;
import java.util.ArrayList;

import javafx.application.Application;

import javafx.scene.Group;
import javafx.scene.*;
import javafx.scene.canvas.*;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

public class HelloWorld extends Application {

    int hauteur = 1440 ;
    int largeur = 2560 ;

    int tailleX = largeur/2;
    int tailleY = hauteur/2 ;

    int rayonHexa = 30 ;
    int nombreLigne = (int) Math.round(tailleX/(rayonHexa*Math.sqrt(3)))-1 ;
    int nombreCol = (int) Math.round(tailleY/60)-1 ;

    @Override public void start(Stage stage) {
        System.out.println(nombreLigne);
        System.out.println(nombreCol);
        Group root = new Group() ;
        Scene scene = new Scene(root,tailleX,tailleY,Color.BLACK);

        final Canvas canvas = new Canvas(tailleX,tailleY);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.setFill(Color.BLUE);
        for(int i = 1; i <= nombreCol ; i++) {
            double[][] coordsHexa = coordsHexa(-20,(Math.sqrt(3)*rayonHexa+(2*rayonHexa-Math.sqrt(3)*rayonHexa))*i-30,nombreLigne) ;
            for(int j = 0;j < nombreLigne;j++) {
                /*double[][]*/ double [] coordsPoint = coordsPoint(coordsHexa[0][j],coordsHexa[1][j]) ;
                Polygon polygon = new Polygon(coordsPoint);

                //gc.fillPolygon(coordsPoint[0],coordsPoint[1],6);
            }
        }
        root.getChildren().add(canvas);

        stage.setTitle("Welcome to JavaFX!");
        stage.setScene(scene);
        stage.sizeToScene() ;
        stage.show();
    }

    private double[] /*double[][]*/ coordsPoint(double x, double y) {
        double[] coordX = new double[6];
        double[] coordY = new double[6];

        double [] coords = new double[12];
        int j=0;

        for(int i = 0; i < 6 ; i++) {
            coordX[i] = x + (rayonHexa*Math.cos(((Math.PI/180)*(60*i)))) ;
            coords[j]=coordX[i];
            j++;

            coordY[i] = y + (rayonHexa*Math.sin(((Math.PI/180)*(60*i)))) ;
            coords[j]=coordY[i];
            j++;
    		/*System.out.println(i+1+"-----");
    		System.out.println(coordX[i]) ;
    		System.out.println(coordY[i]) ;*/
        }

        //double[][] coords = {coordX,coordY};
        return coords ;
    }

    private double[][] coordsHexa(double departX,double departY, int nombreHexa){
        double[] coordX = new double[nombreHexa];
        double[] coordY = new double[nombreHexa];
        double pointX = departX ;
        double pointY = departY ;

        for(int i = 0; i < nombreHexa ; i++) {
            switch(i%2) {
                case(0):
                    pointX += (2*rayonHexa)*Math.cos(((Math.PI/180)*30)) ;
                    pointY += (2*rayonHexa)*Math.sin(((Math.PI/180)*30)) ;
                    coordX[i] = pointX ;
                    coordY[i] = pointY ;
                    break ;
                case(1):
                    pointX += (2*rayonHexa)*Math.cos(((Math.PI/180)*-30)) ;
                    pointY += (2*rayonHexa)*Math.sin(((Math.PI/180)*-30)) ;
                    coordX[i] = pointX ;
                    coordY[i] = pointY ;
            }
    		/*System.out.println(i+1+"-----");
    		System.out.println(coordX[i]) ;
    		System.out.println(coordY[i]) ;*/
        }
        double[][] coords = {coordX,coordY};
        return coords ;
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}