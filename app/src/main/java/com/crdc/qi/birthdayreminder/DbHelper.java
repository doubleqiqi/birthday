package com.crdc.qi.birthdayreminder;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qi on 2017/8/26.
 */

public class DbHelper {

    private static final String DATA_BASE_NAME = "birth.db";
    private static final int DATA_BASE_VERSION = 1;

    private static DbHelper instance;

    private ContactDatabase database;
    private DbHelper(Context context) {
        database = new ContactDatabase(context, DATA_BASE_NAME, null, DATA_BASE_VERSION);
    }

    public static DbHelper getInstance(Context context) {
        synchronized (DbHelper.class) {
            if (instance == null) {
                synchronized (DbHelper.class) {
                    instance = new DbHelper(context);
                }
            }
        }
        return instance;
    }


    public List<Contact> getContactList() {
        SQLiteDatabase db = database.getWritableDatabase();
        List<Contact> list = new ArrayList<>();
        Cursor cursor = db.query("contact", null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex("id"));
            String name = cursor.getString(cursor.getColumnIndex("contact_name"));
            String card_num = cursor.getString(cursor.getColumnIndex("card_num"));
            String phone_num = cursor.getString(cursor.getColumnIndex("phone_num"));
            String remark = cursor.getString(cursor.getColumnIndex("remark"));
            Contact contact = new Contact(id, name,card_num, phone_num, remark);
            list.add(contact);
        }
        cursor.close();
        return list;
    }

    public long addContact(Contact contact) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("contact_name", contact.name);
        contentValues.put("card_num", contact.cardNum);
        contentValues.put("phone_num", contact.phoneNum);
        contentValues.put("remark", contact.text);
        SQLiteDatabase sqLiteDatabase = database.getWritableDatabase();
        return  sqLiteDatabase.insert("contact", null, contentValues);

    }


}
