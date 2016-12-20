package com.example.mrizkip.mukidi;

import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.TextView;

import com.daasuu.ahp.AnimateHorizontalProgressBar;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.nlopez.smartadapters.views.BindableLayout;
import io.nlopez.smartadapters.views.BindableRelativeLayout;

/**
 * Created by mrizkip on 12/9/2016.
 */
public class BudgetView extends BindableRelativeLayout<BudgetModel> {
    @BindView(R.id.txtNamaBudget) TextView txtNamaBudget;
    @BindView(R.id.txtRecentNominalBudget) TextView txtRecentNominalBudget;
    @BindView(R.id.txtTotalNominalBudget) TextView txtTotalNominalBudget;
    @BindView(R.id.txtPercentage) TextView txtPercentage;
    @BindView(R.id.txtTglAwalBudget) TextView txtTglAwalBudget;
    @BindView(R.id.txtTglAkhirBudget) TextView txtTglAkhirBudget;
    AnimateHorizontalProgressBar progressBar;

    private BudgetControl budgetControl;

    private long recentBudget;
    private double percentage;

    public BudgetView(Context context) {
        super(context);
    }

    @Override
    public int getLayoutId() {
        return R.layout.budget_view;
    }

    @Override
    public void onViewInflated() {
        ButterKnife.bind(this);
        progressBar = (AnimateHorizontalProgressBar) findViewById(R.id.animatedProgressBar);
        progressBar.setMax(100);
        progressBar.setProgress(0);
        budgetControl = new BudgetControl();
        setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
    }

    @Override
    public void bind(BudgetModel budgetModel) {
        budgetControl.calculateBudget(budgetModel);
        recentBudget = budgetControl.getRecentBudget();
        percentage = budgetControl.getPercentage();
        Log.d("persen", percentage + "");
        Log.d("recent", recentBudget + "");

        txtNamaBudget.setText(budgetModel.getNamaBudget());
        txtRecentNominalBudget.setText("Rp " + String.valueOf(recentBudget));
        txtTotalNominalBudget.setText("Rp " + String.valueOf(budgetModel.getNominalBudget()));
        txtPercentage.setText(String.valueOf(percentage) + "%");
        progressBar.setProgress((int) percentage);

        Log.d("nominal", txtTotalNominalBudget + "");

        String format = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.US);
        txtTglAwalBudget.setText(sdf.format(budgetModel.getTanggalAwalBudget()));
        txtTglAkhirBudget.setText(sdf.format(budgetModel.getTanggalAkhirBudget()));

    }


}
