package com.example.apifirst;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DashboardActivity extends AppCompatActivity{
    private Button btnShowAll, btnRegister, btnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        btnShowAll = findViewById(R.id.btnShowAll);
        btnRegister = findViewById(R.id.btnRegister);
        btnSearch = findViewById(R.id.btnSearch);


        btnShowAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(mainIntent);

            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(getApplicationContext(),RegisterActivity.class);
                startActivity(mainIntent);


            }
        });
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(getApplicationContext(),SearchActivity.class);
                startActivity(mainIntent);

            }
        });


    }


}
