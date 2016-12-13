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
public class UserModel {
    @Id(autoincrement = true)
    private Long idUser;

    private long saldo;

    @ToMany(referencedJoinProperty = "idUser")
    private List<AsetModel> asetModelList;

    @ToMany(referencedJoinProperty = "idUser")
    private List<TransaksiModel> transaksiModelList;

    @ToMany(referencedJoinProperty = "idUser")
    private List<BudgetModel> budgetModelList;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 1229314203)
    private transient UserModelDao myDao;

    @Generated(hash = 1733993042)
    public UserModel(Long idUser, long saldo) {
        this.idUser = idUser;
        this.saldo = saldo;
    }

    @Generated(hash = 782181818)
    public UserModel() {
    }

    public Long getIdUser() {
        return this.idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public long getSaldo() {
        return this.saldo;
    }

    public void setSaldo(long saldo) {
        this.saldo = saldo;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 2108215298)
    public List<AsetModel> getAsetModelList() {
        if (asetModelList == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            AsetModelDao targetDao = daoSession.getAsetModelDao();
            List<AsetModel> asetModelListNew = targetDao
                    ._queryUserModel_AsetModelList(idUser);
            synchronized (this) {
                if (asetModelList == null) {
                    asetModelList = asetModelListNew;
                }
            }
        }
        return asetModelList;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 561870836)
    public synchronized void resetAsetModelList() {
        asetModelList = null;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 163582056)
    public List<TransaksiModel> getTransaksiModelList() {
        if (transaksiModelList == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            TransaksiModelDao targetDao = daoSession.getTransaksiModelDao();
            List<TransaksiModel> transaksiModelListNew = targetDao
                    ._queryUserModel_TransaksiModelList(idUser);
            synchronized (this) {
                if (transaksiModelList == null) {
                    transaksiModelList = transaksiModelListNew;
                }
            }
        }
        return transaksiModelList;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 142228250)
    public synchronized void resetTransaksiModelList() {
        transaksiModelList = null;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 911814347)
    public List<BudgetModel> getBudgetModelList() {
        if (budgetModelList == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            BudgetModelDao targetDao = daoSession.getBudgetModelDao();
            List<BudgetModel> budgetModelListNew = targetDao
                    ._queryUserModel_BudgetModelList(idUser);
            synchronized (this) {
                if (budgetModelList == null) {
                    budgetModelList = budgetModelListNew;
                }
            }
        }
        return budgetModelList;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 445737568)
    public synchronized void resetBudgetModelList() {
        budgetModelList = null;
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 359156521)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getUserModelDao() : null;
    }
}
