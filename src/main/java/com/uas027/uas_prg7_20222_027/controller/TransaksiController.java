package com.uas027.uas_prg7_20222_027.controller;

import com.uas027.uas_prg7_20222_027.Result;
import com.uas027.uas_prg7_20222_027.model.Detail;
import com.uas027.uas_prg7_20222_027.model.Transaksi;
import com.uas027.uas_prg7_20222_027.service.DetailService;
import com.uas027.uas_prg7_20222_027.service.TransaksiService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class TransaksiController {
    @Autowired
    TransaksiService transaksiService;

    @Autowired
    DetailService detailService;

    @GetMapping("/saveTransaksi")
    public void save(HttpServletResponse response,
                     @RequestParam(name = "namaPenyewa") String namaPenyewa,
                     @RequestParam(name = "tanggalSewa") String tanggalSewa) throws ParseException {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date tanggalSewaDate = format.parse(tanggalSewa);
        Transaksi transaksi = new Transaksi(namaPenyewa, tanggalSewaDate, 0);
        transaksiService.save(transaksi);
    }

    @GetMapping("/getTransaksis")
    public List<Transaksi> getTransaksis() { return transaksiService.getTransaksis(); }

    @GetMapping("/getTransaksiByDate")
    public List<Detail> getTransaksiByDate(@RequestParam(name = "tanggalSewa") String tanggalSewa) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date tanggalSewaDate = format.parse(tanggalSewa);

        List<Transaksi> transaksis = transaksiService.getTransaksis();
        Integer id_transaksi = null;
        if (!transaksis.isEmpty()) {
            Transaksi lastTransaksi = transaksis.get(transaksis.size() - 1);
            id_transaksi = lastTransaksi.getId_transaksi();
        }

        List<Transaksi> transaksisByDate = transaksiService.getTransaksiByDate(tanggalSewaDate, id_transaksi);
        List<Detail> getAllDetailFromTransaksiByDate = new ArrayList<>();

        for (Transaksi transaksi : transaksisByDate) {
            List<Detail> detailsForTransaksi = detailService.getDetailByTransaksi(transaksi.getId_transaksi());
            getAllDetailFromTransaksiByDate.addAll(detailsForTransaksi);
        }

        return getAllDetailFromTransaksiByDate;
    }
}
