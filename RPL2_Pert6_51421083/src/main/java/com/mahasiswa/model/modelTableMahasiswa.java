package com.mahasiswa.model;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class modelTableMahasiswa extends AbstractTableModel {

    private List<modelMahasiswa> mahasiswalist;
    private String[] columnNames = {"ID", "NPM", "Nama", "Semester", "IPK"};

    public modelTableMahasiswa(List<modelMahasiswa> mahasiswalist) {
        this.mahasiswalist = mahasiswalist;
    }

    @Override
    public int getRowCount() {
        return mahasiswalist.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        modelMahasiswa mahasiswa = mahasiswalist.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return mahasiswa.getId();
            case 1:
                return mahasiswa.getNpm();
            case 2:
                return mahasiswa.getNama();
            case 3:
                return mahasiswa.getSemester();
            case 4:
                return mahasiswa.getIpk();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int column) {
        // Mengembalikan judul kolom berdasarkan indeks
        return columnNames[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        // Semua sel tidak dapat diedit
        return false;
    }

    public void setMahasiswalist(List<modelMahasiswa> mahasiswalist) {
        // Memperbarui daftar mahasiswa dan memberitahu tabel
        this.mahasiswalist = mahasiswalist;
        fireTableDataChanged();
    }
}