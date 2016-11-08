package Interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class buscador {

    private JFrame frame;
    private JPanel panel;
    private JLabel textBuscador;
    private JTextField texto;
    private JComboBox combo;
    private ArrayList<String> lista;
    private String directeada;
    private JButton aceptar;
    
    public buscador(JFrame frame,ArrayList<String> lista) {
        this.frame=frame;
        
        this.lista = lista;
        panel();
        componentes();
        modificador(lista);
        frame.add(panel);
        
        
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
        panel.add(combo);
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
        panel.add(aceptar);
        aceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                aceptarActionPerformed(evt);
            }

        });
        //panel.pack();
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
             vendedorVehiculo v=new vendedorVehiculo(texto.getText());
             frame.dispose(); 
        }
        
    }

    private void panel() {
        panel=new JPanel();
        GroupLayout grupo=new GroupLayout(panel);
        panel.setLayout(grupo);
        panel.setBackground(Color.RED);
        panel.setBounds(0, 0,500, 400);
    }
  
    
}
