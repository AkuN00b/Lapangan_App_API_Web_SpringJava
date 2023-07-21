package com.uas027.uas_prg7_20222_027.service;

import com.uas027.uas_prg7_20222_027.model.Lapangan;
import com.uas027.uas_prg7_20222_027.repository.LapanganRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LapanganService {
    @Autowired
    LapanganRepository lapanganRepository;

    public boolean save(Lapangan lapangan) {
        lapangan.setStatus(1);
        Lapangan result = lapanganRepository.save(lapangan);
        boolean isSuccess = true;

        if (result == null) {
            isSuccess = false;
        }

        return isSuccess;
    }

    public Lapangan getLapangan(Integer idLapangan) {
        List<Lapangan> allLapanganList = lapanganRepository.findAll();

        for (Lapangan lapangan : allLapanganList) {
            if (lapangan.getId_lapangan().equals(idLapangan)) {
                return lapangan;
            }
        }

        return null;
    }

    public List<Lapangan> getLapangans() {
        return lapanganRepository.findAll();
    }

    public boolean update(Lapangan lapangan) {
        Lapangan result = lapanganRepository.save(lapangan);
        boolean isSuccess = true;

        if (result == null) {
            isSuccess = false;
        }

        return isSuccess;
    }

    public void deleteLapangan(Integer idLapangan) {
        List<Lapangan> allLapanganList = lapanganRepository.findAll();

        for (Lapangan lapangan : allLapanganList) {
            if (lapangan.getId_lapangan().equals(idLapangan)) {
                lapangan.setStatus(0);
                lapanganRepository.save(lapangan);
            }
        }
    }
}
