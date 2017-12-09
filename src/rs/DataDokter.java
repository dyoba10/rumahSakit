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
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

//import net.sf.jasperreports.engine.*;
//import net.sf.jasperreports.engine.JasperCompileManager;
//import net.sf.jasperreports.engine.JasperFillManager;
//import net.sf.jasperreports.engine.JasperPrint;
//import net.sf.jasperreports.engine.JasperReport;
//import net.sf.jasperreports.engine.design.JRDesignQuery;
//import net.sf.jasperreports.engine.design.JasperDesign;
//import net.sf.jasperreports.engine.xml.JRXmlLoader;
//import net.sf.jasperreports.view.JasperViewer;
//import net.sf.jasperreports.engine.xml.JRXmlDigesterFactory;


public class DataDokter extends javax.swing.JFrame {

    Connection cn = null;
    ResultSet res = null;
    public MenuDokter back;
    public HalamanAwal home;
    
    koneksi1 konek = new koneksi1();
    //JasperReport jasperReport;
    //JasperDesign jasperDesign;
    //JasperPrint jasperPrint;
    Map<String, Object> param = new HashMap<String, Object>();
    private DefaultTableModel model;
    
    public DataDokter() {
        initComponents();
        dataTable();
        setLocationRelativeTo(null);
        comboKode();
    }
    

