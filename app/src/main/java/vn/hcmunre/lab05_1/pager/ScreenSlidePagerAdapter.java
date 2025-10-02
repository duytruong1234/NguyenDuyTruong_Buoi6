package vn.hcmunre.lab05_1.pager;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ScreenSlidePagerAdapter extends FragmentStateAdapter {
    public ScreenSlidePagerAdapter(@NonNull FragmentActivity fa) { super(fa); }
    @NonNull @Override public Fragment createFragment(int position) {
        return (position == 0) ? new FirstFragment() : new SecondFragment();
    }
    @Override public int getItemCount() { return 2; }
}
