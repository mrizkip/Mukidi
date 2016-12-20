package com.example.mrizkip.mukidi;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.nlopez.smartadapters.utils.ViewEventListener;
import io.nlopez.smartadapters.views.BindableLayout;
import io.nlopez.smartadapters.views.BindableLinearLayout;

/**
 * Created by mrizkip on 12/7/2016.
 */
public class AsetView extends BindableLinearLayout<AsetModel> {
    @BindView(R.id.txtNamaAset) TextView txtNamaAset;
    @BindView(R.id.txtDeskripsiAset) TextView txtDeskripsiAset;

    public AsetView(Context context) {
        super(context);
    }

    @Override
    public int getOrientation() {
        return LinearLayout.VERTICAL;
    }


    @Override
    public int getLayoutId() {
        return R.layout.aset_view;
    }

    @Override
    public void onViewInflated() {
        ButterKnife.bind(this);
        setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
    }

    @Override
    public void bind(final AsetModel asetModel) {
        txtNamaAset.setText(asetModel.getNamaAset());
        txtDeskripsiAset.setText(asetModel.getDeskripsiAset());

        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), DetailAset.class);
                intent.putExtra("idAset", asetModel.getIdAset());
                getContext().startActivity(intent);
            }
        });
    }
}
