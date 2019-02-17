package com.josephhahn.ck;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;

public class getaddress extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getaddress);
    }


public void saveaddress(View view){
    EditText walletaddress = findViewById(R.id.et_addvalue);
    String walletaddressvalue = walletaddress.getText().toString();
    SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
    SharedPreferences.Editor editor = pref.edit();
    editor.putString("walletaddress", walletaddressvalue);  // Saving string

// Save the changes in SharedPreferences
    editor.commit(); //
    Intent intent = new Intent(this,MainActivity.class);
    startActivity(intent);

}

}
