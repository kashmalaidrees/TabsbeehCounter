package com.example.tasbeehcountere;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AddTasbeeh extends AppCompatActivity {

    Button addTasbeeh;

    CheckBox kalmac, darudc, astigfarc;

    TextView date;

    EditText kalma, darud, astigfar;

    Intent intet;
    String ck = "0", cd = "0", ca = "0";
    public DBHandler db;


    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_tasbeeh);


        intet = getIntent();
        db = new DBHandler(this);

        @SuppressLint("SimpleDateFormat") DateFormat formatter = new SimpleDateFormat("dd/MM/yy");
        Calendar obj = Calendar.getInstance();
        String dateobj = formatter.format(obj.getTime());

       // ClearTasbeehCount
        addTasbeeh = findViewById(R.id.ClearTasbeehCount);
        date = findViewById(R.id.Date);

        kalmac = findViewById(R.id.kalmacheck);
        darudc = findViewById(R.id.darudcheck);
        astigfarc = findViewById(R.id.astigfarcheck);

        kalma = findViewById(R.id.kalmaCount);
        darud = findViewById(R.id.darudCount);
        astigfar = findViewById(R.id.astigfarCount);


        date.setText(dateobj);


        addTasbeeh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (kalmac.isChecked())
                {
                    ck =  kalma.getText().toString();
                    if (ck.equals(""))
                    {
                        ck = "0";
                    }
                }
                if (darudc.isChecked())
                {
                    cd =  darud.getText().toString();
                    if (cd.equals(""))
                    {
                        cd = "0";
                    }
                }
                if (astigfarc.isChecked())
                {
                    ca =  astigfar.getText().toString();
                    if (ca.equals(""))
                    {
                        ca = "0";
                    }
                }

                Tasbeeh tas = new Tasbeeh(dateobj, ck,cd, ca);

                db.insertTasbeeh(tas);

                Toast.makeText(AddTasbeeh.this, "Tasbeeh Added Successfully.", Toast.LENGTH_LONG);

                intet = new Intent(AddTasbeeh.this, MainActivity.class);
                startActivity(intet);

            }
        });


    }
}