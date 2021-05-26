package com.example.percobaandua.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.percobaandua.R;
import com.example.percobaandua.helper.DBMahasiswa;

public class ActivityData extends AppCompatActivity {

    EditText etNim, etNama, etKelas, etProgramstudi;
    Button btSimpan, btEdit, btHapus, btTampil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        etNim = (EditText) findViewById(R.id.nim);
        etNama = (EditText) findViewById(R.id.nama);
        etKelas = (EditText) findViewById(R.id.kelas);
        etProgramstudi = (EditText) findViewById(R.id.programstudi);

        btSimpan = (Button) findViewById(R.id.btsimpan);
        btEdit = (Button) findViewById(R.id.btedit);
        btHapus = (Button) findViewById(R.id.bthapus);
        btTampil = (Button) findViewById(R.id.bttampil);


        btSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nim = etNim.getText().toString().trim();
                String nama = etNama.getText().toString().trim();
                String kelas = etKelas.getText().toString().trim();
                String programstudi = etProgramstudi.getText().toString().trim();

                DBMahasiswa db = new DBMahasiswa(ActivityData.this);
                boolean insert = db.addMhs(nim, nama, kelas, programstudi);

                if(insert != false){
                    Toast.makeText(ActivityData.this, "Data Berhasil Disimpan", Toast.LENGTH_SHORT).show();
                    etNim.setText("");
                    etNama.setText("");
                    etKelas.setText("");
                    etProgramstudi.setText("");
                } else {
                    Toast.makeText(ActivityData.this, "Data Gagal Disimpan", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btTampil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dataTampil = new Intent(ActivityData.this, ActivityTampil.class);
                startActivity(dataTampil);
            }
        });

        btEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nim = etNim.getText().toString().trim();
                String nama = etNama.getText().toString().trim();
                String kelas = etKelas.getText().toString().trim();
                String programstudi = etProgramstudi.getText().toString().trim();

                DBMahasiswa db = new DBMahasiswa(ActivityData.this);
                boolean update = db.updateData(nim, nama, kelas, programstudi);

                if(update != false){
                    Toast.makeText(ActivityData.this, "Data Berhasil Diperbaharui", Toast.LENGTH_SHORT).show();
                    etNim.setText("");
                    etNama.setText("");
                    etKelas.setText("");
                    etProgramstudi.setText("");
                } else {
                    Toast.makeText(ActivityData.this, "Data Gagal Diperbaharui", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nim = etNim.getText().toString().trim();

                DBMahasiswa db = new DBMahasiswa(ActivityData.this);
                Integer delete = db.deleteData(nim);

                if(delete > 0){
                    Toast.makeText(ActivityData.this, "Data Berhasil Dihapus", Toast.LENGTH_SHORT).show();
                    etNim.setText("");
                    etNama.setText("");
                    etKelas.setText("");
                    etProgramstudi.setText("");
                } else {
                    Toast.makeText(ActivityData.this, "Data Gagal Dihapus", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }


}