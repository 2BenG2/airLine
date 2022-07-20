package com.lectures.airline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PassengerInfoActivity extends AppCompatActivity {
    public static final String RESULT = "RESULT";

    private EditText nameInput;
    private EditText ageInput;
    private Button btnNext;

    private String finalName;
    private int finalAge;

    private Order resultOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passenger_info);


        findViews();
        btnNext.setOnClickListener(v -> {
            checkData();
        });
    }

    private void checkData() {
        if(nameInput.getText().toString().isEmpty()){
            Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show();

        }else if(ageInput.getText().toString().isEmpty()){
            Toast.makeText(this, "Please enter your age", Toast.LENGTH_SHORT).show();

        }else{
            next();
        }

    }

    private void next() {
        finalName = nameInput.getText().toString();
        finalAge = Integer.parseInt(ageInput.getText().toString());
        Order tempOrder = (Order) getIntent().getSerializableExtra(StartOrderActivity.ORDER);
        resultOrder = new Order.OrderBuilder(tempOrder.getDestination(),tempOrder.getNOP(),tempOrder.isBornInIsrael())
                .age(finalAge)
                .name(finalName)
                .build();
        tempOrder = null;

        Intent intent = new Intent(this, OrderDetailsActivity.class);
        intent.putExtra(RESULT,resultOrder);
        startActivity(intent);

    }

    private void findViews() {
        nameInput = findViewById(R.id.nameInput);
        ageInput = findViewById(R.id.ageInput);
        btnNext = findViewById(R.id.btnNextToOrderDetails);
    }



}