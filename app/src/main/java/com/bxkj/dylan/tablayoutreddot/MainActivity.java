package com.bxkj.dylan.tablayoutreddot;

import android.content.res.Resources;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * @author dylan
 */
public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private TextView tv_tab_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = findViewById(R.id.tabLayout);
        initData();
    }

    private void initData() {
        TabLayout.Tab tab = tabLayout.newTab().setText("全部");
        tabLayout.addTab(tab);

        tab = tabLayout.newTab();
        tab.setCustomView(R.layout.tab_wait_for_pay);
        tv_tab_title = tab.getCustomView().findViewById(R.id.tv_tab_title);
        tv_tab_title.setText("待付款");
        tabLayout.addTab(tab);


        tab = tabLayout.newTab().setText("待发货");
        tabLayout.addTab(tab);

        tab = tabLayout.newTab().setText("待收货");
        tabLayout.addTab(tab);

        tab = tabLayout.newTab().setText("已完成");
        tabLayout.addTab(tab);

        tab = tabLayout.newTab().setText("已取消");
        tabLayout.addTab(tab);

        //添加监听
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getCustomView() != null) {
                    tv_tab_title.setTextColor(getResources().getColor(R.color.colorAccent));
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                if (tab.getCustomView() != null) {
                    tv_tab_title.setTextColor(getResources().getColor(R.color.colorBlack));
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
