package blue_caps.horsesimulator;

import android.app.Activity;

import java.util.Random;
import java.util.zip.CheckedInputStream;


/**
 * Created by AlexUD on 25.10.2016.
 */

public class Controller {
    private int mTimeToAttack = Constants.maxTimeToRomaAttack;
    private int mChanceAttackPercent = 10;
    private int mLifeTime = 1;
    private int mTimeToChampionship = Constants.timeToChampionship;
    private int mGoldApple = 0;
    private int mTotalScore = 0;
    private int mCountRomaAttack = 0;
    private int mCountBattlesWon = 0;
    private int mDieTimeSatiety = 4;
    private int mDieTimeStamina = 4;
    private int mDieTimeHappiness = 4;
    private int [] mNextLevel = {Constants.amazingHorse, Constants.pickupMasterHorse, Constants.bossHorse,Constants.godHorse};
    private int index = 0;


    Random rd = new Random();
    private Horse mHorse  = new Horse();

    public void wasStep(Activity act){
        mHorse.downHappiness(Constants.wasStepDownHappiness);
        mHorse.downSatiety(Constants.wasStepDownSatiety);
        mHorse.downStamina(Constants.wasStepDownStamina);
        mTotalScore = (int) ((getHorse().getMaxSpeed())-20)*100 +
                mLifeTime*100 +
                getHorse().getRespectHorses()*20 +
                getHorse().getRespectPeoples()*20 +
                mCountBattlesWon*1000;

        if (mHorse.getLevel() != Level.HORSE_GOD)
            if (mTotalScore > mNextLevel[index]){
                index++;
                mHorse.setLevel(Level.values()[index]);
                MainActivity.showHorsePicture(index, act);
            }

        mLifeTime++;

        if (mTimeToAttack > 0)
            mTimeToAttack--;
        if (mTimeToChampionship > 0)
            mTimeToChampionship--;
        romaAttack(act);
    }

    public void dieCheck(Activity act){
        dieAlert(act);
        dieDialog(act);
    }

    public void dieAlert(Activity act){
        if (mHorse.getStamina() == 0) {
            if (mDieTimeStamina == 4)
                MainActivity.showDieAlert(act);
            mDieTimeStamina--;
        }
        else mDieTimeStamina = 4;
        if (mHorse.getSatiety() == 0) {
            if ((mDieTimeSatiety == 4)&&(mDieTimeStamina > 3))
                MainActivity.showDieAlert(act);
            mDieTimeSatiety--;
        }
        else mDieTimeSatiety = 4;
        if (mHorse.getHappiness() == 0) {
            if ((mDieTimeHappiness == 4)&&(mDieTimeStamina > 3)&&(mDieTimeSatiety > 3))
                MainActivity.showDieAlert(act);
            mDieTimeHappiness--;
        }
        else mDieTimeHappiness = 4;
    }

    public void dieDialog(Activity act){
        if ((mDieTimeStamina == 0)||(mDieTimeSatiety == 0)||(mDieTimeHappiness == 0))
            MainActivity.showDieDialog(act);
    }

    public void romaAttack(Activity act){
        Random rd = new Random();
        if (mTimeToAttack == 0&& rd.nextInt(100) < mChanceAttackPercent) {
            MainActivity.showRomaAttack((MainActivity)act);
        }
    }
    /* Function for satiety   */

    public void eatGrass(){
        mHorse.upSatiety(Constants.eatGrassUpSatiety);
        mHorse.downStamina(Constants.eatGrassDownStamina);
    }

    public void stealingFood(){
        mHorse.upSatiety(Constants.stealingFoodUpSatiety);
        mHorse.downStamina(Constants.stealingFoodDownStamina);
        mHorse.downHappiness(Constants.stealingFoodDownHappiness);
        mHorse.upRespectHorses(Constants.stealingFoodUpRespectHorses);
        mHorse.downRespectPeoples(Constants.stealingFoodDownRespectPeoples);
    }

