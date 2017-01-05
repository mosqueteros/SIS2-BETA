
import java.awt.event.ActionEvent;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class registroPagosEmpleados {//clase prueba

    public registroPagosEmpleados() {
        //nos imaginamos que ya existe la clase

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

    public boolean validoTeclado(char dato) {
        boolean salida = false;
        if (dato >= 'a' && dato <= 'z' || dato >= '0' && dato <= '9' || dato >= 'A' && dato <= 'Z') {
            salida = true;
        }
        return salida;
    }

    public boolean accionBotonAceptar(String nombre, String ci, String tipo, String fecha, String dinero) {
        boolean salida = false;
        if (verificarString(nombre)) {
            if (verificarNumero(ci)) {
                if (verificarString(tipo)) {
                    if (verificarFecha(fecha)) {//"12/2/2016"
                        if (verificarNumero(dinero)) {
                            salida = true;
                            JOptionPane.showMessageDialog(null, "bien ingersado");
                        } else {
                            System.out.println("monto Error");
                        }
                    } else {
                        System.out.println("fecha pago Error");
                    }
                } else {
                    System.out.println("tipoEmpleado Error");
                }
            } else {
                System.out.println("ci Error");
            }
        } else {
            System.out.println("noombre Error");
        }
        return salida;
    }

    public void accionBotonCancelar(ActionEvent evt) {
        System.exit(0);

    }
    //"eduardo","123132","cajero","12d112015", "2200

    public boolean verificarString(String text) {
        boolean salida = true;
        if (!text.isEmpty()) {
            char[] elementos = text.toCharArray();
            for (int i = 0; i < elementos.length; i++) {
                if ((elementos[i] >= 48 && elementos[i] <= 57)) {
//Si es numero
                    salida = false;
                }
            }
        }

        return salida;
    }

    public boolean verificarNumero(String text) {
        boolean salida = true;
        if (!text.isEmpty()) {
             char[] elementos = text.toCharArray();
        for (int i = 0; i < elementos.length; i++) {
            if ((elementos[i] <48 || elementos[i] >57)) {//Si no es numero
                salida = false;
            }
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

    public boolean verificarFecha(String text) {
        //boolean salida = true;
        //int cont=0;
        char [] caracteres = text.toCharArray();
        if (!text.isEmpty()) {
            if(text.length() == 10){
                if (caracteres[4]=='/'){
                    if(caracteres[7]== '/'){
                        return true;
                    }
                        
                }
            }
        }

        return false;
    }

}
