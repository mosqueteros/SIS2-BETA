/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class SisIIFX extends Application {
    
    Pane root;
    
            
    TextField nombre;
    TextField NIT;
    TextField IDEauto;
    TextField costoUnitario;
    TextField fecha;
    TextField precioDeVenta;
    TextField porcentajeGanancias;
    
    Label nombreLabel;
    Label NITLabel;
    Label IDEautoLabel;
    Label costoUnitarioLabel;
    Label fechaLabel;
    Label precioDeVentaLabel;
    Label porcentajeGananciasLabel;
    
    Button boton;
    
    int segundaCol;
    int primeraCol;
    
    String fuenteTitulo;
    String fuenteLabel;
    String fuente;
    String fuenteTextField;
    String colorLabel;
    int tamanoLabel;
    int tamanoTextField;
    int tamanoTitulo;
    
    Group raiz;
    Scene scene;
    
    @Override
    public void start(Stage primaryStage) {
        fuenteLabel = "Britannic Bold";
        tamanoLabel = 25;
        fuenteTextField = "Cambria";
        tamanoTextField = 15;
        primeraCol=40;
        segundaCol=340;
        fuenteTitulo = "Cambria";
        tamanoTitulo = 40;
        colorLabel = "#f7f7f9";
      // root = new Pane();
       
        raiz = new Group();
        Scene escena = new Scene(raiz);
        Image image = new Image("file:///C:/Users/USUARIO/Desktop/FondoInterfaz.png");
        ImageView iv1 = new ImageView();
         iv1.setImage(image);
       //  escena.setFill(Color.BLACK);
         HBox box = new HBox();
         box.getChildren().add(iv1);
         raiz.getChildren().add(box);
         primaryStage.setScene(escena); 
         primaryStage.sizeToScene(); 
        inicializarBotones();
        inicializarTextFields();
        inicializarLabels();
        
        primaryStage.show();
        
    }
    public void inicializarBotones(){
        boton = new Button("Registrar");
        boton.setLayoutX(190);boton.setLayoutY(500);
        boton.setPrefHeight(20);
        boton.setPrefWidth(300);
        boton.setOnAction(new EventHandler<ActionEvent>() {
         @Override public void handle(ActionEvent e) {
            comprobarCamposVacios();
    }
});
        anadirBotones();
    }
    public void anadirBotones(){
        add(boton);
    }
    public void inicializarLabels(){
      
       Text texto = new Text("COMPRA DE VEHÍCULOS: ");
       texto.setFont(Font.font(fuenteTitulo,tamanoTitulo));
       texto.setLayoutX(primeraCol);texto.setLayoutY(110);
       texto.setFill(Color.WHITE);
       add(texto);
        int i = 60;
        int inicio = 160;
        nombreLabel         = new Label("Nombre del proveedor: ");
        nombreLabel.setFont(Font.font(fuenteLabel,tamanoLabel));
        nombreLabel.setLayoutX(primeraCol);nombreLabel.setLayoutY(inicio);
        nombreLabel.setTextFill(Color.web(colorLabel));
       inicio+=i;    
        NITLabel            = new Label("NIT del proveedor: ");
        NITLabel.setFont(Font.font(fuenteLabel,tamanoLabel));
        NITLabel.setLayoutX(primeraCol);NITLabel.setLayoutY(inicio);
        NITLabel.setTextFill(Color.web(colorLabel));
        inicio+=i;
        IDEautoLabel = new Label("IDE del auto: ");
        IDEautoLabel.setFont(Font.font(fuenteLabel, tamanoLabel));
        IDEautoLabel.setLayoutX(primeraCol);IDEautoLabel.setLayoutY(inicio);
        IDEautoLabel.setTextFill(Color.web(colorLabel)); 
        inicio+=i;
        costoUnitarioLabel  = new Label("Costo unitario: ");
        costoUnitarioLabel.setFont(Font.font(fuenteLabel,tamanoLabel));
        costoUnitarioLabel.setLayoutX(primeraCol);costoUnitarioLabel.setLayoutY(inicio);
        costoUnitarioLabel.setTextFill(Color.web(colorLabel));
        inicio+=i;
        fechaLabel          = new Label("Fecha: ");
        fechaLabel.setFont(Font.font(fuenteLabel,tamanoLabel));
        fechaLabel.setLayoutX(primeraCol);fechaLabel.setLayoutY(inicio);
        fechaLabel.setTextFill(Color.web(colorLabel));
        inicio+=i;
        precioDeVentaLabel  = new Label("Precio de Venta: ");
        precioDeVentaLabel.setFont(Font.font(fuenteLabel,tamanoLabel));
        precioDeVentaLabel.setLayoutX(primeraCol);precioDeVentaLabel.setLayoutY(inicio);
        precioDeVentaLabel.setTextFill(Color.web(colorLabel));
        inicio+=i;
        anadirLabels();
    }
    public void anadirLabels(){
        
        add(nombreLabel);
        add(NITLabel);
        add(IDEautoLabel);
        add(costoUnitarioLabel);
        add(fechaLabel);
        add(precioDeVentaLabel);
    
    
    }
    public void inicializarTextFields(){
        int i = 60;
        int inicio = 150;
        nombre =        new TextField();
        nombre.setFont(Font.font(fuenteTextField, FontWeight.BOLD,tamanoTextField));
        nombre.setLayoutX(segundaCol);nombre.setLayoutY(inicio);
        nombre.setPrefWidth(300);
        nombre.setPrefHeight(40);
        //nombre.setFont(Font.font(fuenteTextField, FontWeight.BOLD,tamanoTextField));
        inicio+=i;
        NIT =           new TextField();
        NIT.setLayoutX(segundaCol);NIT.setLayoutY(inicio);
        NIT.setPrefWidth(300);      
        NIT.setFont(Font.font(fuenteTextField, FontWeight.BOLD,tamanoTextField));
        NIT.setPrefHeight(40);
        inicio+=i;
        IDEauto =       new TextField();
        IDEauto.setLayoutX(segundaCol);IDEauto.setLayoutY(inicio);
        IDEauto.setPrefWidth(300);
        IDEauto.setFont(Font.font(fuenteTextField, FontWeight.BOLD,tamanoTextField));
        IDEauto.setPrefHeight(40);       
        IDEauto.setEditable(false);
        inicio+=i;
        costoUnitario = new TextField();
        costoUnitario.setLayoutX(segundaCol);costoUnitario.setLayoutY(inicio);
        costoUnitario.setPrefWidth(300);
        costoUnitario.setFont(Font.font(fuenteTextField, FontWeight.BOLD,tamanoTextField));
        costoUnitario.setPrefHeight(40);
        inicio+=i;
        fecha =         new TextField();
        fecha.setLayoutX(segundaCol);fecha.setLayoutY(inicio);
        fecha.setPrefWidth(300);
        fecha.setEditable(false);
        fecha.setFont(Font.font(fuenteTextField, FontWeight.BOLD,tamanoTextField));
        fecha.setPrefHeight(40);
        asignarFecha();
        inicio+=i;
        precioDeVenta = new TextField();  
        precioDeVenta.setPrefWidth(300);
        precioDeVenta.setPrefHeight(40);
        precioDeVenta.setLayoutX(segundaCol);precioDeVenta.setLayoutY(inicio);
        precioDeVenta.setFont(Font.font(fuenteTextField, FontWeight.BOLD,tamanoTextField));
        precioDeVenta.setEditable(false);
        
        porcentajeGanancias = new TextField();
        porcentajeGanancias.setPrefColumnCount(2);
        porcentajeGanancias.setPrefHeight(40);
        porcentajeGanancias.setFont(Font.font(fuenteTextField, FontWeight.BOLD,tamanoTextField));
        porcentajeGanancias.setLayoutX(segundaCol+350);porcentajeGanancias.setLayoutY(inicio);
        
        porcentajeGanancias.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
               int a  = Integer.parseInt(costoUnitario.getText());
               double b = Integer.parseInt(porcentajeGanancias.getText())/100.0;
               double mul = 1+b;
               double res = mul*a;
                precioDeVenta.setText(a+res+"");
              
            }
});
        anadirTextFields();
    }
    public void establecerPrecioDeVenta(){
    
    }
    
    public void anadirTextFields(){
    
        add(nombre);
        add(NIT);
        add(IDEauto);
        add(costoUnitario);
        add(fecha);
        add(precioDeVenta);
        add(porcentajeGanancias);
 
    }
    public void add(Node n){
        raiz.getChildren().add(n);
    
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public void comprobarCamposVacios(){
        if(nombre.getText().equals("")||
           NIT.getText().equals("") ||
           IDEauto.getText().equals("") ||
           costoUnitario.getText().equals("") ||     
           fecha.getText().equals("") ||
           precioDeVenta.getText().equals("")){
            
            comprobarCamposValidos();
            
        
        }else{
            System.out.println("Completo");
        }
    
    }
   
    public void asignarFecha(){
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    Date date = new Date();
    fecha.setText(dateFormat.format(date));
    }
    
    
    public void comprobarCamposValidos(){
        
    
    
    
    }
    
}
