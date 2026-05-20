
package Presentacion;

import Presentacion.FrmPrincipa;
import datos.UsuarioDAO;
import static java.awt.PageAttributes.MediaType.C;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Image;

public class FrmLogin extends javax.swing.JFrame {

    public FrmLogin() {
        initComponents();
        this.setSize(450, 550); 
        java.awt.Color azulAguaMarina = new java.awt.Color(204, 238, 240); 
        this.getContentPane().setBackground(azulAguaMarina);

        PanelLogin.setBackground(azulAguaMarina);
        if(PanelRegistro != null) {
        PanelRegistro.setBackground(azulAguaMarina);
}
        this.setLocationRelativeTo(null); 
   
        PanelLogin.setVisible(true);
        PanelRegistro.setVisible(false);
        this.setTitle("Inicio de sesión");
    
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelRegistro = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnConfirmarRegistro = new javax.swing.JButton();
        btnVolveraLogin = new javax.swing.JButton();
        txtNombreRegistro = new javax.swing.JTextField();
        txtCorreoRegistro = new javax.swing.JTextField();
        txtDocumentoRegistro = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        txtConfirmarRegistro = new javax.swing.JPasswordField();
        lblTitutloRegistro = new javax.swing.JLabel();
        PanelLogin = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtDocumentoLogin = new javax.swing.JTextField();
        txtContraseñaLogin = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        btnIniciarSesion = new javax.swing.JButton();
        btnRegistrarse = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lblTituloLogin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanelRegistro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setText("Nombre Completo:");
        PanelRegistro.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 139, 113, 28));

        jLabel5.setText("Correo Electronico:");
        PanelRegistro.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 185, 113, 28));

        jLabel6.setText("Documento:");
        PanelRegistro.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 231, 113, 29));

        jLabel7.setText("Contraseña:");
        PanelRegistro.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 278, 113, 28));

        jLabel8.setText("Confirmar Contraseña:");
        PanelRegistro.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 324, -1, 28));

        btnConfirmarRegistro.setBackground(new java.awt.Color(51, 255, 51));
        btnConfirmarRegistro.setText("Confirmar Registro");
        btnConfirmarRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarRegistroActionPerformed(evt);
            }
        });
        PanelRegistro.add(btnConfirmarRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 402, -1, -1));

        btnVolveraLogin.setBackground(new java.awt.Color(215, 147, 147));
        btnVolveraLogin.setText("Volver al Login");
        btnVolveraLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolveraLoginActionPerformed(evt);
            }
        });
        PanelRegistro.add(btnVolveraLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(289, 402, -1, -1));
        PanelRegistro.add(txtNombreRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(253, 140, 150, -1));
        PanelRegistro.add(txtCorreoRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(253, 186, 150, 27));
        PanelRegistro.add(txtDocumentoRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(253, 231, 150, 29));

        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });
        PanelRegistro.add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(253, 279, 150, -1));
        PanelRegistro.add(txtConfirmarRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(253, 325, 150, -1));

        lblTitutloRegistro.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        lblTitutloRegistro.setForeground(new java.awt.Color(0, 0, 0));
        lblTitutloRegistro.setText("Registro");
        PanelRegistro.add(lblTitutloRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(143, 34, 140, -1));

        PanelLogin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Documento:");
        PanelLogin.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 97, 37));
        PanelLogin.add(txtDocumentoLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 173, 37));

        txtContraseñaLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContraseñaLoginActionPerformed(evt);
            }
        });
        PanelLogin.add(txtContraseñaLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, 173, 37));

        jLabel2.setText("Contraseña:");
        PanelLogin.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, 97, 37));

        btnIniciarSesion.setBackground(new java.awt.Color(51, 255, 51));
        btnIniciarSesion.setText("Iniciar Sesion");
        btnIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarSesionActionPerformed(evt);
            }
        });
        PanelLogin.add(btnIniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, -1, -1));

        btnRegistrarse.setBackground(new java.awt.Color(30, 131, 131));
        btnRegistrarse.setText("Registrate");
        btnRegistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarseActionPerformed(evt);
            }
        });
        PanelLogin.add(btnRegistrarse, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 330, -1, -1));

        jLabel3.setText("¿No tienes cuenta?");
        PanelLogin.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 310, -1, -1));

        lblTituloLogin.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        lblTituloLogin.setForeground(new java.awt.Color(0, 0, 0));
        lblTituloLogin.setText("Inicio de Sesion");
        PanelLogin.add(lblTituloLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 815, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PanelRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(PanelLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarSesionActionPerformed
     String documento = txtDocumentoLogin.getText().trim();
    String clave = new String(txtContraseñaLogin.getPassword()).trim();
    if (documento.isEmpty() || clave.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Acceso", JOptionPane.WARNING_MESSAGE);
        return;
    }
    try {
        
        datos.UsuarioDAO dao = new datos.UsuarioDAO();
        if (dao.login(documento, clave)) {
            JOptionPane.showMessageDialog(this, "¡Bienvenido al sistema SaludLife!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            FrmPrincipa principal = new FrmPrincipa();
            principal.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
            principal.setVisible(true);
            this.dispose(); 
        } else {
            JOptionPane.showMessageDialog(this, "Documento o contraseña incorrectos.", "Acceso Denegado", JOptionPane.ERROR_MESSAGE);
            txtContraseñaLogin.setText("");
            txtContraseñaLogin.requestFocus();
        }
    }catch(Exception e){
        JOptionPane.showMessageDialog(this, "Error crítico de conexión con la Base de Datos:\n" + e.getMessage(), "Error de Sistema", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnIniciarSesionActionPerformed

    private void btnRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarseActionPerformed
        PanelLogin.setVisible(false);
    PanelRegistro.setVisible(true);
    this.setTitle("Registro de Usuario");;
    this.revalidate();
    this.repaint();
    }//GEN-LAST:event_btnRegistrarseActionPerformed

    private void txtContraseñaLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContraseñaLoginActionPerformed
        btnIniciarSesionActionPerformed(evt);
    }//GEN-LAST:event_txtContraseñaLoginActionPerformed

    private void btnVolveraLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolveraLoginActionPerformed
        PanelRegistro.setVisible(false);
    PanelLogin.setVisible(true);
    this.setTitle("Acceso al Sistema");
    }//GEN-LAST:event_btnVolveraLoginActionPerformed

    private void btnConfirmarRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarRegistroActionPerformed
        String nombre = txtNombreRegistro.getText().trim();
    String documento = txtDocumentoRegistro.getText().trim();
    String clave = new String(jPasswordField1.getPassword()).trim();
    String claveConf = new String(txtConfirmarRegistro.getPassword()).trim(); 
    String correo = txtCorreoRegistro.getText().trim(); 
    if (nombre.isEmpty() || documento.isEmpty() || clave.isEmpty() || claveConf.isEmpty() || correo.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Validación", JOptionPane.WARNING_MESSAGE);
        return; 
    }
    if (!clave.equals(claveConf)) {
        JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden. Por favor, verifíquelas.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
        jPasswordField1.setText("");
        txtConfirmarRegistro.setText("");
        jPasswordField1.requestFocus(); 
        return; 
    }
    try {
        datos.UsuarioDAO dao = new datos.UsuarioDAO();
        
        if (dao.registrar(nombre, documento, clave, correo)) {
            JOptionPane.showMessageDialog(this, "¡Usuario registrado con éxito!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            
            txtNombreRegistro.setText("");
            txtDocumentoRegistro.setText("");
            jPasswordField1.setText("");
            txtConfirmarRegistro.setText("");
            txtCorreoRegistro.setText("");
            btnVolveraLoginActionPerformed(evt); 
        }else{
            JOptionPane.showMessageDialog(this, "No se pudo registrar. El documento o correo ya podrían existir.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }catch(Exception e) {
        JOptionPane.showMessageDialog(this, "Error de sistema: " + e.getMessage(), "Error Crítico", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnConfirmarRegistroActionPerformed

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField1ActionPerformed

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
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelLogin;
    private javax.swing.JPanel PanelRegistro;
    private javax.swing.JButton btnConfirmarRegistro;
    private javax.swing.JButton btnIniciarSesion;
    private javax.swing.JButton btnRegistrarse;
    private javax.swing.JButton btnVolveraLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JLabel lblTituloLogin;
    private javax.swing.JLabel lblTitutloRegistro;
    private javax.swing.JPasswordField txtConfirmarRegistro;
    private javax.swing.JPasswordField txtContraseñaLogin;
    private javax.swing.JTextField txtCorreoRegistro;
    private javax.swing.JTextField txtDocumentoLogin;
    private javax.swing.JTextField txtDocumentoRegistro;
    private javax.swing.JTextField txtNombreRegistro;
    // End of variables declaration//GEN-END:variables
}
