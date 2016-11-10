package Administrador;

import java.util.ArrayList;
import BaseDatos.ConexionMySQL;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    public void modificacionEmpleado(int ci, String correo, float sueldo){
        // modifica sueldo, correo y buscar segun su ci si el sueldo no requiere ser modificado se le envia 0
        
        String idd=""+ci;
        int n;
        PreparedStatement ps;
        String modificacion_sueldo, modificacion_correo;
        
        modificacion_sueldo = "update empleado set sueldo = sueldo+"+sueldo+" where ci="+idd;        
        modificacion_correo = "update empleado set correo = '"+correo+"' where ci="+idd;        
        
        try{
                ps = cn.prepareStatement(modificacion_sueldo);
                n = ps.executeUpdate();
            
            if(!correo.equals("")){
                ps = cn.prepareStatement(modificacion_correo);
                n = ps.executeUpdate();
            }
            
            if(n>0) System.out.println("Funciono");
            else System.out.println("NOOOOO");
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
    }
    public void eliminacionEmpleado(int ci){
        // eliminar un empleado segun su ci
        String idd=""+ci;
        int n;
        PreparedStatement ps;
        String eliminarEmpleado;
        
        eliminarEmpleado = "DELETE FROM empleado where ci="+idd;        
        
        try{
                ps = cn.prepareStatement(eliminarEmpleado);
                n = ps.executeUpdate();
        
            if(n>0) System.out.println("Funciono");
            else System.out.println("NOOOOO");
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
    }
    
    
    
    public void registrarVentaAutomovil(String nombre){
        //actualizar el stock
        
        String ingreso = "update automovil set cantidad = cantidad - 1 where nombreAuto='"+nombre+"'";
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
    
    //para generar el registro de la venta al contado
    public void registrarVentaContado(int idEmp, int idAuto, Float precio, String nombre, String apellidos, int ci, String fecha){
        String ingreso1 = "INSERT INTO ventacontado"+"(idEmp, idAuto, precio, nombre, apellidos, ci, fecha)"+
                "VALUES(?,?,?,?,?,?)";
        try{
            int n;
            PreparedStatement ps=cn.prepareStatement(ingreso1);
            ps.setInt(1, idEmp);
            ps.setInt(2, idAuto);
            ps.setFloat(3, precio);
            ps.setString(4, nombre);
            ps.setString(5, apellidos);
            ps.setInt(6, ci);
            ps.setString(7, fecha);
            n=ps.executeUpdate();
            if(n>0) System.out.println("Funciono");
            else System.out.println("NOOOOO");
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
    }
    
    
    public void registrarAutomovil(Float f, int cant, String nombre){
        
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
    
    public void registrarCliente(String ci,String nombre, String apellidos, int cuenta, String banco, int telefono, String direccion){
        //despues verificar si crear una tabla de sueldos de acuerdo al tipo 
        String ingreso1 = "INSERT INTO cliente"+"(ciclie, nombreclie, apellidosclie, cuentaclie, bancoclie, telefonoclie, direcionclie)"+
                "VALUES(?,?,?,?,?,?)";
        try{
            int n;
            PreparedStatement ps=cn.prepareStatement(ingreso1);
            ps.setString(1, ci);
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
    
    public void modificarCliente(int id,String ci,String nombre, String apellidos, int cuenta, String banco, int telefono, String direccion){
        //despues verificar si crear una tabla de sueldos de acuerdo al tipo 
        String ingreso = "UPDATE cliente SET "+
                "ciclie="+ci+
                ", nombreclie='"+nombre+
                "', apellidosclie='"+apellidos+
                "', cuentaclie="+cuenta+
                ", bancoclie='"+banco+
                "', telefonoclie="+telefono+
                ", direccionclie='"+direccion+
                "' WHERE idclie="+id;
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

    public void eliminarCliente(int id){
        String idd=Integer.toString(id);
        int n;
        PreparedStatement ps;
        String scripteliminacion;
        
        scripteliminacion = "DELETE FROM cliente where idclie="+idd;        
        
        try{
                ps = cn.prepareStatement(scripteliminacion);
                n = ps.executeUpdate();
        
            if(n>0) System.out.println("Funciono");
            else System.out.println("NOOOOO");
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
    }
    public void ingresarVentaCredito(String plazo, String estado, float deuda, int idcliente){
        //despues verificar si crear una tabla de sueldos de acuerdo al tipo 
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
    
    // el ingreso de la fecha debe ser como un numero entero con el año primero
    // luego el mes seguido del dia
    public ArrayList<ArrayList<String>> reporteVendedoresVentas(String date){
        
        ArrayList<ArrayList<String>> vendedores = new ArrayList();
        ArrayList<String> aux;
        
        int mesini = (((Integer.parseInt(date)%10000)/100)*100);
        int mesfin = mesini+50;
        String fechaini = date.substring(0,4)+mesini;
        String fechafin = date.substring(0,4)+mesfin;
        
        String consulta = "SELECT empleado.Nombre AS name, count(*) AS Numero_Ventas FROM ventacontado JOIN empleado ON ventacontado.idEmp = empleado.idEmp WHERE ventacontado.fecha >= '"+ fechaini +"' and ventacontado.fecha <= '"+fechafin +"' GROUP BY ventacontado.idEmp";
        
        String var;
        Statement stmt;
        int pos = 1;
        try {
            stmt = cn.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery(consulta);
            
            while(rs.absolute(pos)){
                
                aux = new ArrayList<String>();
                
                aux.add(rs.getString("name"));
                aux.add(rs.getString("Numero_Ventas"));
                
                vendedores.add(aux);
                pos++;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(int i = 0; i < vendedores.size(); i++){
            System.out.println(vendedores.get(i).get(0)+" - "+vendedores.get(i).get(1));
        }
       
        return vendedores;
    }
    
    
    public ArrayList<String> prueba1(){
        
        ArrayList<String> lista  = new ArrayList();
        String var;
        Statement stmt;
        int pos = 1;
        try {
            stmt = cn.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("SELECT * FROM empleado");
            
            while(rs.absolute(pos)){
                var = rs.getString("Apellidos");
                System.out.println("-> "+var);
                pos++;
            }
            
        
        } catch (SQLException ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return lista;
    }

    public ArrayList<ArrayList<String>> getClientes(){
        ArrayList<ArrayList<String>> lista=new ArrayList<ArrayList<String>>();
        try{
            Statement stmt = cn.createStatement();
            String consulta="SELECT * FROM cliente ORDER BY nombreclie";
            ResultSet rs = stmt.executeQuery(consulta);
            
            String id;
            String ci;
            String nombre;
            String apellidos;
            String cuenta;
            String banco;
            String telefono;
            String direccion;
            while(rs.next()){
                ArrayList<String> fila= new ArrayList<String>();
                id=Integer.toString(rs.getInt("idclie"));
                ci=rs.getString("ciclie");
                nombre=rs.getString("nombreclie");
                apellidos=rs.getString("apellidosclie");
                cuenta=Integer.toString(rs.getInt("cuentaclie"));
                banco=rs.getString("bancoclie");
                telefono=Integer.toString(rs.getInt("telefonoclie"));
                direccion=rs.getString("direccionclie");
                fila.add(id);
                fila.add(ci);
                fila.add(nombre);
                fila.add(apellidos);
                fila.add(cuenta);
                fila.add(banco);
                fila.add(telefono);
                fila.add(direccion);
                lista.add(fila);
            }
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
        return lista;
    }
    
    public ArrayList<String> getListaAutos(){
        ArrayList<String> lista=new ArrayList<String>();
        try{
            Statement stmt = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String consulta="SELECT nombreAuto FROM automovil";
            ResultSet rs = stmt.executeQuery(consulta);
            //int[] lista=rs.getArray("nombreAuto");
            System.out.println("Hello");
            int p=1;
            String nombre;
            while(rs.absolute(p)){
                nombre=rs.getString("nombreAuto");
                lista.add(nombre);
                p++;
            }
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
        return lista;
    }
    
    public int getStock(String nombre){
        int stock=0;
        try{
            Statement stmt = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String consulta="SELECT cantidad FROM automovil where nombreAuto='"+nombre+"'";
            ResultSet rs = stmt.executeQuery(consulta);
            rs.absolute(1);
            String res=rs.getString("cantidad");
            stock=Integer.parseInt(res);
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
        return stock;
    }
    public float getPrecioAuto(String nombre){
        float precio=0;
        try{
            Statement stmt = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String consulta="SELECT precioauto FROM automovil where nombreAuto='"+nombre+"'";
            ResultSet rs = stmt.executeQuery(consulta);
            rs.absolute(1);
            String res=rs.getString("precioauto");
            precio=Float.parseFloat(res);
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
        return precio;
    }
    
    public int getIdAuto(String nombre){
        int id=0;
        try{
            Statement stmt = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String consulta="SELECT idauto FROM automovil where nombreAuto='"+nombre+"'";
            ResultSet rs = stmt.executeQuery(consulta);
            rs.absolute(1);
            String res=rs.getString("idauto");
            id=Integer.parseInt(res);
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
        return id;
    }
    
   
    
    //a partir de aca nuevo comit 4EJ
    public int getCIEmpleado(int id){
        int ci=-1;
        try{
            Statement stmt = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String consulta="SELECT ci FROM empleado where idEmp="+id+"";
            ResultSet rs = stmt.executeQuery(consulta);
            if(rs.absolute(1)){
                ci=rs.getInt("ci");
            }
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
        return ci;
    }
    
    public String getTipoEmpleado(int id){
        String tipoEmpleado="";
        try{
            Statement stmt = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String consulta="SELECT tipo FROM empleado where idEmp="+id+"";
            ResultSet rs = stmt.executeQuery(consulta);
            if(rs.absolute(1)){
                tipoEmpleado=rs.getString("tipo");
            }
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
        return tipoEmpleado;
    }
    //al momento de realizar la compra hay que verificar si hay dinero suficiente
    public void ingresarCaja(float dinero, String fecha, int tipo, int id){
        //el tipo y el id lo manejo, para si el caso de querer saber los detalles de la compra o venta
        //tipo1-> ventaContado
        //tipo2-> compraProveedores
        //tipo3-> ventaCredito
        String ingreso1 = "INSERT INTO caja"+"(idVentaCompra, tipoVentaCompra,fecha, dinero)"+
                "VALUES(?,?,?,?)";
        try{
            int n;
            PreparedStatement ps=cn.prepareStatement(ingreso1);
            ps.setInt(1, id);
            ps.setInt(2, tipo);
            ps.setString(3, fecha);
            ps.setFloat(4, dinero);
            n=ps.executeUpdate();
            if(n>0) System.out.println("Funciono");
            else System.out.println("NOOOOO");
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
    }
    
    public float dineroDisponibleCaja(){
        String consulta = "SELECT sum(dinero) AS disponible FROM caja";
        float dineroDisponible=0;
        try {
            
            Statement st = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery(consulta);
            if(rs.absolute(1)){
                dineroDisponible=rs.getFloat("disponible");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dineroDisponible;
    }
    
    
    public ArrayList<Float> listadoIngresos(){
        String consulta = "SELECT caja.fecha AS fecha, count(*) AS numVentas, sum(dinero) AS suma FROM caja " +"WHERE caja.tipoVentaCompra<>2"+ " GROUP BY caja.fecha";
        ArrayList<Float> lista=new ArrayList<Float>();
        try {
            
            Statement st = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery(consulta);
            int p=1;
            while(rs.absolute(p)){
                lista.add(rs.getFloat("suma"));
                p++;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    public ArrayList<Float> listadoEgresos(){
        String consulta = "SELECT caja.fecha AS fecha, count(*) AS numVentas, sum(dinero) AS suma FROM caja " +"WHERE caja.tipoVentaCompra=2"+ " GROUP BY caja.fecha";
        ArrayList<Float> lista=new ArrayList<Float>();
        try {
            Statement st = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery(consulta);
            int p=1;
            while(rs.absolute(p)){
                lista.add(rs.getFloat("suma"));
                p++;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
}

