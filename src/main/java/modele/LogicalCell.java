package modele;

import java.util.ArrayList;

/**
 * class LogicalCell
 * @author FLEURY CALAIS Pierre
 */
public class LogicalCell {
    private LogicalOperation operation;
    private Boolean input1 = null;
    private Boolean input2 = null;
    private LogicalCell nextCell1 = null;
    private LogicalCell nextCell2 = null;

    private Boolean expectedVal = null;

    /**
     * Method setOperation
     * @param parOpeName String
     * Change the LogicalCell's operation with the operation's name
     */
    public void setOperation(String parOpeName) {
        operation = new LogicalOperation(parOpeName);
    }

    /**
     * Method setOperation
     * @param parOpe LogicalOperation
     * Change the LogicalCell's operation
     */
    public void  setOperation(LogicalOperation parOpe) {
        operation = parOpe;
    }

    /**
     * Method setInput1
     * @param parInput Boolean
     * Change the first input
     */
    public void setInput1(Boolean parInput) {
        input1 = parInput;
    }

    /**
     * Method setInput2
     * @param parInput Boolean
     * Change the second input
     */
    public void setInput2(Boolean parInput) {
        input2 = parInput;
    }

    /**
     * Method setExpectedVal
     * @param parVal Boolean
     * Change the expected value
     */
    /*public void setExpectedVal(Boolean parVal) {
        expectedVal = parVal;
    }*/

    /**
     * Method setnextCell1
     * @param parCell LogicalCell
     * Change the first next LogicalCell and set the first input of the next LogicalCell (at null if miss an input in the current LogicalCell)
     */
    public void setNextCell1(LogicalCell parCell) {
        nextCell1 = parCell;
        if (!(this.isSetInput1() && this.isSetInput2())) {
            nextCell1.setInput2(null);
        }
        if (expectedVal != null) {
            nextCell1.setInput2(operation.execute(input1, input2));
        }
    }

    /**
     * Method setNextell2
     * @param parCell LogicalCell
     * Change the second next LogicalCell and set the second input of the next LogicalCell (at null if miss an input in the current LogicalCell)
     */
    public void setNextCell2(LogicalCell parCell) {
        nextCell2 = parCell;
        if (!(this.isSetInput1() && this.isSetInput2())) {
            nextCell2.setInput2(null);
        }
        if (expectedVal != null) {
            nextCell2.setInput2(operation.execute(input1, input2));
        }
    }

    /**
     * Method isSetInput1
     * @return boolean
     * Check if there's the first input
     */
    public boolean isSetInput1() {
        return input1 != null;
    }

    /**
     * Method isSetInput2
     * @return boolean
     * Check if there's the second input
     */
    public boolean isSetInput2() {
        return input2 != null;
    }

    /**
     * Method getInput1
     * @return boolean
     * Return the first input
     */
    public Boolean getInput1() {
        return input1;
    }

    /**
     * Method getInput2
     * @return Boolean
     * Return the second input
     */
    public Boolean getInput2() {
        return input2;
    }

    /**
     * Method getExpectedVal
     * @return Boolean
     * Return the expected value
     */
    public Boolean getExpectedVal() {
        return expectedVal;
    }

    /**
     * Method getOperation
     * @return LogicalOperation
     * Return the LogicalOperation
     */
    public LogicalOperation getOperation() {
        return operation;
    }

    /**
     * Method nextCell1
     * @return LogicalCell
     * Return the first next LogicalCell
     */
    public LogicalCell nextCell1() {
        return nextCell1;
    }

    /**
     * Method nextCell2
     * @return LogicalCell
     * Return the second next LogicalCell
     */
    public LogicalCell nextCell2() {
        return nextCell2;
    }

    /**
     * Method getOut
     * @return Boolean
     * Return the LogicalCell's output, after made the logical operation with first and second input
     */
    public Boolean getOut() {
        if ((input1!=null) && (input2!=null)) {
            System.out.println("Check");
            return operation.execute(input1, input2);
        }
        else {
            return null;
        }
    }

}
