package com.example.midterm;




import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.nfc.Tag;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.example.midterm.R;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText etdate;
    private TextView tvdate;

    EditText fname;
    EditText Lname;
    Button btnshow;


    DatePickerDialog.OnDateSetListener setListener;
    CRACustomer craCustomer = new CRACustomer();

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etdate = findViewById(R.id.et_date);

        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);
        btnshow= findViewById(R.id.btnShow);
        tvdate= findViewById(R.id.tv_date);
        fname = findViewById(R.id.firstName);
        Lname = findViewById(R.id.lastName);

       craCustomer.fNAme = fname.getText().toString();
       craCustomer.lName = Lname.getText().toString();
       craCustomer.dob = etdate.getText().toString();
//       craCustomer.fullName();
        btnshow.setOnClickListener(this);



        etdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month = month +1;
                        String date = day+ "/"+month+"/"+year;
                        etdate.setText(date);
                    }
                },year,month,day);
                datePickerDialog.show();

            }
        });

    }

    @Override
    public void onClick(View v) {
        System.out.println(craCustomer.fullName());
    }
}



