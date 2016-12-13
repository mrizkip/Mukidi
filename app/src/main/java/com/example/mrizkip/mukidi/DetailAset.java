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
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailAset extends AppCompatActivity {
    @BindView(R.id.toolbarAsetText) TextView namaAset;
    @BindView(R.id.lokasiAset) TextView lokasiAset;
    @BindView(R.id.tanggalPajakAset) TextView tanggalPajakAset;
    @BindView(R.id.deskripsiAset) TextView deskripsiAset;
    private Toolbar toolbarDetailAset;
    private ActionBar actionBar;

    private AsetControl asetControl;
    private AsetModel asetModel;
    private Long idAsetModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_aset);
        ButterKnife.bind(this);

        toolbarDetailAset = (Toolbar) findViewById(R.id.toolbarTambahAset);
        if (toolbarDetailAset != null) {
            setSupportActionBar(toolbarDetailAset);
        }

        actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        // mendapatkan detail aset
        asetControl = new AsetControl();
        Intent intent = getIntent();
        idAsetModel = intent.getLongExtra("idAset", -1); //ambil dari intent listAset
        asetModel = asetControl.getAsetModel(idAsetModel);
        namaAset.setText(asetModel.getNamaAset());
        lokasiAset.setText(asetModel.getLokasiAset());
        String format = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.US);
        tanggalPajakAset.setText(sdf.format(asetModel.getTanggalPajak()));
        deskripsiAset.setText(asetModel.getDeskripsiAset());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detail_aset, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
            case R.id.editAset:
                // Method editAset

                Toast.makeText(DetailAset.this, "Edit Aset", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.hapusAset:
                // Method deleteAset
                // tampilkan pesan allert
//                asetControl.deleteAset(idAsetModel);

                Toast.makeText(DetailAset.this, "Delete Aset", Toast.LENGTH_SHORT).show();
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
