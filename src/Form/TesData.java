package Form;

import Koneksi.KoneksiDb;
import Process.PrintPdf;
import Process.ReadWrite;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TesData extends javax.swing.JFrame {

    Connection con;
    Statement st;
    ResultSet rs;
    PreparedStatement ps;

    public LinkedList<Object> listKriteriaId = new LinkedList<>();
    public LinkedList<Object> listKriteriaNama = new LinkedList<>();
    public LinkedList<String> listHeader = new LinkedList<>();
    public LinkedList<Object> listKriteriaBobot = new LinkedList<>();
    public LinkedList<Object> listKriteriaFlag = new LinkedList<>();

    public LinkedList<Object> listPelamarId = new LinkedList<>();
    public LinkedList<Object> listPelamarNama = new LinkedList<>();

    private PrintPdf printPdf = new PrintPdf();
    private ReadWrite readWrite = new ReadWrite();

    public TesData() throws SQLException {
        initComponents();
        con = new KoneksiDb().getConnect();
        tampilData();
        this.setLocationRelativeTo(null);
    }

    void tampilData() throws SQLException {
        DefaultTableModel mdl = new DefaultTableModel();
        tblProsesHitung.setModel(mdl);

        //proses menentukan header
        mdl.addColumn("<html><b>Alternatif</b><html>");
        mdl.addColumn("<html><b>Nama</b><html>");
        try {
            st = con.createStatement();
            rs = st.executeQuery("select * from tbl_kriteria");
            while (rs.next()) {
                listKriteriaId.add(rs.getString("id_kriteria"));
                listKriteriaNama.add(rs.getString("nama_kriteria"));
                listKriteriaBobot.add(rs.getString("bobot"));
                listKriteriaFlag.add(rs.getString("flag"));
            }
        } catch (Exception e) {
            System.out.println("#ERROR " + e.getMessage());
        }

        for (int i = 0; i < listKriteriaId.size(); i++) {
            listHeader.add("<html><b>" + (String) listKriteriaId.get(i) + " (" + (String) listKriteriaNama.get(i) + ")</b><html>");
        }

        for (String i : listHeader) {
            mdl.addColumn(i);
        }

        //Proses Menentukan Isi
        try {
            st = con.createStatement();
            rs = st.executeQuery("select * from tbl_pelamar ORDER BY LENGTH(id_pelamar), id_pelamar");
            while (rs.next()) {
                listPelamarId.add(rs.getString("id_pelamar"));
                listPelamarNama.add(rs.getString("nama"));
                mdl.addRow(new Object[]{
                    rs.getString("id_pelamar"),
                    rs.getString("nama")
                });
                tblProsesHitung.setModel(mdl);
            }
        } catch (Exception e) {
            System.out.println("#ERROR " + e.getMessage());
        }

        //Proses Menentukan Bobot dan Flag
        mdl.addRow(new Object[]{
            "<html><b>Bobot (%)</b></html>",
            " - "
        });

        mdl.addRow(new Object[]{
            "<html><b>Flag</b><html>",
            " - "
        });
        //mdl.isCellEditable(0, 0);

        //proses agar tabel ada scroll
        tblProsesHitung.setModel(mdl);
        for (int i = 0; i < mdl.getColumnCount(); i++) {
            tblProsesHitung.getColumnModel().getColumn(i).setPreferredWidth(150);
        }

        int rows = tblProsesHitung.getRowCount() - 1;
        int cols = tblProsesHitung.getColumnCount();

        for (int i = 2; i < cols; i++) {
            tblProsesHitung.setValueAt(listKriteriaBobot.get(i - 2), rows - 1, i);
            tblProsesHitung.setValueAt(listKriteriaFlag.get(i - 2), rows, i);
        }

        tblProsesHitung.setShowGrid(true);
    }

    public void refresh() {
        listHeader.clear();
        listKriteriaBobot.clear();
        listKriteriaFlag.clear();
        listKriteriaId.clear();
        listKriteriaNama.clear();

        listPelamarId.clear();
        listPelamarNama.clear();
    }

    public boolean isNumeric(String str) {
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProsesHitung = new javax.swing.JTable();
        btnProsesRefresh = new javax.swing.JButton();
        btnProsesFix = new javax.swing.JButton();
        btnProsesFix1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setTitle("Data Nilai");
        setMinimumSize(new java.awt.Dimension(640, 480));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        tblProsesHitung.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblProsesHitung.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblProsesHitung.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(tblProsesHitung);

        btnProsesRefresh.setBackground(new java.awt.Color(0, 0, 0));
        btnProsesRefresh.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        btnProsesRefresh.setText("Refresh");
        btnProsesRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProsesRefreshActionPerformed(evt);
            }
        });

        btnProsesFix.setBackground(new java.awt.Color(0, 0, 0));
        btnProsesFix.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        btnProsesFix.setText("Simpan");
        btnProsesFix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProsesFixActionPerformed(evt);
            }
        });

        btnProsesFix1.setBackground(new java.awt.Color(0, 0, 0));
        btnProsesFix1.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        btnProsesFix1.setText("Edit");
        btnProsesFix1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProsesFix1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 796, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnProsesRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnProsesFix, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnProsesFix1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnProsesRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnProsesFix1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnProsesFix, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Res/Untitled-4.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 786, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProsesFixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProsesFixActionPerformed
        boolean check = true;

        for (int i = 0; i < tblProsesHitung.getRowCount()-2; i++) {
            for (int j = 2; j < tblProsesHitung.getColumnCount(); j++) {
                String value = (String) tblProsesHitung.getValueAt(i, j);
                //System.out.print("Value("+i+","+j+") : "+isNumeric(value)+" || ");
                if (value != null) {
                    if(isNumeric(value) == false){
                        check = false;
                    }
                }else if(value == null){
                    check = false;
                }
            }
            System.out.println();
        }

        if (check) {
            tblProsesHitung.editCellAt(-1, -1);
            tblProsesHitung.setRowSelectionInterval(0, 0);
            tblProsesHitung.setEnabled(false);
            JOptionPane.showMessageDialog(null, "Data sudah disimpan");
        } else {
            JOptionPane.showMessageDialog(null, "Mohon cek kembali data yang anda inputkan");
        }
    }//GEN-LAST:event_btnProsesFixActionPerformed

    private void btnProsesRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProsesRefreshActionPerformed
        try {
            tblProsesHitung.setEnabled(true);
            refresh();
            tampilData();
        } catch (SQLException ex) {
            Logger.getLogger(M_ProsesHitung.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnProsesRefreshActionPerformed

    private void btnProsesFix1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProsesFix1ActionPerformed
        tblProsesHitung.setEnabled(true);
    }//GEN-LAST:event_btnProsesFix1ActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TesHitung.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TesHitung.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TesHitung.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TesHitung.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new TesData().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(TesData.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnProsesFix;
    private javax.swing.JButton btnProsesFix1;
    private javax.swing.JButton btnProsesRefresh;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tblProsesHitung;
    // End of variables declaration//GEN-END:variables
}
