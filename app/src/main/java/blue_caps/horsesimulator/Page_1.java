package blue_caps.horsesimulator;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
            textHaveSleep,
            textGoToWatering,
            textGoToDrinkers,
            textGetMassage,
            textSwimInLake;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.page_1, null);

        buttonHaveSleep    = (Button) view.findViewById(R.id.button_have_sleep);
        buttonGoToWatering = (Button) view.findViewById(R.id.button_go_to_watering);
        buttonGoToDrinkers = (Button) view.findViewById(R.id.button_go_to_drinkers);
        buttonGetMassage   = (Button) view.findViewById(R.id.button_get_massage);
        buttonSwimInLake   = (Button) view.findViewById(R.id.button_swim_in_lake);

        textHaveSleep = (TextView) view.findViewById(R.id.text_have_sleep);
        textGoToWatering = (TextView) view.findViewById(R.id.text_go_to_watering);
        textGoToDrinkers = (TextView) view.findViewById(R.id.text_go_to_drinkers);
        textGetMassage = (TextView) view.findViewById(R.id.text_get_massage);
        textSwimInLake = (TextView) view.findViewById(R.id.text_swim_in_lake);

        textHaveSleep.setText(makeParamString(R.id.text_have_sleep));
        textGoToWatering.setText(makeParamString(R.id.text_go_to_watering));
        textGoToDrinkers.setText(makeParamString(R.id.text_go_to_drinkers));
        textGetMassage.setText(makeParamString(R.id.text_get_massage));
        textSwimInLake.setText(makeParamString(R.id.text_swim_in_lake));

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
            case R.id.text_have_sleep: {
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
            }
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
}
