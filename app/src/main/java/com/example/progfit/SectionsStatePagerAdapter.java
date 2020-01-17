package com.example.progfit;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class SectionsStatePagerAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> mFragmentList;

    public SectionsStatePagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
        mFragmentList = new ArrayList<>();
    }

    public void addFragment(Fragment f){
        mFragmentList.add(f);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

}
