package com.crdc.qi.birthdayreminder;

/**
 * Created by qi on 2017/8/26.
 */

public class CardBirthday {
    public int year;
    public int month;
    public  int day;

    public CardBirthday(int year, int month, int day) {
        this.year=year;
        this.month=month;
        this.day=day;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if ( !(obj instanceof CardBirthday)) {
            return false;
        }
        CardBirthday tmp = (CardBirthday) obj;

        if (this.year == tmp.year && this.month == tmp.month && this.day == tmp.day) {
            return true;
        }

        return super.equals(obj);
    }

    public static CardBirthday DEFAULT=new CardBirthday(-1, -1, -1);

}
