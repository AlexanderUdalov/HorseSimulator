package blue_caps.horsesimulator;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by alexu on 29.10.2016.
 */

public class AdapterForViewPager extends FragmentPagerAdapter{
    public AdapterForViewPager(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return TestFragment.newInstance();
    }
    @Override
    public int getCount() {
        return MainActivity.PAGE_COUNT;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return "Title " + position;
    }

}

