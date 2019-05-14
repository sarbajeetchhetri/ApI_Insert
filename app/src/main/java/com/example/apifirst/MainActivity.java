package com.example.apifirst;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ClientAPI.EmployeeAPI;
import adapter.EmployeeAdapter;
import model.Employee;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);


        Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl("http://dummy.restapiexample.com/api/v1/")
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();

        EmployeeAPI employeeAPI = retrofit.create(EmployeeAPI.class);

        Call<List<Employee>> listCall = employeeAPI.getEmployee();

        listCall.enqueue(new Callback<List<Employee>>() {
            @Override
            public void onResponse(Call<List<Employee>> call, Response<List<Employee>> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"Code :"+response.code(),Toast.LENGTH_SHORT).show();
                    return;
                }

                List<Employee> employeeList = response.body();
                List<Employee> newEmployeeList= new ArrayList<>();
                for (Employee employee : employeeList){
                   Employee employee1 = new Employee(
                           employee.getId(),
                           employee.getEmployee_name(),
                           employee.getEmployee_salary(),
                           employee.getEmployee_age(),
                           employee.getProfile_image()
                   );
                   newEmployeeList.add(employee1);



                }
                EmployeeAdapter employeeAdapter = new EmployeeAdapter(getApplicationContext(), newEmployeeList);
//                final ContactsAdapter contactsAdapter= new ContactsAdapter(this,contactsList);
                recyclerView.setAdapter(employeeAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));


            }

            @Override
            public void onFailure(Call<List<Employee>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Error"+t.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });
    }
}
