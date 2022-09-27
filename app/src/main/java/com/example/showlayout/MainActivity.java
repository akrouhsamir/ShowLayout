package com.example.showlayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabs;
    private ViewPager2 viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createTabs();
        createViewPager();

    }

    private void createTabs(){
        tabs = findViewById(R.id.main_tablayout);
        tabs.setTabGravity(TabLayout.GRAVITY_FILL);
        tabs.addTab(tabs.newTab().setText("Linear"));
        tabs.addTab(tabs.newTab().setText("Constrain"));
        tabs.addTab(tabs.newTab().setText("Frame"));
        tabs.addTab(tabs.newTab().setText("Table"));

        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void createViewPager(){
        viewPager = findViewById(R.id.main_viewpager);
        viewPager.setAdapter(new MainAdapter(getSupportFragmentManager(),getLifecycle()));
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabs.selectTab(tabs.getTabAt(position));
            }
        });
    }
}