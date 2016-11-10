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
public class registroEmpleado{
    
    JFrame f;
    public registroEmpleado(String p){
        f=new JFrame();
       f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       f.setResizable(false);
       
       registroEmplead panel = new registroEmplead(p,f);
       f.add(panel);
       f.setSize(1000,600);
       f.setLocationRelativeTo(null);
      // interfaz.pack();
       f.setVisible(true);
    
    }
    
}
