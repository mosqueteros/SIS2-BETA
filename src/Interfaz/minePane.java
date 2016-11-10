/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USUARIO
 */
public class minePane extends JPanel{
    JLabel tituloLabel;
    JLabel nombreLabel;
    JLabel ciLabel;
    JLabel correoElectronicoLabel;
    JLabel tipoEmpleadoLabel;
    
    Validacion v;
    JTextField titulo;
    JTextField nombre;
    JTextField ci;
    JTextField correoElectronico;
    JTextField tipoEmpleado;
    
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
    
    public minePane(){
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
       
        //anadirComponentes();
    }
    public void inicializarComponentes(){
        inicializarLabels();
        inicializarTextFields();
        inicializarTabla();
        inicializarBotones();
    
    }
    public void inicializarBotones(){
        registrarBoton = new JButton("Registrar");
        registrarBoton.setFont(new Font((fuente),grosor,tamano));
        registrarBoton.setBounds(240,330,300,50);
        registrarBoton.addActionListener(new ActionListener(){
           @Override
            public void actionPerformed(ActionEvent e) {
                if (enviar()){
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
        cancelarBoton.setBounds(600,330,300,50);
        //anadirAPanel((JButton)registrarBoton,this);
        add(cancelarBoton);
    
    }
    public boolean enviar(){
       
        if(v.CIValido(ci.getText()) &&
          v.nombreProveedorValido(nombre.getText()) &&
          v.correoValido(correoElectronico.getText()) ){
            return true;
        }else{
            return false;
        }
    }
    public void inicializarTabla(){
        tabla = new JTable();
        String[] columnNames = {"Nombre","CI","Correo electronico","Sueldo"};
        String [] datos = {""};
        DefaultTableModel dtm= new DefaultTableModel(columnNames,20);
        final JTable table = new JTable(dtm);
        table.setFont(new Font((fuente),grosor,tamano));
        JScrollPane tableContainer = new JScrollPane(table);
        this.add(tableContainer);
        
        tableContainer.setBounds(600, 100, 310, 200);
        
    }
    
    public void inicializarTextFields(){
       nombre   =     new JTextField();    
       ci       =     new JTextField();     
       correoElectronico = new JTextField();
       textFields = new ArrayList<>();
       textFields.add(nombre);textFields.add(ci);textFields.add(correoElectronico);
       comboBox = new JComboBox();
       comboBox.setFont(new Font((fuente),grosor,tamano));
       comboBox.addItem("Recursos Humanos");
       comboBox.addItem("Vendedor");
       comboBox.addItem("Mecanico");
       anadirTextFields();
    }
    public void anadirTextFields(){
        int x = 240;
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
        tituloLabel = new JLabel("REGISTRO DE EMPLEADO");
        tituloLabel.setFont(new Font((fuente),grosor,35));
        tituloLabel.setBounds(300,30,600,30);
        add(tituloLabel);
        nombreLabel = new JLabel("Nombre: ");
        ciLabel = new JLabel("CI: ");
        correoElectronicoLabel = new JLabel("Correo Electrónico: ");
        tipoEmpleadoLabel = new JLabel("Tipo de Empleado: ");
        labels = new ArrayList<>();
        labels.add(nombreLabel);labels.add(ciLabel);
        labels.add(correoElectronicoLabel); labels.add(tipoEmpleadoLabel); 
        anadirLabels();
    }
    
}
