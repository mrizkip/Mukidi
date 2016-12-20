package com.example.mrizkip.mukidi;

import android.content.Intent;
import android.os.StrictMode;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TambahTransaksi extends AppCompatActivity {
    private TransaksiControl transaksiControl;

    @BindView(R.id.nominalTransaksi)
    TextView txtNominalTransaksi;

    private Toolbar toolbarTambahTransaksi;
    private ActionBar actionBar;

    public String jenisTransaksi;
    public String kategoriTransaksi;
    private long nominalTransaksi;
    private Date tanggalTransaksi;

    Calendar calendar = Calendar.getInstance();

    FragmentPagerItemAdapter adapter;

    TambahPemasukan tambahPemasukan;
    TambahPengeluaran tambahPengeluaran;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_transaksi);
        toolbarTambahTransaksi = (Toolbar) findViewById(R.id.toolbarTambahTransaksi);
        ButterKnife.bind(this);

        transaksiControl = new TransaksiControl();

        if(toolbarTambahTransaksi != null) {
            setSupportActionBar(toolbarTambahTransaksi);
        }

        actionBar = getSupportActionBar();
        actionBar.setTitle("TAMBAH TRANSAKSI");

        if(actionBar != null) {
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(), FragmentPagerItems.with(this)
                .add("TAMBAH PEMASUKAN", TambahPemasukan.class)
                .add("TAMBAH PENGELUARAN", TambahPengeluaran.class)
                .create());
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter);
        SmartTabLayout viewPagerTab = (SmartTabLayout) findViewById(R.id.viewpagertab);
        viewPagerTab.setViewPager(viewPager);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position == 0) {
                    tambahPemasukan = (TambahPemasukan) adapter.getPage(0);
                    tambahPemasukan.selectDefault();
                } else if(position == 1) {
                    tambahPengeluaran = (TambahPengeluaran) adapter.getPage(1);
                    tambahPengeluaran.selectDefault();
                }
                updateSelection("", "");
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        updateSelection("", "");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.tambah_transaksi, menu);
        return true;
    }

    public void updateSelection(String jenisTransaksi, String kategoriTransaksi) {
        this.jenisTransaksi = jenisTransaksi;
        this.kategoriTransaksi = kategoriTransaksi;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
            case R.id.selesaiTambahTransaksi:
                String nominal = txtNominalTransaksi.getText().toString();
                if(nominal.isEmpty()) nominal = "0";
                nominalTransaksi = Long.parseLong(nominal);
                tanggalTransaksi = calendar.getTime();

                // Method addTransaksi()
                if (nominalTransaksi == 0) {
                    Toast.makeText(TambahTransaksi.this, "Anda harus menginputkan nominal transaksi", Toast.LENGTH_SHORT).show();
                } else if (kategoriTransaksi.isEmpty()) {
                    Toast.makeText(TambahTransaksi.this, "Anda harus memilih kategori", Toast.LENGTH_SHORT).show();
                }

                if (jenisTransaksi.equals("Pemasukan")) {
                    transaksiControl.addPemasukan(jenisTransaksi, nominalTransaksi, kategoriTransaksi, tanggalTransaksi);
                    Intent intent = new Intent(TambahTransaksi.this, MenuTransaksi.class);
                    startActivity(intent);
                    finish();
                } else if (jenisTransaksi.equals("Pengeluaran")) {
                    transaksiControl.addPengeluaran(jenisTransaksi, nominalTransaksi, kategoriTransaksi, tanggalTransaksi);
                    Intent intent = new Intent(TambahTransaksi.this, MenuTransaksi.class);
                    startActivity(intent);
                    finish();
                }


                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
