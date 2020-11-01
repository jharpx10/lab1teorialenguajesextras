/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saveLoadPackage;

import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 *
 * @author Alejandro Rios
 */
public class LocalStringFileWriter implements IFileWriter {

    @Override
    public void write(Object data, Object target) {
        BufferedWriter writer;
        try {
            writer=new BufferedWriter(new FileWriter((String)target));
            writer.write((String) data);
        } catch (Exception e) {
        }

    }

}
