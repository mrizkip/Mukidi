package com.example.mrizkip.mukidi;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EditAset extends AppCompatActivity {
    private Toolbar toolbarEditAset;
    @BindView(R.id.namaAset) EditText namaAset;
    @BindView(R.id.lokasiAset) EditText lokasiAset;
    @BindView(R.id.tanggalPajakAset) TextView tanggalPajakAset;
    @BindView(R.id.deskripsiAset) EditText deskripsiAset;
    private ActionBar actionBar;

    Calendar calendar = Calendar.getInstance();

    private String strNamaAset;
    private String strLokasiAset;
    private Date dateTanggalPajakAset;
    private String strDeskripsiAset;

    private AsetControl asetControl;
    private AsetModel asetModel;
    private Long idAsetModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_aset);
        ButterKnife.bind(this);

        toolbarEditAset = (Toolbar) findViewById(R.id.toolbarEditAset);
        if (toolbarEditAset != null) {
            setSupportActionBar(toolbarEditAset);
        }

        actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        actionBar.setTitle("Edit Aset");

        // mendapatkan detail aset
        asetControl = new AsetControl();
        Intent intent = getIntent();
        idAsetModel = intent.getLongExtra("idAset", -1); //ambil dari intent detailAset
        asetModel = asetControl.getAsetModel(idAsetModel);
        namaAset.setText(asetModel.getNamaAset());
        lokasiAset.setText(asetModel.getLokasiAset());
        String format = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.US);
        tanggalPajakAset.setText(sdf.format(asetModel.getTanggalPajak()));
        deskripsiAset.setText(asetModel.getDeskripsiAset());

        tanggalPajakAset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePicker();
            }
        });

    }

    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, monthOfYear);
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

            updateLabel();
        }
    };

    private void showDatePicker() {
        new DatePickerDialog(EditAset.this, date, calendar
                .get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)).show();
    }

    private void updateLabel() {
        String format = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.US);
        tanggalPajakAset.setText((sdf.format(calendar.getTime())));
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
                finish();
                return true;
            case R.id.selesaiTambahAset:
                // Method editAset()
                strNamaAset = namaAset.getText().toString();
                strLokasiAset = lokasiAset.getText().toString();
                dateTanggalPajakAset = calendar.getTime();
                strDeskripsiAset = deskripsiAset.getText().toString();

                if(strNamaAset.trim().isEmpty() || strLokasiAset.isEmpty() || strDeskripsiAset.isEmpty() ) {
                    Toast.makeText(EditAset.this, "Anda harus mengisikan semua form", Toast.LENGTH_SHORT).show();
                } else {
                    asetControl.editAset(idAsetModel, strNamaAset, strLokasiAset, dateTanggalPajakAset, strDeskripsiAset);
                    Intent intent = new Intent(EditAset.this, DetailAset.class);
                    intent.putExtra("idAset", idAsetModel);
                    startActivity(intent);
                    finish();
                }

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
