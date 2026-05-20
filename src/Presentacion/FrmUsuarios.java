/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Presentacion;

import Negocio.UsuarioControl;
import javax.swing.JOptionPane;

public class FrmUsuarios extends javax.swing.JInternalFrame {

    private final Negocio.UsuarioControl CONTROL;
    
    public FrmUsuarios() {
        initComponents();
        this.CONTROL = new Negocio.UsuarioControl(); 
        this.listar("");
    }
    
     private void listar(String texto) {
        String rolSeleccionado = ComboRolUsuarios.getSelectedItem().toString();
    
    // 2. Llamamos al controlador de usuarios pasando ambos parámetros
    tablaUsuarios.setModel(this.CONTROL.listar(texto, rolSeleccionado));
    
    // 3. Actualizamos el label con los registros que sobrevivieron al filtro
    lblTotalRegistros.setText("Registros mostrados: " + this.CONTROL.totalMostrado());
    
    // 4. Ocultamos la columna del ID (Columna 0) para mantener la estética limpia
    tablaUsuarios.getColumnModel().getColumn(0).setMaxWidth(0);
    tablaUsuarios.getColumnModel().getColumn(0).setMinWidth(0);
    tablaUsuarios.getColumnModel().getColumn(0).setPreferredWidth(0);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtBuscarUsuarios = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        ComboRolUsuarios = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaUsuarios = new javax.swing.JTable();
        lblTotalRegistros = new javax.swing.JLabel();
        btnActivarUsuarios = new javax.swing.JButton();
        btnDesactivarUsuarios = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Usuarios");

        jLabel1.setText("Buscar:");

        txtBuscarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarUsuariosActionPerformed(evt);
            }
        });

        jLabel2.setText("Rol:");

        ComboRolUsuarios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Paciente", "Medico", "Secretaria" }));
        ComboRolUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboRolUsuariosActionPerformed(evt);
            }
        });

        tablaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaUsuarios);

        lblTotalRegistros.setText("Registros mostrados: 0");

        btnActivarUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/images/icons8-check-mark-24.png"))); // NOI18N
        btnActivarUsuarios.setText("Activar");
        btnActivarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActivarUsuariosActionPerformed(evt);
            }
        });

        btnDesactivarUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/images/icons8-remove-user-24.png"))); // NOI18N
        btnDesactivarUsuarios.setText("Desactivar");
        btnDesactivarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivarUsuariosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(jLabel1)
                        .addGap(41, 41, 41)
                        .addComponent(txtBuscarUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ComboRolUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(lblTotalRegistros)
                        .addGap(142, 142, 142)
                        .addComponent(btnActivarUsuarios)
                        .addGap(124, 124, 124)
                        .addComponent(btnDesactivarUsuarios))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(184, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscarUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboRolUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDesactivarUsuarios)
                    .addComponent(btnActivarUsuarios)
                    .addComponent(lblTotalRegistros))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarUsuariosActionPerformed
        listar(txtBuscarUsuarios.getText().trim());
    }//GEN-LAST:event_txtBuscarUsuariosActionPerformed

    private void ComboRolUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboRolUsuariosActionPerformed
        listar(txtBuscarUsuarios.getText().trim());
    }//GEN-LAST:event_ComboRolUsuariosActionPerformed

    private void btnDesactivarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivarUsuariosActionPerformed
        if (tablaUsuarios.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Debes seleccionar un usuario de la tabla.", "Sistema", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int id = Integer.parseInt(tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(), 0).toString());
            String nombre = tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(), 2).toString();
        if (JOptionPane.showConfirmDialog(this, "¿Deseas desactivar al usuario " + nombre + "?", "Desactivar", JOptionPane.YES_NO_OPTION) == 0) {
            String resp = this.CONTROL.desactivar(id);
            if (resp.equals("OK")){
                JOptionPane.showMessageDialog(this, "El usuario ha sido desactivado.", "Sistema", JOptionPane.INFORMATION_MESSAGE);
                this.listar(txtBuscarUsuarios.getText().trim());
            }else{
                JOptionPane.showMessageDialog(this, resp, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnDesactivarUsuariosActionPerformed

    private void btnActivarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActivarUsuariosActionPerformed
        if(tablaUsuarios.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(this, "Debes seleccionar un usuario de la tabla.", "Sistema", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int id = Integer.parseInt(tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(), 0).toString());
            String nombre = tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(), 2).toString();
        
        if(JOptionPane.showConfirmDialog(this, "¿Deseas activar al usuario " + nombre + "?", "Activar", JOptionPane.YES_NO_OPTION) == 0) {
            String resp = this.CONTROL.activar(id);
            if(resp.equals("OK")){
                JOptionPane.showMessageDialog(this, "El usuario ha sido activado con éxito.", "Sistema", JOptionPane.INFORMATION_MESSAGE);
                this.listar(txtBuscarUsuarios.getText().trim());
            }else{
                JOptionPane.showMessageDialog(this, resp, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnActivarUsuariosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboRolUsuarios;
    private javax.swing.JButton btnActivarUsuarios;
    private javax.swing.JButton btnDesactivarUsuarios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTotalRegistros;
    private javax.swing.JTable tablaUsuarios;
    private javax.swing.JTextField txtBuscarUsuarios;
    // End of variables declaration//GEN-END:variables


    

}
