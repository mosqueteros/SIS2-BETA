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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import principal.PrincipalNuevo;

/**
 *
 * @author USUARIO
 */
public class compraVehiculos {

    JFrame Frame;
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
    JTextField monto;
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
    float precioUnitario;
    int idAuto;

    String carro;
    String cargo;

    Administrador admin;

    int contador = 0;

    public static void main(String[] args) {
        compraVehiculos c = new compraVehiculos("Juan", "GERENTE");
    }

    public compraVehiculos(String carro, String cargo) {
        Frame = new JFrame();
        this.carro = carro;
        this.cargo = cargo;
        v = new Validacion();
        grosor = 4;
        tamano = 20;
        fuente = "Eras Bold ITC";

        admin = Administrador.crearAdministrador("");
        precioUnitario = admin.getPrecioAuto(carro);
        JOptionPane.showMessageDialog(null,""+precioUnitario);
        idAuto = admin.getIdAuto(carro);
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame.setResizable(false);
        Frame.setLayout(null);
        inicializarBotones();
        inicializarLabels();
        inicializarTextFields();

        nombre.setText(this.carro);
        nombre.setEditable(false);
        monto.setText(precioUnitario + "");
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame.setResizable(false);
        Frame.setLayout(null);

        Frame.pack();
        Frame.setSize(1000, 600);
        Frame.setLocationRelativeTo(null);
        comboBox.setVisible(true);
        Frame.setVisible(true);
    }

    public void inicializarBotones() {
        registrarBoton = new JButton("Registrar");
        registrarBoton.setFont(new Font((fuente), grosor, tamano));
        registrarBoton.setBounds(270, 470, 300, 50);
        registrarBoton.addActionListener(new ActionListener() {
            @Override
           public void actionPerformed(ActionEvent e) {
                if (enviar()) {
                    JOptionPane.showMessageDialog(null, "mensaje correcto");
                    Frame.dispose();
                    buscadorIDvehiculo_1 b = new buscadorIDvehiculo_1(cargo);
                } else {
                    System.out.println("Error");
                }
            }
        });
        //anadirAPanel((JButton)registrarBoton,this);
        Frame.getContentPane().add(registrarBoton);
        cancelarBoton = new JButton("Cancelar");
        cancelarBoton.setFont(new Font((fuente), grosor, tamano));
        cancelarBoton.setBounds(630, 470, 300, 50);
        cancelarBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] opciones = {"Aceptar", "Cancelar"};
                int eleccion = JOptionPane.showOptionDialog(null, "En realidad desea realizar cerrar la aplicacion", "Mensaje de Confirmacion",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, opciones, "Aceptar");
                if (eleccion == JOptionPane.YES_OPTION) {

                    Frame.dispose();
                    buscadorIDvehiculo_1 b = new buscadorIDvehiculo_1(cargo);
                }
            }
        });
        Frame.getContentPane().add(cancelarBoton);

    }

    public boolean enviar() {
        boolean compro = false;
        int cantidadAutos = Integer.parseInt(cantidad.getText());
        //System.out.println("CANTIDAD--->"+cantidad.getText());
        float totalAPagar = cantidadAutos * precioUnitario;
        float dineroDisponibleCaja = admin.dineroDisponibleCaja();
        float porcentaje = Float.parseFloat((String) comboBox.getSelectedItem());
        
        //System.out.println("totalAPagar = "+totalAPagar+", dineroDisponible )= "+dineroDisponibleCaja+", porcentaje= "+porcentaje);
        float precioVenta;
        int idCompra;
        if (dineroDisponibleCaja >= totalAPagar) {
            System.out.println("PUDDDOOOOO COMPRAR VEHICULOS");
            contador++;
            precioVenta = (float) (precioUnitario * (porcentaje / 100)) + precioUnitario;
            System.out.println("PRECIO DE VENTA ASIGNADO = "+precioVenta);
            
            admin.registrar_compra(nombreProveedor.getText(), Integer.parseInt(NIT.getText()), idAuto, (float) (precioUnitario), cantidadAutos, (float) precioVenta);
            idCompra = admin.getIDUltimaCompra();
            admin.ingresarCaja(idCompra, 2, "20161205", totalAPagar * -1);//crear la verdadera fecha
            compro = true;
            
            admin.actualizarPrecioVenta((float) precioVenta, idAuto);
        } else {
            JOptionPane.showMessageDialog(null, "No existe el dinero suficiente para realizar esa compra");
        }
        return compro;
    }

    public void inicializarTextFields() {
        comboBox = new JComboBox();
        comboBox.setFont(new Font((fuente), grosor, tamano));
        comboBox.addItem("");
        comboBox.addItem("20");
        comboBox.addItem("50");
        comboBox.addItem("75");
        comboBox.addItem("100");

        Frame.getContentPane().add(comboBox);
        nombreProveedor = new JTextField();
        NIT = new JTextField();
        nombre = new JTextField();
        cantidad = new JTextField();
        monto = new JTextField();
        precioVenta = new JTextField();
        precioVenta.setEditable(false);
        textFields = new ArrayList<>();
        textFields.add(nombreProveedor);
        textFields.add(NIT);
        textFields.add(nombre);
        textFields.add(monto);
        textFields.add(cantidad);
        textFields.add(precioVenta);

        anadirTextFields();

    }

    public void anadirTextFields() {
        int x = 270;
        int y = 142;
        for (int i = 0; i < textFields.size(); i++) {
            textFields.get(i).setBounds(x, y, 300, 35);

            Frame.getContentPane().add(textFields.get(i));
            textFields.get(i).setFont(new Font((fuente), grosor, tamano));
            y += 50;
        }
        comboBox.setBounds(x, y, 300, 35);
        comboBox.repaint();
    }

    public void anadirLabels() {
        int x = 20;
        int y = 107;

        for (int i = 0; i < labels.size(); i++) {
            labels.get(i).setBounds(x, y, 400, 100);
            labels.get(i).setForeground(Color.LIGHT_GRAY);
            labels.get(i).setFont(new Font((fuente), grosor, tamano));
            Frame.getContentPane().add(labels.get(i));

            labels.get(i).setFont(new Font((fuente), grosor, tamano));
            // labels.get(i).setLocation(x, y);

            y += 50;
        }

    }

    private void inicializarLabels() {
        tituloLabel = new JLabel("REGISTRO DE COMPRA DE VEHICULOS");
        tituloLabel.setFont(new Font((fuente), grosor, 35));
        tituloLabel.setForeground(Color.LIGHT_GRAY);
        tituloLabel.setBounds(150, 30, 800, 30);
        Frame.getContentPane().add(tituloLabel);

        nombreProveedorLabel = new JLabel("Nombre de proveedor: ");
        nitLabel = new JLabel("NIT: ");
        nombreLabel = new JLabel("Nombre de Artículo: ");
        montoLabel = new JLabel("Monto: ");
        cantidadLabel = new JLabel("Cantidad: ");
        precioVentaLabel = new JLabel("Precio de Venta");

        labels = new ArrayList<>();
        labels.add(nombreProveedorLabel);
        labels.add(nitLabel);
        labels.add(nombreLabel);
        labels.add(montoLabel);
        labels.add(cantidadLabel);
        labels.add(precioVentaLabel);

        anadirLabels();

        JLabel label = new JLabel();
        label.setIcon(new ImageIcon(getClass().getResource("/Imagen/InterfazMejor.jpg")));
        Frame.getContentPane().add(label);
        label.setBounds(0, 0, 1000, 600);

    }

}
