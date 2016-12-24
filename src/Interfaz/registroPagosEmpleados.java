/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class registroPagosEmpleados extends JFrame {

    JLabel titulo = new JLabel("REGISTRO DE PAGOS A CLIENTES");
    JLabel nombre = new JLabel("nombre :");
    JLabel ci = new JLabel("Ci :");
    JLabel tipoEmpleado = new JLabel("tipo de empleado :");
    JLabel fechaPago = new JLabel("fecha de Pago :");
    JLabel montoPagado = new JLabel("monto a Pagar :");
    JTextField nombres = new JTextField();
    JTextField cis = new JTextField();
    JTextField tipoEmpleados = new JTextField();
    JTextField fechaPagos = new JTextField();
    JTextField montoPagados = new JTextField();
    JButton aceptar = new JButton("pagar");
    JButton cancelar = new JButton("cancelar");

    public registroPagosEmpleados() {
        int posY = 0, posX = 100, posX1 = 25, posY1 = 0;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);
        this.setSize(600, 400);
        posX += 50;
        posY1 += 50;
        titulo.setBounds(posX, posY, 400, 60);
        posX += 50;
        posY += 50;
        nombre.setBounds(posX1, posY1, 200, 30);
        posY1 += 50;
        nombres.setBounds(posX, posY, 200, 30);
        posY += 50;
        creaEventoTeclado(nombres);
        ci.setBounds(posX1, posY1, 200, 30);
        posY1 += 50;
        cis.setBounds(posX, posY, 200, 30);
        posY += 50;
        creaEventoTeclado(cis);
        tipoEmpleado.setBounds(posX1, posY1, 200, 30);
        posY1 += 50;
        tipoEmpleados.setBounds(posX, posY, 200, 30);
        posY += 50;
        fechaPago.setBounds(posX1, posY1, 200, 30);
        posY1 += 50;
        fechaPagos.setBounds(posX, posY, 200, 30);
        posY += 50;
        montoPagado.setBounds(posX1, posY1, 200, 30);
        posY1 += 50;
        montoPagados.setBounds(posX, posY, 200, 30);
        posY += 50;
        aceptar.setBounds(posX, posY, 100, 30);
        posX += 50;
        posX += 50;
        aceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                accionBotonAceptar(evt);
            }

        });
        cancelar.setBounds(posX, posY, 100, 30);
        cancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                accionBotonCancelar(evt);
            }

        });
        this.getContentPane().add(titulo);
        this.getContentPane().add(nombres);
        this.getContentPane().add(cis);
        this.getContentPane().add(tipoEmpleados);
        this.getContentPane().add(fechaPagos);
        this.getContentPane().add(montoPagados);

        this.getContentPane().add(nombre);
        this.getContentPane().add(ci);
        this.getContentPane().add(tipoEmpleado);
        this.getContentPane().add(fechaPago);
        this.getContentPane().add(montoPagado);

        this.getContentPane().add(aceptar);
        this.getContentPane().add(cancelar);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

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
            //System.out.println(false);
            eliminarCaract();
        }
    }

    public static void main(String[] a) {
        registroPagosEmpleados n = new registroPagosEmpleados();

    }

    private boolean validoTeclado(char dato) {
        boolean salida = false;
        if (dato >= 'a' && dato <= 'z') {
            salida = true;
        }
        return salida;
    }

    private void accionBotonAceptar(ActionEvent evt) {
        if (verificarString(nombres.getText())) {
            if (verificarNumero(cis.getText())) {
                if (verificarString(tipoEmpleados.getText())) {
                    if (verificarFecha(fechaPagos.getText())) {
                        if (verificarNumero(montoPagados.getText())) {
                            JOptionPane.showMessageDialog(null,"bien ingersado");
                        }
                        else{
                            System.out.println("monto Error");
                        }
                    }
                    else{
                        System.out.println("fecha pago Error");
                    }
                }
                else{
                    System.out.println("tipoEmpleado Error");
                }
            }
            else{
            System.out.println("ci Error");
            }
        }
        else{
            System.out.println("noombre Error");
        }

    }

    private void accionBotonCancelar(ActionEvent evt) {
        System.exit(0);

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

    private void eliminarCaract() {
        //donde eliminar el ultimo caracter ingresado
        
       // String salida=texto.getText();
        //salida=salida.split(0, texto.length()-1);
        //texto.setText(salida);
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
