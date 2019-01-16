package com.example.user.makemoney;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MakeNegativeActivity extends AppCompatActivity {
    ListViewNegativeAdapter listViewNegativeAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makenegative);

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
                    AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
                    builder.setTitle("경고")
                            .setMessage("천원을 입력할때 숫자 0~9만 입력해주세요")
                            .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            })
                            .create()
                            .show();
                }
                else {
                    Intent intent = getIntent();
                    listViewNegativeAdapter = (ListViewNegativeAdapter) intent.getSerializableExtra("listviewadapter2");
                    Intent intent1 = new Intent();
                    listViewNegativeAdapter.addItem(Integer.parseInt(costText.getText().toString()), Integer.parseInt(costText2.getText().toString()));
                    intent1.putExtra("b", listViewNegativeAdapter);
                    setResult(RESULT_OK, intent1);
                    Values.setMinusMoney(Values.getMinusMoney()+Integer.parseInt(costText.getText().toString())
                           , Integer.parseInt(costText2.getText().toString()));


                    finish();
                }
            }
        });

    }
}
