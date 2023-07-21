package com.example.navigationdrawer;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class HomePageAdapter extends FragmentStateAdapter {
    public HomePageAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch(position){
            case 0:
                return new RegisterEventFragment();
            case 1:
                return new UploadFragment();
            case 2:
                return new ViewPicsFragment();
            default:
                return new RegisterEventFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
