package com.uas027.uas_prg7_20222_027.service;

import com.uas027.uas_prg7_20222_027.model.Detail;
import com.uas027.uas_prg7_20222_027.model.Transaksi;
import com.uas027.uas_prg7_20222_027.repository.DetailRepository;
import com.uas027.uas_prg7_20222_027.repository.TransaksiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DetailService {
    @Autowired
    DetailRepository detailRepository;

    public boolean save(Detail detail) {
        Detail result = detailRepository.save(detail);
        boolean isSuccess = true;

        if (result == null) {
            isSuccess = false;
        }

        return isSuccess;
    }

    public List<Detail> getDetailByTransaksi(Integer id) {
        List<Detail> details = detailRepository.findAll();

        List<Detail> detailsById = details.stream()
                .filter(detail -> detail.getId_transaksi().equals(id))
                .collect(Collectors.toList());

        return detailsById;
    }
}
