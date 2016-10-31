package blue_caps.horsesimulator;


import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ViewPager pager;
    private TextView valueStamina;
    private TextView valueSatiety;
    private TextView valueHappiness;
    private TextView valueDays;
    private TextView valueGoldApple;
    private ImageView scaleStamina;
    private ImageView scaleSatiety;
    private ImageView scaleHappiness;
    public static String TITLE_0;
    public static Controller controller;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        controller = new Controller();
        setContentView(R.layout.activity_main);

        TITLE_0 = getString(R.string.stat);

        scaleStamina = (ImageView) findViewById(R.id.scale_stamina);
        scaleSatiety = (ImageView) findViewById(R.id.scale_satiety);
        scaleHappiness = (ImageView) findViewById(R.id.scale_happiness);
        valueDays = (TextView) findViewById(R.id.value_day);
        valueGoldApple = (TextView) findViewById(R.id.value_goldapple);
        valueStamina = (TextView) findViewById(R.id.value_stamina);
        valueSatiety = (TextView) findViewById(R.id.value_satiety);
        valueHappiness = (TextView) findViewById(R.id.value_happiness);

        valueStamina.setText(controller.getHorse().getStamina() + "%");
        valueSatiety.setText(controller.getHorse().getSatiety() + "%");
        valueHappiness.setText(controller.getHorse().getHappiness() + "%");
        valueDays.setText(" " + controller.getLifeTime());
        valueGoldApple.setText("" + controller.getGoldApple());

        pager = (ViewPager) findViewById(R.id.pager);
        PagerAdapter pagerAdapter = new AdapterForViewPager(getSupportFragmentManager());
        pager.setAdapter(pagerAdapter);
        setDrawable();
    }

    /*Следующая функция написана самым быдлокодерским способом, потому что я не знаю
        как по-другому закинуть туда размеры(
        */
    public void setDrawable(){
        int windowSize = getWindowManager().getDefaultDisplay().getWidth();
        int DPI = (int) getResources().getDisplayMetrics().density;
        int border = DPI*16;
        float staminaWidth = (windowSize - 2*border)*((float)controller.getHorse().getStamina())/Horse.mMaxStamina;
        float satietyWidth = (windowSize - 2*border)*((float)controller.getHorse().getSatiety())/Horse.mMaxSatiety;
        float happinessWidth = (windowSize - 2*border)*((float)controller.getHorse().getHappiness())/Horse.mMaxHappiness;
        ShapeDrawable shapeStamina = new ShapeDrawable(new RectShape());
        ShapeDrawable shapeSatiety = new ShapeDrawable(new RectShape());
        ShapeDrawable shapeHappiness = new ShapeDrawable(new RectShape());

        shapeStamina.setIntrinsicHeight(10*DPI);
        shapeStamina.setIntrinsicWidth((int)staminaWidth);
        shapeStamina.getPaint().setARGB(100,
                getRedColorFromValue(((float)controller.getHorse().getStamina())/Horse.mMaxStamina),
                getGreenColorFromValue(((float)controller.getHorse().getStamina())/Horse.mMaxStamina),0);
        scaleStamina.setImageDrawable(shapeStamina);

        shapeSatiety.setIntrinsicHeight(10*DPI);
        shapeSatiety.setIntrinsicWidth((int)satietyWidth);
        shapeSatiety.getPaint().setARGB(100,
                getRedColorFromValue(((float)controller.getHorse().getSatiety())/Horse.mMaxSatiety),
                getGreenColorFromValue(((float)controller.getHorse().getSatiety())/Horse.mMaxSatiety),0);
        scaleSatiety.setImageDrawable(shapeSatiety);

        shapeHappiness.setIntrinsicHeight(10*DPI);
        shapeHappiness.setIntrinsicWidth((int)happinessWidth);
        shapeHappiness.getPaint().setARGB(100,
                getRedColorFromValue(((float)controller.getHorse().getHappiness())/Horse.mMaxHappiness),
                getGreenColorFromValue(((float)controller.getHorse().getHappiness())/Horse.mMaxHappiness),0);
        scaleHappiness.setImageDrawable(shapeHappiness);
    }

    public int getRedColorFromValue(float value){
        return (int) (255*(1 - value));
    }

    public int getGreenColorFromValue(float value){
        return (int) (255*value);
    }
}
