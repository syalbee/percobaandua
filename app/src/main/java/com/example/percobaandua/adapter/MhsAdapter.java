package com.example.percobaandua.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.percobaandua.R;

import java.util.ArrayList;

public class MhsAdapter extends RecyclerView.Adapter<MhsAdapter.MyViewHolder> {

     Context context;
     ArrayList nim, nama, kelas, programstudi;

    public MhsAdapter(Context context, ArrayList nim, ArrayList nama, ArrayList kelas, ArrayList programstudi){

        this.context = context;
        this.nim = nim;
        this.nama = nama;
        this.kelas = kelas;
        this.programstudi = programstudi;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view =  inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.aNim.setText(String.valueOf(nim.get(position)));
        holder.aNama.setText(String.valueOf(nama.get(position)));
        holder.aKelas.setText(String.valueOf(kelas.get(position)));
        holder.aProgramstudi.setText(String.valueOf(programstudi.get(position)));
    }

    @Override
    public int getItemCount() {
        return nim.size();
//        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView aNim, aNama, aKelas, aProgramstudi;

        public MyViewHolder(@NonNull View itemView){
            super((itemView));

            aNim = itemView.findViewById(R.id.tvNim);
            aNama = itemView.findViewById(R.id.tvNama);
            aKelas = itemView.findViewById(R.id.tvKelas);
            aProgramstudi = itemView.findViewById(R.id.tvPS);
        }
    }
}
