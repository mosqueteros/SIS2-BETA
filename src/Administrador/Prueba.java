package Administrador;
/**
 *
 * @author Heredia
 */
public class Prueba {
    public static void main(String[] args){
        Administrador admin = Administrador.crearAdministrador("");
        admin.registrarVentaContado(1);
        admin.ingresarEmpleado("", "", 1, 1, "", "");
    }
}
