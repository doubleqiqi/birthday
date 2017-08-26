package com.crdc.qi.birthdayreminder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddContactActivity extends AppCompatActivity {


    EditText dtName;
    EditText dtPhone;
    EditText dtCard;
    EditText dtText;
    Button btnSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_add_contact);

        dtName =(EditText) findViewById(R.id.contact_name);

        dtPhone = (EditText) findViewById(R.id.contact_phone);
        dtCard = (EditText) findViewById(R.id.contact_card);

        dtText = (EditText) findViewById(R.id.contact_text);

        btnSave = (Button) findViewById(R.id.btn_save);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attempSave();
            }


        });

    }

    private void attempSave() {
        String name = dtName.getText().toString();
        String phone = dtPhone.getText().toString();
        String card = dtCard.getText().toString();
        String text = dtText.getText().toString();
        Contact contact = new Contact(0, name, card, phone, text);
        long row = DbHelper.getInstance(this).addContact(contact);
        if (row == -1) {
            Toast.makeText(this, "添加失败", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "添加成功", Toast.LENGTH_SHORT).show();
            this.finish();
        }

    }
}
