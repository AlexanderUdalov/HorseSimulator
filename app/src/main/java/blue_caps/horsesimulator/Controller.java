package blue_caps.horsesimulator;

import android.app.Activity;

import java.util.Random;
import java.util.zip.CheckedInputStream;


/**
 * Created by AlexUD on 25.10.2016.
 */

public class Controller {
    private int mTimeToAttack = Constants.timeToRomaAttack;
    private int mChanceAttackPercent = 10;
    private int mLifeTime = 1;
    private int mTimeToChampionship = Constants.timeToChampionship;
    private int mGoldApple = 0;
    private int mTotalScore = 0;
    private int mCountRomaAttack = 0;
    private int mCountBattlesWon = 0;
    private int mDieTime = 4;

    Random rd = new Random();
    private Horse mHorse  = new Horse();

    public void wasStep(Activity act){
        mHorse.downHappiness(Constants.wasStepDownHappiness);
        mHorse.downSatiety(Constants.wasStepDownSatiety);
        mHorse.downStamina(Constants.wasStepDownStamina);
        mLifeTime++;

        if (mTimeToAttack > 0)
            mTimeToAttack--;
        if (mTimeToChampionship > 0)
            mTimeToChampionship--;

        dieAlert(act);
        dieDialog(act);
        romaAttack(act);
    }

    public void dieAlert(Activity act){
        if (mHorse.getSatiety() == 0 ||
                mHorse.getStamina() == 0 ||
                mHorse.getHappiness() == 0) {
            if (mDieTime == 4)
                MainActivity.showDieAlert(act);
            mDieTime--;
        }
        else mDieTime = 4;
    }

    public void dieDialog(Activity act){
        if (mDieTime == 0)
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

    }

    public void findApple(){
        Random rd = new Random();
        mHorse.downStamina(Constants.findAppleDownStamina);
        mHorse.downSatiety(Constants.findAppleDownSatiety);
        int difference = rd.nextInt(5) + 1;
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
        bobMuscles();
    }


    public void bobMuscles(){
        mHorse.downSatiety(Constants.bobMusclesDownSatiety);
        mHorse.downStamina(Constants.bobMusclesDownStamina);
        mHorse.upMaxSpeed();
        mGoldApple -= 1;
    }

    public boolean participateChampionship(){
        mTimeToChampionship = 10;
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
        if (rd.nextInt(60) + 1 + 2*mHorse.getMaxSpeed() > 2 * Horse.mMaxSpeedLimit + 5) {
            mHorse.downStamina(mHorse.getStamina()/2);
            mHorse.downSatiety(mHorse.getSatiety()/2);
            mCountRomaAttack++;
            mTimeToAttack = Constants.timeToRomaAttack;
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

        if (rd.nextInt(1500) + 2 + 3*param > 1600) {
            mHorse.downStamina(mHorse.getStamina()/2);
            mHorse.downSatiety(mHorse.getSatiety()/2);
            mCountRomaAttack++;
            mTimeToAttack = Constants.timeToRomaAttack;
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

    public void setmTimeToAttack(int TimeToAttack) {
        mTimeToAttack = TimeToAttack;
    }

    public int getCountRomaAtack() {
        return mCountRomaAttack;
    }
}
