
package Interfaz;

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
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import principal.PrincipalNuevo;

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
     int tamanoLabel;
     
     String fuenteLabel;
     String fuenteTextField;
     
     String cargo;
     
     JButton confirmarBoton;
     JButton cancelarBoton;
    public static void main(String [] args){
        CajeroSwing cajero = new CajeroSwing("M");
    }
    public CajeroSwing(String cargo){
        Frame = new JFrame();
        this.cargo = cargo;
        
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame.setResizable(false);
        Frame.setLayout(null);
        
        inicializarEstandares();
        
        inicializarBotones();
        inicializarLabels();
        inicializarTextFields();
        
        
         Frame.pack();
        //Frame.pack();
       
        Frame.setSize(450,500);
        //Frame.add(panel);
        Frame.setLocationRelativeTo(null);
        Frame.setVisible(true);
    }
    //kktsv81102
   
    public void inicializarEstandares(){
        saltoLinea = 50;
        columnaUno = 30;
        columnaDos = 180;
        fuenteLabel = "Eras Bold ITC";
        fuenteTextField = "Eras Bold ITC";
        tamanoLabel = 20;
    
    }
     public void inicializarLabels(){
         tituloLabel = new JLabel("CAJERO ");
        
        CILabel =       new JLabel("CI: ");
        montoLabel =    new JLabel("Monto: ");  
        labels =        new ArrayList<>();
        labels.add(CILabel);labels.add(montoLabel);
        anadirLabels();
         JLabel label = new JLabel(); 
        label.setIcon(new ImageIcon(getClass().getResource("/Imagen/InterfazMejor.jpg")));
        Frame.getContentPane().add(label);
        label.setBounds(0,0,500,500);
      
        
        
    }
    private void anadirLabels(){
        tituloLabel.setBounds(columnaUno+100,20,200,40);
        tituloLabel.setForeground(Color.LIGHT_GRAY);
        tituloLabel.setFont(new Font(fuenteLabel, 4, 40));
        Frame.getContentPane().add(tituloLabel);
        int y = 130;
        for(int j = 0; j< labels.size(); j++){
            JLabel actual = labels.get(j);
            actual.setForeground(Color.LIGHT_GRAY);
            actual.setFont(new Font(fuenteLabel, 4, tamanoLabel));
            actual.setBounds(columnaUno, y, 200, 40);
            y+=saltoLinea;
            Frame.getContentPane().add(actual);
        }
    }
    public void inicializarTextFields(){
        CI =        new JTextField();
        monto =     new JTextField();
        textFields =    new ArrayList<>();
        textFields.add(CI);textFields.add(monto);
        anadirTextFields();
    }
    private void anadirTextFields(){
        int y = 130;
        for(int j = 0; j< textFields.size(); j++){
            JTextField actual = textFields.get(j);
            actual.setFont(new Font(fuenteTextField, 4, tamanoLabel));
            actual.setBounds(columnaDos, y, 200, 40);
            actual.setBorder(new LineBorder(Color.GRAY));
            y+=saltoLinea;
            Frame.getContentPane().add(actual);
        }
    
    }
    
    private void inicializarBotones(){ 
            confirmarBoton =     new JButton("Confirmar");
            confirmarBoton.setFont(new Font(fuenteLabel, 4, tamanoLabel));
            confirmarBoton.setBounds(columnaUno+20, 320, 150, 40);
            confirmarBoton.addActionListener(new ActionListener(){
               Validacion v = new Validacion();
               @Override
               public void actionPerformed(ActionEvent e) {
                   if(v.CIValido(CI.getText()) && (Integer.parseInt(monto.getText())>0)){
                       int cambio = 0;
                       if(cambio!=0){
                           
                       JOptionPane.showMessageDialog(null,"Transacción realizada con éxito \n"
                               +"Su cambio es :"+cambio+".");
                       Frame.dispose();
                        PrincipalNuevo p = new PrincipalNuevo(cargo);
                       }else{
                       JOptionPane.showMessageDialog(null,"Transacción realizada con éxito");
                       Frame.dispose();
                       PrincipalNuevo p = new PrincipalNuevo(cargo);
                       }
                       
                   }else{
                       JOptionPane.showMessageDialog(null,"Datos incorrectos, por favor, revise");
                       
                   }
               }
               
           
           });
           
           //confirmarBoton.setFocusCycleRoot(true);
           cancelarBoton = new JButton("Cancelar");
           cancelarBoton.setBounds(columnaDos+60, 320, 150, 40);
           cancelarBoton.setFont(new Font(fuenteLabel, 4, tamanoLabel));
           Frame.getContentPane().add(confirmarBoton);
           cancelarBoton.addActionListener(new ActionListener(){
               Validacion v = new Validacion();
               @Override
               public void actionPerformed(ActionEvent e) {
                   JOptionPane.showMessageDialog(null,"Cancelado");
                   Frame.dispose();
                   PrincipalNuevo p = new PrincipalNuevo(cargo);
                   
               }
               
           
           });
           Frame.getContentPane().add(cancelarBoton);
    }
}
