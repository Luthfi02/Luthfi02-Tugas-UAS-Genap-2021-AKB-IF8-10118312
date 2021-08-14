// Tanggal Pengerjaan : 8 Agustus 2021
// NIM  : 10118312
// Nama : Luthfi Rifqi Zulfiqar
// Kelas: IF-8

package com.tugas.uas_10118312.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.google.android.material.tabs.TabLayout;
import com.tugas.uas_10118312.R;

import com.tugas.uas_10118312.View.Adapter.*;

public class ViewPagerActivity extends AppCompatActivity {
    private ViewPagerAdapter VPAdapter;
    private ViewPager VP;
    private Button BtnStart;
    TabLayout TabVPIndicator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        TabVPIndicator = findViewById(R.id.tab_indicator);
        BtnStart = findViewById(R.id.buttonstart);
        VP = findViewById(R.id.view_pager_image);
        VPAdapter = new ViewPagerAdapter(this);

        VP.setAdapter(VPAdapter);
        TabVPIndicator.setupWithViewPager(VP);
        BtnStart.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        });
    }
}