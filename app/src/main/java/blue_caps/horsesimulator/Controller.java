package blue_caps.horsesimulator;

import android.app.Activity;

import java.util.Random;
import java.util.zip.CheckedInputStream;


/**
 * Created by AlexUD on 25.10.2016.
 */

public class Controller {
    private int mTimeToAttack = Constants.maxTimeToRomaAttack;
    public int mChanceAttackPercent = 10;
    private int mLifeTime = 1;
    private int mTimeToChampionship = Constants.timeToChampionship;
    private int mTimeToAdd = 0;
    private int mGoldApple = 5;
    private int mTotalScore = 0;
    private int mCountRomaAttack = 0;
    private int mCountBattlesWon = 0;
    private int mDieTimeSatiety = 4;
    private int mDieTimeStamina = 4;
    private int mDieTimeHappiness = 4;
    public int [] mNextLevel = {Constants.amazingHorse, Constants.pickupMasterHorse, Constants.bossHorse,Constants.godHorse};
    public int index = 0;


    Random rd = new Random();
    private Horse mHorse  = new Horse();

    /* Function for satiety   */

    public void startGame(){
        mTimeToAttack = Constants.maxTimeToRomaAttack;
        mChanceAttackPercent = 10;
        mLifeTime = 1;
        mTimeToChampionship = Constants.timeToChampionship;
        mTimeToAdd = 0;
        mGoldApple = 5;
        mTotalScore = 0;
        mCountRomaAttack = 0;
        mCountBattlesWon = 0;
        mDieTimeSatiety = 4;
        mDieTimeStamina = 4;
        mDieTimeHappiness = 4;
        index = 0;
        mHorse.startGame();
    }

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
        mHorse.downSatiety(Constants.getMassageDownSatiety);
        mHorse.upHappiness(Constants.getMassageUpHappiness);
    }

    public void swimInLake(){
        mHorse.upStamina(Constants.swimInLakeUpStamina);
        mHorse.downSatiety(Constants.swimInLakeDownSatiety);
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

    public int getTimeToAdd() {return mTimeToAdd; }

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

    public void setTimeToAdd(int time) {mTimeToAdd = time; }
}
