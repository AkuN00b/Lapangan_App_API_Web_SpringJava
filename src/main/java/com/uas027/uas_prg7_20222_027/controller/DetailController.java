package com.uas027.uas_prg7_20222_027.controller;

import com.uas027.uas_prg7_20222_027.model.Detail;
import com.uas027.uas_prg7_20222_027.model.Transaksi;
import com.uas027.uas_prg7_20222_027.service.DetailService;
import com.uas027.uas_prg7_20222_027.service.TransaksiService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class DetailController {
    @Autowired
    DetailService detailService;

    @Autowired
    TransaksiService transaksiService;

    @GetMapping("/saveDetail")
    public void save(HttpServletResponse response,
                     @RequestParam(name = "id") Integer id,
                     @RequestParam(name = "waktu") String waktu,
                     @RequestParam(name = "jam") Integer jam,
                     @RequestParam(name = "subtot") Integer subtot) throws ParseException {

        List<Transaksi> transaksis = transaksiService.getTransaksis();
        Integer id_transaksi = null;
        if (!transaksis.isEmpty()) {
            Transaksi lastTransaksi = transaksis.get(transaksis.size() - 1);
            id_transaksi = lastTransaksi.getId_transaksi();
        }

        transaksiService.updateHarga(id_transaksi, subtot);

        DateFormat sdf = new SimpleDateFormat("HH:mm");
        Date date = sdf.parse(waktu);
        Time time = new Time(date.getTime());

        Detail detail = new Detail(id_transaksi, id, time, jam, subtot);
        detailService.save(detail);
    }

    @GetMapping("/getDetails")
    public List<Detail> getDetails(@RequestParam(name = "id") Integer id) { return detailService.getDetailByTransaksi(id); }
}
