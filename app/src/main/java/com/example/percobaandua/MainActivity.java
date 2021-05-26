package com.example.percobaandua;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.percobaandua.Activity.ActivityData;

public class MainActivity extends AppCompatActivity {

    EditText etuser, etpassword;
    Button btnLogout, btnlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etuser = (EditText) findViewById(R.id.etUsername);
        etpassword = (EditText) findViewById(R.id.etPassword);
        btnLogout = (Button) findViewById(R.id.btLogout);
        btnlogin = (Button) findViewById(R.id.btLogin);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etuser.getText().toString().trim();
                String password = etpassword.getText().toString().trim();

                if(username.equals("admin") && password.equals("admin")){
                    Intent homepage = new Intent(MainActivity.this, ActivityData.class);
                    startActivity(homepage);
                    Toast.makeText(MainActivity.this, "Login Berhasil ", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Login Gagal ", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


}