package tmp;
	
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;

/*
public class Main extends Application {
	MenuPane gamemenu;
	Scene scene;
	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage stage) throws IOException {
			Pane root = new Pane();
			root.setPrefSize(1050, 700);
			
			gamemenu = new MenuPane();
			
			InputStream is = Files.newInputStream(Paths.get("image/Capture.png"));
			Image img = new Image(is);
			is.close();
			ImageView imgV = new ImageView(img);
			imgV.setFitHeight(700);
			imgV.setFitWidth(1050);
			
			root.getChildren().addAll(imgV, gamemenu);
			
			FadeTransition ft = new FadeTransition(Duration.seconds(1), gamemenu);
			
			scene = new Scene(root);
			scene.setOnKeyPressed(event ->{
				if(event.getCode() == KeyCode.ESCAPE) {
					if(!gamemenu.isVisible()) {  
						ft.setOnFinished(evt -> gamemenu.setVisible(true));
						ft.setFromValue(0);
						ft.setToValue(1);
						ft.play();
					}
					else {    
						ft.setFromValue(1);
						ft.setToValue(0);
						ft.setOnFinished(evt -> gamemenu.setVisible(false));
						ft.play();
					}
				}
			});
			
			
			stage.setScene(scene);
			stage.show();
			
			
	}
	
	
}*/
