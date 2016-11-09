package blue_caps.horsesimulator;


import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
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
    private SharedPreferences sPref;
    static boolean isStart = true;

    private final String
            TIME_TO_ATTACK = "TIME_TO_ATTACK",
            LIFE_TIME = "LIFE_TIME",
            TIME_TO_CHAMPIONSHIP = "TIME_TO_CHAMPIONSHIP",
            GOLD_APPLE = "GOLD_APPLE",
            TOTAL_SCORE = "TOTAL_SCORE",
            COUNT_ROMA_ATTACK = "COUNT_ROMA_ATTACK",
            COUNT_BATTLE_WON = "COUNT_BATTLE_WON",
            DIE_TIME_STAMINA = "DIE_TIME_STAMINA",
            DIE_TIME_SATIETY = "DIE_TIME_SATIETY",
            DIE_TIME_HAPPINESS = "DIE_TIME_HAPPINESS",
            STAMINA = "STAMINA",
            SATIETY = "SATIETY",
            HAPPINESS = "HAPPINESS",
            RESPECT_HORSES = "RESPECT_HORSES",
            RESPECT_PEOPLES = "RESPECT_PEOPLES",
            MAX_SPEED = "MAX_SPEED",
            HABITAT = "HABITAT",
            LEVEL = "LEVEL",
            NEXT_LEVEL_INDEX = "NEXT_LEVEL_INDEX",
            IS_START = "IS_START";

    @Override
    protected void onDestroy(){
        super.onDestroy();
        save();
    }

    @Override
    protected void onPause(){
        super.onPause();
        save();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();

        controller = new Controller();
        setContentView(R.layout.activity_main);

        load();

        if (isStart)
            showHowToPlay(this);
        isStart = false;

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
        TITLE_4 = getString(R.string.habitat);
        TITLE_3 = getString(R.string.other);

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
                        isStart = true;
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
                    MainActivity.updateStats();
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
                            controller.setTimeToAttack(Constants.timeToRomaAttack);
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
                    MainActivity.updateStats();
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
                            controller.setTimeToAttack(Constants.timeToRomaAttack);
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

    public void save(){
        sPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();

        ed.putInt(TIME_TO_ATTACK, MainActivity.controller.getTimeToAttack());
        ed.putInt(TIME_TO_CHAMPIONSHIP, MainActivity.controller.getTimeToChampionship());
        ed.putInt(GOLD_APPLE, MainActivity.controller.getGoldApple());
        ed.putInt(LIFE_TIME, MainActivity.controller.getLifeTime());
        ed.putInt(TOTAL_SCORE, MainActivity.controller.getTotalScore());
        ed.putInt(COUNT_ROMA_ATTACK, MainActivity.controller.getCountRomaAtack());
        ed.putInt(COUNT_BATTLE_WON, MainActivity.controller.getCountBattlesWon());
        ed.putInt(DIE_TIME_STAMINA, MainActivity.controller.getDieTimeStamina());
        ed.putInt(DIE_TIME_HAPPINESS, MainActivity.controller.getDieTimeHappiness());
        ed.putInt(DIE_TIME_SATIETY, MainActivity.controller.getDieTimeSatiety());

        ed.putInt(STAMINA, MainActivity.controller.getHorse().getStamina());
        ed.putInt(SATIETY, MainActivity.controller.getHorse().getSatiety());
        ed.putInt(HAPPINESS, MainActivity.controller.getHorse().getHappiness());
        ed.putInt(RESPECT_HORSES, MainActivity.controller.getHorse().getRespectHorses());
        ed.putInt(RESPECT_PEOPLES, MainActivity.controller.getHorse().getRespectPeoples());
        ed.putFloat(MAX_SPEED, MainActivity.controller.getHorse().getMaxSpeed());
        ed.putInt(HABITAT, (MainActivity.controller.getHorse().getHabitat().ordinal()));
        ed.putInt(LEVEL, (MainActivity.controller.getHorse().getLevel().ordinal()));
        ed.putInt(NEXT_LEVEL_INDEX, MainActivity.controller.getIndex());
        ed.putBoolean(IS_START, isStart);

        ed.apply();
    }

    public void load(){
        sPref = getPreferences(MODE_PRIVATE);
        isStart = sPref.getBoolean(IS_START, true);
        if(!(isStart)) {
            MainActivity.controller.setLifeTime(sPref.getInt(LIFE_TIME, 1));
            MainActivity.controller.setTimeToAttack(sPref.getInt(TIME_TO_ATTACK, 0));
            MainActivity.controller.setTimeToChampionship(sPref.getInt(TIME_TO_CHAMPIONSHIP, 0));
            MainActivity.controller.setGoldApple(sPref.getInt(GOLD_APPLE, 0));
            MainActivity.controller.setTotalScore(sPref.getInt(TOTAL_SCORE, 0));
            MainActivity.controller.setCountRomaAttack(sPref.getInt(COUNT_ROMA_ATTACK, 0));
            MainActivity.controller.setCountBattlesWon(sPref.getInt(COUNT_BATTLE_WON, 0));
            MainActivity.controller.setDieTimeStamina(sPref.getInt(DIE_TIME_STAMINA, 4));
            MainActivity.controller.setDieTimeHappiness(sPref.getInt(DIE_TIME_HAPPINESS, 4));
            MainActivity.controller.setDieTimeSatiety(sPref.getInt(DIE_TIME_SATIETY, 4));

            MainActivity.controller.getHorse().setStamina(sPref.getInt(STAMINA, 50));
            MainActivity.controller.getHorse().setSatiety(sPref.getInt(SATIETY, 50));
            MainActivity.controller.getHorse().setHappiness(sPref.getInt(HAPPINESS, 50));
            MainActivity.controller.getHorse().setRespectHorses(sPref.getInt(RESPECT_HORSES, 0));
            MainActivity.controller.getHorse().setRespectPeoples(sPref.getInt(RESPECT_PEOPLES, 0));
            MainActivity.controller.getHorse().setMaxSpeed(sPref.getFloat(MAX_SPEED, 20));
            MainActivity.controller.getHorse().setHabitat(Habitat.values()[sPref.getInt(HABITAT, 0)]);
            MainActivity.controller.getHorse().setLevel(Level.values()[sPref.getInt(LEVEL, 0)]);
            MainActivity.controller.setIndex(sPref.getInt(NEXT_LEVEL_INDEX, 1));
        }
    }
}


