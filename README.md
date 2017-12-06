# Android中TabLayout添加小红点

## 1.主布局文件

...xml
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
...