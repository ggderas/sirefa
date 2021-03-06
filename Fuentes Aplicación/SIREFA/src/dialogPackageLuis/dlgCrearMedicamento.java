/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dialogPackageLuis;

import classpackage.Medicamento;
import classpackage.Tipo_medicamento;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis Manuel
 */
public class dlgCrearMedicamento extends javax.swing.JDialog {

    
    private Medicamento medicamento;
    private Tipo_medicamento tipoMedicamento;
    private ArrayList<Tipo_medicamento> listaDeTiposMedicamento;
    /**
     * Creates new form dlgCrearMedicamento
     */
    public dlgCrearMedicamento(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        this.tipoMedicamento = new Tipo_medicamento();
        this.medicamento = new Medicamento();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        listboxTipoMedicamento = new javax.swing.JList();
        txtTipoMedicamento = new javax.swing.JTextField();
        lblNombreMedicamento = new javax.swing.JLabel();
        txtNombreMedicamento = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnRegistrarMedicamento = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Registrar nuevo medicamento"));

        listboxTipoMedicamento.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo de medicamento"));
        listboxTipoMedicamento.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listboxTipoMedicamento.setInheritsPopupMenu(true);
        jScrollPane1.setViewportView(listboxTipoMedicamento);

        txtTipoMedicamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTipoMedicamentoActionPerformed(evt);
            }
        });
        txtTipoMedicamento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTipoMedicamentoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTipoMedicamentoKeyTyped(evt);
            }
        });

        lblNombreMedicamento.setText("Nombre medicamento:");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rsc/icono_buscar.png"))); // NOI18N

        btnRegistrarMedicamento.setText("Registrar medicamento");
        btnRegistrarMedicamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarMedicamentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTipoMedicamento))
                    .addComponent(jScrollPane1))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnRegistrarMedicamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNombreMedicamento))
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblNombreMedicamento, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtTipoMedicamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblNombreMedicamento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombreMedicamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(btnRegistrarMedicamento)))
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTipoMedicamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTipoMedicamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTipoMedicamentoActionPerformed

    private void btnRegistrarMedicamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarMedicamentoActionPerformed
        
        String nombreMedicamento = this.txtNombreMedicamento.getText();
        Tipo_medicamento tipoMedicamento = (Tipo_medicamento)this.listboxTipoMedicamento.getSelectedValue();
        
        if(nombreMedicamento == null)
        {
            JOptionPane.showMessageDialog(this, "Ingrese un nombre para el nuevo medicamento",
                        "Registrar nuevo medicamento", JOptionPane.WARNING_MESSAGE);
        }
        else if(tipoMedicamento == null)
        {
            JOptionPane.showMessageDialog(this, "Seleccione un tipo de medicamento",
                            "Registrar nuevo medicamento", JOptionPane.WARNING_MESSAGE);
        }
        else
        {
            this.medicamento = new Medicamento(nombreMedicamento, tipoMedicamento);
            
            //Registrar en la base de datos
            String mensajeError = this.medicamento.getMedicamentoDB().registrarMedicamento(this.medicamento);
            
            if(mensajeError == null)
            {
                JOptionPane.showMessageDialog(this, "El medicamento ha sido de manera exitosa",
                                        "Registrar nuevo medicamento", JOptionPane.INFORMATION_MESSAGE);
            }
            else
            {
                JOptionPane.showMessageDialog(this, mensajeError, "Registrar nuevo medicamento", JOptionPane.ERROR_MESSAGE);                
            }            
        }
    }//GEN-LAST:event_btnRegistrarMedicamentoActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        this.cargarTiposDeMedicamento();
    }//GEN-LAST:event_formWindowOpened

    private void txtTipoMedicamentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTipoMedicamentoKeyTyped
        
        
        
    }//GEN-LAST:event_txtTipoMedicamentoKeyTyped

    private void txtTipoMedicamentoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTipoMedicamentoKeyReleased
        realizarFiltroDeTiposDeMedicamento();
    }//GEN-LAST:event_txtTipoMedicamentoKeyReleased

    private void cargarTiposDeMedicamento()
    {
        this.listaDeTiposMedicamento = this.tipoMedicamento.getTipoMedicamentoDB().obtenerTiposDeMedicamento();
        
        this.listboxTipoMedicamento.setListData(this.listaDeTiposMedicamento.toArray());
    }
    
    private void realizarFiltroDeTiposDeMedicamento()
    {
        String posibleTipoMedicamento = this.txtTipoMedicamento.getText();
        
        ArrayList<Tipo_medicamento> listaTemporal = new ArrayList<Tipo_medicamento>();
        
        if(posibleTipoMedicamento.isEmpty())
        {
            this.listboxTipoMedicamento.setListData(this.listaDeTiposMedicamento.toArray());
        }
        else
        {        
            for(Tipo_medicamento tipoMedicamento : this.listaDeTiposMedicamento)
            {
                if(tipoMedicamento.getDescripcion().toLowerCase().startsWith(posibleTipoMedicamento.toLowerCase()) ||
                        tipoMedicamento.getDescripcion().toLowerCase().equals(posibleTipoMedicamento.toLowerCase()))
                {
                    listaTemporal.add(tipoMedicamento);
                }
            }
            
            this.listboxTipoMedicamento.setListData(listaTemporal.toArray());
        }

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
            java.util.logging.Logger.getLogger(dlgCrearMedicamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dlgCrearMedicamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dlgCrearMedicamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dlgCrearMedicamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dlgCrearMedicamento dialog = new dlgCrearMedicamento(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrarMedicamento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNombreMedicamento;
    private javax.swing.JList listboxTipoMedicamento;
    private javax.swing.JTextField txtNombreMedicamento;
    private javax.swing.JTextField txtTipoMedicamento;
    // End of variables declaration//GEN-END:variables
}
