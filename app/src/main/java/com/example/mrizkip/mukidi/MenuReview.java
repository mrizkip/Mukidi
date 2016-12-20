package com.example.mrizkip.mukidi;

import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.eazegraph.lib.charts.BarChart;
import org.eazegraph.lib.models.BarModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MenuReview extends AppCompatActivity {
    private ReviewControl reviewControl;
    List<TransaksiModel> transaksiModelList;


    @BindView(R.id.saldoDompet) TextView saldoDompet;

    BarChart barChart;

    Toolbar toolbarReview;
    ActionBar actionBar;


    private UserControl userControl;
    private long saldoUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_review);
        ButterKnife.bind(this);
        toolbarReview = (Toolbar) findViewById(R.id.toolbarReview);

        barChart = (BarChart) findViewById(R.id.barchart);

        reviewControl = new ReviewControl();
        userControl = new UserControl();

        if(toolbarReview != null) {
            setSupportActionBar(toolbarReview);
        }

        actionBar = getSupportActionBar();

        if(actionBar != null) {
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        actionBar.setTitle("REVIEW");

        saldoUser = userControl.getSaldoUser();
        saldoDompet.setText("Rp " + saldoUser);

        loadDataReview();

    }

    private void loadDataReview() {
        transaksiModelList = reviewControl.getReview();
        long nominal;
        for (TransaksiModel transaksi : transaksiModelList) {
            if (transaksi.getJenisTransaksi().equalsIgnoreCase("pemasukan")) {
                nominal = transaksi.getNominalTransaksi();
                barChart.addBar(new BarModel(nominal, 0xff18b272));
            } else if (transaksi.getJenisTransaksi().equalsIgnoreCase("pengeluaran")) {
                nominal = transaksi.getNominalTransaksi();
                barChart.addBar(new BarModel(nominal, 0xffb21818));
            }
        }

        barChart.startAnimation();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
