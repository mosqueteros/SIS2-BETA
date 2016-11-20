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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.security.Principal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
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
public class Login {

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

    public Login() {
        pasword();
    }

    public static void main(String[] a) {
        Login p = new Login();
    }

    private void pasword() {
        pasword = new JFrame("Inicio de Sesión");
         JLabel label = new JLabel(); 
        label.setIcon(new ImageIcon(getClass().getResource("/Imagen/ImgLogin.jpg")));
        
        label.setBounds(0,0,360,500);

        pasword.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
        pasword.setLayout(null);
      
        pasword.setSize(360, 450);
        pasword.setResizable(false);
        pasword.setLocationRelativeTo(null);
        int y = 160;
        int x = 5;
        //Primera Columna
       
        nombre = new JLabel("USUARIO:");
        nombre.setForeground(Color.LIGHT_GRAY);
        nombre.setFont(new Font("Eras Bold ITC", 4, 20));
        nombre.setBounds(35, 30+y,110, 25);
        pasword.getContentPane().add(nombre);
      
        ide = new JLabel("IDE: ");
        ide.setForeground(Color.LIGHT_GRAY);
        ide.setFont(new Font("Eras Bold ITC", 4, 20));
        ide.setBounds(35, 70+y, 100, 20);
        pasword.getContentPane().add(ide);

        paswordt = new JLabel("CLAVE:");
        paswordt.setForeground(Color.LIGHT_GRAY);
        paswordt.setFont(new Font("Eras Bold ITC", 4, 20));
        paswordt.setBounds(35, 110+y, 100, 20);
        pasword.getContentPane().add(paswordt);
        
        
        //SegundaColumna
        
        combo = new JComboBox<>();
        combo.setModel(new DefaultComboBoxModel<>(new String[]{"VENDEDOR", "R HUMANOS", "GERENTE", "CAJERO"}));
        pasword.getContentPane().add(combo);
        combo.setBounds(150+x+35, 30+y, 120, 25);
        combo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                comboActionPerformed(evt);
            }

            private void comboActionPerformed(ActionEvent evt) {
                valor = (String) combo.getSelectedItem();
            }

        });
        
         id = new JTextField("1");
        id.setFont(new Font("Eras Bold ITC", 4, 20));
        id.setBounds(150+x+35, 70+y, 120, 25);
        pasword.getContentPane().add(id);
        
        paswor = new JPasswordField("1234567");
        paswor.setFont(new Font("Eras Bold ITC", 4, 20));
        paswor.setBounds(150+x+35, 110+y, 120, 25);
        pasword.getContentPane().add(paswor);
        paswor.addKeyListener(new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent evt) {
                if (evt.getKeyCode() == 10) {
                          aceptarActionPerformed();
                }
        }
});
       
        aceptar = new JButton("LOGIN");
        aceptar.setFont(new Font("Eras Bold ITC", 4, 15));
        aceptar.setBounds(15, 160+y+10, 160, 30);
        aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                aceptarActionPerformed();
            }

        });
        pasword.getContentPane().add(aceptar);

        salir = new JButton("CANCELAR");
        salir.setFont(new Font("Eras Bold ITC", 4, 15));
        salir.setBounds(180, 160+y+10, 160, 30);
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
        pasword.getContentPane().add(label);
        pasword.setVisible(true);
    }

    private void aceptarActionPerformed() {
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
