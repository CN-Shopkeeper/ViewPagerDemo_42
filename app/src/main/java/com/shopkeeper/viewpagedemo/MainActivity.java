package com.shopkeeper.viewpagedemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.util.Log;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {
    TabLayoutMediator tabLayoutMediator;//配置策略
    ViewPager2 viewPager2;
    TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager2=findViewById(R.id.viewPager2);
        tabLayout=findViewById(R.id.tabLayout2);
        viewPager2.setAdapter(new FragmentStateAdapter(this) {
            @NonNull
            @Override
            public Fragment createFragment(int position) {//每一个页面对应要创建的对应的页面
                switch (position){
                    case 0:
                        return new ScaleFragment();
                    case 1:
                        return new RotateFragment();
                    default:
                        return new TranslateFragment();
                }
            }

            @Override
            public int getItemCount() {//需要实现几个页面
                return 3;
            }
        });

        tabLayoutMediator=new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position){
                    case 0:
                        tab.setText("缩放");
                        break;
                    case 1:
                        tab.setText("旋转");
                        break;
                    default:
                        tab.setText("位移");
                }
            }
        });
        tabLayoutMediator.attach();
    }
}