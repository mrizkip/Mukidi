package com.example.mrizkip.mukidi;

import java.util.List;

/**
 * Created by mrizkip on 11/30/2016.
 */
public class BudgetControl {
    private UserModel userModel;
    private UserModelDao userModelDao;
    private BudgetModel budgetModel;
    private BudgetModelDao budgetModelDao;
    private List<BudgetModel> listBudget;
    private TransaksiModelDao transaksiModelDao;
    private List<TransaksiModel> listTransaksi;

    public BudgetControl() {
        userModelDao = MukidiApplication.getInstance().getDaoSession().getUserModelDao();
        budgetModelDao = MukidiApplication.getInstance().getDaoSession().getBudgetModelDao();
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

    public void setBudget(long nominalBudget, String kategoriBudget) {
        budgetModel = new BudgetModel(null, userModel.getIdUser(), nominalBudget, kategoriBudget);
        budgetModelDao.insert(budgetModel);
    }

    public void calculateBudget() {

    }
}