    public void beggingSugar(){
        mHorse.upSatiety(Constants.beggingSugarUpSatiety);
        mHorse.downStamina(Constants.beggingSugarDownStamina);
        mHorse.upHappiness(Constants.beggingSugarUpHappiness);
        mHorse.downRespectHorses(Constants.beggingSugarDownRespectHorses);
        mHorse.upRespectPeoples(Constants.beggingSugarUpRespectPeoples);
    }


    public void askForFood(){
        mHorse.upSatiety(Constants.askForFoodUpSatiety);
        mHorse.upHappiness(Constants.askForFoodUpHappiness);
        mHorse.downStamina(Constants.askForFoodDownStamina);
    }

    public void eatApple(){
        if (mGoldApple > 0){
            mGoldApple--;
            mHorse.upHappiness(Constants.eatAppleUpHappiness);
            mHorse.upSatiety(Constants.eatAppleUpSatiety);
        }
        else return;
    }

    /* Function for stamina  */

    public void haveSleep() {
        switch (mHorse.getHabitat()){
            case TABOR: { sleepParamChange(Constants.haveSleepUpStaminaTABOR, Constants.haveSleepDownSatietyTABOR); break; }
            case WASTELAND: { sleepParamChange(Constants.haveSleepUpStaminaWASTELAND, Constants.haveSleepDownSatietyWASTELAND); break; }
            case CLEAR_FIELD: { sleepParamChange(Constants.haveSleepUpStaminaCLEAR_FIELD, Constants.haveSleepDownSatietyCLEAR_FIELD); break; }
            case MEADOWS: { sleepParamChange(Constants.haveSleepUpStaminaMEADOWS, Constants.haveSleepDownSatietyMEADOWS); break; }
            case PRAIRIE: { sleepParamChange(Constants.haveSleepUpStaminaPRAIRIE, Constants.haveSleepDownSatietyPRAIRIE, Constants.haveSleepUpHappinessPRAIRIE); break; }
            case KAZAKHSTAN: { sleepParamChange(Constants.haveSleepUpStaminaKAZAKHSTAN, Constants.haveSleepDownSatietyKAZAKHSTAN, Constants.haveSleepUpHappinessKAZAKHSTAN); break; }
            case PADDOCK: { sleepParamChange(Constants.haveSleepUpStaminaPADDOCK, Constants.haveSleepDownSatietyPADDOCK); break; }
            case STABLE: { sleepParamChange(Constants.haveSleepUpStaminaSTABLE, Constants.haveSleepDownSatietySTABLE); break; }
            case RANCH: { sleepParamChange(Constants.haveSleepUpStaminaRANCH, Constants.haveSleepDownSatietyRANCH); break; }
            case HORSE_CLUB: { sleepParamChange(Constants.haveSleepUpStaminaHORSE_CLUB, Constants.haveSleepDownSatietyHORSE_CLUB, Constants.haveSleepUpHappinessHORSE_CLUB); break; }
            case PRIVATE_FARM:{ sleepParamChange(Constants.haveSleepUpStaminaPRICATE_FARM, Constants.haveSleepDownSatietyPRICATE_FARM, Constants.haveSleepUpHappinessPRICATE_FARM); break; }
        }
    }

    public void goToWatering(){
        mHorse.upStamina(Constants.goToWateringUpStamina);
        mHorse.downSatiety(Constants.goToWateringDownSatiety);
        mHorse.upHappiness(Constants.goToWateringUpHappiness);
    }

    public void goToDrinkers(){
        mHorse.upStamina(Constants.goToDrinkersUpStamina);
        mHorse.downSatiety(Constants.goToDrinkersDownSatiety);
        mHorse.upHappiness(Constants.goToDrinkersUpHappiness);
    }

    public void getMassage(){
        mHorse.upStamina(Constants.getMassageUpStamina);
        mHorse.upHappiness(Constants.getMassageUpHappiness);
    }

