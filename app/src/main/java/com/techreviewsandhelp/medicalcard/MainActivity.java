package com.techreviewsandhelp.medicalcard;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


    public class MainActivity extends Activity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);



            final Context c = this;

            Button menu = (Button) findViewById(R.id.menubutton);
            menu.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    startActivity(new Intent(c, Input.class));
                }
            });

        }

        @Override
        protected void onStart() {
            // TODO Auto-generated method stub
            super.onStart();
            SharedPreferences preferences = PreferenceManager
                    .getDefaultSharedPreferences(this);
            String name = "Hi, My Name is "
                    + preferences.getString(Data.Name, Data.default_Name);
            final String phonenumber = preferences.getString(Data.EmergencyNumber,
                    Data.default_EmergencyNumber);
            String disString = preferences.getString(Data.Medical,
                    Data.default_Medical);
            String symptomps = preferences.getString(Data.Allergies,
                    Data.default_Allergies);
            String emergencyName = preferences.getString(Data.EmergencyName,
                    Data.default_EmergencyName);

            settext(R.id.disabilities, disString);
            settext(R.id.phonenumber, phonenumber);
            settext(R.id.symphtoms, symptomps);
            settext(R.id.name, name);
            settext(R.id.emergencyname, emergencyName);

            TextView txt = (TextView) findViewById(R.id.phonenumber);
            txt.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:"+phonenumber));
                    startActivity(callIntent);
                }
            });

        }

        public void settext(int id, String text) {

            TextView txt = (TextView) findViewById(id);
            txt.setText(text);
        }

    }