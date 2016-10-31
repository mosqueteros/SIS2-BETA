
package Interfaz;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.util.Date;
public class component {
    private JFrame fram;
    private JTextField TidVenta, TidEmpleado, Tci, Tmarca, TidAuto,Tapellidos,Tnombre,Tfecha;
    private JButton confirmar,impresion;
    private JLabel idEmpleado, Bnombre, idAuto, idVenta,Bapellidos,Bci,BCliente,Bfecha;
    

    public component(JFrame frame) {
        fram = frame;
        editor();
        Tfecha.setText(getFechaActual()+"            "+getHoraActual()+" horas");
    }
    public String getFechaActual() {
        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");
        return formateador.format(ahora);
    }
    public String getHoraActual() {
        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("hh:mm:ss");
        return formateador.format(ahora);
    }
    private void editor() {
        fram.setSize(500, 300);
        TidVenta = new JTextField();
        TidEmpleado = new JTextField();
        TidAuto = new JTextField();
        Tmarca = new JTextField();
        Tapellidos = new JTextField();
        Tnombre = new JTextField();
        Tci = new JTextField();
        Tfecha=new JTextField();
        
        
        //textfields
        impresion=new JButton();
        impresion.setFont(new Font("Arial", 4,15));
        impresion.setText("imprimir");
        impresion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BimpresionActionPerformed(evt);}

        });
        fram.getContentPane().add(impresion);
        impresion.setBounds(600, 500, 120,50);
        
        confirmar = new JButton();
        confirmar.setFont(new Font("Arial", 4,15));
        confirmar.setText("registrar");
        confirmar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BconfirmaActionPerformed(evt);}
        });
        fram.getContentPane().add(confirmar);
        confirmar.setBounds(400, 500, 120,50);
        
        BCliente=new JLabel();
        BCliente.setFont(new Font("Arial", 4, 20));
        BCliente.setText("DATOS DE LA VENTA POR CONTADO");
        BCliente.setBounds(300, 5,400, 30);
        fram.getContentPane().add(BCliente);
        
        idVenta = new JLabel();
        idVenta.setFont(new Font("Arial",4, 15));
        idVenta.setText("ID.venta:");
        fram.getContentPane().add(idVenta);
        idVenta.setBounds(5, 100,  100, 20);
        idEmpleado = new JLabel();
        idEmpleado.setFont(new Font("Arial",4,15));
        idEmpleado.setText("ID.empleado:");
        fram.getContentPane().add(idEmpleado);
        idEmpleado.setBounds(5, 150, 100, 20);
        idAuto = new JLabel();
        idAuto.setFont(new Font("Arial", 4, 15));
        idAuto.setText("ID.Auto:");
        idAuto.setBounds(5, 200, 50, 20);
        fram.getContentPane().add(idAuto);
        
        Bnombre = new JLabel();
        Bnombre.setFont(new Font("Arial", 4, 15));
        Bnombre.setText("Nombre:");
        fram.getContentPane().add(Bnombre);
        Bnombre.setBounds(5, 250, 100, 20);
        Bapellidos = new JLabel();
        Bapellidos.setFont(new Font("Arial", 4, 15));
        Bapellidos.setText("Apellidos:");
        fram.getContentPane().add(Bapellidos);
        Bapellidos.setBounds(5, 300, 100, 20);
        Bci = new JLabel();
        Bci.setFont(new Font("Arial", 4, 15));
        Bci.setText("CI:");
        fram.getContentPane().add(Bci);
        Bci.setBounds(5, 350, 100, 20);
        Bfecha= new JLabel();
        Bfecha.setFont(new Font("Arial", 4, 15));
        Bfecha.setText("Fecha:");
        fram.getContentPane().add(Bfecha);
        Bfecha.setBounds(5, 400, 100, 20);
        
        
        fram.getContentPane().add(TidAuto);
        TidAuto.setFont(new Font("Arial", 4, 15));
        TidAuto.setEnabled(false);
        TidAuto.setBounds(100, 200, 300, 30);
        fram.getContentPane().add(Tmarca);
        Tmarca.setFont(new Font("Arial", 4, 15));
        Tmarca.setBounds(100, 250, 300, 30);
        fram.getContentPane().add(Tci);
        Tci.setFont(new Font("Arial", 4, 15));
        Tci.setBounds(100, 350,300, 30);
        fram.getContentPane().add(Tapellidos);
        Tapellidos.setFont(new Font("Arial", 4, 15));
        Tapellidos.setBounds(100, 300, 300, 30);
        fram.getContentPane().add(Tnombre);
        Tnombre.setFont(new Font("Arial", 4, 15));
        Tnombre.setBounds(100, 250,300, 30);
        fram.getContentPane().add(TidEmpleado);
        TidEmpleado.setFont(new Font("Arial", 4, 15));
        TidEmpleado.setBounds(100, 150, 300, 30);
        fram.getContentPane().add(TidVenta);
        TidVenta.setFont(new Font("Arial", 4, 15));
        TidVenta.setBounds(100, 100, 300, 30);
        TidVenta.setEnabled(false);
        fram.getContentPane().add(Tfecha);
        Tfecha.setFont(new Font("Arial", 4, 15));
        Tfecha.setEnabled(false);
        Tfecha.setBounds(100, 400, 300, 30);
        
        fram.pack();
    }
    private void BconfirmaActionPerformed(ActionEvent evt) {
      //en esta parte se conecta la base de datos
      //
    }
    
     private void BimpresionActionPerformed(ActionEvent evt) {
     //en esta parte manda a la impresion obteniendo los datos 
     //es otra tarea por asignar
     }
}

