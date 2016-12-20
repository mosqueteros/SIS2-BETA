/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Administrador.Administrador;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

/**
 *
 * @author Heredia
 */
public class TestEstadisticasVentas {
    
    public TestEstadisticasVentas() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void testCeroVentasHastaElMomento(){
        Administrador admin=Administrador.crearAdministrador("");
        admin.vaciarDatosCaja();
        ArrayList<Float> lista=admin.listadoIngresos();
        String ventasPorDia="";
        for(int i=0; i<lista.size(); i++){
            ventasPorDia+=lista.get(i)+"\n";
        }
        System.out.println("ventas por dia, vacia = "+ventasPorDia);
        assertEquals("", ventasPorDia);
    }
    @Test
    public void primerVenta(){
        Administrador admin=Administrador.crearAdministrador("");
        admin.vaciarDatosCaja();
        String fecha="20160113";
        float precio = admin.getPrecioVentaAuto("renault");
        int id = admin.getIdAuto("renault")    ;
        admin.registrarVentaAutomovil("renault");
        admin.registrarVentaContado(4, id, precio, "Gustavo", "Torres", 1234567, fecha);
        int idVenta=admin.getIDUltimaVentaContado();
        admin.ingresarCaja(idVenta, 1, fecha, precio);
        
        ArrayList<Float> lista=admin.listadoIngresos();
        String ventasPorDia="";
        for(int i=0; i<lista.size(); i++){
            ventasPorDia+=lista.get(i)+"\n";
        }
        System.out.println("Ventas x dia, primer venta = "+ventasPorDia);
        //se realizo una sola venta hasta el momento
        assertEquals("1200.0\n", ventasPorDia);
    }
    @Test
    public void dosVentasMismoDia(){
        Administrador admin=Administrador.crearAdministrador("");
        admin.vaciarDatosCaja();
        String fecha="20160113";
        float precio = admin.getPrecioVentaAuto("renault");
        int id = admin.getIdAuto("renault")    ;
        admin.registrarVentaAutomovil("renault");
        admin.registrarVentaContado(4, id, precio, "Gustavo", "Torres", 1234567, fecha);
        int idVenta=admin.getIDUltimaVentaContado();
        admin.ingresarCaja(idVenta, 1, fecha, precio);
        
        fecha="20160113";
        precio = admin.getPrecioVentaAuto("toyota");
        id = admin.getIdAuto("toyota")    ;
        admin.registrarVentaAutomovil("toyota");
        admin.registrarVentaContado(4, id, precio, "Gustavo", "Torres", 1234567, fecha);
        idVenta=admin.getIDUltimaVentaContado();
        admin.ingresarCaja(idVenta, 1, fecha, precio);
        
        
        ArrayList<Float> lista=admin.listadoIngresos();
        String ventasPorDia="";
        for(int i=0; i<lista.size(); i++){
            ventasPorDia+=lista.get(i)+"\n";
        }
        System.out.println("Ventas x dia, dos ventas = "+ventasPorDia);
        assertEquals("2605.0\n", ventasPorDia);
    }
    @Test
    public void dosVentasMismoDia_unaVentaOtroDia(){
        Administrador admin=Administrador.crearAdministrador("");
        admin.vaciarDatosCaja();
        String fecha="20160113";
        float precio = admin.getPrecioVentaAuto("renault");
        int id = admin.getIdAuto("renault")    ;
        admin.registrarVentaAutomovil("renault");
        admin.registrarVentaContado(4, id, precio, "Gustavo", "Torres", 1234567, fecha);
        int idVenta=admin.getIDUltimaVentaContado();
        admin.ingresarCaja(idVenta, 1, fecha, precio);
        
        fecha="20160113";
        precio = admin.getPrecioVentaAuto("toyota");
        id = admin.getIdAuto("toyota")    ;
        admin.registrarVentaAutomovil("toyota");
        admin.registrarVentaContado(4, id, precio, "Gustavo", "Torres", 1234567, fecha);
        idVenta=admin.getIDUltimaVentaContado();
        admin.ingresarCaja(idVenta, 1, fecha, precio);
        
        fecha="20160120";
        precio = admin.getPrecioVentaAuto("volvo");
        id = admin.getIdAuto("volvo");
        admin.registrarVentaAutomovil("volvo");
        admin.registrarVentaContado(4, id, precio, "Gustavo", "Torres", 1234567, fecha);
        idVenta=admin.getIDUltimaVentaContado();
        admin.ingresarCaja(idVenta, 1, fecha, precio);
        
        
        ArrayList<Float> lista=admin.listadoIngresos();
        String ventasPorDia="";
        for(int i=0; i<lista.size(); i++){
            ventasPorDia+=lista.get(i)+"\n";
        }
        System.out.println("Dos ventas mismo dia, una venta otro dia = "+ventasPorDia);
        assertEquals("2605.0\n1165.5\n", ventasPorDia);
    }
    @Test
    public void testCantidadVentas_dia0(){
        Administrador admin=Administrador.crearAdministrador("");
        admin.vaciarDatosCaja();
        ArrayList<Integer> lista=admin.listadoCantidadVentas();
        String ventasPorDia="";
        for(int i=0; i<lista.size(); i++){
            ventasPorDia+=lista.get(i)+"\n";
        }
        System.out.println("Cantidad ventas por dia, 0 ventas = "+ventasPorDia);
        assertEquals("", ventasPorDia);
    }
    @Test
    public void cantidadVentas_2MismoDia(){
        Administrador admin=Administrador.crearAdministrador("");
        admin.vaciarDatosCaja();
        String fecha="20160113";
        float precio = admin.getPrecioVentaAuto("renault");
        int id = admin.getIdAuto("renault")    ;
        admin.registrarVentaAutomovil("renault");
        admin.registrarVentaContado(4, id, precio, "Gustavo", "Torres", 1234567, fecha);
        int idVenta=admin.getIDUltimaVentaContado();
        admin.ingresarCaja(idVenta, 1, fecha, precio);
       
        fecha="20160113";
        precio = admin.getPrecioVentaAuto("toyota");
        id = admin.getIdAuto("toyota")    ;
        admin.registrarVentaAutomovil("toyota");
        admin.registrarVentaContado(4, id, precio, "Gustavo", "Torres", 1234567, fecha);
        idVenta=admin.getIDUltimaVentaContado();
        admin.ingresarCaja(idVenta, 1, fecha, precio);
        
        
        ArrayList<Integer> lista=admin.listadoCantidadVentas();
        String ventasPorDia="";
        for(int i=0; i<lista.size(); i++){
            ventasPorDia+=lista.get(i)+"\n";
        }
        System.out.println("Cantidad de ventas, dos ventas mismo dia= "+ventasPorDia);
        assertEquals("2\n", ventasPorDia);
    }
    @Test
    public void cantidaVentas_dosMismoDia_unaOtroDia(){
        Administrador admin=Administrador.crearAdministrador("");
        admin.vaciarDatosCaja();
        String fecha="20160113";
        float precio = admin.getPrecioVentaAuto("renault");
        int id = admin.getIdAuto("renault")    ;
        admin.registrarVentaAutomovil("renault");
        admin.registrarVentaContado(4, id, precio, "Gustavo", "Torres", 1234567, fecha);
        int idVenta=admin.getIDUltimaVentaContado();
        admin.ingresarCaja(idVenta, 1, fecha, precio);
        
        fecha="20160113";
        precio = admin.getPrecioVentaAuto("toyota");
        id = admin.getIdAuto("toyota")    ;
        admin.registrarVentaAutomovil("toyota");
        admin.registrarVentaContado(4, id, precio, "Gustavo", "Torres", 1234567, fecha);
        idVenta=admin.getIDUltimaVentaContado();
        admin.ingresarCaja(idVenta, 1, fecha, precio);
        
        fecha="20160120";
        precio = admin.getPrecioVentaAuto("volvo");
        id = admin.getIdAuto("volvo");
        admin.registrarVentaAutomovil("volvo");
        admin.registrarVentaContado(4, id, precio, "Gustavo", "Torres", 1234567, fecha);
        idVenta=admin.getIDUltimaVentaContado();
        admin.ingresarCaja(idVenta, 1, fecha, precio);
        
        
        ArrayList<Integer> lista=admin.listadoCantidadVentas();
        String ventasPorDia="";
        for(int i=0; i<lista.size(); i++){
            ventasPorDia+=lista.get(i)+"\n";
        }
        System.out.println("Cantidad de ventas 2 ventas mismo dia, una venta otro dia = "+ventasPorDia);
        assertEquals("2\n1\n", ventasPorDia);
    }
}
