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

import butterknife.BindView;
import butterknife.ButterKnife;

public class TambahBudget extends AppCompatActivity {
    Toolbar toolbarTambahBudget;
    @BindView(R.id.namaBudget) EditText namaBudget;
    @BindView(R.id.nominalBudget) EditText nominalBudget;
    @BindView(R.id.kategoriBudget) TextView kategoriBudget;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_budget);
        ButterKnife.bind(this);
        toolbarTambahBudget = (Toolbar) findViewById(R.id.toolbarTambahBudget);

        if(toolbarTambahBudget != null) {
            setSupportActionBar(toolbarTambahBudget);
        }

        actionBar = getSupportActionBar();

        if(actionBar != null) {
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
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
                // Method setBudget()
                Toast.makeText(TambahBudget.this, "Tambah Budget", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
