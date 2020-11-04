package com.example.listacontactos;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.TextView;

public class MuestroContacto extends AppCompatActivity {
TextView txt1;
TextView txt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muestro_contacto);
        txt1=findViewById(R.id.txt1);
        txt2=findViewById(R.id.txt2);
       String contacto=getIntent().getStringExtra("contacto");

        Cursor cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, new String[] { ContactsContract.Contacts.DISPLAY_NAME, ContactsContract.CommonDataKinds.Phone.NUMBER,}, "DISPLAY_NAME = '"+contacto+"'", null, null);

        cursor.moveToFirst();
        txt1.setText(cursor.getString(0));
        txt2.setText(cursor.getString(1));



    }
}