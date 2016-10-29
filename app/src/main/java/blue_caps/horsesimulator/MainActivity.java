package blue_caps.horsesimulator;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ViewPager pager;
    private TextView valueStamina;
    private TextView valueSatiety;
    private TextView valueHappiness;
    private TextView valueDays;
    private TextView valueGoldApple;
    public static final int PAGE_COUNT = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Controller controller = new Controller();
        setContentView(R.layout.activity_main);
        valueDays = (TextView) findViewById(R.id.value_day);
        valueGoldApple = (TextView) findViewById(R.id.value_goldapple);
        valueStamina = (TextView) findViewById(R.id.value_stamina);
        valueSatiety = (TextView) findViewById(R.id.value_satiety);
        valueHappiness = (TextView) findViewById(R.id.value_happiness);
        /*valueStamina.setText(controller.getHorse().getStamina());
        valueSatiety.setText(controller.getHorse().getSatiety());
        valueHappiness.setText(controller.getHorse().getHappiness());
        valueDays.setText(controller.getLifeTime());
        valueGoldApple.setText(controller.getGoldApple());*/
        pager = (ViewPager) findViewById(R.id.pager);
        PagerAdapter pagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(pagerAdapter);
    }

    private class MyFragmentPagerAdapter extends FragmentPagerAdapter {
       public MyFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
            }

        @Override
        public Fragment getItem(int position) {
            return TestFragment.newInstance();
            }
        @Override
        public int getCount() {
            return PAGE_COUNT;
            }
        @Override
        public CharSequence getPageTitle(int position) {
            return "Title " + position;
        }

    }
}
