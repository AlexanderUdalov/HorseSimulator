package blue_caps.horsesimulator;


import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ViewPager pager;
    private static TextView
            valueStamina,
            valueSatiety,
            valueHappiness,
            valueDays,
            valueGoldApple;
    private static ImageView
            scaleStamina,
            scaleSatiety,
            scaleHappiness,
            imageGoldApple,
            imageStamina,
            imageSatiety,
            imageHappiness;
    private static int
            DPI,
            windowSize;
    private static float
            staminaWidth,
            satietyWidth,
            happinessWidth;
    public static String
            TITLE_0,
            TITLE_1,
            TITLE_2,
            TITLE_3,
            TITLE_4;
    public static Page_0 page_0;
    public static Page_1 page_1;
    public static Page_2 page_2;
    public static Page_3 page_3;
    public static Page_4 page_4;
    static Controller controller;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();

        controller = new Controller();
        setContentView(R.layout.activity_main);
        showHowToPlay(this);

        page_0 = new Page_0();
        page_1 = new Page_1();
        page_2 = new Page_2();
        page_3 = new Page_3();
        page_4 = new Page_4();


        windowSize = getWindowManager().getDefaultDisplay().getWidth();
        DPI = (int) getResources().getDisplayMetrics().density;

        TITLE_1 = getString(R.string.stamina);
        TITLE_0 = getString(R.string.stat);
        TITLE_2 = getString(R.string.food);
        TITLE_3 = getString(R.string.habitat);
        TITLE_4 = getString(R.string.other);

        imageStamina = (ImageView) findViewById(R.id.image_stamina);
        imageSatiety = (ImageView) findViewById(R.id.image_satiety);
        imageHappiness = (ImageView) findViewById(R.id.image_happiness);
        imageGoldApple = (ImageView) findViewById(R.id.image_goldapple);
        scaleStamina = (ImageView) findViewById(R.id.scale_stamina);
        scaleSatiety = (ImageView) findViewById(R.id.scale_satiety);
        scaleHappiness = (ImageView) findViewById(R.id.scale_happiness);
        valueDays = (TextView) findViewById(R.id.value_day);
        valueGoldApple = (TextView) findViewById(R.id.value_goldapple);
        valueStamina = (TextView) findViewById(R.id.value_stamina);
        valueSatiety = (TextView) findViewById(R.id.value_satiety);
        valueHappiness = (TextView) findViewById(R.id.value_happiness);


        imageGoldApple.setImageResource(R.drawable.image_goldapple);
        imageStamina.setImageResource(R.drawable.stamina);
        imageSatiety.setImageResource(R.drawable.satiety);
        imageHappiness.setImageResource(R.drawable.happiness);

        pager = (ViewPager) findViewById(R.id.pager);
        PagerAdapter pagerAdapter = new AdapterForViewPager(getSupportFragmentManager());
        pager.setAdapter(pagerAdapter);
        updateStats();
    }

    /*Следующая функция написана самым быдлокодерским способом, потому что я не знаю
        как по-другому закинуть туда размеры =(
        */

    public static void updateStats(){
        valueStamina.setText(controller.getHorse().getStamina() + "%");
        valueSatiety.setText(controller.getHorse().getSatiety() + "%");
        valueHappiness.setText(controller.getHorse().getHappiness() + "%");
        valueDays.setText(" " + controller.getLifeTime());
        valueGoldApple.setText("" + controller.getGoldApple());

        int border = DPI*0;
        staminaWidth = (windowSize - 2*border)*((float)controller.getHorse().getStamina())/Horse.mMaxStamina;
        satietyWidth = (windowSize - 2*border)*((float)controller.getHorse().getSatiety())/Horse.mMaxSatiety;
        happinessWidth = (windowSize - 2*border)*((float)controller.getHorse().getHappiness())/Horse.mMaxHappiness;

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

    public static int getRedColorFromValue(float value){
        return (int) (255*(1 - value));
    }

    public static int getGreenColorFromValue(float value){
        return (int) (255*value);
    }

    public static void showHowToPlay(Activity act){
        final AlertDialog.Builder builder = new AlertDialog.Builder(act);
        builder.setTitle(R.string.introducing_speech_title).setCancelable(true);
        View v = LayoutInflater.from(act).inflate(R.layout.introducing_speech, null);
        builder.setView(v);
        AlertDialog alert = builder.create();
        alert.show();
    }

    public static void showDieAlert(Activity act) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(act);
        builder.setTitle(R.string.die_alert_speech_title).setCancelable(true);
        View v = LayoutInflater.from(act).inflate(R.layout.die_alert, null);
        builder.setView(v);
        AlertDialog alert = builder.create();
        alert.show();
    }

    public static void showDieDialog(final Activity act) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(act);
        builder.setTitle(R.string.die_speech_title).setCancelable(false)
                .setNegativeButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent starterIntent = act.getIntent();
                        act.finish();
                        act.startActivity(starterIntent);
                    }
                });
        View v = LayoutInflater.from(act).inflate(R.layout.die_dialog, null);
        builder.setView(v);
        AlertDialog alert = builder.create();
        alert.show();
    }

    public static void showWinChampionship(final Activity act) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(act);
        builder.setTitle(R.string.win_title).setCancelable(true);
        View v = LayoutInflater.from(act).inflate(R.layout.die_dialog, null);
        builder.setView(v);
        AlertDialog alert = builder.create();
        alert.show();
    }

    public static void showLoseChampionship(final Activity act) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(act);
        builder.setTitle(R.string.lose_title).setCancelable(true);
        View v = LayoutInflater.from(act).inflate(R.layout.die_dialog, null);
        builder.setView(v);
        AlertDialog alert = builder.create();
        alert.show();
    }

    public static void showHorsePicture(int index, Activity act) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(act);
        builder.setTitle(R.string.new_level).setCancelable(true);
        View v = LayoutInflater.from(act).inflate(R.layout.new_level, null);
        TextView text = (TextView) v.findViewById(R.id.new_level_text);
        TextView textValue = (TextView) v.findViewById(R.id.new_level_text_value);
        ImageView image = (ImageView) v.findViewById(R.id.new_level_image);
        switch (index) {
            case 1: {
                text.setText(act.getString(R.string.you_are));
                textValue.setText(act.getString(R.string.amazing_horse));
                image.setImageResource(R.drawable.amazing_horse);
                break;
            }
            case 2: {
                text.setText(act.getString(R.string.you_are));
                textValue.setText(act.getString(R.string.pickup_master_horse));
                image.setImageResource(R.drawable.pickup_master_horse);
                break;
            }
            case 3: {
                text.setText(act.getString(R.string.you_are));
                textValue.setText(act.getString(R.string.boss_horse));
                image.setImageResource(R.drawable.boss_horse);
                break;
            }
            case 4: {
                text.setText(act.getString(R.string.you_are));
                textValue.setText(act.getString(R.string.horse_god));
                image.setImageResource(R.drawable.god_horse);
                break;
            }
        }
        builder.setView(v);
        AlertDialog alert = builder.create();
        alert.show();
    }

    public static void showRomaAttack(final MainActivity act) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(act);
        builder.setTitle(R.string.roma_attack_title).setCancelable(false);
        View v = LayoutInflater.from(act).inflate(R.layout.roma_attack, null);
        TextView speechRomaAttack = (TextView) v.findViewById(R.id.roma_attack_speech);

        Button buttonRun = (Button) v.findViewById(R.id.button_run);
        Button buttonFight = (Button) v.findViewById(R.id.button_fight);

        speechRomaAttack.setText(act.getString(R.string.roma_attack_speech));
        buttonRun.setText(act.getString(R.string.run));
        buttonFight.setText(act.getString(R.string.fight));

        builder.setView(v);
        final AlertDialog alert = builder.create();
        alert.show();

        buttonRun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (controller.runFromRoma()) {
                    alert.hide();
                    AlertDialog.Builder successBuilder = new AlertDialog.Builder(act);
                    successBuilder.setTitle(R.string.success).setCancelable(true);
                    successBuilder.setView(LayoutInflater.from(act).inflate(R.layout.success_run, null));

                    final AlertDialog successRun = successBuilder.create();
                    successRun.show();
                }
                else {
                    alert.hide();
                    final AlertDialog.Builder builderAd = new AlertDialog.Builder(act);
                    builderAd.setTitle(R.string.ad_run_title).setCancelable(false);
                    View vAd = LayoutInflater.from(act).inflate(R.layout.ad_death, null);
                    TextView speechAdRun = (TextView) vAd.findViewById(R.id.ad_speech);

                    Button buttonAd = (Button) vAd.findViewById(R.id.button_ad);
                    Button buttonDie = (Button) vAd.findViewById(R.id.button_die);

                    speechAdRun.setText(act.getString(R.string.ad_speech));
                    buttonAd.setText(act.getString(R.string.god));
                    buttonDie.setText(act.getString(R.string.die));

                    builderAd.setView(vAd);
                    final AlertDialog adAlert = builderAd.create();
                    adAlert.show();

                    buttonAd.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            // СЂРµРєР»Р°РјР°
                            controller.setmTimeToAttack(Constants.timeToRomaAttack);
                            adAlert.hide();
                        }
                    });
                    buttonDie.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            adAlert.hide();
                            act.recreate();
                        }
                    });
                }
            }
        });

        buttonFight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (controller.fightWithRoma()) {
                    alert.hide();
                    AlertDialog.Builder successBuilder = new AlertDialog.Builder(act);
                    successBuilder.setTitle(R.string.success).setCancelable(true);
                    successBuilder.setView(LayoutInflater.from(act).inflate(R.layout.success_fight, null));

                    final AlertDialog successRun = successBuilder.create();
                    successRun.show();
                }
                else {
                    alert.hide();
                    final AlertDialog.Builder builderAd = new AlertDialog.Builder(act);
                    builderAd.setTitle(R.string.ad_fight_title).setCancelable(false);
                    View vAd = LayoutInflater.from(act).inflate(R.layout.ad_death, null);
                    TextView speechAdRun = (TextView) vAd.findViewById(R.id.ad_speech);

                    Button buttonAd = (Button) vAd.findViewById(R.id.button_ad);
                    Button buttonDie = (Button) vAd.findViewById(R.id.button_die);

                    speechAdRun.setText(act.getString(R.string.ad_speech));
                    buttonAd.setText(act.getString(R.string.god));
                    buttonDie.setText(act.getString(R.string.die));

                    builderAd.setView(vAd);
                    final AlertDialog adAlert = builderAd.create();
                    adAlert.show();

                    buttonAd.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            // СЂРµРєР»Р°РјР°
                            controller.setmTimeToAttack(Constants.timeToRomaAttack);
                            adAlert.hide();
                        }
                    });
                    buttonDie.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            adAlert.hide();
                            act.recreate();
                        }
                    });
                }
            }
        });
    }
}


