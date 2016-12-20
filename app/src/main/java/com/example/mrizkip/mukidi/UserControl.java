package com.example.mrizkip.mukidi;

import java.lang.ref.PhantomReference;
import java.util.List;

/**
 * Created by mrizkip on 12/6/2016.
 */
public class UserControl {
    private UserModel userModel;
    private UserModelDao dao;
    private List<UserModel> listUser;
    private TransaksiControl transaksiControl;

    private long saldoUser;
    private long nominalPemasukan;
    private long nominalPengeluaran;

    public UserControl() {
        dao = MukidiApplication.getInstance().getDaoSession().getUserModelDao();
        transaksiControl = new TransaksiControl();
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
        userModel = dao.queryBuilder().list().get(0);
        userModel.setSaldo(saldo);
        dao.update(userModel);
    }

    public long getSaldoUser() {
        saldoUser = dao.queryBuilder().list().get(0).getSaldo();
        calculateSaldo();
        return saldoUser;
    }

    private void calculateSaldo() {
        nominalPemasukan = 0;
        nominalPengeluaran = 0;
        List<TransaksiModel> listTransaksi = transaksiControl.getListTransaksi();
        for (TransaksiModel transaksi : listTransaksi) {
            if (transaksi.getJenisTransaksi().equals("Pemasukan")) {
                nominalPemasukan = nominalPemasukan + transaksi.getNominalTransaksi();
            } else if (transaksi.getJenisTransaksi().equals("Pengeluaran")) {
                nominalPengeluaran = nominalPengeluaran + transaksi.getNominalTransaksi();
            }
        }
        saldoUser = saldoUser + (nominalPemasukan - nominalPengeluaran);
    }

}
