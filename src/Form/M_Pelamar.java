package Form;

import Koneksi.KoneksiDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class M_Pelamar extends javax.swing.JInternalFrame {

    Connection con;
    Statement st;
    ResultSet rs;
    PreparedStatement ps;
    
    public M_Pelamar() throws SQLException {
        initComponents();
        con = new KoneksiDb().getConnect();
        tampilPelamar();
        
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblPelamar = new javax.swing.JTable();
        lblIdPelamar = new javax.swing.JLabel();
        txtIdPelamar = new javax.swing.JTextField();
        lblNamaPelamar = new javax.swing.JLabel();
        txtNamaPelamar = new javax.swing.JTextField();
        lblAlamatPelamar = new javax.swing.JLabel();
        lblTelpPelamar = new javax.swing.JLabel();
        txtTelpPelamar = new javax.swing.JTextField();
        btnPelamarHapus = new javax.swing.JButton();
        btnPelamarEdit = new javax.swing.JButton();
        btnPelamarSimpan = new javax.swing.JButton();
        btnPelamarTambah = new javax.swing.JButton();
        btnPelamarBatal = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAlamatPelamar = new javax.swing.JTextArea();

        setClosable(true);
        setResizable(true);
        setTitle("Master Pelamar");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFrameIcon(null);

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
        tblPelamar.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        lblIdPelamar.setText("Id Pelamar");

        txtIdPelamar.setEditable(false);

        lblNamaPelamar.setText("Nama");

        txtNamaPelamar.setEditable(false);

        lblAlamatPelamar.setText("Alamat");

        lblTelpPelamar.setText("No. Telp.");

        txtTelpPelamar.setEditable(false);

        btnPelamarHapus.setText("Hapus");
        btnPelamarHapus.setEnabled(false);
        btnPelamarHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPelamarHapusActionPerformed(evt);
            }
        });

        btnPelamarEdit.setText("Edit");
        btnPelamarEdit.setEnabled(false);
        btnPelamarEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPelamarEditActionPerformed(evt);
            }
        });

        btnPelamarSimpan.setText("Simpan");
        btnPelamarSimpan.setEnabled(false);
        btnPelamarSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPelamarSimpanActionPerformed(evt);
            }
        });

        btnPelamarTambah.setText("Tambah");
        btnPelamarTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPelamarTambahActionPerformed(evt);
            }
        });

        btnPelamarBatal.setText("Batal");
        btnPelamarBatal.setEnabled(false);
        btnPelamarBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPelamarBatalActionPerformed(evt);
            }
        });

        txtAlamatPelamar.setEditable(false);
        txtAlamatPelamar.setColumns(20);
        txtAlamatPelamar.setRows(5);
        jScrollPane2.setViewportView(txtAlamatPelamar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(lblIdPelamar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtIdPelamar, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblAlamatPelamar)
                                    .addComponent(lblNamaPelamar))
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNamaPelamar, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(223, 397, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnPelamarTambah)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPelamarSimpan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPelamarEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPelamarHapus)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPelamarBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblTelpPelamar)
                                .addGap(18, 18, 18)
                                .addComponent(txtTelpPelamar, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdPelamar)
                    .addComponent(txtIdPelamar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNamaPelamar)
                    .addComponent(txtNamaPelamar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAlamatPelamar)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTelpPelamar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTelpPelamar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPelamarTambah, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addComponent(btnPelamarSimpan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPelamarEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPelamarHapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPelamarBatal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        setBounds(0, 0, 671, 545);
    }// </editor-fold>//GEN-END:initComponents

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

    private void tblPelamarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPelamarMouseClicked
        setField(true);

        int pilih = tblPelamar.getSelectedRow();
        txtIdPelamar.setText(tblPelamar.getValueAt(pilih, 0).toString());
        txtNamaPelamar.setText(tblPelamar.getValueAt(pilih, 1).toString());
        txtAlamatPelamar.setText(tblPelamar.getValueAt(pilih, 2).toString());
        txtTelpPelamar.setText(tblPelamar.getValueAt(pilih, 3).toString());
    }//GEN-LAST:event_tblPelamarMouseClicked

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPelamarBatal;
    private javax.swing.JButton btnPelamarEdit;
    private javax.swing.JButton btnPelamarHapus;
    private javax.swing.JButton btnPelamarSimpan;
    private javax.swing.JButton btnPelamarTambah;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAlamatPelamar;
    private javax.swing.JLabel lblIdPelamar;
    private javax.swing.JLabel lblNamaPelamar;
    private javax.swing.JLabel lblTelpPelamar;
    private javax.swing.JTable tblPelamar;
    private javax.swing.JTextArea txtAlamatPelamar;
    private javax.swing.JTextField txtIdPelamar;
    private javax.swing.JTextField txtNamaPelamar;
    private javax.swing.JTextField txtTelpPelamar;
    // End of variables declaration//GEN-END:variables
}
