package com.example.user.makemoney;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ShowMyIncome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_my_income);

        TextView showMonthIncome= (TextView) findViewById(R.id.showMonthIncome);
        TextView showYearIncome = (TextView) findViewById(R.id.showYearIncome);
        TextView showComplexIncome = (TextView) findViewById(R.id.showComplexIncome);
        TextView showMyIncome = (TextView) findViewById(R.id.showMyIncome);


        showMyIncome.setText(""+Values.getShowMyIncome()+"만"+Values.getShowMyIncome2()+"천원");
        showMonthIncome.setText(""+Values.getFrequencyIncome_m()+"만"+Values.getFrequencyIncome2_m()+"천원");
        showYearIncome.setText(""+Values.getFrequencyIncome_y()+"만"+Values.getFrequencyIncome2_y()+"천원");
        showComplexIncome.setText(""+Values.getNonFrequencyIncome()+"만"+Values.getNonFrequencyIncome2()+"천원");

    }
}
