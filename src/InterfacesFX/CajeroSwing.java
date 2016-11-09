
package InterfacesFX;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class CajeroSwing{

     JFrame Frame;
     JPanel panel;
     
     JLabel CILabel;
     JLabel montoLabel;
     JLabel cambioLabel;
     JLabel otroLabel;
     JLabel tituloLabel;
     
     JTextField CI;
     JTextField monto;
     JTextField cambio;
     JTextField otro;
     
     ArrayList<String> parametros;
     ArrayList<JLabel> labels;
     ArrayList<JTextField> textFields;
     int saltoLinea;
     int columnaUno;
     int columnaDos;
     
     JButton confirmarBoton;
     JButton cancelarBoton;
    public static void main(String [] args)throws Exception{
        CajeroSwing cajero = new CajeroSwing();
    }
    public CajeroSwing()throws Exception{
        Frame = new JFrame();
        Frame.setSize(500,500);
        inicializarPanel();
        inicializarEstandares();
        inicializarLabels();
        inicializarTextFields();
        inicializarBotones();
        //Frame.pack();
       
        Frame.add(panel);
        Frame.setVisible(true);
        //inicializarBotones();
    }
   
    public void inicializarEstandares(){
        saltoLinea = 50;
        columnaUno = 20;
        columnaDos = 200;
    
    }
     public void inicializarLabels(){
        tituloLabel = new JLabel("CAJERO ");
        CILabel =       new JLabel("CI: ");
        montoLabel =    new JLabel("Monto: ");
        cambioLabel =   new JLabel("Cambio: ");
        otroLabel =     new JLabel("Otro: ");
        labels =        new ArrayList<>();
        labels.add(CILabel);labels.add(montoLabel);
        labels.add(cambioLabel);labels.add(otroLabel);
        anadirLabels();
    }
    private void anadirLabels(){
        tituloLabel.setBounds(columnaUno,20,200,40);
        tituloLabel.setFont(new Font("Arial", 4, 40));
        Frame.getContentPane().add(tituloLabel);
        int y = 90;
        for(int j = 0; j< labels.size(); j++){
            JLabel actual = labels.get(j);
            actual.setFont(new Font("Arial", 4, 20));
            actual.setBounds(columnaUno, y, 200, 40);
            y+=saltoLinea;
            Frame.getContentPane().add(actual);
        }
    }
    public void inicializarTextFields(){
        CI =        new JTextField();
        monto =     new JTextField();
        cambio =    new JTextField();
        otro =      new JTextField();
        textFields =    new ArrayList<>();
        textFields.add(CI);textFields.add(monto);
        textFields.add(cambio);textFields.add(otro);
        anadirTextFields();
    }
    private void anadirTextFields(){
        int y = 90;
        for(int j = 0; j< textFields.size(); j++){
            JTextField actual = textFields.get(j);
            actual.setFont(new Font("Arial", 4, 20));
            actual.setBounds(columnaDos, y, 200, 40);
            actual.setBorder(new LineBorder(Color.GRAY));
            y+=saltoLinea;
            Frame.getContentPane().add(actual);
        }
    
    }
    private void inicializarPanel()throws Exception {

        panel = new JPanel();
        //JLabel label = new JLabel("HOLA");
       
        panel.setBackground(Color.red);
        panel.setBounds(0, 0,1000, 600);
       
    
    }
    private void inicializarBotones(){
           confirmarBoton = new JButton("Confirmar");
           confirmarBoton.setBounds(columnaUno, 350, 150, 40);
           cancelarBoton = new JButton("Cancelar");
           cancelarBoton.setBounds(columnaDos, 350, 150, 40);
           Frame.getContentPane().add(confirmarBoton);
           Frame.getContentPane().add(cancelarBoton);
    }
}
