package blue_caps.horsesimulator;

import java.util.Random;


/**
 * Created by AlexUD on 25.10.2016.
 */
// Проверка запуска с гитхаба и комммита обратно fzsfzed

public class Controller {
    private static final int mTimeToAttack = 60;
    private int mChanceAttackPercent;
    private static int mLifeTime;
    private static int mTimeToChampionship = 10;
    private int mGoldApple;
    private Horse mHorse  = new Horse();;

    Controller(){
        mChanceAttackPercent = 10;
        mLifeTime = 0;
        mGoldApple = 0;
    }

    public void wasStep(){
        mHorse.downHappiness(2);
        mHorse.downSatiety(3);
        mHorse.downStamina(3);
        mLifeTime++;
        mTimeToChampionship--;
        romaAttack();
    }

    public void romaAttack(){
        Random rd = new Random();
        if (mLifeTime < mTimeToAttack)
            return;
        else if (rd.nextInt(100) > mChanceAttackPercent){
            // Напасть цыганам
        }
    }
    /* Function for satiety   */

    public void eatGrass(){
        mLifeTime++;
        mHorse.upSatiety(4);
        mHorse.downStamina(6);
    }

    public void stealingFood(){
        mHorse.upSatiety(8);
        mHorse.downStamina(8);
        mHorse.downHappiness(3);
        mHorse.upRespectHorses(4);
        mHorse.downRespectPeoples(4);
    }

    public void beggingSugar(){
        mHorse.upSatiety(2);
        mHorse.downStamina(6);
        mHorse.upHappiness(4);
        mHorse.downRespectHorses(2);
        mHorse.upRespectPeoples(2);
    }


    public void askForFood(){
        mHorse.upSatiety(8);
        mHorse.upHappiness(4);
        mHorse.downStamina(6);
    }

    public void eatApple(){
        if (mGoldApple > 0){
            mGoldApple--;
            mHorse.upHappiness(20);
            mHorse.upSatiety(50);
        }
        else return;
    }

    /* Function for stamina  */

    public void haveSleep() throws HabitatNotFoundExceptoin {
        switch (mHorse.getHabitat()){
            case TABOR: { sleepParamChange(6, 3); break; }
            case WASTELAND: { sleepParamChange(8, 4); break; }
            case CLEAR_FIELD: { sleepParamChange(10, 5); break; }
            case MEADOWS: { sleepParamChange(15, 7); break; }
            case PRAIRIE: { sleepParamChange(20, 10, 4); break; }
            case KAZAKHSTAN: { sleepParamChange(25, 12, 10); break; }
            case PADDOCK: { sleepParamChange(8, 4); break; }
            case STABLE: { sleepParamChange(10, 5); break; }
            case RANCH: { sleepParamChange(15, 7); break; }
            case HORSE_CLUB: { sleepParamChange(20, 10, 4); break; }
            case PRICATE_FARM:{ sleepParamChange(25, 12, 10); break; }
            default: throw new HabitatNotFoundExceptoin();
        }
    }

    public void goToWatering(){
        mHorse.upStamina(10);
        mHorse.downSatiety(4);
        mHorse.upHappiness(4);
    }

    public void goToDrinkers(){
        mHorse.upStamina(10);
        mHorse.downSatiety(4);
        mHorse.upHappiness(4);
    }

    public void getMassage(){
        mHorse.upStamina(14);
        mHorse.upHappiness(5);
    }

    public void swimInLake(){
        mHorse.upStamina(14);
        mHorse.upHappiness(5);
    }

    /* Other function  */
    public void getApples(){

    }

    public int findApple(){
        Random rd = new Random();
        mHorse.downStamina(15);
        mHorse.downSatiety(15);
        int difference = rd.nextInt(5) + 1;
        mGoldApple += difference;
        return difference;
    }

    public void plowedField(){
        mHorse.downStamina();
        mHorse.downSatiety();
        mHorse.downRespectHorses();
        mHorse.upRespectPeoples();
    }

    public void drugLoads(){
        mHorse.downStamina();
        mHorse.downSatiety();
        mHorse.downRespectHorses();
        mHorse.upRespectPeoples();
    }

    public void knockCorralGate(){
        mHorse.downSatiety();
        mHorse.downStamina();
        mHorse.downRespectPeoples();
        mHorse.upRespectHorses();
    }

    public void participateHorseRace(){
        mHorse.downSatiety();
        mHorse.downStamina();
        mHorse.upRespectHorses();
    }


    public void bobMuscles(){
        mHorse.downSatiety();
        mHorse.downSatiety();
        mHorse.setMaxSpeed(mHorse.getMaxSpeed() + 0.3);
        mGoldApple -= 1;
    }

    public boolean participateChampionchip(){
        Random rd = new Random();
        mTimeToChampionship = 10;
        mHorse.downStamina();
        mHorse.downSatiety();
        if (rd.nextInt(60) + 1 + 2*mHorse.getMaxSpeed() > 100){
            mGoldApple += 5;
            mHorse.upRespectHorses();
            mHorse.upRespectPeoples();
            mHorse.upHappiness();
            return true;
        }
        mHorse.downRespectHorses();
        mHorse.downRespectPeoples();
        mHorse.downHappiness();
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
}
