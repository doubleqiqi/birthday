package com.crdc.qi.birthdayreminder;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by qi on 2017/8/26.
 */

public class ContactDatabase extends SQLiteOpenHelper {

    public static final String CONTACT = "create table contact(" +
            "id integer primary key autoincrement," +
            "contact_name text not null," +
            "card_num text(18) unique not null," +
            "phone_num text(11) unique not null," +
            "remark text" + ")";
    public ContactDatabase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CONTACT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
