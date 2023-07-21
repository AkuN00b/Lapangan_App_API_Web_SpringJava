package com.uas027.uas_prg7_20222_027.service;

import com.uas027.uas_prg7_20222_027.model.Lapangan;
import com.uas027.uas_prg7_20222_027.model.Transaksi;
import com.uas027.uas_prg7_20222_027.repository.TransaksiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransaksiService {
    @Autowired
    TransaksiRepository transaksiRepository;

    public boolean save(Transaksi transaksi) {
        Transaksi result = transaksiRepository.save(transaksi);
        boolean isSuccess = true;

        if (result == null) {
            isSuccess = false;
        }

        return isSuccess;
    }

    public List<Transaksi> getTransaksis() {
        return transaksiRepository.findAll();
    }

    public void updateHarga(Integer id, Integer sub) {
        List<Transaksi> allTransaksiList = transaksiRepository.findAll();

        for (Transaksi transaksi : allTransaksiList) {
            if (transaksi.getId_transaksi().equals(id)) {
                Integer total = transaksi.getTotal() + sub;
                transaksi.setTotal(total);
                transaksiRepository.save(transaksi);
            }
        }
    }

    public List<Transaksi> getTransaksiByDate(Date tanggal, Integer id_transaksi) {
        return transaksiRepository.getTransaksiByDate(tanggal, id_transaksi);
    }
}
