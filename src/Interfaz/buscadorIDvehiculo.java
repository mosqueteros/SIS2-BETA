package Interfaz;

import java.util.ArrayList;
import Administrador.*;

public class buscadorIDvehiculo {
    public buscadorIDvehiculo(){
        Administrador admin=Administrador.crearAdministrador("");
        ArrayList<String>lista=admin.getListaAutos();
        ArrayList<String> vehiculosDisponibles=new ArrayList<String>();
        int stock;
        for(String nombre: lista){
            stock=admin.getStock(nombre);
            if(stock>0){
                vehiculosDisponibles.add(nombre);
            }
        }
        buscador busca=new buscador(vehiculosDisponibles);
    }
    public static void main(String[] args) {
        Administrador admin=Administrador.crearAdministrador("");
        ArrayList<String>lista=admin.getListaAutos();
        
        ArrayList<String> vehiculosDisponibles=new ArrayList<String>();
        int stock;
        for(String nombre: lista){
            stock=admin.getStock(nombre);
            if(stock>0){
                vehiculosDisponibles.add(nombre);
            }
        }
        
        
        buscador busca=new buscador(vehiculosDisponibles);
    }
    
    
}
