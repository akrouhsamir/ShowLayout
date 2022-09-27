package com.example.showlayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class MainAdapter extends FragmentStateAdapter {

    public MainAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch(position){
            case 1: return new ConstraintFragment();
            case 2: return new FrameFragment();
            case 3: return new TableFragment();
            default: return new LinearFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
