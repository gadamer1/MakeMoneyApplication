package com.example.user.makemoney;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MakePositiveActivity extends AppCompatActivity {
    ListViewPoisitiveAdapter listViewPoisitiveAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makepoisitive);

        final EditText costText = (EditText) findViewById(R.id.costText);
        final EditText costText2 = (EditText) findViewById(R.id.costText2);
        Button setButton = (Button) findViewById(R.id.setButton);


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
                    listViewPoisitiveAdapter.addItem(Integer.parseInt(costText.getText().toString()), Integer.parseInt(costText2.getText().toString()));
                    intent1.putExtra("a", listViewPoisitiveAdapter);
                    Values.setPlusMoney(Values.getPlusMoney()+Integer.parseInt(costText.getText().toString())
                                             ,Integer.parseInt(costText2.getText().toString()));

                    setResult(RESULT_OK, intent1);
                    finish();
                }
            }
        });

    }
}
