package com.uas027.uas_prg7_20222_027.model;

import jakarta.persistence.*;

import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "Detail")
public class Detail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detail")
    private Integer id_detail;

    @Column(name = "id_transaksi")
    private Integer id_transaksi;

    @Column(name = "id_lapangan")
    private Integer id_lapangan;

    @Column(name = "waktu_mulai")
    private Time waktu_mulai;

    @Column(name = "jumlah_jam_sewa")
    private Integer jumlah_jam_sewa;

    @Column(name = "sub_total")
    private Integer sub_total;

    public Detail() {

    }

    public Detail(Integer id_detail, Integer id_transaksi, Integer id_lapangan, Time waktu_mulai, Integer jumlah_jam_sewa, Integer sub_total) {
        this.id_detail = id_detail;
        this.id_transaksi = id_transaksi;
        this.id_lapangan = id_lapangan;
        this.waktu_mulai = waktu_mulai;
        this.jumlah_jam_sewa = jumlah_jam_sewa;
        this.sub_total = sub_total;
    }

    public Detail(Integer id_transaksi, Integer id_lapangan, Time waktu_mulai, Integer jumlah_jam_sewa, Integer sub_total) {
        this.id_transaksi = id_transaksi;
        this.id_lapangan = id_lapangan;
        this.waktu_mulai = waktu_mulai;
        this.jumlah_jam_sewa = jumlah_jam_sewa;
        this.sub_total = sub_total;
    }

    public Integer getId_detail() {
        return id_detail;
    }

    public void setId_detail(Integer id_detail) {
        this.id_detail = id_detail;
    }

    public Integer getId_transaksi() {
        return id_transaksi;
    }

    public void setId_transaksi(Integer id_transaksi) {
        this.id_transaksi = id_transaksi;
    }

    public Integer getId_lapangan() {
        return id_lapangan;
    }

    public void setId_lapangan(Integer id_lapangan) {
        this.id_lapangan = id_lapangan;
    }

    public Time getWaktu_mulai() {
        return waktu_mulai;
    }

    public void setWaktu_mulai(Time waktu_mulai) {
        this.waktu_mulai = waktu_mulai;
    }

    public Integer getJumlah_jam_sewa() {
        return jumlah_jam_sewa;
    }

    public void setJumlah_jam_sewa(Integer jumlah_jam_sewa) {
        this.jumlah_jam_sewa = jumlah_jam_sewa;
    }

    public Integer getSub_total() {
        return sub_total;
    }

    public void setSub_total(Integer sub_total) {
        this.sub_total = sub_total;
    }
}
