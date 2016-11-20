package Interfaz;

import Administrador.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.util.Date;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import principal.PrincipalNuevo;
//no sirve

public class component {

    private Administrador admin;
    private JFrame frame;
    private JPanel panel2;
    private JTextField TidEmpleado, Tci, Tnombres, TidAuto, Tapellidos, Tnombre, Tfecha, Tname;
    private JButton nuevo, guardar;
    private JLabel idEmpleado, Bnombre, idAuto, Bapellidos, Bci, BCliente, Bfecha;
    private Validacion valida;
    String cargo;

    public component(JFrame frame, String dato, String cargo) {
        this.cargo = cargo;
        admin = Administrador.crearAdministrador("");
        this.frame = frame;
        frame.setTitle("REGISTRO DE VENTA AL CONTADO");
        panel();
       
        editor();
        valida = new Validacion();
        Tfecha.setText(getFechaActual());
        TidAuto.setText(dato);
        
        TidEmpleado.setText(""+admin.getUsuarioConectado());
        imagen();
        frame.add(panel2);
         frame.setVisible(true);
    }

    public String getFechaActual() {
        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("yyyyMMdd");
        return formateador.format(ahora);
    }

    public String getHoraActual() {
        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("hhmmss");
        return formateador.format(ahora);
    }

    private void editor() {
        TidEmpleado = new JTextField();
        TidAuto = new JTextField();
        Tnombres = new JTextField();
        Tapellidos = new JTextField();
        Tnombre = new JTextField();
        Tci = new JTextField();
        Tfecha = new JTextField();
        Tname = new JTextField();
        nuevo = new JButton();
        nuevo.setFont(new Font("Eras Bold ITC", 4, 20));
        nuevo.setText("nuevo");
        nuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                BconfirmaActionPerformed(evt);
            }

        });
        panel2.add(nuevo);
        nuevo.setBounds(400, 500, 120, 50);
        guardar = new JButton();
        guardar.setFont(new Font("Eras Bold ITC", 4, 20));
        guardar.setText("guardar");
        guardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                BgusradrActionPerformed(evt);
            }

        });
        panel2.add(guardar);
        guardar.setBounds(600, 500, 120, 50);

        BCliente = new JLabel();
        BCliente.setFont(new Font("Eras Bold ITC", 4, 35));
        BCliente.setText("DATOS DE LA VENTA POR CONTADO");
        BCliente.setBounds(100,30,700,30);
        panel2.add(BCliente);

        idEmpleado = new JLabel();
        idEmpleado.setFont(new Font("Eras Bold ITC", 4, 20));
        idEmpleado.setText("ID.empleado:");
        panel2.add(idEmpleado);
        idEmpleado.setBounds(5, 150, 150, 20);
        idAuto = new JLabel();
        idAuto.setFont(new Font("Eras Bold ITC", 4, 20));
        idAuto.setText("nombreVehiculo:");
        idAuto.setBounds(5, 200, 150, 20);
        panel2.add(idAuto);

        Bnombre = new JLabel();
        Bnombre.setFont(new Font("Eras Bold ITC", 4, 20));
        Bnombre.setText("Nombre:");
        panel2.add(Bnombre);
        Bnombre.setBounds(5, 250, 150, 20);
        Bapellidos = new JLabel();
        Bapellidos.setFont(new Font("Eras Bold ITC", 4, 20));
        Bapellidos.setText("Apellidos:");
        panel2.add(Bapellidos);
        Bapellidos.setBounds(5, 300, 150, 20);

        Bci = new JLabel();
        Bci.setFont(new Font("Eras Bold ITC", 4, 20));
        Bci.setText("CI:");
        panel2.add(Bci);
        Bci.setBounds(5, 350, 150, 20);
        Bfecha = new JLabel();
        Bfecha.setFont(new Font("Eras Bold ITC", 4, 20));
        Bfecha.setText("Fecha:");
        panel2.add(Bfecha);
        Bfecha.setBounds(5, 400, 150, 20);

        panel2.add(TidAuto);
        TidAuto.setFont(new Font("Eras Bold ITC", 4, 20));
        TidAuto.setEnabled(false);
        TidAuto.setBounds(170, 200, 300, 30);
        panel2.add(Tnombres);
        Tnombres.setFont(new Font("Eras Bold ITC", 4, 20));
        Tnombres.setBounds(170, 250, 300, 30);
        panel2.add(Tci);
        Tci.setFont(new Font("Eras Bold ITC", 4, 20));
        Tci.setBounds(170, 350, 300, 30);
        panel2.add(Tapellidos);
        Tapellidos.setFont(new Font("Eras Bold ITC", 4, 20));
        Tapellidos.setBounds(170, 300, 300, 30);
        panel2.add(TidEmpleado);
        TidEmpleado.setFont(new Font("Eras Bold ITC", 4, 20));
        TidEmpleado.setBounds(170, 150, 300, 30);
        TidEmpleado.setEditable(false);
        Tfecha.setFont(new Font("Eras Bold ITC", 4, 20));
        Tfecha.setEditable(false);
        Tfecha.setBounds(170, 400, 300, 30);
        panel2.add(Tfecha);

    }

    private void BconfirmaActionPerformed(ActionEvent evt) {
        frame.dispose();
        buscadorIDvehiculo buscar = new buscadorIDvehiculo(cargo);

    }

    private void transitarImpresion() {
        String dat[] = new String[5];
        dat[0] = TidEmpleado.getText();
        dat[1] = Tname.getText() + "" + Tapellidos.getText();
        dat[2] = Tci.getText();
        dat[3] = TidAuto.getText();
        dat[4] = Tfecha.getText();
        impresora imp = new impresora(dat);
    }
    GroupLayout grupo2;

    private void panel() {
        panel2 = new JPanel();
        grupo2 = new GroupLayout(panel2);
        panel2.setLayout(grupo2);
        panel2.setBounds(0, 0, 1100, 600);
        panel2.setLayout(null);
    }


    private void BgusradrActionPerformed(ActionEvent evt) {
        String nombre = Tnombres.getText();
        String apellido = Tapellidos.getText();
        int ci = Integer.parseInt(Tci.getText());
        String nombreAuto = TidAuto.getText();
        String fecha = Tfecha.getText();
        int idVendedor=admin.getUsuarioConectado();
        int idAuto=admin.getIdAuto(nombreAuto);
        float precio;
        int id, idVenta;
        //int idEmp, int idAuto, Float precio, String nombre, String apellidos, int ci, String fecha
        if (!nombre.isEmpty() && valida.nombreProveedorValido(nombre)
                && !apellido.isEmpty() && valida.ApellidosValido(apellido)
                && !("" + ci).isEmpty() && valida.CIValido("" + ci)) {
            precio = admin.getPrecioVentaAuto(nombreAuto);
            id = admin.getIdAuto(nombreAuto);
            admin.registrarVentaAutomovil(nombreAuto);
            admin.registrarVentaContado(idVendedor, idAuto, precio, nombre, apellido, ci, fecha);
            
            
            idVenta=admin.getIDUltimaVentaContado();
            admin.ingresarCaja(idVenta, 1, fecha, precio);
//admin.registrarVentaContado(1, id, precio, nombre, apellido, ci, fecha);
            
            JOptionPane.showMessageDialog(null,"TRANSACION REALIZADA CON EXITO");
            frame.dispose();
            transitarImpresion();
            PrincipalNuevo j=new PrincipalNuevo(cargo);
        }
    }
    JLabel fondos;
    private void imagen() {
        fondos = new JLabel(); 
        fondos.setBounds(0,0,1000,600);
        fondos.setIcon(new ImageIcon(getClass().getResource("/Imagen/InterfazMejor.jpg")));
        panel2.add(fondos);
    }

}