    public void swimInLake(){
        mHorse.upStamina(Constants.swimInLakeUpStamina);
        mHorse.upHappiness(Constants.swimInLakeUpHappiness);
    }

    /* Other function  */
    public void getApples(){
            mGoldApple += 2;
    }

    public void findApple(){
        Random rd = new Random();
        mHorse.downStamina(Constants.findAppleDownStamina);
        mHorse.downSatiety(Constants.findAppleDownSatiety);
        int difference = rd.nextInt(2);
        mGoldApple += difference;
    }

    public void plowedField(){
        mHorse.downStamina(Constants.plowedFieldDownStamina);
        mHorse.downSatiety(Constants.plowedFieldDownSatiety);
        mHorse.downRespectHorses(Constants.plowedFieldDownRespectHorses);
        mHorse.upRespectPeoples(Constants.plowedFieldUpRespectPeoples);
    }

    public void helpPeople(){
        mHorse.downStamina(Constants.helpPeopleDownStamina);
        mHorse.downSatiety(Constants.helpPeopleDownSatiety);
        mHorse.downRespectHorses(Constants.helpPeopleDownRespectHorses);
        mHorse.upRespectPeoples(Constants.helpPeopleUpRespectPeoples);
    }

    public void helpHorses(){
        mHorse.downStamina(Constants.helpHorsesDownStamina);
        mHorse.downSatiety(Constants.helpHorsesDownSatiety);
        mHorse.upRespectHorses(Constants.helpHorsesUpRespectHorses);
        mHorse.downRespectPeoples(Constants.helpHorsesDownRespectPeoples);
    }

    public void knockCorralGate(){
        mHorse.downSatiety(Constants.knockCorralGateDownSatiety);
        mHorse.downStamina(Constants.knockCorralGateDownStamina);
        mHorse.downRespectPeoples(Constants.knockCorralGateDownRespectPeoples);
        mHorse.upRespectHorses(Constants.knockCorralGateUpRespectHorses);
    }

    public void participateHorseRace(){
        mHorse.downSatiety(Constants.participateHorseRaceDownSatiety);
        mHorse.downStamina(Constants.participateHorseRaceDownStamina);
        mHorse.upRespectHorses(Constants.participateHorseRaceUpRespectHorses);
        mHorse.upRespectPeoples(Constants.participateHorseRaceUpRespectPeople);
        mGoldApple--;
    }


    public void bobMuscles(){
        mHorse.downSatiety(Constants.bobMusclesDownSatiety);
        mHorse.downStamina(Constants.bobMusclesDownStamina);
        mHorse.upMaxSpeed();
        mGoldApple -= 1;
    }

    public boolean participateChampionship(){
        mTimeToChampionship = Constants.timeToChampionship;
        mHorse.downStamina(Constants.participateChampionshipDownStamina);
        mHorse.downSatiety(Constants.participateChampionshipDownSatiety);
        if (rd.nextInt(60) + 1 + 2*mHorse.getMaxSpeed() > 2 * Horse.mMaxSpeedLimit + 5){
            mGoldApple += Constants.participateChampionshipUpApples;
            mHorse.upRespectHorses(Constants.participateChampionshipUpRespectHorses);
            mHorse.upRespectPeoples(Constants.participateChampionshipUpRespectPeoples);
            mHorse.upHappiness(Constants.participateChampionshipUpHappiness);
            return true;
        }
        mHorse.downRespectHorses(Constants.participateChampionshipDownRespectHorses);
        mHorse.downRespectPeoples(Constants.participateChampionshipDownRespectPeoples);
        mHorse.downHappiness(Constants.participateChampionshipDownHappiness);
        return false;
    }
    public void sleepParamChange(int stamina, int satiety){
        mHorse.upStamina(stamina);
        mHorse.downSatiety(satiety);
    }

