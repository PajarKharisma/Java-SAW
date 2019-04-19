package Form;

import Koneksi.KoneksiDb;
import Process.PrintPdf;
import com.itextpdf.text.DocumentException;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class M_ProsesHitung extends javax.swing.JInternalFrame {

    Connection con;
    Statement st;
    ResultSet rs;
    PreparedStatement ps;
    
    LinkedList<Object> listKriteriaId = new LinkedList<>();
    LinkedList<Object> listKriteriaNama = new LinkedList<>();
    LinkedList<String> listHeader = new LinkedList<>();
    LinkedList<Object> listKriteriaBobot = new LinkedList<>();
    LinkedList<Object> listKriteriaFlag = new LinkedList<>();
    LinkedList<Float> listResult = new LinkedList<>();
    
    LinkedList<Object> listPelamarId = new LinkedList<>();
    LinkedList<Object> listPelamarNama = new LinkedList<>();
    
    PrintPdf printPdf = new PrintPdf();
    
    double[][] data;
    double[][] dataBagi;
    double[][] dataPersen;
    
    int alternatif = 0;
    int criteria = 0;
    
    public M_ProsesHitung() throws SQLException {
        initComponents();
        con = new KoneksiDb().getConnect();
        tampilData();
    }

    void tampilData() throws SQLException{
        //Proses Menentukan Header
        DefaultTableModel mdl = new DefaultTableModel();
        tblProsesHitung.setModel(mdl);
        
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
        
        for(int i=0; i<listKriteriaId.size(); i++){
            listHeader.add("<html><b>"+(String)listKriteriaId.get(i) + " (" + (String)listKriteriaNama.get(i) +")</b><html>");
        }
        
        for(String i:listHeader){
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
        tblProsesHitung.setModel(mdl);
        
        int rows = tblProsesHitung.getRowCount()-1;
        int cols = tblProsesHitung.getColumnCount();
        
        for(int i=2; i<cols; i++){
            tblProsesHitung.setValueAt(listKriteriaBobot.get(i-2), rows-1, i);
            tblProsesHitung.setValueAt(listKriteriaFlag.get(i-2), rows, i);
        }
        
        tblProsesHitung.setShowGrid(false);
    }
    
    public void refresh(){
        listHeader.clear();
        listKriteriaBobot.clear();
        listKriteriaFlag.clear();
        listKriteriaId.clear();
        listKriteriaNama.clear();
        
        listPelamarId.clear();
        listPelamarNama.clear();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblProsesHitung = new javax.swing.JTable();
        btnProsesHitung = new javax.swing.JButton();
        btnProsesFix = new javax.swing.JButton();
        btnProsesRefresh = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHasil = new javax.swing.JTable();

        setClosable(true);
        setResizable(true);
        setTitle("Proses Hitung");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblProsesHitung.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblProsesHitung.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(tblProsesHitung);
        tblProsesHitung.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 636, 354));

        btnProsesHitung.setText("Proses");
        btnProsesHitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProsesHitungActionPerformed(evt);
            }
        });
        getContentPane().add(btnProsesHitung, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 371, 77, -1));

        btnProsesFix.setText("Fix");
        btnProsesFix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProsesFixActionPerformed(evt);
            }
        });
        getContentPane().add(btnProsesFix, new org.netbeans.lib.awtextra.AbsoluteConstraints(176, 371, 79, -1));

        btnProsesRefresh.setText("Refresh");
        btnProsesRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProsesRefreshActionPerformed(evt);
            }
        });
        getContentPane().add(btnProsesRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 371, 77, -1));

        tblHasil.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tblHasil);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(664, 11, 243, 354));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProsesRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProsesRefreshActionPerformed
        try {
            refresh();
            tampilData();
        } catch (SQLException ex) {
            Logger.getLogger(M_ProsesHitung.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnProsesRefreshActionPerformed

    private void btnProsesHitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProsesHitungActionPerformed
        printPdf.removeDir("laporan");
        
        alternatif = tblProsesHitung.getRowCount()-2;
        criteria = tblProsesHitung.getColumnCount()-2;
        
        data = new double[alternatif][criteria];
        dataBagi = new double[alternatif][criteria];
        dataPersen = new double[alternatif][criteria];
        
        //Proses input data dari table ke dalam array 2D
        for (int i = 0; i < alternatif; i++) {
            for (int j = 0; j < criteria; j++) {
                data[i][j] = Double.parseDouble(tblProsesHitung.getValueAt(i, j+2).toString());
            }
        }
        
        System.out.println("\n============== DATA ASLI ================");
        for (int i = 0; i < alternatif; i++) {
            for (int j = 0; j < criteria; j++) {
                System.out.print(data[i][j] + "\t");
            }
            System.out.println("");
        }
        
        //PROSES PRINT DATA
        
        try {
            printPdf.print("DATA ASLI", "data asli", listKriteriaId, listPelamarId, listPelamarNama, data);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(M_ProsesHitung.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(M_ProsesHitung.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Proses Membagi Nilai
        for (int i = 0; i < criteria; i++) {
            String value = tblProsesHitung.getValueAt(tblProsesHitung.getRowCount() - 1, i + 2).toString();
            if (value.equals("benefit")) {
                double max = 0;
                for (int j = 0; j < alternatif; j++) {
                    double nilai = data[j][i];
                    if (nilai > max) {
                        max = nilai;
                    }
                }

                for (int j = 0; j < alternatif; j++) {
                    dataBagi[j][i] = data[j][i] / max;
                }
            } else {
                double min = 1000000000;
                for (int j = 0; j < alternatif; j++) {
                    double nilai = data[j][i];
                    if (nilai < min) {
                        min = nilai;
                    }
                }

                for (int j = 0; j < alternatif; j++) {
                    dataBagi[j][i] = min / data[j][i];
                }
            }
        }

        System.out.println("\n\n=================DATA SETELAH DIBAGI====================");
        for (int i = 0; i < alternatif; i++) {
            for (int j = 0; j < criteria; j++) {
                System.out.print(dataBagi[i][j] + "\t");
            }
            System.out.println();
        }
        //PROSES PRINT DATA
        try {
            printPdf.print("DATA SETELAH DIBAGI", "data bagi", listKriteriaId, listPelamarId, listPelamarNama, dataBagi);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(M_ProsesHitung.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(M_ProsesHitung.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Proses Menghitung Dengan Persentase
        for (int i = 0; i < criteria; i++) {
            float persentase = Float.parseFloat(tblProsesHitung.getValueAt(tblProsesHitung.getRowCount() - 2, i + 2).toString());
            System.out.print(persentase + "%\t");
            for (int j = 0; j < alternatif; j++) {
                dataPersen[j][i] = (dataBagi[j][i] * persentase) / 100f;
            }
        }

        System.out.println("\n\n=================DATA PERSENTASE====================");
        for (int i = 0; i < alternatif; i++) {
            for (int j = 0; j < criteria; j++) {
                System.out.print(dataPersen[i][j] + "\t");
            }
            System.out.println();
        }
        
        //PROSES PRINT DATA
        try {
            printPdf.print("DATA PERSENTASE", "data persentase", listKriteriaId, listPelamarId, listPelamarNama, dataPersen);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(M_ProsesHitung.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(M_ProsesHitung.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Proses menjumlahkan setiap kriteria
        for (int i = 0; i < alternatif; i++) {
            float sum = 0;
            for (int j = 0; j < criteria; j++) {
                sum += dataPersen[i][j];
            }
            listResult.add(sum);
        }
        
        DefaultTableModel mdl = new DefaultTableModel();
        mdl.addColumn("Alternatif");
        mdl.addColumn("Hasil");
        for (int i = 0; i < listResult.size(); i++) {
            mdl.addRow(new Object[]{
                "Alternatif" + (i + 1),
                listResult.get(i).toString()
            });
        }
        tblHasil.setModel(mdl);
        
        System.out.println("\n\n=================DATA HASIL PENJUMLAHAN SETIAP KRITERIA====================");
        for(float i:listResult){
            System.out.println("Result : "+i);
        }
        
        /*
        try {
            printPdf.print("Muhammad Pajar Kharisma Putra", "Coba", listKriteriaId, listPelamarId, listPelamarNama, data);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(M_ProsesHitung.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(M_ProsesHitung.class.getName()).log(Level.SEVERE, null, ex);
        }
*/
    }//GEN-LAST:event_btnProsesHitungActionPerformed

    private void btnProsesFixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProsesFixActionPerformed
        tblProsesHitung.editCellAt(-1, -1);
        tblProsesHitung.setRowSelectionInterval(0, 0);
        tblProsesHitung.setEnabled(false);
    }//GEN-LAST:event_btnProsesFixActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnProsesFix;
    private javax.swing.JButton btnProsesHitung;
    private javax.swing.JButton btnProsesRefresh;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblHasil;
    private javax.swing.JTable tblProsesHitung;
    // End of variables declaration//GEN-END:variables
}
