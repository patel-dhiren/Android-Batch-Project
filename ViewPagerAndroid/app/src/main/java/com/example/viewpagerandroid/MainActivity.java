
package com.example.viewpagerandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.viewpagerandroid.adapter.CustomPagerAdapter;
import com.example.viewpagerandroid.databinding.ActivityMainBinding;
import com.example.viewpagerandroid.model.Item;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private List<Item> itemList = new ArrayList<>();
    private CustomPagerAdapter adapter;
    private int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        prepareData();

        // pass data to adapter using constructor
        adapter = new CustomPagerAdapter(this, itemList);
        binding.viewPager.setAdapter(adapter);

        updateIndicator(currentIndex);

        binding.btnSkip.setOnClickListener(view -> {
            // navigate to login activity
        });

        binding.btnStart.setOnClickListener(view -> {
            // navigate to login Activity
        });

        binding.btnNext.setOnClickListener(view -> {

            if(currentIndex<adapter.getCount()){
                currentIndex++;
                binding.viewPager.setCurrentItem(currentIndex);
            }
        });

        binding.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                currentIndex = position;

                if(currentIndex==adapter.getCount()-1){
                    binding.btnNext.setVisibility(View.GONE);
                    binding.btnSkip.setVisibility(View.GONE);
                    binding.btnStart.setVisibility(View.VISIBLE);
                }else{
                    binding.btnNext.setVisibility(View.VISIBLE);
                    binding.btnSkip.setVisibility(View.VISIBLE);
                    binding.btnStart.setVisibility(View.GONE);
                }

                updateIndicator(currentIndex);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void updateIndicator(int index) {

        binding.indicatorDots.removeAllViews();

        ImageView layoutDots[] = new ImageView[adapter.getCount()];

        for(int i =0; i<layoutDots.length; i++){
            layoutDots[i] = new ImageView(this);
            layoutDots[i].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.inactive_dots));
            LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            param.setMargins(8, 0, 8, 0);
            if(i==index){
                layoutDots[i].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.active_dots));
            }

            binding.indicatorDots.addView(layoutDots[i], param);

        }



    }

    private void prepareData() {

        itemList.add(new Item(1, "Fresh Food", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum is simply dummy text of the printing", R.drawable.onboarding1));
        itemList.add(new Item(2, "Fast Delivery", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum is simply dummy text of the printing", R.drawable.onboarding2));
        itemList.add(new Item(3, "Easy Payment", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum is simply dummy text of the printing", R.drawable.onboarding3));

    }
}