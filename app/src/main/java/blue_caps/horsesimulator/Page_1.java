package blue_caps.horsesimulator;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Created by alexu on 30.10.2016.
 */

public class Page_1 extends Fragment implements View.OnClickListener {
    private Button
            buttonHaveSleep,
            buttonGoToWatering,
            buttonGoToDrinkers,
            buttonGetMassage,
            buttonSwimInLake;
    private TextView
            haveSleepStaminaText,
            haveSleepSatietyText,
            haveSleepHappinessText,
            goToWateringStaminaText,
            goToWateringSatietyText,
            goToWateringHappinessText,
            goToDrinkersStaminaText,
            goToDrinkersSatietyText,
            goToDrinkersHappinessText,
            getMassageStaminaText,
            getMassageSatietyText,
            getMassageHappinessText,
            swimInLakeStaminaText,
            swimInLakeSatietyText,
            swimInLakeHappinessText;
    private ImageView
            haveSleepStaminaImage,
            haveSleepSatietyImage,
            haveSleepHappinessImage,
            goToWateringStaminaImage,
            goToWateringSatietyImage,
            goToWateringHappinessImage,
            goToDrinkersStaminaImage,
            goToDrinkersSatietyImage,
            goToDrinkersHappinessImage,
            getMassageStaminaImage,
            getMassageSatietyImage,
            getMassageHappinessImage,
            swimInLakeStaminaImage,
            swimInLakeSatietyImage,
            swimInLakeHappinessImage;

    public FragmentEventListener listener;

    @Override
    public void onAttach(Activity act){
        super.onAttach(act);
        listener = (FragmentEventListener) act;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.page_1, null);


        haveSleepStaminaText = (TextView) view.findViewById(R.id.have_sleep_stamina_text);
        haveSleepSatietyText = (TextView) view.findViewById(R.id.have_sleep_satiety_text);
        haveSleepHappinessText = (TextView) view.findViewById(R.id.have_sleep_happiness_text);
        goToWateringStaminaText = (TextView) view.findViewById(R.id.go_to_watering_stamina_text);
        goToWateringSatietyText = (TextView) view.findViewById(R.id.go_to_watering_satiety_text);
        goToWateringHappinessText = (TextView) view.findViewById(R.id.go_to_watering_happiness_text);
        goToDrinkersStaminaText = (TextView) view.findViewById(R.id.go_to_drinkers_stamina_text);
        goToDrinkersSatietyText = (TextView) view.findViewById(R.id.go_to_drinkers_satiety_text);
        goToDrinkersHappinessText = (TextView) view.findViewById(R.id.go_to_drinkers_happiness_text);
        getMassageStaminaText = (TextView) view.findViewById(R.id.get_massage_stamina_text);
        getMassageSatietyText = (TextView) view.findViewById(R.id.get_massage_satiety_text);
        getMassageHappinessText = (TextView) view.findViewById(R.id.get_massage_happiness_text);
        swimInLakeStaminaText = (TextView) view.findViewById(R.id.swim_in_lake_stamina_text);
        swimInLakeSatietyText = (TextView) view.findViewById(R.id.swim_in_lake_satiety_text);
        swimInLakeHappinessText = (TextView) view.findViewById(R.id.swim_in_lake_happiness_text);

