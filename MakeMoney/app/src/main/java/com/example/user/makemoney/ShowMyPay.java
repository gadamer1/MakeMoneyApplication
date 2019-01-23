package com.example.user.makemoney;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ShowMyPay  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_my_pay);

        TextView eat = (TextView) findViewById(R.id.eat);
        TextView etc = (TextView) findViewById(R.id.etc);
        TextView clothes = (TextView) findViewById(R.id.clothes);
        TextView dessert = (TextView) findViewById(R.id.dessert);
        TextView housing_expenses = (TextView) findViewById(R.id.housing_expenses) ;
        TextView etc_living_expenses = (TextView) findViewById(R.id.etc_living_expenses);
        eat.setText(""+Values.getEat()+"만"+Values.getEat2()+"천원");
        etc.setText(""+Values.getEtc()+"만"+Values.getEtc2()+"천원");
        clothes.setText(""+Values.getClothes()+"만"+Values.getClothes2()+"천원");
        dessert.setText(""+Values.getDessert()+"만"+Values.getDessert2()+"천원");
        housing_expenses.setText(""+Values.getHousing_expenses()+"만"+Values.getHousing_expenses2()+"천원");
        etc_living_expenses.setText(""+Values.getEtc_living_expenses()+"만"+Values.getEtc_living_expenses2()+"천원");
    }
}
