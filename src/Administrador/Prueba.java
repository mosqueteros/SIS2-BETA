package Administrador;
/**
 *
 * @author Heredia
 */
public class Prueba {
    public static void main(String[] args){
        Administrador admin = Administrador.crearAdministrador("concesionario");
        //AdministradorBD admin = new AdministradorBD();
        //admin.RegistrarCliente("7387477575gh", "Alberto", "Cortes Mamani"
        //        , "643783783873", "Banco Union", "72546738", "av. Siempre viva 336");
        //admin.registrarVentaContado(1);
        //admin.ingresarEmpleado("", "", 1, 1, "", "");
        //admin.modificacionEmpleado(200, "luluchan@gmail.com", 100);
        admin.eliminacionEmpleado(200);
    }
}
