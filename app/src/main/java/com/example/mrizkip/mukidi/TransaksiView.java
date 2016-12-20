package com.example.mrizkip.mukidi;

import android.content.Context;
import android.os.Debug;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.nlopez.smartadapters.views.BindableRelativeLayout;

/**
 * Created by mrizkip on 12/14/2016.
 */
public class TransaksiView extends BindableRelativeLayout<TransaksiModel> {
    @BindView(R.id.iconKategoriTransaksi)
    ImageView iconKategoriTransaksi;
    @BindView(R.id.txtKategoriTransaksi)
    TextView txtKategoriTransaksi;
    @BindView(R.id.txtNominalTransaksi) TextView txtNominalTransaksi;
    String kategoriTransaksi;

    public TransaksiView(Context context) {
        super(context);
    }

    @Override
    public int getLayoutId() {
        return R.layout.transaksi_view;
    }

    @Override
    public void onViewInflated() {
        ButterKnife.bind(this);
        setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
    }

    @Override
    public void bind(TransaksiModel transaksiModel) {
        kategoriTransaksi = transaksiModel.getKategoriTransaksi();
        Log.d("Test", kategoriTransaksi);
        if(kategoriTransaksi.equalsIgnoreCase("MakanMinum")) {
            iconKategoriTransaksi.setImageResource(R.drawable.makan_minum);
            txtKategoriTransaksi.setText("Makan & Minum");
        } else if (kategoriTransaksi.equalsIgnoreCase("Belanja")) {
            iconKategoriTransaksi.setImageResource(R.drawable.belanja);
            txtKategoriTransaksi.setText(kategoriTransaksi);
        } else if (kategoriTransaksi.equalsIgnoreCase("HadiahKeluar")) {
            iconKategoriTransaksi.setImageResource(R.drawable.hadiah);
            txtKategoriTransaksi.setText("Hadiah");
        } else if (kategoriTransaksi.equalsIgnoreCase("Pendidikan")) {
            iconKategoriTransaksi.setImageResource(R.drawable.pendidikan);
            txtKategoriTransaksi.setText(kategoriTransaksi);
        } else if (kategoriTransaksi.equalsIgnoreCase("Hiburan")) {
            iconKategoriTransaksi.setImageResource(R.drawable.hiburan);
            txtKategoriTransaksi.setText(kategoriTransaksi);
        } else if (kategoriTransaksi.equalsIgnoreCase("Tagihan")) {
            iconKategoriTransaksi.setImageResource(R.drawable.tagihan);
            txtKategoriTransaksi.setText(kategoriTransaksi);
        } else if (kategoriTransaksi.equalsIgnoreCase("Travelling")) {
            iconKategoriTransaksi.setImageResource(R.drawable.travel);
            txtKategoriTransaksi.setText(kategoriTransaksi);
        } else if (kategoriTransaksi.equalsIgnoreCase("Transportasi")) {
            iconKategoriTransaksi.setImageResource(R.drawable.transportasi);
            txtKategoriTransaksi.setText(kategoriTransaksi);
        } else if (kategoriTransaksi.equalsIgnoreCase("Gaji")) {
            iconKategoriTransaksi.setImageResource(R.drawable.gaji);
            txtKategoriTransaksi.setText(kategoriTransaksi);
        } else if (kategoriTransaksi.equalsIgnoreCase("Bisnis")) {
            iconKategoriTransaksi.setImageResource(R.drawable.bisnis);
            txtKategoriTransaksi.setText(kategoriTransaksi);
        } else if (kategoriTransaksi.equalsIgnoreCase("HadiahMasuk")) {
            iconKategoriTransaksi.setImageResource(R.drawable.hadiah);
            txtKategoriTransaksi.setText(kategoriTransaksi);
        } else if (kategoriTransaksi.equalsIgnoreCase("Pinjaman")) {
            iconKategoriTransaksi.setImageResource(R.drawable.pinjaman);
            txtKategoriTransaksi.setText(kategoriTransaksi);
        }
        txtNominalTransaksi.setText(String.valueOf(transaksiModel.getNominalTransaksi()));
    }
}
