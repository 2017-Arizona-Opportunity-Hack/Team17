package com.jaaz.android;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Map;


public class HomePage extends AppCompatActivity {

    //firebase reference variables

    FirebaseFirestore fireDB;

    ArrayList<Position> positionList = new ArrayList<Position>();
    ArrayList<String> positionStringList = new ArrayList<String>();
    ArrayAdapter<String> positionStringListAdapter;
    TextView testView;
    ListView dataList;
    Button getButton;
    Button emailButton;
    int dataListCount = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        fireDB = FirebaseFirestore.getInstance();

        testView = (TextView)findViewById(R.id.testView);
        testView.setText("Hello World");

        dataList = (ListView)findViewById(R.id.dataList);
        positionStringListAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, positionStringList);
        dataList.setAdapter(positionStringListAdapter);

        getButton = (Button)findViewById(R.id.getButton);
        getButton.setText("Get from Database");
        getButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fireDB.collection("positions")
                        .get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                           @Override
                           public void onComplete(@NonNull Task<QuerySnapshot> task) {
                               if(task.isSuccessful()) {
                                   //For every document (position) in positions:
                                   for(DocumentSnapshot document : task.getResult()) {
                                       Map docMap = document.getData();
                                       Position newPosition = new Position();
                                       //For every entry in the document:
                                       for (Object objectEntry : docMap.entrySet()) {
                                           //Load the information and store it in the appropriate variable
                                           Map.Entry<String, Object> entry = (Map.Entry<String, Object>)objectEntry;
                                           String key = entry.getKey();
                                           Object value = entry.getValue();
                                           if(value != null) {
                                               //set position data based on key/value pairs (filtering out nulls)
                                               switch(key) {
                                                   case "address":
                                                       newPosition.address = (String) value;
                                                       break;
                                                   case "city":
                                                       newPosition.city = (String) value;
                                                       break;
                                                   case "county":
                                                       newPosition.county = (String) value;
                                                       break;
                                                   case "fr_15_16":
                                                       newPosition.fr_15_16 = (Long) value;
                                                       break;
                                                   case "fr_16_17":
                                                       newPosition.fr_16_17 = (Long) value;
                                                       break;
                                                   case "fr_17":
                                                       newPosition.fr_17 = (Long) value;
                                                       break;
                                                   case "district_saz":
                                                       newPosition.district_saz = (boolean) value;
                                                       break;
                                                   case "title_1":
                                                       newPosition.title_1 = (boolean) value;
                                                       break;
                                                   case "district_caz":
                                                       newPosition.district_caz = (boolean) value;
                                                       break;
                                                   case "name":
                                                       newPosition.name = (String) value;
                                                       break;
                                                   case "district":
                                                       newPosition.district = (String) value;
                                                       break;
                                                   case "zip":
                                                       newPosition.zip = (Long) value;
                                                       break;
                                                   case "type":
                                                       newPosition.type = (ArrayList<Boolean>)value;
                                                       break;
                                                   case "model":
                                                       newPosition.model = (String) value;
                                                       break;
                                                   case "dateTime":
                                                       //Not implemented
                                                       newPosition.dateTime = "";
                                                       break;
                                                   default:
                                                       break;
                                               }
                                           }
                                           //positionStringList.add("Key : " + entry.getKey() + " Value : " + entry.getValue());
                                       }
                                       positionList.add(newPosition);
                                       positionStringList.add(newPosition.name + " added in city " + newPosition.city + ".");
                                   }
                               }
                           }
                       });

                //TODO: add sort?
                positionStringListAdapter.notifyDataSetChanged();
            }
        });

        emailButton = (Button)findViewById(R.id.emailButton);
        emailButton.setText("Send email");
        emailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*
                String fromEmail = "jaazmailbot@gmail.com";
                String fromPassword = "636Children!";
                String toEmail = "matthewhollenbeck0@gmail.com";
                String emailSubject = "Thank you for volunteering!";
                String emailBody = "Thank you for your application!\nOne of our volunteers will get back to you soon.";
                */
            }
        });

    }



}
