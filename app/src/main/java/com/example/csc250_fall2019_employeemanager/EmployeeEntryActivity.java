package com.example.csc250_fall2019_employeemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EmployeeEntryActivity extends AppCompatActivity
{
    private EditText fnameET, lnameET, height_feetET, height_inchesET, weightET, ageET;
    private static Employee theEmployee = null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_entry);

        this.fnameET = this.findViewById(R.id.fnameET);
        this.lnameET = this.findViewById(R.id.lnameET);
        this.weightET = this.findViewById(R.id.weightET);
        this.ageET = this.findViewById(R.id.ageET);
        this.height_feetET = this.findViewById(R.id.height_feetET);
        this.height_inchesET = this.findViewById(R.id.height_inchesET);
    }

    public void onCreateEmployeeButtonClicked(View v)
    {
        if(this.theEmployee == null) //this is a new employee
        {
            String fname = this.fnameET.getText().toString();
            String lname = this.lnameET.getText().toString();
            double weight = Double.parseDouble(this.weightET.getText().toString());
            int age = Integer.parseInt(this.ageET.getText().toString());
            int height_feet = Integer.parseInt(this.height_feetET.getText().toString());
            int height_inches = Integer.parseInt(this.height_inchesET.getText().toString());
            this.theEmployee = new Employee(fname, lname, height_feet, height_inches, age, weight);

        }
        else //this is an employee we are updating
        {
            this.theEmployee.setFname(this.fnameET.getText().toString());
            this.theEmployee.setLname(this.lnameET.getText().toString());
            this.theEmployee.setHeight_feet(Integer.parseInt(this.height_feetET.getText().toString()));
            this.theEmployee.setHeight_inches(Integer.parseInt(this.height_inchesET.getText().toString()));
            this.theEmployee.setAge(Integer.parseInt(this.ageET.getText().toString()));
            this.theEmployee.setWeight(Double.parseDouble(this.weightET.getText().toString()));

            //allow the create button to also update the current employee object
            //note that you only have getters for your private employee fields
            //currently.  You may need to change that :)
        }
    }
    public void onButtonClick(View view) {

        // get the text to pass
        String info = this.theEmployee.getString();
        // start the SecondActivity
        Intent intent = new Intent(this, EmployeeListActivity.class);
        intent.putExtra(Intent.EXTRA_TEXT, info);
        startActivity(intent);
    }
}
