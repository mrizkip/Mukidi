package com.example.mrizkip.mukidi;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class TambahPengeluaran extends Fragment {
    private RadioGroup radioGroupPengeluaran1;
    private RadioGroup radioGroupPengeluaran2;
    private String kategoriPengeluaran;

    private boolean isChecking = true;
    private int mCheckedId = R.id.radioBtnMakanMinum;

    public TambahPengeluaran() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tambah_pengeluaran, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        radioGroupPengeluaran1 = (RadioGroup) view.findViewById(R.id.radioGroupPengeluaran1);
        radioGroupPengeluaran2 = (RadioGroup) view.findViewById(R.id.radioGroupPengeluaran2);

        radioGroupPengeluaran1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId != -1 && isChecking) {
                    isChecking = false;
                    radioGroupPengeluaran2.clearCheck();
                    mCheckedId = checkedId;
                }
                isChecking = true;
            }
        });

        radioGroupPengeluaran2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId != -1 && isChecking) {
                    isChecking = false;
                    radioGroupPengeluaran1.clearCheck();
                    mCheckedId = checkedId;
                }
                isChecking = true;
            }
        });
    }

    public void pilihKategori() {
        if (mCheckedId == R.id.radioBtnMakanMinum) {
            kategoriPengeluaran = "MakanMinum";
        } else if (mCheckedId == R.id.radioBtnBelanja) {
            kategoriPengeluaran = "Belanja";
        } else if (mCheckedId == R.id.radioBtnHadiahKeluar) {
            kategoriPengeluaran = "HadiahKeluar";
        } else if (mCheckedId == R.id.radioBtnPendidikan) {
            kategoriPengeluaran = "Pendidikan";
        } else if (mCheckedId == R.id.radioBtnHiburan) {
            kategoriPengeluaran = "Hiburan";
        } else if (mCheckedId == R.id.radioBtnTagihan) {
            kategoriPengeluaran = "Tagihan";
        } else if (mCheckedId == R.id.radioBtnTraveling) {
            kategoriPengeluaran = "Travelling";
        } else if (mCheckedId == R.id.radioBtnTransportasi) {
            kategoriPengeluaran = "Transportasi";
        }
    }
}
