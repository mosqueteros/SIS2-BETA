/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import Administrador.Administrador;
import Interfaz.Validacion;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.Principal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Invitado
 */
public class princi {

    private static JFrame frame;
    private static JPanel pane;
    private JMenuBar menuBar;
    private JButton ventaCredit, ventaCont, reporteVent, registroVehicu, registroEmple, despidoEmpl;
    private JTextField id;
    private JLabel nombre, paswordt, ide;
    private JPasswordField paswor;
    private JButton aceptar, salir;
    private JComboBox combo;
    private JFrame pasword;
    String valor;

    public princi() {
        pasword();
    }

    public static void main(String[] a) {
        princi p = new princi();
    }

    private void pasword() {
        pasword = new JFrame("usuario");

        pasword.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pasword.getContentPane().setBackground(Color.cyan);
        pasword.setLayout(null);
        valor = "VENDEDOR";
        pasword.setSize(300, 205);
        pasword.setResizable(false);
        pasword.setLocationRelativeTo(null);
        nombre = new JLabel("usuario:");
        nombre.setFont(new Font("Arial", 3, 15));
        nombre.setBounds(10, 10, 90, 20);
        pasword.getContentPane().add(nombre);
        paswor = new JPasswordField("1234567");
        paswor.setFont(new Font("Arial", 3, 15));
        paswor.setBounds(100, 90, 120, 20);
        pasword.getContentPane().add(paswor);
        paswordt = new JLabel("clave:");
        paswordt.setFont(new Font("Arial", 3, 15));
        paswordt.setBounds(10, 90, 90, 20);
        pasword.getContentPane().add(paswordt);

        id = new JTextField("1");
        id.setFont(new Font("Arial", 3, 15));
        id.setBounds(100, 50, 120, 20);
        pasword.getContentPane().add(id);
        ide = new JLabel("Ide:");
        ide.setFont(new Font("Arial", 3, 15));
        ide.setBounds(10, 50, 90, 20);
        pasword.getContentPane().add(ide);

        combo = new JComboBox<>();
        combo.setModel(new DefaultComboBoxModel<>(new String[]{"VENDEDOR", "R HUMANOS", "GERENTE", "CAJERO"}));
        pasword.getContentPane().add(combo);
        combo.setBounds(100, 10, 120, 20);
        combo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                comboActionPerformed(evt);
            }

            private void comboActionPerformed(ActionEvent evt) {
                valor = (String) combo.getSelectedItem();
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

            private void salirActionPerformed(ActionEvent evt) {
                System.exit(0);
            }

        });
        pasword.getContentPane().add(salir);
        pasword.setVisible(true);
    }

    private void aceptarActionPerformed(ActionEvent evt) {
        Validacion valida = new Validacion();
        int iden = Integer.parseInt("" + id.getText());
        String carg = valor;
        String contrasena = paswor.getText();
        String cargoEmpleado;
        Administrador admin=Administrador.crearAdministrador("");
        int ci;
        if (iden != 0) {
            System.out.println("sss "+carg);
            if (valida.nombreProveedorValido(carg) ) {
                System.out.println("aaa");
                if (contrasena != null && valida.CIValido(contrasena)) {
                        ci=admin.getCIEmpleado(iden);
                        cargoEmpleado=admin.getTipoEmpleado(iden);
                        if(ci==Integer.parseInt(contrasena) && cargoEmpleado.equals(carg)){
                        try {
                           admin.setUsuarioConectado(iden);
                           PrincipalNuevo p = new PrincipalNuevo(valor);
                           
                        } catch (Exception ex) {
                            System.out.println(ex.toString());
                        }
                        pasword.dispose();
                    }
                        else {
                            
                        JOptionPane.showMessageDialog(null,"1DATOS INCORRECTOS");
        
                        }
                }
                else{
                    JOptionPane.showMessageDialog(null,"2DATOS INCORRECTOS");
        
                }
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"3DATOS INCORRECTOS");
        }
    }
}
