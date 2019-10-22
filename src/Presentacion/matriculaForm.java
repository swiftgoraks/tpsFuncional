/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Datos.AlumnoJpaController;
import Logica_Negocio.Alumno;
import Logica_Negocio.Grado;
import Logica_Negocio.Turno;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Datos.ManejadorMatricula;
import Logica_Negocio.MatriculaProd;

/**
 *
 * @author ronal
 */
public class matriculaForm extends javax.swing.JFrame {

    /**
     * Creates new form matriculaForm
     */
    
    DefaultTableModel modeloTable;
    
     DefaultTableModel modeloTableMatriculas;
    Grado grado = new Grado();
    Turno turno = new Turno();
    
    
    
     AlumnoJpaController CAlumno= new AlumnoJpaController();
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    
     Alumno AlumnoEdit;
     
     ManejadorMatricula manMatricula = new ManejadorMatricula();
     
    MatriculaProd matEdit;
    
    public matriculaForm() {
        initComponents();
        
        grado.ComboGrado(comboGrado);
        turno.ComboTurno(comboTurno);
        modeloTable = (DefaultTableModel) this.tableAlumno.getModel();
        modeloTableMatriculas = (DefaultTableModel) this.tablaMatriculas.getModel();

          
         
        CargarAlumno();
        manMatricula.extraerDatos(tablaMatriculas);
       
        btnActualizar.setEnabled(false);
        btnEliminar.setEnabled(false);
       btnMatricular.setEnabled(false);
    }
    
