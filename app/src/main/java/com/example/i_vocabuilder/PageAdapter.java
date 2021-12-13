package com.example.i_vocabuilder;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import org.jetbrains.annotations.NotNull;

public class PageAdapter extends FragmentPagerAdapter {

    int tabcount;
    public PageAdapter(@NonNull @NotNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @NotNull
    @Override
    public Fragment getItem(int position) {

        switch(position)
        {
            case 0 : return new DailyFragment();
            case 1 : return new WeeklyFragment();
            case 2 : return new MonthlyFragment();
            case 3 : return new AllFragment();
            default : return null;
        }


    }

    @Override
    public int getCount() {
        return tabcount;
    }
}
