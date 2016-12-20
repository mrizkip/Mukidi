package com.example.mrizkip.mukidi;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by mrizkip on 11/30/2016.
 */
public class TransaksiControl {
    private TransaksiModel transaksiModel;
    private TransaksiModelDao transaksiModelDao;
    private List<TransaksiModel> listTransaksi;

    private UserModel userModel;
    private UserModelDao userModelDao;

    public TransaksiControl() {
        userModelDao = MukidiApplication.getInstance().getDaoSession().getUserModelDao();
        transaksiModelDao = MukidiApplication.getInstance().getDaoSession().getTransaksiModelDao();
    }

    private UserModel getUserModel() {
        userModel = userModelDao.queryBuilder().list().get(0);
        return userModel;
    }

    // ambil semua transaksi
    public List<TransaksiModel> getListTransaksi() {
        userModel = getUserModel();
        listTransaksi = transaksiModelDao.queryBuilder().where(TransaksiModelDao.Properties.IdUser.eq(userModel.getIdUser()))
                .orderAsc(TransaksiModelDao.Properties.TanggalTransaksi).list();
        return listTransaksi;
    }

    public void addPemasukan(String jenisTransaksi, long nominalTransaksi, String kategoriTransaksi, Date tanggalTransaksi) {
        userModel = getUserModel();
        transaksiModel = new TransaksiModel(null, userModel.getIdUser(),nominalTransaksi, kategoriTransaksi, tanggalTransaksi, jenisTransaksi);
        transaksiModelDao.insert(transaksiModel);
    }

    public void addPengeluaran(String jenisTransaksi, long nominalTransaksi, String kategoriTransaksi, Date tanggalTransaksi) {
        userModel = getUserModel();
        transaksiModel = new TransaksiModel(null, userModel.getIdUser(), nominalTransaksi, kategoriTransaksi, tanggalTransaksi, jenisTransaksi);
        transaksiModelDao.insert(transaksiModel);
    }

    public TransaksiModel getTransaksiModel(Long idTransaksi) {
        transaksiModel = transaksiModelDao.queryBuilder().where(TransaksiModelDao.Properties.IdTransaksi.eq(idTransaksi))
                .list().get(0);
        return transaksiModel;
    }

    public List<Object> getDataToShow() {
        List<TransaksiModel> transaksiModelList = getListTransaksi();

        List<Object> dataToShow = new ArrayList<>();

        for(TransaksiModel transaksi : transaksiModelList) {
            TanggalTransaksiModel tanggalModel = new TanggalTransaksiModel();
            tanggalModel.setDate(transaksi.getTanggalTransaksi());
            if(!dataToShow.contains(tanggalModel)) {
                dataToShow.add(tanggalModel);
            }
            dataToShow.add(transaksi);
        }

        return dataToShow;
    }
}
