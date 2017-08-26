package com.crdc.qi.birthdayreminder;

/**
 * Created by qi on 2017/8/26.
 */

public class Contact {
    int id;
    String name;
    String cardNum;
    String phoneNum;
    String text;

    public Contact(int id, String name, String cardNum, String phoneNum, String text) {
        this.id=id;
        this.name = name;
        this.cardNum=cardNum;
        this.phoneNum = phoneNum;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCardNum() {
        return cardNum;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getText() {
        return text;
    }
}
