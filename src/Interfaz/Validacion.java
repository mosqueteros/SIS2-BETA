/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;


import java.util.regex.Pattern;

/**
 *
 * @author USUARIO
 */
public class Validacion {
    public Validacion(){}
   
     public boolean nombreProveedorValido(String nombre){
        
        Pattern p = Pattern.compile("[a-zA-Z_ ]{1,20}");
        if(!p.matcher(nombre).matches()){
            return false;
        }
        return true;
    }
    public boolean NITValido(String NITT){
        Pattern p = Pattern.compile("[0-9]{1,20}");
        if(!p.matcher(NITT).matches()){
            return false;
        }
        return true;
    } 
    public boolean ApellidosValido(String apellidos){
        Pattern p = Pattern.compile("[a-zA-z_ ]{1,25}");
        if(!p.matcher(apellidos).matches()){
            return false;
        }
        return true;
    }
    public boolean CIValido(String CI){
        Pattern p = Pattern.compile("[0-9]{7,8}");
        if(!p.matcher(CI).matches()){
            return false;
        
        }
        return true;
    }
    public boolean MarcaValida(String marca){
     Pattern p = Pattern.compile("[a-zA-Z]{1,50}");
        if(!p.matcher(marca).matches()){
            return false;
        
        }
        return true;
    }
    public boolean correoValido(String correo){
        Pattern p = Pattern.compile("[a-zA-Z_1-9]{1,15}@[a-zA-z]{1,7}.com");
        if(!p.matcher(correo).matches()){
            return false;
        }
        return true;
        
    }

}