package com.example.user.makemoney;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ListView positiveListView;
    private ListView negativeListView;
    private ListViewPoisitiveAdapter listViewPoisitiveAdapter;
    private ListViewNegativeAdapter listViewNegativeAdapter;
    private TextView goalMoney;
    private static int showGoalMoney;
    private Values values;
    private TextView goalProduct;
    private TextView mySaveMoney;
    private TextView myPayMoney;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        values = new Values();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listViewPoisitiveAdapter = new ListViewPoisitiveAdapter();
        listViewNegativeAdapter = new ListViewNegativeAdapter();
        positiveListView = (ListView) findViewById(R.id.positiveList);
        negativeListView = (ListView) findViewById(R.id.negativeList);
        final Button positiveSetButton = (Button) findViewById(R.id.positiveSetButton);
        final Button negativeSetButton = (Button) findViewById(R.id.negativeSetButton);
        goalMoney = (TextView) findViewById(R.id.goalMoney);
        goalProduct = (TextView) findViewById(R.id.goalProduct);
        myPayMoney = (TextView) findViewById(R.id.myPayMoney);
        mySaveMoney = (TextView) findViewById(R.id.mySaveMoney);

        positiveSetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MakePositiveActivity.class);
                intent.putExtra("listviewadapter1", listViewPoisitiveAdapter);
                startActivityForResult(intent,1);
            }
        });
        negativeSetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MakeNegativeActivity.class);
                intent.putExtra("listviewadapter2", listViewNegativeAdapter);
                startActivityForResult(intent,2);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){

        if(requestCode == 1){
            if(resultCode == RESULT_OK){
                positiveListView.setAdapter((ListViewPoisitiveAdapter)data.getSerializableExtra("a"));
                showGoalMoney= Values.getGoalMoney()+Values.getMinusMoney()-Values.getPlusMoney();
                if(showGoalMoney<=0){
                    goalMoney.setText("목표 달성!!!! 치킨먹는날!");
                    mySaveMoney.setText(""+Values.getPlusMoney()+"만"+Values.plusMoney2+"천원");
                }
                else if(showGoalMoney<14){
                    goalMoney.setText("조금만더." + showGoalMoney + "만원");
                    mySaveMoney.setText(""+Values.getPlusMoney()+"만"+Values.plusMoney2+"천원");
                }
                else if(showGoalMoney<40){
                    goalMoney.setText("힘내자,남은돈" + showGoalMoney + "만원!!!");
                    mySaveMoney.setText(""+Values.getPlusMoney()+"만"+Values.plusMoney2+"천원");
                }
                else {
                    goalMoney.setText("목표까지" + showGoalMoney + "만원!!!");
                    mySaveMoney.setText(""+Values.getPlusMoney()+"만"+Values.plusMoney2+"천원");
                }
            }
        }
        else if(requestCode==2){
            if (resultCode == RESULT_OK) {
                negativeListView.setAdapter((ListViewNegativeAdapter)data.getSerializableExtra("b"));
                showGoalMoney= Values.getGoalMoney()+Values.getMinusMoney()-Values.getPlusMoney();
                if(showGoalMoney<=0){
                    goalMoney.setText("노력하는 당신");
                    myPayMoney.setText(""+Values.getMinusMoney()+"만"+Values.minusMoney2+"천원");
                }
                else if(showGoalMoney<14){
                    goalMoney.setText("이제 곧!" + showGoalMoney + "만원");
                    myPayMoney.setText(""+Values.getMinusMoney()+"만"+Values.minusMoney2+"천원");
                }
                else if(showGoalMoney<40){
                    goalMoney.setText("할수있다" + showGoalMoney + "만원!!!");
                    myPayMoney.setText(""+Values.getMinusMoney()+"만"+Values.minusMoney2+"천원");
                }
                else {
                    goalMoney.setText("목표까지" + showGoalMoney + "만원!!!");
                    myPayMoney.setText(""+Values.getMinusMoney()+"만"+Values.minusMoney2+"천원");
                }
            }
        }
        else if (requestCode==300){
            if(resultCode==RESULT_OK){
                showGoalMoney= Values.getGoalMoney()+Values.getMinusMoney()-Values.getPlusMoney();
                goalMoney.setText("목표까지"+showGoalMoney+"만원!");            }
        }
        else if (requestCode==400){
            if(resultCode==RESULT_OK){
                    goalProduct.setText(data.getStringExtra("c"));
                }
        }
    }

    protected void onClickGoalListener(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("알림")
                .setMessage("목표금액을 설정하시겠습니까?")
                .setCancelable(true)
                .setPositiveButton("네", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(MainActivity.this, MakeGoalAcitivity.class);
                        startActivityForResult(intent , 300);
                    }
                })
                .setNegativeButton("아니요", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    protected void onClickGoalPruductListener(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("알림")
                .setMessage("나의 목표를 입력하겠습니까?")
                .setCancelable(true)
                .setPositiveButton("네", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(MainActivity.this, MakeGoalProductActivity.class);
                        startActivityForResult(intent , 400);
                    }
                })
                .setNegativeButton("아니요", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();

    }

}
