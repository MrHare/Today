package com.hare.today;

import android.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView today;

    private TextView todo;

    private TextView about;

    private List<TextView> textViews;

    private PagerAdapter pagerAdapter;

    private ViewPager viewPager;

    private List<Fragment> fragments;

    //private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        //fragmentManager = getFragmentManager();
    }

    private void init(){
        today = (TextView)findViewById(R.id.today_textView);
        todo = (TextView)findViewById(R.id.todo_textView);
        about = (TextView)findViewById(R.id.about_textView);
        textViews = new ArrayList<TextView>();
        textViews.add(today);
        textViews.add(todo);
        textViews.add(about);
        viewPager = (ViewPager)findViewById(R.id.viewPager);

        today.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectTab(0);
            }
        });
        todo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectTab(1);
            }
        });

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectTab(2);
            }
        });

        fragments = new ArrayList<Fragment>();
        fragments.add(new TodayFragment());
        fragments.add(new TodoFragment());
        fragments.add(new AboutFragment());

        pagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public android.support.v4.app.Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        };

        viewPager.setAdapter(pagerAdapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                selectTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void selectTab(int position){
        viewPager.setCurrentItem(position);
        for(TextView tv : textViews){
            tv.setTextAppearance(getApplicationContext(),R.style.UnSelectFragment);
        }
        textViews.get(position).setTextAppearance(getApplicationContext(),R.style.SelectFragment);
    }
}
