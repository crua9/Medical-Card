package com.techreviewsandhelp.medicalcard;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by crua9 on 2/23/2016.
 */
public class Input extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input);
        final SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);

        Button b =(Button)findViewById(R.id.submit);
        b.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString(Data.Name,getdata(R.id.ename));
                editor.putString(Data.Medical,getdata(R.id.emedical));
                editor.putString(Data.Allergies,getdata(R.id.eallergies));
                editor.putString(Data.EmergencyName,getdata(R.id.eemergency));
                editor.putString(Data.EmergencyNumber,getdata(R.id.enumber));
                editor.commit();
                finish();
            }
        });

        Button help = (Button) findViewById(R.id.helpbutton);
        help.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri
                            .parse("vnd.youtube://xN0fLiun-bY"));
                    startActivity(intent);
                } catch (Exception e) {
                    Intent intent = new Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("http://www.youtube.com/watch?v=xN0fLiun-bY"));
                    startActivity(intent);
                }

            }
        });



    }


    String getdata(int id)
    {
        EditText edittext= (EditText)findViewById(id);
        return edittext.getText().toString();
    }

    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        SharedPreferences preferences = PreferenceManager
                .getDefaultSharedPreferences(this);
        String name =preferences.getString(Data.Name, Data.default_Name);
        String phonenumber = preferences.getString(Data.EmergencyNumber,
                Data.default_EmergencyNumber);
        String disString = preferences.getString(Data.Medical,
                Data.default_Medical);
        String symptomps = preferences.getString(Data.Allergies,
                Data.default_Allergies);
        String emergencyName = preferences.getString(Data.EmergencyName,
                Data.default_EmergencyName);

        settext(R.id.emedical, disString);
        settext(R.id.enumber, phonenumber);
        settext(R.id.eallergies, symptomps);
        settext(R.id.ename, name);
        settext(R.id.eemergency, emergencyName);
    }

    public void settext(int id, String text) {

        EditText txt = (EditText) findViewById(id);
        if(text!="")
            txt.setText(text);
    }

}

