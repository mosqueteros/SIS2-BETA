
package Administrador;

/**
 *
 * @author Shirley
 */

import java.sql.*;

public class AdministradorBD {
    Connection con;
    ResultSet rs;

    public AdministradorBD() {  
   try {
      Class.forName("com.mysql.jdbc.Driver");
      con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/concesionario",
      "root", "");
   } catch (ClassNotFoundException | SQLException e) {
      System.out.println("Error: " + e.getMessage());
      }
   }

    public void RegistrarCliente(String ci,String nombre, String apellidos
            , String cuenta, String banco, String telefono, String direccion){
      
        String insertar = "INSERT INTO cliente VALUES (default,'"
                +ci+"','"
                +nombre+"','"
                +apellidos+"','"
                +cuenta+"','"
                +banco+"','"
                +telefono+"','"
                +direccion+"')";
        try{
            Statement stat = con.createStatement();
            stat.executeUpdate(insertar);
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
        
    }
}