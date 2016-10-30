/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;
import Administrador.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class RegistroEmpleadoInterfaz extends Application {
    
    Pane root;
    
            
    TextField nombre;
    TextField apellidos;
    TextField CI;
   // TextField empleado;
    TextField correo;
    
    ComboBox comboBox;
    ObservableList<String> tiposEmpleado;
    
    
    Label nombreLabel;
    Label apellidosLabel;
    Label CILabel;
    Label empleadoLabel;
    Label correoLabel;
    Button boton;
    int separacionX;
    int separacion2col;
    
    Administrador admin;
    Scene scene;
    
    @Override
    public void start(Stage primaryStage) {
        admin = Administrador.crearAdministrador("");
        separacionX = 40;
        separacion2col = 350;
        root = new Pane();
        inicializarBotones();
        inicializarTextFields();
        inicializarLabels();
        inicializarCombos();
        primaryStage.setResizable(false);
        
        
        scene = new Scene(root, 1000,600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public void inicializarCombos(){
          tiposEmpleado = 
            FXCollections.observableArrayList(
            "Vendedor",
            "Mecánico",
            "Recursos Humanos"
            );
        comboBox = new ComboBox(tiposEmpleado);
         comboBox.setLayoutX(separacion2col);
        comboBox.setLayoutY(350);
        comboBox.setPrefWidth(300);
        
        add(comboBox);
        
        
    }
    public void inicializarBotones(){
        boton = new Button("Registrar");
        boton.setLayoutX(separacion2col);boton.setLayoutY(500);
        boton.setPrefHeight(20);
        boton.setPrefWidth(300);
        boton.setOnAction(new EventHandler<ActionEvent>() {
         @Override public void handle(ActionEvent e) {
            if(validar()){
                admin.ingresarEmpleado(nombre.getText(),apellidos.getText(),10000,Integer.parseInt(CI.getText()),correo.getText(),(String)comboBox.getValue());
            }
    }
});
        anadirBotones();
    }
    public void anadirBotones(){
        add(boton);
    }
    public void inicializarLabels(){
       Text texto = new Text("REGISTRO DE EMPLEADO: ");
       texto.setFont(Font.font("Britannic Bold",40));
       texto.setLayoutX(separacionX);texto.setLayoutY(100);
       add(texto);
        nombreLabel         = new Label("Nombre: ");
        nombreLabel.setFont(Font.font("Britannic Bold",20));
        nombreLabel.setLayoutX(separacionX);nombreLabel.setLayoutY(150);
           
        apellidosLabel      = new Label("Apellidos: ");
        apellidosLabel.setFont(Font.font("Britannic Bold",20));
        apellidosLabel.setLayoutX(separacionX);apellidosLabel.setLayoutY(200);
           
        CILabel            = new Label("CI: ");
        CILabel.setFont(Font.font("Britannic Bold",20));
        CILabel.setLayoutX(separacionX);CILabel.setLayoutY(250);
        
        correoLabel        = new Label("Correo electrónico: ");
        correoLabel.setFont(Font.font("Britannic Bold",20));
        correoLabel.setLayoutX(separacionX);correoLabel.setLayoutY(300);
        
        empleadoLabel      = new Label("Seleccione tipo de empleado: ");
        empleadoLabel.setFont(Font.font("Britannic Bold",20));
        empleadoLabel.setLayoutX(separacionX);empleadoLabel.setLayoutY(350);
        anadirLabels();
    }
    public void anadirLabels(){
        
        add(nombreLabel);
        add(apellidosLabel);
        add(CILabel);
        add(correoLabel);
        add(empleadoLabel);
       
    }
    public void inicializarTextFields(){
        
        nombre =        new TextField("Nombre");
        nombre.setLayoutX(separacion2col);nombre.setLayoutY(150);
        nombre.setPrefWidth(300);
        
        apellidos=      new TextField("Apellidos: "); 
        apellidos.setLayoutX(separacion2col);apellidos.setLayoutY(200);
        apellidos.setPrefWidth(300);
        
        CI =           new TextField("NIT");
        CI.setLayoutX(separacion2col);CI.setLayoutY(250);
        CI.setPrefWidth(300);
        
        correo=         new TextField("Correo electrónico");
        correo.setLayoutX(separacion2col);correo.setLayoutY(300);
        correo.setPrefWidth(300);
        
        anadirTextFields();
    }
    public void anadirTextFields(){
    
        add(nombre);
        add (apellidos);
        add(CI);
        add(correo);
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
           CI.getText().equals("")){ 
   
            
        }else{
            System.out.println("Completo");
        }
    
    }
    public boolean validar(){
        return true;
    }
   
    
}
