package Interfaz;

import java.util.ArrayList;
import Administrador.*;
import java.awt.Color;
import javax.swing.JFrame;

public class buscadorIDvehiculo_1 {
    private JFrame frame;
    public buscadorIDvehiculo_1(String cargo){
        frame=new JFrame("registro de compra de vehiculos");
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        frame.setLayout(null);
        frame.setSize(600, 150);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        
        Administrador admin=Administrador.crearAdministrador("");
        ArrayList<String>lista=admin.getListaAutos();
        
        frame.setVisible(true);
        buscador_1 busca=new buscador_1(frame,lista,cargo);
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
