/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automata;

import java.util.ArrayList;
import java.util.StringTokenizer;


public final class Automata {

    private int Q;
    private String alpha;
    private int q0;
    private ArrayList<Integer> F;
    private int mte[][];

    /**
     * Constructor de la clase automata que inicia el meto analizaTexto
     */
    public Automata() {
        analizaTexto();
    }

    /**
     * Metodo que obtiene la posicion de un cambio de estado dependiendo de la
     * cadena analizada.
     *
     * @param q indica la posicion de un estado dado por un automata.
     * @param s indica la posicion del simbolo de una cadena.
     * @return mte la posicion donde se encuentra un estado dependiendo del
     * simbolo del alfabeto o retorna -1 si la posicion no se encuentra.
     */
    public int getMte(int q, int s) {
        if (q < Q && s < alpha.length()) {
            return mte[q][s];
        } else {
            return -1;
        }
    }

    /**
     *
     * @return
     */
    public int[][] getMte() {
        return mte;
    }

    /**
     *
     * @return Q
     */
    public int getQ() {
        return Q;
    }

    /**
     *
     * @return alpha
     */
    public String getAlpha() {
        return alpha;
    }

    /**
     *
     * @return q0
     */
    public int getQ0() {
        return q0;
    }

    /**
     *
     * @return F
     */
    public ArrayList<Integer> getF() {
        return F;
    }

    /**
     *
     * @param texto
     * @return
     */
    public ArrayList<Integer> analizaEstadoFinal(String texto) {
        F = new ArrayList<>();
        for (int i = 0; i < texto.length(); i++) {
            char x = texto.charAt(i);
            if (x != ',') {
                int estadof = Integer.parseInt(String.valueOf(x));
                F.add(estadof);
            }
        }
        return F;
    }

    /**
     * Metodo para llenar la matriz de estados a partir de un texto
     *
     * @param texto
     */
    public void llenaMatriz(String texto) {
        mte = new int[Q][alpha.length()];
        int cont = 0;
        for (int i = 0; i < Q; i++) {
            for (int j = 0; j < alpha.length(); j++) {
                mte[i][j] = Integer.parseInt(String.valueOf(texto.charAt(cont)));
                cont++;
            }
        }
        imprimeMatriz();
    }

    /**
     * Metodo encargado de Analizar un archivo de textos, se instancia la clase
     * abreArchivo para leer un archivo de textos para despues identificar cada
     * dato de un automata
     */
    public void analizaTexto() {
        Abrir_archivo abreArchivo = new Abrir_archivo();
        abreArchivo.leerArchivo("C:\\Users\\CECI\\Documents\\NetBeansProjects\\Practica_1\\automata.txt");//Direccion del archivo de texto
        StringTokenizer token = new StringTokenizer(abreArchivo.getTexto());//Se manda a llamar la clase StringTokeneizer para dividir un texto en tokens.
        while (token.hasMoreElements()) {
            Object nextElement = token.nextElement();//Se guarda un token en la variable nextElement de tipo Object.
            if (nextElement.equals("Alfabeto=")) {//Pregunta si el object nextElement es igual a Alfabeto=
                nextElement = token.nextElement();//si es verdad sigue al siguiente token
                alpha = String.valueOf(nextElement);//Guarda el dato en la variable alpha.
            }
            if (nextElement.equals("Q=")) {//Pregunta si el object nextElement es igual a Q=
                nextElement = token.nextElement();
                Q = Integer.parseInt(String.valueOf(nextElement));
            }
            if (nextElement.equals("Q0=")) {//Pregunta si el object nextElement es igual a Q0=
                nextElement = token.nextElement();
                q0 = Integer.parseInt(String.valueOf(nextElement));
            }
            if (nextElement.equals("F=")) {//Pregunta si el object nextElement es igual a F=
                nextElement = token.nextElement();
                String aux = String.valueOf(nextElement);
                analizaEstadoFinal(aux);

            }
            if (nextElement.equals("Matriz=")) {//Pregunta si el object nextElement es igual a Matriz=
                nextElement = token.nextElement();
                llenaMatriz(String.valueOf(nextElement));
            }
        }

    }
    /*
     *Metodo para imprimir una matriz
     */
    private void imprimeMatriz() {
        System.out.println("Matriz de estados");
        for (int i = 0; i < Q; i++) {
            for (int j = 0; j < alpha.length(); j++) {
                System.out.print(mte[i][j]);
            }
            System.out.println("");
        }
    }

}
