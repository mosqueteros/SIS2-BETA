
package Interfaz;
import java.awt.Color;
import javax.swing.JFrame;
public class vendedorVehiculo {
    private JFrame frame;
    private component componentes;
    public vendedorVehiculo(String da) {
        frame=new JFrame("registro de compra de vehiculo");
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        frame.setLayout(null);
        frame.setSize(1000, 600);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        component p=new component(frame,da);
        System.out.println("entro");
    }
}
