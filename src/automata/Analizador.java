/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automata;



public class Analizador {

    private String cadena;
    private final Automata afd;
    private int simbolo_analizado;

    public Analizador() {
        simbolo_analizado = -1;
        afd= new Automata();
    }
    

    char siguiente_simbolo() throws IndexOutOfBoundsException {//Para proteger memoria y saber que ya termino 
        simbolo_analizado++;
        return cadena.charAt(simbolo_analizado);

    }

    private void error(int i) {
        switch (i) {
            case 101:System.err.println("Error!!! Simbolo o estado no declarado");
                break;
            case 102:  System.err.println("Error!!! Simbolo no declarado");
                break;
        }

    }

    public boolean analizar(String w) {
        cadena = w;
        int q = afd.getQ0();
        char s;
        int is;
        try {
            s = siguiente_simbolo();
            while (true) {
                is = afd.getAlpha().indexOf("" + s);//posicion del simbolo
                if (is == -1) {
                    error(102);
                }
                q = afd.getMte(q, is);
                System.out.printf(q+"-");
                if (q == -1) {
                    error(101);
                }
                s = siguiente_simbolo();
            }
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Fin de cadena!");
        }
        System.out.println("");
        // return afd.getF().contains("" + q);
        return afd.getF().contains(q);

    }
}
