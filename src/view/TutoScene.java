package view;

import javafx.scene.Scene;
import javafx.scene.paint.Color;
import sample.Controller;

/**
 * Class TutoScene extends Scene
 * @author FLEURY CALAIS Pierre
 */
public class TutoScene extends Scene {
    private Controller controller ;
    private TutoPane tutoPane;

    /**
     * Constructor TutoScene
     * @param parController Controller
     * @param parPane TutoPane
     * @param parHigh int
     * @param parWidth int
     */
    public TutoScene(Controller parController, TutoPane parPane, int parHigh, int parWidth) {
        super(parPane, parHigh, parWidth, Color.BLACK);
        tutoPane = parPane;
        controller = parController;
    }

}
