
package Presentacion;

import javax.swing.JOptionPane;
import datos.PrepagadaDAO;
import entidades.Prepagada;

public class FrmModificarPaciente extends javax.swing.JInternalFrame {

    private int idPaciente;
    private String documentoAnt;
    
    public FrmModificarPaciente() {
        initComponents();
        cargarComboEntidades();
    }

public void cargarDatos(int id, String nombre, String apellido, String documento, String telefono, String correo, String edad, String direccion, String historial) {
    this.idPaciente = id;       
    this.documentoAnt = documento;
    
    txtNombreModificar.setText(nombre);
    txtApellidoModificar.setText(apellido);
    txtDocumentoModificar.setText(documento); // Asegúrate de tener esta línea
    txtTelefonoModificar.setText(telefono);
    txtCorreoModificar.setText(correo);
    txtEdadModificar.setText(edad);
    txtDireccionModificar.setText(direccion);
    txtAreaHistorialModificar.setText(historial);
}

    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNombreModificar = new javax.swing.JLabel();
        txtNombreModificar = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtApellidoModificar = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDocumentoModificar = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTelefonoModificar = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCorreoModificar = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtDireccionModificar = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtEdadModificar = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        ScrollHistorialMedico = new javax.swing.JScrollPane();
        txtAreaHistorialModificar = new javax.swing.JTextArea();
        comboEntidadModificar = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        btnGuardarModifcar = new javax.swing.JButton();
        btnCancelarModificar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Modificar paciente");

        lblNombreModificar.setText("Nombre:");

        txtNombreModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreModificarActionPerformed(evt);
            }
        });

        jLabel2.setText("Apellido");

        txtApellidoModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoModificarActionPerformed(evt);
            }
        });

        jLabel3.setText("Documento");

        txtDocumentoModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDocumentoModificarActionPerformed(evt);
            }
        });

        jLabel4.setText("Telefono");

        jLabel5.setText("Correo ");

        jLabel6.setText("Direccion");

        jLabel7.setText("Edad");

        jLabel8.setText("Entidad");

        txtAreaHistorialModificar.setColumns(20);
        txtAreaHistorialModificar.setRows(5);
        ScrollHistorialMedico.setViewportView(txtAreaHistorialModificar);

        jLabel1.setText("Historial medico");

        btnGuardarModifcar.setText("Guardar cambios");
        btnGuardarModifcar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarModifcarActionPerformed(evt);
            }
        });

        btnCancelarModificar.setText("Cancelar");
        btnCancelarModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarModificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblNombreModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE))
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNombreModificar)
                            .addComponent(txtApellidoModificar)
                            .addComponent(txtDocumentoModificar)
                            .addComponent(txtTelefonoModificar)
                            .addComponent(txtCorreoModificar, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnGuardarModifcar)
                        .addGap(38, 38, 38)
                        .addComponent(btnCancelarModificar)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                        .addComponent(ScrollHistorialMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtDireccionModificar)
                                    .addComponent(txtEdadModificar, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                                    .addComponent(comboEntidadModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreModificar)
                    .addComponent(txtNombreModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtDireccionModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtApellidoModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtEdadModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDocumentoModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(comboEntidadModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtTelefonoModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtCorreoModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGuardarModifcar)
                            .addComponent(btnCancelarModificar)))
                    .addComponent(ScrollHistorialMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreModificarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreModificarActionPerformed

    private void txtApellidoModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoModificarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoModificarActionPerformed

    private void txtDocumentoModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDocumentoModificarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDocumentoModificarActionPerformed

    private void btnCancelarModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarModificarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarModificarActionPerformed

    private void btnGuardarModifcarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarModifcarActionPerformed
      if (txtNombreModificar.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "El nombre es obligatorio.", "Validación", JOptionPane.WARNING_MESSAGE);
        txtNombreModificar.requestFocus();
        return;
    }
    if (txtApellidoModificar.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "El apellido es obligatorio.", "Validación", JOptionPane.WARNING_MESSAGE);
        txtApellidoModificar.requestFocus();
        return;
    }
    if (txtDocumentoModificar.getText().trim().isEmpty()) { 
        JOptionPane.showMessageDialog(this, "El documento es obligatorio.", "Validación", JOptionPane.WARNING_MESSAGE);
        txtDocumentoModificar.requestFocus();
        return;
    }
    if (txtEdadModificar.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "La edad es obligatoria.", "Validación", JOptionPane.WARNING_MESSAGE);
        txtEdadModificar.requestFocus();
        return;
    }

    int id = this.idPaciente; 
    String nombre = txtNombreModificar.getText().trim();
    String apellido = txtApellidoModificar.getText().trim();
    String documento = txtDocumentoModificar.getText().trim(); 
    String documentoAnt = this.documentoAnt;
    String telefono = txtTelefonoModificar.getText().trim();
    String correo = txtCorreoModificar.getText().trim();
    String direccion = txtDireccionModificar.getText().trim();
    String historial = txtAreaHistorialModificar.getText().trim();
    
    int edad;
    try {
        address_check: edad = Integer.parseInt(txtEdadModificar.getText().trim());
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "La edad debe ser un número entero válido.", "Validación", JOptionPane.WARNING_MESSAGE);
        txtEdadModificar.requestFocus();
        return;
    }
    Integer prepagadaID = null;
    if (comboEntidadModificar.getSelectedIndex() > 0) {
        String nombreSeleccionado = comboEntidadModificar.getSelectedItem().toString();
        datos.PrepagadaDAO prepagadaDao = new datos.PrepagadaDAO();
        
        for (entidades.Prepagada p : prepagadaDao.listar("")) { 
            if (p.getNombre().equals(nombreSeleccionado)) {
                prepagadaID = p.getId();
                break; 
            }
        }
    }
    Negocio.PacienteControl control = new Negocio.PacienteControl(); 
    String respuesta = control.actualizar(id, nombre, apellido, documento, documentoAnt, telefono, correo, edad, direccion, historial, prepagadaID);
    
    if(respuesta.equals("OK")){
        JOptionPane.showMessageDialog(this, "Los datos del paciente se actualizaron correctamente.", "Sistema", JOptionPane.INFORMATION_MESSAGE);
        this.dispose(); 
    }else{
        JOptionPane.showMessageDialog(this, respuesta, "Error del Sistema", JOptionPane.ERROR_MESSAGE);
    }
    
    }//GEN-LAST:event_btnGuardarModifcarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane ScrollHistorialMedico;
    private javax.swing.JButton btnCancelarModificar;
    private javax.swing.JButton btnGuardarModifcar;
    private javax.swing.JComboBox<String> comboEntidadModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lblNombreModificar;
    private javax.swing.JTextField txtApellidoModificar;
    private javax.swing.JTextArea txtAreaHistorialModificar;
    private javax.swing.JTextField txtCorreoModificar;
    private javax.swing.JTextField txtDireccionModificar;
    private javax.swing.JTextField txtDocumentoModificar;
    private javax.swing.JTextField txtEdadModificar;
    private javax.swing.JTextField txtNombreModificar;
    private javax.swing.JTextField txtTelefonoModificar;
    // End of variables declaration//GEN-END:variables

    private void cargarComboEntidades() {
    datos.PrepagadaDAO prepagadaDao = new datos.PrepagadaDAO();
    comboEntidadModificar.removeAllItems();
    comboEntidadModificar.addItem("Sin Entidad / Particular");
    try{
        java.util.List<entidades.Prepagada> lista = prepagadaDao.listar(""); 
        for(entidades.Prepagada p : lista){
            comboEntidadModificar.addItem(p.getNombre());
        }
    }catch(Exception e){
        JOptionPane.showMessageDialog(this, "Error al cargar las entidades prepagadas: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}
    }
