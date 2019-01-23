package com.example.user.makemoney;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ListView positiveListView;
    private ListView negativeListView;
    private ListViewPoisitiveAdapter listViewPoisitiveAdapter;
    private ListViewNegativeAdapter listViewNegativeAdapter;
    private TextView goalMoney;
    private static int showGoalMoney;
    private int showMyMoney;
    private Values values;
    private TextView goalProduct;
    private TextView mySaveMoney;
    private TextView myPayMoney;
    private Spinner spinner;
    private TextView showRemainTime;
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
        spinner = (Spinner) findViewById(R.id.spinner);
        showRemainTime = (TextView) findViewById(R.id.showRemainTime);

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


        /////////////////리스트 삭제//////////////////////
        positiveListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                builder.setTitle("알림")
                        .setMessage("리스트를 삭제하겠습니까?")
                        .setCancelable(true)
                        .setPositiveButton("네", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Values.setPlusMoney(-ListViewPoisitiveAdapter.getListViewItems().get(position).getCost(),
                                        -ListViewPoisitiveAdapter.getListViewItems().get(position).getCost2());
                                if(ListViewPoisitiveAdapter.getListViewItems().get(position).getMemo().equals("기본수입")){
                                    Values.setShowMyIncome(-ListViewPoisitiveAdapter.getListViewItems().get(position).getCost(),
                                            -ListViewPoisitiveAdapter.getListViewItems().get(position).getCost2());
                                }else if(ListViewPoisitiveAdapter.getListViewItems().get(position).getMemo().equals("정기(월)")){
                                    Values.setFrequencyIncome_m(-ListViewPoisitiveAdapter.getListViewItems().get(position).getCost(),
                                            -ListViewPoisitiveAdapter.getListViewItems().get(position).getCost2());
                                }else if(ListViewPoisitiveAdapter.getListViewItems().get(position).getMemo().equals("정기(년)")){
                                    Values.setFrequencyIncome_y(-ListViewPoisitiveAdapter.getListViewItems().get(position).getCost(),
                                            -ListViewPoisitiveAdapter.getListViewItems().get(position).getCost2());
                                }else if(ListViewPoisitiveAdapter.getListViewItems().get(position).getMemo().equals("비정기")){
                                    Values.setNonFrequencyIncome(-ListViewPoisitiveAdapter.getListViewItems().get(position).getCost(),
                                            -ListViewPoisitiveAdapter.getListViewItems().get(position).getCost2());
                                }
                                listViewNegativeAdapter.remove(position);
                                listViewNegativeAdapter.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("아니요", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                listViewPoisitiveAdapter.notifyDataSetChanged();
                                dialog.cancel();
                            }
                        });
                final AlertDialog alertDialog = builder.create();
                alertDialog.setOnShowListener(new DialogInterface.OnShowListener() {
                    @Override
                    public void onShow(DialogInterface dialog) {
                        alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.BLACK);
                        alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(Color.BLACK);
                    }
                });
                alertDialog.show();
            }

        });

        negativeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                builder.setTitle("알림")
                        .setMessage("리스트를 삭제하겠습니까?")
                        .setCancelable(true)
                        .setPositiveButton("네", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Values.setMinusMoney(-ListViewNegativeAdapter.getListViewItems().get(position).getCost(),
                                        -ListViewNegativeAdapter.getListViewItems().get(position).getCost2());
                                if(ListViewNegativeAdapter.getListViewItems().get(position).getMemo().equals("식사")){
                                    Values.setEat(-ListViewNegativeAdapter.getListViewItems().get(position).getCost(),
                                            -ListViewNegativeAdapter.getListViewItems().get(position).getCost2());
                                }else if(ListViewNegativeAdapter.getListViewItems().get(position).getMemo().equals("의류")){
                                    Values.setClothes(-ListViewNegativeAdapter.getListViewItems().get(position).getCost(),
                                            -ListViewNegativeAdapter.getListViewItems().get(position).getCost2());
                                }else if(ListViewNegativeAdapter.getListViewItems().get(position).getMemo().equals("디저트")){
                                    Values.setDessert(-ListViewNegativeAdapter.getListViewItems().get(position).getCost(),
                                            -ListViewNegativeAdapter.getListViewItems().get(position).getCost2());
                                }else if(ListViewNegativeAdapter.getListViewItems().get(position).getMemo().equals("기본지출(보험비등)")){
                                Values.setEtc(-ListViewNegativeAdapter.getListViewItems().get(position).getCost(),
                                        -ListViewNegativeAdapter.getListViewItems().get(position).getCost2());
                                 }else if(ListViewNegativeAdapter.getListViewItems().get(position).getMemo().equals("주거비")){
                                    Values.setHousing_expenses(-ListViewNegativeAdapter.getListViewItems().get(position).getCost(),
                                            -ListViewNegativeAdapter.getListViewItems().get(position).getCost2());
                                }else if(ListViewNegativeAdapter.getListViewItems().get(position).getMemo().equals("기타생활비")){
                                    Values.setEtc_living_expenses(-ListViewNegativeAdapter.getListViewItems().get(position).getCost(),
                                            -ListViewNegativeAdapter.getListViewItems().get(position).getCost2());
                                }
                                listViewNegativeAdapter.remove(position);
                                listViewNegativeAdapter.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("아니요", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                final AlertDialog alertDialog = builder.create();
                alertDialog.setOnShowListener(new DialogInterface.OnShowListener() {
                    @Override
                    public void onShow(DialogInterface dialog) {
                        alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.BLACK);
                        alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(Color.BLACK);
                    }
                });
                alertDialog.show();
            }

        });

    }

    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){

        if(requestCode == 1){
            if(resultCode == RESULT_OK){
                if(Values.getFrequencyIncome_m()>0||Values.getFrequencyIncome_y()>0) {
                    positiveListView.setAdapter((ListViewPoisitiveAdapter) data.getSerializableExtra("a"));
                    showMyMoney= Values.getPlusMoney()-Values.getMinusMoney();
                    showGoalMoney = Values.getGoalMoney()-Values.getPlusMoney()+Values.getMinusMoney();
                    int residue = (showGoalMoney) / (Values.getFrequencyIncome_m()
                            + Values.getFrequencyIncome_y() / 12);
                    if (showGoalMoney <= 0) {
                        goalMoney.setText("목표:"+Values.getGoalMoney()+"만 모은돈:" + showMyMoney + "만");
                        mySaveMoney.setText("총수익:"+ Values.getPlusMoney() + "만" + Values.plusMoney2 + "천원");
                        showRemainTime.setText("대략"+residue+"개월 이후 달성");
                    } else if (showGoalMoney < 14) {
                        goalMoney.setText("목표:" + Values.getGoalMoney() + "만 모은돈:" + showMyMoney + "만원");
                        mySaveMoney.setText("총수익:"+ Values.getPlusMoney() + "만" + Values.plusMoney2 + "천원");
                        showRemainTime.setText("대략"+residue+"개월 이후 달성");

                    } else if (showGoalMoney < 40) {
                        goalMoney.setText("목표:" + Values.getGoalMoney() + "만 모은돈:" + showMyMoney + "만원");
                        mySaveMoney.setText("총수익:"+ Values.getPlusMoney() + "만" + Values.plusMoney2 + "천원");
                        showRemainTime.setText("대략"+residue+"개월 이후 달성");

                    } else {
                        goalMoney.setText("목표:" + Values.getGoalMoney() + "만 모은돈:" + showMyMoney + "만원");
                        mySaveMoney.setText("총수익" + "" + Values.getPlusMoney() + "만" + Values.plusMoney2 + "천원");
                        showRemainTime.setText("대략"+residue+"개월 이후 달성");

                    }
                }
                else{
                    positiveListView.setAdapter((ListViewPoisitiveAdapter) data.getSerializableExtra("a"));
                    showMyMoney= Values.getPlusMoney()-Values.getMinusMoney();
                    showGoalMoney = Values.getGoalMoney()-Values.getPlusMoney()+Values.getMinusMoney();
                    if (showGoalMoney <= 0) {
                        goalMoney.setText("목표:"+Values.getGoalMoney()+"만 모은돈:" + showMyMoney + "만");
                        mySaveMoney.setText("총수익:"+ Values.getPlusMoney() + "만" + Values.plusMoney2 + "천원");
                    } else if (showGoalMoney < 14) {
                        goalMoney.setText("목표:" + Values.getGoalMoney() + "만 모은돈:" + showMyMoney + "만원" );
                        mySaveMoney.setText("총수익:"+ Values.getPlusMoney() + "만" + Values.plusMoney2 + "천원");
                    } else if (showGoalMoney < 40) {
                        goalMoney.setText("목표:" + Values.getGoalMoney() + "만 모은돈:" + showMyMoney + "만원" );
                        mySaveMoney.setText("총수익:"+ Values.getPlusMoney() + "만" + Values.plusMoney2 + "천원");
                    } else {
                        goalMoney.setText("목표:" + Values.getGoalMoney() + "만 모은돈:" + showMyMoney + "만원" );
                        mySaveMoney.setText("총수익:"+ Values.getPlusMoney() + "만" + Values.plusMoney2 + "천원");
                    }
                }
            }
        }
        else if(requestCode==2){
            if (resultCode == RESULT_OK) {
                int residue;
                if(Values.getFrequencyIncome_m()>0||Values.getFrequencyIncome_y()>0) {
                    negativeListView.setAdapter((ListViewNegativeAdapter)data.getSerializableExtra("b"));
                    showMyMoney= Values.getPlusMoney()-Values.getMinusMoney();
                    showGoalMoney = Values.getGoalMoney()-Values.getPlusMoney()+Values.getMinusMoney();
                    residue = (showGoalMoney) / (Values.getFrequencyIncome_m()
                            + Values.getFrequencyIncome_y() / 12);
                    if(showGoalMoney<=0){
                        goalMoney.setText("목표:"+Values.getGoalMoney()+"만 모은돈:" + showMyMoney + "만");
                        myPayMoney.setText("총소비:"+"-"+Values.getMinusMoney()+"만"+Values.minusMoney2+"천원");
                        showRemainTime.setText("대략"+residue+"개월 이후 달성");

                    }
                    else if(showGoalMoney<14){
                        goalMoney.setText("목표:"+Values.getGoalMoney()+"만 모은돈:" + showMyMoney + "만");
                        myPayMoney.setText("총소비:"+"-"+Values.getMinusMoney()+"만"+Values.minusMoney2+"천원");
                        showRemainTime.setText("대략"+residue+"개월 이후 달성");

                    }
                    else if(showGoalMoney<40){
                        goalMoney.setText("목표:"+Values.getGoalMoney()+"만 모은돈:" + showMyMoney + "만");
                        myPayMoney.setText("총소비:"+"-"+Values.getMinusMoney()+"만"+Values.minusMoney2+"천원");
                        showRemainTime.setText("대략"+residue+"개월 이후 달성");

                    }
                    else {
                        goalMoney.setText("목표:"+Values.getGoalMoney()+"만 모은돈:" + showMyMoney + "만");
                        myPayMoney.setText("총소비:"+"-"+Values.getMinusMoney()+"만"+Values.minusMoney2+"천원");
                        showRemainTime.setText("대략"+residue+"개월 이후 달성");
                    }
                }
                else{
                    negativeListView.setAdapter((ListViewNegativeAdapter)data.getSerializableExtra("b"));
                    showMyMoney= Values.getPlusMoney()-Values.getMinusMoney();
                    showGoalMoney = Values.getGoalMoney()-Values.getPlusMoney()+Values.getMinusMoney();
                    if(showGoalMoney<=0){
                        goalMoney.setText("목표:"+Values.getGoalMoney()+"만 모은돈:" + showMyMoney + "만");
                        myPayMoney.setText("총소비:"+"-"+Values.getMinusMoney()+"만"+Values.minusMoney2+"천원");
                    }
                    else if(showGoalMoney<14){
                        goalMoney.setText("목표:"+Values.getGoalMoney()+"만 모은돈:" + showMyMoney + "만");
                        myPayMoney.setText("총소비:"+"-"+Values.getMinusMoney()+"만"+Values.minusMoney2+"천원");
                    }
                    else if(showGoalMoney<40){
                        goalMoney.setText("목표:"+Values.getGoalMoney()+"만 모은돈:" + showMyMoney + "만");
                        myPayMoney.setText("총소비:"+"-"+Values.getMinusMoney()+"만"+Values.minusMoney2+"천원");
                    }
                    else {
                        goalMoney.setText("목표:"+Values.getGoalMoney()+"만 모은돈:" + showMyMoney + "만");
                        myPayMoney.setText("총소비:"+"-"+Values.getMinusMoney()+"만"+Values.minusMoney2+"천원");
                    }
                }

            }
        }
        else if (requestCode==300){
            if(resultCode==RESULT_OK){
                showMyMoney= Values.getPlusMoney()-Values.getMinusMoney();
                goalMoney.setText("목표:"+Values.getGoalMoney()+"만 모은돈:" + showMyMoney + "만원");
                showRemainTime.setText("목표달성까지 얼마나남았니");
            }
        }
        else if (requestCode==400){
            if(resultCode==RESULT_OK){
                    goalProduct.setText(data.getStringExtra("c"));
                    showRemainTime.setText("꿈은 이루어진다");
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
        final AlertDialog alertDialog = builder.create();
       alertDialog.setOnShowListener(new DialogInterface.OnShowListener() {
           @Override
           public void onShow(DialogInterface dialog) {
               alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.BLACK);
               alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(Color.BLACK);
           }
       });
       alertDialog.show();
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
        final AlertDialog alertDialog = builder.create();
        alertDialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialog) {
                alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.BLACK);
                alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(Color.BLACK);
            }
        });
        alertDialog.show();

    }


    protected void onClickShowMyIncome(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("알림")
                .setMessage("나의 수입내역을 보시겠습니까?")
                .setCancelable(true)
                .setPositiveButton("네", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(MainActivity.this, ShowMyIncome.class);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("아니요", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        final AlertDialog alertDialog = builder.create();
        alertDialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialog) {
                alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.BLACK);
                alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(Color.BLACK);
            }
        });
        alertDialog.show();
    }

    protected void onClickShowMyPay(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("알림")
                .setMessage("나의 지출내역을 보시겠습니까?")
                .setCancelable(true)
                .setPositiveButton("네", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(MainActivity.this, ShowMyPay.class);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("아니요", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        final AlertDialog alertDialog = builder.create();
        alertDialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialog) {
                alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.BLACK);
                alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(Color.BLACK);
            }
        });
        alertDialog.show();
    }
}
