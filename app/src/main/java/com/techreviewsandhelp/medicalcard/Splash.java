package com.techreviewsandhelp.medicalcard;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by crua9 on 2/23/2016.
 */
public class Splash extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        final Context c = this;
        Thread timer = new Thread(){
            public void run(){
                try{
                    sleep(2000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }finally{
                    Intent openStartingPoint = new Intent(c,MainActivity.class);
                    startActivity(openStartingPoint);
                }
            }
        };
        timer.start();
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        finish();
    }

}