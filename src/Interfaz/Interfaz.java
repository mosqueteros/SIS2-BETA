/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import javax.swing.JFrame;

/**
 *
 * @author USUARIO
 */
public class Interfaz extends JFrame{
    public static void main(String [] args){
       Interfaz interfaz = new Interfaz();
       interfaz.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       interfaz.setResizable(false);
       minePane panel = new minePane();
       interfaz.add(panel);
       interfaz.setSize(1000,600);
      // interfaz.pack();
       interfaz.setVisible(true);
    
    }
    
}
