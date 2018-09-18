package com.xeeshi.horizontalpaging;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;

public class FragTabHostWidgetFragment extends Fragment {

    private static final String TAG = FragTabHostWidgetFragment.class.getSimpleName();

    public FragTabHostWidgetFragment() { }

    private FragmentTabHost fragmentTabHost;
    private ViewPager fragmentTabHostViewPager;

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
        return inflater.inflate(R.layout.fragment_frag_tab_host_widget, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.i(TAG, "onViewCreated: ");
        fragmentTabHost = view.findViewById(android.R.id.tabhost);
        fragmentTabHostViewPager = view.findViewById(R.id.fragmentTabHostPager);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i(TAG, "onActivityCreated: ");

        fragmentTabHost.setup(getActivity(), getChildFragmentManager(), R.id.realtabcontent);
        fragmentTabHost.addTab(fragmentTabHost.newTabSpec("First Tab").setIndicator("First Tab").setContent(new MyTabFactory(getActivity())));
        fragmentTabHost.addTab(fragmentTabHost.newTabSpec("Second Tab").setIndicator("Second Tab").setContent(new MyTabFactory(getActivity())));
        fragmentTabHost.addTab(fragmentTabHost.newTabSpec("Third Tab").setIndicator("Third Tab").setContent(new MyTabFactory(getActivity())));


        FragmentTabHostPagerAdapter fragmentTabHostPagerAdapter = new FragmentTabHostPagerAdapter(getChildFragmentManager());
        fragmentTabHostViewPager.setAdapter(fragmentTabHostPagerAdapter);

        fragmentTabHostViewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                fragmentTabHost.setCurrentTab(position);
            }
        });

        fragmentTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String s) {
                fragmentTabHostViewPager.setCurrentItem(fragmentTabHost.getCurrentTab(), true);
            }
        });

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


    public class FragmentTabHostPagerAdapter extends FragmentStatePagerAdapter {

        public FragmentTabHostPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0: {
                    return FirstFragment.newInstance();
                }
                case 1: {
                    return SecondFragment.newInstance();
                }
                case 2: {
                    return ThirdFragment.newInstance();
                }
                default:
                    return FirstFragment.newInstance();
            }
        }

        @Override
        public int getCount() {
            return 3;
        }


        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0: {
                    return FirstFragment.class.getSimpleName();
                }
                case 1: {
                    return SecondFragment.class.getSimpleName();
                }
                case 2: {
                    return ThirdFragment.class.getSimpleName();
                }
                default:
                    return FirstFragment.class.getSimpleName();
            }
        }
    }

    public class MyTabFactory implements TabHost.TabContentFactory {

        private final Context context;

        public MyTabFactory(Context context) {
            this.context = context;
        }

        @Override
        public View createTabContent(String s) {
            View v = new View(context);
            v.setMinimumWidth(0);
            v.setMinimumHeight(0);
            return v;
        }
    }

}
