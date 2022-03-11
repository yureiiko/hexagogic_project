package view;


import javafx.animation.FadeTransition;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import sample.Controller;

import java.io.IOException;

/**
 * Class GameMenu enxtends Parent
 * @author LEROY Camille
 */
public class MenuPane extends Parent{
	Controller controller;
	ButtonMenu play = new ButtonMenu("PLAY");
	ButtonMenu restart = new ButtonMenu("RESTART");
	ButtonMenu selectLevel = new ButtonMenu("SELECT LEVEL");
	ButtonMenu tutorial = new ButtonMenu("TUTORIAL");
	ButtonMenu nextLevel = new ButtonMenu("NEXT LEVEL");
	ButtonMenu mainMenu = new ButtonMenu("MAIN MENU");
	ButtonMenu exit = new ButtonMenu("EXIT");

	/**
	 * Contructor MenuPane
	 * @param parController Controller
	 */
	public MenuPane(Controller parController) {
		this.controller = parController;
		this.setStyle("-fx-background-color: black;");
		
		Rectangle rtFondMenu = new Rectangle(1050,700);
		rtFondMenu.setFill(Color.WHITE);
		rtFondMenu.setOpacity(0.7);
		
		Rectangle [] espaces = new Rectangle[7];
		
		Rectangle espace;
		for (int i = 0 ; i < espaces.length ; i++) {
			espace = new Rectangle(10,10);
			espace.setOpacity(0);
			espaces[i] = espace;
		}
		
		Pane root = new Pane();
		root.setPrefSize(1050,700);
		
		VBox menu = new VBox();

		ButtonMenu [] boutons = {play, restart, selectLevel, tutorial, nextLevel, mainMenu, exit};

		play.setOnMouseClicked(event -> {
			FadeTransition ft = new FadeTransition(Duration.seconds(1), this);
			ft.setFromValue(1);
			ft.setToValue(0);
			ft.setOnFinished(evt -> this.setVisible(false));
			ft.play();
			//controller.setGameStage();
			controller.setSelectionStage();
		});

		tutorial.setOnMouseClicked(event -> {
			FadeTransition ft = new FadeTransition(Duration.seconds(1), this);
			ft.setFromValue(1);
			ft.setToValue(0);
			ft.setOnFinished(evt -> this.setVisible(false));
			ft.play();
			try {
				controller.setTutoStage();
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		
		exit.setOnMouseClicked(event -> {
			FadeTransition ft = new FadeTransition(Duration.seconds(1), this);
			ft.setFromValue(1);
			ft.setToValue(0);
			ft.setOnFinished(evt -> this.setVisible(false));
			ft.play();
			System.exit(0);
		});
		
		for( int i = 0 ; i < boutons.length ; i++ ) {
			menu.getChildren().addAll(boutons[i],espaces[i]);
		}
		
		root.getChildren().addAll(rtFondMenu, menu);
		getChildren().addAll(root);
	}
}