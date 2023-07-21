package com.uas027.uas_prg7_20222_027.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Lapangan")
public class Lapangan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_lapangan")
    private Integer id_lapangan;

    @Column(name = "nama_lapangan")
    private String nama_lapangan;

    @Column(name = "harga_lapangan")
    private Integer harga_lapangan;

    @Column(name = "status")
    private Integer status;

    public Lapangan() {

    }

    public Lapangan(Integer id_lapangan, String nama_lapangan, Integer harga_lapangan, Integer status) {
        this.id_lapangan = id_lapangan;
        this.nama_lapangan = nama_lapangan;
        this.harga_lapangan = harga_lapangan;
        this.status = status;
    }

    public Integer getId_lapangan() {
        return id_lapangan;
    }

    public void setId_lapangan(Integer id_lapangan) {
        this.id_lapangan = id_lapangan;
    }

    public String getNama_lapangan() {
        return nama_lapangan;
    }

    public void setNama_lapangan(String nama_lapangan) {
        this.nama_lapangan = nama_lapangan;
    }

    public Integer getHarga_lapangan() {
        return harga_lapangan;
    }

    public void setHarga_lapangan(Integer harga_lapangan) {
        this.harga_lapangan = harga_lapangan;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
