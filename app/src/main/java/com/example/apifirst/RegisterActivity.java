package com.example.apifirst;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {
    private EditText etID, etName, etSalary, etAge, etProfile;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etID = findViewById(R.id.etID);
        etName = findViewById(R.id.etName);
        etSalary = findViewById(R.id.etSalary);
        etAge = findViewById(R.id.etAge);
        etProfile = findViewById(R.id.etProfile);

        btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name,profile;
                int id,age;
                float salary;

                name = etName.getText().toString();
                profile = etProfile.getText().toString();
                id = Integer.parseInt(etID.getText().toString());
                age =Integer.parseInt(etAge.getText().toString());
                salary =Float.parseFloat(etSalary.getText().toString());



            }
        });
    }
}
