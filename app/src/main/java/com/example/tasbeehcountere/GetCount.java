package com.example.tasbeehcountere;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class GetCount extends AppCompatActivity {

    Intent intet;

    TextView date, kalmaview, darudview, astigfarview;
    DBHandler db;
    String fromDate, todate;
    Button clearBtn;

    @SuppressLint({"MissingInflatedId", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_count);

        intet = getIntent();
        db = new DBHandler(this);



        @SuppressLint("SimpleDateFormat") DateFormat formatter = new SimpleDateFormat("dd/MM/yy");
        Calendar obj = Calendar.getInstance();
        String dateobj = formatter.format(obj.getTime());

        date = findViewById(R.id.Date);
        date.setText("Today date: " + dateobj);

        clearBtn = findViewById(R.id.ClearTasbeehCount);

        kalmaview  = findViewById(R.id.kalmaView);
        darudview = findViewById(R.id.darudView);
        astigfarview = findViewById(R.id.astigfarView);

        List<Tasbeeh> data = db.getCountofAll();

        if (data.size() > 0)
        {
            List<Tasbeeh> fromdatedata = db.getFromDate();
            List<Tasbeeh> todatedata = db.getToDate();
            fromDate = fromdatedata.get(fromdatedata.size()-1).getDate();
            todate = fromdatedata.get(todatedata.size()-1).getDate();
            kalmaview.setText(data.get(data.size()-1).getCountKalma());
            darudview.setText(data.get(data.size()-1).getCountDarud());
            astigfarview.setText(data.get(data.size()-1).getCountAstigfar());
            date.setText(fromDate + " to " + todate);
        }

        clearBtn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint({"ShowToast", "SetTextI18n"})
            @Override
            public void onClick(View v) {
                db.emptytable();

                kalmaview.setText("--");
                darudview.setText("--");
                astigfarview.setText("--");
                date.setText("Today date: " + dateobj);

                Toast.makeText(GetCount.this, "Tasbeeh Cleared ", Toast.LENGTH_LONG);
            }
        });


    }
}