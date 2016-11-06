
package Interfaz;

import java.util.ArrayList;

public class buscadorIDvehiculo {
    public buscadorIDvehiculo(){
        ArrayList<String>lista;
        
        lista=new ArrayList<>();
        lista.add("toyota");
        lista.add("nissan");
        lista.add("cuart");
        lista.add("acuarius");
        lista.add("hammer");
        lista.add("wwd");
        lista.add("toyota condor");
        lista.add("nissan condor");
        lista.add("playera");
        lista.add("apple");
        lista.add("manuelitoHD");
        lista.add("anaconda");
        lista.add("patiño");
        buscador busca=new buscador(lista);
    }
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
