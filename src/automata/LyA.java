/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automata;

import java.util.InputMismatchException;
import java.util.Scanner;


public class LyA {

    Scanner in = new Scanner(System.in);

    private String cargarCadena() {
        String cadena;
        System.out.println("Cadena a analizar: ");
        cadena = in.next();
        return cadena;
    }

    private void cargarMenu() {
        int opcion;
        System.out.printf("Analizar una cadena=1\nSalir= 2 %n ");
        opcion = in.nextInt();
        llamaAnalizador(opcion);
    }

    /**
     * Metodo para preguntar si se analizara otra cadena de texto
     */
    public void cicloPregunta() {
        System.out.println("¿Deseas analizar otra cadena? SI=0 o NO=1?");
        int opcion = in.nextInt();
        if (opcion == 0) {
            opcion = 1;
            llamaAnalizador(opcion);
        } else {
            System.exit(0);
        }
    }

    /**
     * Metodo que hace una instancia a la clase Analizador , se encarga de
     * analizar una cadena Recibe un parametro de tipo int para elejir una
     * opcion con la palabra reservada switch
     *
     * @param opcion
     */
    public void llamaAnalizador(int opcion) {
        Analizador a = new Analizador();
        switch (opcion) {
            case 1:
                if (a.analizar(cargarCadena())) {
                    System.out.println("Cadena aceptada");
                    cicloPregunta();
                } else {
                    System.err.println("Cadena rechazada");
                    cicloPregunta();
                }
                break;
            case 2:
                System.exit(0);
                System.out.println("Has salido del sistema");
                break;
            default:
                System.out.println("Opcion invalida");
                break;

        }
    }

    /**
     * Metodo que inicializa nuestro programa.
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            LyA prueba = new LyA();
            System.out.println("Bienvenido al sistema!!!");
            prueba.cargarMenu();

        } catch (InputMismatchException e) {//Atrapa excepciones en caso de ingresar datos incorrectos
            System.err.println("Error en la entrada de datos");
        }
    }
}
