package com.example.csc250_fall2019_employeemanager;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;

public class EmployeeListActivity extends AppCompatActivity {
    private  TextView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_list);
        this.list= this.findViewById(R.id.employeeList);

        Intent intent = getIntent();
        String text = intent.getStringExtra(Intent.EXTRA_TEXT);

        // use the text in a TextView
        list.setText(text);
    }
}
