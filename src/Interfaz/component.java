package Interfaz;

import Administrador.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.util.Date;
import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class component {

    private JFrame frame;
    private JPanel panel2;
    private JTextField TidEmpleado, Tci, Tnombres, TidAuto, Tapellidos, Tnombre, Tfecha,Tname;
    private JButton nuevo, guardar;
    private JLabel idEmpleado, Bnombre, idAuto, Bapellidos, Bci, BCliente, Bfecha;
    private Validacion valida;
    private JTable tablero;
    private JScrollPane nombreColumnas;

    public component(JFrame frame, String dato) {
        this.frame = frame;
        panel();
        tablavehiculos();
        editor();
        valida=new Validacion();
        Tfecha.setText(getFechaActual() + "            " + getHoraActual() + " horas");
        TidAuto.setText(dato);
        frame.add(panel2);
    }

    public String getFechaActual() {
        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");
        return formateador.format(ahora);
    }

    public String getHoraActual() {
        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("hh:mm:ss");
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
        Tname=new JTextField();
        nuevo = new JButton();
        nuevo.setFont(new Font("Arial", 4, 15));
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
        guardar.setFont(new Font("Arial", 4, 15));
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
        BCliente.setFont(new Font("Arial", 4, 20));
        BCliente.setText("DATOS DE LA VENTA POR CONTADO");
        BCliente.setBounds(300, 5, 400, 30);
        panel2.add(BCliente);

        idEmpleado = new JLabel();
        idEmpleado.setFont(new Font("Arial", 4, 15));
        idEmpleado.setText("ID.empleado:");
        panel2.add(idEmpleado);
        idEmpleado.setBounds(5, 150, 100, 20);
        idAuto = new JLabel();
        idAuto.setFont(new Font("Arial", 4, 15));
        idAuto.setText("nombreVehiculo:");
        idAuto.setBounds(5, 200, 100, 20);
        panel2.add(idAuto);

        Bnombre = new JLabel();
        Bnombre.setFont(new Font("Arial", 4, 15));
        Bnombre.setText("Nombre:");
        panel2.add(Bnombre);
        Bnombre.setBounds(5, 250, 100, 20);
        Bapellidos = new JLabel();
        Bapellidos.setFont(new Font("Arial", 4, 15));
        Bapellidos.setText("Apellidos:");
        panel2.add(Bapellidos);
        Bapellidos.setBounds(5, 300, 100, 20);
        
        Bci = new JLabel();
        Bci.setFont(new Font("Arial", 4, 15));
        Bci.setText("CI:");
        panel2.add(Bci);
        Bci.setBounds(5, 350, 100, 20);
        Bfecha = new JLabel();
        Bfecha.setFont(new Font("Arial", 4, 15));
        Bfecha.setText("Fecha:");
        panel2.add(Bfecha);
        Bfecha.setBounds(5, 400, 100, 20);

        panel2.add(TidAuto);
        TidAuto.setFont(new Font("Arial", 4, 15));
        TidAuto.setEnabled(false);
        TidAuto.setBounds(100, 200, 300, 30);
        panel2.add(Tnombres);
        Tnombres.setFont(new Font("Arial", 4, 15));
        Tnombres.setBounds(100, 250, 300, 30);
        panel2.add(Tci);
        Tci.setFont(new Font("Arial", 4, 15));
        Tci.setBounds(100, 350, 300, 30);
        panel2.add(Tapellidos);
        Tapellidos.setFont(new Font("Arial", 4, 15));
        Tapellidos.setBounds(100, 300, 300, 30);
        panel2.add(TidEmpleado);
        TidEmpleado.setFont(new Font("Arial", 4, 15));
        TidEmpleado.setBounds(100, 150, 300, 30);
        TidEmpleado.setEnabled(false);
        Tfecha.setFont(new Font("Arial", 4, 15));
        Tfecha.setEnabled(false);
        Tfecha.setBounds(100, 400, 300, 30);
        panel2.add(Tfecha);



       

    }

    private void BconfirmaActionPerformed(ActionEvent evt) {
        buscadorIDvehiculo buscar = new buscadorIDvehiculo();
        frame.dispose();
    }

    private void transitarImpresion() {
        String dat[] = new String[5];
        dat[0] = TidEmpleado.getText();
        dat[1] = TidEmpleado.getText();
        dat[2] = Tnombre.getText() + "" + Tapellidos.getText();
        dat[3] = Tci.getText();
        dat[4] = TidAuto.getText();
        impresora imp = new impresora(dat);
    }

    private void tablavehiculos() {
        tablero = new JTable();
        nombreColumnas = new JScrollPane();
        nombreColumnas.setFont(new Font("OCR A Extended", 3, 14));
        tablero.setModel(new DefaultTableModel(
                new Object[][]{//matriz
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null}},
                new String[]{
                    "ID empleando", "ID auto", "nombreClient", "apellidosClient", "CIClient", "fecha"
                }
        ) {
            Class[] tipo = new Class[]{
                String.class, String.class, String.class, String.class, String.class, String.class
            };
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false
            };

            @Override
            public Class getColumnClass(int columnIndex) {
                return tipo[columnIndex];
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        });
        TableroErramientas();
        nombreColumnas.setViewportView(tablero);
        inavalidarPosicionesTablero();
        nombreColumnas.setBounds(500, 90, 453, 300);
        panel2.add(nombreColumnas);
    }

    private void TableroErramientas() {
        tablero.setToolTipText("registro de venta");
        tablero.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
        tablero.setGridColor(new Color(0, 0, 0));
        tablero.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tablero.getTableHeader().setReorderingAllowed(false);
        tablero.addMouseListener(new MouseAdapter() {//la accion
            @Override
            public void mouseClicked(MouseEvent evt) {
                tableroMouseClicked(evt);
            }
        });
    }

    private void inavalidarPosicionesTablero() {
        if (tablero.getColumnModel().getColumnCount() > 0) {
            tablero.getColumnModel().getColumn(0).setResizable(false);
            tablero.getColumnModel().getColumn(1).setResizable(false);
            tablero.getColumnModel().getColumn(2).setResizable(false);
            tablero.getColumnModel().getColumn(3).setResizable(false);
            tablero.getColumnModel().getColumn(4).setResizable(false);
            tablero.getColumnModel().getColumn(5).setResizable(false);
        }
        anadir(tablero);

    }

    private void tableroMouseClicked(MouseEvent evt) {

        int pos = tablero.getSelectedRow();
        TableModel model = tablero.getModel();
        if (model.getValueAt(pos, 3).toString() != "") {
            String aux = "";
            aux = model.getValueAt(pos, 0).toString();
            TidEmpleado.setText(aux);
            aux = model.getValueAt(pos, 1).toString();
            TidAuto.setText(aux);
            aux = model.getValueAt(pos, 2).toString();
            Tnombres.setText(aux);
            aux = model.getValueAt(pos, 3).toString();
            Tapellidos.setText(aux);
            aux = model.getValueAt(pos, 4).toString();
            Tci.setText(aux);
            aux = model.getValueAt(pos, 5).toString();
            Tfecha.setText(aux);
        }

    }
    GroupLayout grupo2;

    private void panel() {
        panel2 = new JPanel();
        grupo2 = new GroupLayout(panel2);
        panel2.setLayout(grupo2);
        panel2.setBackground(Color.LIGHT_GRAY);
        panel2.setBounds(0, 0, 1000, 600);
        panel2.setLayout(null);
    }

    private void anadir(JTable tablero) {
        tablero.setValueAt("edv", 0, 0);
        tablero.setValueAt("edasd", 0, 1);
        tablero.setValueAt("asdsa", 0, 2);
        tablero.setValueAt("daf", 0, 3);
        tablero.setValueAt("fsd", 0, 4);
        tablero.setValueAt("fsd", 0, 5);
        tablero.setValueAt("edfsdu", 1, 0);
        tablero.setValueAt("edsf", 1, 1);
        tablero.setValueAt("esss", 1, 2);
        tablero.setValueAt("aaa", 1, 3);
        tablero.setValueAt("sss", 1, 4);
        tablero.setValueAt("fsd", 1, 5);
        tablero.setValueAt("eyyy", 2, 0);
        tablero.setValueAt("esd", 2, 1);
        tablero.setValueAt("eyyy", 2, 2);
        tablero.setValueAt("eyyy", 2, 3);
        tablero.setValueAt("eyyy", 2, 4);
        tablero.setValueAt("eyyy", 2, 5);
    }

    private void BgusradrActionPerformed(ActionEvent evt) {
        if(!Tnombres.getText().isEmpty() && valida.nombreProveedorValido(Tnombres.getText())&&
                !Tapellidos.getText().isEmpty() && valida.ApellidosValido(Tapellidos.getText())&&
                        !Tci.getText().isEmpty() && valida.CIValido(Tci.getText())){
                        System.out.println("listo");
        }
    }

}
