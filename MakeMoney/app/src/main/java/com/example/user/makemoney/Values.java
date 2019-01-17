package com.example.user.makemoney;

public class Values {
    private static int goalMoney;
    public static int plusMoney;
    public static int plusMoney2;
    public static int minusMoney;
    public static int minusMoney2;
    private static int frequencyIncome_m;//정기(월,만원)
    private static int frequencyIncome2_m;//정기(월,천원)
    private static int frequencyIncome_y;//정기(년,만원)
    private static int frequencyIncome2_y;//정기(년,천원)
    private static int nonFrequencyIncome;
    private static int nonFrequencyIncome2;
    private static int eat;
    private static int clothes;
    private static int etc;
    private static int dessert;
    private static int eat2;
    private static int clothes2;
    private static int etc2;
    private static int dessert2;




    public static int getEat() {
        return eat;
    }

    public static void setEat(int eat,int eat2) {
        Values.eat2 += eat2;
        if (Values.eat2 > 9) {
            Values.eat2 -= 10;
            Values.eat += 1;
        }
        Values.eat+=eat;
    }

    public static int getClothes() {
        return clothes;
    }

    public static void setClothes(int clothes,int clothes2) {
        Values.clothes2 += clothes2;
        if (Values.clothes2 > 9) {
            Values.clothes2 -= 10;
            Values.clothes += 1;
        }
        Values.clothes+=clothes;
    }

    public static int getEtc() {
        return etc;
    }

    public static void setEtc(int etc,int etc2) {
        Values.etc2 += etc2;
        if (Values.etc2 > 9) {
            Values.etc2 -= 10;
            Values.etc += 1;
        }
        Values.etc+=etc;
    }

    public static int getDessert() {
        return dessert;
    }

    public static void setDessert(int dessert,int dessert2) {
        Values.dessert2 += dessert2;
        if (Values.dessert2 > 9) {
            Values.dessert2 -= 10;
            Values.dessert += 1;
        }
        Values.dessert+=dessert;
    }
    public static int getFrequencyIncome2() {
        return frequencyIncome2_m;
    }

    public static void setFrequencyIncome_m(int frequencyIncome2,int frequencyIncome) {
        Values.frequencyIncome2_m += frequencyIncome2;
        if(Values.frequencyIncome2_m>9) {
            Values.frequencyIncome2_m -= 10;
            Values.frequencyIncome_m+=1;
        }
        Values.frequencyIncome_m+=frequencyIncome;
    }
    public static void setFrequencyIncome_y(int frequencyIncome2,int frequencyIncome) {
        Values.frequencyIncome2_y += frequencyIncome2;
        if(Values.frequencyIncome2_y>9) {
            Values.frequencyIncome2_y -= 10;
            Values.frequencyIncome_y+=1;
        }
        Values.frequencyIncome_y+=frequencyIncome;
    }

    public static int getNonFrequencyIncome2() {
        return nonFrequencyIncome2;
    }

    public static void setNonFrequencyIncome(int nonFrequencyIncome2,int nonFrequencyIncome) {
        Values.nonFrequencyIncome2 += nonFrequencyIncome2;
        if (Values.nonFrequencyIncome2 > 9) {
            Values.nonFrequencyIncome2 -= 10;
            Values.nonFrequencyIncome += 1;
        }
        Values.nonFrequencyIncome+=nonFrequencyIncome;
    }
    public static int getGoalMoney() {
        return goalMoney;
    }

    public static void setGoalMoney(int goalMoney) {
        Values.goalMoney = goalMoney;
    }

    public static int getPlusMoney() {
        return plusMoney;
    }

    public static int getFrequencyIncome() {
        return frequencyIncome_m;
    }

    public static int getFrequencyIncome_m() {
        return frequencyIncome_m;
    }

    public static int getFrequencyIncome2_m() {
        return frequencyIncome2_m;
    }

    public static int getFrequencyIncome_y() {
        return frequencyIncome_y;
    }

    public static int getFrequencyIncome2_y() {
        return frequencyIncome2_y;
    }

    public static int getNonFrequencyIncome() {
        return nonFrequencyIncome;
    }

    public static void setPlusMoney(int plusMoney, int plusMoney2) {
        Values.plusMoney2+=plusMoney2;
        if(Values.plusMoney2>9) {
            Values.plusMoney2 -= 10;
            Values.plusMoney+=1;
        }
        Values.plusMoney += plusMoney;
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
        Values.minusMoney += minusMoney;
    }

    public Values(){

    }
}
