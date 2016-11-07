package blue_caps.horsesimulator;

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

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.page_2, null);

        buttonHaveSleep = (Button) view.findViewById(R.id.button_have_sleep);
        buttonGoToWatering = (Button) view.findViewById(R.id.button_go_to_watering);
        buttonGoToDrinkers = (Button) view.findViewById(R.id.button_go_to_drinkers);
        buttonGetMassage = (Button) view.findViewById(R.id.button_get_massage);
        buttonSwimInLake = (Button) view.findViewById(R.id.button_swim_in_lake);

        haveSleepStaminaText = (TextView) view.findViewById(R.id.have_sleep_stamina_text);
        haveSleepSatietyText = (TextView) view.findViewById(R.id.have_sleep_satiety_text);
        haveSleepHappinessText = (TextView) view.findViewById(R.id.have_sleep_happiness_text);
        goToWateringStaminaText = (TextView) view.findViewById(R.id.go_to_watering_stamina_text);
        goToWateringSatietyText = (TextView) view.findViewById(R.id.go_to_watering_satiety_text);
        goToWateringHappinessText = (TextView) view.findViewById(R.id.go_to_watering_happiness_text);
        goToDrinkersStaminaText = (TextView) view.findViewById(R.id.go_to_drinkers_stamina_text);
        goToDrinkersSatietyText = (TextView) view.findViewById(R.id.go_to_drinkers_satiety_text);
        goToDrinkersHappinessText = (TextView) view.findViewById(R.id.go_to_drinkers_happiness_text):
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
        MainActivity.controller.wasStep(getActivity());

        switch (view.getId()) {
            case R.id.button_have_sleep:     MainActivity.controller.haveSleep(); break;
            case R.id.button_go_to_watering: MainActivity.controller.goToWatering(); break;
            case R.id.button_go_to_drinkers: MainActivity.controller.goToDrinkers(); break;
            case R.id.button_get_massage:    MainActivity.controller.getMassage(); break;
            case R.id.button_swim_in_lake:   MainActivity.controller.swimInLake(); break;
        }
        MainActivity.controller.dieCheck(getActivity());
        update();
        MainActivity.page_0.update();
        MainActivity.page_2.update();
        MainActivity.updateStats();
    }

    public String makeParamString(int id) {
        StringBuilder sb = new StringBuilder();
        String tmpStamina = getActivity().getString(R.string.stamina);
        String tmpSatiety = getActivity().getString(R.string.satiety);
        String tmpHappiness = getActivity().getString(R.string.happiness);
        switch (id) {
            /*case R.id.text_have_sleep: {
                sb.append(tmpStamina);
                sb.append(": +");
                switch (MainActivity.controller.getHorse().getHabitat()) {
                    case TABOR: {
                        sb.append(Constants.haveSleepUpStaminaTABOR - Constants.wasStepDownStamina);
                        sb.append("; ");
                        sb.append(tmpSatiety);
                        sb.append(": ");
                        sb.append(-Constants.haveSleepDownSatietyTABOR - Constants.wasStepDownSatiety);
                        break;
                    }
                    case WASTELAND: {
                        sb.append(Constants.haveSleepUpStaminaWASTELAND - Constants.wasStepDownStamina);
                        sb.append("; ");
                        sb.append(tmpSatiety);
                        sb.append(": ");
                        sb.append(-Constants.haveSleepDownSatietyWASTELAND - Constants.wasStepDownSatiety);
                        break;
                    }
                    case CLEAR_FIELD: {
                        sb.append(Constants.haveSleepUpStaminaCLEAR_FIELD - Constants.wasStepDownStamina);
                        sb.append("; ");
                        sb.append(tmpSatiety);
                        sb.append(": ");
                        sb.append(-Constants.haveSleepDownSatietyCLEAR_FIELD - Constants.wasStepDownSatiety);
                        break;
                    }
                    case MEADOWS: {
                        sb.append(Constants.haveSleepUpStaminaMEADOWS - Constants.wasStepDownStamina);
                        sb.append("; ");
                        sb.append(tmpSatiety);
                        sb.append(": ");
                        sb.append(-Constants.haveSleepDownSatietyMEADOWS - Constants.wasStepDownSatiety);
                        break;
                    }
                    case PRAIRIE: {
                        sb.append(Constants.haveSleepUpStaminaPRAIRIE - Constants.wasStepDownStamina);
                        sb.append("; ");
                        sb.append(tmpSatiety);
                        sb.append(": ");
                        sb.append(-Constants.haveSleepDownSatietyPRAIRIE - Constants.wasStepDownSatiety);
                        sb.append("; ");
                        sb.append(tmpHappiness);
                        sb.append(": ");
                        sb.append(-Constants.haveSleepUpHappinessPRAIRIE - Constants.wasStepDownHappiness);
                        break;
                    }
                    case KAZAKHSTAN: {
                        sb.append(Constants.haveSleepUpStaminaKAZAKHSTAN - Constants.wasStepDownStamina);
                        sb.append("; ");
                        sb.append(tmpSatiety);
                        sb.append(": ");
                        sb.append(-Constants.haveSleepDownSatietyKAZAKHSTAN - Constants.wasStepDownSatiety);
                        sb.append("; ");
                        sb.append(tmpHappiness);
                        sb.append(": ");
                        sb.append(-Constants.haveSleepUpHappinessKAZAKHSTAN - Constants.wasStepDownHappiness);
                        break;
                    }
                    case PADDOCK: {
                        sb.append(Constants.haveSleepUpStaminaPADDOCK - Constants.wasStepDownStamina);
                        sb.append("; ");
                        sb.append(tmpSatiety);
                        sb.append(": ");
                        sb.append(-Constants.haveSleepDownSatietyPADDOCK - Constants.wasStepDownSatiety);
                        break;
                    }
                    case STABLE: {
                        sb.append(Constants.haveSleepUpStaminaSTABLE - Constants.wasStepDownStamina);
                        sb.append("; ");
                        sb.append(tmpSatiety);
                        sb.append(": ");
                        sb.append(-Constants.haveSleepDownSatietySTABLE - Constants.wasStepDownSatiety);
                        break;
                    }
                    case RANCH: {
                        sb.append(Constants.haveSleepUpStaminaRANCH - Constants.wasStepDownStamina);
                        sb.append("; ");
                        sb.append(tmpSatiety);
                        sb.append(": ");
                        sb.append(-Constants.haveSleepDownSatietyRANCH - Constants.wasStepDownSatiety);
                        break;
                    }
                    case HORSE_CLUB: {
                        sb.append(Constants.haveSleepUpStaminaHORSE_CLUB - Constants.wasStepDownStamina);
                        sb.append("; ");
                        sb.append(tmpSatiety);
                        sb.append(": ");
                        sb.append(-Constants.haveSleepDownSatietyHORSE_CLUB - Constants.wasStepDownSatiety);
                        sb.append("; ");
                        sb.append(tmpHappiness);
                        sb.append(": ");
                        sb.append(-Constants.haveSleepUpHappinessHORSE_CLUB - Constants.wasStepDownHappiness);
                        break;
                    }
                    case PRIVATE_FARM: {
                        sb.append(Constants.haveSleepUpStaminaPRICATE_FARM - Constants.wasStepDownStamina);
                        sb.append("; ");
                        sb.append(tmpSatiety);
                        sb.append(": ");
                        sb.append(-Constants.haveSleepDownSatietyPRICATE_FARM - Constants.wasStepDownSatiety);
                        sb.append("; ");
                        sb.append(tmpSatiety);
                        sb.append(": ");
                        sb.append(-Constants.haveSleepUpHappinessPRICATE_FARM - Constants.wasStepDownHappiness);
                        break;
                    }
                }
                return sb.toString();
            }*/
            case R.id.text_go_to_watering:{
                sb.append(tmpStamina);
                sb.append(": +");
                sb.append(Constants.goToWateringUpStamina - Constants.wasStepDownStamina);
                sb.append("; ");
                sb.append(tmpSatiety);
                sb.append(": ");
                sb.append(-Constants.goToWateringDownSatiety - Constants.wasStepDownSatiety);
                sb.append("; ");
                sb.append(tmpHappiness);
                sb.append(": ");
                sb.append(Constants.goToWateringUpHappiness - Constants.wasStepDownHappiness);
                return sb.toString();
            }
            case R.id.text_go_to_drinkers:{
                sb.append(tmpStamina);
                sb.append(": +");
                sb.append(Constants.goToDrinkersUpStamina - Constants.wasStepDownStamina);
                sb.append("; ");
                sb.append(tmpSatiety);
                sb.append(": ");
                sb.append(-Constants.goToDrinkersDownSatiety - Constants.wasStepDownSatiety);
                sb.append("; ");
                sb.append(tmpHappiness);
                sb.append(": ");
                sb.append(Constants.goToDrinkersUpHappiness - Constants.wasStepDownHappiness);
                return sb.toString();
            }
            case R.id.text_get_massage:{
                sb.append(tmpStamina);
                sb.append(": +");
                sb.append(Constants.getMassageUpStamina - Constants.wasStepDownStamina);
                sb.append("; ");
                sb.append(tmpSatiety);
                sb.append(": ");
                sb.append(-Constants.getMassageDownSatiety - Constants.wasStepDownSatiety);
                sb.append("; ");
                sb.append(tmpHappiness);
                sb.append(": ");
                sb.append(Constants.getMassageUpHappiness- Constants.wasStepDownHappiness);
                return sb.toString();
            }
            case R.id.text_swim_in_lake:{
                sb.append(tmpStamina);
                sb.append(": +");
                sb.append(Constants.swimInLakeUpStamina - Constants.wasStepDownStamina);
                sb.append("; ");
                sb.append(tmpSatiety);
                sb.append(": ");
                sb.append(-Constants.swimInLakeDownSatiety - Constants.wasStepDownSatiety);
                sb.append("; ");
                sb.append(tmpHappiness);
                sb.append(": ");
                sb.append(Constants.swimInLakeUpHappiness - Constants.wasStepDownHappiness);
                return sb.toString();
            }
            default: return null;
        }
    }

    public void update(){
        switch (MainActivity.controller.getHorse().getHabitat()){
            case TABOR:{
                buttonGoToDrinkers.setEnabled(false);
                buttonGoToWatering.setEnabled(false);
                buttonGetMassage.setEnabled(false);
                buttonSwimInLake.setEnabled(false);
                textSwimInLake.setText(R.string.need_bester_habitat);
                textGetMassage.setText(R.string.need_bester_habitat);
                textGoToWatering.setText(R.string.need_bester_habitat);
                textGoToDrinkers.setText(R.string.need_bester_habitat);
                break;
            }
            case WASTELAND:{
                buttonGoToDrinkers.setEnabled(false);
                buttonGoToWatering.setEnabled(false);
                buttonGetMassage.setEnabled(false);
                buttonSwimInLake.setEnabled(false);
                textSwimInLake.setText(getString(R.string.need_bester_habitat));
                textGetMassage.setText(R.string.need_bester_habitat);
                textGoToWatering.setText(R.string.need_bester_habitat);
                textGoToDrinkers.setText(R.string.need_bester_habitat);
                break;
            }
            case PADDOCK:{
                buttonGoToDrinkers.setEnabled(false);
                buttonGoToWatering.setEnabled(false);
                buttonGetMassage.setEnabled(false);
                buttonSwimInLake.setEnabled(false);
                textSwimInLake.setText(R.string.need_bester_habitat);
                textGetMassage.setText(R.string.need_bester_habitat);
                textGoToWatering.setText(R.string.need_bester_habitat);
                textGoToDrinkers.setText(R.string.need_bester_habitat);
                break;
            }
            case STABLE:{
                buttonGoToDrinkers.setEnabled(true);
                buttonGoToWatering.setEnabled(false);
                buttonGetMassage.setEnabled(false);
                buttonSwimInLake.setEnabled(false);
                textSwimInLake.setText(R.string.need_bester_habitat);
                textGetMassage.setText(R.string.need_bester_habitat);
                textGoToWatering.setText(R.string.need_bester_habitat);
                break;
            }
            case CLEAR_FIELD:{
                buttonGoToDrinkers.setEnabled(false);
                buttonGoToWatering.setEnabled(true);
                buttonGetMassage.setEnabled(false);
                buttonSwimInLake.setEnabled(false);
                textSwimInLake.setText(R.string.need_bester_habitat);
                textGetMassage.setText(R.string.need_bester_habitat);
                textGoToDrinkers.setText(R.string.need_bester_habitat);
                break;
            }
            case PRAIRIE:{
                buttonGoToDrinkers.setEnabled(false);
                buttonGoToWatering.setEnabled(true);
                buttonGetMassage.setEnabled(false);
                buttonSwimInLake.setEnabled(true);
                textGoToDrinkers.setText(R.string.need_bester_habitat);
                textGetMassage.setText(R.string.need_bester_habitat);
                break;
            }
            case HORSE_CLUB:{
                buttonGoToDrinkers.setEnabled(true);
                buttonGoToWatering.setEnabled(false);
                buttonGetMassage.setEnabled(true);
                buttonSwimInLake.setEnabled(false);
                textSwimInLake.setText(R.string.need_bester_habitat);
                textGoToWatering.setText(R.string.need_bester_habitat);
                break;
            }
            default: return;
        }
    }

    public int getCountsOfDigits(long number) {
        int count = (number == 0) ? 1 : 0;
        while (number != 0) {
            count++;
            number /= 10;
        }
        return count;
    }
}
