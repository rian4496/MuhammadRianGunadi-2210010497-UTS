/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Connected;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HADI PC
 */
public class Connected {
    private static final String DB = "jdbc:mysql://localhost/bukualamat_db";
    
    public static Connection getKoneksi() {
        Connection conn = null; // Deklarasi variabel untuk menyimpan objek koneksi
        MysqlDataSource data = new MysqlDataSource(); // Membuat instance data source MySQL

        data.setUser("root"); // Username untuk login ke database
        data.setPassword(""); // Password untuk login ke database (kosong dalam kasus ini)
        data.setURL(DB); // URL database yang akan dihubungkan

        try {
            // Mencoba membuat koneksi ke database
            conn = data.getConnection();
        } catch (SQLException ex) {
            // Menangkap exception jika terjadi kesalahan koneksi
            Logger.getLogger(Connected.class.getName()).log(Level.SEVERE, null, ex);
            // Mencatat pesan kesalahan di log dengan level SEVERE
        }

        // Mengembalikan objek koneksi (null jika gagal)
        return conn;
    }
 
}
