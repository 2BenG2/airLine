package com.lectures.airline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.time.Instant;

public class OrderDetailsActivity extends AppCompatActivity {

    private TextView nameInfoHolder;
    private TextView ageInfoHolder;
    private TextView destinationInfoHolder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);

        findViews();
        setData();
    }


    private void findViews() {
        nameInfoHolder = findViewById(R.id.viewResultName);
        ageInfoHolder = findViewById(R.id.viewResultAge);
        destinationInfoHolder = findViewById(R.id.viewResultDestination);
    }
    private void setData() {
        Order resultOrder = (Order)getIntent().getSerializableExtra(PassengerInfoActivity.RESULT);
        nameInfoHolder.setText(resultOrder.getName());
        ageInfoHolder.setText(String.valueOf(resultOrder.getAge()));
        destinationInfoHolder.setText(resultOrder.getDestination());
    }


}