/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Tutorial extends JFrame
{
       JPanel jp = new JPanel();
       JLabel jl = new JLabel();

       public Tutorial()
       {
              setTitle("Tutorial");
              setVisible(true);
              setSize(400, 200);
              setDefaultCloseOperation(EXIT_ON_CLOSE);

              jl.setIcon(new ImageIcon(getClass().getResource("/Imagen/InterfazMejor.jpg")));
              jp.add(jl);
              add(jp);

              validate();
       }

       public static void main(String[] args)
       {
             Tutorial t = new Tutorial();
       }
}