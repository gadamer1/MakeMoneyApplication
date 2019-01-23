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
    private static int etc_living_expenses;//기타생활비
    private static int etc_living_expenses2;//기타생활비
    private static int housing_expenses;//주거비
    private static int housing_expenses2;//주거비
    private static int showMyIncome;//기본수입
    private static int showMyIncome2;//기본수입



    public static int getEat() {
        return eat;
    }

    public static int getEtc_living_expenses() {
        return etc_living_expenses;
    }

    public static int getShowMyIncome() {
        return showMyIncome;
    }

    public static void setShowMyIncome(int showMyIncome,int showMyIncome2) {
        Values.showMyIncome2 += showMyIncome2;
        if(Values.showMyIncome2<0){
            Values.showMyIncome2+=10;
            Values.showMyIncome-=1;
        }
        if (Values.showMyIncome2 > 9) {
            Values.showMyIncome2 -= 10;
            Values.showMyIncome += 1;
        }
        Values.showMyIncome+=showMyIncome;
    }

    public static int getShowMyIncome2() {
        return showMyIncome2;
    }

    public static void setShowMyIncome2(int showMyIncome2) {
        Values.showMyIncome2 = showMyIncome2;
    }

    public static void setEtc_living_expenses(int etc_living_expenses, int etc_living_expenses2) {
        Values.etc_living_expenses2 += etc_living_expenses2;
        if(Values.etc_living_expenses2<0){
            Values.etc_living_expenses2+=10;
            Values.etc_living_expenses-=1;
        }
        if (Values.etc_living_expenses2 > 9) {
            Values.etc_living_expenses -= 10;

            Values.etc_living_expenses += 1;
        }
        Values.etc_living_expenses+=etc_living_expenses;
    }

    public static int getHousing_expenses() {
        return housing_expenses;
    }

    public static void setHousing_expenses(int housing_expenses,int housing_expenses2) {
        Values.housing_expenses2 += housing_expenses2;
        if(Values.housing_expenses2<0){
            Values.housing_expenses2+=10;
            Values.housing_expenses-=1;
        }
        if (Values.housing_expenses2 > 9) {
            Values.housing_expenses2 -= 10;
            Values.housing_expenses += 1;
        }
        Values.housing_expenses+=housing_expenses;
    }

    public static void setEat(int eat, int eat2) {
        Values.eat2 += eat2;
        if(Values.eat2<0){
            Values.eat2+=10;
            Values.eat-=1;
        }
        if (Values.eat2 > 9) {
            Values.eat2 -= 10;
            Values.eat += 1;

        }
        Values.eat+=eat;
    }

    public static int getClothes() {
        return clothes;
    }

    public static void setEtc_living_expenses(int etc_living_expenses) {
        Values.etc_living_expenses = etc_living_expenses;
    }

    public static int getEtc_living_expenses2() {
        return etc_living_expenses2;
    }

    public static void setEtc_living_expenses2(int etc_living_expenses2) {
        Values.etc_living_expenses2 = etc_living_expenses2;
    }

    public static void setHousing_expenses(int housing_expenses) {
        Values.housing_expenses = housing_expenses;
    }

    public static int getHousing_expenses2() {
        return housing_expenses2;
    }

    public static void setHousing_expenses2(int housing_expenses2) {
        Values.housing_expenses2 = housing_expenses2;
    }

    public static void setClothes(int clothes, int clothes2) {
        Values.clothes2 += clothes2;
        if(Values.clothes2<0){
            Values.clothes2+=10;
            Values.clothes-=1;
        }
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
        if(Values.etc2<0){
            Values.etc2+=10;
            Values.etc-=1;
        }
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
        if(Values.dessert2<0){
            Values.dessert2+=10;
            Values.dessert-=1;
        }
        if (Values.dessert2 > 9) {
            Values.dessert2 -= 10;
            Values.dessert += 1;
        }
        Values.dessert+=dessert;
    }
    public static int getFrequencyIncome2() {
        return frequencyIncome2_m;
    }

    public static void setFrequencyIncome_m(int frequencyIncome,int frequencyIncome2) {
        Values.frequencyIncome2_m += frequencyIncome2;
        if(Values.frequencyIncome2_m<0){
            Values.frequencyIncome2_m+=10;
            Values.frequencyIncome_m-=1;
        }
        if(Values.frequencyIncome2_m>9) {
            Values.frequencyIncome2_m -= 10;
            Values.frequencyIncome_m+=1;
        }
        Values.frequencyIncome_m+=frequencyIncome;
    }
    public static void setFrequencyIncome_y(int frequencyIncome,int frequencyIncome2) {
        Values.frequencyIncome2_y += frequencyIncome2;
        if(Values.frequencyIncome2_y<0){
            Values.frequencyIncome2_y+=10;
            Values.frequencyIncome_y-=1;
        }
        if(Values.frequencyIncome2_y>9) {
            Values.frequencyIncome2_y -= 10;
            Values.frequencyIncome_y+=1;
        }
        Values.frequencyIncome_y+=frequencyIncome;

    }

    public static int getNonFrequencyIncome2() {
        return nonFrequencyIncome2;
    }

    public static void setNonFrequencyIncome(int nonFrequencyIncome,int nonFrequencyIncome2) {
        Values.nonFrequencyIncome2 += nonFrequencyIncome2;
        if(Values.nonFrequencyIncome2<0){
            Values.nonFrequencyIncome2+=10;
            Values.nonFrequencyIncome-=1;
        }
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

    public static void setFrequencyIncome_m(int frequencyIncome_m) {
        Values.frequencyIncome_m = frequencyIncome_m;
    }

    public static void setFrequencyIncome2_m(int frequencyIncome2_m) {
        Values.frequencyIncome2_m = frequencyIncome2_m;
    }

    public static void setFrequencyIncome_y(int frequencyIncome_y) {
        Values.frequencyIncome_y = frequencyIncome_y;
    }

    public static void setFrequencyIncome2_y(int frequencyIncome2_y) {
        Values.frequencyIncome2_y = frequencyIncome2_y;
    }

    public static void setNonFrequencyIncome(int nonFrequencyIncome) {
        Values.nonFrequencyIncome = nonFrequencyIncome;
    }

    public static void setNonFrequencyIncome2(int nonFrequencyIncome2) {
        Values.nonFrequencyIncome2 = nonFrequencyIncome2;
    }

    public static void setEat(int eat) {
        Values.eat = eat;
    }

    public static void setClothes(int clothes) {
        Values.clothes = clothes;
    }

    public static void setEtc(int etc) {
        Values.etc = etc;
    }

    public static void setDessert(int dessert) {
        Values.dessert = dessert;
    }

    public static int getEat2() {
        return eat2;
    }

    public static void setEat2(int eat2) {
        Values.eat2 = eat2;
    }

    public static int getClothes2() {
        return clothes2;
    }

    public static void setClothes2(int clothes2) {
        Values.clothes2 = clothes2;
    }

    public static int getEtc2() {
        return etc2;
    }

    public static void setEtc2(int etc2) {
        Values.etc2 = etc2;
    }

    public static int getDessert2() {
        return dessert2;
    }

    public static void setDessert2(int dessert2) {
        Values.dessert2 = dessert2;
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
        if(Values.plusMoney2<0){
            Values.plusMoney2+=10;
            Values.plusMoney-=1;
        }
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
        if(Values.minusMoney2<0){
            Values.minusMoney2+=10;
            Values.minusMoney-=1;
        }
        if(Values.minusMoney2>9) {
            Values.minusMoney2 -= 10;
            Values.minusMoney+=1;
        }
        Values.minusMoney += minusMoney;
    }

    public Values(){

    }
}
