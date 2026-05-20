
package Presentacion;

import javax.swing.JOptionPane;

public class FrmCancelaciones extends javax.swing.JInternalFrame {

    public FrmCancelaciones() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtBuscarCancelaciones = new javax.swing.JTextField();
        btnBuscarCancelaciones = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCitaEstado = new javax.swing.JTable();
        comboEstadoCita = new javax.swing.JComboBox<>();
        btnActualizarEstado = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Cancelaciones");

        btnBuscarCancelaciones.setText("Buscar");
        btnBuscarCancelaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarCancelacionesActionPerformed(evt);
            }
        });

        tablaCitaEstado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaCitaEstado);

        comboEstadoCita.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pendiente", "Asistida", "Completada", " " }));
        comboEstadoCita.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboEstadoCitaMouseClicked(evt);
            }
        });

        btnActualizarEstado.setText("Actualizar");
        btnActualizarEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarEstadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtBuscarCancelaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(btnBuscarCancelaciones)
                .addGap(170, 170, 170))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(btnActualizarEstado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(comboEstadoCita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(159, 159, 159))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscarCancelaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarCancelaciones))
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboEstadoCita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizarEstado))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarCancelacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCancelacionesActionPerformed
        String documento = txtBuscarCancelaciones.getText().trim();
        if(documento.isEmpty()){
            JOptionPane.showMessageDialog(this, "Ingrese el documento del paciente", "Validacion", JOptionPane.WARNING_MESSAGE);
            txtBuscarCancelaciones.requestFocus();
            return;
        }
        datos.CitaDAO datosCita= new datos.CitaDAO();
        tablaCitaEstado.setModel(datosCita.buscarCitasPorPaciente(documento));
        if(tablaCitaEstado.getRowCount() == 0){
            JOptionPane.showMessageDialog(this, "No se encontraron citas registrars para el documento "+ documento, "Sistema", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnBuscarCancelacionesActionPerformed

    private void comboEstadoCitaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboEstadoCitaMouseClicked
       int fila=tablaCitaEstado.getSelectedRow();
       if(fila !=-1){
           String estadoActual = tablaCitaEstado.getValueAt(fila, 5).toString();
           comboEstadoCita.setSelectedItem(estadoActual);
       }
    }//GEN-LAST:event_comboEstadoCitaMouseClicked

    private void btnActualizarEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarEstadoActionPerformed
        int fila = tablaCitaEstado.getSelectedRow();
    if (fila == -1) {
        JOptionPane.showMessageDialog(this, "Debe seleccionar una cita de la tabla para poder cambiar su estado.", "Sistema", JOptionPane.WARNING_MESSAGE);
        return;
    }
        int idCita = Integer.parseInt(tablaCitaEstado.getValueAt(fila, 0).toString());
            String nuevoEstado = comboEstadoCita.getSelectedItem().toString();
            datos.CitaDAO datosCita = new datos.CitaDAO();
        if (datosCita.cambiarEstado(idCita, nuevoEstado)) { 
            JOptionPane.showMessageDialog(this, "El estado de la cita se actualizó correctamente.");
            String documento = txtBuscarCancelaciones.getText().trim();
            tablaCitaEstado.setModel(datosCita.buscarCitasPorPaciente(documento));
        
    }else{
        JOptionPane.showMessageDialog(this, "No se pudieron salvar los cambios en la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnActualizarEstadoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarEstado;
    private javax.swing.JButton btnBuscarCancelaciones;
    private javax.swing.JComboBox<String> comboEstadoCita;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaCitaEstado;
    private javax.swing.JTextField txtBuscarCancelaciones;
    // End of variables declaration//GEN-END:variables
}
