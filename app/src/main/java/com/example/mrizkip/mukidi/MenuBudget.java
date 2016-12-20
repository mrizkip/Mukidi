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
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.nlopez.smartadapters.SmartAdapter;

public class MenuBudget extends AppCompatActivity {

    private Toolbar toolbarBudget;
    private FloatingActionButton fabTambahBudget;
    private ActionBar actionBar;

    private RecyclerView recyclerViewBudget;
    TextView emptyBudget;
    TextView emptyBudget2;

    private BudgetControl budgetControl;
    private List<BudgetModel> listBudget;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_budget);
        toolbarBudget = (Toolbar) findViewById(R.id.toolbarBudget);
        fabTambahBudget = (FloatingActionButton) findViewById(R.id.fabTambahBudget);

        recyclerViewBudget = (RecyclerView) findViewById(R.id.recycler_view_budget);
        emptyBudget = (TextView) findViewById(R.id.emptyBudget);
        emptyBudget2 = (TextView) findViewById(R.id.emptyBudget2);


        if(toolbarBudget != null) {
            setSupportActionBar(toolbarBudget);
        }

        actionBar = getSupportActionBar();

        if(actionBar != null) {
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        fabTambahBudget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuBudget.this, TambahBudget.class);
                startActivity(intent);
            }
        });

        actionBar.setTitle("BUDGET");

        budgetControl = new BudgetControl();
        listBudget = budgetControl.getListBudget();

        if(listBudget.isEmpty()) {
            recyclerViewBudget.setVisibility(View.GONE);
            emptyBudget.setVisibility(View.VISIBLE);
            emptyBudget2.setVisibility(View.VISIBLE);
        } else {
            recyclerViewBudget.setVisibility(View.VISIBLE);
            emptyBudget.setVisibility(View.GONE);
            emptyBudget2.setVisibility(View.GONE);

        }

        recyclerViewBudget.setLayoutManager(new LinearLayoutManager(this));
        SmartAdapter.items(listBudget).map(BudgetModel.class, BudgetView.class)
                .into(recyclerViewBudget);
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
