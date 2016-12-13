package com.example.mrizkip.mukidi;

import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EditAset extends AppCompatActivity {
    private AsetControl asetControl;

    private Toolbar toolbarEditAset;
    @BindView(R.id.namaAset) EditText namaAset;
    @BindView(R.id.lokasiAset) EditText lokasiAset;
    @BindView(R.id.tanggalPajakAset) TextView tanggalPajakAset;
    @BindView(R.id.deskripsiAset) EditText deskripsiAset;
    private ActionBar actionBar;

    Calendar calendar = Calendar.getInstance();

    String strNamaAset;
    String strLokasiAset;
    Date dateTanggalPajakAset;
    String strDeskripsiAset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_aset);
        ButterKnife.bind(this);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.edit_aset, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
            case R.id.selesaiTambahAset:
                // Method editAset()
                strNamaAset = namaAset.getText().toString();
                strLokasiAset = lokasiAset.getText().toString();
                dateTanggalPajakAset = calendar.getTime();
                strDeskripsiAset = deskripsiAset.getText().toString();

                if(strNamaAset.isEmpty() || strLokasiAset.isEmpty() || strDeskripsiAset.isEmpty()) {
                    Toast.makeText(EditAset.this, "Anda harus mengisikan semua form", Toast.LENGTH_SHORT).show();
                } else {
//                    asetControl.editAset(idAsetModel, strNamaAset, strLokasiAset, dateTanggalPajakAset, strDeskripsiAset);
                }

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
