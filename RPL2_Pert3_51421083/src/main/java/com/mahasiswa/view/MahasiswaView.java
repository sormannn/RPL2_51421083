package com.mahasiswa.view;

import com.mahasiswa.controller.MahasiswaController;
import com.mahasiswa.model.MahasiswaDAO;
import java.util.Scanner;

public class MahasiswaView {
    public static void main(String[] args) {
        MahasiswaDAO mahasiswaDAO = new MahasiswaDAO();
        MahasiswaController mahasiswaController = new MahasiswaController(mahasiswaDAO);

        Scanner scanner = new Scanner(System.in);
        int pilihan;

        while (true) {
            System.out.println("Menu :");
            System.out.println("1. Tampilkan Semua Mahasiswa");
            System.out.println("2. Tambah Mahasiswa");
            System.out.println("3. Update Mahasiswa");
            System.out.println("4. Hapus Mahasiswa");
            System.out.println("5. Cek Koneksi Database");
            System.out.println("6. Keluar");
            System.out.print("PILIH OPSI: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (pilihan) {
                case 1:
                    mahasiswaController.displayAllMahasiswa();
                    break;
                case 2:
                    System.out.print("Masukan NPM: ");
                    String npm = scanner.nextLine(); // Use nextLine for names with spaces
                    System.out.print("Masukan Nama: ");
                    String nama = scanner.nextLine(); // Use nextLine for names with spaces
                    System.out.print("Masukan Semester: ");
                    int semester = scanner.nextInt();
                    System.out.print("Masukan IPK: ");
                    float ipk = scanner.nextFloat();
                    System.out.print("Masukan Umur: ");
                    int umur = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline
                    System.out.print("Masukan Jurusan: ");
                    String jurusan = scanner.nextLine(); // Use nextLine for names with spaces
                    mahasiswaController.addMahasiswa(npm, nama, semester, ipk, umur, jurusan);
                    break;
                case 3:
                    System.out.print("Masukan ID Mahasiswa yang akan di-update: ");
                    int idUpdate = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline
                    System.out.print("Masukan NPM: ");
                    String npmUpdate = scanner.nextLine(); // Use nextLine for names with spaces
                    System.out.print("Masukan Nama: ");
                    String namaUpdate = scanner.nextLine(); // Use nextLine for names with spaces
                    System.out.print("Masukan Semester: ");
                    int semesterUpdate = scanner.nextInt();
                    System.out.print("Masukan IPK: ");
                    float ipkUpdate = scanner.nextFloat();
                    System.out.print("Masukan Umur: ");
                    int umurUpdate = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline
                    System.out.print("Masukan Jurusan: ");
                    String jurusanUpdate = scanner.nextLine(); // Use nextLine for names with spaces
                    mahasiswaController.updateMahasiswa(idUpdate, npmUpdate, namaUpdate, semesterUpdate, ipkUpdate, umurUpdate, jurusanUpdate);
                    break;
                case 4:
                    System.out.print("Masukan ID Mahasiswa yang akan dihapus: ");
                    int idDelete = scanner.nextInt();
                    mahasiswaController.deleteMahasiswa(idDelete);
                    break;
                case 5:
                    mahasiswaController.checkDatabaseConnection();
                    break;
                case 6:
                    System.out.println("Keluar dari program...");
                    mahasiswaController.closeConnection();
                    scanner.close();
                    return;
                default:
                    System.out.println("Opsi tidak valid!");
            }
        }
    }
}
