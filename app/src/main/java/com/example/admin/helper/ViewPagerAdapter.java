package com.example.admin.helper;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by gurjeet on 11/10/2017.
 */

public class ViewPagerAdapter extends PagerAdapter {

    private int[] image_resources={R.drawable.pc,R.drawable.wp,R.drawable.es,R.drawable.pc,
            R.drawable.ac,R.drawable.pc,R.drawable.wp,R.drawable.es,R.drawable.pc,R.drawable.ac};
    private Context context;
    private LayoutInflater layoutInflater;

    public ViewPagerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return image_resources.length;
    }


    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view==(FrameLayout)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        layoutInflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item_view=layoutInflater.inflate(R.layout.swipe,container,false);

        ImageView imageView=item_view.findViewById(R.id.image_viewpager);
        imageView.setImageResource(image_resources[position]);

        container.addView(item_view);

        return item_view;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView((FrameLayout)object);
    }


}