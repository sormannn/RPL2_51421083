package com.mahasiswa.service;

import com.mahasiswa.model.modelMahasiswa;
import com.mahasiswa.repository.mahasiswaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class mahasiswaService {

    @Autowired
    private mahasiswaRepository repository;

    public void addMhs(modelMahasiswa mhs) {
        repository.save(mhs);
    }

    public modelMahasiswa getMhs(int id) {
        return repository.findById(id).orElse(null);
    }

    public void updateMhs(modelMahasiswa mhs) {
        repository.save(mhs);
    }

    public void deleteMhs(int id) {
        repository.deleteById(id);
    }

    public List<modelMahasiswa> getAllMahasiswa() {
        return repository.findAll();
    }
}