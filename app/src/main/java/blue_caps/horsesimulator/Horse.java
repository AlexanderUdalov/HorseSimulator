package blue_caps.horsesimulator;

/**
 * Created by AlexUD on 25.10.2016.
 */

public class Horse {
    private int mStamina;
    private int mSatiety;
    private int mHappiness;
    private int mRespectHorses;
    private int mRespectPeoples;
    private double mMaxSpeed;
    private Habitat habitat;

    public static final int mMaxStamina = 100;
    public static final int mMaxSatiety = 100;
    public static final int mMaxHappiness = 100;

    public Horse(){
        mStamina = mMaxStamina/2;
        mSatiety = mMaxSatiety/2;
        mHappiness = mMaxHappiness/2;
        mRespectHorses = 0;
        mRespectPeoples = 0;
        mMaxSpeed = 20;
        habitat = Habitat.TABOR;
    }

    public int getStamina() {return mStamina;}
    public int getSatiety() {return mSatiety;}
    public int getHappiness() {return mHappiness;}
    public int getRespectHorses() {return mRespectHorses;}
    public int getRespectPeoples() {return mRespectPeoples;}
    public double getMaxSpeed() {return mMaxSpeed;}

    public void upStamina(int x) {
        if (mStamina <= mMaxStamina - x)
            mStamina += x;
        else mStamina = mMaxStamina;
    }

    public void downStamina(int x) {
        if (mStamina >=  x)
            mStamina -= x;
        else mStamina = 0;
    }

    public void upSatiety(int x) {
        if (mSatiety <= mMaxSatiety - x)
            mSatiety += x;
        else mSatiety = mMaxSatiety;
    }

    public void downSatiety(int x) {
        if (mSatiety >=  x)
            mSatiety -= x;
        else mSatiety = 0;
    }


    public void upHappiness(int x) {
        if (mHappiness <= mMaxHappiness - x)
            mHappiness += x;
        else mHappiness = mMaxHappiness;
    }

    public void downHappiness(int x) {
        if (mHappiness >=  x)
            mHappiness -= x;
        else mHappiness = 0;
    }


    public void upRespectHorses(int respectHorses) {
        mRespectHorses += respectHorses;
    }

    public void downRespectHorses(int x) {
        if (mRespectHorses >=  x)
            mRespectHorses -= x;
        else mRespectHorses = 0;
    }


    public void upRespectPeoples(int respectPeoples) {
        mRespectPeoples += respectPeoples;
    }

    public void downRespectPeoples(int x) {
        if (mRespectPeoples >=  x)
            mRespectPeoples -= x;
        else mRespectPeoples = 0;
    }


    public void setMaxSpeed(double maxSpeed) {
        mMaxSpeed = maxSpeed;
    }

    public Habitat getHabitat() {
        return habitat;
    }

    public void setHabitat(Habitat habitat) {
        this.habitat = habitat;
    }
}
