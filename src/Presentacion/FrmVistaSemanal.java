
package Presentacion;

import javax.swing.JOptionPane;

public class FrmVistaSemanal extends javax.swing.JInternalFrame {

    private javax.swing.JTextField txtBuscarCita;
    
    public FrmVistaSemanal() {
        initComponents();
        txtBuscarCita = new javax.swing.JTextField();
        txtBuscarCita.setToolTipText("Buscar por nombre, apellido, documento o estado...");
        txtBuscarCita.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                refrescarTablaSemanal();
            }
        });
        dcFiltroFecha.setDate(new java.util.Date());
        refrescarTablaSemanal();
        
        txtBuscarCita.addKeyListener(new java.awt.event.KeyAdapter() {
    @Override
    public void keyReleased(java.awt.event.KeyEvent evt) {
        // Llamamos al método de búsqueda cada vez que se suelta una tecla
        buscarCitasPorCriterio();
    }
});
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dcFiltroFecha = new com.toedter.calendar.JDateChooser();
        btnFiltrarFecha = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCitasGenerales = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Vista Semanal");

        btnFiltrarFecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentacion/images/icons8-check-box-with-check-24.png"))); // NOI18N
        btnFiltrarFecha.setText("Filtrar fecha");
        btnFiltrarFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarFechaActionPerformed(evt);
            }
        });

        tablaCitasGenerales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaCitasGenerales);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 598, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(dcFiltroFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(btnFiltrarFecha)))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnFiltrarFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dcFiltroFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(53, 53, 53)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(73, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFiltrarFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarFechaActionPerformed
        if(dcFiltroFecha.getDate() == null){
            JOptionPane.showMessageDialog(this, "Por favor, seleccione una fecha para buscar.", "Sistema", JOptionPane.WARNING_MESSAGE);
            return;
        }
        refrescarTablaSemanal();
    }//GEN-LAST:event_btnFiltrarFechaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFiltrarFecha;
    private com.toedter.calendar.JDateChooser dcFiltroFecha;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaCitasGenerales;
    // End of variables declaration//GEN-END:variables

  private void refrescarTablaSemanal() {
        try {
            if (dcFiltroFecha.getDate() == null) {
                return; 
            }
            
            java.util.Date fechaSeleccionada = dcFiltroFecha.getDate();
            
            // --- CÁLCULO DINÁMICO DE LA SEMANA (LUNES A DOMINGO) ---
            java.util.Calendar cal = java.util.Calendar.getInstance();
            cal.setTime(fechaSeleccionada);
            
            cal.setFirstDayOfWeek(java.util.Calendar.MONDAY); 
            cal.set(java.util.Calendar.DAY_OF_WEEK, java.util.Calendar.MONDAY);
            java.sql.Date fechaInicio = new java.sql.Date(cal.getTimeInMillis());
            
            cal.add(java.util.Calendar.DAY_OF_WEEK, 6);
            java.sql.Date fechaFin = new java.sql.Date(cal.getTimeInMillis());
            // -------------------------------------------------------

            // Captura el texto de lo que vas escribiendo (puedes dejarlo vacío y traerá todo el rango)
            String textoBuscar = (txtBuscarCita != null) ? txtBuscarCita.getText().trim() : "";
            
            datos.CitaDAO citaDao = new datos.CitaDAO();
            
            // Inyectamos el DefaultTableModel estructurado multicriterio que añadimos en CitaDAO
            tablaCitasGenerales.setModel(citaDao.listarCitasSemanalesConFiltro(fechaInicio, fechaFin, textoBuscar));
            
        } catch (Exception e) {
            System.out.println("Error procesando filtros semanales: " + e.getMessage());
        }
        }
  
  private void buscarCitasPorCriterio() {
    try {
        // 1. Validamos que haya una fecha seleccionada en el JDateChooser
        if (dcFiltroFecha.getDate() == null) {
            return; 
        }
        
        java.util.Date fechaSeleccionada = dcFiltroFecha.getDate();
        
        // 2. Calculamos el rango de la semana (Lunes a Domingo) automáticamente
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.setTime(fechaSeleccionada);
        cal.setFirstDayOfWeek(java.util.Calendar.MONDAY); 
        cal.set(java.util.Calendar.DAY_OF_WEEK, java.util.Calendar.MONDAY);
        java.sql.Date fechaInicio = new java.sql.Date(cal.getTimeInMillis());
        
        cal.add(java.util.Calendar.DAY_OF_WEEK, 6);
        java.sql.Date fechaFin = new java.sql.Date(cal.getTimeInMillis());

        // 3. Capturamos el texto que el usuario ingresa en la barra de búsqueda
        // .trim() elimina espacios vacíos al inicio o al final para evitar errores
        String textoBuscar = txtBuscarCita.getText().trim();
        
        // 4. Instanciamos el DAO de Citas
        datos.CitaDAO citaDao = new datos.CitaDAO();
        
        // 5. Enviamos los parámetros al método optimizado del DAO y cargamos la tabla directamente
        tablaCitasGenerales.setModel(citaDao.listarCitasSemanalesConFiltro(fechaInicio, fechaFin, textoBuscar));
        
    } catch (Exception e) {
        System.out.println("Error al ejecutar la búsqueda multicriterio: " + e.getMessage());
    }
}

}