        haveSleepStaminaImage = (ImageView) view.findViewById(R.id.have_sleep_stamina_image);
        haveSleepSatietyImage= (ImageView) view.findViewById(R.id.have_sleep_satiety_image);
        haveSleepHappinessImage = (ImageView) view.findViewById(R.id.have_sleep_happiness_image);
        goToWateringStaminaImage = (ImageView) view.findViewById(R.id.go_to_watering_stamina_image);
        goToWateringSatietyImage = (ImageView) view.findViewById(R.id.go_to_watering_satiety_image);
        goToWateringHappinessImage = (ImageView) view.findViewById(R.id.go_to_watering_happiness_image);
        goToDrinkersStaminaImage = (ImageView) view.findViewById(R.id.go_to_drinkers_stamina_image);
        goToDrinkersSatietyImage = (ImageView) view.findViewById(R.id.go_to_drinkers_satiety_image);
        goToDrinkersHappinessImage = (ImageView) view.findViewById(R.id.go_to_drinkers_happiness_image);
        getMassageStaminaImage = (ImageView) view.findViewById(R.id.get_massage_stamina_image);
        getMassageSatietyImage = (ImageView) view.findViewById(R.id.get_massage_satiety_image);
        getMassageHappinessImage = (ImageView) view.findViewById(R.id.get_massage_happiness_image);
        swimInLakeStaminaImage = (ImageView) view.findViewById(R.id.swim_in_lake_stamina_image);
        swimInLakeSatietyImage = (ImageView) view.findViewById(R.id.swim_in_lake_satiety_image);
        swimInLakeHappinessImage = (ImageView) view.findViewById(R.id.swim_in_lake_happiness_image);

        haveSleepStaminaImage.setImageResource(R.drawable.stamina);
        haveSleepSatietyImage.setImageResource(R.drawable.satiety);
        haveSleepHappinessImage.setImageResource(R.drawable.happiness);
        goToWateringStaminaImage.setImageResource(R.drawable.stamina);
        goToWateringSatietyImage.setImageResource(R.drawable.satiety);
        goToWateringHappinessImage.setImageResource(R.drawable.happiness);
        goToDrinkersStaminaImage.setImageResource(R.drawable.stamina);
        goToDrinkersSatietyImage.setImageResource(R.drawable.satiety);
        goToDrinkersHappinessImage.setImageResource(R.drawable.happiness);
        getMassageStaminaImage.setImageResource(R.drawable.stamina);
        getMassageSatietyImage.setImageResource(R.drawable.satiety);
        getMassageHappinessImage.setImageResource(R.drawable.happiness);
        swimInLakeStaminaImage.setImageResource(R.drawable.stamina);
        swimInLakeSatietyImage.setImageResource(R.drawable.satiety);
        swimInLakeHappinessImage.setImageResource(R.drawable.happiness);

        goToWateringStaminaText.setText(withSign(Constants.goToWateringUpStamina - Constants.wasStepDownStamina));
        goToWateringSatietyText.setText(withSign(-Constants.goToWateringDownSatiety - Constants.wasStepDownSatiety));
        goToWateringHappinessText.setText(withSign(Constants.goToWateringUpHappiness-Constants.wasStepDownHappiness));
        goToDrinkersStaminaText.setText(withSign(Constants.goToDrinkersUpStamina - Constants.wasStepDownStamina));
        goToDrinkersSatietyText.setText(withSign(-Constants.goToWateringDownSatiety - Constants.wasStepDownSatiety));
        goToDrinkersHappinessText.setText(withSign(Constants.goToDrinkersUpHappiness- Constants.wasStepDownHappiness));
        getMassageStaminaText.setText(withSign(Constants.getMassageUpStamina - Constants.wasStepDownStamina));
        getMassageSatietyText.setText(withSign(-Constants.getMassageDownSatiety - Constants.wasStepDownSatiety));
        getMassageHappinessText.setText(withSign(Constants.getMassageUpHappiness - Constants.wasStepDownHappiness));
        swimInLakeStaminaText.setText(withSign(Constants.swimInLakeUpStamina - Constants.wasStepDownStamina));
        swimInLakeSatietyText.setText(withSign(-Constants.swimInLakeDownSatiety - Constants.wasStepDownSatiety));
        swimInLakeHappinessText.setText(withSign(Constants.swimInLakeUpHappiness - Constants.wasStepDownHappiness));

        buttonHaveSleep = (Button) view.findViewById(R.id.button_have_sleep);
        buttonGoToWatering = (Button) view.findViewById(R.id.button_go_to_watering);
        buttonGoToDrinkers = (Button) view.findViewById(R.id.button_go_to_drinkers);
        buttonGetMassage = (Button) view.findViewById(R.id.button_get_massage);
        buttonSwimInLake = (Button) view.findViewById(R.id.button_swim_in_lake);

