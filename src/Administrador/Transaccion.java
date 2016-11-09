/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administrador;

import BaseDatos.ConexionMySQL;
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
public class Transaccion {
    
    private ConexionMySQL base;
    private Connection cn;
    
    public Transaccion(){
        base = new ConexionMySQL();
        cn = base.Conectar();
    }
    
    public ArrayList<ArrayList<String>> buscadorTablaCredito(int ci){
        ArrayList<ArrayList<String>> tablaCredito = new ArrayList();
        
        ArrayList<String> aux;
        
        String consulta = "SELECT * FROM ventacredito "
                + "JOIN cliente ON cliente.idclie = ventacredito.idclie "
                + "WHERE cliente.ciclie = "+ci
                +" ;";
        
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
                
                aux.add(rs.getString("idventcred"));
                aux.add(rs.getString("plazoventcred"));
                aux.add(rs.getString("estadoventcred"));
                aux.add(rs.getString("deudaventcred"));
                aux.add(rs.getString("idclie"));
                
                tablaCredito.add(aux);
                pos++;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(int i = 0; i < tablaCredito.size(); i++){
            System.out.println(tablaCredito.get(i).get(0)+" - "+tablaCredito.get(i).get(1)+" - "+tablaCredito.get(i).get(2)+" - "+tablaCredito.get(i).get(3) );
        }
        
        return tablaCredito;
    }
    
    public int ejecutarPagoCliente(int ci_cliente, int cantidad_cancelar, String fechapago, int idVentaCredito){
    	Statement stmt;
        String var;
        int pos = 1, monto, vuelto = 0;
        String actualizacion1 = "Update ventacredito "
                + "SET ventacredito.deudaventcred = ventacredito.deudaventcred - "+cantidad_cancelar
                + " WHERE ventacredito.idventcred = "+idVentaCredito;
        String consultaDeuda = "SELECT deudaventcred FROM ventacredito WHERE idventcred = "+idVentaCredito;
        try {
            cn.setAutoCommit(false);//inicio de la transaccion -> BEGIN
            stmt = cn.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            int n1 = stmt.executeUpdate(actualizacion1);
            if(n1 > 0){
                ResultSet rs = stmt.executeQuery(consultaDeuda);
                pos = 1;
                rs.absolute(pos);
                var = rs.getString("deudaventcred");
                monto = Integer.parseInt(var);
                if(monto <= 0){
                    cancelarDeuda(idVentaCredito);
                    vuelto=Math.abs(monto);
                }
            
            }else{
                cn.rollback();
            }
            cn.commit();
        } 
        catch (SQLException sqle) {
            try {
                cn.rollback();
            } 
            catch (SQLException e) {
                e.printStackTrace();
            }
            sqle.printStackTrace();
            } 
            finally {
                try {
                    cn.setAutoCommit(true);
                } 
                catch (SQLException e) {
                    e.printStackTrace();
                }
	}
        return vuelto;
    }
    
    private void cancelarDeuda(int id){
        Statement stmt;
        String actualizacion1 = "Update ventacredito "
                + "SET ventacredito.estadoventcred = 'cancelado'"
                + " WHERE ventacredito.idventcred = "+id;
        try{
            stmt = cn.createStatement(
            ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.CONCUR_UPDATABLE);
            int n1 = stmt.executeUpdate(actualizacion1);
            //if(n1>0)    System.out.println("UPDATE");
            //else System.out.println("NO actualizo");
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
    }
    
    
    
}
