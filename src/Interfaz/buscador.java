package Interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
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
    private JButton aceptar,registrar;
    
    String fuente;
    int tamanoTitulo;
    int tamanoLabels;
    String cargo;
    public buscador(JFrame frame,ArrayList<String> lista,String cargo) {
        this.cargo=cargo;
        this.frame=frame;  
        this.lista = lista;
        panel();
        inicializarEstandares();
        componentes();
        imagen();
        modificador(lista);
        frame.add(panel);
        
        
    }
    private void inicializarEstandares(){
        fuente = "Eras Bold ITC";
        tamanoTitulo = 40 ;
        tamanoLabels = 20;
    }

    private void componentes() {
        textBuscador = new JLabel("Buscar:");
        textBuscador.setForeground(Color.WHITE);
        textBuscador.setFont(new Font(fuente, 4, tamanoLabels));
        textBuscador.setBounds(20, 10, 200, 35);
        frame.getContentPane().add(textBuscador);

        texto = new JTextField();
        texto.setFont(new Font(fuente, 3, tamanoLabels));
        texto.setBounds(100, 10, 200, 35);
        frame.getContentPane().add(texto);
        texto.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                textokeyReleased(evt);
            }

        });
        combo = new JComboBox<>();
        combo.setModel(new DefaultComboBoxModel<>(new String[]{""}));
        panel.add(combo);
        combo.setBounds(310, 10, 200, 35);
        combo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                comboActionPerformed(evt);
            }

        });

        aceptar = new JButton();
        aceptar.setFont(new Font(fuente, 4, tamanoLabels));
        aceptar.setText("ACEPTAR");
        aceptar.setForeground(Color.BLACK);
        aceptar.setBounds(200, 60, 200, 35);
        panel.add(aceptar);
        aceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                aceptarActionPerformed(evt);
            }

        });

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
             vendedorVehiculo v=new vendedorVehiculo(texto.getText(),cargo);
             frame.dispose(); 
        }
        
    }

    private void panel() {
        panel=new JPanel();
        GroupLayout grupo=new GroupLayout(panel);
        panel.setLayout(grupo);
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setBounds(0, 0,600, 200);
    }
    
    JLabel fondos;
    private void imagen() {
        fondos = new JLabel(); 
        fondos.setBounds(0,0,600,200);
        fondos.setIcon(new ImageIcon(getClass().getResource("/Imagen/InterfazMejor.jpg")));
        panel.add(fondos);
    }
  
}
