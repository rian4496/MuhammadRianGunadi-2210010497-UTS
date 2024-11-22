/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Settings;

import Connected.Connected;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author HADI PC
 */
public class tambahData {
      // Membuat koneksi ke database menggunakan metode `getKoneksi` dari kelas `Koneksi`
    Connection conn = Connected.getKoneksi();
    // Deklarasi variabel untuk menyimpan pernyataan SQL yang akan dijalankan
    PreparedStatement pst;

    // Metode untuk menambahkan data ke dalam tabel `recipes`
    public String addData(String nama,String relasi, String telpon, String alamat, String kota) throws SQLException {
        String queryTambah = "INSERT INTO buku_alamat VALUES (null, ?, ?, ?, ?,?);";
        // Menyiapkan pernyataan SQL untuk diisi dengan data
        pst = conn.prepareStatement(queryTambah);
        // Mengisi parameter query dengan data yang diterima
        pst.setString(1, nama); 
        pst.setString(2, relasi);   
        pst.setString(3, telpon);    
        pst.setString(4, alamat);    
        pst.setString(5, kota);     

        // Menjalankan pernyataan SQL untuk menambahkan data ke database
        int result = pst.executeUpdate(); // Mengembalikan jumlah baris yang dimodifikasi
        if (result > 0) { // Mengecek apakah ada data yang berhasil ditambahkan
                JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan", "Sukses", JOptionPane.INFORMATION_MESSAGE);
            return "{ \"status\": 200, \"message\": \"Sukses Tambah Data\" }";
        } else {
            // Jika data gagal ditambahkan, mengembalikan pesan gagal dalam format JSON
            return "{ \"status\": 500, \"message\": \"Gagal Tambah Data\" }";
        }
    }
}
