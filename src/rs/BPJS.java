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
import java.text.SimpleDateFormat;
import rs.koneksi.koneksi1;
import rs.koneksi.Validasi;
import javax.swing.table.DefaultTableModel;
import java.util.HashMap;
import java.util.Map;
import java.io.File;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.engine.util.JRLoader;

public class BPJS extends javax.swing.JFrame {

    Connection cn = null;
    ResultSet res = null;
    public HalamanAwal home;
    koneksi1 konek = new koneksi1();
    private DefaultTableModel model;
    
    public BPJS() {
        initComponents();
        dataTable();
        setLocationRelativeTo(null);
        comboKode();
        comboKode1();
    }

    public void dataTable() {
        DefaultTableModel tbl = new DefaultTableModel();
        Validasi valid = new Validasi();
        
        tbl.addColumn("No. Registrasi");
        tbl.addColumn("NIK/No. KTP");
        tbl.addColumn("Nama");
        tbl.addColumn("Jenis Kelamin");
        tbl.addColumn("Tempat Lahir");
        tbl.addColumn("Tanggal Lahir");
        tbl.addColumn("Alamat");
        tbl.addColumn("Status Pernikaha");
        tbl.addColumn("No. Handphone");
        tbl.addColumn("Pekerjaan");
        tbl.addColumn("NPWP");
        tbl.addColumn("Kelas Perawatan");

        table4.setModel(tbl);
        try {
            Statement statement = (Statement)koneksi1.GetConnection().createStatement();
            ResultSet res = statement.executeQuery("select * from peserta_bpjs");
            while (res.next()) {
                tbl.addRow(new Object[]{
                    res.getString("No_Regis"),
                    res.getString("Nik"),
                    res.getString("Nama_peserta"),
                    res.getString("Jk"),
                    res.getString("Tempat_L"),
                    res.getString("Tgl_lahir"),
                    res.getString("Alamat"),
                    res.getString("Status_per"),
                    res.getString("No_hp"),
                    res.getString("Pekerjaan"),
                    res.getString("npwp"),
                    res.getString("Kelas_P")
                });
                table4.setModel(tbl);
            }
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "salah");
        }
        valid.autoNomer(tbl, "BPJS",4,pnoreg);
    }  
    
    public void comboKode() {
        try {
            Statement statement = (Statement)koneksi1.GetConnection().createStatement();
            ResultSet res = statement.executeQuery("select * from kelas_perawatan");
            while (res.next()) {
                pkpb.addItem(res.getString("Kode_kelas"));
            }
            res.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public void comboKode1() {
        try {
            Statement statement = (Statement)koneksi1.GetConnection().createStatement();
            ResultSet res = statement.executeQuery("select * from pekerjaan");
            while (res.next()) {
                ppkb.addItem(res.getString("Nama_pekerjaan"));
            }
            res.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        pnoreg = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        pnik = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        pnamab = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        pjklb = new javax.swing.JRadioButton();
        pjkpb = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        ptmpl = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        palmb = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        pstap = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        phpb = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        ppkb = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        pnpwp = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        pkpb = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        table4 = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        pharga = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jcarib = new javax.swing.JButton();
        pcarib = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        carkodbp = new javax.swing.JButton();
        tcarkodbp = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jcetakbp = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        ptglb = new javax.swing.JTextField();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable2);

        jButton6.setText("jButton6");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("RUMAH SAKIT MEDICA");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Jl. Desa Cipadung no. 66 Kota Bandung");

        jLabel1.setText("No. Registrasi ");

        jLabel2.setText("NIK/No. KTP");

        jLabel3.setText("Nama");

        jLabel5.setText("Jenis Kelamin");

        pjklb.setBackground(new java.awt.Color(0, 204, 204));
        buttonGroup1.add(pjklb);
        pjklb.setText("Laki-laki");

        pjkpb.setBackground(new java.awt.Color(0, 204, 204));
        buttonGroup1.add(pjkpb);
        pjkpb.setText("Perempuan");

        jLabel7.setText("Tempat Lahir");

        ptmpl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ptmplActionPerformed(evt);
            }
        });

        jLabel8.setText("Tanggal Lahir");

        jLabel9.setText("Alamat");

        palmb.setColumns(20);
        palmb.setRows(5);
        jScrollPane1.setViewportView(palmb);

        jLabel10.setText("Status Pernikahan");

        pstap.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Belum Kawin", "Kawin", "Duda", "Janda" }));
        pstap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pstapActionPerformed(evt);
            }
        });

        jLabel11.setText("No. Handphone");

        jLabel12.setText("Pekerjaan");

        ppkb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        ppkb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ppkbActionPerformed(evt);
            }
        });

        jLabel13.setText("NPWP");

        jLabel14.setText("Kelas Perawatan");

        pkpb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        pkpb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pkpbActionPerformed(evt);
            }
        });

        table4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No. Registrasi", "NIK/No. KTP", "Nama", "Jenis Kelamin", "Tempat Lahir", "Tanggal Lahir", "Alamat", "Status Pernikahan", "No. Handphone", "Pekerjaan", "NPWP", "Kelas Perawatan"
            }
        ));
        table4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table4MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(table4);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/kembali_1.png"))); // NOI18N
        jButton5.setText("Kembali");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));

        jcarib.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/iconsearch.png"))); // NOI18N
        jcarib.setText("Cari");
        jcarib.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcaribActionPerformed(evt);
            }
        });

        pcarib.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pcaribActionPerformed(evt);
            }
        });

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Berdasarkan Nama");

        carkodbp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/iconsearch.png"))); // NOI18N
        carkodbp.setText("Cari");
        carkodbp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carkodbpActionPerformed(evt);
            }
        });

        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Berdasarkan Kode");

        jcetakbp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/badge-512.png"))); // NOI18N
        jcetakbp.setText("Kartu");
        jcetakbp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcetakbpActionPerformed(evt);
            }
        });

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/printer.png"))); // NOI18N
        jButton7.setText("Print");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(carkodbp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tcarkodbp))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jcarib)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pcarib, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel16)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcetakbp)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {pcarib, tcarkodbp});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {carkodbp, jButton7, jcarib, jcetakbp});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7)
                    .addComponent(jcetakbp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(carkodbp)
                    .addComponent(tcarkodbp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcarib)
                    .addComponent(pcarib, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {pcarib, tcarkodbp});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {carkodbp, jButton7, jcarib, jcetakbp});

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/save3.png"))); // NOI18N
        jButton2.setText("Simpan");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/refresh.png"))); // NOI18N
        jButton3.setText("Refresh");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/deletered.png"))); // NOI18N
        jButton4.setText("Hapus");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/imagebpjs2.png"))); // NOI18N

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/b_edit.png"))); // NOI18N
        jButton1.setText("Edit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pnamab)
                            .addComponent(ptmpl)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(pnoreg)
                            .addComponent(pnik)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(pjklb)
                                .addGap(18, 18, 18)
                                .addComponent(pjkpb))
                            .addComponent(ptglb))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 151, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(pkpb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pharga))
                            .addComponent(ppkb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pstap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(phpb, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                            .addComponent(pnpwp))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2, jButton3, jButton4, jButton5});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(pnoreg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(pnik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pnamab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(pjklb)
                            .addComponent(pjkpb))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(ptmpl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(ptglb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(pstap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(phpb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(ppkb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(pnpwp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(pkpb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pharga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jButton2, jButton3, jButton4, jButton5});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pstapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pstapActionPerformed
        try {
            Statement statement = (Statement)koneksi1.GetConnection().createStatement();
            ResultSet res = statement.executeQuery("select Status_per from peserta_bpjs'"+pstap.getSelectedItem()+"'");
        } 
        catch (Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_pstapActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       home = new HalamanAwal();
       home.show();
       this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String noreg = pnoreg.getText();
        String nik = pnik.getText();
        String nama = pnamab.getText();
        String jenisk = null;
        if (pjklb.isSelected()) {
            jenisk = "Laki-laki";
        } else if (pjkpb.isSelected()) {
            jenisk = "Perempuan";
        }
        String tmpt = ptmpl.getText();
        String tgl = ptglb.getText();
        String almt = palmb.getText();
        String statp = (String)pstap.getSelectedItem();
        String nohp = phpb.getText();
        String pkr = (String)ppkb.getSelectedItem();
        String npwp = pnpwp.getText();
        String kelasp = (String)pkpb.getSelectedItem();
        String harga = pharga.getText();
        
        try {
        Statement statement = (Statement)koneksi1.GetConnection().createStatement();
        statement.executeUpdate("insert into peserta_bpjs VALUES('"+ noreg + "','"+ nik + "','"+ nama +"','"+ jenisk + "','"+ tmpt + "','"+tgl+"','"+almt+"','"+statp+"','"+nohp+"','"+pkr+"','"+npwp+"','"+kelasp+"');");
        statement.close();
        JOptionPane.showMessageDialog(null, "Anda Berhasil Terdaftar");
        }
        catch (Exception t) {
            JOptionPane.showMessageDialog(null, "data gagal disimpan");
        }
        dataTable();

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        pnoreg.setText("");
        pnik.setText("");
        pnamab.setText("");
        if (pjklb.isSelected()) {
            //jenisk = "Laki-laki";
        } else if (pjkpb.isSelected()) {
            //jenisk = "Perempuan";
        }
        ptmpl.setText("");
        palmb.setText("");
        pstap.setSelectedItem("");
        phpb.setText("");
        ppkb.setSelectedItem("");
        pnpwp.setText("");
        pkpb.setSelectedItem("");
        pharga.setText("");
        tcarkodbp.setText("");
        pcarib.setText("");

        dataTable();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String noreg = pnoreg.getText();
        try {
            Statement statement = (Statement)koneksi1.GetConnection().createStatement();
            statement.executeUpdate("DELETE from peserta_bpjs where No_Regis =('" + noreg + "');");
            JOptionPane.showMessageDialog(null, "Data Berhasil di Hapus");
            pnoreg.setText("");
            pnik.setText("");
            pnamab.setText("");
            if (pjklb.isSelected()) {
                //jenisk = "Laki-laki";
            } else if (pjkpb.isSelected()) {
                //jenisk = "Perempuan";
            }
            ptmpl.setText("");
            palmb.setText("");
            pstap.setSelectedItem("");
            phpb.setText("");
            ppkb.setSelectedItem("");
            pnpwp.setText("");
            pkpb.setSelectedItem("");
            pharga.setText("");
        }
        catch (Exception t ) {
            JOptionPane.showMessageDialog(null, "Data Gagal di Hapus");
        }
        dataTable();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jcaribActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcaribActionPerformed
        try {
            Statement statement = (Statement)koneksi1.GetConnection().createStatement();
            ResultSet res = statement.executeQuery("select * from peserta_bpjs where "+ "Nama_peserta like '"+pcarib.getText()+"%'");
            DefaultTableModel tbl = new DefaultTableModel();
            tbl.addColumn("No. Registrasi");
            tbl.addColumn("NIK/No. KTP");
            tbl.addColumn("Nama");
            tbl.addColumn("Jenis Kelamin");
            tbl.addColumn("Tempat Lahir");
            tbl.addColumn("Tanggal Lahir");
            tbl.addColumn("Alamat");
            tbl.addColumn("Status Pernikaha");
            tbl.addColumn("No. Handphone");
            tbl.addColumn("Pekerjaan");
            tbl.addColumn("NPWP");
            tbl.addColumn("Kelas Perawatan");

            table4.setModel(tbl);
            
             while (res.next()) {
                tbl.addRow(new Object[]{
                    res.getString("No_Regis"),
                    res.getString("Nik"),
                    res.getString("Nama_peserta"),
                    res.getString("Jk"),
                    res.getString("Tempat_L"),
                    res.getString("Tgl_lahir"),
                    res.getString("Alamat"),
                    res.getString("Status_per"),
                    res.getString("No_hp"),
                    res.getString("Pekerjaan"),
                    res.getString("npwp"),
                    res.getString("Kelas_P")
                });
                table4.setModel(tbl);
            }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Tidak ada");
        }
    }//GEN-LAST:event_jcaribActionPerformed

    private void pcaribActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pcaribActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pcaribActionPerformed

    private void ppkbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ppkbActionPerformed
        try {
            Statement statement = (Statement)koneksi1.GetConnection().createStatement();
            ResultSet res = statement.executeQuery("select Nama_pekerjaan from Pekerjaan'"+ppkb.getSelectedItem()+"'");
        } 
        catch (Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_ppkbActionPerformed

    private void pkpbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pkpbActionPerformed
         try {
            Statement statement = (Statement)koneksi1.GetConnection().createStatement();
            ResultSet res = statement.executeQuery("select Harga_bayar from kelas_perawatan where Kode_kelas ='"+pkpb.getSelectedItem()+"'");
            while (res.next()) {
                pharga.setText(res.getString("Harga_bayar"));
            }
            res.close();
        } 
        catch (Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_pkpbActionPerformed

    private void carkodbpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carkodbpActionPerformed
        try {
            Statement statement = (Statement)koneksi1.GetConnection().createStatement();
            ResultSet res = statement.executeQuery("select * from peserta_bpjs where "+ "No_Regis ='"+tcarkodbp.getText()+"'");
            DefaultTableModel tbl = new DefaultTableModel();
            tbl.addColumn("No. Registrasi");
            tbl.addColumn("NIK/No. KTP");
            tbl.addColumn("Nama");
            tbl.addColumn("Jenis Kelamin");
            tbl.addColumn("Tempat Lahir");
            tbl.addColumn("Tanggal Lahir");
            tbl.addColumn("Alamat");
            tbl.addColumn("Status Pernikaha");
            tbl.addColumn("No. Handphone");
            tbl.addColumn("Pekerjaan");
            tbl.addColumn("NPWP");
            tbl.addColumn("Kelas Perawatan");

            table4.setModel(tbl);
            
             while (res.next()) {
                tbl.addRow(new Object[]{
                    res.getString("No_Regis"),
                    res.getString("Nik"),
                    res.getString("Nama_peserta"),
                    res.getString("Jk"),
                    res.getString("Tempat_L"),
                    res.getString("Tgl_lahir"),
                    res.getString("Alamat"),
                    res.getString("Status_per"),
                    res.getString("No_hp"),
                    res.getString("Pekerjaan"),
                    res.getString("npwp"),
                    res.getString("Kelas_P")
                });
                table4.setModel(tbl);
            }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Tidak ada");
        }
    }//GEN-LAST:event_carkodbpActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        koneksi1 con= new koneksi1();
        java.io.File namaFile=new java.io.File("src/report/report_BPJS.jasper");
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
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jcetakbpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcetakbpActionPerformed
        try {
            String path = "src/report/kartu_BPJS.jasper";
            HashMap parameter = new HashMap();
            parameter.put("pasbp",pnoreg.getText());
            JasperPrint print = JasperFillManager.fillReport(path, parameter, koneksi1.GetConnection());
            JasperViewer.viewReport(print, false);
        } catch(Exception ex) {
            JOptionPane.showInternalMessageDialog(rootPane, "Dokumen Tidak Ada"+ ex);
        }
    }//GEN-LAST:event_jcetakbpActionPerformed

    private void table4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table4MouseClicked
        int row = table4.getSelectedRow();
        String status = table4.getValueAt(row, 7).toString();
        String peker = table4.getValueAt(row, 9).toString();
        String kelas = table4.getValueAt(row, 11).toString();
        
        pnoreg.setText((String)table4.getValueAt(row, 0));
        pnik.setText((String)table4.getValueAt(row, 1));
        pnamab.setText((String)table4.getValueAt(row, 2));
        ptmpl.setText((String)table4.getValueAt(row, 4));
        palmb.setText((String)table4.getValueAt(row, 6));
        pstap.setSelectedItem(String.valueOf(status));
        phpb.setText((String)table4.getValueAt(row, 8));
        ppkb.setSelectedItem(String.valueOf(peker));
        pnpwp.setText((String)table4.getValueAt(row, 10));
        pkpb.setSelectedItem(String.valueOf(kelas));
    }//GEN-LAST:event_table4MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String noreg = pnoreg.getText();
        String nik = pnik.getText();
        String nama = pnamab.getText();
        String jenisk = null;
        if (pjklb.isSelected()) {
            jenisk = "Laki-laki";
        } else if (pjkpb.isSelected()) {
            jenisk = "Perempuan";
        }
        String tempatl = ptmpl.getText();
        String tgl = ptglb.getText();
        String alamat = palmb.getText();
        String status = (String)pstap.getSelectedItem();
        String nohp = phpb.getText();
        String peker = (String) ppkb.getSelectedItem();
        String npwp = pnpwp.getText();
        String kelas = (String) pkpb.getSelectedItem();
        try {
            Statement statement = (Statement) koneksi1.GetConnection().createStatement();
            statement.executeUpdate("UPDATE peserta_bpjs " + "SET " + "No_Regis = '" +noreg+ "'," + "Nik = '" +nik+ "'," + "Nama_peserta = '" +nama+"',"+"Jk ='"+jenisk+"', "+" Tempat_L='"+tempatl+"', "+"Tgl_lahir ='"+tgl+"', "+"Alamat ='"+alamat+"', "+ " Status_per ='"+status+"', "+ "No_hp='"+nohp+"', "+ " Pekerjaan ='"+peker+"', "+"npwp ='"+npwp+"', "+"Kelas_P ='"+kelas+"'"+ "WHERE " + "No_Regis = '" +noreg+ "';");
            statement.close();
            JOptionPane.showMessageDialog(null, "Data berhasil rubah");
        } catch(Exception t) {
            JOptionPane.showMessageDialog(null, "Data gagal disimpan");
        }
        dataTable();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ptmplActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ptmplActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ptmplActionPerformed


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
            java.util.logging.Logger.getLogger(BPJS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BPJS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BPJS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BPJS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BPJS().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton carkodbp;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton jcarib;
    private javax.swing.JButton jcetakbp;
    private javax.swing.JTextArea palmb;
    private javax.swing.JTextField pcarib;
    private javax.swing.JTextField pharga;
    private javax.swing.JTextField phpb;
    private javax.swing.JRadioButton pjklb;
    private javax.swing.JRadioButton pjkpb;
    private javax.swing.JComboBox<String> pkpb;
    private javax.swing.JTextField pnamab;
    private javax.swing.JTextField pnik;
    private javax.swing.JTextField pnoreg;
    private javax.swing.JTextField pnpwp;
    private javax.swing.JComboBox<String> ppkb;
    private javax.swing.JComboBox<String> pstap;
    private javax.swing.JTextField ptglb;
    private javax.swing.JTextField ptmpl;
    private javax.swing.JTable table4;
    private javax.swing.JTextField tcarkodbp;
    // End of variables declaration//GEN-END:variables
}
