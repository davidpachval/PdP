/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package david_victor;


import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author David Pacheco Valero
 * @author Victor Ortiz Lahuerta
 */
public class Interfaz extends javax.swing.JFrame {
        
        Avion a;
        Cinta c;
        Servidor s;
        long t0 = (new Date()).getTime();
       
        private boolean botonPulsado1 = false;
        private boolean botonPulsado2 = false;
        private boolean botontodo = false;
        private StartStop pausa1 = new StartStop();
        private StartStop pausa2 = new StartStop();
        private StartStop todo = new StartStop();

    /**
     * Creates new form Interfaz
     */
    public Interfaz() throws IOException {
        initComponents();
        
        c = new Cinta(8, contenido_cinta);
        a = new Avion(contenido_avion);
        s = new Servidor(c, a);
        s.start();
        GuardarDatos.CrearLog();
        Thread e1 = new Empleado(c, a, "Empleado1", empleado1, pausa1, todo, t0);
        Thread e2 = new Empleado(c, a, "Empleado2", empleado2, pausa2, todo, t0);
        for(int i=1; i<21; i++){
            Thread p = new Pasajero(c, "Pasajero"+i, todo, t0);
            p.start();
        }
        e1.start();
        e2.start();
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        contenido_cinta = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        empleado1 = new javax.swing.JTextField();
        empleado2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        pausar_todo = new javax.swing.JButton();
        parar_empleado1 = new javax.swing.JButton();
        parar_empleado2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        contenido_avion = new javax.swing.JTextArea();
        ver_cliente = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel1.setText("PRÁCTICA VICTOR ORTIZ Y DAVID PACHECO");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 11, 1020, 43));

        jLabel2.setText("CONTENIDO_CINTA");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 60, -1, -1));

        contenido_cinta.setMaximumSize(new java.awt.Dimension(0, 8));
        contenido_cinta.setMinimumSize(new java.awt.Dimension(0, 0));
        contenido_cinta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contenido_cintaActionPerformed(evt);
            }
        });
        getContentPane().add(contenido_cinta, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 85, 1133, 41));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("EMPLEADO 1");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(139, 153, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("EMPLEADO 2");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(835, 153, -1, -1));
        getContentPane().add(empleado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 190, 226, 38));

        empleado2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empleado2ActionPerformed(evt);
            }
        });
        getContentPane().add(empleado2, new org.netbeans.lib.awtextra.AbsoluteConstraints(781, 190, 247, 38));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("CONTENIDO_AVION");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(523, 281, -1, -1));

        pausar_todo.setBackground(new java.awt.Color(255, 255, 255));
        pausar_todo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        pausar_todo.setForeground(new java.awt.Color(255, 0, 0));
        pausar_todo.setText("DETENER TODO");
        pausar_todo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pausar_todoActionPerformed(evt);
            }
        });
        getContentPane().add(pausar_todo, new org.netbeans.lib.awtextra.AbsoluteConstraints(511, 440, 211, 57));

        parar_empleado1.setBackground(new java.awt.Color(0, 51, 255));
        parar_empleado1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        parar_empleado1.setForeground(new java.awt.Color(255, 255, 255));
        parar_empleado1.setText("DETENER EMPLEADO 1");
        parar_empleado1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                parar_empleado1ActionPerformed(evt);
            }
        });
        getContentPane().add(parar_empleado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 239, -1, -1));

        parar_empleado2.setBackground(new java.awt.Color(0, 0, 255));
        parar_empleado2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        parar_empleado2.setForeground(new java.awt.Color(255, 255, 255));
        parar_empleado2.setText("DETENER EMPLEADO 2");
        parar_empleado2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                parar_empleado2ActionPerformed(evt);
            }
        });
        getContentPane().add(parar_empleado2, new org.netbeans.lib.awtextra.AbsoluteConstraints(792, 239, -1, -1));

        contenido_avion.setColumns(20);
        contenido_avion.setRows(5);
        jScrollPane1.setViewportView(contenido_avion);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 325, 1072, 97));

        ver_cliente.setBackground(new java.awt.Color(51, 204, 0));
        ver_cliente.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ver_cliente.setText("VER CLIENTE");
        ver_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ver_clienteActionPerformed(evt);
            }
        });
        getContentPane().add(ver_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 500, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void contenido_cintaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contenido_cintaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contenido_cintaActionPerformed

    private void pausar_todoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pausar_todoActionPerformed
        // TODO add your handling code here:
        if (!botontodo) //Si no se ha pulsado
        {
            botontodo = true;             //lo cambiamos a pulsado
            pausar_todo.setText("REAUNUDAR TODO");  //y cambiamos el texto
            empleado1.setText("DESCANSANDO GENERAL"); // Cambia la casilla de texto del empleado
            empleado2.setText("DESCANSO GENERAL");
            String texto = "////PARADA GENERAL DE LA ACTIVIDAD\\\\";
            try {
                GuardarDatos.ModificarLog(texto, t0);
            } catch (IOException ex) {
                Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
            }
            parar_empleado1.setEnabled(false);
            parar_empleado2.setEnabled(false);
            todo.cerrar();    //Cerramos el paso para que los pintores se detengan
        } else //Si ya se había pulsado
        {
            botontodo = false;            //lo cambiamos
            pausar_todo.setText("DETENER TODO");  //y cambiamos el texto
            String texto = "////REANUDAIÓN GENERAL DE LA ACTIVIDAD\\\\";
            try {
                GuardarDatos.ModificarLog(texto, t0);
            } catch (IOException ex) {
                Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
            }
            parar_empleado1.setEnabled(true);
            parar_empleado2.setEnabled(true);
            todo.abrir();    //Abrimos el paso para que los pintores sigan trabajando
        }
    }//GEN-LAST:event_pausar_todoActionPerformed

    private void parar_empleado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_parar_empleado1ActionPerformed
        // TODO add your handling code here:
        if (!botonPulsado1) //Si no se ha pulsado
        {
            botonPulsado1 = true;             //lo cambiamos a pulsado
            parar_empleado1.setText("REANUDAR EMPLEADO 1");  //y cambiamos el texto
            empleado1.setText("DESCANSANDO"); // Cambia la casilla de texto del empleado
            String texto = "Empleado [1] DESCANSANDO";
            try {
                GuardarDatos.ModificarLog(texto, t0);
            } catch (IOException ex) {
                Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
            }
            pausa1.cerrar();    //Cerramos el paso para que los pintores se detengan
        } else //Si ya se había pulsado
        {
            botonPulsado1 = false;            //lo cambiamos
            parar_empleado1.setText("DETENER EMPLEADO 1");  //y cambiamos el texto
            String texto = "Empleado [1] VUELVE AL TRABAJO";
            try {
                GuardarDatos.ModificarLog(texto, t0);
            } catch (IOException ex) {
                Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
            }
            pausa1.abrir();    //Abrimos el paso para que los pintores sigan trabajando
        }
    }//GEN-LAST:event_parar_empleado1ActionPerformed

    private void parar_empleado2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_parar_empleado2ActionPerformed
        // TODO add your handling code here:
        if (!botonPulsado2) //Si no se ha pulsado
        {
            botonPulsado2 = true;             //lo cambiamos a pulsado
            parar_empleado2.setText("REANUDAR EMPLEADO 2");  //y cambiamos el texto
            empleado2.setText("DESCANSANDO"); // Cambia la casilla de texto del empleado
            String texto = "Empleado [2] DESCANSANDO";
            try {
                GuardarDatos.ModificarLog(texto, t0);
            } catch (IOException ex) {
                Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
            }
            pausa2.cerrar();    //Cerramos el paso para que los pintores se detengan
        } else //Si ya se había pulsado
        {
            botonPulsado2 = false;            //lo cambiamos
            parar_empleado2.setText("DETENER EMPLEADO 2");  //y cambiamos el texto
            String texto = "Empleado [2] VUELVE AL TRABAJO";
            try {
                GuardarDatos.ModificarLog(texto, t0);
            } catch (IOException ex) {
                Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
            }
            pausa2.abrir();    //Abrimos el paso para que los pintores sigan trabajando
        }
    }//GEN-LAST:event_parar_empleado2ActionPerformed

    private void empleado2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empleado2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_empleado2ActionPerformed

    private void ver_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ver_clienteActionPerformed
        // TODO add your handling code here:
        Cliente r = new Cliente();
        r.setVisible(true);
    }//GEN-LAST:event_ver_clienteActionPerformed
    
    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Interfaz().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea contenido_avion;
    private javax.swing.JTextField contenido_cinta;
    private javax.swing.JTextField empleado1;
    private javax.swing.JTextField empleado2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton parar_empleado1;
    private javax.swing.JButton parar_empleado2;
    private javax.swing.JButton pausar_todo;
    private javax.swing.JButton ver_cliente;
    // End of variables declaration//GEN-END:variables
}
