package com.example.mrizkip.mukidi;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MenuTransaksi extends AppCompatActivity {

    private Toolbar toolbarTransaksi;
    private FloatingActionButton fabTambahTransaksi;
    private ActionBar actionBar;

    private RecyclerView recyclerViewTransaksi;

    private TransaksiControl transaksiControl;
    private List<TransaksiModel> listTransaksi;

    @BindView(R.id.emptyTransaksi) TextView emptyTransaksi;
    @BindView(R.id.emptyTransaksi2) TextView emptyTransaksi2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_transaksi);
        toolbarTransaksi = (Toolbar) findViewById(R.id.toolbarTransaksi);
        fabTambahTransaksi = (FloatingActionButton) findViewById(R.id.fabTambahTransaksi);
        recyclerViewTransaksi = (RecyclerView) findViewById(R.id.recycler_view_transaksi);
        ButterKnife.bind(this);

        if(toolbarTransaksi != null) {
            setSupportActionBar(toolbarTransaksi);
        }

        actionBar = getSupportActionBar();

        if(actionBar != null) {
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        fabTambahTransaksi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuTransaksi.this, TambahTransaksi.class);
                startActivity(intent);
            }
        });


        transaksiControl = new TransaksiControl();
//        listTransaksi = transaksiControl.getListTransaksi()

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
