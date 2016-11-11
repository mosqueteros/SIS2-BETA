package Interfaz;

import javax.swing.JFrame;

/**
 *
 * @author USUARIO
 */
public class InterfazRegistroCompraVehiculo {
    public InterfazRegistroCompraVehiculo(String carro,String cargo){
       JFrame interfaz = new JFrame();
       interfaz.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       interfaz.setResizable(false);
       compraVehiculos panel = new compraVehiculos(carro,cargo);
       interfaz.add(panel);
       interfaz.setSize(1000,600);
       interfaz.setLocationRelativeTo(null);
       interfaz.setVisible(true);
    
    }
    
}
