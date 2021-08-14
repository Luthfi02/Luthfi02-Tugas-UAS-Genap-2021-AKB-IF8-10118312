// Tanggal Pengerjaan : 8 Agustus 2021
// NIM  : 10118312
// Nama : Luthfi Rifqi Zulfiqar
// Kelas: IF-8

package com.tugas.uas_10118312.View.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tugas.uas_10118312.Model.Wisata;
import com.tugas.uas_10118312.R;
import com.tugas.uas_10118312.View.WisataActivity;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class ListWisataAdapter extends RecyclerView.Adapter<ListWisataAdapter.ViewHolder>{

    private ArrayList<Wisata> wisatas;
    private Context context;
    private Activity act;

    public ListWisataAdapter(ArrayList<Wisata> wisata, Context context, Activity act){
        this.wisatas =  wisata;
        this.context = context;
        this.act = act;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }
    @NonNull
    @Override
    public void onBindViewHolder(@NonNull ListWisataAdapter.ViewHolder holder, int position) {
        Wisata wisata = wisatas.get(position);
        Glide.with(context).load(wisata.getImg()).into(holder.foto);
        holder.nama.setText(wisata.getNama());
        holder.deskripsi.setText(wisata.getDesc());
        holder.item.setOnClickListener(v -> {
            Intent intent = new Intent(act, WisataActivity.class);
            intent.putExtra("nama", wisata.getNama());
            intent.putExtra("deskripsi", wisata.getDesc());
            intent.putExtra("foto", wisata.getImg());
            intent.putExtra("lat", wisata.getLatLng().latitude);
            intent.putExtra("lng", wisata.getLatLng().longitude);
            act.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return wisatas.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nama;
        TextView deskripsi;
        ImageView foto;
        ConstraintLayout item;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nama = itemView.findViewById(R.id.listnama);
            deskripsi = itemView.findViewById(R.id.listdeskripsi);
            foto = itemView.findViewById(R.id.listfoto);
            item = itemView.findViewById(R.id.item);
        }
    }

}
