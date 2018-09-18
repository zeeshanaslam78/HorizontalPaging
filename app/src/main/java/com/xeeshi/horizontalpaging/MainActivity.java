package com.xeeshi.horizontalpaging;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static final String ARG_FRAGMENT_ID = "FRAGMENT_ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.buttonPagerTab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, HorizontalPagingActivity.class);
                intent.putExtra(ARG_FRAGMENT_ID, 1);
                startActivity(intent);
            }
        });

        findViewById(R.id.buttonTabHost).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, HorizontalPagingActivity.class);
                intent.putExtra(ARG_FRAGMENT_ID, 2);
                startActivity(intent);
            }
        });

        findViewById(R.id.buttonFragmentTabHost).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, HorizontalPagingActivity.class);
                intent.putExtra(ARG_FRAGMENT_ID, 3);
                startActivity(intent);
            }
        });

    }
}
