package com.jaaz.android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class HomePage extends AppCompatActivity {

    ArrayList<String> positionList = new ArrayList<String>();
    ArrayAdapter<String> positionListAdapter;
    TextView testView;
    ListView dataList;
    Button getButton;
    int dataListCount = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        testView = (TextView)findViewById(R.id.testView);
        testView.setText("Hello World");


        dataList = (ListView)findViewById(R.id.dataList);
        positionListAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, positionList);
        dataList.setAdapter(positionListAdapter);

        getButton = (Button)findViewById(R.id.getButton);
        getButton.setText("Get from Database");
        getButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                positionList.add("Message Test #" + dataListCount++);
                positionListAdapter.notifyDataSetChanged();
            }
        });

    }



}