        buttonHaveSleep.setOnClickListener(this);
        buttonGoToWatering.setOnClickListener(this);
        buttonGoToDrinkers.setOnClickListener(this);
        buttonGetMassage.setOnClickListener(this);
        buttonSwimInLake.setOnClickListener(this);

        update();

        return view;
    }

    @Override
    public void onClick(View view) {
        listener.clickEvent("wasStep");
        switch (view.getId()) {
            case R.id.button_have_sleep:     MainActivity.controller.haveSleep(); break;
            case R.id.button_go_to_watering: MainActivity.controller.goToWatering(); break;
            case R.id.button_go_to_drinkers: MainActivity.controller.goToDrinkers(); break;
            case R.id.button_get_massage:    MainActivity.controller.getMassage(); break;
            case R.id.button_swim_in_lake:   MainActivity.controller.swimInLake(); break;
        }
        listener.clickEvent("updateScore");
        listener.clickEvent("dieCheck");
        update();
        MainActivity.page_0.update();
        MainActivity.page_2.update();
        MainActivity.updateStats();
    }


    public void update(){
        switch (MainActivity.controller.getHorse().getHabitat()){
            case TABOR:{
                buttonGoToDrinkers.setEnabled(false);
                buttonGoToWatering.setEnabled(false);
                buttonGetMassage.setEnabled(false);
                buttonSwimInLake.setEnabled(false);
                buttonGoToWatering.setText(R.string.need_habitat_clear_field);
                buttonGoToDrinkers.setText(R.string.need_habitat_stable);
                buttonGetMassage.setText(R.string.need_habitat_horse_club);
                buttonSwimInLake.setText(R.string.need_habitat_prairie);

                haveSleepStaminaText.setText(withSign(Constants.haveSleepUpStaminaTABOR - Constants.wasStepDownStamina));
                haveSleepSatietyText.setText(withSign(-Constants.haveSleepDownSatietyTABOR - Constants.wasStepDownSatiety));
                haveSleepHappinessText.setText(withSign(-Constants.wasStepDownHappiness));
                break;
            }
            case PADDOCK:{
                buttonGoToDrinkers.setEnabled(false);
                buttonGoToWatering.setEnabled(false);
                buttonGetMassage.setEnabled(false);
                buttonSwimInLake.setEnabled(false);
                buttonGoToWatering.setText(R.string.need_habitat_clear_field);
                buttonGoToDrinkers.setText(R.string.need_habitat_stable);
                buttonGetMassage.setText(R.string.need_habitat_horse_club);
                buttonSwimInLake.setText(R.string.need_habitat_prairie);

                haveSleepStaminaText.setText(withSign(Constants.haveSleepUpStaminaPADDOCK - Constants.wasStepDownStamina));
                haveSleepSatietyText.setText(withSign(-Constants.haveSleepDownSatietyPADDOCK - Constants.wasStepDownSatiety));
                haveSleepHappinessText.setText(withSign(-Constants.wasStepDownHappiness));
                break;
            }
            case STABLE:{
                buttonGoToDrinkers.setEnabled(true);
                buttonGoToWatering.setEnabled(false);
                buttonGetMassage.setEnabled(false);
                buttonSwimInLake.setEnabled(false);
                buttonGoToWatering.setText(R.string.need_habitat_clear_field);
                buttonGoToDrinkers.setText(R.string.go_to_drinkers);
                buttonGetMassage.setText(R.string.need_habitat_horse_club);
                buttonSwimInLake.setText(R.string.need_habitat_prairie);

                haveSleepStaminaText.setText(withSign(Constants.haveSleepUpStaminaSTABLE - Constants.wasStepDownStamina));
                haveSleepSatietyText.setText(withSign(-Constants.haveSleepDownSatietySTABLE - Constants.wasStepDownSatiety));
                haveSleepHappinessText.setText(withSign(-Constants.wasStepDownHappiness));
                break;
            }
            case RANCH:{
                buttonGoToDrinkers.setEnabled(true);
                buttonGoToWatering.setEnabled(false);
                buttonGetMassage.setEnabled(false);
                buttonSwimInLake.setEnabled(false);
                buttonGoToWatering.setText(R.string.need_habitat_clear_field);
                buttonGoToDrinkers.setText(R.string.go_to_drinkers);
                buttonGetMassage.setText(R.string.need_habitat_horse_club);
                buttonSwimInLake.setText(R.string.need_habitat_prairie);

                haveSleepStaminaText.setText(withSign(Constants.haveSleepUpStaminaRANCH - Constants.wasStepDownStamina));
                haveSleepSatietyText.setText(withSign(-Constants.haveSleepDownSatietyRANCH - Constants.wasStepDownSatiety));
                haveSleepHappinessText.setText(withSign(-Constants.wasStepDownHappiness));
            }
            case HORSE_CLUB:{
                buttonGoToDrinkers.setEnabled(true);
                buttonGoToWatering.setEnabled(false);
                buttonGetMassage.setEnabled(true);
                buttonSwimInLake.setEnabled(false);
                buttonGoToWatering.setText(R.string.need_habitat_clear_field);
                buttonGoToDrinkers.setText(R.string.go_to_drinkers);
                buttonGetMassage.setText(R.string.get_massage);
                buttonSwimInLake.setText(R.string.need_habitat_prairie);

                haveSleepStaminaText.setText(withSign(Constants.haveSleepUpStaminaHORSE_CLUB - Constants.wasStepDownStamina));
                haveSleepSatietyText.setText(withSign(-Constants.haveSleepDownSatietyHORSE_CLUB - Constants.wasStepDownSatiety));
                haveSleepHappinessText.setText(withSign(Constants.haveSleepUpHappinessHORSE_CLUB - Constants.wasStepDownHappiness));
                break;
            }
            case PRIVATE_FARM:{
                buttonGoToDrinkers.setEnabled(true);
                buttonGoToWatering.setEnabled(false);
                buttonGetMassage.setEnabled(true);
                buttonSwimInLake.setEnabled(false);
                buttonGoToWatering.setText(R.string.need_habitat_clear_field);
                buttonGoToDrinkers.setText(R.string.go_to_drinkers);
                buttonGetMassage.setText(R.string.get_massage);
                buttonSwimInLake.setText(R.string.need_habitat_prairie);

                haveSleepStaminaText.setText(withSign(Constants.haveSleepUpStaminaPRICATE_FARM - Constants.wasStepDownStamina));
                haveSleepSatietyText.setText(withSign(-Constants.haveSleepDownSatietyPRICATE_FARM - Constants.wasStepDownSatiety));
                haveSleepHappinessText.setText(withSign(Constants.haveSleepUpHappinessPRICATE_FARM - Constants.wasStepDownHappiness));
                break;
            }
            case WASTELAND:{
                buttonGoToDrinkers.setEnabled(false);
                buttonGoToWatering.setEnabled(false);
                buttonGetMassage.setEnabled(false);
                buttonSwimInLake.setEnabled(false);
                buttonGoToWatering.setText(R.string.need_habitat_clear_field);
                buttonGoToDrinkers.setText(R.string.need_habitat_stable);
                buttonGetMassage.setText(R.string.need_habitat_horse_club);
                buttonSwimInLake.setText(R.string.need_habitat_prairie);

                haveSleepStaminaText.setText(withSign(Constants.haveSleepUpStaminaWASTELAND - Constants.wasStepDownStamina));
                haveSleepSatietyText.setText(withSign(-Constants.haveSleepDownSatietyWASTELAND - Constants.wasStepDownSatiety));
                haveSleepHappinessText.setText(withSign(-Constants.wasStepDownHappiness));
                break;
            }
            case CLEAR_FIELD:{
                buttonGoToDrinkers.setEnabled(false);
                buttonGoToWatering.setEnabled(true);
                buttonGetMassage.setEnabled(false);
                buttonSwimInLake.setEnabled(false);
                buttonGoToWatering.setText(R.string.go_to_watering);
                buttonGoToDrinkers.setText(R.string.need_habitat_stable);
                buttonGetMassage.setText(R.string.need_habitat_horse_club);
                buttonSwimInLake.setText(R.string.need_habitat_prairie);

                haveSleepStaminaText.setText(withSign(Constants.haveSleepUpStaminaCLEAR_FIELD - Constants.wasStepDownStamina));
                haveSleepSatietyText.setText(withSign(-Constants.haveSleepDownSatietyCLEAR_FIELD - Constants.wasStepDownSatiety));
                haveSleepHappinessText.setText(withSign(-Constants.wasStepDownHappiness));
                break;
            }
            case MEADOWS:{
                buttonGoToDrinkers.setEnabled(false);
                buttonGoToWatering.setEnabled(true);
                buttonGetMassage.setEnabled(false);
                buttonSwimInLake.setEnabled(false);
                buttonGoToWatering.setText(R.string.go_to_watering);
                buttonGoToDrinkers.setText(R.string.need_habitat_stable);
                buttonGetMassage.setText(R.string.need_habitat_horse_club);
                buttonSwimInLake.setText(R.string.need_habitat_prairie);

                haveSleepStaminaText.setText(withSign(Constants.haveSleepUpStaminaMEADOWS - Constants.wasStepDownStamina));
                haveSleepSatietyText.setText(withSign(-Constants.haveSleepDownSatietyMEADOWS - Constants.wasStepDownSatiety));
                haveSleepHappinessText.setText(withSign(-Constants.wasStepDownHappiness));
            }
            case PRAIRIE:{
                buttonGoToDrinkers.setEnabled(false);
                buttonGoToWatering.setEnabled(true);
                buttonGetMassage.setEnabled(false);
                buttonSwimInLake.setEnabled(true);
                buttonGoToWatering.setText(R.string.go_to_watering);
                buttonGoToDrinkers.setText(R.string.need_habitat_stable);
                buttonGetMassage.setText(R.string.need_habitat_horse_club);
                buttonSwimInLake.setText(R.string.swim_in_lake);

                haveSleepStaminaText.setText(withSign(Constants.haveSleepUpStaminaPRAIRIE - Constants.wasStepDownStamina));
                haveSleepSatietyText.setText(withSign(-Constants.haveSleepDownSatietyPRAIRIE - Constants.wasStepDownSatiety));
                haveSleepHappinessText.setText(withSign(Constants.haveSleepUpHappinessPRAIRIE - Constants.wasStepDownHappiness));
                break;
            }
            case KAZAKHSTAN:{
                buttonGoToDrinkers.setEnabled(false);
                buttonGoToWatering.setEnabled(true);
                buttonGetMassage.setEnabled(false);
                buttonSwimInLake.setEnabled(true);
                buttonGoToWatering.setText(R.string.go_to_watering);
                buttonGoToDrinkers.setText(R.string.need_habitat_stable);
                buttonGetMassage.setText(R.string.need_habitat_horse_club);
                buttonSwimInLake.setText(R.string.swim_in_lake);

                haveSleepStaminaText.setText(withSign(Constants.haveSleepUpStaminaKAZAKHSTAN - Constants.wasStepDownStamina));
                haveSleepSatietyText.setText(withSign(-Constants.haveSleepDownSatietyKAZAKHSTAN - Constants.wasStepDownSatiety));
                haveSleepHappinessText.setText(withSign(Constants.haveSleepUpHappinessKAZAKHSTAN - Constants.wasStepDownHappiness));
                break;
            }
            default: return;
        }
    }

    public String withSign(int value){
        if (value > 0)
            return "+" + value;
        return "" + value;
    }
}
