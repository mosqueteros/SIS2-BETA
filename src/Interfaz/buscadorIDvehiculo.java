
package Interfaz;

import java.util.ArrayList;

public class buscadorIDvehiculo {

    public static void main(String[] args) {
        ArrayList<String>lista;
        
        lista=new ArrayList<>();
        lista.add("luismariano");
        lista.add("ana");
        lista.add("german");
        lista.add("juan");
        lista.add("herban");
        lista.add("luisme");
        lista.add("maria");
        lista.add("fernando");
        lista.add("rene");
        lista.add("fer");
        lista.add("jose");
        lista.add("anaconda");
        lista.add("hoelinda");
        buscador busca=new buscador(lista);
    }
    
}