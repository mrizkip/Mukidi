package com.example.mrizkip.mukidi;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioGroup;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PilihKategoriBudget extends AppCompatActivity {
    @BindView(R.id.radioGroupPilihKategoriBudget) RadioGroup radioGroupPilihKategoriBudget;
    private String kategoriBudget;

    private int mCheckedId = R.id.radioMakanMinum;

    private Toolbar toolbar;
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilih_kategori_budget);
        ButterKnife.bind(this);

        toolbar = (Toolbar) findViewById(R.id.toolbarPilihKategoriBudget);

        if(toolbar != null) {
            setSupportActionBar(toolbar);
        }

        actionBar = getSupportActionBar();
        actionBar.setTitle("PILIH KATEGORI BUDGET");

        if(actionBar != null) {
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        radioGroupPilihKategoriBudget.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                mCheckedId = checkedId;
            }
        });
    }

    public void pilihKategoriBudget() {
        if (mCheckedId == R.id.radioMakanMinum) {
            kategoriBudget = "MakanMinum";
        } else if (mCheckedId == R.id.radioBelanja) {
            kategoriBudget = "Belanja";
        } else if (mCheckedId == R.id.radioHadiahKeluar) {
            kategoriBudget = "HadiahKeluar";
        } else if (mCheckedId == R.id.radioPendidikan) {
            kategoriBudget = "Pendidikan";
        } else if (mCheckedId == R.id.radioHiburan) {
            kategoriBudget = "Hiburan";
        } else if (mCheckedId == R.id.radioTagihan) {
            kategoriBudget = "Tagihan";
        } else if (mCheckedId == R.id.radioTraveling) {
            kategoriBudget = "Travelling";
        } else if (mCheckedId == R.id.radioTransportasi) {
            kategoriBudget = "Transportasi";
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.pilih_kategori_budget, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            case R.id.selesaiPilihKategori:
                // pilih kategori
                pilihKategoriBudget();
                Intent intent = getIntent();
                intent.putExtra("kategori", kategoriBudget);
                setResult(RESULT_OK, intent);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
