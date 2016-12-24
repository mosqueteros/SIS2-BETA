
import Administrador.Administrador;
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
    public void testIngresarBanco() {
        Administrador admin = Administrador.crearAdministrador("");
        admin.vaciarDatosBanco();
        boolean respuesta = admin.registrarBanco("banco nuevo");
        assertEquals(true, respuesta);
    }

    @Test
    public void testModificarBanco() {
        Administrador admin = Administrador.crearAdministrador("");
        admin.vaciarDatosBanco();
        admin.registrarBanco("banco nombre actual");
        String idbanco = admin.getIdBanco("banco nombre actual");
        int id = Integer.parseInt(idbanco);
        boolean respuesta = admin.modificacionBanco(id, "banco nombre nuevo");
        assertEquals(true, respuesta);
    }
    
    @Test
    public void testEliminarBanco(){
        Administrador admin = Administrador.crearAdministrador("");
        admin.vaciarDatosBanco();
        admin.registrarBanco("banco inexistente");
        String idbanco = admin.getIdBanco("banco inexistente");
        int id = Integer.parseInt(idbanco);
        boolean respuesta = admin.eliminarBanco(id);
        assertEquals(true, respuesta);
    }
}
