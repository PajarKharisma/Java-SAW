/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import Koneksi.KoneksiDb;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TesKriteria extends javax.swing.JFrame {

    Connection con;
    Statement st;
    ResultSet rs;
    PreparedStatement ps;

    public TesKriteria() throws SQLException {
        initComponents();
        con = new KoneksiDb().getConnect();
        tampilKriteria();
        this.setLocationRelativeTo(null);
        this.jPanel1.setBackground(Color.black);

    }

    private void tampilKriteria() throws SQLException {
        DefaultTableModel mdl = new DefaultTableModel();
        mdl.addColumn("Id Kriteria");
        mdl.addColumn("Kriteria");
        mdl.addColumn("Bobot (%)");
        mdl.addColumn("Flag");
        tblKriteria.setModel(mdl);

        try {
            st = con.createStatement();
            rs = st.executeQuery("select * from tbl_kriteria ORDER BY LENGTH(id_kriteria), id_kriteria");
            while (rs.next()) {
                mdl.addRow(new Object[]{
                    rs.getString("id_kriteria"),
                    rs.getString("nama_kriteria"),
                    rs.getString("bobot"),
                    rs.getString("flag")
                });
                tblKriteria.setModel(mdl);
            }
        } catch (Exception e) {
            System.out.println("#ERROR " + e.getMessage());
        }
    }

    void setField(boolean param) {
        txtNamaKriteria.setEnabled(param);
        txtBobotKriteria.setEnabled(param);
        radioKriteriaBenefit.setEnabled(param);
        radioKriteriaCost.setEnabled(param);
        radioKriteriaBenefit.setSelected(false);
        radioKriteriaCost.setSelected(false);

        txtIdKriteria.setText("");
        txtNamaKriteria.setText("");
        txtBobotKriteria.setText("");

        btnKriteriaSimpan.setEnabled(param);
        btnKriteriaEdit.setEnabled(param);
        btnKriteriaHapus.setEnabled(param);
        btnKriteriaBatal.setEnabled(param);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblIdKriteria1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnKriteriaTambah = new javax.swing.JButton();
        btnKriteriaBatal = new javax.swing.JButton();
        btnKriteriaEdit = new javax.swing.JButton();
        radioKriteriaCost = new javax.swing.JRadioButton();
        btnKriteriaHapus = new javax.swing.JButton();
        radioKriteriaBenefit = new javax.swing.JRadioButton();
        txtBobotKriteria = new javax.swing.JTextField();
        lblIdKriteria = new javax.swing.JLabel();
        txtIdKriteria = new javax.swing.JTextField();
        lbNamaKriteria = new javax.swing.JLabel();
        lblFlagKriteria = new javax.swing.JLabel();
        txtNamaKriteria = new javax.swing.JTextField();
        btnKriteriaSimpan = new javax.swing.JButton();
        lblBobotKriteria = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKriteria = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Master Kriteria");

        lblIdKriteria1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Res/Logo Niaga.jpg"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        btnKriteriaTambah.setBackground(new java.awt.Color(0, 0, 0));
        btnKriteriaTambah.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        btnKriteriaTambah.setText("Tambah");
        btnKriteriaTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKriteriaTambahActionPerformed(evt);
            }
        });

        btnKriteriaBatal.setBackground(new java.awt.Color(0, 0, 0));
        btnKriteriaBatal.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        btnKriteriaBatal.setText("Batal");
        btnKriteriaBatal.setEnabled(false);
        btnKriteriaBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKriteriaBatalActionPerformed(evt);
            }
        });

        btnKriteriaEdit.setBackground(new java.awt.Color(0, 0, 0));
        btnKriteriaEdit.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        btnKriteriaEdit.setText("Edit");
        btnKriteriaEdit.setEnabled(false);
        btnKriteriaEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKriteriaEditActionPerformed(evt);
            }
        });

        radioKriteriaCost.setBackground(new java.awt.Color(0, 0, 0));
        radioKriteriaCost.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        radioKriteriaCost.setForeground(new java.awt.Color(255, 255, 255));
        radioKriteriaCost.setText("Cost");
        radioKriteriaCost.setEnabled(false);
        radioKriteriaCost.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                radioKriteriaCostMouseClicked(evt);
            }
        });

        btnKriteriaHapus.setBackground(new java.awt.Color(0, 0, 0));
        btnKriteriaHapus.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        btnKriteriaHapus.setText("Hapus");
        btnKriteriaHapus.setEnabled(false);
        btnKriteriaHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKriteriaHapusActionPerformed(evt);
            }
        });

        radioKriteriaBenefit.setBackground(new java.awt.Color(0, 0, 0));
        radioKriteriaBenefit.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        radioKriteriaBenefit.setForeground(new java.awt.Color(255, 255, 255));
        radioKriteriaBenefit.setText("Benefit");
        radioKriteriaBenefit.setEnabled(false);
        radioKriteriaBenefit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                radioKriteriaBenefitMouseClicked(evt);
            }
        });

        txtBobotKriteria.setEnabled(false);

        lblIdKriteria.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        lblIdKriteria.setForeground(new java.awt.Color(255, 255, 255));
        lblIdKriteria.setText("Id Kriteria");

        txtIdKriteria.setEditable(false);

        lbNamaKriteria.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        lbNamaKriteria.setForeground(new java.awt.Color(255, 255, 255));
        lbNamaKriteria.setText("Kriteria");

        lblFlagKriteria.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        lblFlagKriteria.setForeground(new java.awt.Color(255, 255, 255));
        lblFlagKriteria.setText("Flag");

        txtNamaKriteria.setEnabled(false);

        btnKriteriaSimpan.setBackground(new java.awt.Color(0, 0, 0));
        btnKriteriaSimpan.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        btnKriteriaSimpan.setText("Simpan");
        btnKriteriaSimpan.setEnabled(false);
        btnKriteriaSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKriteriaSimpanActionPerformed(evt);
            }
        });

        lblBobotKriteria.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        lblBobotKriteria.setForeground(new java.awt.Color(255, 255, 255));
        lblBobotKriteria.setText("Bobot");

        tblKriteria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblKriteria.setColumnSelectionAllowed(true);
        tblKriteria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKriteriaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblKriteria);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnKriteriaTambah)
                        .addGap(0, 0, 0)
                        .addComponent(btnKriteriaSimpan)
                        .addGap(0, 0, 0)
                        .addComponent(btnKriteriaEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btnKriteriaHapus)
                        .addGap(0, 0, 0)
                        .addComponent(btnKriteriaBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblIdKriteria)
                            .addComponent(lbNamaKriteria)
                            .addComponent(lblBobotKriteria)
                            .addComponent(lblFlagKriteria))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtBobotKriteria)
                            .addComponent(txtNamaKriteria)
                            .addComponent(txtIdKriteria, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(radioKriteriaBenefit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(radioKriteriaCost)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdKriteria)
                    .addComponent(txtIdKriteria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbNamaKriteria)
                    .addComponent(txtNamaKriteria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBobotKriteria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBobotKriteria))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFlagKriteria)
                    .addComponent(radioKriteriaBenefit)
                    .addComponent(radioKriteriaCost))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnKriteriaSimpan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnKriteriaEdit, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnKriteriaHapus, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnKriteriaBatal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnKriteriaTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblIdKriteria1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(lblIdKriteria1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblKriteriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKriteriaMouseClicked
        setField(true);

        int pilih = tblKriteria.getSelectedRow();
        txtIdKriteria.setText(tblKriteria.getValueAt(pilih, 0).toString());
        txtNamaKriteria.setText(tblKriteria.getValueAt(pilih, 1).toString());
        txtBobotKriteria.setText(tblKriteria.getValueAt(pilih, 2).toString());
        String flagKriteria = tblKriteria.getValueAt(pilih, 3).toString();
        if (flagKriteria.equals("benefit")) {
            radioKriteriaBenefit.setSelected(true);
        } else {
            radioKriteriaCost.setSelected(true);
        }
    }//GEN-LAST:event_tblKriteriaMouseClicked

    private void btnKriteriaSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKriteriaSimpanActionPerformed
        int temp = 0;
        String idKriteria = txtIdKriteria.getText();
        String namaKriteria = txtNamaKriteria.getText();
        Float bobotKriteria = Float.parseFloat(txtBobotKriteria.getText());
        String flagKriteria = "";
        
        for (int i = 0; i < tblKriteria.getRowCount(); i++) {
            temp += Integer.parseInt(tblKriteria.getValueAt(i, 2).toString());
        }
        System.out.println("count value : " + temp);
        
        if (temp + bobotKriteria > 100) {
            JOptionPane.showMessageDialog(null, "Bobot yang anda masukan melebihi nilai maksimum yang ditentukan!!!");
        } else {
            if (radioKriteriaBenefit.isSelected()) {
                flagKriteria = "benefit";
            } else {
                flagKriteria = "cost";
            }

            try {
                String sql = "insert into tbl_kriteria(id_kriteria, nama_kriteria, bobot, flag) values(?,?,?,?)";
                ps = con.prepareStatement(sql);
                ps.setString(1, idKriteria);
                ps.setString(2, namaKriteria);
                ps.setFloat(3, bobotKriteria);
                ps.setString(4, flagKriteria);
                ps.execute();
                JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
                setField(false);
                tampilKriteria();
            } catch (Exception e) {
                System.out.println("#Error " + e.getMessage());
            }
            setField(false);
        }
    }//GEN-LAST:event_btnKriteriaSimpanActionPerformed

    private void btnKriteriaTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKriteriaTambahActionPerformed
        setField(true);

        int countId = 0;
        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT COUNT(id_kriteria) as 'jumlah' FROM tbl_kriteria");
            while (rs.next()) {
                countId = rs.getInt("jumlah");
            }
        } catch (Exception e) {
            System.out.println("#ERROR " + e.getMessage());
        }
        txtIdKriteria.setText("C" + (countId + 1));
    }//GEN-LAST:event_btnKriteriaTambahActionPerformed

    private void btnKriteriaBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKriteriaBatalActionPerformed
        setField(false);
    }//GEN-LAST:event_btnKriteriaBatalActionPerformed

    private void btnKriteriaEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKriteriaEditActionPerformed
        String idKriteria = txtIdKriteria.getText();
        String namaKriteria = txtNamaKriteria.getText();
        Float bobotKriteria = Float.parseFloat(txtBobotKriteria.getText());
        String flagKriteria = "";
        if (radioKriteriaBenefit.isSelected()) {
            flagKriteria = "benefit";
        } else {
            flagKriteria = "cost";
        }

        String sql = "UPDATE tbl_kriteria SET nama_kriteria='" + namaKriteria + "', bobot=" + bobotKriteria + ", flag='" + flagKriteria + "' WHERE id_kriteria='" + idKriteria + "'";
        try {
            st = con.createStatement();
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Data berhasil diubah");
            tampilKriteria();
        } catch (SQLException ex) {
            System.out.println("#Error " + ex.getMessage());
        }
        setField(false);
    }//GEN-LAST:event_btnKriteriaEditActionPerformed

    private void radioKriteriaCostMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radioKriteriaCostMouseClicked
        if (radioKriteriaCost.isSelected()) {
            radioKriteriaBenefit.setSelected(false);
        }
    }//GEN-LAST:event_radioKriteriaCostMouseClicked

    private void btnKriteriaHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKriteriaHapusActionPerformed
        try {
            String sql = "DELETE from tbl_kriteria WHERE id_kriteria='" + txtIdKriteria.getText() + "'";
            ps = con.prepareStatement(sql);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
            tampilKriteria();
        } catch (Exception e) {
            System.out.println("#Error " + e.getMessage());
        }
        setField(false);
    }//GEN-LAST:event_btnKriteriaHapusActionPerformed

    private void radioKriteriaBenefitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radioKriteriaBenefitMouseClicked
        if (radioKriteriaBenefit.isSelected()) {
            radioKriteriaCost.setSelected(false);
        }
    }//GEN-LAST:event_radioKriteriaBenefitMouseClicked

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
            java.util.logging.Logger.getLogger(TesKriteria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TesKriteria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TesKriteria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TesKriteria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new TesKriteria().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(TesKriteria.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKriteriaBatal;
    private javax.swing.JButton btnKriteriaEdit;
    private javax.swing.JButton btnKriteriaHapus;
    private javax.swing.JButton btnKriteriaSimpan;
    private javax.swing.JButton btnKriteriaTambah;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbNamaKriteria;
    private javax.swing.JLabel lblBobotKriteria;
    private javax.swing.JLabel lblFlagKriteria;
    private javax.swing.JLabel lblIdKriteria;
    private javax.swing.JLabel lblIdKriteria1;
    private javax.swing.JRadioButton radioKriteriaBenefit;
    private javax.swing.JRadioButton radioKriteriaCost;
    private javax.swing.JTable tblKriteria;
    private javax.swing.JTextField txtBobotKriteria;
    private javax.swing.JTextField txtIdKriteria;
    private javax.swing.JTextField txtNamaKriteria;
    // End of variables declaration//GEN-END:variables
}