    public void sleepParamChange(int stamina, int satiety, int happiness){
        sleepParamChange(stamina, satiety);
        mHorse.upHappiness(happiness);
    }

    public boolean runFromRoma() {
        mCountRomaAttack++;

        if (mCountRomaAttack < (Constants.maxTimeToRomaAttack-Constants.minTimeToRomaAttack)/2)
            mTimeToAttack = Constants.maxTimeToRomaAttack - mCountRomaAttack*2;
        else
            mTimeToAttack = Constants.minTimeToRomaAttack;

        if (rd.nextInt(60) + 1 + 2*mHorse.getMaxSpeed() > 2 * Horse.mMaxSpeedLimit + 5) {
            mHorse.downStamina(mHorse.getStamina()/2);
            mHorse.downSatiety(mHorse.getSatiety()/2);

            return true;
        }

        return false;
    }

    public boolean fightWithRoma() {
        int param;

        switch (mHorse.getHabitat()) {
            case TABOR:
                param = Math.max(mHorse.getRespectHorses(), mHorse.getRespectPeoples());
                break;
            case PADDOCK:
            case STABLE:
            case RANCH:
            case HORSE_CLUB:
            case PRIVATE_FARM:
                param = mHorse.getRespectPeoples();
                break;
            default:
                param = mHorse.getRespectHorses();
                break;
        }

        mCountRomaAttack++;

        if (mCountRomaAttack < (Constants.maxTimeToRomaAttack-Constants.minTimeToRomaAttack)/2)
            mTimeToAttack = Constants.maxTimeToRomaAttack - mCountRomaAttack*2;
        else
            mTimeToAttack = Constants.minTimeToRomaAttack;

        if (rd.nextInt(1500) + 2 + 3*param > 1600) {
            mHorse.downStamina(mHorse.getStamina()/2);
            mHorse.downSatiety(mHorse.getSatiety()/2);
            mCountBattlesWon++;

            return true;
        }

        return false;
    }

    public Horse getHorse() {
        return mHorse;
    }

    public int getLifeTime() {
        return mLifeTime;
    }

    public int getTimeToChampionship() {
        return mTimeToChampionship;
    }

    public int getGoldApple() {
        return mGoldApple;
    }

    public int getTotalScore() {
        return mTotalScore;
    }

    public int getTimeToAttack() {
        return mTimeToAttack;
    }

    public void setTimeToChampionship(int timeToChampionship) {
        mTimeToChampionship = timeToChampionship;
    }

    public void setTimeToAttack(int TimeToAttack) {
        mTimeToAttack = TimeToAttack;
    }

    public int getCountRomaAtack() {
        return mCountRomaAttack;
    }

    public int getDieTimeHappiness() {
        return mDieTimeHappiness;
    }

    public int getDieTimeStamina() {
        return mDieTimeStamina;
    }

    public int getDieTimeSatiety() {
        return mDieTimeSatiety;
    }

    public int getCountBattlesWon() {
        return mCountBattlesWon;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setLifeTime(int mLifeTime) {
        this.mLifeTime = mLifeTime;
    }

    public void setGoldApple(int mGoldApple) {
        this.mGoldApple = mGoldApple;
    }

    public void setTotalScore(int mTotalScore) {
        this.mTotalScore = mTotalScore;
    }

    public void setCountRomaAttack(int mCountRomaAttack) {
        this.mCountRomaAttack = mCountRomaAttack;
    }


    public void setCountBattlesWon(int mCountBattlesWon) {
        this.mCountBattlesWon = mCountBattlesWon;
    }

    public void setDieTimeSatiety(int mDieTimeSatiety) {
        this.mDieTimeSatiety = mDieTimeSatiety;
    }

    public void setDieTimeStamina(int mDieTimeStamina) {
        this.mDieTimeStamina = mDieTimeStamina;
    }

    public void setDieTimeHappiness(int mDieTimeHappiness) {
        this.mDieTimeHappiness = mDieTimeHappiness;
    }
}
