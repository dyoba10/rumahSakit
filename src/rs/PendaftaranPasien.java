
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



public class PendaftaranPasien extends javax.swing.JFrame {

    Connection cn = null;
    ResultSet res = null;
    public HalamanAwal home;
    koneksi1 konek = new koneksi1();
    private DefaultTableModel model;
    
    public PendaftaranPasien() {
        initComponents();
        dataTable();
        setLocationRelativeTo(null);
        comboKode();
        comboKode1();
    }
    
    public void dataTable() {
        DefaultTableModel tbl = new DefaultTableModel();
        Validasi valid = new Validasi();
        
        tbl.addColumn("Kode Pasien");       
        tbl.addColumn("No. KTP");
        tbl.addColumn("Nama");
        tbl.addColumn("Tanggal Lahir");
        tbl.addColumn("Gol. Darah");
        tbl.addColumn("Alamat");
        tbl.addColumn("Jenis Kelamin");
        tbl.addColumn("Pekerjaan");
        tbl.addColumn("Perawatan");

        table1.setModel(tbl);
        try {
            Statement statement = (Statement)koneksi1.GetConnection().createStatement();
            ResultSet res = statement.executeQuery("select * from pasien");
            while (res.next()) {
                tbl.addRow(new Object[]{
                    res.getString("Kode_pas"),
                    res.getString("No_KTP"),
                    res.getString("Nama_Pasien"),
                    res.getString("Ttl"),
                    res.getString("Golongan_Darah"),
                    res.getString("Alamat"),
                    res.getString("Jk"),
                    res.getString("Pekerjaan"),
                    res.getString("Bagian_Perawatan"),
                });
                table1.setModel(tbl);
            }
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "salah");
        }
        valid.autoNomer(tbl, "PAT",4,pkodepas);
    }
    
    public void comboKode() {
        try {
            Statement statement = (Statement)koneksi1.GetConnection().createStatement();
            ResultSet res = statement.executeQuery("select * from spesialis");
            while (res.next()) {
                pper.addItem(res.getString("Nama_spe"));
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
                ppeker.addItem(res.getString("Nama_pekerjaan"));
            }
            res.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        pnama = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        pgol = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        palamat = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        pjkl = new javax.swing.JRadioButton();
        pjkp = new javax.swing.JRadioButton();
        jLabel11 = new javax.swing.JLabel();
        ppeker = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        pktp = new javax.swing.JTextField();
        pper = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        pcari = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        tcarkod = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        carkod = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        pkodepas = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        ptglp = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        jLabel5.setText("Nama");

        jLabel7.setText("Gol. Darah");

        pgol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "A", "B", "O", "AB" }));
        pgol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pgolActionPerformed(evt);
            }
        });

        jLabel9.setText("Alamat");

        palamat.setColumns(20);
        palamat.setRows(5);
        jScrollPane1.setViewportView(palamat);

        jLabel10.setText("Jenis Kelamin");

        pjkl.setBackground(new java.awt.Color(0, 204, 204));
        buttonGroup1.add(pjkl);
        pjkl.setText("Laki-laki");

        pjkp.setBackground(new java.awt.Color(0, 204, 204));
        buttonGroup1.add(pjkp);
        pjkp.setText("Perempuan");
        pjkp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pjkpActionPerformed(evt);
            }
        });

        jLabel11.setText("Pekerjaan");

        ppeker.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        ppeker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ppekerActionPerformed(evt);
            }
        });

        jLabel12.setText("Perawatan");

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Kode Pasien", "No. KTP", "Nama", "Umur", "Gol. Darah", "Alamat", "Jenis Kelamin", "Pekerjaan", "Perawatan"
            }
        ));
        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table1);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/kembali_1.png"))); // NOI18N
        jButton5.setText("Kembali");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel1.setText("No. KTP");

        pper.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        pper.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pperActionPerformed(evt);
            }
        });

        jLabel2.setText("Tanggal Lahir");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("RUMAH SAKIT MEDICA");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Jl. Desa Cipadung no. 66 Kota Bandung");

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/iconsearch.png"))); // NOI18N
        jButton6.setText("Cari");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Beradasarkan Nama");

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Berdasarkan Kode");

        carkod.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/iconsearch.png"))); // NOI18N
        carkod.setText("Cari");
        carkod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carkodActionPerformed(evt);
            }
        });

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/badge-512.png"))); // NOI18N
        jButton7.setText("Kartu");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/printer.png"))); // NOI18N
        jButton2.setText("Print");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pcari))
                    .addComponent(jLabel14)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(carkod)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tcarkod, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel15)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {pcari, tcarkod});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {carkod, jButton2, jButton6, jButton7});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tcarkod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(carkod))
                .addGap(7, 7, 7)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pcari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {pcari, tcarkod});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {carkod, jButton2, jButton6, jButton7});

        jLabel3.setText("Kode Pasien");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/save3.png"))); // NOI18N
        jButton1.setText("Simpan");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/b_edit.png"))); // NOI18N
        jButton8.setText("Edit");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel9))
                                .addGap(39, 39, 39)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pktp, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pkodepas, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pnama, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pgol, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ptglp, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12))
                                .addGap(34, 34, 34)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pper, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(pjkl)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(pjkp))
                                    .addComponent(ppeker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 146, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton3, jButton4, jButton5, jButton8});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pkodepas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(pktp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(pnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(ptglp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pgol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(pjkl)
                            .addComponent(pjkp))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(ppeker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(pper, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton1)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton8))
                .addGap(112, 112, 112))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jButton3, jButton4, jButton5, jButton8});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        home = new HalamanAwal();
        home.show();
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void pjkpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pjkpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pjkpActionPerformed

    private void pgolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pgolActionPerformed
        try {
            Statement statement = (Statement)koneksi1.GetConnection().createStatement();
            ResultSet res = statement.executeQuery("select Golongan_Darah from pasien'"+pgol.getSelectedItem()+"'");
        } 
        catch (Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_pgolActionPerformed

    private void ppekerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ppekerActionPerformed
        try {
            Statement statement = (Statement)koneksi1.GetConnection().createStatement();
            ResultSet res = statement.executeQuery("select Nama_pekerjaan from pekerjaan'"+ppeker.getSelectedItem()+"'");
        } 
        catch (Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_ppekerActionPerformed

    private void pperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pperActionPerformed
        try {
            Statement statement = (Statement)koneksi1.GetConnection().createStatement();
            ResultSet res = statement.executeQuery("select Nama_spe from spesialis'"+pper.getSelectedItem()+"'");
        } 
        catch (Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_pperActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try {
            Statement statement = (Statement)koneksi1.GetConnection().createStatement();
            ResultSet res = statement.executeQuery("select * from pasien where "+ "Nama_Pasien like '"+pcari.getText()+"%'");
            DefaultTableModel tbl = new DefaultTableModel();
            
            tbl.addColumn("Kode Pasien");
            tbl.addColumn("No. KTP");
            tbl.addColumn("Nama");
            tbl.addColumn("Tanggal Lahir");
            tbl.addColumn("Gol. Darah");
            tbl.addColumn("Alamat");
            tbl.addColumn("Jenis Kelamin");
            tbl.addColumn("Pekerjaan");
            tbl.addColumn("Perawatan");

            table1.setModel(tbl);

            while (res.next()) {
                tbl.addRow(new Object[]{
                    res.getString("Kode_pas"),
                    res.getString("No_KTP"),
                    res.getString("Nama_Pasien"),
                    res.getString("Ttl"),
                    res.getString("Golongan_Darah"),
                    res.getString("Alamat"),
                    res.getString("Jk"),
                    res.getString("Pekerjaan"),
                    res.getString("Bagian_Perawatan"),
                });
                table1.setModel(tbl);
            }
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Tidak ada");
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String kodepas = pkodepas.getText();
        try {
            Statement statement = (Statement)koneksi1.GetConnection().createStatement();
            statement.executeUpdate("DELETE from pasien where Kode_pas =('" + kodepas + "');");
            JOptionPane.showMessageDialog(null, "Data Berhasil di Hapus");
            pkodepas.setText("");
            pktp.setText("");
            pnama.setText("");
            pgol.setSelectedItem("");
            palamat.setText("");
            if (pjkl.isSelected()){
                //JOptionPane.showMessageDialog(rootPane, "Laki-laki");
            } else if (pjkp.isSelected()) {
                //JOptionPane.showMessageDialog(rootPane, "Perempuan");
            }
            ppeker.setSelectedItem("");
            pper.setSelectedItem("");
            pktp.requestFocus();
        }
        catch (Exception e ) {
            JOptionPane.showMessageDialog(null, "Data Gagal di Hapus");
        }
        dataTable();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        pkodepas.setText("");
        pktp.setText("");
        pnama.setText("");
        pgol.setSelectedItem("");
        palamat.setText("");
        if (pjkl.isSelected()){
            //JOptionPane.showMessageDialog(rootPane, "Laki-laki");
        } else if (pjkp.isSelected()) {
            //JOptionPane.showMessageDialog(rootPane, "Perempuan");
        }
        ppeker.setSelectedItem("");
        pper.setSelectedItem("");
        tcarkod.setText("");
        pcari.setText("");
        dataTable();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String kodepas = pkodepas.getText();
        String ktp = pktp.getText();
        String nama = pnama.getText();
        String ttl = ptglp.getText();
        String goldar = (String) pgol.getSelectedItem();
        String alamat = palamat.getText();
        String Jk = null;
        if (pjkl.isSelected()) {
            Jk = "Laki-laki";
        } else if (pjkp.isSelected()) {
            Jk = "Perempuan";
        }
        String pekerjaan = (String) ppeker.getSelectedItem();
        String perawatan = (String)pper.getSelectedItem();

        try {
            Statement statement = (Statement)koneksi1.GetConnection().createStatement();
            statement.executeUpdate("insert into pasien VALUES('"+kodepas +"','"+ ktp + "','"+ nama + "','"+ ttl +"','"+ goldar + "','"+ alamat + "','"+
                Jk+"','"+pekerjaan+"','"+perawatan+"');");
            statement.close();
            JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data gagal disimpan");
        }
        dataTable();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void carkodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carkodActionPerformed
        try {
            Statement statement = (Statement)koneksi1.GetConnection().createStatement();
            ResultSet res = statement.executeQuery("select * from pasien where "+ "Kode_pas = '"+tcarkod.getText()+"'");
            DefaultTableModel tbl = new DefaultTableModel();
            
            tbl.addColumn("Kode Pasien");
            tbl.addColumn("No. KTP");
            tbl.addColumn("Nama");
            tbl.addColumn("Tanggal Lahir");
            tbl.addColumn("Gol. Darah");
            tbl.addColumn("Alamat");
            tbl.addColumn("Jenis Kelamin");
            tbl.addColumn("Pekerjaan");
            tbl.addColumn("Perawatan");

            table1.setModel(tbl);

            while (res.next()) {
                tbl.addRow(new Object[]{
                    res.getString("Kode_pas"),
                    res.getString("No_KTP"),
                    res.getString("Nama_Pasien"),
                    res.getString("Ttl"),
                    res.getString("Golongan_Darah"),
                    res.getString("Alamat"),
                    res.getString("Jk"),
                    res.getString("Pekerjaan"),
                    res.getString("Bagian_Perawatan"),
                });
                table1.setModel(tbl);
            }
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Tidak ada");
        }

    }//GEN-LAST:event_carkodActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        koneksi1 con= new koneksi1();
        java.io.File namaFile=new java.io.File("src/report/report_pasien.jasper");
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
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        try {
            String path = "src/report/kartu_pasien.jasper";
            HashMap parameter = new HashMap();
            parameter.put("pas",pkodepas.getText());
            JasperPrint print = JasperFillManager.fillReport(path, parameter, koneksi1.GetConnection());
            JasperViewer.viewReport(print, false);
        } catch(Exception ex) {
            JOptionPane.showInternalMessageDialog(rootPane, "Dokumen Tidak Ada"+ ex);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MouseClicked
        int row = table1.getSelectedRow();
        String gol = table1.getValueAt(row, 4).toString();
        String peker = table1.getValueAt(row, 7).toString();
        String per = table1.getValueAt(row, 8).toString();
        
        pkodepas.setText((String)table1.getValueAt(row, 0));
        pktp.setText((String)table1.getValueAt(row, 1));
        pnama.setText((String)table1.getValueAt(row, 2));
        pgol.setSelectedItem(String.valueOf(gol));
        palamat.setText((String)table1.getValueAt(row, 5));
        ppeker.setSelectedItem(String.valueOf(peker));
        pper.setSelectedItem(String.valueOf(per));
    }//GEN-LAST:event_table1MouseClicked

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        String kd = pkodepas.getText();
        String ktp = pktp.getText();
        String nama = pnama.getText();
        String gol = (String)pgol.getSelectedItem();
        String tgl = ptglp.getText();
        String alamat = palamat.getText();
        String jenisk = null;
        if (pjkl.isSelected()) {
            jenisk = "Laki-laki";
        } else if (pjkp.isSelected()) {
            jenisk = "Perempuan";
        }
        String pekerjaan = (String) ppeker.getSelectedItem();
        String perawatan = (String)pper.getSelectedItem();
        try {
            Statement statement = (Statement) koneksi1.GetConnection().createStatement();
            statement.executeUpdate("UPDATE pasien " + "SET " + "Kode_pas = '" +kd+ "'," + "No_KTP = '" +ktp+ "',"+"Nama_Pasien ='" +nama+"', "+ "Ttl = '" +tgl+"',"+"Golongan_Darah ='"+gol+"', "+ "Alamat ='"+alamat+"', "+ " Jk ='"+jenisk+"', "+ "Pekerjaan ='"+pekerjaan+"', "+ " Bagian_Perawatan ='"+perawatan+"'" + "WHERE " + "Kode_Pas = '" +kd+ "';");
            statement.close();
            JOptionPane.showMessageDialog(null, "Data berhasil rubah");
        } catch(Exception t) {
            JOptionPane.showMessageDialog(null, "Data gagal disimpan");
        }
        dataTable();
    }//GEN-LAST:event_jButton8ActionPerformed

    
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
            java.util.logging.Logger.getLogger(PendaftaranPasien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PendaftaranPasien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PendaftaranPasien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PendaftaranPasien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PendaftaranPasien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton carkod;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea palamat;
    private javax.swing.JTextField pcari;
    private javax.swing.JComboBox<String> pgol;
    private javax.swing.JRadioButton pjkl;
    private javax.swing.JRadioButton pjkp;
    private javax.swing.JTextField pkodepas;
    private javax.swing.JTextField pktp;
    private javax.swing.JTextField pnama;
    private javax.swing.JComboBox<String> ppeker;
    private javax.swing.JComboBox<String> pper;
    private javax.swing.JTextField ptglp;
    private javax.swing.JTable table1;
    private javax.swing.JTextField tcarkod;
    // End of variables declaration//GEN-END:variables
}
