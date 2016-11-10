package Interfaz;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

/**
 *
 * @author MAYKOL
 */
public class ventaVehiculo extends javax.swing.JFrame {

    /**
     * Creates new form ventaVehiculo
     */
    private Image fondo;
    public ventaVehiculo() {
        this.setBounds(0,0,400,400);
        this.setTitle("VENTA DE VEHICULOS");
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setSize(400, 600);
        initComponents();
        
        
        //Container contentpane =getContentPane();
        //contentpane.add(panel);
       SLetras(textNombre);
       SLetras(textApellido);
       SNumeros(textTelefono);
       SLNum(textCI);
       
    }
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        labelNombre = new javax.swing.JLabel();
        labelApellido = new javax.swing.JLabel();
        labelCI = new javax.swing.JLabel();
        labelTelefono = new javax.swing.JLabel();
        labelModelo = new javax.swing.JLabel();
        textNombre = new javax.swing.JTextField();
        textApellido = new javax.swing.JTextField();
        textCI = new javax.swing.JTextField();
        textTelefono = new javax.swing.JTextField();
        comboAuto = new javax.swing.JComboBox<>();
        imageAuto = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        botonImprimir = new javax.swing.JButton();
        botonGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel.setPreferredSize(new java.awt.Dimension(1000, 600));

        labelNombre.setFont(new java.awt.Font("Eras Bold ITC", 1, 20)); // NOI18N
        labelNombre.setText("Nombre:");

        labelApellido.setFont(new java.awt.Font("Eras Bold ITC", 1, 20)); // NOI18N
        labelApellido.setText("Apellido:");

        labelCI.setFont(new java.awt.Font("Eras Bold ITC", 1, 20)); // NOI18N
        labelCI.setText("CI:");

        labelTelefono.setFont(new java.awt.Font("Eras Bold ITC", 1, 20)); // NOI18N
        labelTelefono.setText("Teléfono:");

        labelModelo.setFont(new java.awt.Font("Eras Bold ITC", 1, 20)); // NOI18N
        labelModelo.setText("Modelo Automovil:");

        textNombre.setFont(new java.awt.Font("Eras Bold ITC", 1, 15)); // NOI18N

        textApellido.setFont(new java.awt.Font("Eras Bold ITC", 1, 15)); // NOI18N

        textCI.setFont(new java.awt.Font("Eras Bold ITC", 1, 15)); // NOI18N

        textTelefono.setFont(new java.awt.Font("Eras Bold ITC", 1, 15)); // NOI18N

        comboAuto.setFont(new java.awt.Font("Eras Bold ITC", 1, 15)); // NOI18N
        comboAuto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Modelo", "Ferrari", "Ford F-150", "Lamborghini", "Nissan Skyline", "Toyota Auris", "Puma F25", "Koenigsegg One" }));
        comboAuto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboAutoItemStateChanged(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Eras Bold ITC", 1, 30)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("VENTA DE VEHICULOS ");

        botonImprimir.setFont(new java.awt.Font("Arial", 3, 15)); // NOI18N
        botonImprimir.setText("IMPRIMIR");
        botonImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonImprimirActionPerformed(evt);
            }
        });

        botonGuardar.setFont(new java.awt.Font("Arial", 3, 15)); // NOI18N
        botonGuardar.setText("GUARDAR");
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(comboAuto, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(labelModelo))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelApellido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelCI)
                            .addComponent(labelTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textCI, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(textTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
            .addGroup(panelLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(imageAuto, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonImprimir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonGuardar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(22, 22, 22))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCI, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textCI, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboAuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(imageAuto, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(botonImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(botonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboAutoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboAutoItemStateChanged
            int posicion;
            String lugarImagen;
            URL url=null;
            posicion= comboAuto.getSelectedIndex();
            switch(posicion){
                case 0: 
                    lugarImagen = " ";
                    url= this.getClass().getResource(lugarImagen);
                    ImageIcon imagen0=new ImageIcon(url);
                    imageAuto.setIcon(imagen0);
                    break;
                case 1: 
                    lugarImagen = "/ImageAutos/ferrari.jpg";
                    url= this.getClass().getResource(lugarImagen);
                    ImageIcon imagen=new ImageIcon(url);
                    imageAuto.setIcon(imagen);
                    break;
                case 2:
                    lugarImagen = "/ImageAutos/ford-f-150.jpg";
                    url= this.getClass().getResource(lugarImagen);
                    ImageIcon imagen2=new ImageIcon(url);
                    imageAuto.setIcon(imagen2);
                    break;
                case 3: 
                    lugarImagen = "/ImageAutos/lamborghini-16387.jpg";
                    url= this.getClass().getResource(lugarImagen);
                    ImageIcon imagen3=new ImageIcon(url);
                    imageAuto.setIcon(imagen3);
                    break;
                case 4:
                    lugarImagen = "/ImageAutos/nissan skyline.jpg";
                    url= this.getClass().getResource(lugarImagen);
                    ImageIcon imagen4=new ImageIcon(url);
                    imageAuto.setIcon(imagen4);
                    break;
                case 5: 
                    lugarImagen = "/ImageAutos/toyota auris.jpg";
                    url= this.getClass().getResource(lugarImagen);
                    ImageIcon imagen5=new ImageIcon(url);
                    imageAuto.setIcon(imagen5);
                    break;
                case 6: 
                    lugarImagen = "/ImageAutos/puma F25.jpg";
                    url= this.getClass().getResource(lugarImagen);
                    ImageIcon imagen6=new ImageIcon(url);
                    imageAuto.setIcon(imagen6);
                    break;
                case 7: 
                    lugarImagen = "/ImageAutos/koenigseggOne.jpg";
                    url= this.getClass().getResource(lugarImagen);
                    ImageIcon imagen7=new ImageIcon(url);
                    imageAuto.setIcon(imagen7);
                    break;
            }
    }//GEN-LAST:event_comboAutoItemStateChanged

    private void botonImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonImprimirActionPerformed
       
    }//GEN-LAST:event_botonImprimirActionPerformed
  
    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
            
    }//GEN-LAST:event_botonGuardarActionPerformed
        public void SLetras(JTextField a){
        a.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                  char c=e.getKeyChar();
                  if(Character.isDigit(c)){
                      getToolkit().beep();
                      e.consume();
                  }
            }
        });
    }
       public void SNumeros(JTextField a){
        a.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                  char c=e.getKeyChar();
                  if(!Character.isDigit(c)){
                      getToolkit().beep();
                      e.consume();
                  }
            }
        });
    }
       public void SLNum(JTextField a){
        a.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                  char c=e.getKeyChar();
                  if(!Character.isDigit(c)&& Character.isDigit(c) ){
                      getToolkit().beep();
                      e.consume();
                  }
            }
        });
    }
     /*  
    private void preInit(){
        fondo=new ImageIcon("android1.jpg").getImage();
    }
    public void paint(Graphics g){
        g.drawImage(fondo,0,0,getWidth(),getHeight(),panel);
    }*/
            
            
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ventaVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ventaVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ventaVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ventaVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ventaVehiculo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonGuardar;
    private javax.swing.JButton botonImprimir;
    private javax.swing.JComboBox<String> comboAuto;
    private javax.swing.JLabel imageAuto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labelApellido;
    private javax.swing.JLabel labelCI;
    private javax.swing.JLabel labelModelo;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelTelefono;
    private javax.swing.JPanel panel;
    private javax.swing.JTextField textApellido;
    private javax.swing.JTextField textCI;
    private javax.swing.JTextField textNombre;
    private javax.swing.JTextField textTelefono;
    // End of variables declaration//GEN-END:variables
}
