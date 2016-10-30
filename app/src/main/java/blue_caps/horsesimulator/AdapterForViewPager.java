package blue_caps.horsesimulator;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by alexu on 29.10.2016.
 */

public class AdapterForViewPager extends FragmentPagerAdapter{

    public static final int PAGE_COUNT = 5;

    public AdapterForViewPager(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: {
                return new Page_0();
            }
            case 1: {
                return new Page_1();
            }
            case 2: {
                return new Page_2();
            }
            case 3: {
                return new Page_3();
            }
            case 4: {
                return new Page_4();
            }
            default: return null;
        }
    }
    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0: {
                return MainActivity.TITLE_0;
            }
            case 1: {
                return Page_1.TITLE;
            }
            case 2: {
                return Page_2.TITLE;
            }
            case 3: {
                return Page_3.TITLE;
            }
            case 4: {
                return Page_4.TITLE;
            }
            default:
                return null;
        }
    }
}

