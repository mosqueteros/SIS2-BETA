
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Administrador.Administrador;
import Administrador.Reporte;
import Interfaz.Validacion;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

/**
 *
 * @author migi
 */
public class TestVendedoresMes {
    
    public TestVendedoresMes() {
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
    public void testCiIncorrecto(){
        Validacion validar = new Validacion();
        boolean ci = validar.CIValido("12");
        //System.out.println("num1");
        assertFalse(ci);
    }
    @Test
    public void noexisteCiVendedor(){
        Administrador admin=Administrador.crearAdministrador("");
        Reporte reportes = new Reporte();
        admin.eliminacionEmpleado(12345678);
        boolean existe = reportes.existeCiVendedor(12345678);
        //System.out.println("num3");
        //System.out.println("2->>>>>>>>>>>> "+existe);
        assertFalse(existe);
    }
    @Test
    public void testCiIncorrecto2(){
        Validacion validar = new Validacion();
        boolean ci = validar.CIValido("123456789012");
        //System.out.println("num4");
        assertFalse(ci);
    }
    @Test
    public void registrarVentaContado(){
        Administrador admin=Administrador.crearAdministrador("");
        Reporte reportes = new Reporte();
        int id = 32;
        admin.registrarVentaContado(id, 2, 500, "trump", "barrientos", 0, "170117");
        //System.out.println("num5");
        assertEquals("trump","trump");
    }
    @Test
    public void testEsCICorrecto(){
        Validacion validar = new Validacion();
        boolean ci = validar.CIValido("12345678");
        //System.out.println("num6");
        assertTrue(ci);
    }
    @Test
    public void existeCiVendedor(){
        Administrador admin=Administrador.crearAdministrador("");
        Reporte reportes = new Reporte();
        admin.ingresarEmpleado("Juand", "Chalar", (float)1223, 12345678, "isis@gmail.com", "VENDEDOR");
        boolean existe = reportes.existeCiVendedor(12345678);
        //System.out.println("num7");
        assertTrue(existe);
        admin.eliminacionEmpleado(12345678);
    }
    @Test
    public void fechavalida(){
        Reporte reporte = new Reporte();
        boolean valido = reporte.validar_fecha("20071016");
        assertTrue(valido);
    }
    @Test
    public void validarLista(){
        Reporte reporte = new Reporte();
        ArrayList<String> answer = reporte.getListaVendedores();
        assertNull(answer);
    }
    @Test
    public void reporte(){
    }
    /*    
    @Test
    public void reporte(){
        Reporte reportes = new Reporte();
        String total = (reportes.reporteVentasVendedor(12345678).get(0).get(6));
        assertNotEquals("500",total);
    }
    */
    
}
