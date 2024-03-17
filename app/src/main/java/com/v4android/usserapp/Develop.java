package com.v4android.usserapp;

import android.app.Activity;
import android.os.Bundle;

public class Develop extends Activity {
    public static String DeV = BuildConfig.WEB_URL;
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.develop);
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

}
