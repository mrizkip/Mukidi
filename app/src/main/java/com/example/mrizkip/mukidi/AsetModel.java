package com.example.mrizkip.mukidi;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import java.util.Date;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by mrizkip on 12/6/2016.
 */
@Entity
public class AsetModel {
    @Id(autoincrement = true)
    private Long idAset;

    private long idUser;

    private String namaAset;
    private String lokasiAset;
    private Date tanggalPajak;
    private String deskripsiAset;
    @Generated(hash = 677719487)
    public AsetModel(Long idAset, long idUser, String namaAset, String lokasiAset,
            Date tanggalPajak, String deskripsiAset) {
        this.idAset = idAset;
        this.idUser = idUser;
        this.namaAset = namaAset;
        this.lokasiAset = lokasiAset;
        this.tanggalPajak = tanggalPajak;
        this.deskripsiAset = deskripsiAset;
    }
    @Generated(hash = 1960721441)
    public AsetModel() {
    }
    public Long getIdAset() {
        return this.idAset;
    }
    public void setIdAset(Long idAset) {
        this.idAset = idAset;
    }
    public long getIdUser() {
        return this.idUser;
    }
    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }
    public String getLokasiAset() {
        return this.lokasiAset;
    }
    public void setLokasiAset(String lokasiAset) {
        this.lokasiAset = lokasiAset;
    }
    public Date getTanggalPajak() {
        return this.tanggalPajak;
    }
    public void setTanggalPajak(Date tanggalPajak) {
        this.tanggalPajak = tanggalPajak;
    }
    public String getDeskripsiAset() {
        return this.deskripsiAset;
    }
    public void setDeskripsiAset(String deskripsiAset) {
        this.deskripsiAset = deskripsiAset;
    }
    public String getNamaAset() {
        return this.namaAset;
    }
    public void setNamaAset(String namaAset) {
        this.namaAset = namaAset;
    }

}

