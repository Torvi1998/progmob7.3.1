package com.example.progmob731;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

@RequiresApi(api = Build.VERSION_CODES.M)
public class MainActivity extends AppCompatActivity {

    String CONNECTED = "You are connected to the internet :)";
    String NOT_CONNECTED = "You are not connected to the internet :(";

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.textView);
    }

    /**
     * Set text view depending on return
     * @param v
     */
    public void onButtonClicked(View v) {
        if(checkConnection()) {
            tv.setText(CONNECTED);
        } else {
            tv.setText(NOT_CONNECTED);
        }
    }

    /**
     * If connectivity manager returns true on connection for roaming or wifi we are connected, else false
     * @return
     */
    public boolean checkConnection() {

        boolean connected;

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            connected = true;
        } else {
            connected = false;
        }

        return connected;
    }
}