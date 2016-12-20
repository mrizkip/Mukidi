package com.example.mrizkip.mukidi;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.nlopez.smartadapters.views.BindableFrameLayout;
import io.nlopez.smartadapters.views.BindableRelativeLayout;

/**
 * Created by mrizkip on 12/14/2016.
 */
public class TanggalView extends BindableRelativeLayout<TanggalTransaksiModel> {
    @BindView(R.id.txtTanggalTransaksi)
    TextView txtTanggalTransaksi;

    public TanggalView(Context context) {
        super(context);
    }

    @Override
    public int getLayoutId() {
        return R.layout.tanggal_view;
    }

    @Override
    public void onViewInflated() {
        ButterKnife.bind(this);
        setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
    }

    @Override
    public void bind(TanggalTransaksiModel tanggalTransaksiModel) {
        String format = "dd-MMMM-yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.US);
        txtTanggalTransaksi.setText(sdf.format(tanggalTransaksiModel.getDate()));
    }
}
