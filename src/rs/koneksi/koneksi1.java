/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.koneksi;

import java.sql.*;
import com.mysql.jdbc.Driver;
import java.sql.DriverManager;

public class koneksi1 {
    private static Connection koneksi;
    
    public static Connection GetConnection() throws SQLException {
        if (koneksi==null) {
            Driver driver = new Driver();
           
            koneksi = DriverManager.getConnection("jdbc:mysql://localhost:3306/rumah_sakit", "root", "");
        }
        return koneksi;
    }

    public static Object getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

