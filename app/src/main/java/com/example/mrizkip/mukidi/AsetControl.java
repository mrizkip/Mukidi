package com.example.mrizkip.mukidi;

import java.util.Date;
import java.util.List;

/**
 * Created by mrizkip on 11/30/2016.
 */
public class AsetControl {
    private UserModel userModel;
    private UserModelDao userModelDao;
    private AsetModel asetModel;
    private AsetModelDao dao;
    private List<AsetModel> listAset;

    public AsetControl() {
        userModelDao = MukidiApplication.getInstance().getDaoSession().getUserModelDao();
        dao = MukidiApplication.getInstance().getDaoSession().getAsetModelDao();
    }

    private UserModel getUserModel() {
        UserModel user;
        user = userModelDao.queryBuilder().list().get(0);
        return user;
    }

    public List<AsetModel> getListAset() {
        userModel = getUserModel();
        listAset = dao.queryBuilder().where(AsetModelDao.Properties.IdUser.eq(userModel.getIdUser())).list();
        return listAset;
    }

    public void addAset(String namaAset, String lokasiAset, Date tanggalPajak, String deskripsiAset) {
        userModel = getUserModel();
        asetModel = new AsetModel(null, userModel.getIdUser(), namaAset, lokasiAset, tanggalPajak, deskripsiAset);
        dao.insert(asetModel);
    }

    public void editAset(Long idAset, String namaAset, String lokasiAset, Date tanggalPajak, String deskripsiAset) {
        userModel = getUserModel();
        asetModel = dao.queryBuilder().where(AsetModelDao.Properties.IdAset.eq(idAset)).list().get(0);
        asetModel.setNamaAset(namaAset);
        asetModel.setLokasiAset(lokasiAset);
        asetModel.setTanggalPajak(tanggalPajak);
        asetModel.setDeskripsiAset(deskripsiAset);
        dao.update(asetModel);
    }

    public void deleteAset(Long idAset) {
        userModel = getUserModel();
        asetModel = dao.queryBuilder().where(AsetModelDao.Properties.IdAset.eq(idAset)).list().get(0);
        dao.delete(asetModel);
    }

    public AsetModel getAsetModel(Long idAset) {
        userModel = getUserModel();
        asetModel = dao.queryBuilder().where(AsetModelDao.Properties.IdAset.eq(idAset)).list().get(0);
        return asetModel;
    }


}
