package Administrador;
/**
 *
 * @author Heredia
 */

import java.util.ArrayList;

public class Prueba {
    public static void main(String[] args){
        Administrador admin = Administrador.crearAdministrador("concesionario");
        //AdministradorBD admin = new AdministradorBD();
        //admin.RegistrarCliente("7387477575gh", "Alberto", "Cortes Mamani"
        //        , "643783783873", "Banco Union", "72546738", "av. Siempre viva 336");
        //admin.registrarVentaContado(1);
        //admin.ingresarEmpleado("Davor", "Heredia", 100, 342, "jaredAchi@gmail.com", "Vendedor");
        //admin.modificacionEmpleado(200, "luluchan@gmail.com", 100);
        //admin.eliminacionEmpleado(200);
        admin.reporteVendedoresVentas("20071016");
        
    }
}
