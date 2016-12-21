package com.example.a9dots04.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button list;
    EditText Zip_no_edittext;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        list = (Button) findViewById(R.id.Login_btn);
        Zip_no_edittext=(EditText)findViewById(R.id.mobile_Login_mobile_no_edittext) ;

        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Zip_no_edittext.getText().toString().length() <=2||Zip_no_edittext.getText().toString().length()>=6) {
                    Zip_no_edittext.setError("Enter valid Zipcode");

                }
                else {
                    String zipcode = Zip_no_edittext.getText().toString();
                    SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putString("zipcode", zipcode);
                    editor.commit();
                    Log.e("zip", "" + zipcode);
                    Intent intent = new Intent(MainActivity.this, DataActivity.class);
                    startActivity(intent);
                    Zip_no_edittext.setText("");
                }
            }

        });

    }
}


