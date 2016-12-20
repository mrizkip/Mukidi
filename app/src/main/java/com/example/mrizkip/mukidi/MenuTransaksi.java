package com.example.mrizkip.mukidi;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.nlopez.smartadapters.SmartAdapter;

public class MenuTransaksi extends AppCompatActivity {
    private TransaksiControl transaksiControl;

    private Toolbar toolbarTransaksi;
    private FloatingActionButton fabTambahTransaksi;
    private ActionBar actionBar;

    private RecyclerView recyclerViewTransaksi;

    private UserControl userControl;
    private List<Object> listObject;

    @BindView(R.id.txtSaldoDompet) TextView txtSaldoDompet;
    long saldoDompet;

    TextView emptyTransaksi;
    TextView emptyTransaksi2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_transaksi);
        toolbarTransaksi = (Toolbar) findViewById(R.id.toolbarTransaksi);
        fabTambahTransaksi = (FloatingActionButton) findViewById(R.id.fabTambahTransaksi);
        recyclerViewTransaksi = (RecyclerView) findViewById(R.id.recycler_view_transaksi);
        ButterKnife.bind(this);

        userControl = new UserControl();
        saldoDompet =  userControl.getSaldoUser();
        txtSaldoDompet.setText("Rp "+ saldoDompet);

        emptyTransaksi = (TextView) findViewById(R.id.emptyTransaksi);
        emptyTransaksi2 = (TextView) findViewById(R.id.emptyTransaksi2);

        if(toolbarTransaksi != null) {
            setSupportActionBar(toolbarTransaksi);
        }

        actionBar = getSupportActionBar();

        if(actionBar != null) {
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        actionBar.setTitle("TRANSAKSI");

        fabTambahTransaksi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuTransaksi.this, TambahTransaksi.class);
                startActivity(intent);
            }
        });


        transaksiControl = new TransaksiControl();
        listObject = transaksiControl.getDataToShow();

        if(listObject.isEmpty()) {
            recyclerViewTransaksi.setVisibility(View.GONE);
            emptyTransaksi.setVisibility(View.VISIBLE);
            emptyTransaksi2.setVisibility(View.VISIBLE);
        } else {
            recyclerViewTransaksi.setVisibility(View.VISIBLE);
            emptyTransaksi.setVisibility(View.GONE);
            emptyTransaksi2.setVisibility(View.GONE);
        }

        recyclerViewTransaksi.setLayoutManager(new LinearLayoutManager(this));
        SmartAdapter.items(listObject)
                .map(TanggalTransaksiModel.class, TanggalView.class)
                .map(TransaksiModel.class, TransaksiView.class)
                .into(recyclerViewTransaksi);
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
