// Tanggal Pengerjaan : 8 Agustus 2021
// NIM  : 10118312
// Nama : Luthfi Rifqi Zulfiqar
// Kelas: IF-8

package com.tugas.uas_10118312.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.tugas.uas_10118312.R;

import org.jetbrains.annotations.NotNull;

public class WisataActivity extends AppCompatActivity implements OnMapReadyCallback {
    GoogleMap maps;
    String nama, deskripsi, foto;
    double lat,lng;
    LatLng latLng;
    TextView tvNama, tvDeskripsi;
    ImageView ivFoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wisata);
        tvNama = findViewById(R.id.namawisata);
        tvDeskripsi = findViewById(R.id.deskripsiwisata);
        ivFoto = findViewById(R.id.wisatafoto);
        nama = getIntent().getStringExtra("nama");
        deskripsi = getIntent().getStringExtra("deskripsi");
        foto = getIntent().getStringExtra("foto");
        lat = getIntent().getDoubleExtra("lat",0);
        lng = getIntent().getDoubleExtra("lng",0);
        latLng = new LatLng(lat,lng);
        tvNama.setText(nama);
        tvDeskripsi.setText(deskripsi);
        Glide.with(getApplicationContext()).load(foto).into(ivFoto);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapwisata);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull @NotNull GoogleMap googleMap) {
        maps = googleMap;

        maps.addMarker(
                new MarkerOptions()
                        .position(latLng)
                        .title(nama)
        );
        maps.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,16f));
    }
}