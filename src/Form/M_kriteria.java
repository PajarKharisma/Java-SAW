package Form;

import Koneksi.KoneksiDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class M_kriteria extends javax.swing.JInternalFrame {

    Connection con;
    Statement st;
    ResultSet rs;
    PreparedStatement ps;
    
    public M_kriteria() throws SQLException {
        initComponents();
        con = new KoneksiDb().getConnect();
        tampilKriteria();
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
    
    void setField(boolean param){
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKriteria = new javax.swing.JTable();
        btnKriteriaTambah = new javax.swing.JButton();
        btnKriteriaEdit = new javax.swing.JButton();
        btnKriteriaHapus = new javax.swing.JButton();
        lblIdKriteria = new javax.swing.JLabel();
        txtIdKriteria = new javax.swing.JTextField();
        lbNamaKriteria = new javax.swing.JLabel();
        txtNamaKriteria = new javax.swing.JTextField();
        lblBobotKriteria = new javax.swing.JLabel();
        txtBobotKriteria = new javax.swing.JTextField();
        lblFlagKriteria = new javax.swing.JLabel();
        btnKriteriaSimpan = new javax.swing.JButton();
        btnKriteriaBatal = new javax.swing.JButton();
        radioKriteriaCost = new javax.swing.JRadioButton();
        radioKriteriaBenefit = new javax.swing.JRadioButton();

        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setClosable(true);
        setResizable(true);
        setTitle("Master Kriteria");
        setToolTipText("");
        setFrameIcon(null);
        setName(""); // NOI18N
        setOpaque(true);

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
        tblKriteria.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        btnKriteriaTambah.setText("Tambah");
        btnKriteriaTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKriteriaTambahActionPerformed(evt);
            }
        });

        btnKriteriaEdit.setText("Edit");
        btnKriteriaEdit.setEnabled(false);
        btnKriteriaEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKriteriaEditActionPerformed(evt);
            }
        });

        btnKriteriaHapus.setText("Hapus");
        btnKriteriaHapus.setEnabled(false);
        btnKriteriaHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKriteriaHapusActionPerformed(evt);
            }
        });

        lblIdKriteria.setText("Id Kriteria");

        txtIdKriteria.setEditable(false);

        lbNamaKriteria.setText("Kriteria");

        txtNamaKriteria.setEnabled(false);

        lblBobotKriteria.setText("Bobot");

        txtBobotKriteria.setEnabled(false);

        lblFlagKriteria.setText("Flag");

        btnKriteriaSimpan.setText("Simpan");
        btnKriteriaSimpan.setEnabled(false);
        btnKriteriaSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKriteriaSimpanActionPerformed(evt);
            }
        });

        btnKriteriaBatal.setText("Batal");
        btnKriteriaBatal.setEnabled(false);
        btnKriteriaBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKriteriaBatalActionPerformed(evt);
            }
        });

        radioKriteriaCost.setText("Cost");
        radioKriteriaCost.setEnabled(false);
        radioKriteriaCost.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                radioKriteriaCostMouseClicked(evt);
            }
        });

        radioKriteriaBenefit.setText("Benefit");
        radioKriteriaBenefit.setEnabled(false);
        radioKriteriaBenefit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                radioKriteriaBenefitMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblIdKriteria)
                                    .addComponent(lbNamaKriteria)
                                    .addComponent(lblBobotKriteria)
                                    .addComponent(lblFlagKriteria))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtBobotKriteria)
                                    .addComponent(txtNamaKriteria)
                                    .addComponent(txtIdKriteria, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(radioKriteriaBenefit)
                                        .addGap(18, 18, 18)
                                        .addComponent(radioKriteriaCost))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(btnKriteriaTambah)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnKriteriaSimpan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnKriteriaEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnKriteriaHapus)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnKriteriaBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdKriteria)
                    .addComponent(txtIdKriteria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNamaKriteria)
                    .addComponent(txtNamaKriteria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBobotKriteria)
                    .addComponent(txtBobotKriteria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFlagKriteria)
                    .addComponent(radioKriteriaCost)
                    .addComponent(radioKriteriaBenefit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnKriteriaTambah)
                    .addComponent(btnKriteriaEdit)
                    .addComponent(btnKriteriaHapus)
                    .addComponent(btnKriteriaSimpan)
                    .addComponent(btnKriteriaBatal))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
        txtIdKriteria.setText("C"+(countId+1));
    }//GEN-LAST:event_btnKriteriaTambahActionPerformed

    private void btnKriteriaSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKriteriaSimpanActionPerformed
        String idKriteria = txtIdKriteria.getText();
        String namaKriteria = txtNamaKriteria.getText();
        Float bobotKriteria = Float.parseFloat(txtBobotKriteria.getText());
        String flagKriteria = "";
        if(radioKriteriaBenefit.isSelected())
            flagKriteria = "benefit";
        else
            flagKriteria = "cost";
        
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
    }//GEN-LAST:event_btnKriteriaSimpanActionPerformed

    private void radioKriteriaBenefitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radioKriteriaBenefitMouseClicked
        if(radioKriteriaBenefit.isSelected())
            radioKriteriaCost.setSelected(false);
    }//GEN-LAST:event_radioKriteriaBenefitMouseClicked

    private void radioKriteriaCostMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radioKriteriaCostMouseClicked
        if(radioKriteriaCost.isSelected())
            radioKriteriaBenefit.setSelected(false);
    }//GEN-LAST:event_radioKriteriaCostMouseClicked

    private void btnKriteriaBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKriteriaBatalActionPerformed
        setField(false);
    }//GEN-LAST:event_btnKriteriaBatalActionPerformed

    private void tblKriteriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKriteriaMouseClicked
        setField(true);

        int pilih = tblKriteria.getSelectedRow();
        txtIdKriteria.setText(tblKriteria.getValueAt(pilih, 0).toString());
        txtNamaKriteria.setText(tblKriteria.getValueAt(pilih, 1).toString());
        txtBobotKriteria.setText(tblKriteria.getValueAt(pilih, 2).toString());
        String flagKriteria = tblKriteria.getValueAt(pilih, 3).toString();
        if(flagKriteria.equals("benefit"))
            radioKriteriaBenefit.setSelected(true);
        else
            radioKriteriaCost.setSelected(true);
    }//GEN-LAST:event_tblKriteriaMouseClicked

    private void btnKriteriaEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKriteriaEditActionPerformed
        String idKriteria = txtIdKriteria.getText();
        String namaKriteria = txtNamaKriteria.getText();
        Float bobotKriteria = Float.parseFloat(txtBobotKriteria.getText());
        String flagKriteria = "";
        if(radioKriteriaBenefit.isSelected())
            flagKriteria = "benefit";
        else
            flagKriteria = "cost";
        
        String sql = "UPDATE tbl_kriteria SET nama_kriteria='"+namaKriteria+"', bobot="+bobotKriteria+", flag='"+flagKriteria+"' WHERE id_kriteria='" + idKriteria + "'";
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKriteriaBatal;
    private javax.swing.JButton btnKriteriaEdit;
    private javax.swing.JButton btnKriteriaHapus;
    private javax.swing.JButton btnKriteriaSimpan;
    private javax.swing.JButton btnKriteriaTambah;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbNamaKriteria;
    private javax.swing.JLabel lblBobotKriteria;
    private javax.swing.JLabel lblFlagKriteria;
    private javax.swing.JLabel lblIdKriteria;
    private javax.swing.JRadioButton radioKriteriaBenefit;
    private javax.swing.JRadioButton radioKriteriaCost;
    private javax.swing.JTable tblKriteria;
    private javax.swing.JTextField txtBobotKriteria;
    private javax.swing.JTextField txtIdKriteria;
    private javax.swing.JTextField txtNamaKriteria;
    // End of variables declaration//GEN-END:variables
}
