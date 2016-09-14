package org.khmeracademy.database_sqlite;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        ArrayList<String> mainPage = new ArrayList<String>();
        mainPage.add("Product Page");
        mainPage.add("Customer Page");
        mainPage.add("Invoice Page");
        mainPage.add("Booking Page");
        mainPage.add("About Page");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                mainPage
        );
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView textView = (TextView)view;
                if(textView.getText().toString().equals("Product Page")){
                    //TODO GO TO PRODUCT ACTIVITY
                    Intent intent = new Intent(getApplicationContext(),ProductActivity.class);
                    startActivity(intent);
                }
                else if(textView.getText().toString().equals("Customer Page")){
                    //TODO GO TO CUSTOMER ACTIVITY
                    Intent intent = new Intent(getApplicationContext(),CustomerActivity.class);
                    startActivity(intent);
                }
                else if(textView.getText().toString().equals("Invoice Page")){
                    //TODO GO TO INVOICE ACTIVITY
                    Intent intent = new Intent(getApplicationContext(),InvoiceActivity.class);
                    startActivity(intent);
                }
                else if(textView.getText().toString().equals("Booking Page")){
                    //TODO GO TO BOOKING ACTIVITY
                    Intent intent = new Intent(getApplicationContext(),BookingActivity.class);
                    startActivity(intent);
                }
                else if(textView.getText().toString().equals("About Page")){
                    //TODO GO TO ABOUT ACTIVITY
                    Intent intent = new Intent(getApplicationContext(),AboutActivity.class);
                    startActivity(intent);
                }
            }
        });


    }
}
