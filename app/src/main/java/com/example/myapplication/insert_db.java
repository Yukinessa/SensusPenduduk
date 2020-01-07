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

        provinsi = (EditText) findViewById(R.id.et_prov);
        kecamatan = (EditText) findViewById(R.id.et_kec);
        kelurahan = (EditText) findViewById(R.id.et_klrh);
        rt = (EditText) findViewById(R.id.et_rt);
        rw = (EditText) findViewById(R.id.et_rw);
        jumlah_kepala = (EditText) findViewById(R.id.et_jk);
        jumlah_penduduk = (EditText) findViewById(R.id.et_jp);
        submit = (Button) findViewById(R.id.Submit);

        mDatabase = FirebaseDatabase.getInstance().getReference();
//        submit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (!isEmpty(provinsi.getText().toString()) && !isEmpty(kecamatan.getText().toString())
//                        && !isEmpty(kelurahan.getText().toString()) && !isEmpty(rt.getText().toString()) && !isEmpty(rw.getText().toString())
//                        && !isEmpty(jumlah_kepala.getText().toString()) && !isEmpty(jumlah_penduduk.getText().toString()))submitData
//                        (new Sensus(provinsi.getText().toString(),kecamatan.getText().toString(),kelurahan.getText().toString(),rt.getText().toString(),
//                                rw.getText().toString(),jumlah_kepala.getText().toString(),jumlah_penduduk.getText().toString()));
//                else
//                    Toast.makeText(getApplicationContext(), "Form tidak boleh kosong", Toast.LENGTH_SHORT).show();
//
//                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
//                imm.hideSoftInputFromWindow(
//                        provinsi.getWindowToken(),0
//                );
//            }
//        });
    }
    private boolean isEmpty(String s){
        return TextUtils.isEmpty(s);
    }

    private void submitData(Sensus sensus){
        mDatabase.child("sensus").push().setValue(sensus).addOnSuccessListener(this, new OnSuccessListener<Void>() {
            @Override
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
