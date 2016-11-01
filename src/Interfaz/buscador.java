package Interfaz;

import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class buscador {

    private JFrame frame = new JFrame("buscador de ID vehiculo");

    private JLabel textBuscador;
    private JTextField texto;
    private JComboBox combo;
    private ArrayList<String> lista;
    private String directeada;
    private JButton aceptar;

    public buscador(ArrayList<String> lista) {
        this.lista = lista;
        frame = new JFrame();
        frame.setTitle("buscador de ID vehiculo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        componentes();
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    private void componentes() {
        textBuscador = new JLabel("buscar:");
        textBuscador.setFont(new Font("Arial", 4, 15));
        textBuscador.setText("buscar:");
        textBuscador.setBounds(20, 10, 200, 30);
        frame.getContentPane().add(textBuscador);

        texto = new JTextField();
        texto.setFont(new Font("Arial", 3, 15));
        texto.setBounds(80, 10, 200, 30);
        frame.getContentPane().add(texto);
        texto.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                textokeyReleased(evt);
            }

        });
        combo = new JComboBox<>();
        combo.setModel(new DefaultComboBoxModel<>(new String[]{""}));
        frame.getContentPane().add(combo);
        combo.setBounds(290, 10, 200, 30);
        combo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                comboActionPerformed(evt);
            }

        });

        aceptar = new JButton();
        aceptar.setFont(new Font("Arial", 4, 15));
        aceptar.setText("aceptar");
        aceptar.setBounds(390, 340, 100, 30);
        frame.getContentPane().add(aceptar);
        aceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                aceptarActionPerformed(evt);
            }

        });
        frame.pack();
    }

    private void textokeyReleased(KeyEvent evt) {
        String palabra = texto.getText();
        ArrayList<String> lista2 = new ArrayList<>();
        int tam = palabra.length();
        for (int i = 0; i < lista.size(); i++) {
            try {
                String dato = lista.get(i).substring(0, tam);
                if (dato.equalsIgnoreCase(palabra)) {
                    lista2.add(lista.get(i));
                }
            } catch (Exception e) {
                tam = tam - 1;
            }
        }
        modificador(lista2);
    }

    public void modificador(ArrayList<String> listado) {
        String[] list = new String[listado.size()];

        for (int i = 0; i < listado.size(); i++) {
            list[i] = listado.get(i);
        }
        combo.setModel(new DefaultComboBoxModel<>(list));
    }

    private void comboActionPerformed(ActionEvent evt) {
        String valor = (String) combo.getSelectedItem();
        if (valor != null) {
            texto.setText(valor);
        }
    }

    private void aceptarActionPerformed(ActionEvent evt) {
        if(!texto.getText().isEmpty()){
             vendedorVehiculo venta=new vendedorVehiculo(texto.getText());
             frame.dispose(); 
        }
        
    }

}
