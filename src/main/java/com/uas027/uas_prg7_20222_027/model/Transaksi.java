package com.uas027.uas_prg7_20222_027.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Transaksi")
public class Transaksi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transaksi")
    private Integer id_transaksi;

    @Column(name = "nama_penyewa")
    private String nama_penyewa;

    @Column(name = "tanggal_transaksi")
    private Date tanggal_transaksi;

    @Column(name = "total")
    private Integer total;

    public Transaksi() {

    }

    public Transaksi(Integer id_transaksi, String nama_penyewa, Date tanggal_transaksi, Integer total) {
        this.id_transaksi = id_transaksi;
        this.nama_penyewa = nama_penyewa;
        this.tanggal_transaksi = tanggal_transaksi;
        this.total = total;
    }
    public Transaksi(String nama_penyewa, Date tanggal_transaksi, Integer total) {
        this.nama_penyewa = nama_penyewa;
        this.tanggal_transaksi = tanggal_transaksi;
        this.total = total;
    }

    public Integer getId_transaksi() {
        return id_transaksi;
    }

    public void setId_transaksi(Integer id_transaksi) {
        this.id_transaksi = id_transaksi;
    }

    public String getNama_penyewa() {
        return nama_penyewa;
    }

    public void setNama_penyewa(String nama_penyewa) {
        this.nama_penyewa = nama_penyewa;
    }

    public Date getTanggal_transaksi() {
        return tanggal_transaksi;
    }

    public void setTanggal_transaksi(Date tanggal_transaksi) {
        this.tanggal_transaksi = tanggal_transaksi;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
