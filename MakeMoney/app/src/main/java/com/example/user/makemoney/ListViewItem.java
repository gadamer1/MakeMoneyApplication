package com.example.user.makemoney;

import java.io.Serializable;

public class ListViewItem implements Serializable {
    private int cost;
    private int cost2;
    private String memo;
    private String tag;
    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public int getCost2() {
        return cost2;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setCost2(int cost2) {
        this.cost2 = cost2;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
