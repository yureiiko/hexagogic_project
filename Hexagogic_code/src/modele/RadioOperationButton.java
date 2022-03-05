package modele;

import javafx.scene.control.RadioButton;

/**
 * Class RadioOperationButton extends RadioButton
 * @author FLEURY CALAIS Pierre
 */
public class RadioOperationButton extends RadioButton {
    private String name;

    /**
     * Constructor RadioOperationButton
     * @param parName String
     */
    public RadioOperationButton(String parName) {
        super(parName);
        name = parName;
    }

    /**
     * Method toString
     * @return String
     * Return the logical operation's name
     */
    public String toString() {
        return name;
    }

}
