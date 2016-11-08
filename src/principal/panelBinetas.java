
package principal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class panelBinetas {
    private static JPanel pane;
    private JMenuBar menuBar;
   public  panelBinetas(JPanel pane) {
       this.pane=pane;
       barraMenu();
    }
    private void barraMenu() {
        menuBar = new JMenuBar();
        JMenu registro = new JMenu();
        JMenu registro2 = new JMenu();
        JMenu registro3 = new JMenu();
        JCheckBoxMenuItem compra1 = new JCheckBoxMenuItem();
        compra1 = new JCheckBoxMenuItem();
        JCheckBoxMenuItem compra2 = new JCheckBoxMenuItem();
        JCheckBoxMenuItem vehiculos1 = new JCheckBoxMenuItem();
        registro.setText("registro");
        compra1.setSelected(true);
        compra1.setText("compra1");
        compra1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
               // mensajeNocopiarActionPerformed(evt);
            }
        });
        registro.add(compra1);
        menuBar.add(registro);
        registro2.setText("registro2");
        compra2.setSelected(true);
        compra2.setText("compra2");
        compra2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
               // aprenderActionPerformed(evt);
            }
        });
        registro2.add(compra2);
        menuBar.add(registro2);
        registro3.setText("resgistr3");
        vehiculos1.setSelected(true);
        vehiculos1.setText("vehiculos1");
        vehiculos1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                //nombreJugadorActionPerformed(evt);
            }
        });
        registro3.add(vehiculos1);
        menuBar.add(registro3);
        
    }
    public JMenuBar getMenuBar(){
        return menuBar;
    }
}
