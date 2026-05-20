
package Presentacion;

import javax.swing.JOptionPane;
import Negocio.PacienteControl;
import java.util.List;

public class FrmPacientes extends javax.swing.JInternalFrame {

    
    private int idPaciente;
    private String documentoAnt;
    private String accion = "guardar"; 
    
    public FrmPacientes() {
        initComponents();
        inicializarComponentesRegistro();
        
    }
    
   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        RegistroNombre = new javax.swing.JLabel();
        txtNombreRegis = new javax.swing.JTextField();
        RegistroApellido = new javax.swing.JLabel();
        txtTelefonoRegis = new javax.swing.JTextField();
        RegistroTipoDocumento = new javax.swing.JLabel();
        ComboTipoDocumentoRegis = new javax.swing.JComboBox<>();
        RegistroTelefono = new javax.swing.JLabel();
        RegistroCorreo = new javax.swing.JLabel();
        txtApellidoRegis = new javax.swing.JTextField();
        txtCorreoRegis = new javax.swing.JTextField();
        btnGuardarRegis = new javax.swing.JButton();
        btnCancelarRegis = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        DocumentoRegis = new javax.swing.JLabel();
        DireccionRegis = new javax.swing.JLabel();
        EdadRegis = new javax.swing.JLabel();
        EntidadRegis = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaHistorialMedico = new javax.swing.JTextArea();
        txtEdadRegis = new javax.swing.JTextField();
        txtDireccionRegis = new javax.swing.JTextField();
        txtDocumentoRegis = new javax.swing.JTextField();
        comboEntidadRegis = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Registro");

        RegistroNombre.setText("Nombre(*)");

