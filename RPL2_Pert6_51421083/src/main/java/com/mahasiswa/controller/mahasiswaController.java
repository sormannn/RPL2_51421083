package com.mahasiswa.controller;

import com.mahasiswa.model.modelMahasiswa;
import com.mahasiswa.service.mahasiswaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

@Controller
public class mahasiswaController {
    @Autowired
    private mahasiswaService mahasiswaService;

    public String addMahasiswa(@RequestBody modelMahasiswa mhs) {
        mahasiswaService.addMhs(mhs);
        return "Mahasiswa Added Successfully";
    }

    public modelMahasiswa getMahasiswa(@PathVariable int id) {
        return mahasiswaService.getMhs(id);
    }

    public String updateMahasiswa(@RequestBody modelMahasiswa mhs) {
        mahasiswaService.updateMhs(mhs);
        return "Mahasiswa Updated Successfully";
    }

    public String deleteMahasiswa(@PathVariable int id) {
        mahasiswaService.deleteMhs(id);
        return "Mahasiswa Deleted Successfully";
    }

    public List<modelMahasiswa> getAllMahasiswa() {
        return mahasiswaService.getAllMahasiswa();
    }
}