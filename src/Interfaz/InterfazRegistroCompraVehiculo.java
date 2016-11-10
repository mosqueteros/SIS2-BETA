package Interfaz;

import javax.swing.JFrame;

/**
 *
 * @author USUARIO
 */
public class InterfazRegistroCompraVehiculo extends JFrame{
    public static void main(String [] args){
       JFrame interfaz = new JFrame();
       interfaz.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       interfaz.setResizable(false);
       compraVehiculos panel = new compraVehiculos();
       interfaz.add(panel);
       interfaz.setSize(1000,600);
      // interfaz.pack();
       interfaz.setVisible(true);
    
    }
    
}
