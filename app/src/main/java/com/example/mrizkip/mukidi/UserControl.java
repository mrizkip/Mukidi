package com.example.mrizkip.mukidi;

import java.util.List;

/**
 * Created by mrizkip on 12/6/2016.
 */
public class UserControl {
    private UserModel userModel;
    private UserModelDao dao;
    private List<UserModel> listUser;

    public UserControl() {
        dao = MukidiApplication.getInstance().getDaoSession().getUserModelDao();
    }

    public List<UserModel> checkUser() {
        listUser = dao.queryBuilder().list();
        return listUser;
    }

    public void addUser() {
        UserModel user = new UserModel(null, 0);
        dao.insert(user);
    }

    public void updateSaldoUser(long saldo) {
        checkUser();
        userModel = listUser.get(0);
        userModel.setSaldo(saldo);
        dao.update(userModel);
    }


}
