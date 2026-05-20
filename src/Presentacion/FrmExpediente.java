
package Presentacion;

import Negocio.PacienteControl;
import entidades.Paciente;
import datos.PacienteDAO;
import javax.swing.JOptionPane;
import entidades.Prepagada;
import datos.PrepagadaDAO;

public class FrmExpediente extends javax.swing.JInternalFrame {

    
    public FrmExpediente() {
        initComponents();
    }

    
    public void cargarExpediente(int idPaciente){
        PacienteDAO controlPaciente = new PacienteDAO();
        Paciente p =controlPaciente.obtenerPacientePorId(idPaciente);
        if(p !=null){
            lblNombreExpediente.setText("Paciente: " + p.getNombre() + " " + p.getApellido());
            lblDocumentoExpediente.setText("Documento: " +p.getDocumento());
            lblEdadExpediente.setText("Edad: "+p.getEdad() + " años");
            txtAreaHistorialExpediente.setText(p.getHistorialMedico());
            datos.CitaDAO controlCita = new datos.CitaDAO();
            tablaCitas.setModel(controlCita.listarHistorialCitasPorPaciente(idPaciente));
        }else{
            JOptionPane.showMessageDialog(this, "No hay historial clinico para esta persona", "Historial", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNombreExpediente = new javax.swing.JLabel();
        lblDocumentoExpediente = new javax.swing.JLabel();
        lblEdadExpediente = new javax.swing.JLabel();
        lblEntidadExpediente = new javax.swing.JLabel();
        lblHistorialExpediente = new javax.swing.JLabel();
        ScrollHistorialAntecedentes = new javax.swing.JScrollPane();
        txtAreaHistorialExpediente = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        ScrollHistorialCitas = new javax.swing.JScrollPane();
        tablaCitas = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Expediente");

        lblNombreExpediente.setText("Paciente");

        lblDocumentoExpediente.setText("Documento");

        lblEdadExpediente.setText("Edad");

        lblEntidadExpediente.setText("Entidad");

        lblHistorialExpediente.setText("Historial Clinico");

        txtAreaHistorialExpediente.setEditable(false);
        txtAreaHistorialExpediente.setColumns(20);
        txtAreaHistorialExpediente.setRows(5);
        ScrollHistorialAntecedentes.setViewportView(txtAreaHistorialExpediente);

        jLabel1.setText("Historial Citas medicas");

        tablaCitas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        ScrollHistorialCitas.setViewportView(tablaCitas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(lblHistorialExpediente)
                        .addGap(47, 47, 47)
                        .addComponent(ScrollHistorialAntecedentes, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(lblNombreExpediente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblDocumentoExpediente)))
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(lblEdadExpediente))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(ScrollHistorialCitas, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(lblEntidadExpediente)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreExpediente)
                    .addComponent(lblDocumentoExpediente)
                    .addComponent(lblEdadExpediente)
                    .addComponent(lblEntidadExpediente))
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblHistorialExpediente)
                    .addComponent(jLabel1)
                    .addComponent(ScrollHistorialCitas, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(ScrollHistorialAntecedentes, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE))
                .addContainerGap(244, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane ScrollHistorialAntecedentes;
    private javax.swing.JScrollPane ScrollHistorialCitas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblDocumentoExpediente;
    private javax.swing.JLabel lblEdadExpediente;
    private javax.swing.JLabel lblEntidadExpediente;
    private javax.swing.JLabel lblHistorialExpediente;
    private javax.swing.JLabel lblNombreExpediente;
    private javax.swing.JTable tablaCitas;
    private javax.swing.JTextArea txtAreaHistorialExpediente;
    // End of variables declaration//GEN-END:variables
}
