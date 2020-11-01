/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afg2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import saveLoadPackage.LocalStringFileReader;

/**
 *
 * @author Alejandro Rios
 */
public class Main {

    public static final String SEPARADOR = ",";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

      
    
        String s = getCode("C:\\Universidad\\semestre7\\teoria\\automatas\\automataigual.csv");
        guardarTexto("C:\\Universidad\\semestre7\\teoria\\automatas\\automataigual.txt", s);
        char a = 'a';
        String av = String.valueOf(a);


    }

    public static String getCode(String path) {
        BufferedReader bufferLectura = null;
        String lleva = "";
        try {
            // Abrir el .csv en buffer de lectura
            bufferLectura = new BufferedReader(new FileReader(path));

            // Leer una linea del archivo
            String linea = bufferLectura.readLine();
           
            int j = 0;

            ArrayList<String> entradas = new ArrayList<>();

            while (linea != null) {
                // Sepapar la linea leída con el separador definido previamente
                String[] campos = linea.split(SEPARADOR);

                if (j == 0) {
                    for (String a : campos) {

                        entradas.add(a);

                    }
                    entradas.remove(0);
                    for (int i = 0; i < entradas.size(); i++) {

                        if (entradas.get(i).equals("\"")) {
                            entradas.remove(i);
                            entradas.remove(i);
                            entradas.add(i, ";");
                        }

                    }
                } else {

                    String estAc = campos[0];

                    for (int i = 1; i < campos.length; i++) {

                        if (j == 1 && i == 1) {
                            lleva += ss(estAc, entradas.get(i - 1), campos[i],
                                    lleva, true, false, true, false
                            );
                        } else if (j != 1 && i == 1) {
                            lleva = ss(estAc, entradas.get(i - 1), campos[i],
                                    lleva, false, false, true, false
                            );

                        } else if (j >= 1 && i + 1 < campos.length) {
                            lleva = ss(estAc, entradas.get(i - 1), campos[i],
                                    lleva, false, false, false, false
                            );

                        } else {
                            lleva = ss(estAc, entradas.get(i - 1), campos[i],
                                    lleva, false, true, false, true);
                        }
                        {

                        }

                    }
                }

                // Volver a leer otra línea del fichero
                linea = bufferLectura.readLine();
                j++;
            }
            lleva += "  if(estadoActual.equalsIgnoreCase(\"ERROR\") || estadoActual.equalsIgnoreCase(\"ERRORC\")){\n"
                    + "            mensaje += \"\\n\" + getErrorMistake(estadoPrevioError,String.valueOf(a), linea, n, secuencia);\n"
                    + "           }"
                    + "  \n}";

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lleva;
    }

    public static String s(String estado, String entrada, String transicion,
            String lleva, boolean inicioE, boolean finE, boolean inicioS, boolean finS) {
        System.out.println(entrada);
        String ss = lleva;
        if (inicioE) {

            ss = " for (char a : secuencia.toCharArray()) {\n " + "estadoPrevioError=estadoActual;\n"
                    + "n++;\n"
                    + "switch(estadoActual){\n";

        }
        if (inicioS) {
            ss += "case \"" + estado + "\":";
            ss += "\nswitch(a){\n";
        }

        if (entrada.equalsIgnoreCase("LETRAS")) {
            ss += "\ncase 'A':case 'B':case 'C':case 'D':case 'E':case 'F':case 'G':case 'H':case 'I':case 'J':case 'K':\n"
                    + "case 'L':case 'M':case 'N':case 'Ñ':case'O':case 'P':case 'Q':case 'R':case 'S':case 'T':case 'U':case 'V':\n"
                    + "case 'W':case 'X':case 'Y':case 'Z':case '_':case 'd':case 'j':\n"
                    + "case 'k':case 'm':case 'p':case 'ñ':case 'q':case 's':case 'v':\n"
                    + "case 'w':case 'x':case 'y': case 'z':\n";
        } else if (entrada.equalsIgnoreCase("NUMEROS")) {
            ss += "\ncase '1':\n"
                    + "                        case '2':\n"
                    + "                        case '3':\n"
                    + "                        case '4':\n"
                    + "                        case '5':\n"
                    + "                        case '6':\n"
                    + "                        case '7':\n"
                    + "                        case '8':\n"
                    + "                        case '9':\n"
                    + "                        case '0':\n";

        } else if (entrada.equalsIgnoreCase("OPERADORES")) {
            ss += "\ncase '*':\n"
                    + "                        case '/':\n"
                    + "                        case '%':\n"
                    + "                        case '^':\n"
                    + "                        case '~':\n"
                    + "                        case '*':\n";
        

        } 
        
        else {

            ss += "\n case '" + entrada + "':\n";

        }

        ss += "estadoActual=\"" + transicion + "\";";

        ss += "\n break;";

        if (finE) {

            ss += "\n"
                    + "default:\n"
                    + "                           estadoActual=\"ERROR\";\n";
            ss += "\n}\nbreak;";

        }
        
        return ss;
    }

    public static void guardarTexto(String path, String text) {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter(path);
            pw = new PrintWriter(fichero);

            pw.println(text);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Nuevamente aprovechamos el finally para 
                // asegurarnos que se cierra el fichero.
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

    }

    public static String getStringEspacioSelectError(int pos) {
        String s = "";
        for (int i = 1; i < pos; i++) {
            s += " ";
        }
        s += "^";
        return s;
    }

 
    public static String getErrorMistake(String[] context, int posicion, String secuencia) {
        String err = "\n ERROR EN LÍNEA: " + posicion + "\n";

        String estadoDeError = context[0];
        String entrada = context[1];
        String selectError = getStringEspacioSelectError(posicion);

        switch (estadoDeError) {
            case "EI":
                err += "Se espera una letra para definir y/o asignar variable  e ingresó: " + entrada + "\n";
                break;

        }
        err += secuencia;
        err += selectError;

        return err;
    }


  public static String ss(String estado, String entrada, String transicion,
            String lleva, boolean inicioE, boolean finE, boolean inicioS, boolean finS) {
        String ss = lleva;
        System.out.println(entrada);
        if (inicioE) {

            ss = " for (char a : secuencia.toCharArray()) {\n " + "estadoPrevioError=estadoActual;\n"
                    + "n++;\n";
                     ss += "if(estadoActual.equals(\"" + estado + "\")){";

        }
       else if (inicioS) {
            ss += "else if(estadoActual.equals(\"" + estado + "\")){";
           
        }

        if (entrada.equalsIgnoreCase("LETRAS")) {
            
            ss +="else if(isLetter(String.valueOf(a)))\n" +
"            {";
         
        } else if (entrada.equalsIgnoreCase("NUMEROS")) {
            ss +="else if(isNumber(String.valueOf(a)))\n" +
"            {";

        } else if (entrada.equalsIgnoreCase("OPERADORES")) {
            ss +="else if(isOperator(String.valueOf(a)))\n" +
"            {";

        }
        
        
        else {

            if(inicioS){
                ss +="if(String.valueOf(a).equals(\""+entrada+"\"))\n" +
"            {";
            }
            else{
              ss +="else if(String.valueOf(a).equals(\""+entrada+"\"))\n" +
"            {";
            }

        }

        ss += "estadoActual=\"" + transicion + "\";}\n";

       

        if (finE) {
            ss += "\nelse{\n" +
"                estadoActual=\"ERROR\";\n" +
"                }\n}";

        }

        return ss;
    }

   

   


}