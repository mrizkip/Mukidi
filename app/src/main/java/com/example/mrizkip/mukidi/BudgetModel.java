package com.example.mrizkip.mukidi;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.Date;
import java.util.List;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

/**
 * Created by mrizkip on 12/6/2016.
 */
@Entity
public class BudgetModel {
    @Id(autoincrement = true)
    private Long idBudget;

    private long idUser;

    private String namaBudget;
    private long nominalBudget;
    private String kategoriBudget;
    private Date tanggalAwalBudget;
    private Date tanggalAkhirBudget;
    @Generated(hash = 1452157988)
    public BudgetModel(Long idBudget, long idUser, String namaBudget,
            long nominalBudget, String kategoriBudget, Date tanggalAwalBudget,
            Date tanggalAkhirBudget) {
        this.idBudget = idBudget;
        this.idUser = idUser;
        this.namaBudget = namaBudget;
        this.nominalBudget = nominalBudget;
        this.kategoriBudget = kategoriBudget;
        this.tanggalAwalBudget = tanggalAwalBudget;
        this.tanggalAkhirBudget = tanggalAkhirBudget;
    }
    @Generated(hash = 986427255)
    public BudgetModel() {
    }
    public Long getIdBudget() {
        return this.idBudget;
    }
    public void setIdBudget(Long idBudget) {
        this.idBudget = idBudget;
    }
    public long getIdUser() {
        return this.idUser;
    }
    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }
    public String getNamaBudget() {
        return this.namaBudget;
    }
    public void setNamaBudget(String namaBudget) {
        this.namaBudget = namaBudget;
    }
    public long getNominalBudget() {
        return this.nominalBudget;
    }
    public void setNominalBudget(long nominalBudget) {
        this.nominalBudget = nominalBudget;
    }
    public String getKategoriBudget() {
        return this.kategoriBudget;
    }
    public void setKategoriBudget(String kategoriBudget) {
        this.kategoriBudget = kategoriBudget;
    }
    public Date getTanggalAwalBudget() {
        return this.tanggalAwalBudget;
    }
    public void setTanggalAwalBudget(Date tanggalAwalBudget) {
        this.tanggalAwalBudget = tanggalAwalBudget;
    }
    public Date getTanggalAkhirBudget() {
        return this.tanggalAkhirBudget;
    }
    public void setTanggalAkhirBudget(Date tanggalAkhirBudget) {
        this.tanggalAkhirBudget = tanggalAkhirBudget;
    }


    
}
