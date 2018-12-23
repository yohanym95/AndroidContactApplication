package com.example.yohan.fragmentrecyclertest;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements PersonAdapter.ItemClicked {

    Button addBtn;
    EditText name,pNumber;
    TextView textName,textNumber;
    ListFrag list;
    FragmentManager manager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        pNumber = findViewById(R.id.Number);
        textName = findViewById(R.id.textName);
        textNumber = findViewById(R.id.textNumber);

        addBtn = findViewById(R.id.AddBtn);
        manager = this.getSupportFragmentManager();
        list = (ListFrag) manager.findFragmentById(R.id.listFRAG);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(name.getText().toString().isEmpty() || pNumber.getText().toString().isEmpty()){

                    Toast.makeText(MainActivity.this,"Please Enter all Fields",Toast.LENGTH_SHORT).show();

                }else{

                    ApplicationClass.people.add(new Person(name.getText().toString().trim(),pNumber.getText().toString().trim()));
                    Toast.makeText(MainActivity.this,"Person successfully Added!",Toast.LENGTH_SHORT).show();
                    name.setText(null);
                    pNumber.setText(null);
                    list.notifyDataChanged();
                }

            }
        });
        onItemClicked(0);
    }

    @Override
    public void onItemClicked(int index) {

        textName.setText(ApplicationClass.people.get(index).getName());
        textNumber.setText(ApplicationClass.people.get(index).getTelNumber());
    }

    @Override
    public void dialNumber(int index) {
        String num = ApplicationClass.people.get(index).getTelNumber();
        Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: "+num));
        startActivity(i);
    }
}
