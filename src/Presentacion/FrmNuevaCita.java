
package Presentacion;

import datos.MedicoDAO;
import javax.swing.JOptionPane;
import datos.PacienteDAO;
import entidades.Persona;

public class FrmNuevaCita extends javax.swing.JInternalFrame {

    private int idPacienteNuevaCita =0;
    
    
    public FrmNuevaCita() {
        initComponents();
        MedicoDAO controlMedico = new MedicoDAO();
        comboMedicoNuevaCita.setModel(controlMedico.seleccionaMedicos());
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtBuscarNuevaCita = new javax.swing.JTextField();
        btnBuscarNuevaCita = new javax.swing.JButton();
        comboMedicoNuevaCita = new javax.swing.JComboBox<>();
        dcFechaNuevaCita = new com.toedter.calendar.JDateChooser();
        comboHoraNuevaCita = new javax.swing.JComboBox<>();
        ScrollHoraNuevaCita = new javax.swing.JScrollPane();
        txtAreaMotivo = new javax.swing.JTextArea();
        btnGuardarCita = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Nueva Cita");

        txtBuscarNuevaCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarNuevaCitaActionPerformed(evt);
            }
        });

        btnBuscarNuevaCita.setText("Buscar");
        btnBuscarNuevaCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarNuevaCitaActionPerformed(evt);
            }
        });

        comboHoraNuevaCita.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "08:00am", "08:30am", "09:00am", "09:30am", "10:00am", "14:00pm", "14:30pm" }));
        comboHoraNuevaCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboHoraNuevaCitaActionPerformed(evt);
            }
        });

        txtAreaMotivo.setColumns(20);
        txtAreaMotivo.setRows(5);
        ScrollHoraNuevaCita.setViewportView(txtAreaMotivo);

        btnGuardarCita.setText("Guardar");
        btnGuardarCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarCitaActionPerformed(evt);
            }
        });

        jLabel1.setText("Medico:");

        jLabel2.setText("Fecha:");

        jLabel3.setText("Hora:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtBuscarNuevaCita, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btnBuscarNuevaCita))
                    .addComponent(ScrollHoraNuevaCita, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 29, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dcFechaNuevaCita, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardarCita, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(comboHoraNuevaCita, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboMedicoNuevaCita, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscarNuevaCita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarNuevaCita)
                    .addComponent(comboMedicoNuevaCita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ScrollHoraNuevaCita, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dcFechaNuevaCita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboHoraNuevaCita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addComponent(btnGuardarCita)))
                .addContainerGap(121, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarNuevaCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarNuevaCitaActionPerformed
        if(txtBuscarNuevaCita.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Por favor ingrese el documento del paciente", "Sistema", JOptionPane.INFORMATION_MESSAGE);
            txtBuscarNuevaCita.requestFocus();
            return;
            
        }
        
        String documento = txtBuscarNuevaCita.getText().trim();
        
        datos.PacienteDAO datosPaciente = new datos.PacienteDAO();
        entidades.Paciente p = datosPaciente.obtenerPacientePorDocumento(documento);
        if(p !=null){
            this.idPacienteNuevaCita = p.getId();
            
            String motivo = " ----- PACIENTE ENCONTRADO -----\n\n"
                    +"Nombre: "+p.getNombre() + " "+p.getApellido() + "\n"
                    +"Documento: "+p.getDocumento() + "\n"
                    +"Edad: "+p.getEdad() +"\n"
                    +"Direccion: "+p.getDireccion() + "\n"
                    +"Historial: "+p.getHistorialMedico();
            
            txtAreaMotivo.setText(motivo);
        }else{
            this.idPacienteNuevaCita=0;
            txtAreaMotivo.setText("");
            JOptionPane.showMessageDialog(this, "No se encontro ningun paciente con el documento "+p.getDocumento(), "Sistema", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnBuscarNuevaCitaActionPerformed

    private void txtBuscarNuevaCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarNuevaCitaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarNuevaCitaActionPerformed

    private void btnGuardarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCitaActionPerformed
        if (this.idPacienteNuevaCita == 0) {
        JOptionPane.showMessageDialog(this, "Debe buscar y seleccionar un paciente primero.", "Validación", JOptionPane.WARNING_MESSAGE);
        return;
    }
    
    if (comboMedicoNuevaCita.getSelectedIndex() == 0) {
        JOptionPane.showMessageDialog(this, "Debe seleccionar un médico.", "Validación", JOptionPane.WARNING_MESSAGE);
        return;
    }
    
    if (dcFechaNuevaCita.getDate() == null) {
        JOptionPane.showMessageDialog(this, "Debe seleccionar una fecha.", "Validación", JOptionPane.WARNING_MESSAGE);
        return;
    }

    try {
       
        java.util.Date fechaUtil = dcFechaNuevaCita.getDate();
        java.sql.Date fechaSQL = new java.sql.Date(fechaUtil.getTime());

       
        String horaTexto = comboHoraNuevaCita.getSelectedItem().toString().trim();
        if (horaTexto.toLowerCase().contains("am") || horaTexto.toLowerCase().contains("pm")) {
        horaTexto = horaTexto.replaceAll("(?i)[a-z\\s]+", ""); 
}
        if (horaTexto.length() == 5) { 
        horaTexto += ":00";
}
java.sql.Time horaSQL = java.sql.Time.valueOf(horaTexto);
        Persona med = (Persona) comboMedicoNuevaCita.getSelectedItem();
        int idMedico = med.getId();

        String motivo = txtAreaMotivo.getText().trim();
        entidades.Cita nuevaCita = new entidades.Cita();
        nuevaCita.setFecha(fechaSQL);
        nuevaCita.setHora(horaSQL);
        nuevaCita.setEstado("Pendiente"); 
        nuevaCita.setMotivo(motivo);
        nuevaCita.setPacienteID(this.idPacienteNuevaCita);
        nuevaCita.setMedicoID(idMedico);
        datos.CitaDAO citaDAO = new datos.CitaDAO();
        if (citaDAO.insertar(nuevaCita)) {
            JOptionPane.showMessageDialog(this, "¡Cita registrada con éxito!", "Sistema", JOptionPane.INFORMATION_MESSAGE);
            
            txtBuscarNuevaCita.setText("");
            txtAreaMotivo.setText("");
            txtAreaMotivo.setText("");
            comboMedicoNuevaCita.setSelectedIndex(0);
            comboHoraNuevaCita.setSelectedIndex(0);
            dcFechaNuevaCita.setDate(null);
            this.idPacienteNuevaCita = 0;
        } else {
            JOptionPane.showMessageDialog(this, "La base de datos rechazó el registro de la cita.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error de formato de datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnGuardarCitaActionPerformed

    private void comboHoraNuevaCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboHoraNuevaCitaActionPerformed
       
    }//GEN-LAST:event_comboHoraNuevaCitaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane ScrollHoraNuevaCita;
    private javax.swing.JButton btnBuscarNuevaCita;
    private javax.swing.JButton btnGuardarCita;
    private javax.swing.JComboBox<String> comboHoraNuevaCita;
    private javax.swing.JComboBox<String> comboMedicoNuevaCita;
    private com.toedter.calendar.JDateChooser dcFechaNuevaCita;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextArea txtAreaMotivo;
    private javax.swing.JTextField txtBuscarNuevaCita;
    // End of variables declaration//GEN-END:variables
}
