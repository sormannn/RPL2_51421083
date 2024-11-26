package com.mahasiswa.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MahasiswaDAO {
    private Connection connection;

    public MahasiswaDAO() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mvc_db", "root", "");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean cekKoneksi() {
        try {
            return connection != null && !connection.isClosed();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void addMahasiswa(ModelMahasiswa mahasiswa) {
        String sql = "INSERT INTO mahasiswa (npm, nama, semester, ipk, umur, jurusan) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstat = connection.prepareStatement(sql)) {
            pstat.setString(1, mahasiswa.getNpm());
            pstat.setString(2, mahasiswa.getNama());
            pstat.setInt(3, mahasiswa.getSemester());
            pstat.setFloat(4, mahasiswa.getIpk());
            pstat.setInt(5, mahasiswa.getUmur());  // assuming 'umur' is a property of ModelMahasiswa
            pstat.setString(6, mahasiswa.getJurusan()); // assuming 'jurusan' is a property of ModelMahasiswa

            pstat.executeUpdate();
            System.out.println("Mahasiswa " + mahasiswa.getNama() + " berhasil ditambahkan.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<ModelMahasiswa> getAllMahasiswa() {
        List<ModelMahasiswa> mahasiswaList = new ArrayList<>();
        String sql = "SELECT * FROM mahasiswa";
        try (Statement stat = connection.createStatement(); ResultSet rs = stat.executeQuery(sql)) {
            while (rs.next()) {
                mahasiswaList.add(new ModelMahasiswa(
                    rs.getInt("id"),
                    rs.getString("npm"),
                    rs.getString("nama"),
                    rs.getInt("semester"),
                    rs.getFloat("ipk"),
                    rs.getInt("umur"), // ensure to retrieve 'umur' if present in the database
                    rs.getString("jurusan") // ensure to retrieve 'jurusan' if present in the database
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mahasiswaList;
    }

    public void updateMahasiswa(ModelMahasiswa mahasiswa) {
        String sql = "UPDATE mahasiswa SET npm = ?, nama = ?, semester = ?, ipk = ?, umur = ?, jurusan = ? WHERE id = ?";
        try (PreparedStatement pstat = connection.prepareStatement(sql)) {
            pstat.setString(1, mahasiswa.getNpm());
            pstat.setString(2, mahasiswa.getNama());
            pstat.setInt(3, mahasiswa.getSemester());
            pstat.setFloat(4, mahasiswa.getIpk());
            pstat.setInt(5, mahasiswa.getUmur());
            pstat.setString(6, mahasiswa.getJurusan());
            pstat.setInt(7, mahasiswa.getId());
            pstat.executeUpdate();
            System.out.println("Mahasiswa " + mahasiswa.getNama() + " berhasil diperbarui.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteMahasiswa(int id) {
        String sql = "DELETE FROM mahasiswa WHERE id = ?";
        try (PreparedStatement pstat = connection.prepareStatement(sql)) {
            pstat.setInt(1, id);
            pstat.executeUpdate();
            System.out.println("Mahasiswa dengan ID " + id + " berhasil dihapus.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
