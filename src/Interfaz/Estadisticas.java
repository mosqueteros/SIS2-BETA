package Interfaz;

/**
 *
 * @author Heredia
 */

import Administrador.Reporte;
import Administrador.Administrador;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JFrame;
import org.jfree.chart.*;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;


public class Estadisticas {
    
    public static void main(String [] args){
        Estadisticas v = new Estadisticas("20161006",0);
    }

    public Estadisticas(int tipo) {
        
        Administrador admin=Administrador.crearAdministrador("");
        cargarDatos(admin);
        ArrayList<String> fechas=admin.listadoFechasIngresos();
        ArrayList<Float> ingresos=admin.listadoIngresos();
        
        Estadisticas p=new Estadisticas(fechas, ingresos, "Bolivianos", "Fechas", "Ventas diarias", tipo);
        ChartPanel panel = new ChartPanel(p.getGrafica());
        JFrame ventana = new JFrame("");
        ventana.getContentPane().add(panel);
        ventana.pack();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        
    }
    public Estadisticas(String mes,int tipo) {
        
        Administrador admin=Administrador.crearAdministrador("");
        Reporte reporte = new Reporte();
        //cargarDatos(admin);
        System.out.println("entre");
        reporte.reporteVendedoresVentas(mes);
        ArrayList<String> nombres = reporte.getListaVendedores();
        ArrayList<Float> ingresos = reporte.getListaIngresosGenerados();
        
        Estadisticas p=new Estadisticas(nombres, ingresos, "Bolivianos", "Nombres", "Reporte de ventas por vendedor", tipo);
        ChartPanel panel = new ChartPanel(p.getGrafica());
        JFrame ventana = new JFrame("");
        ventana.getContentPane().add(panel);
        ventana.pack();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        
    }
    
    private void cargarDatos(Administrador admin){
        admin.vaciarDatosCaja();
        String fecha="20160113";
        float precio = admin.getPrecioVentaAuto("renault");
        int id = admin.getIdAuto("renault")    ;
        admin.registrarVentaAutomovil("renault");
        admin.registrarVentaContado(4, id, precio, "Gustavo", "Torres", 1234567, fecha);
        int idVenta=admin.getIDUltimaVentaContado();
        admin.ingresarCaja(idVenta, 1, fecha, precio);
        
        fecha="20160713";
        precio = admin.getPrecioVentaAuto("toyota");
        id = admin.getIdAuto("toyota")    ;
        admin.registrarVentaAutomovil("toyota");
        admin.registrarVentaContado(4, id, precio, "Gustavo", "Torres", 1234567, fecha);
        idVenta=admin.getIDUltimaVentaContado();
        admin.ingresarCaja(idVenta, 1, fecha, precio);
        
        fecha="20160120";
        precio = admin.getPrecioVentaAuto("volvo");
        id = admin.getIdAuto("volvo");
        admin.registrarVentaAutomovil("volvo");
        admin.registrarVentaContado(4, id, precio, "Gustavo", "Torres", 1234567, fecha);
        idVenta=admin.getIDUltimaVentaContado();
        admin.ingresarCaja(idVenta, 1, fecha, precio);
    
        fecha="20160322";
        precio = admin.getPrecioVentaAuto("ford");
        id = admin.getIdAuto("ford");
        admin.registrarVentaAutomovil("ford");
        admin.registrarVentaContado(4, id, precio, "Gustavo", "Torres", 1234567, fecha);
        idVenta=admin.getIDUltimaVentaContado();
        admin.ingresarCaja(idVenta, 1, fecha, precio);
    
        fecha="20160402";
        precio = admin.getPrecioVentaAuto("fiat");
        id = admin.getIdAuto("fiat");
        admin.registrarVentaAutomovil("fiat");
        admin.registrarVentaContado(4, id, precio, "Gustavo", "Torres", 1234567, fecha);
        idVenta=admin.getIDUltimaVentaContado();
        admin.ingresarCaja(idVenta, 1, fecha, precio);
    }
    
    Administrador admin;
    JFreeChart grafica;
    DefaultCategoryDataset datos = new DefaultCategoryDataset();
    DefaultCategoryDataset datosL = new DefaultCategoryDataset();
    DefaultPieDataset datosPie = new DefaultPieDataset();
    String nombreP, nombreEje, nombreT;
    
    public Estadisticas(ArrayList<String> nombres, ArrayList<Float> valores, String n1, String n2, String n3, int tipo) {
        anadir(nombres,valores,n1);
        nombreP = n1;
        nombreEje = n2;
        nombreT = n3;
        graficar(tipo);
    }
    
    public void anadir(ArrayList<String> n, ArrayList<Float> v, String n1) {
        for(int i=0; i<n.size(); i++){
            datos.addValue(v.get(i), n.get(i), n.get(i));
            datosL.addValue(v.get(i), n1, n.get(i));
            datosPie.setValue(n.get(i), v.get(i));
        }
    }
    
    public void graficar(int i){
        switch(i){
            case 0: grafica = ChartFactory.createBarChart3D(nombreT, nombreEje, null, datos);
                    grafica.setBackgroundPaint(new Color(255, 204, 51));
                    
                break;
            case 1: grafica = ChartFactory.createLineChart3D(nombreT, nombreEje, null, datosL);
                    grafica.setBackgroundPaint(new Color(255, 204, 51));
                break;
            case 2: grafica = ChartFactory.createPieChart3D(nombreT, datosPie);
                    grafica.setBackgroundPaint(new Color(255, 204, 51));
                break;
        }
       
    }
    
    public JFreeChart getGrafica(){
        return grafica;
    }
    
    public void cambiarValores(ArrayList<String> nombres, ArrayList<Float> valores, String n1, String n2, String n3, int tipo) {
        anadir(nombres,valores,n1);
        nombreP = n1;
        nombreEje = n2;
        nombreT = n3;
        graficar(tipo);
    }
}
