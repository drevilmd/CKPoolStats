package com.josephhahn.ck;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONObject;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends Activity {

    String PrefWalletAddress,walletaddress,walletaddressvalue,JsonResponse;
    EditText abc;
    String url = "http://ckpool.org/users/";
    @Override

    protected void onCreate(Bundle savedInstanceState) {

        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
  //      SharedPreferences.Editor editor = pref.edit();
//
        super.onCreate(savedInstanceState);
        String walletaddressvalue=pref.getString("walletaddress", null);         // getting String
        if (TextUtils.isEmpty(walletaddressvalue)){

            Intent intent = new Intent(this,getaddress.class);
            startActivity(intent);



        }


        setContentView(R.layout.activity_main);
        TextView a = findViewById(R.id.et_wallet);
        //a.setText("LTaGs1E7t7VSCWjWRdTn3dFJEo5Qvgt5t4");walletaddressvalue
        a.setText(walletaddressvalue);
         url = url + walletaddressvalue;
        loadurl();


    }

public void loadurl(){

    WebView browser = (WebView) findViewById(R.id.webView);

    browser.loadUrl(url);


}

public void getMiningInfo(){

    RequestQueue queue = Volley.newRequestQueue(this);
    String url2 ="http://ckpool.org/users/15puZrg3dTWNs1KTdeveLXsHv2h3hSEuBe";

// Request a string response from the provided URL.
    StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    // Display the first 500 characters of the response string.
                    //mTextView.setText("Response is: "+ response.substring(0,500));
                    JsonResponse = response;
                    TextView tv = findViewById(R.id.tvresponse);
                    tv.setText(JsonResponse.toString());
                }
            }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {

        }
    });

// Add the request to the RequestQueue.
    queue.add(stringRequest);





}

}
