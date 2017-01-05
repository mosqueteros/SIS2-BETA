//Ultimo
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class testegistropagosTest {
    public testegistropagosTest() {
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
    registroPagosEmpleados registro=new registroPagosEmpleados();
    @Test
    public void testTecladovalidoIngresado(){
        boolean salida=registro.validoTeclado('b');
        Assert.assertEquals(true,salida);
        
        salida=registro.validoTeclado('1');
        Assert.assertEquals(true,salida);
        
         salida=registro.validoTeclado('*');
        Assert.assertEquals(false,salida);
        
         salida=registro.validoTeclado('¿');
        Assert.assertEquals(false,salida);
}
      @Test
    public void testvalidacionContenidoTotalAceptar(){//en caso de que mande false
        boolean salida=registro.accionBotonAceptar("eduardo","123132","cajero","2015/11/12", "2200");
        Assert.assertTrue(salida);
        // sucede cuando ingresamos correctamente los datos
        
        salida=registro.accionBotonAceptar("eduardo","dasdsa","cajero","2015/11/12", "2200");
        Assert.assertFalse(salida);
        
        salida=registro.accionBotonAceptar("eduardo","123132","cajero","12d112015", "2200");
        Assert.assertEquals(false,salida);
        
        salida=registro.accionBotonAceptar("1eduardo","123132","cajero","2015/11/12", " ");
        Assert.assertEquals(false,salida);
        
}
     @Test
    public void testverificaStringApartiString(){
        boolean salida=registro.verificarString("numero");
        Assert.assertEquals(true,salida);
        
        salida=registro.verificarString("numero1");
        Assert.assertEquals(false,salida);
        
        salida=registro.verificarString(" ");
         Assert.assertEquals(true,salida);
         
       salida=registro.verificarString(".");
         Assert.assertEquals(true,salida);  
    }
     @Test
    public void testverificaNumeroApartirString(){
        boolean salida=registro.verificarNumero("1231");
        Assert.assertEquals(true,salida);
        
        salida=registro.verificarNumero("gerente");
        Assert.assertEquals(false,salida);
        
        salida=registro.verificarNumero(" ");
         Assert.assertEquals(false,salida);
         
       salida=registro.verificarNumero(".");
         Assert.assertEquals(false,salida);  
    }
     @Test
    public void testverificafechaApartirString(){// dia mes año
        boolean salida=registro.verificarFecha("2000/11/22");
        Assert.assertEquals(true,salida);
        
        salida=registro.verificarFecha("2001/12/12");
        Assert.assertEquals(true,salida);
        
        salida=registro.verificarFecha("2000/./12");
         Assert.assertEquals(false,salida);
         
       salida=registro.verificarNumero(".");
         Assert.assertEquals(false,salida); 
         
         salida=registro.verificarNumero(" ");
         Assert.assertEquals(false,salida); 
         
         salida=registro.verificarNumero("211");
         Assert.assertEquals(true,salida); 
    }
}

