package Vista.Medicos;

import Vista.*;
import Controlador.ControladorPaciente;
import Controlador.MedicoControlador;
import Modelo.MedicoM;
import Modelo.Paciente;
import javax.swing.table.DefaultTableModel;

public class ListarM extends javax.swing.JInternalFrame {
    DefaultTableModel tm = new DefaultTableModel();
    MedicoControlador mc = MedicoControlador.getInstancia();
    public ListarM() {
        initComponents();
        tablalist.setModel(tm);
        String columnas[] = {"Cedula", "Nombre", "Edad", "Sexo","Especialidad"};
        tm.addColumn(columnas[0]);
        tm.addColumn(columnas[1]);
        tm.addColumn(columnas[2]);
        tm.addColumn(columnas[3]);
        tm.addColumn(columnas[4]);
        
        listartodo();
    }
    public void listartodo (){
        for (MedicoM mm : mc.ListarMedicos()) {
            Object[] fila ={mm.getCedula(), mm.getNombre(), mm.getEdad(), mm.getSexo(),mm.GetEspecialidadmodelo()};
            tm.addRow(fila);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablalist = new javax.swing.JTable();
        txtcedulab = new javax.swing.JTextField();

        jLabel1.setText("Cedula a buscar: ");

        tablalist.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablalist);

        txtcedulab.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcedulaKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtcedulab, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 104, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtcedulab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtcedulaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcedulaKeyReleased
        tm.setRowCount(0);
        String cedula = txtcedulab.getText();
        for (MedicoM mm : mc.BuscarMedico(cedula)) {
            Object[] fila = {mm.getCedula(), mm.getNombre(), mm.getEdad(), mm.getSexo(),mm.GetEspecialidadmodelo()};
            tm.addRow(fila);
        }
    }//GEN-LAST:event_txtcedulaKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablalist;
    private javax.swing.JTextField txtcedulab;
    // End of variables declaration//GEN-END:variables
}
