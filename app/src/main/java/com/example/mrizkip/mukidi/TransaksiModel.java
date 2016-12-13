package com.example.mrizkip.mukidi;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import java.util.Date;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by mrizkip on 12/6/2016.
 */
@Entity
public class TransaksiModel {
    @Id(autoincrement = true)
    private Long idTransaksi;

    private long idUser;

    private long nominalTransaksi;
    private String kategoriTransaksi;
    private Date tanggalTransaksi;
    private String jenisTransaksi;
    @Generated(hash = 426854650)
    public TransaksiModel(Long idTransaksi, long idUser, long nominalTransaksi,
            String kategoriTransaksi, Date tanggalTransaksi,
            String jenisTransaksi) {
        this.idTransaksi = idTransaksi;
        this.idUser = idUser;
        this.nominalTransaksi = nominalTransaksi;
        this.kategoriTransaksi = kategoriTransaksi;
        this.tanggalTransaksi = tanggalTransaksi;
        this.jenisTransaksi = jenisTransaksi;
    }
    @Generated(hash = 1792444128)
    public TransaksiModel() {
    }
    public Long getIdTransaksi() {
        return this.idTransaksi;
    }
    public void setIdTransaksi(Long idTransaksi) {
        this.idTransaksi = idTransaksi;
    }
    public long getIdUser() {
        return this.idUser;
    }
    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }
    public long getNominalTransaksi() {
        return this.nominalTransaksi;
    }
    public void setNominalTransaksi(long nominalTransaksi) {
        this.nominalTransaksi = nominalTransaksi;
    }
    public String getKategoriTransaksi() {
        return this.kategoriTransaksi;
    }
    public void setKategoriTransaksi(String kategoriTransaksi) {
        this.kategoriTransaksi = kategoriTransaksi;
    }
    public Date getTanggalTransaksi() {
        return this.tanggalTransaksi;
    }
    public void setTanggalTransaksi(Date tanggalTransaksi) {
        this.tanggalTransaksi = tanggalTransaksi;
    }
    public String getJenisTransaksi() {
        return this.jenisTransaksi;
    }
    public void setJenisTransaksi(String jenisTransaksi) {
        this.jenisTransaksi = jenisTransaksi;
    }


}
