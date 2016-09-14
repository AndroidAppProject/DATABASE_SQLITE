package org.khmeracademy.database_sqlite;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ProductActivity extends AppCompatActivity {
    EditText edProName,edQty,edUnitPrice,edTotal;
    Button btnAdd,btnDisplay;

    //TODO CREATE DATA BASE
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        edProName =(EditText) findViewById(R.id.edProName);
        edQty =(EditText) findViewById(R.id.edQty);
        edUnitPrice =(EditText)findViewById(R.id.edUnitPrice);
        edTotal =(EditText) findViewById(R.id.edTotal);


        btnAdd =(Button)findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String proName = edProName.getText().toString();
                Integer qty = Integer.parseInt(edQty.getText().toString());
                Float price = Float.parseFloat(edUnitPrice.getText().toString());
                Float total = Float.parseFloat(edTotal.getText().toString());

                db= openOrCreateDatabase("ProductMgt",MODE_PRIVATE,null);
                //TODO CREATE TABLE
                db.execSQL("CREATE TABLE IF NOT EXISTS tbl_product(pro_id INTEGER PRIMARY KEY AUTOINCREMENT, pro_name VARCHAR(50), qty INT ,price FLOAT,total FLOAT);");
                //TODO INSERT DATA TO TABLE
                db.execSQL("INSERT INTO tbl_product(pro_name, qty, price,total) VALUES('"+ proName +"',"+ qty +","+ price +","+ total +");");

                Toast.makeText(getApplicationContext(),"Add Successfully",Toast.LENGTH_LONG).show();

            }
        });

        btnDisplay =(Button)findViewById(R.id.btnDisplay);
        btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ShowProductActivity.class);
                startActivity(intent);
            }
        });

    }
}
