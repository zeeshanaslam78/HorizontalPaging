package com.xeeshi.horizontalpaging;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class HorizontalPagingActivity extends AppCompatActivity {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizontal_paging);

        int fragmentID = getIntent().getIntExtra(MainActivity.ARG_FRAGMENT_ID, -1);

        switch (fragmentID) {
            case 1:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frameLayout, new PagerTabsFragment())
                        .commit();
                break;
            case 2:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frameLayout, new TabHostWidgetFragment())
                        .commit();
                break;
            case 3:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frameLayout, new FragTabHostWidgetFragment())
                        .commit();
                break;

        }


    }





}
