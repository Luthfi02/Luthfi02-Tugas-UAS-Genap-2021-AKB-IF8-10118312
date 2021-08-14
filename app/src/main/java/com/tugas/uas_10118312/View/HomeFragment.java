// Tanggal Pengerjaan : 8 Agustus 2021
// NIM  : 10118312
// Nama : Luthfi Rifqi Zulfiqar
// Kelas: IF-8

package com.tugas.uas_10118312.View;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.tugas.uas_10118312.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class HomeFragment extends Fragment {
    List<String> arraykota = new ArrayList<>();
    Spinner dropdown;
    ArrayAdapter<String> adapterdropdown;
    View view;
    boolean firstdropdown = true;
    String selectedkota = "";
    Button BtnGo;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);
        arraykota.add("Pilih Kota");
        arraykota.add("Kota Bandung");
        arraykota.add("Kab. Bandung");
        arraykota.add("Kab. Bandung Barat");
        arraykota.add("Kota Cimahi");
        dropdown= view.findViewById(R.id.spinnerbandung);
        BtnGo = view.findViewById(R.id.go_to_list);
        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        adapterdropdown = new ArrayAdapter<>(getActivity().getApplicationContext(), R.layout.list_dropdown, arraykota);
        dropdown.setAdapter(adapterdropdown);

        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position!=0||!firstdropdown){
                    selectedkota=arraykota.get(position);
                    BtnGo.setText("GO TO "+selectedkota+" LIST");
                    if(firstdropdown){
                        arraykota.remove(0);
                        firstdropdown=false;
                    }
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                selectedkota="";
            }
        });
        BtnGo.setOnClickListener(v -> {
            if(!selectedkota.equals("")){
                Intent intent = new Intent(requireContext(), ListActivity.class);
                intent.putExtra("kota", selectedkota);
                startActivity(intent);
            }else{
                Toast.makeText(requireContext(),"PILIH KOTA TERLEBIH DAHULU",Toast.LENGTH_LONG).show();
            }
        });

    }
}