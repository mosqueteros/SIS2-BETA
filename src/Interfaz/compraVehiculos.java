/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Administrador.Administrador;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USUARIO
 */
public class compraVehiculos extends JPanel{
    JLabel tituloLabel;
    JLabel nombreProveedorLabel;
    JLabel nitLabel;
    JLabel nombreLabel;
    JLabel cantidadLabel;
    JLabel montoLabel;
    JLabel precioVentaLabel;
    
    Validacion v;
    
    JTextField nombreProveedor;    
    JTextField NIT;
    JTextField nombre;    
    JTextField cantidad;  
    JTextField  monto;
    JTextField precioVenta;
    
    JComboBox comboBox;
    
    JButton registrarBoton;
    JButton cancelarBoton;
    
    GroupLayout grupo;
    ArrayList<JLabel> labels;
    ArrayList<JTextField> textFields;
    JTable tabla;
    String fuente;
    int grosor;
    int tamano;
    String cargo;
    float precioUnitario;
    int idAuto;
    String carro;
    Administrador admin;
    int contador=0;
    public compraVehiculos(String carro,String cargo){
        this.carro=carro;
        admin=Administrador.crearAdministrador("");
        precioUnitario=admin.getPrecioAuto(carro);
        idAuto=admin.getIdAuto(carro);
        this.cargo=cargo;
       // this.setLayout(null);
        v = new Validacion();
         grosor = 4;
         tamano = 20;
         fuente = "Eras Bold ITC";
        grupo = new GroupLayout(this);
        this.setLayout(grupo);
        this.setBackground(Color.LIGHT_GRAY);
        this.setSize(1000,600);
        //this.setLayout(null);
        inicializarComponentes();
       nombre.setText(carro);
       nombre.setEnabled(false);
       monto.setText(precioUnitario+"");
        //anadirComponentes();
    }
    public void inicializarComponentes(){
        inicializarLabels();
        inicializarTextFields();
        
        inicializarBotones();
    
    }
    public void inicializarBotones(){
        registrarBoton = new JButton("Registrar");
        registrarBoton.setFont(new Font((fuente),grosor,tamano));
        registrarBoton.setBounds(270,470,300,50);
        registrarBoton.addActionListener(new ActionListener(){
           @Override
            public void actionPerformed(ActionEvent e) {
                if (enviar()){
                    JOptionPane.showMessageDialog(null,"mensaje correcto");
                    System.out.println("Enviado");
                }else{
                    System.out.println("Error");
                }
            }
        } );
        //anadirAPanel((JButton)registrarBoton,this);
        add(registrarBoton);
        cancelarBoton = new JButton("Cancelar");
        cancelarBoton.setFont(new Font((fuente),grosor,tamano));
        cancelarBoton.setBounds(630,470,300,50);
        //anadirAPanel((JButton)registrarBoton,this);
        add(cancelarBoton);
    
    }
    public boolean enviar(){
        boolean compro=false;
       int cantidadAutos = Integer.parseInt(cantidad.getText());
       //System.out.println("CANTIDAD--->"+cantidad.getText());
       float totalAPagar = cantidadAutos*precioUnitario;
       float dineroDisponibleCaja = admin.dineroDisponibleCaja();
       float porcentaje = Float.parseFloat((String)comboBox.getSelectedItem());
       //System.out.println("totalAPagar = "+totalAPagar+", dineroDisponible )= "+dineroDisponibleCaja+", porcentaje= "+porcentaje);
       float precioVenta;
       int idCompra;
       if(dineroDisponibleCaja>=totalAPagar){
           contador++;
           precioVenta = (float)(precioUnitario*(porcentaje/100))+precioUnitario;
           admin.registrar_compra(nombreProveedor.getText(), Integer.parseInt(NIT.getText()), idAuto, (float)(precioUnitario), cantidadAutos, (float) precioVenta);
           idCompra = admin.getIDUltimaCompra();
           admin.ingresarCaja(idCompra, 2, "20161205", totalAPagar*-1);//crear la verdadera fecha
           compro=true;
       }
       else{
           JOptionPane.showMessageDialog(null, "No existe el dinero suficiente para realizar esa compra");
       }
       return compro;
    }
    
    public void inicializarTextFields(){
       nombreProveedor   =  new JTextField();    
       NIT               =  new JTextField();
       nombre            =  new JTextField();
       cantidad          =  new JTextField();
       monto             =  new JTextField();
       precioVenta       =  new JTextField();
       precioVenta.setEditable(false);
       textFields        =  new ArrayList<>();
       textFields.add(nombreProveedor);textFields.add(NIT);textFields.add(nombre);
      textFields.add(monto); textFields.add(cantidad);textFields.add(precioVenta);
       comboBox = new JComboBox();
       comboBox.setFont(new Font((fuente),grosor,tamano));
       comboBox.addItem("");
       comboBox.addItem("20");
       comboBox.addItem("50");
       comboBox.addItem("75");
       comboBox.addItem("100");
       anadirTextFields();
    }
    public void anadirTextFields(){
        int x = 270;
        int y = 105;
        for(int i = 0; i< textFields.size();i++){
           textFields.get(i).setBounds(x,y,300,35);
            anadirAPanel(textFields.get(i),this);
            textFields.get(i).setFont(new Font((fuente),grosor,tamano));
            y+=50;
        }
        comboBox.setBounds(x, y, 300, 35);
        anadirAPanel(comboBox,this);
    }
    
    
    
    public void anadirLabels(){
        int x = 20;
        int y = 70;
        
        
        
        for(int i = 0 ; i< labels.size() ; i++){ 
            labels.get(i).setBounds(x,y,400,100);
            anadirAPanel(labels.get(i),this);
            
            labels.get(i).setFont(new Font((fuente),grosor,tamano));
           // labels.get(i).setLocation(x, y);
            
            y+=50;
        }
        
    }
    public void anadirAPanel(JComponent jl, JPanel jp){
        jp.add(jl);
    }
    
    private void inicializarLabels(){
        tituloLabel = new JLabel("REGISTRO DE COMPRA");
        tituloLabel.setFont(new Font((fuente),grosor,35));
        tituloLabel.setBounds(300,30,600,30);
        add(tituloLabel);
        
        nombreProveedorLabel = new JLabel("Nombre de proveedor: ");
        nitLabel = new JLabel("NIT: ");
        nombreLabel = new JLabel("Nombre de Artículo: ");
        montoLabel = new JLabel("Monto: ");
        cantidadLabel = new JLabel("Cantidad: ");
        precioVentaLabel = new JLabel("Precio de Venta");
        
        labels = new ArrayList<>();
        labels.add(nombreProveedorLabel);labels.add(nitLabel);
        labels.add(nombreLabel); labels.add(montoLabel);
        labels.add(cantidadLabel);labels.add(precioVentaLabel);
        anadirLabels();
    }
    
}
