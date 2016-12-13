package com.example.mrizkip.mukidi;

import android.content.Context;

import io.nlopez.smartadapters.views.BindableLayout;
import io.nlopez.smartadapters.views.BindableRelativeLayout;

/**
 * Created by mrizkip on 12/9/2016.
 */
public class BudgetView extends BindableRelativeLayout {

    public BudgetView(Context context) {
        super(context);
    }

    @Override
    public int getLayoutId() {
        return R.layout.budget_view;
    }

    @Override
    public void bind(Object o) {

    }
}
