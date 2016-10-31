package blue_caps.horsesimulator;

import java.util.Random;
import java.util.zip.CheckedInputStream;


/**
 * Created by AlexUD on 25.10.2016.
 */
// РџСЂРѕРІРµСЂРєР° Р·Р°РїСѓСЃРєР° СЃ РіРёС‚С…Р°Р±Р° Рё РєРѕРјРјРјРёС‚Р° РѕР±СЂР°С‚РЅРѕ fzsfzed

public class Controller {
    private static int mTimeToAttack = 60;
    private int mChanceAttackPercent = 10;
    private int mLifeTime = 1;
    private int mTimeToChampionship = 10;
    private int mGoldApple = 0;
    private int mTotalScore = 0;
    private int mCountRomaAtack = 0;
    private Horse mHorse  = new Horse();

    public void wasStep(){
        mHorse.downHappiness(Constants.wasStepDownHappiness);
        mHorse.downSatiety(Constants.wasStepDownSatiety);
        mHorse.downStamina(Constants.wasStepDownStamina);
        mLifeTime++;
        if (mTimeToAttack != 0)
            mTimeToAttack--;
        mTimeToChampionship--;
        romaAttack();
    }

    public void romaAttack(){
        Random rd = new Random();
        if (mTimeToAttack == 0&& rd.nextInt(100) < mChanceAttackPercent) {
            // РќР°РїР°СЃС‚СЊ С†С‹РіР°РЅР°Рј
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

    public void haveSleep() throws HabitatNotFoundExceptoin {
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
            default: throw new HabitatNotFoundExceptoin();
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

    public int findApple(){
        Random rd = new Random();
        mHorse.downStamina(Constants.findAppleDownStamina);
        mHorse.downSatiety(Constants.findAppleDownSatiety);
        int difference = rd.nextInt(5) + 1;
        mGoldApple += difference;
        return difference;
    }

    public void plowedField(){
        mHorse.downStamina(Constants.plowedFieldDownStamina);
        mHorse.downSatiety(Constants.plowedFieldDownSatiety);
        mHorse.downRespectHorses(Constants.plowedFieldDownRespectHorses);
        mHorse.upRespectPeoples(Constants.plowedFieldUpRespectPeoples);
    }

    public void drugLoads(){
        mHorse.downStamina(Constants.drugLoadsDownStamina);
        mHorse.downSatiety(Constants.drugLoadsDownSatiety);
        mHorse.downRespectHorses(Constants.drugLoadsDownRespectHorses);
        mHorse.upRespectPeoples(Constants.drugLoadsUpRespectPeoples);
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
    }


    public void bobMuscles(){
        mHorse.downSatiety(Constants.bobMusclesDownSatiety);
        mHorse.downStamina(Constants.bobMusclesDownStamina);
        mHorse.setMaxSpeed(mHorse.getMaxSpeed() + 0.3);
        mGoldApple -= 1;
    }

    public boolean participateChampionship(){
        Random rd = new Random();
        mTimeToChampionship = 10;
        mHorse.downStamina(Constants.participateChampionshipDownStamina);
        mHorse.downSatiety(Constants.participateChampionshipDownSatiety);
        if (rd.nextInt(60) + 1 + 2*mHorse.getMaxSpeed() > 100){
            mGoldApple += 5;
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

    public int getCountRomaAtack() {
        return mCountRomaAtack;
    }
}
