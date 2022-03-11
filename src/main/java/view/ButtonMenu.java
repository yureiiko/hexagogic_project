package view;

import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * Class ButtonMenu extends StackPane
 * @author LEROY Camille
 */
public class ButtonMenu extends StackPane{

	/**
	 * Constructor ButtonMenu
	 * @param name String
	 */
	public ButtonMenu(String name){
		Text text = new Text(name);
		text.setFont(Font.font(20));
		text.setFill(Color.BLACK);
		
		Rectangle rectangle = new Rectangle(300,30);
		rectangle.setFill(Color.RED);
		
		getChildren().addAll(rectangle, text);
		
		setOnMouseEntered(event -> {
			rectangle.setFill(Color.BLUE);
			text.setFill(Color.WHITE);
		});
		
		setOnMouseExited(event -> {
			rectangle.setFill(Color.RED);
			text.setFill(Color.BLACK);
		});
		
		this.setTranslateX(375);
		this.setTranslateY(50);
	}
}
