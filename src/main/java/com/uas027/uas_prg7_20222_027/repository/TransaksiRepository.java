package com.uas027.uas_prg7_20222_027.repository;

import com.uas027.uas_prg7_20222_027.model.Transaksi;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface TransaksiRepository extends CrudRepository<Transaksi, Integer> {
    @Query(value = "SELECT * FROM transaksi WHERE tanggal_transaksi = ?1 AND id_transaksi != ?2", nativeQuery = true)
    List<Transaksi> getTransaksiByDate(Date tanggal, Integer id_transaksi);

    List<Transaksi> findAll();
}
