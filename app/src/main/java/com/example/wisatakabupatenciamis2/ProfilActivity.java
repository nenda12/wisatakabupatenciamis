package com.example.wisatakabupatenciamis2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class ProfilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
    }

    public void panggil(View view) {
        String nomor = "082321647199" ;
        Intent panggil = new Intent(Intent. ACTION_DIAL);
        panggil.setData(Uri. fromParts("tel",nomor,null));
        startActivity(panggil);
    }

    public void buka(View view) {
        String url = "https://www.facebook.com/nenda12" ;
        Intent bukabrowser = new Intent(Intent. ACTION_VIEW);
        bukabrowser.setData(Uri. parse(url));
        startActivity(bukabrowser);
    }

    public void ig(View view) {
        String url = "https://www.instagram.com/a_nenda" ;
        Intent bukaig = new Intent(Intent. ACTION_VIEW);
        bukaig.setData(Uri. parse(url));
        startActivity(bukaig);
    }


}