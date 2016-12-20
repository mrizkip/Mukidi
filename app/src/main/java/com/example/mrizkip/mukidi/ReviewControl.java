package com.example.mrizkip.mukidi;

import java.util.List;

/**
 * Created by mrizkip on 11/30/2016.
 */
public class ReviewControl {
    private List<TransaksiModel> transaksiModels;

    private UserModel userModel;
    private UserModelDao userModelDao;
    private TransaksiModelDao transaksiModelDao;

    public ReviewControl() {
        userModelDao = MukidiApplication.getInstance().getDaoSession().getUserModelDao();
        transaksiModelDao = MukidiApplication.getInstance().getDaoSession().getTransaksiModelDao();
    }

    public UserModel getUserModel() {
        UserModel userModel = userModelDao.queryBuilder().list().get(0);
        return userModel;
    }

    public List<TransaksiModel> getReview() {
        userModel = getUserModel();
        transaksiModels = transaksiModelDao.queryBuilder().where(TransaksiModelDao.Properties.IdUser.eq(userModel.getIdUser()))
                .orderAsc(TransaksiModelDao.Properties.TanggalTransaksi).list();
        return transaksiModels;
    }
}
