/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfacesFX;
import Administrador.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
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
    
    String fuente;
    String fuenteLabel;
    int tamanoLabel;
    String fuenteTextField;
    int tamanoTextField;
    String colorLabel;
    
    Administrador admin;
    Scene scene;
    
    Group raiz;
    @Override
    public void start(Stage primaryStage) {
        fuente = "Cambria";
        fuenteLabel = "Britannic Bold";
        tamanoLabel = 25;
        fuenteTextField = "Cambria";
        tamanoTextField = 15;
        colorLabel = "#f7f7f9";
        admin = Administrador.crearAdministrador("");
        raiz = new Group();
        Scene escena = new Scene(raiz);
        separacionX = 40;
        separacion2col = 270;
        root = new Pane();
        Image image = new Image("file:///C:/Users/USUARIO/Desktop/FondoInterfaz.png");
        ImageView iv1 = new ImageView();
         iv1.setImage(image);
         escena.setFill(Color.BLACK);
         HBox box = new HBox();
         box.getChildren().add(iv1);
         raiz.getChildren().add(box);
         primaryStage.setScene(escena); 
         primaryStage.sizeToScene(); 
        inicializarBotones();
       inicializarTextFields();
        inicializarLabels();
        inicializarCombos();
        primaryStage.setResizable(false);
        
        //root.getChildren().add(iv1);
        //scene = new Scene(root, 1000,600);
        //primaryStage.setScene(escena);
        //primaryStage.sizeToScene();
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
        comboBox.setValue("Seleccione tipo...");
        comboBox.setLayoutX(separacion2col);
        comboBox.setLayoutY(350);
        comboBox.setPrefWidth(300);
        comboBox.setPrefHeight(40);
        
        add(comboBox);
        
        
    }
    public void inicializarBotones(){
        boton = new Button("Registrar");
        boton.setLayoutX(separacionX);boton.setLayoutY(420);
        boton.setPrefHeight(40);
        boton.setPrefWidth(separacion2col-separacionX+300);
        boton.setOnAction(new EventHandler<ActionEvent>() {
         @Override public void handle(ActionEvent e) {
            if(validar()){
                admin.ingresarEmpleado(nombre.getText(),apellidos.getText(),10000.11f,Integer.parseInt(CI.getText()),correo.getText(),(String)comboBox.getValue());
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
       texto.setFont(Font.font(fuente,40));
       texto.setLayoutX(separacionX);texto.setLayoutY(110);
       texto.setFill(Color.WHITE);
       add(texto);
        nombreLabel         = new Label("Nombre: ");
        nombreLabel.setFont(Font.font(fuenteLabel,tamanoLabel));
        nombreLabel.setTextFill(Color.web(colorLabel));
        nombreLabel.setLayoutX(separacionX);nombreLabel.setLayoutY(160);
           
        apellidosLabel      = new Label("Apellidos: ");
        apellidosLabel.setFont(Font.font(fuenteLabel,tamanoLabel));
        apellidosLabel.setLayoutX(separacionX);apellidosLabel.setLayoutY(210);
        apellidosLabel.setTextFill(Color.web(colorLabel));
        
        CILabel            = new Label("CI: ");
        CILabel.setFont(Font.font(fuenteLabel,tamanoLabel));
        CILabel.setTextFill(Color.web(colorLabel));
        CILabel.setLayoutX(separacionX);CILabel.setLayoutY(260);
        
        correoLabel        = new Label("Correo electrónico: ");
        correoLabel.setFont(Font.font(fuenteLabel,tamanoLabel));
        correoLabel.setTextFill(Color.web(colorLabel));
        correoLabel.setLayoutX(separacionX);correoLabel.setLayoutY(310);
        
        empleadoLabel      = new Label("Tipo de empleado: ");
        empleadoLabel.setFont(Font.font(fuenteLabel,tamanoLabel));
        empleadoLabel.setTextFill(Color.web(colorLabel));
        empleadoLabel.setLayoutX(separacionX);empleadoLabel.setLayoutY(360);
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
        
        nombre =        new TextField();               
        nombre.setPromptText("Introduzca nombre...");
        nombre.setFont(Font.font(fuenteTextField, FontWeight.BOLD,tamanoTextField));
        nombre.setLayoutX(separacion2col);nombre.setLayoutY(150);
        nombre.setPrefWidth(300);
        nombre.setPrefHeight(40);
        
        apellidos=      new TextField();
        apellidos.setPromptText("Introduzca apellidos...");
        apellidos.setFont(Font.font(fuenteTextField, FontWeight.BOLD,tamanoTextField));
        apellidos.setLayoutX(separacion2col);apellidos.setLayoutY(200);
        apellidos.setPrefWidth(300);
        apellidos.setPrefHeight(40);
        
        CI =           new TextField(); 
        CI.setPromptText("Introduzca CI...");
        CI.setFont(Font.font(fuenteTextField, FontWeight.BOLD,tamanoTextField));
        CI.setLayoutX(separacion2col);CI.setLayoutY(250);
        CI.setPrefWidth(300);
        CI.setPrefHeight(40);
        
        correo=         new TextField();
        correo.setPromptText("Introduzca correo electrónico...");
        correo.setFont(Font.font(fuenteTextField, FontWeight.BOLD,tamanoTextField));
        correo.setLayoutX(separacion2col);correo.setLayoutY(300);
        correo.setPrefWidth(300);
        correo.setPrefHeight(40);
        
        anadirTextFields();
    }
    public void anadirTextFields(){
    
        add(nombre);
        add (apellidos);
        add(CI);
        add(correo);
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
           CI.getText().equals("")){ 
   
            
        }else{
            System.out.println("Completo");
        }
    
    }
    public boolean validar(){
        return true;
    }
   
    
}
