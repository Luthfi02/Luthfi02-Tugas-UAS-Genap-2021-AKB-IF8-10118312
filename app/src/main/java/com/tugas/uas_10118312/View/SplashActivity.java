// Tanggal Pengerjaan : 8 Agustus 2021
// NIM  : 10118312
// Nama : Luthfi Rifqi Zulfiqar
// Kelas: IF-8

package com.tugas.uas_10118312.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

import com.tugas.uas_10118312.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);
        final Handler handler = new Handler();
        String Allmessage = getIntent().getStringExtra("EXTRA_SESSION_MESSAGE");
        handler.postDelayed(() -> {
            startActivity(new Intent(getApplicationContext(), ViewPagerActivity.class));
            finish();
        }, 2000L);
    }
}