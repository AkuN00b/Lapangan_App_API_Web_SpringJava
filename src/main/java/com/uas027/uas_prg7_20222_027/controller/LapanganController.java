package com.uas027.uas_prg7_20222_027.controller;

import com.uas027.uas_prg7_20222_027.model.Lapangan;
import com.uas027.uas_prg7_20222_027.service.LapanganService;
import com.uas027.uas_prg7_20222_027.service.TransaksiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class LapanganController {
    @Autowired
    LapanganService lapanganService;

    @GetMapping("/getLapanganAktif")
    public List<Lapangan> getLapanganAktif() {
        List<Lapangan> lapangans = lapanganService.getLapangans();

        List<Lapangan> activeLapangans = lapangans.stream()
                .filter(lapangan -> lapangan.getStatus().equals(1))
                .collect(Collectors.toList());

        return activeLapangans;
    }

    @GetMapping("/getLapangan")
    public Lapangan getLapangan(@RequestParam(name = "id") Integer id) {
        return lapanganService.getLapangan(id);
    }
}
