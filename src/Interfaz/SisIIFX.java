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
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class SisIIFX extends Application {
    
    Pane root;
    
            
    TextField nombre;
    TextField NIT;
    TextField marca;
    TextField modelo;
    TextField costoUnitario;
    TextField fecha;
    TextField precioDeVenta;
    
    Label nombreLabel;
    Label NITLabel;
    Label marcaLabel;
    Label modeloLabel;
    Label costoUnitarioLabel;
    Label fechaLabel;
    Label precioDeVentaLabel;
    
    Button boton;
    
    
    
    Scene scene;
    
    @Override
    public void start(Stage primaryStage) {
        
        root = new Pane();
        inicializarBotones();
        inicializarTextFields();
        inicializarLabels();
        primaryStage.setResizable(false);
        
        
        scene = new Scene(root, 1000,600);
        primaryStage.setScene(scene);
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
       texto.setFont(Font.font("Britannic Bold",40));
       texto.setLayoutX(10);texto.setLayoutY(50);
       add(texto);
        nombreLabel         = new Label("Nombre: ");
        nombreLabel.setFont(Font.font("Britannic Bold",20));
        nombreLabel.setLayoutX(10);nombreLabel.setLayoutY(150);
           
        NITLabel            = new Label("NIT: ");
        NITLabel.setFont(Font.font("Britannic Bold",20));
        NITLabel.setLayoutX(10);NITLabel.setLayoutY(200);
        
        marcaLabel          = new Label("Marca: ");
        marcaLabel.setFont(Font.font("Britannic Bold",20));
        marcaLabel.setLayoutX(10);marcaLabel.setLayoutY(250);
        
        modeloLabel          = new Label("Modelo: ");
        modeloLabel.setFont(Font.font("Britannic Bold",20));
        modeloLabel.setLayoutX(10);modeloLabel.setLayoutY(300);

        costoUnitarioLabel  = new Label("Costo unitario: ");
        costoUnitarioLabel.setFont(Font.font("Britannic Bold",20));
        costoUnitarioLabel.setLayoutX(10);costoUnitarioLabel.setLayoutY(350);
        
        fechaLabel          = new Label("Fecha: ");
        fechaLabel.setFont(Font.font("Britannic Bold",20));
        fechaLabel.setLayoutX(10);fechaLabel.setLayoutY(400);
        
        
        precioDeVentaLabel  = new Label("Precio de Venta: ");
        precioDeVentaLabel.setFont(Font.font("Britannic Bold",20));
        precioDeVentaLabel.setLayoutX(10);precioDeVentaLabel.setLayoutY(450);
        
        anadirLabels();
    }
    public void anadirLabels(){
        
        add(nombreLabel);
        add(NITLabel);
        add(marcaLabel);
        add(modeloLabel);
        add(costoUnitarioLabel);
        add(fechaLabel);
        add(precioDeVentaLabel);
    
    
    }
    public void inicializarTextFields(){
        
        nombre =        new TextField("Nombre");
        nombre.setLayoutX(190);nombre.setLayoutY(150);
        nombre.setPrefWidth(300);
        
        NIT =           new TextField("NIT");
        NIT.setLayoutX(190);NIT.setLayoutY(200);
        NIT.setPrefWidth(300);      
        
        marca =         new TextField("Marca");
        marca.setLayoutX(190);marca.setLayoutY(250);
        marca.setPrefWidth(300);
        
        modelo =        new TextField("Modelo");
        modelo.setLayoutX(190);modelo.setLayoutY(300);
        modelo.setPrefWidth(300);
        
        costoUnitario = new TextField("Costo");
        costoUnitario.setLayoutX(190);costoUnitario.setLayoutY(350);
        costoUnitario.setPrefWidth(300);
        
        fecha =         new TextField("Fecha");
        fecha.setLayoutX(190);fecha.setLayoutY(400);
        fecha.setPrefWidth(300);
        fecha.setEditable(false);
        asignarFecha();
        
        precioDeVenta = new TextField("Precio");
        precioDeVenta.setPrefWidth(300);
        precioDeVenta.setLayoutX(190);precioDeVenta.setLayoutY(450);
        
        
        anadirTextFields();
    }
    public void anadirTextFields(){
    
        add(nombre);
        add(NIT);
        add(marca);
        add(modelo);
        add(costoUnitario);
        add(fecha);
        add(precioDeVenta);
 
    }
    public void add(Node n){
        root.getChildren().add(n);
    
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
           marca.getText().equals("") ||
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
    fecha.setText("                                                                     "+
            dateFormat.format(date));
    }
    
    
    public void comprobarCamposValidos(){
        
    
    
    
    }
    
}
