package Form;

import Koneksi.KoneksiDb;
import Process.PassEncrypt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TesPengguna extends javax.swing.JFrame {
    
    Connection con;
    Statement st;
    ResultSet rs;
    PreparedStatement ps;
    PassEncrypt passEncrypt = new PassEncrypt();
    int idUser;
    
    public TesPengguna() throws SQLException {
        initComponents();
        this.setLocationRelativeTo(null);
        con = new KoneksiDb().getConnect();
        tampilUser();
    }
    
    private void tampilUser() throws SQLException {
        DefaultTableModel mdl = new DefaultTableModel();
        mdl.addColumn("No");
        mdl.addColumn("Id");
        mdl.addColumn("User");
        tblUser.setModel(mdl);

        try {
            st = con.createStatement();
            rs = st.executeQuery("select * from tbl_pengguna order by id + 0 asc");
            int noUrut = 1;
            while (rs.next()) {
                mdl.addRow(new Object[]{
                    noUrut,
                    rs.getString("id"),
                    rs.getString("username")
                });
                tblUser.setModel(mdl);
                noUrut++;
            }
            
            tblUser.getColumnModel().getColumn(1).setMinWidth(0);
            tblUser.getColumnModel().getColumn(1).setMaxWidth(0);
            tblUser.getColumnModel().getColumn(1).setWidth(0);
        } catch (Exception e) {
            System.out.println("#ERROR " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblIdPelamar1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUser = new javax.swing.JTable();
        btnPenggunaBatal = new javax.swing.JButton();
        txtUsername = new javax.swing.JTextField();
        btnPenggunaHapus = new javax.swing.JButton();
        lblNamaPelamar = new javax.swing.JLabel();
        btnPenggunaEdit = new javax.swing.JButton();
        btnPenggunaSimpan = new javax.swing.JButton();
        btnPenggunaTambah = new javax.swing.JButton();
        lblIdPelamar = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Master Pengguna");

        lblIdPelamar1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblIdPelamar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Res/header print.png"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        tblUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblUser.setColumnSelectionAllowed(true);
        tblUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUserMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblUser);

        btnPenggunaBatal.setBackground(new java.awt.Color(0, 0, 0));
        btnPenggunaBatal.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        btnPenggunaBatal.setText("Batal");
        btnPenggunaBatal.setEnabled(false);
        btnPenggunaBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPenggunaBatalActionPerformed(evt);
            }
        });

        txtUsername.setEditable(false);
        txtUsername.setBackground(new java.awt.Color(255, 255, 255));

        btnPenggunaHapus.setBackground(new java.awt.Color(0, 0, 0));
        btnPenggunaHapus.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        btnPenggunaHapus.setText("Hapus");
        btnPenggunaHapus.setEnabled(false);
        btnPenggunaHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPenggunaHapusActionPerformed(evt);
            }
        });

        lblNamaPelamar.setBackground(new java.awt.Color(255, 255, 255));
        lblNamaPelamar.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        lblNamaPelamar.setForeground(new java.awt.Color(255, 255, 255));
        lblNamaPelamar.setText("Password");

        btnPenggunaEdit.setBackground(new java.awt.Color(0, 0, 0));
        btnPenggunaEdit.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        btnPenggunaEdit.setText("Edit");
        btnPenggunaEdit.setEnabled(false);
        btnPenggunaEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPenggunaEditActionPerformed(evt);
            }
        });

        btnPenggunaSimpan.setBackground(new java.awt.Color(0, 0, 0));
        btnPenggunaSimpan.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        btnPenggunaSimpan.setText("Simpan");
        btnPenggunaSimpan.setEnabled(false);
        btnPenggunaSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPenggunaSimpanActionPerformed(evt);
            }
        });

        btnPenggunaTambah.setBackground(new java.awt.Color(0, 0, 0));
        btnPenggunaTambah.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        btnPenggunaTambah.setText("Tambah");
        btnPenggunaTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPenggunaTambahActionPerformed(evt);
            }
        });

        lblIdPelamar.setBackground(new java.awt.Color(255, 255, 255));
        lblIdPelamar.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        lblIdPelamar.setForeground(new java.awt.Color(255, 255, 255));
        lblIdPelamar.setText("Userrname");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnPenggunaTambah)
                        .addGap(6, 6, 6)
                        .addComponent(btnPenggunaSimpan)
                        .addGap(6, 6, 6)
                        .addComponent(btnPenggunaEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btnPenggunaHapus)
                        .addGap(6, 6, 6)
                        .addComponent(btnPenggunaBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblIdPelamar)
                            .addComponent(lblNamaPelamar))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                            .addComponent(txtPassword))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtUsername, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIdPelamar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNamaPelamar)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPenggunaTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPenggunaSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPenggunaEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPenggunaHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPenggunaBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblIdPelamar1))
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblIdPelamar1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUserMouseClicked
        setField(true);

        int pilih = tblUser.getSelectedRow();
        idUser = Integer.parseInt(tblUser.getValueAt(pilih, 1).toString());
        txtUsername.setText(tblUser.getValueAt(pilih, 2).toString());
        System.out.println("id : " + idUser);
    }//GEN-LAST:event_tblUserMouseClicked

    private void btnPenggunaTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPenggunaTambahActionPerformed
         setField(true);
    }//GEN-LAST:event_btnPenggunaTambahActionPerformed

    private void btnPenggunaBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPenggunaBatalActionPerformed
        setField(false);
    }//GEN-LAST:event_btnPenggunaBatalActionPerformed

    private void btnPenggunaSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPenggunaSimpanActionPerformed
        String username = txtUsername.getText();
        String password = passEncrypt.getEncrypt(txtPassword.getText());

        try {
            String sql = "insert into tbl_pengguna(username, password) values(?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
            setField(false);
            tampilUser();
        } catch (Exception e) {
            System.out.println("#Error " + e.getMessage());
        }
        txtUsername.setText("");
        txtPassword.setText("");
        setField(false);
    }//GEN-LAST:event_btnPenggunaSimpanActionPerformed

    private void btnPenggunaEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPenggunaEditActionPerformed
        String username = txtUsername.getText();
        String password = passEncrypt.getEncrypt(txtPassword.getText());
        String sql = "UPDATE tbl_pengguna SET username='" + username + "', password='"+password+"' WHERE id='" + idUser + "'";
            try {
                st = con.createStatement();
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Data berhasil diubah");
                tampilUser();
            } catch (SQLException ex) {
                System.out.println("#Error " + ex.getMessage());
            }
            setField(false);
            txtUsername.setText("");
            txtPassword.setText("");
    }//GEN-LAST:event_btnPenggunaEditActionPerformed

    private void btnPenggunaHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPenggunaHapusActionPerformed
        try {
            String sql = "DELETE from tbl_pengguna WHERE id='" + idUser + "'";
            ps = con.prepareStatement(sql);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
            tampilUser();
        } catch (Exception e) {
            System.out.println("#Error " + e.getMessage());
        }
        txtUsername.setText("");
        txtPassword.setText("");
        setField(false);
    }//GEN-LAST:event_btnPenggunaHapusActionPerformed
    private void setField(boolean b){
        txtUsername.setEditable(b);
        txtPassword.setEditable(b);
        btnPenggunaSimpan.setEnabled(b);
        btnPenggunaEdit.setEnabled(b);
        btnPenggunaHapus.setEnabled(b);
        btnPenggunaBatal.setEnabled(b);  
    }

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TesPengguna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TesPengguna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TesPengguna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TesPengguna.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new TesPengguna().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(TesPengguna.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPenggunaBatal;
    private javax.swing.JButton btnPenggunaEdit;
    private javax.swing.JButton btnPenggunaHapus;
    private javax.swing.JButton btnPenggunaSimpan;
    private javax.swing.JButton btnPenggunaTambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblIdPelamar;
    private javax.swing.JLabel lblIdPelamar1;
    private javax.swing.JLabel lblNamaPelamar;
    private javax.swing.JTable tblUser;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
