package Form;

import Process.PrintPdf;
import Process.ReadWrite;
import Process.ResultData;
import Process.ResultOrder;
import com.itextpdf.text.DocumentException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class TesHitung extends javax.swing.JFrame {

    private PrintPdf printPdf = new PrintPdf();
    private TesData tesData;
    private LinkedList<Double> listResult = new LinkedList<>();
    private LinkedList<ResultData> listResultData = new LinkedList<>();
    private ResultData resultData;
    private ResultOrder resultOrder = new ResultOrder();
    
    public double[][] data;
    private double[][] dataBagi;
    private double[][] dataPersen;
    
    private int alternatif = 0;
    private int criteria = 0;
    
    public TesHitung(TesData tesData) throws SQLException {
        initComponents();
        this.setLocationRelativeTo(null);
        this.tesData = tesData;
    }

    private TesHitung() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblIdPelamar1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnProsesHitung = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHasilHitung = new javax.swing.JTable();
        btnProsesClear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Proses Hitung");

        lblIdPelamar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Res/Logo Niaga.jpg"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        btnProsesHitung.setBackground(new java.awt.Color(0, 0, 0));
        btnProsesHitung.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        btnProsesHitung.setText("Hitung");
        btnProsesHitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProsesHitungActionPerformed(evt);
            }
        });

        tblHasilHitung.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblHasilHitung.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(tblHasilHitung);

        btnProsesClear.setBackground(new java.awt.Color(0, 0, 0));
        btnProsesClear.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        btnProsesClear.setText("Clear");
        btnProsesClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProsesClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnProsesHitung, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnProsesClear, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnProsesHitung, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProsesClear, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblIdPelamar1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(lblIdPelamar1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProsesHitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProsesHitungActionPerformed
        //Proses agar tidak ada redudansi data
        DefaultTableModel mdlClear = (DefaultTableModel) tblHasilHitung.getModel();
        mdlClear.setRowCount(0);
        listResult.clear();
        
        //proses menghapus semua isi di folder laporan
        printPdf.removeDir("laporan");
        
        alternatif = tesData.tblProsesHitung.getRowCount()-2;
        criteria = tesData.tblProsesHitung.getColumnCount()-2;

        data = new double[alternatif][criteria];
        dataBagi = new double[alternatif][criteria];
        dataPersen = new double[alternatif][criteria];

        //Proses input data dari table ke dalam array 2D
        for (int i = 0; i < alternatif; i++) {
            for (int j = 0; j < criteria; j++) {
                data[i][j] = Double.parseDouble(tesData.tblProsesHitung.getValueAt(i, j+2).toString());
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
            printPdf.print("DATA NILAI KRITERIA", "data nilai kriteria", tesData.listKriteriaId, tesData.listPelamarId, tesData.listPelamarNama, data);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(M_ProsesHitung.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(M_ProsesHitung.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Proses Membagi Nilai
        for (int i = 0; i < criteria; i++) {
            String value = tesData.tblProsesHitung.getValueAt(tesData.tblProsesHitung.getRowCount() - 1, i + 2).toString();
            if (value.equals("benefit")) {
                double max = 0;
                for (int j = 0; j < alternatif; j++) {
                    double nilai = data[j][i];
                    if (nilai > max) {
                        max = nilai;
                    }
                }

                for (int j = 0; j < alternatif; j++) {
                    double val = data[j][i] / max;
                    dataBagi[j][i] = Math.round(val*1000.0)/1000.0;
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
                    double val = min / data[j][i];
                    dataBagi[j][i] = Math.round(val*1000.0)/1000.0;
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
            printPdf.print("DATA NILAI TERNORMALISASI", "data nilai ternormalisasi", tesData.listKriteriaId, tesData.listPelamarId, tesData.listPelamarNama, dataBagi);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(M_ProsesHitung.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(M_ProsesHitung.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Proses Menghitung Dengan Persentase
        for (int i = 0; i < criteria; i++) {
            double persentase = Float.parseFloat(tesData.tblProsesHitung.getValueAt(tesData.tblProsesHitung.getRowCount() - 2, i + 2).toString());
            System.out.print(persentase + "%\t");
            for (int j = 0; j < alternatif; j++) {
                double val = (dataBagi[j][i] * persentase) / 100f;
                dataPersen[j][i] = Math.round(val*1000.0)/1000.0;
            }
        }

        System.out.println("\n\n=================DATA PERSENTASE====================");
        for (int i = 0; i < alternatif; i++) {
            for (int j = 0; j < criteria; j++) {
                System.out.print(dataPersen[i][j] + "\t");
            }
            System.out.println();
        }

        //Proses menjumlahkan setiap kriteria
        for (int i = 0; i < alternatif; i++) {
            double sum = 0;
            for (int j = 0; j < criteria; j++) {
                sum += dataPersen[i][j];
            }
            listResult.add(Math.round(sum*1000.0)/1000.0);
        }
        
        //PROSES PRINT DATA
//        try {
//            printPdf.print("DATA HASIL PERBANDINGAN", "data hasil perbandingan", tesData.listKriteriaId, tesData.listPelamarId, tesData.listPelamarNama, dataPersen);
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(M_ProsesHitung.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (DocumentException ex) {
//            Logger.getLogger(M_ProsesHitung.class.getName()).log(Level.SEVERE, null, ex);
//        }

        for(int i=0; i<listResult.size(); i++){
            LinkedList<Double> listValue = new LinkedList<>();
            int cols = tesData.tblProsesHitung.getColumnCount();
            for(int j=2; j<cols; j++){
                double val = Float.parseFloat(tesData.tblProsesHitung.getValueAt(i, j).toString());
                listValue.add(val);
            }
            resultData = new ResultData();
            resultData.setAlternatif("Alternatif "+(i+1));
            resultData.setNamaAlternatif(tesData.tblProsesHitung.getValueAt(i, 1).toString());
            resultData.setListValue(listValue);
            resultData.setResult(listResult.get(i));
            
            listResultData.add(resultData);
        }
        
        ResultData[] rd = new ResultData[listResultData.size()];
        for(int i=0; i<rd.length; i++){
            rd[i] = listResultData.get(i);
        }
        
        LinkedList<ResultData> listFinalResult = resultOrder.getResultData(rd);
        
        for(int i=0; i<listFinalResult.size(); i++){
            System.out.print(listFinalResult.get(i).getAlternatif()+"||");
            System.out.print(listFinalResult.get(i).getNamaAlternatif()+"||");
            for(int j=0; j<listFinalResult.get(i).getListValue().size(); j++){
                System.out.print(listFinalResult.get(i).getListValue().get(j)+"||");
            }
            System.out.println(listFinalResult.get(i).getResult());
        }
        
        //Proses menampilkan di tabel
        DefaultTableModel mdl = new DefaultTableModel();
        mdl.addColumn("Alternatif");
        mdl.addColumn("Nama");
        mdl.addColumn("Hasil");
        for (int i = 0; i < listResult.size(); i++) {
            mdl.addRow(new Object[]{
                listFinalResult.get(i).getAlternatif(),
                listFinalResult.get(i).getNamaAlternatif(),
                listFinalResult.get(i).getResult()
            });
        }
        tblHasilHitung.setModel(mdl);
        
        //PROSES PRINT DATA
//        try {
//            printPdf.print("DATA NILAI HASIL PERANKINGAN", "data nilai hasil perankingan", listFinalResult);
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(M_ProsesHitung.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (DocumentException ex) {
//            Logger.getLogger(M_ProsesHitung.class.getName()).log(Level.SEVERE, null, ex);
//        }
        //PROSES PRINT DATA
        try {
            printPdf.print("DATA NILAI HASIL PERANKINGAN", "data nilai hasil perankingan", tesData.listKriteriaId, listFinalResult);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(M_ProsesHitung.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(M_ProsesHitung.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnProsesHitungActionPerformed

    private void btnProsesClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProsesClearActionPerformed
        DefaultTableModel mdlClear = (DefaultTableModel) tblHasilHitung.getModel();
        mdlClear.setRowCount(0);
        listResult.clear();
        listResultData.clear();
    }//GEN-LAST:event_btnProsesClearActionPerformed

    public static void main(String args[]) {
 
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TesData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TesData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TesData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TesData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TesHitung().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnProsesClear;
    private javax.swing.JButton btnProsesHitung;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblIdPelamar1;
    private javax.swing.JTable tblHasilHitung;
    // End of variables declaration//GEN-END:variables
}
