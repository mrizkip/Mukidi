package com.example.mrizkip.mukidi;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.Toast;

import butterknife.BindView;


/**
 * A simple {@link Fragment} subclass.
 */
public class TambahPemasukan extends Fragment {
    private RadioGroup radioGroupPemasukan;
    private String kategoriPemasukan;

    private TambahTransaksi tambahTransaksi;

    private int mCheckedId;

    public TambahPemasukan() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof TambahTransaksi) {
            tambahTransaksi = (TambahTransaksi) context;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tambah_pemasukan, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        radioGroupPemasukan = (RadioGroup) view.findViewById(R.id.radioGroupPemasukan);
        radioGroupPemasukan.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(mCheckedId != -1) {
                    mCheckedId = checkedId;
                    pilihKategoriPemasukan();
                    tambahTransaksi.updateSelection("Pemasukan", kategoriPemasukan);
                }
            }
        });
    }

    public void pilihKategoriPemasukan() {
        if (mCheckedId == R.id.radioBtnGaji) {
            kategoriPemasukan = "Gaji";
        } else if (mCheckedId == R.id.radioBtnPinjaman) {
            kategoriPemasukan = "Pinjaman";
        } else if (mCheckedId == R.id.radioBtnHadiahMasuk) {
            kategoriPemasukan = "HadiahMasuk";
        } else if (mCheckedId == R.id.radioBtnBisnis) {
            kategoriPemasukan = "Bisnis";
        }
    }

    public void selectDefault() {
        radioGroupPemasukan.clearCheck();
    }
}
