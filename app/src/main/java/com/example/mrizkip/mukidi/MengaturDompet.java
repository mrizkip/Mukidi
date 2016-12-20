package com.example.mrizkip.mukidi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MengaturDompet extends AppCompatActivity {
    private UserControl userControl;

    @BindView(R.id.nominalSaldo)
    EditText saldoAwal;
    @BindView(R.id.buttonLanjut)
    Button buttonLanjut;

    long saldo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mengatur_dompet);
        ButterKnife.bind(this);

        userControl = new UserControl();
        List<UserModel> userModels = userControl.checkUser();
        if(userModels.isEmpty()) {
            userControl.addUser();
        }

        buttonLanjut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // cek inputan
                if(saldoAwal.getText().toString().isEmpty()) {
                    saldo = 0;
                } else {
                    saldo = Long.parseLong(saldoAwal.getText().toString());
                }

                // mengatur saldo dompet user
                userControl.updateSaldoUser(saldo);

                Intent intent = new Intent(MengaturDompet.this, HalamanUtama.class);
                startActivity(intent);
                finish();
            }
        });


    }
}
