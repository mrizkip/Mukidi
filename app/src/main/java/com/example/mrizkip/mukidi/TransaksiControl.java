package com.example.mrizkip.mukidi;

import java.util.Date;
import java.util.List;

/**
 * Created by mrizkip on 11/30/2016.
 */
public class TransaksiControl {
    private UserModel userModel;
    private UserModelDao userModelDao;
    private TransaksiModel transaksiModel;
    private TransaksiModelDao transaksiModelDao;
    private List<TransaksiModel> listTransaksi;

    String jenisTransaksi;

    public TransaksiControl() {
        userModelDao = MukidiApplication.getInstance().getDaoSession().getUserModelDao();
        transaksiModelDao = MukidiApplication.getInstance().getDaoSession().getTransaksiModelDao();
        userModel = getUserModel();
    }

    private UserModel getUserModel() {
        userModel = userModelDao.queryBuilder().list().get(0);
        return userModel;
    }

    // ambil semua transaksi berdasarkan tanggal
    public List<TransaksiModel> getListTransaksi(Date tanggalTransaksi) {
        listTransaksi = transaksiModelDao.queryBuilder().where(TransaksiModelDao.Properties.IdUser.eq(userModel.getIdUser()))
                .where(TransaksiModelDao.Properties.TanggalTransaksi.eq(tanggalTransaksi))
                .list();
        return listTransaksi;
    }

    public void addPemasukan(long nominalTransaksi, String kategoriTransaksi, Date tanggalTransaksi) {
        jenisTransaksi = "Pemasukan";
        transaksiModel = new TransaksiModel(null, userModel.getIdUser(),nominalTransaksi, kategoriTransaksi, tanggalTransaksi, jenisTransaksi);
    }

    public void addPengeluaran(long nominalTransaksi, String kategoriTransaksi, Date tanggalTransaksi) {
        jenisTransaksi = "Pengeluaran";
        transaksiModel = new TransaksiModel(null, userModel.getIdUser(), nominalTransaksi, kategoriTransaksi, tanggalTransaksi, jenisTransaksi);
    }

    public TransaksiModel getTransaksiModel(Long idTransaksi) {
        transaksiModel = transaksiModelDao.queryBuilder().where(TransaksiModelDao.Properties.IdTransaksi.eq(idTransaksi))
                .list().get(0);
        return transaksiModel;
    }
}
