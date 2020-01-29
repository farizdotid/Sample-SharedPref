package com.app.samplesharedpref.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.app.samplesharedpref.R;
import com.app.samplesharedpref.detail.DetailActivity;
import com.app.samplesharedpref.utils.SharedPrefManager;

public class MainActivity extends AppCompatActivity {

    private EditText etName;
    private EditText etJob;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etJob = findViewById(R.id.etJob);
        btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etName.getText().toString();
                String job = etJob.getText().toString();

                /*
                Mengecek apakah form nama dan pekerjaan sudah diisi apa belum. Jika sudah diisi
                maka akan melakukan "proses simpan" ke Shared Preferences. Jika belum diisi
                maka akan memunculkan popup message.
                 */
                if (TextUtils.isEmpty(name) || TextUtils.isEmpty(job)) {
                    Toast.makeText(MainActivity.this, "Form tidak boleh kosong",
                            Toast.LENGTH_SHORT).show();
                } else {
                    /*
                    Menyimpan value kedalam key shared preferences.
                    Misalnya Key nya NAME maka value yang diisi kedalam NAME tersebut adalah hasil
                    inputan dari form nama.
                     */
                    SharedPrefManager.getInstance().put(SharedPrefManager.Key.User.NAME, name);
                    SharedPrefManager.getInstance().put(SharedPrefManager.Key.User.JOB, job);

                    startActivity(new Intent(MainActivity.this, DetailActivity.class));
                }
            }
        });
    }
}
