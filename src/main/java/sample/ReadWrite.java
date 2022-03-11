package sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * ReadWrite class able user the reading and writing of files
 *
 * @author Professor, translate by Bonifacio Timothe
 */

public class ReadWrite {
    /**
     * Method for the reading part
     *
     * @param parFile
     * read files
     *
     * @return Object that is being read from a file or an error
     */
    public static Object reading (File parFile) {
        ObjectInputStream flux ;
        Object objetLu = null;

        // Opening of the file for reading
        try {
            flux = new ObjectInputStream(new FileInputStream (parFile));
            objetLu = (Object)flux.readObject ();
            flux.close ();
        }
        catch (ClassNotFoundException parException) {
            System.err.println (parException.toString ());
            System.exit (1);
        }
        catch (IOException parException) {
            System.err.println ("Eror from reading " + parException.toString ());
            System.exit (1);
        }
        return objetLu ;
    }

    /** Method for the writing part
     *
     * @param parFile
     * 	the file in witch we write
     * @param parObject
     * 	data that will be included in the wile
     */
    public static void writing (File parFile, Object parObject) {
        ObjectOutputStream flux = null;
        // Opening of the file for writing
        try {
            flux = new ObjectOutputStream(new FileOutputStream (parFile));
            flux.writeObject(parObject);
            flux.flush ();
            flux.close ();
        }
        catch (IOException parException) {
            System.err.println ("Error from writing\n" + parException.toString ());
            System.exit (1);
        }
    }
}