        txtNombreRegis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreRegisActionPerformed(evt);
            }
        });

        RegistroApellido.setText("Apellido");

        RegistroTipoDocumento.setText("Tipo de Documento");

        ComboTipoDocumentoRegis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "C.C", "N.I.T", "C.E", "Pasaporte" }));

        RegistroTelefono.setText("Telefono");

        RegistroCorreo.setText("Correo");

        btnGuardarRegis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/images/icons8-save-24.png"))); // NOI18N
        btnGuardarRegis.setText("Guardar");
        btnGuardarRegis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarRegisActionPerformed(evt);
            }
        });

        btnCancelarRegis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/images/icons8-cancel-24.png"))); // NOI18N
        btnCancelarRegis.setText("Cancelar");
        btnCancelarRegis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarRegisActionPerformed(evt);
            }
        });

        DocumentoRegis.setText("Documento");

        DireccionRegis.setText("Direccion");

        EdadRegis.setText("Edad");

        EntidadRegis.setText("Entidad(*)");

        txtAreaHistorialMedico.setColumns(20);
        txtAreaHistorialMedico.setRows(5);
        txtAreaHistorialMedico.setText("Historial Medico:\n");
        jScrollPane1.setViewportView(txtAreaHistorialMedico);

        comboEntidadRegis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SaludPlus", "Sanitas", "Salud Total" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(EdadRegis, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtEdadRegis, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(DireccionRegis, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtDireccionRegis, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(DocumentoRegis, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtDocumentoRegis, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(EntidadRegis, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(comboEntidadRegis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addGap(15, 15, 15))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DocumentoRegis, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDocumentoRegis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEdadRegis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EdadRegis, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DireccionRegis, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDireccionRegis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EntidadRegis, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboEntidadRegis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RegistroTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(RegistroTipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(RegistroApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(RegistroNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(RegistroCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ComboTipoDocumentoRegis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtApellidoRegis, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombreRegis, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTelefonoRegis, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCorreoRegis, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(btnGuardarRegis)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelarRegis)
                        .addGap(75, 75, 75)))
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(RegistroNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombreRegis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(RegistroApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtApellidoRegis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(RegistroTipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ComboTipoDocumentoRegis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(RegistroTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTelefonoRegis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCorreoRegis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(RegistroCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(76, 76, 76)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGuardarRegis)
                            .addComponent(btnCancelarRegis))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarRegisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarRegisActionPerformed
        if(txtNombreRegis.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "El campo Nombre es obligatorio", "Validacion", JOptionPane.WARNING_MESSAGE);
            txtNombreRegis.requestFocus();
            return;
        }
        
         if(txtApellidoRegis.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "El campo Apellido es obligatorio", "Validacion", JOptionPane.WARNING_MESSAGE);
            txtApellidoRegis.requestFocus();
            return;
        }
         
          if(txtTelefonoRegis.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "El campo Telefono es obligatorio", "Validacion", JOptionPane.WARNING_MESSAGE);
            txtTelefonoRegis.requestFocus();
            return;
        }
          
           if(txtCorreoRegis.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "El campo Correo es obligatorio", "Validacion", JOptionPane.WARNING_MESSAGE);
            txtCorreoRegis.requestFocus();
            return;
        }
        
        
        if(txtDocumentoRegis.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "El campo Documento es obligatorio", "Validacion", JOptionPane.WARNING_MESSAGE);
            txtDocumentoRegis.requestFocus();
            return;
        }
        
        if(txtEdadRegis.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "El campo Edad es obligatorio", "Validacion", JOptionPane.WARNING_MESSAGE);
            txtEdadRegis.requestFocus();
            return;
     }
        
         if(txtDireccionRegis.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "El campo Direccion es obligatorio", "Validacion", JOptionPane.WARNING_MESSAGE);
            txtDireccionRegis.requestFocus();
            return;
        }
         
        String nombre = txtNombreRegis.getText().trim();
        String apellido = txtApellidoRegis.getText().trim();
        String tipoDocumento = ComboTipoDocumentoRegis.getSelectedItem().toString(); 
        String telefono = txtTelefonoRegis.getText().trim();
        String correo = txtCorreoRegis.getText().trim();
        String documento = txtDocumentoRegis.getText().trim();
        String direccion = txtDireccionRegis.getText().trim();
        String historialMedico = txtAreaHistorialMedico.getText().trim();
        
        int edad = 0;
        try{
            edad=Integer.parseInt(txtEdadRegis.getText().trim());
            if(edad< 0 || edad > 110){
                JOptionPane.showMessageDialog(this, "Por favor ingrese una edad valida", "Validacion", JOptionPane.WARNING_MESSAGE);
                txtEdadRegis.requestFocus();
                return;
            }
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(this, "La edad debe ser un numero entero", "Validacion", JOptionPane.WARNING_MESSAGE);
            txtEdadRegis.requestFocus();
        return;
        }
        // ------------ TERMINAR PREPAGADA ----------
        Integer prepagadaID=null;
        if(comboEntidadRegis.getSelectedIndex() > 0){
            
        }
        
        PacienteControl control = new PacienteControl();

        String rta = control.insertar(nombre, apellido, documento, telefono, correo, edad, direccion, historialMedico,
            prepagadaID);
        
        if(rta.equals("OK")){
            JOptionPane.showMessageDialog(this, "Paciente registrado correctamente");
        limpiarCampos();
        }
    }//GEN-LAST:event_btnGuardarRegisActionPerformed

    private void txtNombreRegisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreRegisActionPerformed
       
    }//GEN-LAST:event_txtNombreRegisActionPerformed

    private void btnCancelarRegisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarRegisActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_btnCancelarRegisActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboTipoDocumentoRegis;
    private javax.swing.JLabel DireccionRegis;
    private javax.swing.JLabel DocumentoRegis;
    private javax.swing.JLabel EdadRegis;
    private javax.swing.JLabel EntidadRegis;
    private javax.swing.JLabel RegistroApellido;
    private javax.swing.JLabel RegistroCorreo;
    private javax.swing.JLabel RegistroNombre;
    private javax.swing.JLabel RegistroTelefono;
    private javax.swing.JLabel RegistroTipoDocumento;
    private javax.swing.JButton btnCancelarRegis;
    private javax.swing.JButton btnGuardarRegis;
    private javax.swing.JComboBox<String> comboEntidadRegis;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtApellidoRegis;
    private javax.swing.JTextArea txtAreaHistorialMedico;
    private javax.swing.JTextField txtCorreoRegis;
    private javax.swing.JTextField txtDireccionRegis;
    private javax.swing.JTextField txtDocumentoRegis;
    private javax.swing.JTextField txtEdadRegis;
    private javax.swing.JTextField txtNombreRegis;
    private javax.swing.JTextField txtTelefonoRegis;
    // End of variables declaration//GEN-END:variables

    private void limpiarCampos() {
    txtNombreRegis.setText("");
    txtApellidoRegis.setText("");
    txtTelefonoRegis.setText("");
    txtCorreoRegis.setText("");
    txtDocumentoRegis.setText("");
    txtEdadRegis.setText("");
    txtDireccionRegis.setText("");
    txtAreaHistorialMedico.setText("");

    ComboTipoDocumentoRegis.setSelectedIndex(0);
    comboEntidadRegis.setSelectedIndex(0);

    txtNombreRegis.requestFocus();
        
    }
    
   public void cargarDatosModificar(int id, String nombre, String apellido, String documento, String telefono, String correo, String edad, String direccion, String historial, String prepagada) {
    this.accion = "editar";
    this.idPaciente = id;
    this.documentoAnt = documento;
    txtNombreRegis.setText(nombre);
    txtApellidoRegis.setText(apellido);
    txtDocumentoRegis.setText(documento);
    txtTelefonoRegis.setText(telefono);
    txtCorreoRegis.setText(correo);
    txtEdadRegis.setText(edad);
    txtDireccionRegis.setText(direccion);
    txtAreaHistorialMedico.setText(historial);
    
    if(prepagada != null && !prepagada.isEmpty()){
        comboEntidadRegis.setSelectedItem(prepagada);
    }else{
        comboEntidadRegis.setSelectedIndex(0);
    }
}
    
private void inicializarComponentesRegistro() {
    ComboTipoDocumentoRegis.removeAllItems();
    ComboTipoDocumentoRegis.addItem("Seleccione...");
    ComboTipoDocumentoRegis.addItem("C.C.");
    ComboTipoDocumentoRegis.addItem("T.I.");
    ComboTipoDocumentoRegis.addItem("C.E.");
    ComboTipoDocumentoRegis.addItem("Pasaporte");
    comboEntidadRegis.removeAllItems();
    comboEntidadRegis.addItem("Seleccione...");
    
    try{
        datos.PrepagadaDAO prepagadaDao = new datos.PrepagadaDAO();
        List<entidades.Prepagada> listaPrepagadas = prepagadaDao.listar("");
        
        for(entidades.Prepagada p:listaPrepagadas){
            if(p.isActivo()){ 
                comboEntidadRegis.addItem(p.getNombre());
            }
        }
    }catch(Exception e){
        System.out.println("Error temporal al conectar combos: " + e.getMessage());
    }
}

}
