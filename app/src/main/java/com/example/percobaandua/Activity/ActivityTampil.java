package com.example.percobaandua.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import com.example.percobaandua.R;
import com.example.percobaandua.adapter.MhsAdapter;
import com.example.percobaandua.helper.DBMahasiswa;

import java.util.ArrayList;

public class ActivityTampil extends AppCompatActivity {

    RecyclerView rvMhs;

    DBMahasiswa db;
    ArrayList<String> nim, nama, kelas, programstudi;
    MhsAdapter mhsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil);

        rvMhs = findViewById(R.id.rvMahasiswa);

        db = new DBMahasiswa(ActivityTampil.this);
        nim = new ArrayList<>();
        nama = new ArrayList<>();
        kelas = new ArrayList<>();
        programstudi = new ArrayList<>();
//
//
//
        storedisplayMhs();
        mhsAdapter = new MhsAdapter(ActivityTampil.this, nim, nama, kelas, programstudi);
        rvMhs.setAdapter(mhsAdapter);
        rvMhs.setLayoutManager(new LinearLayoutManager(ActivityTampil.this));


    }


    void storedisplayMhs(){
        Cursor cursor = db.readDataMhs();

        if(cursor.getCount() == 0){
            Toast.makeText(ActivityTampil.this, "Data kosong", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()){
                nim.add(cursor.getString(0));
                nama.add("Nama : " + cursor.getString(1));
                kelas.add("Kelas : " + cursor.getString(2));
                programstudi.add("Program Studi : " + cursor.getString(3));
            }
        }
    }
}