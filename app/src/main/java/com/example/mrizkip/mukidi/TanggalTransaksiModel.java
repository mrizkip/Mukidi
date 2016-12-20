package com.example.mrizkip.mukidi;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by mrizkip on 12/14/2016.
 */
public class TanggalTransaksiModel {

    private Date date;
    private List<TransaksiModel> transaksiModelList = new ArrayList<>();

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<TransaksiModel> getTransaksiModelList() {
        return transaksiModelList;
    }

    public void setTransaksiModelList(List<TransaksiModel> transaksiModelList) {
        this.transaksiModelList = transaksiModelList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TanggalTransaksiModel that = (TanggalTransaksiModel) o;

        return date != null ? date.equals(that.date) : that.date == null;

    }

    @Override
    public int hashCode() {
        return date != null ? date.hashCode() : 0;
    }
}
