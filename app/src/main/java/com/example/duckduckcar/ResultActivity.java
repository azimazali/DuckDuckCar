package com.example.duckduckcar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Locale;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView tvLoanAmount = findViewById(R.id.tvLoanAmount);
        TextView tvTotalInterest = findViewById(R.id.tvTotalInterest);
        TextView tvTotalPayment = findViewById(R.id.tvTotalPayment);
        TextView tvMonthlyPayment = findViewById(R.id.tvMonthlyPayment);
        Button btnBack = findViewById(R.id.btnBack);

        // Get data from intent
        Intent intent = getIntent();
        double loanAmount = intent.getDoubleExtra("LOAN_AMOUNT", 0);
        double totalInterest = intent.getDoubleExtra("TOTAL_INTEREST", 0);
        double totalPayment = intent.getDoubleExtra("TOTAL_PAYMENT", 0);
        double monthlyPayment = intent.getDoubleExtra("MONTHLY_PAYMENT", 0);

        // Display data
        tvLoanAmount.setText(String.format(Locale.getDefault(), "Loan Amount: %.2f", loanAmount));
        tvTotalInterest.setText(String.format(Locale.getDefault(), "Total Interest: %.2f", totalInterest));
        tvTotalPayment.setText(String.format(Locale.getDefault(), "Total Payment: %.2f", totalPayment));
        tvMonthlyPayment.setText(String.format(Locale.getDefault(), "Monthly Payment: %.2f", monthlyPayment));

        btnBack.setOnClickListener(v -> finish());
    }
}
