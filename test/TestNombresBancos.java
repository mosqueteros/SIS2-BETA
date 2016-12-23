
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
    public void testIngresoNombresBancos() {
        Administrador admin = Administrador.crearAdministrador("");
        admin.vaciarDatosBanco();
        boolean respuesta = admin.registrarBanco("banco ganadero");
        assertEquals(true, respuesta);
    }

    @Test
    public void testModificacionBanco() {
        Administrador admin = Administrador.crearAdministrador("");
        admin.vaciarDatosBanco();
        admin.registrarBanco("banco total");
        String idbanco = admin.getIdBanco("banco total");
        int id = Integer.parseInt(idbanco);
        boolean respuesta = admin.modificacionBanco(id, "banco parcial");
        assertEquals(true, respuesta);
    }
}
