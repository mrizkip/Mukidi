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

public class TambahBudget extends AppCompatActivity {
    Toolbar toolbarTambahBudget;
    @BindView(R.id.namaBudget) EditText namaBudget;
    @BindView(R.id.nominalBudget) EditText nominalBudget;
    @BindView(R.id.kategoriBudget) TextView kategoriBudget;
    @BindView(R.id.tanggalAwalBudget) TextView tanggalAwalBudget;
    @BindView(R.id.tanggalAkhirBudget) TextView tanggalAkhirBudget;
    ActionBar actionBar;

    private BudgetControl budgetControl;

    String strNamaBudget;
    long longNominalBudget;
    String strKategoriBudget;
    Date dtTanggalAwalBudget;
    Date dtTanggalAkhirBudget;

    Calendar calendar1 = Calendar.getInstance();
    Calendar calendar2 = Calendar.getInstance();

    private boolean sudahPilihKategori = false;
    private boolean sudahPilihTanggalAwal = false;
    private boolean sudahPilihTanggalAkhir = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_budget);
        ButterKnife.bind(this);
        toolbarTambahBudget = (Toolbar) findViewById(R.id.toolbarTambahBudget);

        budgetControl = new BudgetControl();

        if(toolbarTambahBudget != null) {
            setSupportActionBar(toolbarTambahBudget);
        }

        actionBar = getSupportActionBar();
        actionBar.setTitle("TAMBAH BUDGET");

        if(actionBar != null) {
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        kategoriBudget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // tampil fragment pilih kategori
                Intent intent = new Intent(TambahBudget.this, PilihKategoriBudget.class);
                startActivityForResult(intent, 1);
            }
        });

        tanggalAwalBudget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePicker1();
            }
        });
        tanggalAkhirBudget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePicker2();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            strKategoriBudget = data.getStringExtra("kategori");
            kategoriBudget.setText(strKategoriBudget);
            sudahPilihKategori = true;
        }
    }

    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            calendar1.set(Calendar.YEAR, year);
            calendar1.set(Calendar.MONTH, monthOfYear);
            calendar1.set(Calendar.DAY_OF_MONTH, dayOfMonth);

            updateLabel1();
            sudahPilihTanggalAwal = true;
        }
    };

    DatePickerDialog.OnDateSetListener date2 = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            calendar2.set(Calendar.YEAR, year);
            calendar2.set(Calendar.MONTH, monthOfYear);
            calendar2.set(Calendar.DAY_OF_MONTH, dayOfMonth);

            updateLabel2();
            sudahPilihTanggalAkhir = true;
        }
    };

    private void showDatePicker1() {
        new DatePickerDialog(TambahBudget.this, date, calendar1
                .get(Calendar.YEAR), calendar1.get(Calendar.MONTH),
                calendar1.get(Calendar.DAY_OF_MONTH)).show();
    }

    private void showDatePicker2() {
        new DatePickerDialog(TambahBudget.this, date2, calendar2
                .get(Calendar.YEAR), calendar2.get(Calendar.MONTH),
                calendar1.get(Calendar.DAY_OF_MONTH)).show();
    }


    private void updateLabel1() {
        String format = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.US);
        tanggalAwalBudget.setText((sdf.format(calendar1.getTime())));
    }

    private void updateLabel2() {
        String format = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.US);
        tanggalAkhirBudget.setText((sdf.format(calendar2.getTime())));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.tambah_budget, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
            case R.id.selesaiTambahBudget:
                String nominal = nominalBudget.getText().toString();
                if(nominal.isEmpty()) nominal = "0";

                strNamaBudget = namaBudget.getText().toString();
                longNominalBudget = Long.parseLong(nominal);
                strKategoriBudget = kategoriBudget.getText().toString();
                dtTanggalAwalBudget = calendar1.getTime();
                dtTanggalAkhirBudget = calendar2.getTime();

                if (strNamaBudget.isEmpty() || longNominalBudget == 0 || strKategoriBudget.isEmpty()
                        || !sudahPilihKategori || !sudahPilihTanggalAwal || !sudahPilihTanggalAkhir) {
                    Toast.makeText(TambahBudget.this, "Anda harus mengisikan semua form", Toast.LENGTH_SHORT).show();
                } else {
                    budgetControl.addBudget(strNamaBudget, longNominalBudget, strKategoriBudget, dtTanggalAwalBudget, dtTanggalAkhirBudget);
                    Intent intent = new Intent(TambahBudget.this, MenuBudget.class);
                    startActivity(intent);
                    finish();
                }



                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
