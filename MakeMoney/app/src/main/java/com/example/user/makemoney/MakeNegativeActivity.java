package com.example.user.makemoney;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MakeNegativeActivity extends AppCompatActivity {
    ListViewNegativeAdapter listViewNegativeAdapter;
    private String memo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makenegative);

        final EditText costText = (EditText) findViewById(R.id.costText);
        final EditText costText2 = (EditText) findViewById(R.id.costText2);
        Button setButton = (Button) findViewById(R.id.setButton);
        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter p_adpater = ArrayAdapter.createFromResource(this,R.array.n_spinner,android.R.layout.simple_spinner_item);
        p_adpater.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(p_adpater);
        memo = "식사";
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner spinner1 = (Spinner) parent;
                memo= (String) spinner1.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });



        setButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(costText.getText().length() == 0)
                    costText.setText("0");
                if(costText2.getText().length() == 0)
                    costText2.setText("0");
                if(Integer.parseInt(costText2.getText().toString())>9){
                    Toast.makeText(getApplicationContext(),"천원을 입력할때 숫자 0~9를 입력해주세요",Toast.LENGTH_LONG);
                }
                else {
                    Intent intent = getIntent();
                    listViewNegativeAdapter = (ListViewNegativeAdapter) intent.getSerializableExtra("listviewadapter2");
                    Intent intent1 = new Intent();
                    listViewNegativeAdapter.addItem(Integer.parseInt(costText.getText().toString()), Integer.parseInt(costText2.getText().toString()),memo);
                    intent1.putExtra("b", listViewNegativeAdapter);
                    setResult(RESULT_OK, intent1);
                    Values.setMinusMoney(Integer.parseInt(costText.getText().toString())
                           , Integer.parseInt(costText2.getText().toString()));
                    if(memo.equals("식사")){
                        Values.setEat(Integer.parseInt(costText.getText().toString()),Integer.parseInt(costText2.getText().toString()));
                    }else if(memo.equals("의류")){
                        Values.setClothes(Integer.parseInt(costText.getText().toString()),Integer.parseInt(costText2.getText().toString()));
                    }else if (memo.equals("디저트")){
                        Values.setDessert(Integer.parseInt(costText.getText().toString()),Integer.parseInt(costText2.getText().toString()));
                    }else if (memo.equals("기본지출(보험비등)")){
                        Values.setEtc(Integer.parseInt(costText.getText().toString()),Integer.parseInt(costText2.getText().toString()));
                    }else if (memo.equals("주거비")){
                        Values.setHousing_expenses(Integer.parseInt(costText.getText().toString()),Integer.parseInt(costText2.getText().toString()));
                    }else if (memo.equals("기타생활비")){
                        Values.setEtc_living_expenses(Integer.parseInt(costText.getText().toString()),Integer.parseInt(costText2.getText().toString()));
                    }
                    finish();
                }
            }
        });

    }
}
