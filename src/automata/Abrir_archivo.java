/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automata;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Abrir_archivo {

    private String texto = "";

    /**
     * Metodo para leer un archivo recibe una direccion de un archivo Guarda
     * cada linea de texto en una cadena.
     *
     * @param direccion
     */
    public void leerArchivo(String direccion) {
        try {
            String aux;
            FileReader archivos = new FileReader(direccion);
            try (BufferedReader lee = new BufferedReader(archivos)) {
                while ((aux = lee.readLine()) != null) {
                    {
                        texto += aux;
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            System.err.println("Error!!! No se ha encontrado el archivo");;
        } catch (IOException err) {
            System.err.println("Error en la lectura del archivo");;
        }
    }

    /**
     *Metodo para retornar la cadena de texto
     * @return
     */
    public String getTexto() {
        return texto;
    }
}
