package Administrador;
/**
 *
 * @author Heredia
 */

import java.util.*;

public class Prueba {
    private static Administrador admin = Administrador.crearAdministrador("concesionario");
    public static void main(String[] args){
        //llenarTablero();
        //admin.RegistrarCliente("7387477575gh", "Alberto", "Cortes Mamani"
        //        , "643783783873", "Banco Union", "72546738", "av. Siempre viva 336");
        //admin.registrarVentaContado(1);
        //admin.ingresarEmpleado("Davor", "Heredia", 100, 342, "jaredAchi@gmail.com", "Vendedor");
        //admin.modificacionEmpleado(200, "luluchan@gmail.com", 100);
        //admin.eliminacionEmpleado(200);
        //admin.reporteVendedoresVentas("20071016");
        Transaccion transaccion = new Transaccion();
        transaccion.ejecutarPagoCliente(1, 100, "1212", 1);
        
    }
    private static void llenarTablero() {
        ArrayList<ArrayList<String>> listaclientes=admin.getClientes();
           for(int i=0;i<listaclientes.size();i++){
               ArrayList<String> fila=listaclientes.get(i);
               for(int j=0;j<fila.size();j++){
                   System.out.print("FILA "+i+" "+j+" "+fila.get(j)+" ");
               }
               System.out.println();
           }
    }
}
