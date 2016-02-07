package com.twh5257_jdm5908_bw.ist402.autopurchase;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class PurchaseActivity extends AppCompatActivity {

    Auto mAuto;

    // Data to be passed
    String loanReport, monthlyPayment;

    private EditText carPriceET, downPayET;
    private RadioGroup loanTermRG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.purchase_layout);
        carPriceET = (EditText) findViewById(R.id.editText1);
        downPayET = (EditText) findViewById(R.id.editText2);
        loanTermRG = (RadioGroup) findViewById(R.id.radioGroup1);
        mAuto = new Auto();
    }

    private void collectAutoInputData(){

        // Set car price
        mAuto.setmPrice((double) Integer.valueOf(carPriceET.getText().toString()));

        // Set down payment
        mAuto.setmDownPayment((double) Integer.valueOf(downPayET.getText().toString()));

        // Set the loan term
        Integer radioId = loanTermRG.getCheckedRadioButtonId();
        RadioButton term = (RadioButton) findViewById(radioId);
        mAuto.setmLoanTerm(term.getText().toString());
    }

    private void buildLoanReport(){

        // Construct monthly payment
        Resources res = getResources();
        monthlyPayment = res.getString(R.string.report_line1) + String.format("%.02f", mAuto.monthlyPayment());

        // Construct loan report
        loanReport = res.getString(R.string.report_line6) + String.format("%10.02f", mAuto.getmPrice());
        loanReport += res.getString(R.string.report_line7) + String.format("%10.02f", mAuto.getmDownPayment());

        loanReport += res.getString(R.string.report_line9) + String.format("%18.02f", mAuto.taxAmount());
        loanReport += res.getString(R.string.report_line10) + String.format("%18.02f", mAuto.totalCost());
        loanReport += res.getString(R.string.report_line11) + String.format("%12.02f", mAuto.borrowedAmount());
        loanReport += res.getString(R.string.report_line12) + String.format("%12.02f", mAuto.interestAmount());

        loanReport += "\n\n" + res.getString(R.string.report_line8) + " " + mAuto.getmLoanTerm() + " years.";

        loanReport += "\n\n" + res.getString(R.string.report_line2);
        loanReport += res.getString(R.string.report_line3);
        loanReport += res.getString(R.string.report_line4);
        loanReport += res.getString(R.string.report_line5);
    }


}
