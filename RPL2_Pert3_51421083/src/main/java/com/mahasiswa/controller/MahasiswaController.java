package com.mahasiswa.controller;

import com.mahasiswa.model.MahasiswaDAO;
import com.mahasiswa.model.ModelMahasiswa;

import java.util.List;

public class MahasiswaController {
    private final MahasiswaDAO mahasiswaDAO;

    public MahasiswaController(MahasiswaDAO mahasiswaDAO) {
        this.mahasiswaDAO = mahasiswaDAO;
    }

    public void checkDatabaseConnection() {
        if (mahasiswaDAO.cekKoneksi()) {
            displayMessage("Koneksi ke DB berhasil!");
        } else {
            displayMessage("Koneksi DB gagal!");
        }
    }

    public void displayAllMahasiswa() {
        List<ModelMahasiswa> mahasiswaList = mahasiswaDAO.getAllMahasiswa();
        displayMahasiswaList(mahasiswaList);
    }

    public void addMahasiswa(String npm, String nama, int semester, float ipk, int umur, String jurusan) {
        ModelMahasiswa mahasiswaBaru = new ModelMahasiswa(0, npm, nama, semester, ipk, umur, jurusan);
        try {
            mahasiswaDAO.addMahasiswa(mahasiswaBaru);
            displayMessage("Mahasiswa " + nama + " berhasil ditambahkan!");
        } catch (Exception e) {
            displayMessage("Gagal menambahkan mahasiswa: " + e.getMessage());
        }
    }

    public void updateMahasiswa(int id, String npm, String nama, int semester, float ipk, int umur, String jurusan) {
        ModelMahasiswa mahasiswaBaru = new ModelMahasiswa(id, npm, nama, semester, ipk, umur, jurusan);
        try {
            mahasiswaDAO.updateMahasiswa(mahasiswaBaru);
            displayMessage("Mahasiswa " + nama + " berhasil diperbarui!");
        } catch (Exception e) {
            displayMessage("Gagal memperbarui mahasiswa: " + e.getMessage());
        }
    }

    public void deleteMahasiswa(int id) {
        try {
            mahasiswaDAO.deleteMahasiswa(id);
            displayMessage("Mahasiswa dengan ID " + id + " berhasil dihapus!");
        } catch (Exception e) {
            displayMessage("Gagal menghapus mahasiswa: " + e.getMessage());
        }
    }

    public void closeConnection() {
        mahasiswaDAO.closeConnection();
        displayMessage("Koneksi database berhasil ditutup.");
    }

    public void displayMahasiswaList(List<ModelMahasiswa> mahasiswaList) {
        if (mahasiswaList.isEmpty()) {
            displayMessage("Tidak ada data mahasiswa!");
        } else {
            System.out.println("==============================");
            System.out.printf("%-5s %-15s %-25s %-10s %-10s %-10s %-20s\n", "ID", "NPM", "Nama", "Umur", "Semester", "IPK", "Jurusan");
            System.out.println("==============================");
            for (ModelMahasiswa m : mahasiswaList) {
                System.out.printf("%-5d %-15s %-25s %-10d %-10d %-10.2f %-20s\n", 
                    m.getId(), m.getNpm(), m.getNama(), m.getUmur(), m.getSemester(), m.getIpk(), m.getJurusan());
            }
            System.out.println("==============================");
            displayMessage("Mahasiswa berhasil ditampilkan.");
        }
    }

    private void displayMessage(String message) {
        System.out.println(message);
    }
}
