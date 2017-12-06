# Android中TabLayout添加小红点

<div  align="center">    
<img src="https://github.com/linglongxin24/TablayoutRedDot/blob/master/screenshot/device-2017-12-06-091225.png" width="50%" height="50%"/>
</div>

## 1.主布局文件

 ```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    tools:context="com.bxkj.dylan.tablayoutreddot.MainActivity">
    <android.support.design.widget.TabLayout
        android:id="@+id/tabLayout"
        app:tabBackground="@android:color/white"
        app:tabTextColor="@color/colorBlack"
        app:tabSelectedTextColor="@color/colorAccent"
        app:tabMode="scrollable"
        android:layout_width="match_parent"
        android:layout_height="40dp" />
</LinearLayout>

```
## 2.要显示小红点的自定义布局文件

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="wrap_content"
    android:layout_height="40dp"
    android:layout_gravity="center"
    android:orientation="horizontal">
    <TextView
        android:id="@+id/tv_tab_title"
        android:layout_width="wrap_content"
        android:layout_height="match_parent"
        android:gravity="center"
        android:textColor="@color/colorBlack"
        android:textSize="15sp" />

    <TextView
        android:id="@+id/iv_tab_red"
        android:layout_gravity="right"
        android:layout_width="18dp"
        android:text="5"
        android:gravity="center"
        android:textColor="@android:color/white"
        android:layout_height="18dp"
        android:background="@drawable/red_dot" />
</LinearLayout>
```

## 3.设置TabLayout加载的各个Tab

```java

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

        //待付款栏目-加载自定义显示小红点的布局
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

        //添加tabLayout选中监听
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //设置选中时的文字颜色
                if (tab.getCustomView() != null) {
                    tv_tab_title.setTextColor(getResources().getColor(R.color.colorAccent));
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                //设置未选中时的文字颜色
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

```
## 4.[GitHub](https://github.com/linglongxin24/TablayoutRedDot)