package com.example.tasbeehcountere;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Button addtas , getcount;
    TextView date;
    Intent intent;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        @SuppressLint("SimpleDateFormat") DateFormat formatter = new SimpleDateFormat("dd/MM/yy");
        Calendar obj = Calendar.getInstance();
        String dateobj = formatter.format(obj.getTime());

        date = findViewById(R.id.Date);
        addtas = findViewById(R.id.Add_Tasbeeh);
        getcount = findViewById(R.id.get_count);

//       date.setText(dateobj);
//
        addtas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this,AddTasbeeh.class);
                startActivity(intent);

            }
        });
//
        getcount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent= new Intent(MainActivity.this, GetCount.class);
                startActivity(intent);


            }
        });
    }
}