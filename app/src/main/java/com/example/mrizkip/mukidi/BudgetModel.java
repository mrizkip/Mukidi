package com.example.mrizkip.mukidi;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToMany;

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

    private long nominalBudget;
    private String kategoriBudget;
    @Generated(hash = 1376076062)
    public BudgetModel(Long idBudget, long idUser, long nominalBudget,
            String kategoriBudget) {
        this.idBudget = idBudget;
        this.idUser = idUser;
        this.nominalBudget = nominalBudget;
        this.kategoriBudget = kategoriBudget;
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

    
}
