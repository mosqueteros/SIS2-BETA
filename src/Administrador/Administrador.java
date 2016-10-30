package Administrador;
import BaseDatos.ConexionMySQL;
import java.sql.*;

public class Administrador {
    private static Administrador admin;
    private final String nombre;
    public static Administrador crearAdministrador(String nombre) {
        if (admin==null) {
            admin=new Administrador(nombre);
        }
        return admin;
    }

    private Administrador(String nombre){
        //base.cargar("baseVacia.xml");
        this.nombre=nombre;
        //init();
    }
    public void ingresarEmpleado(String nombre, String apellidos, float sueldo, int ci, String correo, String tipo){
        //despues verificar si crear una tabla de sueldos de acuerdo al tipo 
        ConexionMySQL base = new ConexionMySQL();
        Connection cn = base.Conectar();
        String ingreso1 = "INSERT INTO empleado"+"(Nombre, Apellidos, sueldo, ci, correo, tipo)"+
                "VALUES(?,?,?,?,?,?)";
        try{
            int n;
            PreparedStatement ps=cn.prepareStatement(ingreso1);
            ps.setString(1, nombre);
            ps.setString(2, apellidos);
            ps.setFloat(3, sueldo);
            ps.setInt(4, ci);
            ps.setString(5, correo);
            ps.setString(6, tipo);
            n=ps.executeUpdate();
            if(n>0) System.out.println("Funciono");
            else System.out.println("NOOOOO");
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
        
    }
}
