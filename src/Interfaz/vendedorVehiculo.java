/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import javax.swing.JFrame;
public class vendedorVehiculo {
    private JFrame frame;
    private component componentes;
    public vendedorVehiculo() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setTitle("registro de venta de vehiculos al contado ");
        componentes = new component(frame);
        frame.setSize(1000, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        vendedorVehiculo pantalla = new vendedorVehiculo();
    }
}
