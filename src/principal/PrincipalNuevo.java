/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import Administrador.Administrador;
import Interfaz.DespedirEmpleado;
import Interfaz.buscadorIDvehiculo;
import Interfaz.registroEmplead;
import Interfaz.registroEmpleado;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import static javafx.scene.text.Font.font;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PrincipalNuevo {

    JFrame Frame;
    JPanel panel;

    JLabel bienvenidoLabel;
    JLabel loggeadoLabel;

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
    private int estado=0;
    JButton salirBoton;
    JButton perfilBoton;
    JButton mensajesBoton;
    int id;
    int saltoLinea;
    private Administrador admin;
    
    public static void main(String[] args) {
        PrincipalNuevo p = new PrincipalNuevo( "eduardo");
    }

    public PrincipalNuevo(String cargo) {
        Frame = new JFrame();
        //imagen();
       
        
        
        Frame.setUndecorated(true);
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame.setBackground(Color.darkGray);
        actualizarFrame();
        this.cargo = cargo;
        this.id = id;
        
        inicializarBotones();
        inicializarLabels();
        inicializarPanel();
        Frame.setResizable(false);
        Frame.setLocationRelativeTo(null);
        Frame.setVisible(true);
        
        preferencias();
        
        
       
        
    }

    public void inicializarLabels() {
        bienvenidoLabel = new JLabel("BIENVENIDO A SCRUMCARS: ");
        bienvenidoLabel.setFont(new Font("Arial", 3, 20));
        bienvenidoLabel.setBounds(0, 0, 300, 40);
        bienvenidoLabel.setForeground(Color.BLACK);
        loggeadoLabel = new JLabel("ESTAS LOGEADO COMO: " + cargo);
        loggeadoLabel.setFont(new Font("Arial", 3, 20));
        loggeadoLabel.setForeground(Color.BLACK);
        loggeadoLabel.setBounds(450, 0, 300, 40);
        

    }

    public void inicializarBotones() {
        //Principales
        salirBoton = new JButton("Salir");
        salirBoton.setBounds(848, 0, 150, 40);
        salirBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                salirActionPerformed(evt);
            }

            private void salirActionPerformed(ActionEvent evt) {
                JOptionPane.showMessageDialog(null,"Usted esta saliendo del programa");
                System.exit(0);
            }
        });
        perfilBoton = new JButton("Perfil");
        perfilBoton.setBounds(848, 40, 150, 40);
        perfilBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                perfilActionPerformed(evt);
            }

        });
        mensajesBoton = new JButton("Mensajes");
        mensajesBoton.setBounds(848, 80, 150, 40);
        mensajesBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                nesajeBActionPerformed(evt);
            }

        });
        //Secundarios
        ventasBoton = new JButton("VENDEDOR");
        ventasBoton.setBounds(0, 150, 150, 80);

        recursosBoton = new JButton("R HUMANOS");
        recursosBoton.setBounds(0, 230, 150, 80);

        cajeroBoton = new JButton("CAJERO");
        cajeroBoton.setBounds(0, 310, 150, 80);
       
        administracionBoton = new JButton("ADMISNISTRACION");
        administracionBoton.setBounds(0, 390, 150, 80);
        eventosBoton();
        inavilitar();
    }

    public void inicializarPanel() {

        Frame.getContentPane().add(bienvenidoLabel);
        Frame.getContentPane().add(loggeadoLabel);
        Frame.getContentPane().add(salirBoton);
        Frame.getContentPane().add(mensajesBoton);
        Frame.getContentPane().add(perfilBoton);

        Frame.getContentPane().add(ventasBoton);
        Frame.getContentPane().add(recursosBoton);
        Frame.getContentPane().add(cajeroBoton);
        Frame.getContentPane().add(administracionBoton);
        panel = new JPanel();
        Frame.getContentPane().add(panel);
        panel.setBounds(300,300,300, 300);
        
    }

    private void eventosBoton() {
        ventasBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                ventaBotonActionPerformed(evt);
            }

            private void ventaBotonActionPerformed(ActionEvent evt) {

                ventas();
                if(estado==1){
                try {
                   
                    recursosBoton.setEnabled(true);
                    cajeroBoton.setEnabled(true);
                    administracionBoton.setEnabled(true);
                    panel.remove(registrarEmpleadoBoton);
                    panel.remove(despedirEmpleadoBoton);
                    panel.remove(registrarPagoBoton);
                    panel.remove(registrarVehiculoBoton);
                } catch (Exception e) {
                    System.out.println("elementos no existen");
                }
                }
                

            }
        });
        recursosBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                recursosHActionPerformed(evt);
            }

            private void recursosHActionPerformed(ActionEvent evt) {
                recusoHumanos();
                if(estado==1){
                try {
                    
                    
                    ventasBoton.setEnabled(true);
                    cajeroBoton.setEnabled(true);
                    administracionBoton.setEnabled(true);
                    panel.remove(ventaCreditoBoton);
                    panel.remove(ventaContadoBoton);
                    panel.remove(registrarPagoBoton);
                    panel.remove(registrarVehiculoBoton);
                    panel.remove(reporteBoton);
                } catch (Exception e) {
                    System.out.println("elementos no existen");
                }
                }
                

            }

        });
        cajeroBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                cajeroBotonActionPerformed(evt);
            }

            private void cajeroBotonActionPerformed(ActionEvent evt) {

                cajero();
                if(estado==1){
                try {
                     
                    ventasBoton.setEnabled(true);
                    recursosBoton.setEnabled(true);
                    administracionBoton.setEnabled(true);
                    
                    panel.remove(registrarEmpleadoBoton);
                    panel.remove(despedirEmpleadoBoton);
                    panel.remove(ventaContadoBoton);
                    panel.remove(ventaCreditoBoton);
                    panel.remove(reporteBoton);
                    panel.remove(registrarVehiculoBoton);
                    
                } catch (Exception e) {
                    System.out.println("Elementos no existen");
                }
                }
                

            }
        });
        administracionBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                administracionActionPerformed(evt);
            }

            private void administracionActionPerformed(ActionEvent evt) {
                administracion();
                try {
                    ventasBoton.setEnabled(true);
                    recursosBoton.setEnabled(true);
                    cajeroBoton.setEnabled(true);
                    panel.remove(registrarEmpleadoBoton);
                    panel.remove(despedirEmpleadoBoton);
                    panel.remove(registrarPagoBoton);
                    panel.remove(reporteBoton);
                    panel.remove(ventaContadoBoton);
                    panel.remove(ventaCreditoBoton);
                } catch (Exception e) {
                    System.out.println("Elementos no existen");
                }

            }
        });

    }

    public void actualizarFrame() {
        Frame.repaint();
        Frame.setSize(1000, 600);
        
    }

    public void cajero() {

        //limpia
        registrarPagoBoton = new JButton("REGISTRAR PAGO");
        registrarPagoBoton.setBounds(300, 300, 150, 80);
        registrarPagoBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                registraraPagoActionPerformed(evt);
            }

        });
        panel.add(registrarPagoBoton);

        Frame.getContentPane().add(panel);
        actualizarFrame();
        registrarPagoBoton.setVisible(true);
        cajeroBoton.setEnabled(false);
    }

    public void recusoHumanos() {

        registrarEmpleadoBoton = new JButton("REGISTRAR EMPLEADO");
        registrarEmpleadoBoton.setBounds(300, 300, 150, 80);
        registrarEmpleadoBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                registrarEmpleadoActionPerformed(evt);
            }

        });

        despedirEmpleadoBoton = new JButton("DESPEDIR EMPLEADO");
        despedirEmpleadoBoton.setBounds(300, 390, 150, 80);
        despedirEmpleadoBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt){
                despedirEmpleadoActionPerformed(evt);
            }

        });
        panel.add(despedirEmpleadoBoton);
        panel.add(registrarEmpleadoBoton);
        Frame.getContentPane().add(panel);
        actualizarFrame();
        recursosBoton.setEnabled(false);
        panel.setFocusable(true);
    }

    public void ventas() {

        ventaCreditoBoton = new JButton("VENTA A CREDITO");
        ventaCreditoBoton.setBounds(300, 300, 150, 80);
        ventaCreditoBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                ventaCreditEmpleadoActionPerformed(evt);
            }

        });
        ventaContadoBoton = new JButton("VENTA A CONTADO");
        ventaContadoBoton.setBounds(300, 390, 150, 80);
        ventaContadoBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                ventaContadoActionPerformed(evt);
            }

        });
        reporteBoton = new JButton("REPORTE DE VENTAS");
        reporteBoton.setBounds(300, 480, 150, 80);
        reporteBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                reporteActionPerformed(evt);
            }

        });
        panel.add(ventaCreditoBoton);
        panel.add(ventaContadoBoton);
        panel.add(reporteBoton);
        Frame.getContentPane().add(panel);
        actualizarFrame();
        ventasBoton.setEnabled(false);
        panel.repaint();
        
    }

    public void administracion() {

        registrarVehiculoBoton = new JButton("REGISTRAR VEHICULO");
        registrarVehiculoBoton.setBounds(300, 300, 150, 80);
        registrarVehiculoBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                RegistrarVehiculActionPerformed(evt);
            }

        });
        panel.add(registrarVehiculoBoton);
        actualizarFrame();
        administracionBoton.setEnabled(false);
        panel.repaint();
        
    }

    private void despedirEmpleadoActionPerformed(ActionEvent evt){
        try{
            DespedirEmpleado d = new DespedirEmpleado(cargo);
            Frame.dispose();
        }catch (Exception e){
        
        }
        
    }

    private void ventaContadoActionPerformed(ActionEvent evt) {
        buscadorIDvehiculo h=new buscadorIDvehiculo(cargo);
    }   

    private void RegistrarVehiculActionPerformed(ActionEvent evt) {
        
    }

    private void reporteActionPerformed(ActionEvent evt) {
    }

    private void ventaCreditEmpleadoActionPerformed(ActionEvent evt) {
        
    }

    private void registrarEmpleadoActionPerformed(ActionEvent evt) {
        registroEmpleado h=new registroEmpleado(cargo);
        Frame.dispose();
    }

    private void registraraPagoActionPerformed(ActionEvent evt) {

    }

    private void perfilActionPerformed(ActionEvent evt) {
       JOptionPane.showMessageDialog(null,"pertenece la plantilla a: "+cargo );
    }

    private void nesajeBActionPerformed(ActionEvent evt) {
        JOptionPane.showMessageDialog(null,"no usar esta plantilla con fines fiscales" );
    }
    JLabel fondos;
    private void imagen() {
        fondos = new JLabel(); 
        fondos.setBounds(0,0,1000,600);
        URL url=getClass().getResource("InterfazMejor.jpg");
        ImageIcon image=new ImageIcon(url);
        Icon icono = new ImageIcon(image.getImage().getScaledInstance(fondos.getWidth(), fondos.getHeight(), Image.SCALE_DEFAULT));
        fondos.setIcon(icono);
        fondos.repaint();
        Frame.getContentPane().add(fondos);
        actualizarFrame();
    }
    public void inavilitar(){
        ventasBoton.setEnabled(false);
        recursosBoton.setEnabled(false);
        cajeroBoton.setEnabled(false);
        administracionBoton.setEnabled(false);
        
    }
    private void preferencias() {
        if(cargo.equals(ventasBoton.getText())){
            ventasBoton.setEnabled(true);
        }
        if(cargo.equals(cajeroBoton.getText())){
            cajeroBoton.setEnabled(true);
        }
        if(cargo.equals(administracionBoton.getText())){
            estado=1;
            administracionBoton.setEnabled(true);
        }
        if(cargo.equals(recursosBoton.getText())){
            recursosBoton.setEnabled(true);
        }
    }
}
