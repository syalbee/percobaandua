package com.example.percobaandua.Activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;

import com.example.percobaandua.R;
import com.example.percobaandua.helper.DBMahasiswa;

public class ActivityShow extends AppCompatActivity {

    DBMahasiswa db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        db = new DBMahasiswa(this);

        Cursor res = db.readDataMhs();
        if(res.getCount() == 0){
            showMessage("Error", "Nothing Found");
            return;
        }

        StringBuffer buffer = new StringBuffer();
        while (res.moveToNext()){
            buffer.append("NIM : " + res.getString(0)+"\n");
            buffer.append("NAMA : "+ res.getString(1)+"\n");
            buffer.append("KELAS : "+ res.getString(2)+"\n");
            buffer.append("PROGRAm Studi : "+ res.getString(3)+"\n");
        }
        showMessage("Data", buffer.toString());
    }

    public void showMessage(String title, String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

}