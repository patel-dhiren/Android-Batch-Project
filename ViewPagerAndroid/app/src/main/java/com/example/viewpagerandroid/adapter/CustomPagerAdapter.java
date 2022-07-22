package com.example.viewpagerandroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.viewpagerandroid.databinding.CustomSliderLayoutBinding;
import com.example.viewpagerandroid.model.Item;

import java.util.List;

public class CustomPagerAdapter extends PagerAdapter {

    private Context context;
    private List<Item> itemList;
    private CustomSliderLayoutBinding binding;

    public CustomPagerAdapter(Context context, List<Item> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        binding = CustomSliderLayoutBinding.inflate(LayoutInflater.from(context), container, false);
        Item item = itemList.get(position);

        binding.tvTitle.setText(item.getTitle());
        binding.tvDesc.setText(item.getDesc());
        binding.ivThumbnail.setImageResource(item.getImage());

        container.addView(binding.getRoot());

        return binding.getRoot();
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
