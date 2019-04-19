package Form;

import Process.PrintPdf;
import com.itextpdf.text.DocumentException;
import java.awt.Color;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class F_Menu extends javax.swing.JFrame {

    F_Login formLogin = new F_Login();

    public F_Menu() throws SQLException {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        panel_master.setVisible(false);
        panel_master1.setVisible(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane2 = new javax.swing.JDesktopPane();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        panel_master1 = new javax.swing.JPanel();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        panel_master = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JSeparator();

        javax.swing.GroupLayout jDesktopPane2Layout = new javax.swing.GroupLayout(jDesktopPane2);
        jDesktopPane2.setLayout(jDesktopPane2Layout);
        jDesktopPane2Layout.setHorizontalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jDesktopPane2Layout.setVerticalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jMenuItem1.setText("jMenuItem1");

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistem Pendukung Keputusan Perekrutan  Teknisi");
        setSize(new java.awt.Dimension(200, 200));

        jDesktopPane1.setBackground(new java.awt.Color(204, 204, 255));
        jDesktopPane1.setToolTipText("");

        panel_master1.setBackground(new java.awt.Color(102, 0, 153));
        panel_master1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panel_master1MouseExited(evt);
            }
        });
        panel_master1.setLayout(null);

        jButton11.setBackground(new java.awt.Color(102, 0, 153));
        jButton11.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jButton11.setForeground(new java.awt.Color(255, 255, 255));
        jButton11.setText("Data Nilai Ternormalisasi");
        jButton11.setBorder(null);
        jButton11.setBorderPainted(false);
        jButton11.setContentAreaFilled(false);
        jButton11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton11.setFocusPainted(false);
        jButton11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        panel_master1.add(jButton11);
        jButton11.setBounds(0, 40, 170, 40);

        jButton12.setBackground(new java.awt.Color(102, 0, 153));
        jButton12.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jButton12.setForeground(new java.awt.Color(255, 255, 255));
        jButton12.setText("Data Nilai Kriteria");
        jButton12.setBorder(null);
        jButton12.setBorderPainted(false);
        jButton12.setContentAreaFilled(false);
        jButton12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton12.setFocusPainted(false);
        jButton12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        panel_master1.add(jButton12);
        jButton12.setBounds(0, 0, 170, 38);

        jButton15.setBackground(new java.awt.Color(102, 0, 153));
        jButton15.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jButton15.setForeground(new java.awt.Color(255, 255, 255));
        jButton15.setText("Data Nilai Perankingan");
        jButton15.setBorder(null);
        jButton15.setBorderPainted(false);
        jButton15.setContentAreaFilled(false);
        jButton15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton15.setFocusPainted(false);
        jButton15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        panel_master1.add(jButton15);
        jButton15.setBounds(0, 80, 170, 40);

        jDesktopPane1.add(panel_master1);
        panel_master1.setBounds(200, 0, 170, 130);

        panel_master.setBackground(new java.awt.Color(102, 0, 153));
        panel_master.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panel_masterMouseExited(evt);
            }
        });
        panel_master.setLayout(null);

        jButton4.setBackground(new java.awt.Color(102, 0, 153));
        jButton4.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("  Master Pengguna");
        jButton4.setBorder(null);
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.setFocusPainted(false);
        jButton4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        panel_master.add(jButton4);
        jButton4.setBounds(0, 80, 140, 38);

        jButton7.setBackground(new java.awt.Color(102, 0, 153));
        jButton7.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("  Master Kriteria");
        jButton7.setBorder(null);
        jButton7.setBorderPainted(false);
        jButton7.setContentAreaFilled(false);
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.setFocusPainted(false);
        jButton7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        panel_master.add(jButton7);
        jButton7.setBounds(0, 0, 140, 38);

        jButton8.setBackground(new java.awt.Color(102, 0, 153));
        jButton8.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("  Master Pelamar");
        jButton8.setBorder(null);
        jButton8.setBorderPainted(false);
        jButton8.setContentAreaFilled(false);
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton8.setFocusPainted(false);
        jButton8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        panel_master.add(jButton8);
        jButton8.setBounds(0, 40, 140, 38);

        jDesktopPane1.add(panel_master);
        panel_master.setBounds(0, 0, 120, 120);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Res/19-40-49-17635171_10210777577973408_6401274865824935270_o.jpg"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jDesktopPane1.add(jLabel1);
        jLabel1.setBounds(0, 0, 1440, 750);

        jPanel2.setBackground(new java.awt.Color(102, 0, 153));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
        });
        jPanel2.setLayout(null);

        jSeparator2.setBackground(new java.awt.Color(255, 255, 204));
        jPanel2.add(jSeparator2);
        jSeparator2.setBounds(390, 30, 80, 10);

        jSeparator3.setBackground(new java.awt.Color(255, 255, 204));
        jPanel2.add(jSeparator3);
        jSeparator3.setBounds(0, 30, 80, 10);

        jSeparator4.setBackground(new java.awt.Color(255, 255, 204));
        jPanel2.add(jSeparator4);
        jSeparator4.setBounds(190, 30, 80, 10);

        jSeparator6.setBackground(new java.awt.Color(255, 255, 204));
        jPanel2.add(jSeparator6);
        jSeparator6.setBounds(290, 30, 80, 10);

        jButton2.setBackground(new java.awt.Color(102, 0, 153));
        jButton2.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Logout");
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setFocusPainted(false);
        jButton2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);
        jButton2.setBounds(390, 0, 95, 40);

        jButton5.setBackground(new java.awt.Color(102, 0, 153));
        jButton5.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Master Data");
        jButton5.setBorder(null);
        jButton5.setBorderPainted(false);
        jButton5.setContentAreaFilled(false);
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.setFocusPainted(false);
        jButton5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton5);
        jButton5.setBounds(0, 0, 100, 40);

        jButton9.setBackground(new java.awt.Color(102, 0, 153));
        jButton9.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("Data Hitung");
        jButton9.setBorder(null);
        jButton9.setBorderPainted(false);
        jButton9.setContentAreaFilled(false);
        jButton9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton9.setFocusPainted(false);
        jButton9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton9);
        jButton9.setBounds(100, 0, 90, 40);

        jButton10.setBackground(new java.awt.Color(102, 0, 153));
        jButton10.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setText("Laporan");
        jButton10.setBorder(null);
        jButton10.setBorderPainted(false);
        jButton10.setContentAreaFilled(false);
        jButton10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton10.setFocusPainted(false);
        jButton10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton10);
        jButton10.setBounds(290, 0, 95, 40);

        jButton14.setBackground(new java.awt.Color(102, 0, 153));
        jButton14.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jButton14.setForeground(new java.awt.Color(255, 255, 255));
        jButton14.setText("Proses Hitung");
        jButton14.setBorder(null);
        jButton14.setBorderPainted(false);
        jButton14.setContentAreaFilled(false);
        jButton14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton14.setFocusPainted(false);
        jButton14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton14);
        jButton14.setBounds(190, 0, 95, 40);

        jSeparator7.setBackground(new java.awt.Color(255, 255, 204));
        jPanel2.add(jSeparator7);
        jSeparator7.setBounds(100, 30, 80, 10);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

        try {
            if (tesKriteria == null) {
                tesKriteria = new TesKriteria();
            }
        } catch (SQLException ex) {
            Logger.getLogger(F_Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        tesKriteria.setVisible(true);
        panel_master.setVisible(false);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void panel_masterMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_masterMouseExited

    }//GEN-LAST:event_panel_masterMouseExited

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed

        try {
            if (tesPelamar == null) {
                tesPelamar = new TesPelamar();
            }
        } catch (SQLException ex) {
            Logger.getLogger(F_Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        tesPelamar.setVisible(true);
        panel_master.setVisible(false);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        panel_master.setVisible(false);
        panel_master1.setVisible(false);
        int opt = JOptionPane.showConfirmDialog(null, "Keluar Dari Aplikasi?", "Logout", JOptionPane.YES_NO_OPTION);
        if (opt == 0) {
            if(tesData != null)
                tesData.dispose();
            if(tesHitung != null)
                tesHitung.dispose();
            if(tesKriteria != null)
                tesKriteria.dispose();
            if(tesPelamar != null)
                tesPelamar.dispose();
            if(tesPengguna != null)
                tesPengguna.dispose();
            formLogin.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        panel_master.setVisible(true);
        panel_master1.setVisible(false);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        panel_master.setVisible(false);
        panel_master1.setVisible(false);
        try {
            if (tesData == null) {
                tesData = new TesData();
            }
            tesData.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(F_Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        panel_master.setVisible(false);
        panel_master1.setVisible(true);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
        panel_master.setVisible(false);
        panel_master1.setVisible(false);
    }//GEN-LAST:event_jPanel2MouseClicked

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        panel_master1.setVisible(false);
        File myFile = new File("laporan\\data nilai kriteria.pdf");
        try {
            Desktop.getDesktop().open(myFile);
        } catch (IOException ex) {
            Logger.getLogger(F_Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void panel_master1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_master1MouseExited

    }//GEN-LAST:event_panel_master1MouseExited

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        panel_master1.setVisible(false);
        panel_master.setVisible(false);
        File myFile = new File("laporan\\data nilai ternormalisasi.pdf");
        try {
            Desktop.getDesktop().open(myFile);
        } catch (IOException ex) {
            Logger.getLogger(F_Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        panel_master.setVisible(false);
        panel_master1.setVisible(false);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            if(tesPengguna == null){
                tesPengguna = new TesPengguna();
            }
        } catch (SQLException ex) {
            Logger.getLogger(F_Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        tesPengguna.setVisible(true);
        panel_master.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        panel_master.setVisible(false);
        panel_master1.setVisible(false);
        try {
            if (tesData == null) {
                tesData = new TesData();
                tesData.setVisible(true);
            }
            if (tesHitung == null) {
                tesHitung = new TesHitung(tesData);
            }
            tesHitung.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(F_Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        panel_master1.setVisible(false);
        panel_master.setVisible(false);
        File myFile = new File("laporan\\data nilai hasil perankingan.pdf");
        try {
            Desktop.getDesktop().open(myFile);
        } catch (IOException ex) {
            Logger.getLogger(F_Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton15ActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(F_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(F_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(F_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(F_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new F_Menu().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(F_Menu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    TesData tesData;
    TesHitung tesHitung;
    TesKriteria tesKriteria;
    TesPengguna tesPengguna;
    TesPelamar tesPelamar;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JPanel panel_master;
    private javax.swing.JPanel panel_master1;
    // End of variables declaration//GEN-END:variables
}
