package com.example.mrizkip.mukidi;

import android.app.DatePickerDialog;
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

public class TambahAset extends AppCompatActivity {
    private AsetControl asetControl;

    private Toolbar toolbarAset;
    private EditText namaAset;
    private EditText lokasiAset;
    private TextView tanggalPajakAset;
    private EditText deskripsiAset;
    private TextView iconNamaAset;

    private ActionBar actionBar;

    Calendar calendar = Calendar.getInstance();

    String strNamaAset;
    String strLokasiAset;
    Date dateTanggalPajakAset;
    String strDeskripsiAset;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_aset);
        namaAset = (EditText) findViewById(R.id.namaAset);
        lokasiAset = (EditText) findViewById(R.id.lokasiAset);
        tanggalPajakAset = (TextView) findViewById(R.id.tanggalPajakAset);
        deskripsiAset = (EditText) findViewById(R.id.deskripsiAset);
        iconNamaAset = (TextView) findViewById(R.id.iconNamaAset);

        asetControl = new AsetControl();

        toolbarAset = (Toolbar) findViewById(R.id.toolbarTambahAset);
        if (toolbarAset != null) {
            setSupportActionBar(toolbarAset);
        }

        actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        tanggalPajakAset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePicker();
            }
        });
    }

    private void showDatePicker() {
        new DatePickerDialog(getApplicationContext(), date, calendar
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
        getMenuInflater().inflate(R.menu.tambah_aset, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
            case R.id.selesaiTambahAset:
                // Method addAset()
                strNamaAset = namaAset.getText().toString();
                strLokasiAset = lokasiAset.getText().toString();
                dateTanggalPajakAset = calendar.getTime();
                strDeskripsiAset = deskripsiAset.getText().toString();

                if(strNamaAset.isEmpty() || strLokasiAset.isEmpty() || strDeskripsiAset.isEmpty()) {
                    Toast.makeText(TambahAset.this, "Anda harus mengisikan semua form", Toast.LENGTH_SHORT).show();
                } else {
                    asetControl.addAset(strNamaAset, strLokasiAset, dateTanggalPajakAset, strDeskripsiAset);
                }

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
