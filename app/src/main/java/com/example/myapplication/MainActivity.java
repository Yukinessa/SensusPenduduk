package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private Button Insert, Show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Insert = (Button) findViewById(R.id.ins_data);
        Show = (Button) findViewById(R.id.shw_data);

        Insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(insert_db.getActIntent(MainActivity.this));
            }
        });

    }
}
