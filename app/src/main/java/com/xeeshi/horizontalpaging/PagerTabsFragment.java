package com.xeeshi.horizontalpaging;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class PagerTabsFragment extends Fragment {

    private static final String TAG = PagerTabsFragment.class.getSimpleName();

    PagerAdapter pagerAdapter;
    ViewPager viewPager;
    // private ActionBar actionBar;

    public PagerTabsFragment() { }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i(TAG, "onAttach: ");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate: ");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView: ");
        return inflater.inflate(R.layout.fragment_pager_tabs, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.i(TAG, "onViewCreated: ");


        /*actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);*/

        pagerAdapter = new PagerAdapter(getChildFragmentManager());
        viewPager = view.findViewById(R.id.pager);
        viewPager.setAdapter(pagerAdapter);

       /* for (int i = 0; i < 100; i++) {
            addTab("Tab " + (i + 1) );
        }*/

        viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                //actionBar.setSelectedNavigationItem(position);
            }
        } );

        PagerTabStrip pagerTabStrip = view.findViewById(R.id.pager_title_strip);
        pagerTabStrip.setDrawFullUnderline(true);
        pagerTabStrip.setTabIndicatorColor(Color.RED);



    }

    /*private void addTab(String tag) {
        ActionBar.Tab tab = actionBar.newTab();
        tab.setTag(tag);
        tab.setText(tag);
        tab.setTabListener(new ActionBar.TabListener() {
            @Override
            public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

            }

            @Override
            public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

            }
        });
        actionBar.addTab(tab);

    }*/


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i(TAG, "onActivityCreated: ");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: ");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: ");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: ");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG, "onStop: ");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i(TAG, "onDestroyView: ");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: ");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i(TAG, "onDetach: ");
    }

    public class PagerAdapter extends FragmentStatePagerAdapter {


        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = new ObjectFragment();
            Bundle args = new Bundle();
            args.putInt(ObjectFragment.ARG_OBJECT, position + 1);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public int getCount() {
            return 100;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return "Object " + (position + 1);
        }
    }


    public static class ObjectFragment extends Fragment {

        private static final String TAG = ObjectFragment.class.getSimpleName();
        public static final String ARG_OBJECT = "object";
        private String currentPosition = "-1";

        @Override
        public void onAttach(Context context) {
            super.onAttach(context);
            Bundle args = getArguments();
            if (args != null) {
                currentPosition = String.valueOf( args.getInt(ARG_OBJECT) );
            }
            Log.i(TAG, "onAttach: ObjectFragment " + currentPosition);
        }

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            Log.i(TAG, "onCreate: ObjectFragment " + currentPosition);
        }


        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            Log.i(TAG, "onCreateView: ObjectFragment " + currentPosition);
            View viewRoot = inflater.inflate(android.R.layout.simple_list_item_1, container, false);
            ((TextView) viewRoot.findViewById(android.R.id.text1)).setText(currentPosition);
            return viewRoot;
        }

        @Override
        public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
            Log.i(TAG, "onViewCreated: ObjectFragment " + currentPosition);
        }

        @Override
        public void onActivityCreated(@Nullable Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            Log.i(TAG, "onActivityCreated: ObjectFragment " + currentPosition);
        }

        @Override
        public void onStart() {
            super.onStart();
            Log.i(TAG, "onStart: ObjectFragment " + currentPosition);
        }

        @Override
        public void onResume() {
            super.onResume();
            Log.i(TAG, "onResume: ObjectFragment " + currentPosition);
        }

        @Override
        public void onPause() {
            super.onPause();
            Log.i(TAG, "onPause: ObjectFragment " + currentPosition);
        }

        @Override
        public void onStop() {
            super.onStop();
            Log.i(TAG, "onStop: ObjectFragment " + currentPosition);
        }

        @Override
        public void onDestroyView() {
            super.onDestroyView();
            Log.i(TAG, "onDestroyView: ObjectFragment " + currentPosition);
        }

        @Override
        public void onDestroy() {
            super.onDestroy();
            Log.i(TAG, "onDestroy: ObjectFragment " + currentPosition);
        }

        @Override
        public void onDetach() {
            super.onDetach();
            Log.i(TAG, "onDetach: ObjectFragment " + currentPosition);
        }
    }


}
