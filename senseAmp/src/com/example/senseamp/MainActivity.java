package com.example.senseamp;

import android.os.Bundle;
import android.content.Context;
import android.os.Vibrator;
import android.app.Activity;
import android.view.Menu;

public class MainActivity
    extends Activity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        String2Vibrations str2vib = new String2Vibrations();

        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        long[] pattern = str2vib.getVibrations("hi a");
        v.vibrate(pattern, -1);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
