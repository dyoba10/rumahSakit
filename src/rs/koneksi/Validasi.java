/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.koneksi;

import javax.swing.table.DefaultTableModel;

public class Validasi {
    public void autoNomer(DefaultTableModel tbl, String strAwal, Integer pnj, javax.swing.JTextField teks) {
    
        String s, s1;
        Integer j;
        s = Integer.toString(tbl.getRowCount()+1);
        j = s.length();
        s1 = "";
        for(int i = 1; i<pnj-j;i++) {
            s1 = s1 + "0";
        }
        teks.setText(strAwal+s1+s);
    }
}
