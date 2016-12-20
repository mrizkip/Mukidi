package com.example.mrizkip.mukidi;

import android.content.DialogInterface;
import android.content.Intent;
import android.preference.DialogPreference;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailAset extends AppCompatActivity {
    @BindView(R.id.lokasiAset) TextView lokasiAset;
    @BindView(R.id.tanggalPajakAset) TextView tanggalPajakAset;
    @BindView(R.id.deskripsiAset) TextView deskripsiAset;
    private Toolbar toolbarDetailAset;
    private ActionBar actionBar;

    private AsetControl asetControl;
    private AsetModel asetModel;
    private Long idAsetModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_aset);
        ButterKnife.bind(this);

        toolbarDetailAset = (Toolbar) findViewById(R.id.toolbarDetailAset);
        if (toolbarDetailAset != null) {
            setSupportActionBar(toolbarDetailAset);
        }

        actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        // mendapatkan detail aset
        asetControl = new AsetControl();
        Intent intent = getIntent();
        idAsetModel = intent.getLongExtra("idAset", -1); //ambil dari intent
        asetModel = asetControl.getAsetModel(idAsetModel);
        actionBar.setTitle(asetModel.getNamaAset());
        lokasiAset.setText(asetModel.getLokasiAset());
        String format = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.US);
        tanggalPajakAset.setText(sdf.format(asetModel.getTanggalPajak()));
        deskripsiAset.setText(asetModel.getDeskripsiAset());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detail_aset, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
            case R.id.editAset:
                // Method editAset
                Intent intent = new Intent(DetailAset.this, EditAset.class);
                intent.putExtra("idAset", asetModel.getIdAset());
                startActivity(intent);
                return true;
            case R.id.hapusAset:
                // tampilkan pesan allert
                final AlertDialog alertDialog = new AlertDialog.Builder(DetailAset.this).create();
                alertDialog.setTitle("Hapus Aset?");
                alertDialog.setMessage("Apakah anda yakin akan menghapus aset " + asetModel.getNamaAset() + " ?");
                alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "HAPUS",new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int which) {
                        // hapus aset
                        asetControl.deleteAset(idAsetModel);
                        Toast.makeText(DetailAset.this, "Data Telah Berhasil Dihapus", Toast.LENGTH_SHORT).show();
                        Intent intent1 = new Intent(DetailAset.this, MenuAset.class);
                        startActivity(intent1);
                        finish();
                    }
                });
                alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "BATAL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // membatalkan hapus aset
                        dialog.cancel();
                    }
                });
                alertDialog.show();



            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
