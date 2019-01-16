package com.example.user.makemoney;

public class Values {
    private static int goalMoney;
    public static int plusMoney;
    public static int plusMoney2;
    public static int minusMoney;
    public static int minusMoney2;

    public static int getGoalMoney() {
        return goalMoney;
    }

    public static void setGoalMoney(int goalMoney) {
        Values.goalMoney = goalMoney;
    }

    public static int getPlusMoney() {
        return plusMoney;
    }

    public static void setPlusMoney(int plusMoney,int plusMoney2) {
        Values.plusMoney2+=plusMoney2;
        if(Values.plusMoney2>9) {
            Values.plusMoney2 -= 10;
            Values.plusMoney+=1;
        }
        Values.plusMoney = plusMoney;
    }

    public static int getMinusMoney() {
        return minusMoney;
    }

    public static void setMinusMoney(int minusMoney,int minusMoney2) {
        Values.minusMoney2+=minusMoney2;
        if(Values.minusMoney2>9) {
            Values.minusMoney2 -= 10;
            Values.minusMoney+=1;
        }
        Values.minusMoney = minusMoney;
    }

    public Values(){

    }
}
