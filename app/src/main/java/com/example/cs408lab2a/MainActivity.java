package com.example.cs408lab2a;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText numberPeople;
    private EditText tipPercent;
    private EditText totalBill;

    private TextView textBottom;
    private TextView textMid;
    private TextView textTop;

    private TextView outputText;

    private Button calculateBtn;

    private static final DecimalFormat decimal = new DecimalFormat("0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberPeople = findViewById(R.id.numberPeople);
        tipPercent = findViewById(R.id.tipPercent);
        totalBill = findViewById(R.id.totalBill);

        textBottom = findViewById(R.id.textBottom);
        textMid = findViewById(R.id.textMid);
        textTop = findViewById(R.id.textTop);

        outputText = findViewById(R.id.outputText);

        calculateBtn = findViewById(R.id.calculateBtn);

        findViewById(R.id.calculateBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    float people = Integer.parseInt(numberPeople.getText().toString());
                    float percent = Integer.parseInt(tipPercent.getText().toString());
                    float bill = Integer.parseInt(totalBill.getText().toString());

                    float workingVal;

                    workingVal = bill / people;
                    workingVal = workingVal + (workingVal * (percent / 100));

                    outputText.setText("Total Per Person: $"+decimal.format(workingVal));

                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}