    public void dataTable() {
        DefaultTableModel tbl = new DefaultTableModel();
        Validasi valid = new Validasi();
        
        tbl.addColumn("Kode Dokter");
        tbl.addColumn("Nama");
        tbl.addColumn("Tanggal Lahir");
        tbl.addColumn("Jenis Kelamin");
        tbl.addColumn("Alamat");
        tbl.addColumn("Spesialis");
        tbl.addColumn("Status");
        tbl.addColumn("No. Izin Kerja");

        table2.setModel(tbl);
        try {
            Statement statement = (Statement)koneksi1.GetConnection().createStatement();
            ResultSet res = statement.executeQuery("select * from dokter");
            while (res.next()) {
                tbl.addRow(new Object[]{
                    res.getString("Kode_Dokter"),
                    res.getString("Nama_Dokter"),
                    res.getString("Tgl_lahir"),
                    res.getString("Jk"),
                    res.getString("Alamat"),
                    res.getString("Spesialis"),
                    res.getString("Status"),
                    res.getString("No_izinK")
                });
                table2.setModel(tbl);
            }
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "salah");
        }
        valid.autoNomer(tbl, "DR",4,pkode);
    }
    
    public void comboKode() {
        try {
            Statement statement = (Statement)koneksi1.GetConnection().createStatement();
            ResultSet res = statement.executeQuery("select * from spesialis");
            while (res.next()) {
                psped.addItem(res.getString("Nama_spe"));
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        pkode = new javax.swing.JTextField();
        pnamad = new javax.swing.JTextField();
        pjkld = new javax.swing.JRadioButton();
        pjkpd = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        palamatd = new javax.swing.JTextArea();
        psped = new javax.swing.JComboBox<>();
        pstad = new javax.swing.JComboBox<>();
        pnod = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        table2 = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        pcarid = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        carkoddokter = new javax.swing.JButton();
        tcarkodedok = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        cetakdokter = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        ptgld = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        jLabel1.setText("Kode Dokter");

        jLabel2.setText("Nama ");

        jLabel3.setText("Tanggal Lahir");

        jLabel4.setText("Jenis Kelamin");

        jLabel6.setText("Alamat");

        jLabel7.setText("Spesialis");

        jLabel8.setText("Status");

        jLabel9.setText("No. Izin Kerja");

        pjkld.setBackground(new java.awt.Color(0, 204, 204));
        buttonGroup1.add(pjkld);
        pjkld.setText("Laki-laki");

        pjkpd.setBackground(new java.awt.Color(0, 204, 204));
        buttonGroup1.add(pjkpd);
        pjkpd.setText("Perempuan");

        palamatd.setColumns(20);
        palamatd.setRows(5);
        jScrollPane1.setViewportView(palamatd);

        psped.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        psped.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pspedActionPerformed(evt);
            }
        });

        pstad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "DOKTER TETAP", "BUKAN DOKTER TETAP" }));
        pstad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pstadActionPerformed(evt);
            }
        });

        table2.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Kode Dokter", "Nama", "Tanggal Lahir", "Jenis Kelamin", "Alamat", "Spesialis", "Status", "No. Izin Kerja"
            }
        ));
        table2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table2);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/kembali_1.png"))); // NOI18N
        jButton5.setText("Kembali");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        jLabel10.setText("RUMAH SAKIT MEDICA");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Jl. Desa Cipadung no. 66 Kota Bandung");

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/iconsearch.png"))); // NOI18N
        jButton6.setText("Cari");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        pcarid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pcaridActionPerformed(evt);
            }
        });

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Berdasarkan Nama");

        carkoddokter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/iconsearch.png"))); // NOI18N
        carkoddokter.setText("Cari");
        carkoddokter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carkoddokterActionPerformed(evt);
            }
        });

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Berdasarkan Kode");

        cetakdokter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/printer.png"))); // NOI18N
        cetakdokter.setText("Print");
        cetakdokter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cetakdokterActionPerformed(evt);
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
                        .addComponent(carkoddokter)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tcarkodedok, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pcarid))
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(cetakdokter))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {pcarid, tcarkodedok});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {carkoddokter, cetakdokter, jButton6});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cetakdokter)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(carkoddokter)
                    .addComponent(tcarkodedok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(pcarid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {pcarid, tcarkodedok});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {carkoddokter, cetakdokter, jButton6});

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/refresh.png"))); // NOI18N
        jButton2.setText("Refresh");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/b_edit.png"))); // NOI18N
        jButton4.setText("Edit");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/save3.png"))); // NOI18N
        jButton1.setText("Simpan");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(pkode, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(pjkld)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(pjkpd))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                                        .addComponent(pnamad))
                                    .addComponent(psped, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pstad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pnod, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(ptgld, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2, jButton3, jButton4});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(pkode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(pnamad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(ptgld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(pjkld)
                    .addComponent(pjkpd))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(75, 75, 75))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(psped, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(pstad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(pnod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton5)
                        .addComponent(jButton2)
                        .addComponent(jButton1)
                        .addComponent(jButton3)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jButton2, jButton3});

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String kd = pkode.getText();
        String nama = pnamad.getText();
        String tgl = ptgld.getText();
        String jenisk = null;
        if (pjkld.isSelected()) {
            jenisk = "Laki-laki";
        } else if (pjkpd.isSelected()) {
            jenisk = "Perempuan";
        }
        String alamat = palamatd.getText();
        String spesialis = (String) psped.getSelectedItem();
        String status = (String)pstad.getSelectedItem();
        String noizink = pnod.getText();
        
        try {
            Statement statement = (Statement)koneksi1.GetConnection().createStatement();
            statement.executeUpdate("insert into dokter VALUES('"+ kd + "','"+ nama + "','"+ tgl +"','"+ jenisk+ "','"+
                    alamat+"','"+spesialis+"','"+status+"','"+noizink+"');");
            statement.close();
            JOptionPane.showMessageDialog(null, "data berhasil disimpan");
        }
        catch (Exception t) {
            JOptionPane.showMessageDialog(null, "data gagal disimpan");
        }
        dataTable();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       
       pkode.setText("");
       pnamad.setText("");
       if (pjkld.isSelected()){
           //JOptionPane.showMessageDialog(rootPane, "Laki-laki");
       } else if (pjkpd.isSelected()) {
           //JOptionPane.showMessageDialog(rootPane, "Perempuan");
       }
       palamatd.setText("");
       psped.setSelectedItem("");
       pstad.setSelectedItem("");
       pnod.setText("");
       tcarkodedok.setText("");
       pcarid.setText("");
       dataTable();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       String ktd = pkode.getText();
        try {
            Statement statement = (Statement)koneksi1.GetConnection().createStatement();
            statement.executeUpdate("DELETE from dokter where Kode_Dokter =('" + ktd + "');");
            JOptionPane.showMessageDialog(null, "Data Berhasil di Hapus");
            pkode.setText("");
            pnamad.setText("");
            if (pjkld.isSelected()){
                //JOptionPane.showMessageDialog(rootPane, "Laki-laki");
            } else if (pjkpd.isSelected()) {
                //JOptionPane.showMessageDialog(rootPane, "Perempuan");
            }
            palamatd.setText("");
            psped.setSelectedItem("");
            pstad.setSelectedItem("");
            pnod.setText("");
             }
        catch (Exception t ) {
            JOptionPane.showMessageDialog(null, "Data Gagal di Hapus");
        }
        dataTable();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        back = new MenuDokter();
        back.show();
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try {
            Statement statement = (Statement)koneksi1.GetConnection().createStatement();
            ResultSet res = statement.executeQuery("select * from dokter where "+ "Nama_Dokter like '"+pcarid.getText()+"%'");
            DefaultTableModel tbl = new DefaultTableModel();
        
            tbl.addColumn("Kode Dokter");
            tbl.addColumn("Nama");
            tbl.addColumn("Tanggal Lahir");
            tbl.addColumn("Jenis Kelamin");
            tbl.addColumn("Alamat");
            tbl.addColumn("Spesialis");
            tbl.addColumn("Status");
            tbl.addColumn("No. Izin Kerja");

            table2.setModel(tbl);

            while (res.next()) {
                tbl.addRow(new Object[]{
                    res.getString("Kode_Dokter"),
                    res.getString("Nama_Dokter"),
                    res.getString("Tgl_lahir"),
                    res.getString("Jk"),
                    res.getString("Alamat"),
                    res.getString("Spesialis"),
                    res.getString("Status"),
                    res.getString("No_IzinK")
                });
                table2.setModel(tbl);
            }
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Tidak ada");
        } 
    }//GEN-LAST:event_jButton6ActionPerformed

    private void pcaridActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pcaridActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pcaridActionPerformed

    private void pspedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pspedActionPerformed
        try {
            Statement statement = (Statement)koneksi1.GetConnection().createStatement();
            ResultSet res = statement.executeQuery("select Nama_spe from spesialis'"+psped.getSelectedItem()+"'");
        } 
        catch (Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_pspedActionPerformed

    private void pstadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pstadActionPerformed
        try {
            Statement statement = (Statement)koneksi1.GetConnection().createStatement();
            ResultSet res = statement.executeQuery("select Status from dokter'"+pstad.getSelectedItem()+"'");
        } 
        catch (Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_pstadActionPerformed

    private void cetakdokterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cetakdokterActionPerformed
        koneksi1 con= new koneksi1();
        java.io.File namaFile=new java.io.File("src/report/report_dokter.jasper");
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
    }//GEN-LAST:event_cetakdokterActionPerformed

    private void carkoddokterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carkoddokterActionPerformed
        try {
            Statement statement = (Statement)koneksi1.GetConnection().createStatement();
            ResultSet res = statement.executeQuery("select * from dokter where "+ "Kode_Dokter ='"+tcarkodedok.getText()+"'");
            DefaultTableModel tbl = new DefaultTableModel();
        
            tbl.addColumn("Kode Dokter");
            tbl.addColumn("Nama");
            tbl.addColumn("Tanggal lahir");
            tbl.addColumn("Jenis Kelamin");
            tbl.addColumn("Alamat");
            tbl.addColumn("Spesialis");
            tbl.addColumn("Status");
            tbl.addColumn("No. Izin Kerja");

            table2.setModel(tbl);

            while (res.next()) {
                tbl.addRow(new Object[]{
                    res.getString("Kode_Dokter"),
                    res.getString("Nama_Dokter"),
                    res.getString("Tgl_lahir"),
                    res.getString("Jk"),
                    res.getString("Alamat"),
                    res.getString("Spesialis"),
                    res.getString("Status"),
                    res.getString("No_izinK")
                });
                table2.setModel(tbl);
            }
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Tidak ada");
        }
    }//GEN-LAST:event_carkoddokterActionPerformed

    private void table2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table2MouseClicked
        int row = table2.getSelectedRow();
        
        String spesialis = table2.getValueAt(row, 5).toString();
        String stat = table2.getValueAt(row, 6).toString();
        
        pkode.setText((String)table2.getValueAt(row, 0));
        pnamad.setText((String)table2.getValueAt(row, 1));
        palamatd.setText((String)table2.getValueAt(row, 4));
        psped.setSelectedItem(String.valueOf(spesialis));
        pstad.setSelectedItem(String.valueOf(stat));
        pnod.setText((String)table2.getValueAt(row, 7));
        //ptgld.setText((String)table2.getValueAt(row, 2));
        //jTextField4.setText((String)jTable1.getValueAt(row, 3)); 
    }//GEN-LAST:event_table2MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String kd = pkode.getText();
        String nama = pnamad.getText();
        String tgl = ptgld.getText();
        String jenisk = null;
        if (pjkld.isSelected()) {
            jenisk = "Laki-laki";
        } else if (pjkpd.isSelected()) {
            jenisk = "Perempuan";
        }
        String alamat = palamatd.getText();
        String spesialis = (String) psped.getSelectedItem();
        String status = (String)pstad.getSelectedItem();
        String noizink = pnod.getText();
        try {
            Statement statement = (Statement) koneksi1.GetConnection().createStatement();
            statement.executeUpdate("UPDATE dokter " + "SET " + "Kode_Dokter = '" +kd+ "'," + "Nama_Dokter = '" +nama+ "'," + "Tgl_lahir = '" +tgl+"',"+"Jk ='"+jenisk+"', "+ "Alamat ='"+alamat+"', "+ " Spesialis ='"+spesialis+"', "+ "Status='"+status+"', "+ " No_IzinK ='"+noizink+"'" + "WHERE " + "Kode_Dokter = '" +kd+ "';");
            statement.close();
            JOptionPane.showMessageDialog(null, "Data berhasil rubah");
        } catch(Exception t) {
            JOptionPane.showMessageDialog(null, "Data gagal disimpan");
        }
        dataTable();
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(DataDokter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataDokter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataDokter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataDokter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataDokter().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton carkoddokter;
    private javax.swing.JButton cetakdokter;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea palamatd;
    private javax.swing.JTextField pcarid;
    private javax.swing.JRadioButton pjkld;
    private javax.swing.JRadioButton pjkpd;
    private javax.swing.JTextField pkode;
    private javax.swing.JTextField pnamad;
    private javax.swing.JTextField pnod;
    private javax.swing.JComboBox<String> psped;
    private javax.swing.JComboBox<String> pstad;
    private javax.swing.JTextField ptgld;
    private javax.swing.JTable table2;
    private javax.swing.JTextField tcarkodedok;
    // End of variables declaration//GEN-END:variables
}
