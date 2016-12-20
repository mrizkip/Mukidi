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
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.nlopez.smartadapters.SmartAdapter;

public class MenuAset extends AppCompatActivity {

    private TextView emptyAset;
    private TextView emptyAset2;

    private Toolbar toolbarAset;
    private FloatingActionButton fabTambahAset;
    private ActionBar actionBar;

    private RecyclerView recyclerView;

    private AsetControl asetControl;
    private List<AsetModel> asetModelList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_aset);

        emptyAset = (TextView) findViewById(R.id.emptyAset);
        emptyAset2 = (TextView) findViewById(R.id.emptyAset2);

        toolbarAset = (Toolbar) findViewById(R.id.toolbarAset);
        fabTambahAset = (FloatingActionButton) findViewById(R.id.fabTambahAset);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_aset);

        if(toolbarAset != null) {
            setSupportActionBar(toolbarAset);
        }

        actionBar = getSupportActionBar();

        if(actionBar != null) {
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        fabTambahAset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent ke tambah aset
                Intent intent = new Intent(MenuAset.this, TambahAset.class);
                startActivity(intent);
            }
        });

        asetControl = new AsetControl();
        asetModelList = asetControl.getListAset();

        // jika list aset kosong
        if (asetModelList.isEmpty()) {
            recyclerView.setVisibility(View.GONE);
            emptyAset.setVisibility(View.VISIBLE);
            emptyAset2.setVisibility(View.VISIBLE);
        } else {
            // jika list aset ada
            recyclerView.setVisibility(View.VISIBLE);
            emptyAset.setVisibility(View.GONE);
            emptyAset2.setVisibility(View.GONE);

        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        SmartAdapter.items(asetModelList)
                .map(AsetModel.class, AsetView.class)
                .into(recyclerView);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                break;
            default:
        }
        return super.onOptionsItemSelected(item);
    }
}
