
import Administrador.Administrador;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestNombresBancos {

    public TestNombresBancos() {
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
    
    @Test
    public void testIngresoNombresBancos(){
        Administrador admin=Administrador.crearAdministrador("");
        admin.registrarBanco("banco ganadero");
        ArrayList<String> lista=admin.listadoBancos();
        String nombresBancos="";
        for(int i=0; i<lista.size(); i++){
            nombresBancos+=lista.get(i)+"\n";
        }
        System.out.println("Nombres de bancos = "+nombresBancos);
        assertEquals("", nombresBancos);
    }
    
    @Test
    public void testModificacionBanco(){
        Administrador admin=Administrador.crearAdministrador("");
        ArrayList<String> lista=admin.listadoBancos();
        String bancoAModificar=lista.get(0);
        
    }
}
