package com.example.mrizkip.mukidi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import jonathanfinerty.once.Once;

public class HalamanUtama extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        UserControl userControl = new UserControl();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_utama);

        List<UserModel> userModels = userControl.checkUser();
        if(userModels.isEmpty()) {
            userControl.addUser();
        }

        String showMengaturDompet = "showMengaturDompetTag";

        if (!Once.beenDone(Once.THIS_APP_INSTALL, showMengaturDompet)) {
            startActivity(new Intent(this, MengaturDompet.class));
            Once.markDone(showMengaturDompet);
        }
    }

    public void menuTransaksi(View view) {
        Intent iMenuTransaksi = new Intent(HalamanUtama.this, MenuTransaksi.class);
        startActivity(iMenuTransaksi);
    }

    public void menuAset(View view) {
        Intent iMenuAset = new Intent(HalamanUtama.this, MenuAset.class);
        startActivity(iMenuAset);
    }

    public void menuBudget (View view) {
        Intent iMenuBudget = new Intent(HalamanUtama.this, MenuBudget.class);
        startActivity(iMenuBudget);
    }

    public void menuReview (View view) {
        Intent iMenuReview = new Intent(HalamanUtama.this, MenuReview.class);
        startActivity(iMenuReview);
    }

}
