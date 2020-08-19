package com.skpd.simplemaths;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static final String USER_NAME="com.saan.firstemptyproject.USER_NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void enter(View view){
        Intent intent = new Intent(this,Addition.class);
        EditText txt_userName = findViewById(R.id.userName);
        String userName = txt_userName.getText().toString();
        intent.putExtra(USER_NAME,userName);
        startActivity(intent);
    }
    public void multiply(View view){
        Intent intent = new Intent(this,Multiply.class);
        EditText txt_userName = findViewById(R.id.userName);
        String userName = txt_userName.getText().toString();
        intent.putExtra(USER_NAME,userName);
        startActivity(intent);
    }
    public void division(View view){
        Intent intent = new Intent(this,DivisionActivity.class);
        EditText txt_userName = findViewById(R.id.userName);
        String userName = txt_userName.getText().toString();
        intent.putExtra(USER_NAME,userName);
        startActivity(intent);
    }
}
