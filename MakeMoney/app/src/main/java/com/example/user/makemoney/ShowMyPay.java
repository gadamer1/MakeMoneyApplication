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

        eat.setText(""+Values.getEat());
        etc.setText(""+Values.getEtc());
        clothes.setText(""+Values.getClothes());
        dessert.setText(""+Values.getDessert());
    }
}
