package Interfaz;

import Administrador.Administrador;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class RegistroBanco {

    JFrame Frame;
    JPanel panel;

    JLabel nombreLabel;
    JLabel tituloLabel;

    JTextField nombre;

    ArrayList<String> parametros;
    ArrayList<JLabel> labels;
    ArrayList<JTextField> textFields;

    int saltoLinea;
    int columnaUno;
    int columnaDos;
    int tamanoLabel;

    String cargo;
    String fuenteLabel;
    String fuenteTextField;

    JButton confirmarBoton;
    JButton cancelarBoton;

    public static void main(String[] args) {
        RegistroBanco v = new RegistroBanco();
    }

    public RegistroBanco() {
        Frame = new JFrame();

        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame.setResizable(false);
        Frame.getContentPane().setLayout(null);

        inicializarEstandares();
        inicializarPanel();
        inicializarEstandares();

        inicializarBotones();
        inicializarLabels();

        inicializarTextFields();

        Frame.pack();
        Frame.setSize(450, 500);
        Frame.setLocationRelativeTo(null);
        Frame.setVisible(true);
        nombre.repaint();
    }

    public void inicializarEstandares() {
        saltoLinea = 50;
        columnaUno = 55;
        columnaDos = 150;
        fuenteLabel = "Eras Bold ITC";
        fuenteTextField = "Eras Bold ITC";
        tamanoLabel = 20;
    }

    public void inicializarLabels() {
        tituloLabel = new JLabel("REGISTRAR BANCO");
        nombreLabel = new JLabel("Nombre: ");
        labels = new ArrayList<>();
        labels.add(nombreLabel);
        anadirLabels();
        JLabel label = new JLabel();
        label.setBounds(0, 0, 450, 500);
        label.setIcon(new ImageIcon(getClass().getResource("/Imagen/InterfazMejor.jpg")));
        Frame.getContentPane().add(label);
    }

    private void anadirLabels() {
        tituloLabel.setBounds(columnaUno, 20, 400, 45);
        tituloLabel.setForeground(Color.LIGHT_GRAY);
        tituloLabel.setFont(new Font(fuenteLabel, 4, 30));
        Frame.getContentPane().add(tituloLabel);
        int y = 130;
        for (int j = 0; j < labels.size(); j++) {
            JLabel actual = labels.get(j);
            actual.setForeground(Color.LIGHT_GRAY);
            actual.setFont(new Font(fuenteLabel, 4, tamanoLabel));
            actual.setBounds(columnaUno, y, 200, 40);
            y += saltoLinea;
            Frame.getContentPane().add(actual);
        }
    }

    public void inicializarTextFields() {
        nombre = new JTextField();
        textFields = new ArrayList<>();
        textFields.add(nombre);
        anadirTextFields();
    }

    private void anadirTextFields() {
        int y = 130;
        for (int j = 0; j < textFields.size(); j++) {
            JTextField actual = textFields.get(j);
            actual.setFont(new Font(fuenteTextField, 4, tamanoLabel));
            actual.setBounds(columnaDos, y, 200, 40);
            actual.setBorder(new LineBorder(Color.GRAY));
            y += saltoLinea;
            Frame.getContentPane().add(actual);
        }

    }

    private void inicializarPanel() {

        panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setBounds(0, 0, 500, 500);

    }

    private void inicializarBotones() {
        Administrador admin = Administrador.crearAdministrador("");
        confirmarBoton = new JButton("Confirmar");
        confirmarBoton.setFont(new Font(fuenteLabel, 4, tamanoLabel));
        confirmarBoton.setBounds(columnaUno, 320, 150, 40);
        confirmarBoton.addActionListener(new ActionListener() {
            Validacion v = new Validacion();

            @Override
            public void actionPerformed(ActionEvent e) {
                if (v.ApellidosValido(nombre.getText())) {
                    boolean resp = admin.registrarBanco(nombre.getText());
                    if (resp) {
                        JOptionPane.showMessageDialog(null, "Registro realizado con éxito");
                    }

                    Frame.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Datos incorrectos, por favor, revise");

                }
            }

        });
        cancelarBoton = new JButton("Cancelar");
        cancelarBoton.setBounds(columnaDos + 60, 320, 150, 40);
        cancelarBoton.setFont(new Font(fuenteLabel, 4, tamanoLabel));
        Frame.getContentPane().add(confirmarBoton);
        cancelarBoton.addActionListener(new ActionListener() {
            Validacion v = new Validacion();

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Cancelado");
                Frame.dispose();
            }

        });
        Frame.getContentPane().add(cancelarBoton);
    }
}
