package com.example.mrizkip.mukidi;

import java.util.Date;
import java.util.List;

/**
 * Created by mrizkip on 11/30/2016.
 */
public class BudgetControl {
    private UserModel userModel;
    private UserModelDao userModelDao;
    private BudgetModel budgetModel;
    private BudgetModelDao budgetModelDao;
    private TransaksiModelDao transaksiModelDao;
    private List<BudgetModel> listBudget;
    private long recentBudget;
    private double percentage;

    public BudgetControl() {
        userModelDao = MukidiApplication.getInstance().getDaoSession().getUserModelDao();
        budgetModelDao = MukidiApplication.getInstance().getDaoSession().getBudgetModelDao();
        transaksiModelDao = MukidiApplication.getInstance().getDaoSession().getTransaksiModelDao();
        userModel = getUserModel();
    }

    private UserModel getUserModel() {
        userModel = userModelDao.queryBuilder().list().get(0);
        return userModel;
    }

    public List<BudgetModel> getListBudget() {
        listBudget = budgetModelDao.queryBuilder().where(BudgetModelDao.Properties.IdUser.eq(userModel.getIdUser())).list();
        return listBudget;
    }

    public void addBudget(String namaBudget, long nominalBudget, String kategoriBudget, Date tanggalAwalBudget, Date tanggalAkhirBudget) {
        budgetModel = new BudgetModel(null, userModel.getIdUser(), namaBudget, nominalBudget, kategoriBudget, tanggalAwalBudget, tanggalAkhirBudget);
        budgetModelDao.insert(budgetModel);
    }

    public void calculateBudget(BudgetModel budgetModel) {
        List<TransaksiModel> listTransaksi = transaksiModelDao.queryBuilder().where(TransaksiModelDao.Properties.IdUser.eq(userModel.getIdUser())).list();
        recentBudget = 0;
        for (TransaksiModel transaksi : listTransaksi) {
            if ((transaksi.getTanggalTransaksi().getTime() >= budgetModel.getTanggalAwalBudget().getTime()) &&
                    (transaksi.getTanggalTransaksi().getTime() <= budgetModel.getTanggalAkhirBudget().getTime())) {
                if (transaksi.getKategoriTransaksi().equals(budgetModel.getKategoriBudget())) {
                    recentBudget = recentBudget + transaksi.getNominalTransaksi();
                }
            }
        }
        percentage = (double) recentBudget / (double) budgetModel.getNominalBudget() * 100;
    }

    public long getRecentBudget() {
        return recentBudget;
    }

    public double getPercentage() {
        return percentage;
    }
}
