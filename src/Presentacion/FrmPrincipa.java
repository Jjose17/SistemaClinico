
package Presentacion;


import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JOptionPane;

public class FrmPrincipa extends javax.swing.JFrame {

   
    public FrmPrincipa() {
   initComponents();
    setExtendedState(MAXIMIZED_BOTH);
 
}
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane(){

            @Override
            protected void paintComponent(Graphics g){

                super.paintComponent(g);
                Color miColor = new Color(16, 109, 133);

                g.setColor(miColor);

                g.fillRect(0, 0, getWidth(), getHeight());
            }

        };
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        mnuPaciente = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        mnuCompras = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        mnuConfiguracion = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        mnuSalir = new javax.swing.JMenuItem();
        mnuConsultas = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Citas medicas");

        jPanel1.setBackground(new java.awt.Color(16, 109, 133));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/images/logo1.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-220, -190, -1, -1));

        escritorio.add(jPanel1);
        jPanel1.setBounds(610, 80, 780, 510);

        mnuPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/images/icons8-user-48.png"))); // NOI18N
        mnuPaciente.setText("Paciente");
        mnuPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuPacienteActionPerformed(evt);
            }
        });

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_DOWN_MASK));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/images/icons8-register-24.png"))); // NOI18N
        jMenuItem1.setText("Registro");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        mnuPaciente.add(jMenuItem1);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.ALT_DOWN_MASK));
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/images/icons8-search-24.png"))); // NOI18N
        jMenuItem3.setText("Busqueda");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        mnuPaciente.add(jMenuItem3);

        menuBar.add(mnuPaciente);

        mnuCompras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/images/icons8-calendar-48.png"))); // NOI18N
        mnuCompras.setText("Citas");

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.ALT_DOWN_MASK));
        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/images/icons8-plus-24.png"))); // NOI18N
        jMenuItem4.setText("Nueva Cita");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        mnuCompras.add(jMenuItem4);

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/images/icons8-view-24.png"))); // NOI18N
        jMenuItem5.setText("Vista diaria/semanal");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        mnuCompras.add(jMenuItem5);

        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/images/icons8-important-event-24.png"))); // NOI18N
        jMenuItem7.setText("Cancelaciones");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        mnuCompras.add(jMenuItem7);

        menuBar.add(mnuCompras);

        mnuConfiguracion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/images/icons8-config-48.png"))); // NOI18N
        mnuConfiguracion.setText("Configuracion");

        jMenuItem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/images/icons8-client-management-24.png"))); // NOI18N
        jMenuItem9.setText("Usuarios");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        mnuConfiguracion.add(jMenuItem9);

        menuBar.add(mnuConfiguracion);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/images/salir.png"))); // NOI18N
        jMenu5.setText("Salir");

        mnuSalir.setText("Salir");
        mnuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSalirActionPerformed(evt);
            }
        });
        jMenu5.add(mnuSalir);

        menuBar.add(jMenu5);

        mnuConsultas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/images/icons8-consultation-48.png"))); // NOI18N
        mnuConsultas.setText("Futuro");

        jMenuItem8.setText("Facturacion");
        mnuConsultas.add(jMenuItem8);

        jMenuItem2.setText("Reportes");
        mnuConsultas.add(jMenuItem2);

        jMenuItem6.setText("Mantenimiento");
        mnuConsultas.add(jMenuItem6);

        menuBar.add(mnuConsultas);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 1401, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 618, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
    FrmPacientes frmReg = new FrmPacientes();
    FrmBusqueda frmBus = new FrmBusqueda();
    frmBus.setFrmRegistroPacientes(frmReg); 
    escritorio.add(frmReg);
    escritorio.add(frmBus);
    
    frmBus.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        FrmVistaSemanal frm = new FrmVistaSemanal();
        escritorio.add(frm);
        frm.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void mnuPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuPacienteActionPerformed
        
    }//GEN-LAST:event_mnuPacienteActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        FrmPacientes frm = new FrmPacientes();
        escritorio.add(frm);
        frm.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        FrmNuevaCita frm = new FrmNuevaCita();
        escritorio.add(frm);
        frm.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
       FrmCancelaciones frm = new FrmCancelaciones();
       escritorio.add(frm);
       frm.setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void mnuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSalirActionPerformed
    int respuesta=JOptionPane.showConfirmDialog(this, "¿Estas segura de salir?", "Confirmar salida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    if(respuesta==JOptionPane.YES_OPTION){
        System.exit(0);
        }
    }//GEN-LAST:event_mnuSalirActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        FrmUsuarios frm = new FrmUsuarios();
        escritorio.add(frm);
        frm.setVisible(true);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new FrmPrincipa().setVisible(true);
        }
    });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu mnuCompras;
    private javax.swing.JMenu mnuConfiguracion;
    private javax.swing.JMenu mnuConsultas;
    private javax.swing.JMenu mnuPaciente;
    private javax.swing.JMenuItem mnuSalir;
    // End of variables declaration//GEN-END:variables

}
