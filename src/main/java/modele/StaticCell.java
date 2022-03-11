package modele;

/**
 * Class StaticCell extends LogicalCell
 * @author FLEURY CALAIS Pierre
 */
public class StaticCell extends LogicalCell {
    private final Boolean staticVal;
    private Boolean givenVal;

    /**
     * Constructor StaticCell
     * @param parVal Boolean
     */
    public StaticCell(Boolean parVal) {
        staticVal = parVal;
    }

    /**
     * Method setGivenVal
     * @param parGivenVal Boolean
     * Change the given value
     */
    public void setGivenVal(Boolean parGivenVal) {
        givenVal = parGivenVal;
    }

    /**
     * Method getOut
     * @return Boolean
     * Return the static value
     */
    public Boolean getOut() {
        return staticVal;
    }

    /**
     * Method isGood
     * @return Boolean
     * Check if static and given values are equal
     */
    public Boolean isGood() {
        return staticVal==givenVal;
    }
}
