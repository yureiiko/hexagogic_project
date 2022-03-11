package view;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import modele.Constants;

import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import sample.Controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Class TutoPane extends BorderPane
 * @author FLEURY CALAIS Pierre
 */
public class TutoPane extends BorderPane {
    private Controller controller;
    private ArrayList <Image> allImages = new ArrayList<Image>();
    private ImageView imageSet = new ImageView();
    private BorderPane actionPane = new BorderPane();
    private Button menu = new Button("MENU");
    private Button back = new Button("<");
    private Button next = new Button(">");

    /**
     * Constructor TutoPane
     * @param parController Controller
     * @throws IOException
     */
    public TutoPane(Controller parController) throws IOException {
        controller = parController;
        for (int i=0 ; i<Constants.IMAGES.length ; i++) {
            Image actu = new Image(new FileInputStream(Constants.IMAGES[i]));
            allImages.add(actu);
        }
        setImage(allImages.get(0));

        menu.setOnMouseClicked( event -> {
            controller.setMenuStage();
        });
        actionPane.setLeft(menu);
        back.setOnMouseClicked(event -> {
            showPrevious();
        });
        actionPane.setCenter(back);
        next.setOnMouseClicked(event -> {
            showNext();
        });
        actionPane.setRight(next);

        this.setBottom(actionPane);
        this.setStyle("-fx-background-color: black;");
    }

    /**
     * Method setImage
     * @param parImage Image
     * Change the current displayed image
     */
    public void setImage(Image parImage) {
        imageSet.setImage(parImage);
        imageSet.setFitHeight(800);
        imageSet.setFitWidth(600);
        imageSet.setPreserveRatio(true);
        this.setCenter(imageSet);
    }

    /**
     * Method showNext
     * Show the next image
     */
    public void showNext() {
        int ind = allImages.indexOf(imageSet.getImage())+1;
        if (ind < allImages.size()) {
            setImage(allImages.get(ind));
            controller.update();
        }
    }

    /**
     * Method showPrevious
     * Show the previous image
     */
    public void showPrevious() {
        int ind = allImages.indexOf(imageSet.getImage())-1;
        if (ind >= 0) {
            setImage(allImages.get(ind));
            controller.update();
        }
    }

}
