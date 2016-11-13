package blue_caps.horsesimulator;


import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
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
import android.widget.Toast;

import com.vungle.publisher.AdConfig;
import com.vungle.publisher.EventListener;
import com.vungle.publisher.Orientation;
import com.vungle.publisher.VunglePub;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements FragmentEventListener{
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

    public final VunglePub videoDie = VunglePub.getInstance();
    public final VunglePub videoApple = VunglePub.getInstance();
    final static AdConfig dieConfig = new AdConfig();
    final static AdConfig appleConfig = new AdConfig();
    final String app_id = "5823510d305e3dec2d00062f";

    @Override
    public void clickEvent(String name){
        switch (name){
            case "wasStep":{
                wasStep();
                break;
            }
            case "showHowToPlay":{
                showHowToPlay();
                break;
            }
            case "dieCheck":{
                dieCheck();
                break;
            }
            case "getApple":{
                getApple();
                break;
            }
            case "showWinChampionship":{
                showWinChampionship();
                break;
            }
            case "showLoseChampionship":{
                showLoseChampionship();
                break;
            }
        }
    }

    public void getApple(){
        if (videoApple.isAdPlayable()) {
            videoApple.playAd(appleConfig);
            MainActivity.page_2.update();
        }
        else {
            Toast toast = Toast.makeText(getApplicationContext(), getString(R.string.no_internet), Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        save();
    }

    @Override
    protected void onPause(){
        super.onPause();
        videoApple.onPause();
        videoDie.onPause();
        save();
    }

    @Override
    protected void onResume(){
        super.onResume();
        videoApple.onResume();
        videoDie.onResume();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();

        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        videoDie.init(this, app_id);
        videoApple.init(this, app_id);
        makeConfig();
        addListeners();

        controller = new Controller();
        setContentView(R.layout.activity_main);


        load();

        if (isStart) {
            showHowToPlay();
        }
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

    public void wasStep(){
        controller.getHorse().downHappiness(Constants.wasStepDownHappiness);
        controller.getHorse().downSatiety(Constants.wasStepDownSatiety);
        controller.getHorse().downStamina(Constants.wasStepDownStamina);
        controller.setTotalScore((int) ((controller.getHorse().getMaxSpeed())-20)*100 +
                controller.getLifeTime()*100 +
                controller.getHorse().getRespectHorses()*20 +
                controller.getHorse().getRespectPeoples()*20 +
                controller.getCountBattlesWon()*1000);

        if (controller.getHorse().getLevel() != Level.HORSE_GOD)
            if (controller.getTotalScore() > controller.mNextLevel[controller.index]){
                controller.index++;
                controller.getHorse().setLevel(Level.values()[controller.index]);
                showHorsePicture(controller.index);
            }

        controller.setLifeTime(controller.getLifeTime()+1);

        if (controller.getTimeToAttack() > 0)
            controller.setTimeToAttack(controller.getTimeToAttack()-1);
        if (controller.getTimeToChampionship() > 0)
            controller.setTimeToChampionship(controller.getTimeToChampionship()-1);
        romaAttack();
    }

    public void dieCheck(){
        dieAlert();
        dieDialog();
    }

    public void dieAlert(){
        if (controller.getHorse().getStamina() == 0) {
            if (controller.getDieTimeStamina() == 4)
                showDieAlert();
            controller.setDieTimeStamina(controller.getDieTimeStamina()-1);
        }
        else controller.setDieTimeStamina(4);
        if (controller.getHorse().getHappiness() == 0) {
            if ((controller.getDieTimeHappiness() == 4) &&(controller.getDieTimeStamina() == 4))
                showDieAlert();
            controller.setDieTimeHappiness(controller.getDieTimeHappiness()-1);
        }
        else controller.setDieTimeHappiness(4);
        if (controller.getHorse().getSatiety() == 0) {
            if ((controller.getDieTimeSatiety() == 4) &&(controller.getDieTimeStamina() == 4)&&(controller.getDieTimeHappiness() == 4))
                showDieAlert();
            controller.setDieTimeSatiety(controller.getDieTimeSatiety()-1);
        }
        else controller.setDieTimeSatiety(4);
    }

    public void dieDialog(){
        if ((controller.getDieTimeSatiety() == 0)||(controller.getDieTimeStamina() == 0)||(controller.getDieTimeHappiness() == 0))
            showDieDialog();
    }

    public void romaAttack(){
        Random rd = new Random();
        if (controller.getTimeToAttack() == 0&& rd.nextInt(100) < controller.mChanceAttackPercent) {
            showRomaAttack();
        }
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

    public void makeConfig(){
        dieConfig.setBackButtonImmediatelyEnabled(false);
        dieConfig.setIncentivizedCancelDialogTitle(getString(R.string.close_video_title_die));
        dieConfig.setIncentivizedCancelDialogBodyText(getString(R.string.close_video_text_die));
        dieConfig.setIncentivizedCancelDialogCloseButtonText(getString(R.string.close_video_button));
        dieConfig.setIncentivizedCancelDialogKeepWatchingButtonText(getString(R.string.keep_watching_button));
        dieConfig.setIncentivized(true);
        dieConfig.setSoundEnabled(false);
        dieConfig.setImmersiveMode(true);
        dieConfig.setOrientation(Orientation.autoRotate);

        appleConfig.setBackButtonImmediatelyEnabled(false);
        appleConfig.setIncentivizedCancelDialogTitle(getString(R.string.close_video_title_apple));
        appleConfig.setIncentivizedCancelDialogBodyText(getString(R.string.close_video_text_apple));
        appleConfig.setIncentivizedCancelDialogCloseButtonText(getString(R.string.close_video_button));
        appleConfig.setIncentivizedCancelDialogKeepWatchingButtonText(getString(R.string.keep_watching_button));
        appleConfig.setIncentivized(true);
        appleConfig.setSoundEnabled(false);
        appleConfig.setImmersiveMode(true);
        appleConfig.setOrientation(Orientation.autoRotate);
    }

    public void addListeners() {
        videoDie.setEventListeners(new EventListener() {
            @Override
            public void onAdEnd(boolean b, boolean b1) {
                if (b){
                    controller.setGoldApple(controller.getGoldApple() - 2);
                }
                if (!b) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            controller.startGame();
                            updateStats();
                            pager.setCurrentItem(0);
                            page_0.update();
                            page_1.update();
                            showHowToPlay();

                        }
                    });
                }
            }

            @Override
            public void onAdStart() {

            }

            @Override
            public void onAdUnavailable(String s) {

            }

            @Override
            public void onAdPlayableChanged(boolean b) {

            }

            @Override
            public void onVideoView(boolean b, int i, int i1) {

            }
        });

        videoApple.setEventListeners(new EventListener() {
            @Override
            public void onAdEnd(boolean b, boolean b1) {
                if (b) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            controller.getApples();
                            updateStats();
                            page_3.update();
                            page_2.update();
                            page_4.update();

                        }
                    });
                }

            }

            @Override
            public void onAdStart() {

            }

            @Override
            public void onAdUnavailable(String s) {

            }

            @Override
            public void onAdPlayableChanged(boolean b) {

            }

            @Override
            public void onVideoView(boolean b, int i, int i1) {

            }
        });
    }

    public static int getRedColorFromValue(float value){
        return (int) (255*(1 - value));
    }

    public static int getGreenColorFromValue(float value){
        return (int) (255*value);
    }

    public void showHowToPlay(){
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.introducing_speech_title).setCancelable(true);
        View v = LayoutInflater.from(this).inflate(R.layout.introducing_speech, null);
        builder.setView(v);
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void showDieAlert() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.die_alert_speech_title).setCancelable(true);
        View v = LayoutInflater.from(this).inflate(R.layout.die_alert, null);
        builder.setView(v);
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void showDieDialog() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.die_speech_title).setCancelable(false)
                .setNegativeButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        controller.startGame();
                        updateStats();
                        pager.setCurrentItem(0);
                        page_0.update();
                        page_1.update();
                        showHowToPlay();
                    }
                });
        View v = LayoutInflater.from(this).inflate(R.layout.die_dialog, null);
        builder.setView(v);
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void showWinChampionship() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.win_title).setCancelable(true);
        View v = LayoutInflater.from(this).inflate(R.layout.die_dialog, null);
        TextView text = (TextView) v.findViewById(R.id.die_speech);
        text.setText(R.string.win);
        builder.setView(v);
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void showLoseChampionship() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.lose_title).setCancelable(true);
        View v = LayoutInflater.from(this).inflate(R.layout.die_dialog, null);
        TextView text = (TextView) v.findViewById(R.id.die_speech);
        text.setText(R.string.lose);
        builder.setView(v);
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void showHorsePicture(int index) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.new_level).setCancelable(true);
        View v = LayoutInflater.from(this).inflate(R.layout.new_level, null);
        TextView text = (TextView) v.findViewById(R.id.new_level_text);
        TextView textValue = (TextView) v.findViewById(R.id.new_level_text_value);
        ImageView image = (ImageView) v.findViewById(R.id.new_level_image);
        switch (index) {
            case 1: {
                text.setText(this.getString(R.string.you_are));
                textValue.setText(this.getString(R.string.amazing_horse));
                image.setImageResource(R.drawable.amazing_horse);
                break;
            }
            case 2: {
                text.setText(this.getString(R.string.you_are));
                textValue.setText(this.getString(R.string.pickup_master_horse));
                image.setImageResource(R.drawable.pickup_master_horse);
                break;
            }
            case 3: {
                text.setText(this.getString(R.string.you_are));
                textValue.setText(this.getString(R.string.boss_horse));
                image.setImageResource(R.drawable.boss_horse);
                break;
            }
            case 4: {
                text.setText(this.getString(R.string.you_are));
                textValue.setText(this.getString(R.string.horse_god));
                image.setImageResource(R.drawable.god_horse);
                break;
            }
        }
        builder.setView(v);
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void showRomaAttack() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.roma_attack_title).setCancelable(false);
        View v = LayoutInflater.from(this).inflate(R.layout.roma_attack, null);
        TextView speechRomaAttack = (TextView) v.findViewById(R.id.roma_attack_speech);

        Button buttonRun = (Button) v.findViewById(R.id.button_run);
        Button buttonFight = (Button) v.findViewById(R.id.button_fight);

        speechRomaAttack.setText(this.getString(R.string.roma_attack_speech));
        buttonRun.setText(getString(R.string.run));
        buttonFight.setText(getString(R.string.fight));

        builder.setView(v);
        final AlertDialog alert = builder.create();
        alert.show();

        buttonRun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (controller.runFromRoma()) {
                    successRun();
                    alert.hide();
                }
                else {
                    notSuccessRun();
                    alert.hide();
                }
            }
        });

        buttonFight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (controller.fightWithRoma()) {
                    alert.hide();
                    successFight();
                }
                else {
                    alert.hide();
                    notSuccessFight();
                }
            }
        });
    }

    public void successFight(){
        AlertDialog.Builder successBuilder = new AlertDialog.Builder(this);
        successBuilder.setTitle(R.string.success).setCancelable(true);
        successBuilder.setView(LayoutInflater.from(this).inflate(R.layout.success_fight, null));

        final AlertDialog successRun = successBuilder.create();
        MainActivity.updateStats();
        successRun.show();

    }

    public void notSuccessFight(){
        final AlertDialog.Builder builderAd = new AlertDialog.Builder(this);
        builderAd.setTitle(R.string.ad_fight_title).setCancelable(false);
        View vAd = LayoutInflater.from(this).inflate(R.layout.ad_death, null);
        TextView speechAdRun = (TextView) vAd.findViewById(R.id.ad_speech);

        Button buttonAd = (Button) vAd.findViewById(R.id.button_ad);
        Button buttonDie = (Button) vAd.findViewById(R.id.button_die);

        speechAdRun.setText(getString(R.string.ad_fight_speech));
        buttonAd.setText(getString(R.string.god));
        buttonDie.setText(getString(R.string.die));

        builderAd.setView(vAd);
        final AlertDialog adAlert = builderAd.create();
        adAlert.show();

        buttonAd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (videoDie.isAdPlayable()) {
                    videoDie.playAd(dieConfig);
                    controller.setTimeToAttack(Constants.maxTimeToRomaAttack);
                    adAlert.hide();
                }
                else {
                    noInternet();
                }
            }
        });
        buttonDie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller.startGame();
                updateStats();
                pager.setCurrentItem(0);
                page_0.update();
                page_1.update();
                showHowToPlay();
                adAlert.hide();
            }
        });

    }

    public void successRun(){
        AlertDialog.Builder successBuilder = new AlertDialog.Builder(this);
        successBuilder.setTitle(R.string.success).setCancelable(true);
        successBuilder.setView(LayoutInflater.from(this).inflate(R.layout.success_run, null));

        final AlertDialog successRun = successBuilder.create();
        MainActivity.updateStats();
        successRun.show();
    }

    public void notSuccessRun(){
        final AlertDialog.Builder builderAd = new AlertDialog.Builder(this);
        builderAd.setTitle(R.string.ad_run_title).setCancelable(false);
        View vAd = LayoutInflater.from(this).inflate(R.layout.ad_death, null);
        TextView speechAdRun = (TextView) vAd.findViewById(R.id.ad_speech);

        Button buttonAd = (Button) vAd.findViewById(R.id.button_ad);
        Button buttonDie = (Button) vAd.findViewById(R.id.button_die);

        speechAdRun.setText(getString(R.string.ad_run_speech));
        buttonAd.setText(getString(R.string.god));
        buttonDie.setText(getString(R.string.die));

        builderAd.setView(vAd);
        final AlertDialog adAlert = builderAd.create();
        adAlert.show();

        buttonAd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (videoDie.isAdPlayable()) {
                    videoDie.playAd(dieConfig);
                    controller.setTimeToAttack(Constants.maxTimeToRomaAttack);
                    adAlert.hide();
                }
                else {
                    noInternet();
                }
            }
        });
        buttonDie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller.startGame();
                updateStats();
                pager.setCurrentItem(0);
                page_0.update();
                page_1.update();
                showHowToPlay();
                adAlert.hide();
            }
        });
    }

    public void noInternet(){
        Toast toast = Toast.makeText(getApplicationContext(), getString(R.string.no_internet), Toast.LENGTH_SHORT);
        toast.show();
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


