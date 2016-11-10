package principal;

import Interfaz.buscadorIDvehiculo;
import Interfaz.component;
import Interfaz.vendedorVehiculo;
import Interfaz.ventaCredito;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class frame {

    private static JFrame frame;
    private static JPanel pane;
    private JMenuBar menuBar;
    private JButton ventaCredit, ventaCont,reporteVent, registroVehicu, registroEmple, despidoEmpl;
    private JTextField cargo, id;
    private JLabel nombre, paswordt, ide;
    private JPasswordField paswor;
    private JButton aceptar, salir;
    private JComboBox combo;

    public frame() {
        pasword();
        primerPane();
    }


    private void primerPane() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        frame.setLayout(null);
        frame.setSize(1100, 600);
        ventana1();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
    }

    private void ventana1() {
        menuBar = new JMenuBar();

        ventaCredit = new JButton();
        ventaCont = new JButton();
        reporteVent = new JButton();
        registroVehicu = new JButton();
        registroEmple = new JButton();
        despidoEmpl = new JButton();
        ventaCredit.setText("venta a credito");
        ventaCont.setText("venta al contado");
        reporteVent.setText("reporte de venta");
        registroVehicu.setText("registro de vehiculo");
        registroEmple.setText("registro de empleado");
        despidoEmpl.setText("despido de empleado");
        

        menuBar.add(ventaCredit);
        menuBar.add(ventaCont);
        menuBar.add(reporteVent);
        menuBar.add(registroVehicu);
        menuBar.add(registroEmple);
        menuBar.add(despidoEmpl);
        ventaCredit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                crediActionPerformed(evt);
            }

            private void crediActionPerformed(ActionEvent evt) {

                ventaCredito v=new ventaCredito();

            }


        });
        ventaCont.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                compra1ActionPerformed(evt);
            }

            private void compra1ActionPerformed(ActionEvent evt) {

              //  buscadorIDvehiculo v=new buscadorIDvehiculo(cargo);

            }

        });
        reporteVent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                compra2ActionPerformed(evt);
            }

            private void compra2ActionPerformed(ActionEvent evt) {

            }

        });
        registroVehicu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                compra3ActionPerformed(evt);
            }

            private void compra3ActionPerformed(ActionEvent evt) {

            }

        });
        registroEmple.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                compra4ActionPerformed(evt);
            }

            private void compra4ActionPerformed(ActionEvent evt) {

            }

        });
        despidoEmpl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                compra5ActionPerformed(evt);
            }

            private void compra5ActionPerformed(ActionEvent evt) {

            }

        });
        frame.setJMenuBar(menuBar);
        inavilitador();

    }
    private JFrame pasword;

    private void pasword() {
        pasword = new JFrame("usuario");

        pasword.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pasword.getContentPane().setBackground(Color.cyan);
        pasword.setLayout(null);

        pasword.setSize(300, 205);
        pasword.setResizable(false);
        pasword.setLocationRelativeTo(null);
        cargo = new JTextField();
        cargo.setFont(new Font("Arial", 3, 15));
        cargo.setBounds(100, 10, 120, 20);
        pasword.getContentPane().add(cargo);
        nombre = new JLabel("usuario:");
        nombre.setFont(new Font("Arial", 3, 15));
        nombre.setBounds(10, 10, 90, 20);
        pasword.getContentPane().add(nombre);
        paswor = new JPasswordField("ksjdhdhdhxvgv");
        paswor.setFont(new Font("Arial", 3, 15));
        paswor.setBounds(100, 90, 120, 20);
        pasword.getContentPane().add(paswor);
        paswordt = new JLabel("clave:");
        paswordt.setFont(new Font("Arial", 3, 15));
        paswordt.setBounds(10, 90, 90, 20);
        pasword.getContentPane().add(paswordt);

        id = new JTextField();
        id.setFont(new Font("Arial", 3, 15));
        id.setBounds(100, 50, 120, 20);
        pasword.getContentPane().add(id);
        ide = new JLabel("ide:");
        ide.setFont(new Font("Arial", 3, 15));
        ide.setBounds(10, 50, 90, 20);
        pasword.getContentPane().add(ide);

        combo = new JComboBox<>();
        combo.setModel(new DefaultComboBoxModel<>(new String[]{"gerente", "vendedor", "recursos humanos", "cajero"}));
        pasword.getContentPane().add(combo);
        combo.setBounds(220, 10, 80, 20);
        combo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                comboActionPerformed(evt);
            }

            private void comboActionPerformed(ActionEvent evt) {
                String valor = (String) combo.getSelectedItem();
                if (valor != null) {
                    cargo.setText(valor);
                }
            }

        });
        aceptar = new JButton("aceptar");
        aceptar.setBackground(Color.GREEN);
        aceptar.setFont(new Font("Arial", 3, 15));
        aceptar.setBounds(20, 130, 100, 20);
        aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                aceptarActionPerformed(evt);
            }

        });
        pasword.getContentPane().add(aceptar);

        salir = new JButton("cancelar");
        salir.setBackground(Color.GREEN);
        salir.setFont(new Font("Arial", 3, 15));
        salir.setBounds(150, 130, 100, 20);
        salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                salirActionPerformed(evt);
            }

        });
        pasword.getContentPane().add(salir);
        pasword.setVisible(true);
    }

    private void aceptarActionPerformed(ActionEvent evt) {
        String iden = ide.getText();
        String carg = cargo.getText();
        String contrasena = paswor.getText();
        if (iden != null) {
            if (carg != null) {
                if (contrasena != null) {
                    if (carg!="contador") {
                        System.out.println("condicion");
                        ventaCredit.setEnabled(true);
                        ventaCont.setEnabled(true);
                        
                        
                    }
                    if (carg.equals( "gerente")) {
                        ventaCredit.setEnabled(true);
                        ventaCont.setEnabled(true);
                        reporteVent.setEnabled(true);
                        registroVehicu.setEnabled(true);
                        registroEmple.setEnabled(true);
                        despidoEmpl.setEnabled(true);
                    }
                    if(carg.equals("recursos humanos")){
                        registroEmple.setEnabled(true);
                        despidoEmpl.setEnabled(true);
                    }
                   frame.setVisible(true);
                    pasword.dispose();
                }
            }
        }
    }

    private void salirActionPerformed(ActionEvent evt) {
        System.exit(0);
    }

    private void inavilitador() {
        ventaCredit.setEnabled(false);
        ventaCont.setEnabled(false);
        reporteVent.setEnabled(false);
        registroVehicu.setEnabled(false);
        registroEmple.setEnabled(false);
        despidoEmpl.setEnabled(false);

    }
}
