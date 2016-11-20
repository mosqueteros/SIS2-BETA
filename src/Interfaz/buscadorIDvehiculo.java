package Interfaz;

import java.util.ArrayList;
import Administrador.*;
import java.awt.Color;
import javax.swing.JFrame;

public class buscadorIDvehiculo {
    private JFrame frame;
    public buscadorIDvehiculo(String cargo){
        frame=new JFrame("REGISTRO DE VENTA AL CONTADO");
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        frame.setLayout(null);
        frame.setSize(600, 150);
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
        buscador busca=new buscador(frame,vehiculosDisponibles,cargo);
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
