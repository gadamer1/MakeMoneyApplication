package com.example.user.makemoney;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.util.ArrayList;

public class ListViewNegativeAdapter extends BaseAdapter implements Serializable {
    private static ArrayList<ListViewItem> listViewItems ;


    public ListViewNegativeAdapter(){
        listViewItems = new ArrayList<ListViewItem>();
    }

    @Override
    public int getCount() {
        return listViewItems.size();
    }

    @Override
    public Object getItem(int position) {
        return listViewItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public static ArrayList<ListViewItem> getListViewItems() {
        return listViewItems;
    }

    public static void setListViewItems(ArrayList<ListViewItem> listViewItems) {
        ListViewNegativeAdapter.listViewItems = listViewItems;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();
        //listviewitems의 layout을 inflate해서 couvertview를 획득
        if(convertView==null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_negativeitem, parent, false);
        }
        //화면에 표시될 view(layout이 inflate된)으로부터 위젯에 대한 참조 획득
        TextView costText1 = (TextView) convertView.findViewById(R.id.costText1);
        TextView costTex2 = (TextView) convertView.findViewById(R.id.costText2);
        TextView memo= (TextView) convertView.findViewById(R.id.memo);
        //data set(listviewitems)에서 position에 위치한 데이터 참조 획득
        ListViewItem listViewItem = listViewItems.get(pos);
        //아이템 내 각 위젯에 데이터 반영
        costText1.setText(""+listViewItem.getCost());
        costTex2.setText(""+listViewItem.getCost2());
        memo.setText(listViewItem.getMemo());

        return convertView;
    }


    public void addItem(int cost,int cost2,String memo){
        ListViewItem item = new ListViewItem();
        item.setCost(cost);
        item.setCost2(cost2);
        item.setMemo(memo);
        listViewItems.add(item);
    }
    public void remove(int pos){
        this.listViewItems.remove(pos);
    }

}
