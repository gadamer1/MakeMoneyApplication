package com.example.user.makemoney;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MakePositiveActivity extends AppCompatActivity {
    ListViewPoisitiveAdapter listViewPoisitiveAdapter;
    private String memo ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makepoisitive);

        final EditText costText = (EditText) findViewById(R.id.costText);
        final EditText costText2 = (EditText) findViewById(R.id.costText2);
        Button setButton = (Button) findViewById(R.id.setButton);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter p_adpater = ArrayAdapter.createFromResource(this,R.array.p_spinner,android.R.layout.simple_spinner_item);
        p_adpater.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(p_adpater);
        memo="정기(월)";
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               memo= parent.getItemAtPosition(position).toString();
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
                    listViewPoisitiveAdapter = (ListViewPoisitiveAdapter) intent.getSerializableExtra("listviewadapter1");
                    if (listViewPoisitiveAdapter == null)
                        listViewPoisitiveAdapter = (ListViewPoisitiveAdapter) intent.getSerializableExtra("listviewadapter2");
                    Intent intent1 = new Intent();
                    listViewPoisitiveAdapter.addItem(Integer.parseInt(costText.getText().toString()), Integer.parseInt(costText2.getText().toString()),memo);
                    intent1.putExtra("a", listViewPoisitiveAdapter);
                    Values.setPlusMoney(Integer.parseInt(costText.getText().toString())
                                             ,Integer.parseInt(costText2.getText().toString()));
                    if(memo.equals("정기(월)")) {
                        Values.setFrequencyIncome_m(Integer.parseInt(costText.getText().toString()), Integer.parseInt(costText2.getText().toString()));
                    }else if(memo.equals("정기(년)")) {
                        Values.setFrequencyIncome_y(Integer.parseInt(costText.getText().toString()), Integer.parseInt(costText2.getText().toString()));
                    }
                    else if(memo.equals("비정기")){
                        Values.setNonFrequencyIncome(Integer.parseInt(costText.getText().toString()),Integer.parseInt(costText2.getText().toString()));
                    } else if(memo.equals("기본수입")){
                        Values.setShowMyIncome(Integer.parseInt(costText.getText().toString()),Integer.parseInt(costText2.getText().toString()));
                    }
                    setResult(RESULT_OK, intent1);
                    finish();
                }
            }
        });

    }
}
