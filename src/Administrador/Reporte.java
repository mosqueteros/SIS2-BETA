/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administrador;

import BaseDatos.ConexionMySQL;
import Interfaz.Validacion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author migi
 */
public class Reporte {
    
    private ConexionMySQL base;
    private Connection cn;
    private ArrayList<String> nombres ;
    private ArrayList<Float> ingresos ;
        
    public Reporte(){
        base = new ConexionMySQL();
        cn = base.Conectar();
    }
    
    public boolean existeCiVendedor(int ci){
        boolean existe = false;
        String consulta = "SELECT * FROM empleado "
                + " WHERE empleado.tipo = 'VENDEDOR' and ci = "+ci;
        try {
            Statement st = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery(consulta);
            int p=1;
            while(rs.absolute(p)){
                existe = true;
                p++;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return existe;
        
    }
    
    public ArrayList<ArrayList<String>> reporteVentasVendedor(int ci){
        
        ArrayList<ArrayList<String>> tabladeventas = null;
        
        if(existeCiVendedor(ci)){
            tabladeventas = obtenerReporteVendedor(ci);
        }
        
        return tabladeventas;
    }
    private ArrayList<ArrayList<String>> obtenerReporteVendedor(int ci){
         
        ArrayList<ArrayList<String>> answer = new ArrayList();
        ArrayList<String> aux;
        String consulta = "SELECT * ,sum(precio) as gananciaTotal FROM ventacontado "
                + " JOIN empleado ON ventacontado.idEmp = empleado.idEmp"
                + " WHERE empleado.ci = "+ci;
        try {
            Statement st = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery(consulta);
            int p=1;
            System.out.println("entre");
             while(rs.absolute(p)){
                aux = new ArrayList<String>();
                
                aux.add(rs.getString("Nombre"));
                aux.add(rs.getString("Apellidos"));
                aux.add(rs.getString("sueldo"));
                aux.add(rs.getString("ci"));
                aux.add(rs.getString("correo"));
                aux.add(rs.getString("tipo"));
                aux.add(rs.getString("gananciaTotal"));
                
                answer.add(aux);
                
                p++;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return answer;
    }
    public void reporteVendedoresVentas(String date){//20071016
        
        nombres = new ArrayList();
        ingresos = new ArrayList();
        
        
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
                
                nombres.add(rs.getString("name"));
                ingresos.add(Float.parseFloat(rs.getString("Numero_Ventas")));
                pos++;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public ArrayList<String> getListaVendedores(){
        return nombres;
    }
    public ArrayList<Float> getListaIngresosGenerados(){
        return ingresos;
    }
    public boolean validar_fecha(String date){
        Validacion validar = new Validacion();
        int tam = date.length();
        if(validar.esNumero(date) && tam == 8){
            return true;
        }
        return false;
    }
}

