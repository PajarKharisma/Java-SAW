
package Form;

import Koneksi.KoneksiDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TesPelamar extends javax.swing.JFrame {

    Connection con;
    Statement st;
    ResultSet rs;
    PreparedStatement ps;
    public TesPelamar() throws SQLException {
        initComponents();
        con = new KoneksiDb().getConnect();
        tampilPelamar();
        this.setLocationRelativeTo(null);
    }
 private void tampilPelamar() throws SQLException {
        DefaultTableModel mdl = new DefaultTableModel();
        mdl.addColumn("Id Pelamar");
        mdl.addColumn("Nama");
        mdl.addColumn("Alamat");
        mdl.addColumn("No Telp");
        tblPelamar.setModel(mdl);
        
        try {
            st = con.createStatement();
            rs = st.executeQuery("select * from tbl_pelamar ORDER BY LENGTH(id_pelamar), id_pelamar");
            while (rs.next()) {
                mdl.addRow(new Object[]{
                    rs.getString("id_pelamar"),
                    rs.getString("nama"),
                    rs.getString("alamat"),
                    rs.getString("telp")
                });
                tblPelamar.setModel(mdl);
            }
        } catch (Exception e) {
            System.out.println("#ERROR " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPelamar = new javax.swing.JTable();
        lblAlamatPelamar = new javax.swing.JLabel();
        txtIdPelamar = new javax.swing.JTextField();
        lblTelpPelamar = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAlamatPelamar = new javax.swing.JTextArea();
        lblNamaPelamar = new javax.swing.JLabel();
        txtTelpPelamar = new javax.swing.JTextField();
        btnPelamarHapus = new javax.swing.JButton();
        btnPelamarEdit = new javax.swing.JButton();
        btnPelamarSimpan = new javax.swing.JButton();
        btnPelamarTambah = new javax.swing.JButton();
        lblIdPelamar = new javax.swing.JLabel();
        txtNamaPelamar = new javax.swing.JTextField();
        btnPelamarBatal = new javax.swing.JButton();
        lblIdPelamar1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Master Pelamar");
        setBackground(new java.awt.Color(0, 0, 0));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        tblPelamar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblPelamar.setColumnSelectionAllowed(true);
        tblPelamar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPelamarMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPelamar);

        lblAlamatPelamar.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        lblAlamatPelamar.setForeground(new java.awt.Color(255, 255, 255));
        lblAlamatPelamar.setText("Alamat");

        txtIdPelamar.setEditable(false);

        lblTelpPelamar.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        lblTelpPelamar.setForeground(new java.awt.Color(255, 255, 255));
        lblTelpPelamar.setText("No. Telp.");

        txtAlamatPelamar.setEditable(false);
        txtAlamatPelamar.setColumns(20);
        txtAlamatPelamar.setRows(5);
        jScrollPane2.setViewportView(txtAlamatPelamar);

        lblNamaPelamar.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        lblNamaPelamar.setForeground(new java.awt.Color(255, 255, 255));
        lblNamaPelamar.setText("Nama");

        txtTelpPelamar.setEditable(false);

        btnPelamarHapus.setBackground(new java.awt.Color(0, 0, 0));
        btnPelamarHapus.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        btnPelamarHapus.setText("Hapus");
        btnPelamarHapus.setEnabled(false);
        btnPelamarHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPelamarHapusActionPerformed(evt);
            }
        });

        btnPelamarEdit.setBackground(new java.awt.Color(0, 0, 0));
        btnPelamarEdit.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        btnPelamarEdit.setText("Edit");
        btnPelamarEdit.setEnabled(false);
        btnPelamarEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPelamarEditActionPerformed(evt);
            }
        });

        btnPelamarSimpan.setBackground(new java.awt.Color(0, 0, 0));
        btnPelamarSimpan.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        btnPelamarSimpan.setText("Simpan");
        btnPelamarSimpan.setEnabled(false);
        btnPelamarSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPelamarSimpanActionPerformed(evt);
            }
        });

        btnPelamarTambah.setBackground(new java.awt.Color(0, 0, 0));
        btnPelamarTambah.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        btnPelamarTambah.setText("Tambah");
        btnPelamarTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPelamarTambahActionPerformed(evt);
            }
        });

        lblIdPelamar.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        lblIdPelamar.setForeground(new java.awt.Color(255, 255, 255));
        lblIdPelamar.setText("Id Pelamar");

        txtNamaPelamar.setEditable(false);

        btnPelamarBatal.setBackground(new java.awt.Color(0, 0, 0));
        btnPelamarBatal.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        btnPelamarBatal.setText("Batal");
        btnPelamarBatal.setEnabled(false);
        btnPelamarBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPelamarBatalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnPelamarTambah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPelamarSimpan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPelamarEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPelamarHapus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPelamarBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblIdPelamar)
                        .addGap(18, 18, 18)
                        .addComponent(txtIdPelamar, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblAlamatPelamar)
                                    .addComponent(lblNamaPelamar))
                                .addGap(16, 16, 16))
                            .addComponent(lblTelpPelamar, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNamaPelamar, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTelpPelamar, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdPelamar)
                    .addComponent(txtIdPelamar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNamaPelamar)
                    .addComponent(txtNamaPelamar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAlamatPelamar)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(lblTelpPelamar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTelpPelamar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPelamarSimpan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnPelamarTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnPelamarEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnPelamarHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnPelamarBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 15, Short.MAX_VALUE))
        );

        lblIdPelamar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Res/Logo Niaga.jpg"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblIdPelamar1)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(lblIdPelamar1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPelamarHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPelamarHapusActionPerformed
        try {
            String sql = "DELETE from tbl_pelamar WHERE id_pelamar='" + txtIdPelamar.getText() + "'";
            ps = con.prepareStatement(sql);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
            tampilPelamar();
        } catch (Exception e) {
            System.out.println("#Error " + e.getMessage());
        }
        setField(false);
    }//GEN-LAST:event_btnPelamarHapusActionPerformed

    private void btnPelamarEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPelamarEditActionPerformed
        String idPelamar = txtIdPelamar.getText();
        String namaPelamar = txtNamaPelamar.getText();
        String alamatPelamar = txtAlamatPelamar.getText();
        String telpPelamar = txtTelpPelamar.getText();

        String sql = "UPDATE tbl_pelamar SET nama='"+namaPelamar+"', alamat='"+alamatPelamar+"', telp='"+telpPelamar+"' WHERE id_pelamar='" + idPelamar + "'";
        try {
            st = con.createStatement();
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Data berhasil diubah");
            tampilPelamar();
        } catch (SQLException ex) {
            System.out.println("#Error " + ex.getMessage());
        }
        setField(false);
    }//GEN-LAST:event_btnPelamarEditActionPerformed

    private void tblPelamarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPelamarMouseClicked
        setField(true);

        int pilih = tblPelamar.getSelectedRow();
        txtIdPelamar.setText(tblPelamar.getValueAt(pilih, 0).toString());
        txtNamaPelamar.setText(tblPelamar.getValueAt(pilih, 1).toString());
        txtAlamatPelamar.setText(tblPelamar.getValueAt(pilih, 2).toString());
        txtTelpPelamar.setText(tblPelamar.getValueAt(pilih, 3).toString());
    }//GEN-LAST:event_tblPelamarMouseClicked

    private void btnPelamarSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPelamarSimpanActionPerformed
        String idPelamar = txtIdPelamar.getText();
        String namaPelamar = txtNamaPelamar.getText();
        String alamatPelamar = txtAlamatPelamar.getText();
        String telpPelamar = txtTelpPelamar.getText();

        try {
            String sql = "insert into tbl_pelamar(id_pelamar, nama, alamat, telp) values(?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, idPelamar);
            ps.setString(2, namaPelamar);
            ps.setString(3, alamatPelamar);
            ps.setString(4, telpPelamar);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
            setField(false);
            tampilPelamar();
        } catch (Exception e) {
            System.out.println("#Error " + e.getMessage());
        }
        setField(false);
    }//GEN-LAST:event_btnPelamarSimpanActionPerformed

    private void btnPelamarTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPelamarTambahActionPerformed
        setField(true);
        int countId = 0;
        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT COUNT(id_pelamar) as 'jumlah' FROM tbl_pelamar");
            while (rs.next()) {
                countId = rs.getInt("jumlah");
            }
        } catch (Exception e) {
            System.out.println("#ERROR " + e.getMessage());
        }
        txtIdPelamar.setText("A"+(countId+1));
    }//GEN-LAST:event_btnPelamarTambahActionPerformed

    private void btnPelamarBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPelamarBatalActionPerformed
        setField(false);
    }//GEN-LAST:event_btnPelamarBatalActionPerformed

     void setField(boolean param){
        this.txtAlamatPelamar.setEditable(param);
        this.txtNamaPelamar.setEditable(param);
        this.txtAlamatPelamar.setEditable(param);
        this.txtTelpPelamar.setEditable(param);
         
        this.txtIdPelamar.setText("");
        this.txtAlamatPelamar.setText("");
        this.txtNamaPelamar.setText("");
        this.txtTelpPelamar.setText("");
        
        this.btnPelamarSimpan.setEnabled(param);
        this.btnPelamarEdit.setEnabled(param);
        this.btnPelamarHapus.setEnabled(param);
        this.btnPelamarBatal.setEnabled(param);
    }


    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TesPelamar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TesPelamar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TesPelamar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TesPelamar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new TesPelamar().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(TesPelamar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPelamarBatal;
    private javax.swing.JButton btnPelamarEdit;
    private javax.swing.JButton btnPelamarHapus;
    private javax.swing.JButton btnPelamarSimpan;
    private javax.swing.JButton btnPelamarTambah;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAlamatPelamar;
    private javax.swing.JLabel lblIdPelamar;
    private javax.swing.JLabel lblIdPelamar1;
    private javax.swing.JLabel lblNamaPelamar;
    private javax.swing.JLabel lblTelpPelamar;
    private javax.swing.JTable tblPelamar;
    private javax.swing.JTextArea txtAlamatPelamar;
    private javax.swing.JTextField txtIdPelamar;
    private javax.swing.JTextField txtNamaPelamar;
    private javax.swing.JTextField txtTelpPelamar;
    // End of variables declaration//GEN-END:variables
}
