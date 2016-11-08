package Interfaz;

import java.util.ArrayList;
import Administrador.*;
import java.awt.Color;
import javax.swing.JFrame;

public class buscadorIDvehiculo {
    private JFrame frame;
    public buscadorIDvehiculo(){
        frame=new JFrame("registro de compra de vehiculo");
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        frame.setLayout(null);
        frame.setSize(1000, 600);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        
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
        buscador busca=new buscador(frame,vehiculosDisponibles);
        frame.setVisible(true);
    }
    /*    public static void main(String[] args) {
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
    }*/
    
    
}
