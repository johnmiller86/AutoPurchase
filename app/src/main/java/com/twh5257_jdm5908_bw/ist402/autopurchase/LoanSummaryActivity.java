package com.twh5257_jdm5908_bw.ist402.autopurchase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class LoanSummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loansummary_layout);
        TextView monthlyPayET = (TextView) findViewById(R.id.textView2);
        TextView loanReportET = (TextView) findViewById(R.id.textView3);

        // Pass data
        Intent intent = getIntent();

        String report;
        report = intent.getStringExtra("LoanReport");

        String monthlyPay;
        monthlyPay = intent.getStringExtra("MonthlyPayment");
        monthlyPayET.setText(monthlyPay);
        loanReportET.setText(report);
    }

    public void goDataEntry(View view){
        finish();
    }
}
