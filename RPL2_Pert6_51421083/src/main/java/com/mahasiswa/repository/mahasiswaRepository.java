package com.mahasiswa.repository;

import com.mahasiswa.model.modelMahasiswa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface mahasiswaRepository extends JpaRepository<modelMahasiswa, Integer> {
    
}