
package Interfaz;

/**
 *
 * @author Heredia
 */

import java.awt.Color;
import javax.swing.JFrame;
import org.jfree.chart.*;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;


public class Estadisticas extends JFrame{
 
    public static void main(String[] args){
        String[] equipos=new String[]{"RIVER", "BOCA", "CHICAGO"};
        int[] val=new int[]{116,12,50};
        Estadisticas p=new Estadisticas(equipos, val, "ejex", "eje y", "XY", 2);
        ChartPanel panel = new ChartPanel(p.getGrafica());
        JFrame ventana = new JFrame("");
        ventana.getContentPane().add(panel);
        ventana.pack();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }
    
    
    JFreeChart grafica;
    DefaultCategoryDataset datos = new DefaultCategoryDataset();
    DefaultCategoryDataset datosL = new DefaultCategoryDataset();
    DefaultPieDataset datosPie = new DefaultPieDataset();
    String nombreP, nombreEje, nombreT;
    
    public Estadisticas(String[] n, int[] v, String n1, String n2, String n3, int tipo) {
        anadir(n,v,n1);
        nombreP = n1;
        nombreEje = n2;
        nombreT = n3;
        graficar(tipo);
    }
    
    public void anadir(String[] n, int[] v, String n1) {
        for(int i=0; i<n.length; i++){
            datos.addValue(v[i], n[i], n[i]);
            datosL.addValue(v[i], n1, n[i]);
            datosPie.setValue(n[i], v[i]);
        }
    }
    
    public void graficar(int i){
        switch(i){
            case 0: grafica = ChartFactory.createBarChart3D(nombreT, nombreEje, null, datos);
                    grafica.setBackgroundPaint(new Color(255, 204, 51));
                    
                break;
            case 1: grafica = ChartFactory.createLineChart3D(nombreT, nombreEje, null, datosL);
                    grafica.setBackgroundPaint(new Color(255, 204, 51));
                break;
            case 2: grafica = ChartFactory.createPieChart3D(nombreT, datosPie);
                    grafica.setBackgroundPaint(new Color(255, 204, 51));
                break;
        }
       
    }
    
    public JFreeChart getGrafica(){
        return grafica;
    }
    
}
