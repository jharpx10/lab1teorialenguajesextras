/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saveLoadPackage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alejandro Rios
 */
public class LocalStringFileReader implements IFileReader {

    @Override
    public String read(Object target) {
        BufferedReader reader;
        String stringRead = "";
       
        try {
             
            reader = new BufferedReader(new FileReader((String) target));
            String nextRead=reader.readLine();
            while (nextRead!= null) {
                stringRead += nextRead;
                nextRead=reader.readLine();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LocalStringFileReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LocalStringFileReader.class.getName()).log(Level.SEVERE, null, ex);
        }

        return stringRead;
    }

}
