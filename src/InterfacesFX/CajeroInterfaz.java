/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfacesFX;


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
import javafx.scene.effect.DropShadow;
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


public class CajeroInterfaz extends Application {
    
    TextField CI;
    TextField monto;
    TextField cambio;
    TextField espacio;
   
    
    Label CILabel;
    Label montoLabel;
    Label cambioLabel;
    Label espacioLabel;
    
    Button botonConfirmar;
    Button botonCancelar;
    
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
    public static void main(String[]args){
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        iniciarEstandares();
        raiz = new Group();
        Scene escena = new Scene(raiz);
        Image image = new Image("Imagen/InterfazMejor.jpg");
        ImageView iv1 = new ImageView();
        iv1.setImage(image);
      
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
     public void inicializarTextFields(){
        int i = 60;
        int inicio = 150;
        CI =        new TextField();
        CI.setFont(Font.font(fuenteTextField, FontWeight.BOLD,tamanoTextField));
        CI.setLayoutX(segundaCol);CI.setLayoutY(inicio);
        CI.setPrefWidth(300);
        CI.setPrefHeight(40);
        //CI.setFont(Font.font(fuenteTextField, FontWeight.BOLD,tamanoTextField));
        inicio+=i;
        monto =           new TextField();
        monto.setLayoutX(segundaCol);monto.setLayoutY(inicio);
        monto.setPrefWidth(300);      
        monto.setFont(Font.font(fuenteTextField, FontWeight.BOLD,tamanoTextField));
        monto.setPrefHeight(40);
        inicio+=i;
        cambio =       new TextField();
        cambio.setLayoutX(segundaCol);cambio.setLayoutY(inicio);
        cambio.setPrefWidth(300);
        cambio.setFont(Font.font(fuenteTextField, FontWeight.BOLD,tamanoTextField));
        cambio.setPrefHeight(40);       
        cambio.setEditable(false);
        inicio+=i;
        espacio = new TextField();
        espacio.setLayoutX(segundaCol);espacio.setLayoutY(inicio);
        espacio.setPrefWidth(300);
        espacio.setFont(Font.font(fuenteTextField, FontWeight.BOLD,tamanoTextField));
        espacio.setPrefHeight(40);
        inicio+=i;
       
       
       
        anadirTextFields();
     }
     public void inicializarBotones(){
        botonConfirmar = new Button("Confirmar");
        botonConfirmar.setLayoutX(360);botonConfirmar.setLayoutY(400);
        botonConfirmar.setPrefHeight(40);
        botonConfirmar.setPrefWidth(150);
        botonConfirmar.setOnAction(new EventHandler<ActionEvent>() {
         @Override public void handle(ActionEvent e) {
           
    }
});
        botonCancelar= new Button("Cancelar");
        botonCancelar.setLayoutX(185);botonCancelar.setLayoutY(400);
        botonCancelar.setPrefHeight(40);
        botonCancelar.setPrefWidth(150);
        botonCancelar.setOnAction(new EventHandler<ActionEvent>() {
         @Override public void handle(ActionEvent e) {
           
    }
});
        anadirBotones();
    }
    public void anadirBotones(){
        add(botonConfirmar);
        add(botonCancelar);
    }
     public void anadirTextFields(){
         add(CI);
         add(monto);
         add(cambio);
         add(espacio);
     }
    public void inicializarLabels(){
      
       Text texto = new Text("CAJERO: ");
       texto.setFont(Font.font(fuenteTitulo,tamanoTitulo));
       texto.setLayoutX(primeraCol);texto.setLayoutY(110);
       texto.setFill(Color.WHITE);
       
       add(texto);
        
       int i = 60;
       int inicio = 160;
        
        CILabel         = new Label("CI: ");
        CILabel.setFont(Font.font(fuenteLabel,tamanoLabel));
        CILabel.setLayoutX(primeraCol);CILabel.setLayoutY(inicio);
        CILabel.setTextFill(Color.web(colorLabel));
      
        inicio+=i;    
        montoLabel            = new Label("Monto: ");
        montoLabel.setFont(Font.font(fuenteLabel,tamanoLabel));
        montoLabel.setLayoutX(primeraCol);montoLabel.setLayoutY(inicio);
        montoLabel.setTextFill(Color.web(colorLabel));
        inicio+=i;
        cambioLabel = new Label("Cambio: ");
        cambioLabel.setFont(Font.font(fuenteLabel, tamanoLabel));
        cambioLabel.setLayoutX(primeraCol);cambioLabel.setLayoutY(inicio);
        cambioLabel.setTextFill(Color.web(colorLabel)); 
        inicio+=i;
        espacioLabel  = new Label("FaltaAlgo: ");
        espacioLabel.setFont(Font.font(fuenteLabel,tamanoLabel));
        espacioLabel.setLayoutX(primeraCol);espacioLabel.setLayoutY(inicio);
        espacioLabel.setTextFill(Color.web(colorLabel));
        inicio+=i;
        
        anadirLabels();
    }
    public void anadirLabels(){
        
        add(CILabel);
        add(montoLabel);
        add(cambioLabel);
        add(espacioLabel);
    
    
    }
    public void iniciarEstandares(){
        fuenteLabel = "Britannic Bold";
        tamanoLabel = 25;
        fuenteTextField = "Cambria";
        tamanoTextField = 15;
        primeraCol=40;
        segundaCol=200;
        fuenteTitulo = "Bernard MT Condensed";
        tamanoTitulo = 52;
        colorLabel = "#f7f7f9";
    }
    public void add(Node n){
        raiz.getChildren().add(n);
    }
}