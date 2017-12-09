/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs;

import javax.swing.JOptionPane;
import com.mysql.jdbc.Statement;
import java.awt.HeadlessException;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import rs.koneksi.koneksi1;
import rs.koneksi.Validasi;
import javax.swing.table.DefaultTableModel;
import java.util.HashMap;
import java.util.Map;
import java.io.File;

public class JadwalDokter extends javax.swing.JFrame {

public HalamanAwal home;
public MenuDokter back;
Connection cn = null;
ResultSet res = null;
koneksi1 konek = new koneksi1();
Map<String, Object> param = new HashMap<String, Object>();
private DefaultTableModel model;
        
    public JadwalDokter() {
        initComponents();
        dataTable();
        setLocationRelativeTo(null);
        comboKode();
        comboKode1();
    }

    public void dataTable() {
        DefaultTableModel tbl = new DefaultTableModel();
        Validasi valid = new Validasi();
        
        tbl.addColumn("Kode jadwal");
        tbl.addColumn("Kode Ruangan");
        tbl.addColumn("Nama klinik");
        tbl.addColumn("Hari");
        tbl.addColumn("Waktu");
        tbl.addColumn("Kode Dokter");
        tbl.addColumn("Nama Dokter");
 


        table3.setModel(tbl);
        try {
            Statement statement = (Statement)koneksi1.GetConnection().createStatement();
            ResultSet res = statement.executeQuery("select * from jadwal");
            while (res.next()) {
                tbl.addRow(new Object[]{
                    res.getString("Kode_jadwal"),
                    res.getString("Kode_ruangan"),
                    res.getString("Nama_klinik"),
                    res.getString("Hari"),
                    res.getString("Waktu"),
                    res.getString("Kdokter"),
                    res.getString("Ndokter")

                });
                table3.setModel(tbl);
            }
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "salah");
        }
        valid.autoNomer(tbl, "JD",3,pkdj);
    }
    
    public void comboKode() {
        try {
            Statement statement = (Statement)koneksi1.GetConnection().createStatement();
            ResultSet res = statement.executeQuery("select * from dokter");
            while (res.next()) {
                pkddj.addItem(res.getString("Kode_Dokter"));
            }
            res.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public void comboKode1() {
        try {
            Statement statement = (Statement)koneksi1.GetConnection().createStatement();
            ResultSet res = statement.executeQuery("select * from ruangan");
            while (res.next()) {
                koderuang.addItem(res.getString("Kode_ruangan"));
            }
            res.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        pkl = new javax.swing.JTextField();
        phr = new javax.swing.JTextField();
        pwk = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table3 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        pkdj = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        pkddj = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        pnamad = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        pcarijd = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        tkodejad = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        koderuang = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        jLabel10.setText("RUMAH SAKIT MEDICA");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Jl. Desa Cipadung no. 66 Kota Bandung");

        jLabel2.setText("Klinik");

        jLabel3.setText("Hari");

        jLabel4.setText("Waktu");

        pkl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pklActionPerformed(evt);
            }
        });

        table3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Kode Jadwal", "Kode Ruangan", "Klinik", "Hari", "Waktu", "Kode Dokter", "Nama Dokter", "Spesialis"
            }
        ));
        table3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table3MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table3);

        jLabel5.setText("Kode Jadwal");

        pkdj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pkdjActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/kembali_1.png"))); // NOI18N
        jButton5.setText("Kembali");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel6.setText("Kode Dokter");

        pkddj.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        pkddj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pkddjActionPerformed(evt);
            }
        });

        jLabel7.setText("Nama Dokter");

        pnamad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pnamadActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/iconsearch.png"))); // NOI18N
        jButton4.setText("Cari");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        pcarijd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pcarijdActionPerformed(evt);
            }
        });

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Beradasarkan Nama Dokter");

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/iconsearch.png"))); // NOI18N
        jButton6.setText("Cari");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Berdasarkan Kode Jadwal");

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/printer.png"))); // NOI18N
        jButton8.setText("Print");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Keterangan :");

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("R401 : Klinik Gigi");

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("R402 : Klinik Anak");

        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("R403 : Klinik Mata");

        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("R404 : Klinik THT");

        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("R405 : Klinik Kandungan");

        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("R406 : Klinik Bagian Dalam");

        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("R407 : Klinik Umum");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton8)
                    .addComponent(jLabel13)
                    .addComponent(jLabel9)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pcarijd))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tkodejad, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel12)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel20))
                    .addComponent(jLabel17)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {pcarijd, tkodejad});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton4, jButton6, jButton8});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel19)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addGap(13, 13, 13)
                .addComponent(jButton8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(tkodejad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(pcarijd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {pcarijd, tkodejad});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton4, jButton6, jButton8});

        jLabel8.setText("Kode Ruangan");

        koderuang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        koderuang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                koderuangActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/save3.png"))); // NOI18N
        jButton1.setText("Simpan");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/refresh.png"))); // NOI18N
        jButton2.setText("Refresh");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/b_edit.png"))); // NOI18N
        jButton9.setText("Edit");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/deletered.png"))); // NOI18N
        jButton3.setText("Hapus");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(pkddj, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel8)
                                                .addComponent(jLabel5)
                                                .addComponent(jLabel3))
                                            .addGap(27, 27, 27))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel4)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(pkl, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(koderuang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(pkdj, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(phr, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(pwk, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(pnamad, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2, jButton3, jButton9});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pkdj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(koderuang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(pkl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(phr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pwk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(pkddj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pnamad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(37, 37, 37))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(20, 20, 20)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton9)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jButton2, jButton3, jButton9});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pklActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pklActionPerformed
        home = new HalamanAwal();
        home.show();
        this.dispose();
    }//GEN-LAST:event_pklActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       back = new MenuDokter();
       back.show();
       this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void pkdjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pkdjActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pkdjActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String kdj = pkdj.getText();
        String kdr = (String)koderuang.getSelectedItem();
        String nama = pkl.getText();
        String hari = phr.getText();
        String waktu = pwk.getText();
        String kodedok = (String)pkddj.getSelectedItem();
        String namadok = pnamad.getText();
        
        try {
            Statement statement = (Statement)koneksi1.GetConnection().createStatement();
            statement.executeUpdate("insert into jadwal VALUES('"+kdj+"','"+ kdr + "','"+ nama + "','"+ hari +"','"+ waktu + "','"+kodedok+"','"+namadok+"');");
            statement.close();
            JOptionPane.showMessageDialog(null, "data berhasil disimpan");
        }
        catch (Exception t) {
            JOptionPane.showMessageDialog(null, "data gagal disimpan");
        }
        dataTable();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       pkdj.setText("");
       koderuang.setSelectedItem("");
       pkl.setText("");
       phr.setText("");
       pwk.setText("");
       pkddj.setSelectedItem("");
       pnamad.setText("");
       tkodejad.setText("");
       pcarijd.setText("");
       dataTable();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String kdj = pkdj.getText();
        try {
            Statement statement = (Statement)koneksi1.GetConnection().createStatement();
            statement.executeUpdate("DELETE from jadwal where Kode_jadwal =('" + kdj + "');");
            JOptionPane.showMessageDialog(null, "Data Berhasil di Hapus");
            pkdj.setText("");
            koderuang.setSelectedItem("");
            pkl.setText("");
            phr.setText("");
            pwk.setText("");
            pkddj.setSelectedItem("");
            pnamad.setText("");
             }
        catch (Exception t ) {
            JOptionPane.showMessageDialog(null, "Data Gagal di Hapus");
        }
        dataTable();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            Statement statement = (Statement)koneksi1.GetConnection().createStatement();
            ResultSet res = statement.executeQuery("select * from jadwal where "+ "NDokter like '"+pcarijd.getText()+"%'");
            DefaultTableModel tbl = new DefaultTableModel();
            
               tbl.addColumn("Kode jadwal");
               tbl.addColumn("Kode Ruangan");
               tbl.addColumn("Nama klinik");
               tbl.addColumn("Hari");
               tbl.addColumn("Waktu");
               tbl.addColumn("Kode Dokter");
               tbl.addColumn("Nama Dokter");
               
               table3.setModel(tbl);
               
               while (res.next()) {
                tbl.addRow(new Object[]{
                    res.getString("Kode_jadwal"),
                    res.getString("Kode_ruangan"),
                    res.getString("Nama_klinik"),
                    res.getString("Hari"),
                    res.getString("Waktu"),
                    res.getString("Kdokter"),
                    res.getString("Ndokter")
                });
                table3.setModel(tbl);
            }   
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Tidak ada");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void pcarijdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pcarijdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pcarijdActionPerformed

    private void pkddjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pkddjActionPerformed
        try {
            Statement statement = (Statement)koneksi1.GetConnection().createStatement();
            ResultSet res = statement.executeQuery("select Nama_Dokter from dokter where Kode_Dokter ='"+pkddj.getSelectedItem()+"'");
            while (res.next()) {
                pnamad.setText(res.getString("Nama_Dokter"));
            }
            res.close();
        } 
        catch (Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_pkddjActionPerformed

    private void pnamadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pnamadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pnamadActionPerformed

    private void koderuangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_koderuangActionPerformed
         try {
            Statement statement = (Statement)koneksi1.GetConnection().createStatement();
            ResultSet res = statement.executeQuery("select Nama_ruangan from ruangan where Kode_ruangan ='"+koderuang.getSelectedItem()+"'");
            while (res.next()) {
                pkl.setText(res.getString("Nama_ruangan"));
            }
            res.close();
        } 
        catch (Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_koderuangActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try {
            Statement statement = (Statement)koneksi1.GetConnection().createStatement();
            ResultSet res = statement.executeQuery("select * from jadwal where "+ "Kode_jadwal ='"+tkodejad.getText()+"'");
            DefaultTableModel tbl = new DefaultTableModel();
            
               tbl.addColumn("Kode jadwal");
               tbl.addColumn("Kode Ruangan");
               tbl.addColumn("Nama klinik");
               tbl.addColumn("Hari");
               tbl.addColumn("Waktu");
               tbl.addColumn("Kode Dokter");
               tbl.addColumn("Nama Dokter");
               
               table3.setModel(tbl);
               
               while (res.next()) {
                tbl.addRow(new Object[]{
                    res.getString("Kode_jadwal"),
                    res.getString("Kode_ruangan"),
                    res.getString("Nama_klinik"),
                    res.getString("Hari"),
                    res.getString("Waktu"),
                    res.getString("Kdokter"),
                    res.getString("Ndokter")
                });
                table3.setModel(tbl);
            }   
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Tidak ada");
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void table3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table3MouseClicked
        int row = table3.getSelectedRow();
        String kode = table3.getValueAt(row, 1).toString();
        String koded = table3.getValueAt(row, 5).toString();
        
        pkdj.setText((String)table3.getValueAt(row, 0));
        koderuang.setSelectedItem(String.valueOf(kode));
        pkl.setText((String)table3.getValueAt(row, 2));
        phr.setText((String)table3.getValueAt(row, 3));
        pwk.setText((String)table3.getValueAt(row, 4));
        pnamad.setText((String)table3.getValueAt(row, 6));
        pkddj.setSelectedItem(String.valueOf(koded));
    }//GEN-LAST:event_table3MouseClicked

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        String kdj = pkdj.getText();
        String kdr = (String)koderuang.getSelectedItem();
        String nama = pkl.getText();
        String hari = phr.getText();
        String waktu = pwk.getText();
        String kodedok = (String)pkddj.getSelectedItem();
        String namadok = pnamad.getText();

        try {
            Statement statement = (Statement) koneksi1.GetConnection().createStatement();
            statement.executeUpdate("UPDATE jadwal " + "SET " + "Kode_jadwal = '" +kdj+ "'," + "Kode_ruangan = '" +kdr+ "'," + "Nama_klinik = '" +nama+"',"+"Hari ='"+hari+"', "+ "Waktu ='"+waktu+"', "+ " Kdokter ='"+kodedok+"', "+ "Ndokter='"+namadok+"'" + "WHERE " + "Kode_jadwal = '" +kdj+ "';");
            statement.close();
            JOptionPane.showMessageDialog(null, "Data berhasil rubah");
            dataTable();
        } catch(Exception t) {
            JOptionPane.showMessageDialog(null, "Data gagal disimpan");        
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        koneksi1 con= new koneksi1();
        java.io.File namaFile=new java.io.File("src/report/report_jadwal.jasper");
        try {
            net.sf.jasperreports.engine.JasperReport jasper;
            jasper=(net.sf.jasperreports.engine.JasperReport)
                    net.sf.jasperreports.engine.util.JRLoader.loadObject(namaFile.getPath());
            net.sf.jasperreports.engine.JasperPrint jp;
            jp=net.sf.jasperreports.engine.JasperFillManager.fillReport(jasper, null,con.GetConnection());
            net.sf.jasperreports.view.JasperViewer.viewReport(jp,false);
        } catch (Exception ex) {
            javax.swing.JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }   
    }//GEN-LAST:event_jButton8ActionPerformed

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
            java.util.logging.Logger.getLogger(JadwalDokter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JadwalDokter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JadwalDokter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JadwalDokter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JadwalDokter().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> koderuang;
    private javax.swing.JTextField pcarijd;
    private javax.swing.JTextField phr;
    private javax.swing.JComboBox<String> pkddj;
    private javax.swing.JTextField pkdj;
    private javax.swing.JTextField pkl;
    private javax.swing.JTextField pnamad;
    private javax.swing.JTextField pwk;
    private javax.swing.JTable table3;
    private javax.swing.JTextField tkodejad;
    // End of variables declaration//GEN-END:variables
}