    public void Limpear() {
        
        lblNameA.setText("-----");
        this.comboGrado.setSelectedIndex(0);
        this.comboTurno.setSelectedIndex(0);
        btnActualizar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnMatricular.setEnabled(false);
        
    }
    
    
        public void CargarAlumno() {
        try {
            modeloTable.setRowCount(0);
            Date fecha;
            Object o[] = null;
            List<Alumno> ListA = CAlumno.findAlumnoEntities();
            for (int i = 0; i < ListA.size(); i++) {
            
                modeloTable.addRow(o);
               
                modeloTable.setValueAt(ListA.get(i), i, 0);
                 modeloTable.setValueAt(ListA.get(i).getIdAlumno(), i, 1); 
                modeloTable.setValueAt(ListA.get(i).getNombre()+ " " + ListA.get(i).getApellido(), i, 2);   
                fecha = ListA.get(i).getFechaNac();
                String fechaTexto = formatter.format(fecha);
                modeloTable.setValueAt(fechaTexto, i,3);
                modeloTable.setValueAt(ListA.get(i).getIdEncargado().getNombre()+" "+ListA.get(i).getIdEncargado().getApellido(), i, 4);
            }

        } catch (Exception e) {
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableAlumno = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        lblNameA = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        comboGrado = new javax.swing.JComboBox<>();
        comboTurno = new javax.swing.JComboBox<>();
        btnMatricular = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpear = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaMatriculas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel2.setText("Alumno:");

        tableAlumno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "EntidadAlumno", "ID", "Nombre", "Fecha de Nacimiento", "Encargado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableAlumno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableAlumnoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableAlumno);

        jLabel3.setText("Alumno Seleccionado:");

        lblNameA.setText("----");

        jLabel4.setText("Seleccionar Grado:");

        jLabel5.setText("Seleccionar Turno:");

        btnMatricular.setText("Matricular");
        btnMatricular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMatricularActionPerformed(evt);
            }
        });

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnLimpear.setText("Limpear");
        btnLimpear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 775, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(18, 18, 18)
                                    .addComponent(comboGrado, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(18, 18, 18)
                                    .addComponent(comboTurno, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(lblNameA, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(32, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnMatricular, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btnActualizar)
                .addGap(26, 26, 26)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btnLimpear, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(182, 182, 182))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblNameA))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(comboGrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(comboTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMatricular)
                    .addComponent(btnActualizar)
                    .addComponent(btnEliminar)
                    .addComponent(btnLimpear))
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Matricula");

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jLabel6.setText("Lista de matriculas:");

        tablaMatriculas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Matricula", "Alumno", "Grado", "Turno", "Fecha de Matricula"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaMatriculas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMatriculasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaMatriculas);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(331, 331, 331)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableAlumnoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableAlumnoMouseClicked
        // TODO add your handling code here:
        
        try {  
             int indice = this.tableAlumno.getSelectedRow();

                if (indice > -1) 
                {
                    Limpear();
                    btnMatricular.setEnabled(true);
                    
                       lblNameA.setText(modeloTable.getValueAt(indice, 2).toString());
                       
                       AlumnoEdit = (Alumno) tableAlumno.getValueAt(tableAlumno.getSelectedRow(), 0);

                       //this.cbEncargado.setSelectedItem((modeloTable.getValueAt(indice, 4)));
                }
         } catch (Exception e) 
            {
                
            }
    }//GEN-LAST:event_tableAlumnoMouseClicked

    private void btnMatricularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMatricularActionPerformed
        // TODO add your handling code here:
        
        MatriculaProd matriAdd = new MatriculaProd();
        
        matriAdd.setIDAlumno(Integer.parseInt(AlumnoEdit.getIdAlumno().toString()));
        
        
        matriAdd.setGradoName(comboGrado.getSelectedItem().toString());
        
        
        matriAdd.setTurnoName(comboTurno.getSelectedItem().toString());
        
        //JOptionPane.showMessageDialog(null, matriAdd.getIDAlumno());
        
        
        ManejadorMatricula newInsert = new ManejadorMatricula();
        
        try {
            newInsert.agregarMatricula(matriAdd);
            manMatricula.extraerDatos(tablaMatriculas);
            Limpear();
            btnMatricular.setEnabled(false);
        } catch (SQLException ex) {
            Logger.getLogger(matriculaForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnMatricularActionPerformed

    private void tablaMatriculasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMatriculasMouseClicked
        // TODO add your handling code here:
        
          int indice = tablaMatriculas.getSelectedRow();
          
          if (indice > -1 ) {

              btnMatricular.setEnabled(false);
              btnActualizar.setEnabled(true);
              btnEliminar.setEnabled(true);
              
              
              lblNameA.setText(tablaMatriculas.getValueAt(indice, 1).toString());
              matEdit = new MatriculaProd();

              matEdit.setIdMatricula(Integer.parseInt(tablaMatriculas.getValueAt(indice, 0).toString()));
              matEdit.setGradoName(tablaMatriculas.getValueAt(indice, 2).toString());
              matEdit.setTurnoName(tablaMatriculas.getValueAt(indice, 3).toString());
              
              
              
              
              
              for (int i = 0; i < this.comboGrado.getItemCount(); i++) {
                  if (this.comboGrado.getItemAt(i).toString().equals(tablaMatriculas.getValueAt(indice, 2).toString())) {
                      this.comboGrado.setSelectedIndex(i);
                      break;
                  }
              }
              
              for (int i = 0; i < this.comboTurno.getItemCount(); i++) {
                  if (this.comboTurno.getItemAt(i).toString().equals(tablaMatriculas.getValueAt(indice, 3).toString())) {
                      this.comboTurno.setSelectedIndex(i);
                      break;
                  }
              }
            
        }
        
    }//GEN-LAST:event_tablaMatriculasMouseClicked

    private void btnLimpearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpearActionPerformed
        // TODO add your handling code here:
        
        
        
         
        Limpear();
    }//GEN-LAST:event_btnLimpearActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        
         ManejadorMatricula newEdit = new ManejadorMatricula();
        llenarMatriculaEdit();
        matEdit.setOpcion(1);
        try {
            newEdit.editarMatricula(matEdit);
            Limpear();
            manMatricula.extraerDatos(tablaMatriculas);
            
        } catch (SQLException ex) {
            Logger.getLogger(matriculaForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:

        ManejadorMatricula newEdit = new ManejadorMatricula();
        llenarMatriculaEdit();
        matEdit.setOpcion(2);
        try {
            newEdit.editarMatricula(matEdit);
            Limpear();
            manMatricula.extraerDatos(tablaMatriculas);

        } catch (SQLException ex) {
            Logger.getLogger(matriculaForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    public void llenarMatriculaEdit(){
    
        matEdit.setGradoName(comboGrado.getSelectedItem().toString());
        matEdit.setTurnoName(comboTurno.getSelectedItem().toString());
    }
    
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
            java.util.logging.Logger.getLogger(matriculaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(matriculaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(matriculaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(matriculaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new matriculaForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpear;
    private javax.swing.JButton btnMatricular;
    private javax.swing.JComboBox<Grado> comboGrado;
    private javax.swing.JComboBox<Logica_Negocio.Turno> comboTurno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblNameA;
    private javax.swing.JTable tablaMatriculas;
    private javax.swing.JTable tableAlumno;
    // End of variables declaration//GEN-END:variables
}