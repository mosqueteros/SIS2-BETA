/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Administrador.Administrador;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import principal.PrincipalNuevo;

public class registroBanc extends JFrame {

    JLabel titulo = new JLabel("REGISTRO DE BANCO");
    JLabel nombre = new JLabel("nombre :");
    JTextField nombres = new JTextField();
    JButton aceptar = new JButton("CONFIRMAR");
    JButton cancelar = new JButton("CANCELAR");
    String cargo;
           String fuenteTextField = "Eras Bold ITC";
    public registroBanc(String cargo) {
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setUndecorated(true);
        this.cargo=cargo;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);
        this.setSize( 450, 500);
        titulo.setBounds(50,5, 400, 60);

        nombre.setBounds(5, 100, 200, 30);
       
        nombres.setBounds(100, 100, 250, 30);
        
        creaEventoTeclado(nombres);
      
        aceptar.setBounds(5, 300, 150, 40);
        
        
        titulo.setForeground(Color.white);
        nombre.setForeground(Color.white);

	titulo.setFont(new Font("Eras Bold ITC", 4, 20));

        nombre.setFont(new Font("Eras Bold ITC", 4, 20));

        nombres.setFont(new Font("Eras Bold ITC", 4, 20));

        
        aceptar.setFont(new Font("Eras Bold ITC", 4, 20));
         Administrador admin = Administrador.crearAdministrador("");
Validacion v = new Validacion();
        aceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (v.ApellidosValido(nombre.getText())) {
                    boolean resp = admin.registrarBanco(nombre.getText());
                    if (resp) {
                        JOptionPane.showMessageDialog(null, "Registro realizado con éxito");
                        PrincipalNuevo c=new PrincipalNuevo(cargo);
                    }

                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Datos incorrectos, por favor, revise");

                }
            }

        });
        cancelar.setBounds(200, 300, 150, 40);
        cancelar.setFont(new Font("Eras Bold ITC", 4, 20));

        cancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                accionBotonCancelar(evt);
            }

        });
        this.getContentPane().add(titulo);
        this.getContentPane().add(nombres);


        this.getContentPane().add(nombre);

        this.getContentPane().add(aceptar);
        this.getContentPane().add(cancelar);
        this.setLocationRelativeTo(null);
        
        JLabel fondos;
        fondos = new JLabel(); 
        fondos.setBounds(0,0, 450, 500);
        fondos.setIcon(new ImageIcon(getClass().getResource("/Imagen/InterfazMejor.jpg")));
        this.add(fondos);
        this.setVisible(true);
        this.setUndecorated(false);
    }

    public void creaEventoTeclado(JTextField texto) {
        texto.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                ControlDeteclas(evt);
            }
        });
    }

    private void ControlDeteclas(KeyEvent evt) {
        char dato = evt.getKeyChar();
        if (!validoTeclado(dato)) {

        }
    }

    public static void main(String[] a) {
        registroBanc n = new registroBanc("GERENTE");
        
    }

    private boolean validoTeclado(char dato) {
        boolean salida = false;
        if (dato >= 'a' && dato <= 'z') {
            salida = true;
        }
        return salida;
    }


    private void accionBotonCancelar(ActionEvent evt) {
        this.dispose();
        PrincipalNuevo p = new PrincipalNuevo(cargo);

                

    }

    private boolean verificarString(String text) {
        boolean salida =false;
        char[] elementos = text.toCharArray();
        for (int i = 0; i < elementos.length; i++) {
            if (!(elementos[i] >= 48 && elementos[i] <=59)) {
                salida =true;
            }
        }
        return salida;
    }

    private boolean verificarNumero(String text) {
        boolean salida = false;
        char[] elementos = text.toCharArray();
        for (int i = 0; i < elementos.length; i++) {
            if (!(elementos[i] <= 48 || elementos[i] >= 59)) {
                salida =true;
            }
        }
        return salida;
    }

    private boolean verificarFecha(String text) {
        boolean salida = true;
        if(!text.isEmpty()){
        String[] elementos = text.split("/");
        int num;//
        for (int i = 0; i < elementos.length; i++) {
            try {
                num=Integer.parseInt(elementos[i]);
                if (!(num>=0 && num<=9999)) {
                salida =false;
            }
            } catch (Exception e) {
                System.out.println("texto erroneo");
            }
        }
        }
        
        return salida;
    }
}
