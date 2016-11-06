package blue_caps.horsesimulator;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by alexu on 4.11.2016.
 */

public class Page_4 extends Fragment implements View.OnClickListener {
    private Button
            buttonFindApple,
            buttonPlowedField,
            buttonHelpHorses,
            buttonHelpPeople,
            buttonKnockCorralGate,
            buttonParticipateHorseRace,
            buttonBobMuscles,
            buttonParticipateChampionship;
    private TextView
            textFindApple,
            textPlowedField,
            textHelpHorses,
            textHelpPeople,
            textKnockCorralGate,
            textParticipateHorseRace,
            textBobMuscles,
            textParticipateChampionship;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.page_4, null);

        buttonFindApple = (Button) view.findViewById(R.id.button_find_apple);
        buttonPlowedField = (Button) view.findViewById(R.id.button_plowed_field);
        buttonHelpHorses = (Button) view.findViewById(R.id.button_help_horses);
        buttonHelpPeople = (Button) view.findViewById(R.id.button_help_people);
        buttonKnockCorralGate = (Button) view.findViewById(R.id.button_knock_corral_gate);
        buttonBobMuscles = (Button) view.findViewById(R.id.button_bob_muscles);
        buttonParticipateHorseRace = (Button) view.findViewById(R.id.button_participate_horse_race);
        buttonParticipateChampionship = (Button) view.findViewById(R.id.button_participate_championship);

        textFindApple = (TextView) view.findViewById(R.id.text_find_apple);
        textPlowedField = (TextView) view.findViewById(R.id.text_plowed_field);
        textHelpHorses = (TextView) view.findViewById(R.id.text_help_horses);
        textHelpPeople = (TextView) view.findViewById(R.id.text_help_people);
        textKnockCorralGate = (TextView) view.findViewById(R.id.text_knock_corral_gate);
        textBobMuscles = (TextView) view.findViewById(R.id.text_bob_muscles);
        textParticipateHorseRace = (TextView) view.findViewById(R.id.text_participate_horse_race);
        textParticipateChampionship = (TextView) view.findViewById(R.id.text_participate_championship);

        textFindApple.setText(makeParamString(R.id.text_find_apple));
        textPlowedField.setText(makeParamString(R.id.text_plowed_field));
        textHelpHorses.setText(makeParamString(R.id.text_help_horses));
        textHelpPeople.setText(makeParamString(R.id.text_help_people));
        textKnockCorralGate.setText(makeParamString(R.id.text_knock_corral_gate));
        textBobMuscles.setText(makeParamString(R.id.text_bob_muscles));
        textParticipateHorseRace.setText(makeParamString(R.id.text_participate_horse_race));
        textParticipateChampionship.setText(makeParamString(R.id.text_participate_championship));

        buttonFindApple.setOnClickListener(this);
        buttonPlowedField.setOnClickListener(this);
        buttonHelpHorses.setOnClickListener(this);
        buttonHelpPeople.setOnClickListener(this);
        buttonKnockCorralGate.setOnClickListener(this);
        buttonBobMuscles.setOnClickListener(this);
        buttonParticipateHorseRace.setOnClickListener(this);
        buttonParticipateChampionship.setOnClickListener(this);

        update();

        return view;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.button_find_apple:     MainActivity.controller.findApple(); break;
            case R.id.button_plowed_field: MainActivity.controller.plowedField(); break;
            case R.id.button_help_horses: MainActivity.controller.helpHorses(); break;
            case R.id.button_help_people:  MainActivity.controller.helpPeople(); break;
            case R.id.button_knock_corral_gate:     MainActivity.controller.knockCorralGate(); break;
            case R.id.button_participate_horse_race:     MainActivity.controller.participateHorseRace(); break;
            case R.id.button_bob_muscles:     MainActivity.controller.bobMuscles(); break;
            case R.id.button_participate_championship: {
                if (MainActivity.controller.participateChampionship())
                    MainActivity.showWinChampionship(getActivity());
                else
                    MainActivity.showLoseChampionship(getActivity());
                MainActivity.controller.setTimeToChampionship(Constants.timeToChampionship);
                break;
            }
        }
        MainActivity.controller.wasStep(getActivity());
        update();
        MainActivity.page_3.update();
        MainActivity.updateStats();
    }

    public String makeParamString(int id) {
        StringBuilder sb = new StringBuilder();
        String tmpStamina = getActivity().getString(R.string.stamina);
        String tmpSatiety = getActivity().getString(R.string.satiety);
        String tmpHappiness = getActivity().getString(R.string.happiness);
        String tmpHorseRespect = getActivity().getString(R.string.respect_horses);
        String tmpPeopleREspect = getActivity().getString(R.string.respect_peoples);
        switch (id) {
            case R.id.text_find_apple: {
                sb.append(tmpStamina);
                sb.append(": ");
                sb.append(-Constants.findAppleDownStamina - Constants.wasStepDownStamina);
                sb.append("; ");
                sb.append(tmpSatiety);
                sb.append(": ");
                sb.append(-Constants.findAppleDownSatiety - Constants.wasStepDownSatiety);
                sb.append("; ");
                sb.append(tmpHappiness);
                sb.append(": ");
                sb.append(- Constants.wasStepDownHappiness);
                return sb.toString();
            }
            case R.id.text_plowed_field:{
                sb.append(tmpStamina);
                sb.append(": ");
                sb.append(-Constants.plowedFieldDownStamina - Constants.wasStepDownStamina);
                sb.append("; ");
                sb.append(tmpSatiety);
                sb.append(": ");
                sb.append(-Constants.plowedFieldDownSatiety - Constants.wasStepDownSatiety);
                sb.append("; ");
                sb.append(tmpHappiness);
                sb.append(": ");
                sb.append(- Constants.wasStepDownHappiness);
                sb.append("; ");
                sb.append(tmpHorseRespect);
                sb.append(" ");
                sb.append(-Constants.plowedFieldDownRespectHorses);
                sb.append("; ");
                sb.append(tmpPeopleREspect);
                sb.append(" +");
                sb.append(Constants.plowedFieldUpRespectPeoples);
                return sb.toString();
            }
            case R.id.text_help_horses:{
                sb.append(tmpStamina);
                sb.append(": ");
                sb.append(-Constants.helpHorsesDownStamina - Constants.wasStepDownStamina);
                sb.append("; ");
                sb.append(tmpSatiety);
                sb.append(": ");
                sb.append(-Constants.helpHorsesDownSatiety - Constants.wasStepDownSatiety);
                sb.append("; ");
                sb.append(tmpHappiness);
                sb.append(": ");
                sb.append(- Constants.wasStepDownHappiness);
                sb.append("; ");
                sb.append(tmpHorseRespect);
                sb.append(" +");
                sb.append(Constants.helpHorsesUpRespectHorses);
                sb.append("; ");
                sb.append(tmpPeopleREspect);
                sb.append(" ");
                sb.append(-Constants.helpHorsesDownRespectPeoples);
                return sb.toString();
            }
            case R.id.text_help_people:{
                sb.append(tmpStamina);
                sb.append(": ");
                sb.append(-Constants.helpPeopleDownStamina - Constants.wasStepDownStamina);
                sb.append("; ");
                sb.append(tmpSatiety);
                sb.append(": ");
                sb.append(-Constants.helpPeopleDownSatiety - Constants.wasStepDownSatiety);
                sb.append("; ");
                sb.append(tmpHappiness);
                sb.append(": ");
                sb.append(- Constants.wasStepDownHappiness);
                sb.append("; ");
                sb.append(tmpHorseRespect);
                sb.append(" ");
                sb.append(-Constants.helpPeopleDownRespectHorses);
                sb.append("; ");
                sb.append(tmpPeopleREspect);
                sb.append(" +");
                sb.append(Constants.helpPeopleUpRespectPeoples);
                return sb.toString();
            }
            case R.id.text_knock_corral_gate:{
                sb.append(tmpStamina);
                sb.append(": ");
                sb.append(-Constants.knockCorralGateDownStamina - Constants.wasStepDownStamina);
                sb.append("; ");
                sb.append(tmpSatiety);
                sb.append(": ");
                sb.append(-Constants.knockCorralGateDownSatiety - Constants.wasStepDownSatiety);
                sb.append("; ");
                sb.append(tmpHappiness);
                sb.append(": ");
                sb.append(- Constants.wasStepDownHappiness);
                sb.append("; ");
                sb.append(tmpHorseRespect);
                sb.append(" +");
                sb.append(Constants.knockCorralGateUpRespectHorses);
                sb.append("; ");
                sb.append(tmpPeopleREspect);
                sb.append(" ");
                sb.append(-Constants.knockCorralGateDownRespectPeoples);
                return sb.toString();
            }
            case R.id.text_bob_muscles:{
                sb.append(tmpStamina);
                sb.append(": ");
                sb.append(-Constants.bobMusclesDownStamina - Constants.wasStepDownStamina);
                sb.append("; ");
                sb.append(tmpSatiety);
                sb.append(": ");
                sb.append(-Constants.bobMusclesDownSatiety - Constants.wasStepDownSatiety);
                sb.append("; ");
                sb.append(getString(R.string.max_speed));
                sb.append(": +");
                sb.append(Constants.bobMusclesUpMaxSpeed);
                sb.append("; ");
                sb.append(getString(R.string.apples));
                sb.append(": -1");
                return sb.toString();
            }
            case R.id.text_participate_horse_race:{
                sb.append(tmpStamina);
                sb.append(": ");
                sb.append(-Constants.participateHorseRaceDownStamina -Constants.wasStepDownStamina);
                sb.append("; ");
                sb.append(tmpSatiety);
                sb.append(": ");
                sb.append(-Constants.participateHorseRaceDownSatiety - Constants.wasStepDownSatiety);
                sb.append("; ");
                sb.append(tmpHappiness);
                sb.append(": ");
                sb.append(-Constants.wasStepDownHappiness);
                sb.append("; ");
                sb.append(tmpHorseRespect);
                sb.append(" +");
                sb.append(Constants.participateHorseRaceUpRespectHorses);
                sb.append("; ");
                sb.append(tmpPeopleREspect);
                sb.append(" +");
                sb.append(Constants.participateHorseRaceUpRespectPeople);
                sb.append("; ");
                sb.append(getString(R.string.apples));
                sb.append(": -1");
                return sb.toString();
            }
            case R.id.text_participate_championship:{
                sb.append(tmpStamina);
                sb.append(": ");
                sb.append(-Constants.participateChampionshipDownStamina -Constants.wasStepDownStamina);
                sb.append("; ");
                sb.append(tmpSatiety);
                sb.append(": ");
                sb.append(-Constants.participateChampionshipDownSatiety - Constants.wasStepDownSatiety);
                sb.append("; ");
                sb.append(tmpHappiness);
                sb.append(": ");
                sb.append(-Constants.wasStepDownHappiness);
                sb.append("; ");
                sb.append(getString(R.string.if_win));
                sb.append(": ");
                sb.append(tmpHorseRespect);
                sb.append(" +");
                sb.append(Constants.participateChampionshipUpRespectHorses);
                sb.append("; ");
                sb.append(tmpPeopleREspect);
                sb.append(" +");
                sb.append(Constants.participateChampionshipUpRespectPeoples);
                sb.append("; ");
                sb.append(getString(R.string.apples));
                sb.append(" +");
                sb.append(Constants.participateChampionshipUpApples);
                sb.append("; ");
                sb.append(getString(R.string.if_lose));
                sb.append(": ");
                sb.append(tmpHorseRespect);
                sb.append(" +");
                sb.append(Constants.participateChampionshipDownRespectHorses);
                sb.append("; ");
                sb.append(tmpPeopleREspect);
                sb.append(" +");
                sb.append(Constants.participateChampionshipDownRespectPeoples);
                sb.append("; ");
                sb.append(tmpHappiness);
                sb.append(": ");
                sb.append(-Constants.participateChampionshipDownHappiness - Constants.wasStepDownHappiness);
                return sb.toString();
            }
            default: return null;
        }
    }
    public void update(){
        if (MainActivity.controller.getTimeToChampionship() != 0)
            buttonParticipateChampionship.setEnabled(false);
        else buttonParticipateChampionship.setEnabled(true);
        if (MainActivity.controller.getGoldApple() == 0){
            buttonParticipateHorseRace.setEnabled(false);
            buttonBobMuscles.setEnabled(false);
        }
        else {
            buttonParticipateHorseRace.setEnabled(true);
            buttonBobMuscles.setEnabled(true);
        }
    }
}
