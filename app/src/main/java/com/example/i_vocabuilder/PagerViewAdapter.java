package com.example.i_vocabuilder;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerViewAdapter extends FragmentPagerAdapter {
    public PagerViewAdapter( FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(int position) {

        Fragment fragment = null;

        switch (position){
            case 0:
                fragment = new Fragment_daily();
                break;
            case 1:
                fragment = new Fragment_weekly();
                break;
            case 2:
                fragment = new Fragment_monthly();
                break;
            case 3:
                fragment = new Fragment_all();
                break;


        }

        return fragment;
    }

    @Override
    public int getCount() {
        return 4;
    }
}
