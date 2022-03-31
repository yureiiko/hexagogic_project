package sample;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import modele.Constants;
import modele.LogicalCircuit;
import modele.StaticCell;

/**
 * @author BONIFACIO TimothÃ©
 * Class LevelRead
 */
public class LevelRead {

    private ReadWrite writeRead = new ReadWrite();
    private File file = new File("file_level.ser");
    private ArrayList <LogicalCircuit> listLevel = new ArrayList<LogicalCircuit>();

    /**
     * Constructor LevelRead
     */
    public LevelRead(){
        //file = new File("file_level.ser");
        this.createFile();
    }

    /**
     * Method size
     * @return int
     * Return the size of the list of level
     */
    public int size() {
        return listLevel.size();
    }

    /**
     * Method addLevel
     * @param level LogicalCircuit
     */
    public void addLevel(LogicalCircuit level) {
        ArrayList <LogicalCircuit> listLevel2 = (ArrayList<LogicalCircuit>) writeRead.reading(file);
        System.out.println("LR : "+listLevel2.size());
        listLevel2.add(level);
        System.out.println("LR : "+listLevel2.size());
        listLevel = listLevel2;
        System.out.println("LR : "+listLevel.size());
        this.createFile();
    }

    /**
     * Method getLevel
     * @param numLevel int
     * @return LogicalCircuit
     */
    public LogicalCircuit getLevel(int numLevel) {
        if (numLevel >= listLevel.size()) {
            return Constants.saveCircuit();
        }else {
            return listLevel.get(numLevel-1);
        }
    }

    /**
     *  Method createFile
     */
    public void createFile() {
        //file.delete();
        if (file.length()==0){
            try {
                file.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        writeRead.writing(file, listLevel);
    }
}
