package Administrador;

import BaseDatos.ConexionMySQL;
import java.sql.*;

public class Administrador {
    private static Administrador admin;
    private final String nombre;
    private ConexionMySQL base;
    private Connection cn;
    public static Administrador crearAdministrador(String nombre) {
        if (admin==null) {
            admin=new Administrador(nombre);
        }
        return admin;
    }

    private Administrador(String nombre){
        this.nombre=nombre;
        base = new ConexionMySQL();
        cn = base.Conectar();
        
    }
    public void ingresarEmpleado(String nombre, String apellidos, float sueldo, int ci, String correo, String tipo){
        //despues verificar si crear una tabla de sueldos de acuerdo al tipo 
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
    public void registrarVentaContado(int id){
        //actualizar el stock
        
        /*PreparedStatement pstmt = con.prepareStatement("UPDATE EMPLOYEES
                                     SET SALARY = ? WHERE ID = ?");
        pstmt.setBigDecimal(1, 153833.00)
        pstmt.setInt(2, 110592)*/
        String idd=""+id;
        String ingreso = "update automovil set cantidad = cantidad - 1 where idauto="+idd;
        //String
        int n;
        try{
            PreparedStatement ps=cn.prepareStatement(ingreso);
            n=ps.executeUpdate();
            if(n>0) System.out.println("Funciono");
            else System.out.println("NOOOOO");
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
    }
    public void registrarAutomovil(Float f, int cant, String nombre){
        ConexionMySQL base = new ConexionMySQL();
        Connection cn = base.Conectar();
       
        String ingreso1 = "INSERT INTO automovil"+"(precioauto, cantidad, nombreAuto)"+
                "VALUES(?,?,?)";
        
        try{
            PreparedStatement ps=cn.prepareStatement(ingreso1);
            ps.setFloat(1, f);
            ps.setInt(2, cant);
            ps.setString(3, nombre);
            int n=ps.executeUpdate();
            if(n>0) System.out.println("Funciono");
            else System.out.println("NOOOOO");
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
    }
    public void ingresarCliente(int ci,String nombre, String apellidos, int cuenta, String banco, int telefono, String direccion){
        //despues verificar si crear una tabla de sueldos de acuerdo al tipo 
        ConexionMySQL base = new ConexionMySQL();
        Connection cn = base.Conectar();
        String ingreso1 = "INSERT INTO cliente"+"(ciclie, nombreclie, apellidosclie, cuentaclie, bancoclie, telefonoclie, direcionclie)"+
                "VALUES(?,?,?,?,?,?)";
        try{
            int n;
            PreparedStatement ps=cn.prepareStatement(ingreso1);
            ps.setInt(1, ci);
            ps.setString(2, nombre);
            ps.setString(3, apellidos);
            ps.setInt(4, cuenta);
            ps.setString(5, banco);
            ps.setInt(6, telefono);
            ps.setString(5, direccion);
            n=ps.executeUpdate();
            if(n>0) System.out.println("Funciono");
            else System.out.println("NOOOOO");
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
        
    }
    public void ingresarVentaCredito(String plazo, String estado, float deuda, int idcliente){
        //despues verificar si crear una tabla de sueldos de acuerdo al tipo 
        ConexionMySQL base = new ConexionMySQL();
        Connection cn = base.Conectar();
        String ingreso1 = "INSERT INTO ventacredito"+"(plazoventcred, estadoventcred, deudaventcred, idclie)"+
                "VALUES(?,?,?,?,?,?)";
        try{
            int n;
            PreparedStatement ps=cn.prepareStatement(ingreso1);
            ps.setString(1, plazo);
            ps.setString(2, estado);
            ps.setFloat(3, deuda);
            ps.setInt(4, idcliente);
            n=ps.executeUpdate();
            if(n>0) System.out.println("Funciono");
            else System.out.println("NOOOOO");
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
        
    }
    public void registrar_compra(String nombre, int nit, int id_auto, int costo_unitario, int cantidad_auto, int precio_venta){
        // registra la compra de un conjunto de vehiculos y lo actualiza al numero de vehiculos que ya existen
        ConexionMySQL base = new ConexionMySQL();
        Connection cn = base.Conectar();
        String tabla = "compra_vehiculos";
        String consulta = "INSERT INTO "+tabla+"(Nombre, NIT, ID_Auto, Costo_Unitario, Cantidad, Precio_de_venta)"+
                "VALUES(?,?,?,?,?,?)";
        try{
            int n;
            PreparedStatement ps=cn.prepareStatement(consulta);
            ps.setString(1, nombre);
            ps.setInt(2, nit);
            ps.setInt(3, id_auto);
            ps.setInt(4, costo_unitario);
            ps.setInt(5, cantidad_auto);
            ps.setInt(6, precio_venta);
            n=ps.executeUpdate();
            if(n>0) actualizar_automovil(id_auto, cantidad_auto);
            else System.out.println("NOOOOO");
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
        
    }
    
    private void actualizar_automovil(int id_auto, int cantidad_auto){
        String idd=""+id_auto;
        String ingreso = "update automovil set cantidadauto = cantidadauto+"+cantidad_auto+" where idauto="+idd;
        
        int n;
        try{
            PreparedStatement ps=cn.prepareStatement(ingreso);
            n=ps.executeUpdate();
            if(n>0) System.out.println("Funciono");
            else System.out.println("NOOOOO");
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
        
    }
}

