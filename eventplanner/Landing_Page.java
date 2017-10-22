package com.juniorachievementofarizona.eventplanner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;


/**
 * Created by ronnievu on 10/22/17.
 */

public class Landing_Page extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.landing_page);
        String newString;
        if(savedInstanceState == null){
            Bundle extras = getIntent().getExtras();
            if(extras == null){
                newString = null;
            }
            else{
                newString = extras.getString("Data");


            }

        } else {

            newString= (String) savedInstanceState.getSerializable("Data");

        }
        TextView name = (TextView)findViewById(R.id.TxtView_Name);
        TextView address = (TextView)findViewById(R.id.TxtView_Address);
        TextView time = (TextView)findViewById(R.id.Txt_Time);
        TextView privacy = (TextView)findViewById(R.id.TxtView_Privacy);
        String[] splitted = newString.split("\n");
        if(splitted.length == 5){
            name.setText(splitted[0]);
            address.setText(splitted[1]);
            time.setText(splitted[2]);
            privacy.setText((splitted[4]));
        }
        else{
            name.setText(newString);
        }






    }


}
