
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
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNombreModificar.setText("Nombre:");
        getContentPane().add(lblNombreModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 28, 74, -1));

        txtNombreModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreModificarActionPerformed(evt);
            }
        });
        getContentPane().add(txtNombreModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(139, 23, 138, -1));

        jLabel2.setText("Apellido");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 86, 74, -1));

        txtApellidoModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoModificarActionPerformed(evt);
            }
        });
        getContentPane().add(txtApellidoModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(139, 81, 138, -1));

        jLabel3.setText("Documento");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 152, 74, -1));

        txtDocumentoModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDocumentoModificarActionPerformed(evt);
            }
        });
        getContentPane().add(txtDocumentoModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(139, 147, 138, -1));

        jLabel4.setText("Telefono");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 228, 74, -1));
        getContentPane().add(txtTelefonoModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(139, 223, 138, -1));

        jLabel5.setText("Correo ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 286, 74, -1));
        getContentPane().add(txtCorreoModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(139, 281, 138, -1));

        jLabel6.setText("Direccion");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(337, 28, 58, -1));
        getContentPane().add(txtDireccionModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(413, 23, 122, -1));

        jLabel7.setText("Edad");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(337, 86, 58, -1));
        getContentPane().add(txtEdadModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(413, 81, 122, -1));

        jLabel8.setText("Entidad");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(337, 152, 58, -1));

        txtAreaHistorialModificar.setColumns(20);
        txtAreaHistorialModificar.setRows(5);
        ScrollHistorialMedico.setViewportView(txtAreaHistorialModificar);

        getContentPane().add(ScrollHistorialMedico, new org.netbeans.lib.awtextra.AbsoluteConstraints(327, 223, -1, 137));

        getContentPane().add(comboEntidadModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(413, 147, -1, -1));

        jLabel1.setText("Historial medico");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(337, 201, -1, -1));

        btnGuardarModifcar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/images/icons8-save-24.png"))); // NOI18N
        btnGuardarModifcar.setText("Guardar cambios");
        btnGuardarModifcar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarModifcarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardarModifcar, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 333, -1, -1));

        btnCancelarModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/images/icons8-cancel-24.png"))); // NOI18N
        btnCancelarModificar.setText("Cancelar");
        btnCancelarModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarModificarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelarModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(183, 333, -1, -1));

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
