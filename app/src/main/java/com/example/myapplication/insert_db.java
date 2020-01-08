package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class insert_db extends AppCompatActivity {
    private DatabaseReference mDatabase;
    private EditText provinsi, kecamatan, kelurahan, rt, rw, jumlah_kepala, jumlah_penduduk;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_db);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        provinsi = (EditText) findViewById(R.id.et_prov);
        kecamatan = (EditText) findViewById(R.id.et_kec);
        kelurahan = (EditText) findViewById(R.id.et_klrh);
        rt = (EditText) findViewById(R.id.et_rt);
        rw = (EditText) findViewById(R.id.et_rw);
        jumlah_kepala = (EditText) findViewById(R.id.et_jk);
        jumlah_penduduk = (EditText) findViewById(R.id.et_jp);
        submit = (Button) findViewById(R.id.Submit);

        String Sprovinsi = provinsi.getText().toString();
        String Skecamatan = kecamatan.getText().toString();
        String Skelurahan = kelurahan.getText().toString();
        String Srt= rt.getText().toString();
        String Srw = rw.getText().toString();
        String Sjumlah_kepala = jumlah_kepala.getText().toString();
        String Sjumlah_penduduk = jumlah_penduduk.getText().toString();

        if (Sprovinsi.equals("")){
            provinsi.setError("Please fill this form");
            provinsi.requestFocus();
        }
        else if (Skecamatan.equals("")){
            kecamatan.setError("Please fill this form");
            kecamatan.requestFocus();
        }
        else if (Skelurahan.equals("")){
            kelurahan.setError("Please fill this form");
            kelurahan.requestFocus();
        }
        else if (Srt.equals("")){
            rt.setError("Please fill this form");
            rt.requestFocus();
        }
        else if (Srw.equals("")){
            rw.setError("Please fill this form");
            rw.requestFocus();
        }
        else if (Sjumlah_kepala.equals("")){
            jumlah_kepala.setError("Please fill this form");
            jumlah_kepala.requestFocus();
        }
        else if (Sjumlah_penduduk.equals("")){
            jumlah_penduduk.setError("Please fill this form");
            jumlah_penduduk.requestFocus();
        }
        else {
            submitData(new Sensus(
                    Sprovinsi.toLowerCase(),
                    Skecamatan.toLowerCase(),
                    Skelurahan.toLowerCase(),
                    Srt.toLowerCase(),
                    Srw.toLowerCase(),
                    Sjumlah_kepala.toLowerCase(),
                    Sjumlah_penduduk.toLowerCase())
            );
        }
    }
    private void submitData(Sensus sensus){
        mDatabase.child("sensus").push().setValue(sensus).addOnSuccessListener(this, new OnSuccessListener<Void>() {
            public void onSuccess(Void aVoid) {
                provinsi.setText("");
                kecamatan.setText("");
                kelurahan.setText("");
                rt.setText("");
                rw.setText("");
                jumlah_kepala.setText("");
                jumlah_penduduk.setText("");
                Toast.makeText(getApplicationContext(), "Data Berhasil Disimpan", Toast.LENGTH_SHORT).show();

            }
        });
    }

    public static Intent getActIntent(Activity activity){
        return new Intent(activity, insert_db.class);
    }
}
