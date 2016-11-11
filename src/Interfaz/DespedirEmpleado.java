/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Administrador.Administrador;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

/**
 *
 * @author migi
 */
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
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import principal.PrincipalNuevo;

public class DespedirEmpleado{
    private static Administrador admin = Administrador.crearAdministrador("concesionario");
    protected JRootPane rootPane;
     JFrame Frame;
     JPanel panel;
     
     JLabel CILabel;
     JLabel tituloLabel;
     
     JTextField CI;
     
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
     JButton botonEliminar;
     
    public static void main(String [] args)throws Exception{
        DespedirEmpleado despido = new DespedirEmpleado("");
    }
    public DespedirEmpleado(String cargo){
        Frame = new JFrame();
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame.setSize(450,500);
        this.cargo = cargo;
        inicializarEstandares();
        inicializarBotones();
        inicializarLabels();
        inicializarTextFields();
        
        //Frame.pack();
        Frame.setResizable(false);
        Frame.add(panel);
        Frame.setLocationRelativeTo(null);
        Frame.setVisible(true);
        //inicializarBotones();
    }
    
    //kktsv81102
   
    public void inicializarEstandares(){
        saltoLinea = 50;
        columnaUno = 20;
        columnaDos = 150;
        fuenteLabel = "Eras Bold ITC";
        fuenteTextField = "Eras Bold ITC";
        tamanoLabel = 20;
    
    }
     public void inicializarLabels(){
        tituloLabel =      new JLabel("DESPEDIR");
        CILabel =           new JLabel("CI: ");
        labels =            new ArrayList<>();
        labels.add(CILabel);
        anadirLabels();
        JLabel label =      new JLabel(); 
        label.setIcon(new ImageIcon(getClass().getResource("/Imagen/InterfazMejor.jpg")));
         Frame.getContentPane().add(label);
        label.setBounds(0,0,500,500);
    }
    private void anadirLabels(){
        tituloLabel.setBounds(columnaUno+70,30,900,40);
        tituloLabel.setFont(new Font(fuenteLabel, 4, 40));
        tituloLabel.setForeground(Color.LIGHT_GRAY);
        Frame.getContentPane().add(tituloLabel);
        int y = 150;
        for(int j = 0; j< labels.size(); j++){
            JLabel actual = labels.get(j);
            actual.setForeground(Color.LIGHT_GRAY);
            actual.setFont(new Font(fuenteLabel, 4, tamanoLabel));
            actual.setBounds(columnaUno, y-5, 200, 40);
            y+=saltoLinea;
            Frame.getContentPane().add(actual);
        }
    }
    public void inicializarTextFields(){
        CI =        new JTextField();
        textFields =    new ArrayList<>();
        textFields.add(CI);
        anadirTextFields();
    }
    private void anadirTextFields(){
        int y = 150;
        for(int j = 0; j< textFields.size(); j++){
            JTextField actual = textFields.get(j);
            actual.setFont(new Font(fuenteTextField, 4 , tamanoLabel));
            actual.setBounds(columnaDos, y, 200, 30);
            actual.setBorder(new LineBorder(Color.GRAY));
            y+=saltoLinea;
            Frame.getContentPane().add(actual);
        }
    
    }
   
    private void inicializarBotones(){
           confirmarBoton = new JButton("Confirmar");
           confirmarBoton.setFont(new Font(fuenteLabel, 4, tamanoLabel));
           confirmarBoton.setBounds(columnaUno+5, 320, 150, 40);
           
           botonEliminar = new JButton("Cancelar");
           botonEliminar.setBounds(columnaDos+60, 320, 150, 40);
           botonEliminar.setFont(new Font(fuenteLabel, 4, tamanoLabel));
    
           Frame.getContentPane().add(confirmarBoton);
           Frame.getContentPane().add(botonEliminar);
    
           confirmarBoton.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                   if(!CI.getText().isEmpty()){
                      if(admin.existeEmpleado(Integer.parseInt(CI.getText()))){
                        admin.eliminacionEmpleado(Integer.parseInt(CI.getText()));
                        Frame.dispose();
                        JOptionPane.showMessageDialog(null,"El empleado con el CI: "+CI.getText()+" fue elminado con éxito.");
                        PrincipalNuevo v = new PrincipalNuevo(cargo);
                   }
                      else
                   JOptionPane.showMessageDialog(null,"No existe el empleado con el CI: "+CI.getText());
                
                   }
                }
               
           }
           );
           botonEliminar.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                   CI.setText("");
                   
                        JOptionPane.showMessageDialog(null,"LA TRANSACCION SE CANCELO");
                   Frame.dispose();
                        PrincipalNuevo v = new PrincipalNuevo(cargo);
               }
           }
           );
           
    }                             
    
}