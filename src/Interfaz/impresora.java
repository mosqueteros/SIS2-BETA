package Interfaz;

import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
//conexion con la clase registro de empleado(component)
//ARCHIVO PDF SE CREA AUTOMATICAMENTE EN EL PROYECT
public class impresora {

    private JFrame frame;
    private JScrollPane panelScrol;
    private JTextArea textoPa;
    private archivo documento;
    private JButton imprimiConf;

    public impresora(String[] factura) {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setTitle("impresion de registro de venta de vehiculo");
        componentes();
        frame.setSize(1000, 600);
        frame.setLocationRelativeTo(null);
        editar(factura);
        frame.setResizable(false);
        frame.setVisible(true);
        
    }
    //enviar un cadena de String; poner dispose ala anterrior pantalla
    //eliminar este main
    public static void main(String[] args) {
    String dat[] = new String[6];
    dat[0] = "klg12221";
    dat[1] = "1232111";
    dat[2] = "fernado catorseno vargas";
    dat[3] = "jose maria martines";
    dat[4] = "76211233";
    dat[5] = "tyu1233";
    impresora pantalla = new impresora(dat);
    
    }
    private void componentes() {
        panelScrol = new JScrollPane();
        textoPa = new JTextArea();
        textoPa.setColumns(30);
        textoPa.setRows(5);
        panelScrol.setViewportView(textoPa);
        frame.getContentPane().add(panelScrol);
        panelScrol.setBounds(200, 70, 600, 400);
        textoPa.setFont(new Font("Arial", 3, 18));

        imprimiConf = new JButton();
        imprimiConf.setFont(new Font("Arial", 3, 15));
        imprimiConf.setText("confirmar");
        imprimiConf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                BconfirmaActionPerformed(evt);
            }

        });
        frame.getContentPane().add(imprimiConf);
        imprimiConf.setBounds(450, 500, 120, 50);
        
    }

    public void editar(String[] document) {
        documento = new archivo();
        documento.archivarDocument(document);
        textoPa.setText(documento.GetarchivoRecopilado());
        
    }

    private void BconfirmaActionPerformed(ActionEvent evt) {
        Desktop desktop = Desktop.getDesktop();
        if (desktop.isSupported(Desktop.Action.PRINT)) {
            try {
                File archivo_pdf = new File("Ultima_Impresion.pdf");
                desktop.print(archivo_pdf);
                
            } catch (IOException ex) {
            
            }
            System.exit(0);
        }
    }
}
