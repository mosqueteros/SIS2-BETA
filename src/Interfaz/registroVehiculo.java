
package Interfaz;

import Administrador.Administrador;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import principal.PrincipalNuevo;

public class registroVehiculo{

     JFrame Frame;
     JPanel panel;
     
     JLabel nombreLabel;
     JLabel precioLabel;
     JLabel tituloLabel;
     
     JTextField nombre;
     JTextField precio;
     
     ArrayList<String> parametros;
     ArrayList<JLabel> labels;
     ArrayList<JTextField> textFields;
     
     int saltoLinea;
     int columnaUno;
     int columnaDos;
     int tamanoLabel;
     
     
     String cargo;
     String fuenteLabel;
     String fuenteTextField;
     
     JButton confirmarBoton;
     JButton cancelarBoton;
    public static void main(String [] args)throws Exception{
       registroVehiculo v = new registroVehiculo("");
    }
    public registroVehiculo(String cargo)throws Exception{
        Frame = new JFrame();
        this.cargo = cargo;
        
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame.setResizable(false);
        Frame.setLayout(null);
        
        inicializarEstandares();
        inicializarPanel();
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
       
        //inicializarBotones();
    }
    //kktsv81102
   
    public void inicializarEstandares(){
        saltoLinea = 50;
        columnaUno = 55;
        columnaDos = 150;
        fuenteLabel = "Eras Bold ITC";
        fuenteTextField = "Eras Bold ITC";
        tamanoLabel = 20;
    
    }
     public void inicializarLabels(){
        tituloLabel = new JLabel("REGISTRAR VEHÍCULO ");
        
        nombreLabel =       new JLabel("Nombre: ");
        precioLabel =    new JLabel("Precio: ");  
        labels =        new ArrayList<>();
        
        labels.add(nombreLabel);labels.add(precioLabel);
        
        anadirLabels();
        JLabel label = new JLabel(); 
        label.setIcon(new ImageIcon(getClass().getResource("/Imagen/InterfazMejor.jpg")));
         Frame.getContentPane().add(label);
        label.setBounds(0,0,450,500);
    }
    private void anadirLabels(){
        tituloLabel.setBounds(columnaUno,20,400,45);
         tituloLabel.setForeground(Color.LIGHT_GRAY);
        tituloLabel.setFont(new Font(fuenteLabel, 4, 30));
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
        nombre =        new JTextField();
        precio =     new JTextField();
        textFields =    new ArrayList<>();
        textFields.add(nombre);textFields.add(precio);
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
    private void inicializarPanel()throws Exception {

        panel = new JPanel();
        //JLabel label = new JLabel("HOLA");
       
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setBounds(0, 0,500, 500);
       
    
    }
    private void inicializarBotones(){
        Administrador admin = Administrador.crearAdministrador("");
        
           confirmarBoton = new JButton("Confirmar");
           confirmarBoton.setFont(new Font(fuenteLabel, 4, tamanoLabel));
           confirmarBoton.setBounds(columnaUno, 320, 150, 40);
           confirmarBoton.addActionListener(new ActionListener(){
               Validacion v = new Validacion();
               @Override
               public void actionPerformed(ActionEvent e) {
                   if(v.ApellidosValido(nombre.getText()) && (Integer.parseInt(precio.getText())>0)){
                       admin.registrarAutomovil(Float.parseFloat(precio.getText()),0, nombre.getText());
                     
                       JOptionPane.showMessageDialog(null,"Registro realizado con éxito");
                       
                       Frame.dispose();
                       PrincipalNuevo p = new PrincipalNuevo(cargo);
                       
                       
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
