package com.app.samplesharedpref.detail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.app.samplesharedpref.R;
import com.app.samplesharedpref.utils.SharedPrefManager;

public class DetailActivity extends AppCompatActivity {

    private TextView tvName;
    private TextView tvJob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvName = findViewById(R.id.tvName);
        tvJob = findViewById(R.id.tvJob);

        /*
        SharedPrefManager.getInstance().getString(SharedPrefManager.Key.User.NAME)
        Ini adalah fungsi untuk memanggil value bedasarkan key yang sudah kita siapkan. Misalnya
        tadi di page sebelumnya kita menyimpan data nama kita kedalam key NAME, maka kalau kita panggil
        hasilnya akan inputan nama dari page sebelumnya.
         */
        String name = SharedPrefManager.getInstance().getString(SharedPrefManager.Key.User.NAME);
        String initName = "Nama kamu " + name;
        tvName.setText(initName);

        String job = SharedPrefManager.getInstance().getString(SharedPrefManager.Key.User.JOB);
        String initJob = "Pekerjaan kamu " + job;
        tvJob.setText(initJob);
    }
}
