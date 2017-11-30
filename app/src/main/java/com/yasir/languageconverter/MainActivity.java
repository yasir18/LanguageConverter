package com.yasir.languageconverter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView num=(TextView)findViewById(R.id.numbers);
        TextView fam=(TextView)findViewById(R.id.family);
        TextView col=(TextView)findViewById(R.id.colors);
        TextView phr=(TextView)findViewById(R.id.phrases);
        num.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent num=new Intent(MainActivity.this,Numbers.class);
                startActivity(num);
            }
        });
        fam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent num=new Intent(MainActivity.this,FamilyMembers.class);
                startActivity(num);
            }
        });
        col.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent num=new Intent(MainActivity.this,colors.class);
                startActivity(num);
            }
        });
        phr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent num=new Intent(MainActivity.this,phrases.class);
                startActivity(num);
            }
        });
    }

}
