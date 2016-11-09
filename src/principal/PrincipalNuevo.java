/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

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
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class PrincipalNuevo{

     JFrame Frame;
     JPanel panel;
     JPanel panelSecundario;
     
     JLabel bienvenidoLabel;
     JLabel loggeadoLabel;
     
 
     
     JTextField CI;
     JTextField monto;
     JTextField cambio;
     JTextField otro;
     
     ArrayList<String> parametros;
     ArrayList<JButton>botonesVentas;
     ArrayList<JButton>botonesRecursos;
     ArrayList<JButton>botonesCajero;
     ArrayList<JButton>botonesAdministracion;
     
     ArrayList<JTextField> textFields;
     JMenu menu;
     //Principales
     JButton ventasBoton;
     JButton recursosBoton;
     JButton cajeroBoton;
     JButton administracionBoton;
  
     //Ventas
     JButton ventaCreditoBoton;
     JButton ventaContadoBoton;
     JButton reporteBoton;
     //RecursosHumanos
     JButton registrarEmpleadoBoton;
     JButton despedirEmpleadoBoton;
     //Administracion
     JButton registrarVehiculoBoton;
     //Cajero
     JButton registrarPagoBoton;
     //Usuario
     String cargo;
     
     JButton salirBoton;
     JButton perfilBoton;
     JButton mensajesBoton;
     int id;
     int saltoLinea;
     int columnaUno;
     int columnaDos;
    public static void main(String [] args)throws Exception{
      PrincipalNuevo p = new PrincipalNuevo(1,"iashfi");
    }
    public PrincipalNuevo(int id,String cargo)throws Exception{
        Frame = new JFrame();
        Frame.setSize(1000,600);
        this.cargo = cargo;
        this.id = id;
        inicializarBotones();
        inicializarLabels();
        inicializarPanel();
       // inicializarEstandares();  
        //inicializarTextFields();
       
        //Frame.pack();
        Frame.add(panel);
        Frame.setVisible(true);
        //inicializarBotones();
    }
    public void inicializarLabels(){
      bienvenidoLabel = new JLabel("BIENVENIDO A SCRUMCARS: ");
      bienvenidoLabel.setFont(new Font("Arial", 4, 20));
      bienvenidoLabel.setBounds(0,0, 300, 40);
      loggeadoLabel = new JLabel("Estás loggeado como: "+cargo);
      loggeadoLabel.setFont(new Font("Arial", 4, 20));
      loggeadoLabel.setBounds(400,0, 300, 40);
      
    }
    public void inicializarBotones(){
        //Principales
        salirBoton = new JButton("Salir");
        salirBoton.setBounds(848,0, 150, 40);
        perfilBoton= new JButton("Perfil");
        perfilBoton.setBounds(848,40, 150, 40);
        mensajesBoton= new JButton("Mensajes");
        mensajesBoton.setBounds(848,80, 150, 40);
        
        //Secundarios
        ventasBoton = new JButton("DEPARTAMENTO \n"+"DE VENTAS");
        ventasBoton.setBounds(0,150, 150, 80);
        
        recursosBoton = new JButton("RECURSOS \n"+"HUMANOS");
        recursosBoton.setBounds(0,230, 150, 80);
        
        cajeroBoton = new JButton("CAJERO");
        cajeroBoton.setBounds(0,310, 150, 80);
        
      
       administracionBoton = new JButton("RECURSOS \n"+"HUMANOS");
       administracionBoton.setBounds(0,390, 150, 80);
  
     //Ventas
     JButton ventaCreditoBoton;
     JButton ventaContadoBoton;
     JButton reporteBoton;
     //RecursosHumanos
     JButton registrarEmpleadoBoton;
     JButton despedirEmpleadoBoton;
     //Administracion
     JButton registrarVehiculoBoton;
     //Cajero
     JButton registrarPagoBoton;
    }
    public void inicializarPanel(){
        panel = new JPanel();
        panel.setBounds(0,0,1000,600);
        Frame.getContentPane().add(bienvenidoLabel);
        Frame.getContentPane().add(loggeadoLabel);
        Frame.getContentPane().add(salirBoton);
        Frame.getContentPane().add(mensajesBoton);
        Frame.getContentPane().add(perfilBoton);
        
        Frame.getContentPane().add(ventasBoton);
        Frame.getContentPane().add(recursosBoton);
        Frame.getContentPane().add(cajeroBoton);
        Frame.getContentPane().add(administracionBoton);
        
        
       // Frame.getContentPane(bienvenidoLabel);
       // panel.add(bienvenidoLabel);
       // panel.add(loggeadoLabel);
      //  panel.add(salirBoton);
       // panel.add(mensajesBoton);
        //panel.add(perfilBoton);
    }
}

   