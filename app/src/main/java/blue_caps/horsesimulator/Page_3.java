package blue_caps.horsesimulator;


import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Created by alexu on 4.11.2016.
 */

public class Page_3 extends Fragment implements View.OnClickListener {
    private Button
            buttonGetApple,
            buttonFindApple,
            buttonPlowedField,
            buttonHelpHorses,
            buttonHelpPeople,
            buttonKnockCorralGate,
            buttonParticipateHorseRace,
            buttonBobMuscles,
            buttonParticipateChampionship;
    private TextView
            findAppleStaminaText,
            findAppleSatietyText,
            findAppleHappinessText,
            findAppleOtherText,
            plowedFieldStaminaText,
            plowedFieldSatietyText,
            plowedFieldHappinessText,
            plowedFieldOtherText,
            helpHorsesStaminaText,
            helpHorsesSatietyText,
            helpHorsesHappinessText,
            helpHorsesOtherText,
            helpPeopleStaminaText,
            helpPeopleSatietyText,
            helpPeopleHappinessText,
            helpPeopleOtherText,
            knockCorralGateStaminaText,
            knockCorralGateSatietyText,
            knockCorralGateHappinessText,
            knockCorralGateOtherText,
            participateHorseRaceStaminaText,
            participateHorseRaceSatietyText,
            participateHorseRaceHappinessText,
            participateHorseRaceGoldAppleText,
            participateHorseRaceOtherText,
            bobMusclesStaminaText,
            bobMusclesSatietyText,
            bobMusclesHappinessText,
            bobMusclesGoldAppleText,
            bobMusclesOtherText,
            participateChampionshipStaminaText,
            participateChampionshipSatietyText,
            participateChampionshipWinHappinessText,
            participateChampionshipLoseHappinessText,
            participateChampionshipGoldAppleText,
            participateChampionshipWinText,
            participateChampionshipLoseText;
    private ImageView
            findAppleStaminaImage,
            findAppleSatietyImage,
            findAppleHappinessImage,
            findAppleOtherImage,
            plowedFieldStaminaImage,
            plowedFieldSatietyImage,
            plowedFieldHappinessImage,
            helpHorsesStaminaImage,
            helpHorsesSatietyImage,
            helpHorsesHappinessImage,
            helpPeopleStaminaImage,
            helpPeopleSatietyImage,
            helpPeopleHappinessImage,
            knockCorralGateStaminaImage,
            knockCorralGateSatietyImage,
            knockCorralGateHappinessImage,
            participateHorseRaceStaminaImage,
            participateHorseRaceSatietyImage,
            participateHorseRaceHappinessImage,
            participateHorseRaceGoldAppleImage,
            bobMusclesStaminaImage,
            bobMusclesSatietyImage,
            bobMusclesHappinessImage,
            bobMusclesGoldAppleImage,
            participateChampionshipStaminaImage,
            participateChampionshipSatietyImage,
            participateChampionshipWinHappinessImage,
            participateChampionshipLoseHappinessImage,
            participateChampionshipGoldAppleImage;
    //Аналогично

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
        View view = inflater.inflate(R.layout.page_3, null);

        buttonGetApple = (Button) view.findViewById(R.id.button_get_apple);
        buttonFindApple = (Button) view.findViewById(R.id.button_find_apple);
        buttonPlowedField = (Button) view.findViewById(R.id.button_plowed_field);
        buttonHelpHorses = (Button) view.findViewById(R.id.button_help_horses);
        buttonHelpPeople = (Button) view.findViewById(R.id.button_help_people);
        buttonKnockCorralGate = (Button) view.findViewById(R.id.button_knock_corral_gate);
        buttonBobMuscles = (Button) view.findViewById(R.id.button_bob_muscles);
        buttonParticipateHorseRace = (Button) view.findViewById(R.id.button_participate_horse_race);
        buttonParticipateChampionship = (Button) view.findViewById(R.id.button_participate_championship);

        findAppleStaminaText = (TextView) view.findViewById(R.id.find_apple_stamina_text);
        findAppleSatietyText = (TextView) view.findViewById(R.id.find_apple_satiety_text);
        findAppleHappinessText = (TextView) view.findViewById(R.id.find_apple_happiness_text);
        findAppleOtherText = (TextView) view.findViewById(R.id.find_apple_other_text);
        plowedFieldStaminaText = (TextView) view.findViewById(R.id.plowed_field_stamina_text);
        plowedFieldSatietyText = (TextView) view.findViewById(R.id.plowed_field_satiety_text);
        plowedFieldHappinessText = (TextView) view.findViewById(R.id.plowed_field_happiness_text);
        plowedFieldOtherText = (TextView) view.findViewById(R.id.plowed_field_other_text);
        helpHorsesStaminaText = (TextView) view.findViewById(R.id.help_horses_stamina_text);
        helpHorsesSatietyText = (TextView) view.findViewById(R.id.help_horses_satiety_text);
        helpHorsesHappinessText = (TextView) view.findViewById(R.id.help_horses_happiness_text);
        helpHorsesOtherText = (TextView) view.findViewById(R.id.help_horses_other_text);
        helpPeopleStaminaText = (TextView) view.findViewById(R.id.help_people_stamina_text);
        helpPeopleSatietyText = (TextView) view.findViewById(R.id.help_people_satiety_text);
        helpPeopleHappinessText = (TextView) view.findViewById(R.id.help_people_happiness_text);
        helpPeopleOtherText = (TextView) view.findViewById(R.id.help_people_other_text);
        knockCorralGateStaminaText = (TextView) view.findViewById(R.id.knock_corral_gate_stamina_text);
        knockCorralGateSatietyText = (TextView) view.findViewById(R.id.knock_corral_gate_satiety_text);
        knockCorralGateHappinessText = (TextView) view.findViewById(R.id.knock_corral_gate_happiness_text);
        knockCorralGateOtherText = (TextView) view.findViewById(R.id.knock_corral_gate_other_text);
        participateHorseRaceStaminaText = (TextView) view.findViewById(R.id.participate_horse_race_stamina_text);
        participateHorseRaceSatietyText = (TextView) view.findViewById(R.id.participate_horse_race_satiety_text);
        participateHorseRaceHappinessText = (TextView) view.findViewById(R.id.participate_horse_race_happiness_text);
        participateHorseRaceGoldAppleText = (TextView) view.findViewById(R.id.participate_horse_race_gold_apple_text);
        participateHorseRaceOtherText = (TextView) view.findViewById(R.id.participate_horse_race_other_text);
        bobMusclesStaminaText = (TextView) view.findViewById(R.id.bob_muscles_stamina_text);
        bobMusclesSatietyText = (TextView) view.findViewById(R.id.bob_muscles_satiety_text);
        bobMusclesHappinessText = (TextView) view.findViewById(R.id.bob_muscles_happiness_text);
        bobMusclesGoldAppleText = (TextView) view.findViewById(R.id.bob_muscles_gold_apple_text);
        bobMusclesOtherText = (TextView) view.findViewById(R.id.bob_muscles_other_text);
        participateChampionshipStaminaText = (TextView) view.findViewById(R.id.participate_championship_stamina_text);
        participateChampionshipSatietyText = (TextView) view.findViewById(R.id.participate_championship_satiety_text);
        participateChampionshipWinHappinessText = (TextView) view.findViewById(R.id.participate_championship_win_happiness_text);
        participateChampionshipLoseHappinessText = (TextView) view.findViewById(R.id.participate_championship_lose_happiness_text);
        participateChampionshipGoldAppleText= (TextView) view.findViewById(R.id.participate_championship_gold_apple_text);
        participateChampionshipWinText = (TextView) view.findViewById(R.id.participate_championship_win_other_text);
        participateChampionshipLoseText = (TextView) view.findViewById(R.id.participate_championship_lose_other_text);

        findAppleStaminaImage = (ImageView) view.findViewById(R.id.find_apple_stamina_image);
        findAppleSatietyImage= (ImageView) view.findViewById(R.id.find_apple_satiety_image);
        findAppleHappinessImage = (ImageView) view.findViewById(R.id.find_apple_happiness_image);
        findAppleOtherImage= (ImageView) view.findViewById(R.id.find_apple_apple_image);
        plowedFieldStaminaImage = (ImageView) view.findViewById(R.id.plowed_field_stamina_image);
        plowedFieldSatietyImage = (ImageView) view.findViewById(R.id.plowed_field_satiety_image);
        plowedFieldHappinessImage = (ImageView) view.findViewById(R.id.plowed_field_happiness_image);
        helpHorsesStaminaImage = (ImageView) view.findViewById(R.id.help_horses_stamina_image);
        helpHorsesSatietyImage = (ImageView) view.findViewById(R.id.help_horses_satiety_image);
        helpHorsesHappinessImage = (ImageView) view.findViewById(R.id.help_horses_happiness_image);
        helpPeopleStaminaImage = (ImageView) view.findViewById(R.id.help_people_stamina_image);
        helpPeopleSatietyImage = (ImageView) view.findViewById(R.id.help_people_satiety_image);
        helpPeopleHappinessImage = (ImageView) view.findViewById(R.id.help_people_happiness_image);
        knockCorralGateStaminaImage = (ImageView) view.findViewById(R.id.knock_corral_gate_stamina_image);
        knockCorralGateSatietyImage = (ImageView) view.findViewById(R.id.knock_corral_gate_satiety_image);
        knockCorralGateHappinessImage = (ImageView) view.findViewById(R.id.knock_corral_gate_happiness_image);
        participateHorseRaceStaminaImage = (ImageView) view.findViewById(R.id.participate_horse_race_stamina_image);
        participateHorseRaceSatietyImage = (ImageView) view.findViewById(R.id.participate_horse_race_satiety_image);
        participateHorseRaceHappinessImage = (ImageView) view.findViewById(R.id.participate_horse_race_happiness_image);
        participateHorseRaceGoldAppleImage = (ImageView) view.findViewById(R.id.participate_horse_race_gold_apple_image);
        bobMusclesStaminaImage = (ImageView) view.findViewById(R.id.bob_muscles_stamina_image);
        bobMusclesSatietyImage = (ImageView) view.findViewById(R.id.bob_muscles_satiety_image);
        bobMusclesHappinessImage = (ImageView) view.findViewById(R.id.bob_muscles_happiness_image);
        bobMusclesGoldAppleImage = (ImageView) view.findViewById(R.id.bob_muscles_gold_apple_image);
        participateChampionshipStaminaImage = (ImageView) view.findViewById(R.id.participate_championship_stamina_image);
        participateChampionshipSatietyImage = (ImageView) view.findViewById(R.id.participate_championship_satiety_image);
        participateChampionshipWinHappinessImage = (ImageView) view.findViewById(R.id.participate_championship_win_happiness_image);
        participateChampionshipLoseHappinessImage = (ImageView) view.findViewById(R.id.participate_championship_lose_happiness_image);
        participateChampionshipGoldAppleImage  = (ImageView) view.findViewById(R.id.participate_championship_gold_apple_image);

        findAppleStaminaImage.setImageResource(R.drawable.stamina);
        findAppleSatietyImage.setImageResource(R.drawable.satiety);
        findAppleHappinessImage.setImageResource(R.drawable.happiness);
        findAppleOtherImage.setImageResource(R.drawable.image_goldapple);
        plowedFieldStaminaImage.setImageResource(R.drawable.stamina);
        plowedFieldSatietyImage.setImageResource(R.drawable.satiety);
        plowedFieldHappinessImage.setImageResource(R.drawable.happiness);
        helpHorsesStaminaImage.setImageResource(R.drawable.stamina);
        helpHorsesSatietyImage.setImageResource(R.drawable.satiety);
        helpHorsesHappinessImage.setImageResource(R.drawable.happiness);
        helpPeopleStaminaImage.setImageResource(R.drawable.stamina);
        helpPeopleSatietyImage.setImageResource(R.drawable.satiety);
        helpPeopleHappinessImage.setImageResource(R.drawable.happiness);
        knockCorralGateStaminaImage.setImageResource(R.drawable.stamina);
        knockCorralGateSatietyImage.setImageResource(R.drawable.satiety);
        knockCorralGateHappinessImage.setImageResource(R.drawable.happiness);
        participateHorseRaceStaminaImage.setImageResource(R.drawable.stamina);
        participateHorseRaceSatietyImage.setImageResource(R.drawable.satiety);
        participateHorseRaceHappinessImage.setImageResource(R.drawable.happiness);
        participateHorseRaceGoldAppleImage.setImageResource(R.drawable.image_goldapple);
        bobMusclesStaminaImage.setImageResource(R.drawable.stamina);
        bobMusclesSatietyImage.setImageResource(R.drawable.satiety);
        bobMusclesHappinessImage.setImageResource(R.drawable.happiness);
        bobMusclesGoldAppleImage.setImageResource(R.drawable.image_goldapple);
        participateChampionshipStaminaImage.setImageResource(R.drawable.stamina);
        participateChampionshipSatietyImage.setImageResource(R.drawable.satiety);
        participateChampionshipWinHappinessImage.setImageResource(R.drawable.happiness);
        participateChampionshipLoseHappinessImage.setImageResource(R.drawable.happiness);
        participateChampionshipGoldAppleImage.setImageResource(R.drawable.image_goldapple);




        findAppleStaminaText.setText(withSign(-Constants.findAppleDownStamina - Constants.wasStepDownStamina));
        findAppleSatietyText.setText(withSign(-Constants.findAppleDownSatiety - Constants.wasStepDownSatiety));
        findAppleHappinessText.setText(withSign(- Constants.wasStepDownHappiness));
        findAppleOtherText.setText(getString(R.string.with_chance) + " 50%:    +1");
        plowedFieldStaminaText.setText(withSign(- Constants.plowedFieldDownStamina - Constants.wasStepDownStamina));
        plowedFieldSatietyText.setText(withSign( -Constants.plowedFieldDownSatiety - Constants.wasStepDownSatiety));
        plowedFieldHappinessText.setText(withSign(- Constants.wasStepDownHappiness));
        plowedFieldOtherText.setText(getString(R.string.respect_horses) + " -" + Constants.plowedFieldDownRespectHorses + "\n" +
                getString(R.string.respect_peoples) + " +" + Constants.plowedFieldUpRespectPeoples);
        helpHorsesStaminaText.setText(withSign(-Constants.helpHorsesDownStamina - Constants.wasStepDownStamina));
        helpHorsesSatietyText.setText(withSign(-Constants.helpHorsesDownSatiety - Constants.wasStepDownSatiety));
        helpHorsesHappinessText.setText(withSign(- Constants.wasStepDownHappiness));
        helpHorsesOtherText.setText(getString(R.string.respect_horses) + " +" + Constants.helpHorsesUpRespectHorses + "\n" +
                getString(R.string.respect_peoples) + " -" + Constants.helpHorsesDownRespectPeoples);
        helpPeopleStaminaText.setText(withSign(-Constants.helpPeopleDownStamina - Constants.wasStepDownStamina));
        helpPeopleSatietyText.setText(withSign(-Constants.helpPeopleDownSatiety - Constants.wasStepDownSatiety));
        helpPeopleHappinessText.setText(withSign( - Constants.wasStepDownHappiness));
        helpPeopleOtherText.setText(getString(R.string.respect_horses) + " -" + Constants.helpPeopleDownRespectHorses + "\n" +
                getString(R.string.respect_peoples) + " +" + Constants.helpPeopleUpRespectPeoples);
        knockCorralGateStaminaText.setText(withSign(-Constants.knockCorralGateDownStamina - Constants.wasStepDownStamina));
        knockCorralGateSatietyText.setText(withSign(-Constants.knockCorralGateDownSatiety - Constants.wasStepDownSatiety));
        knockCorralGateHappinessText.setText(withSign( - Constants.wasStepDownHappiness));
        knockCorralGateOtherText.setText(getString(R.string.respect_horses) + " +" + Constants.knockCorralGateUpRespectHorses + "\n" +
                getString(R.string.respect_peoples) + " -" + Constants.knockCorralGateDownRespectPeoples);
        participateHorseRaceStaminaText.setText(withSign(-Constants.participateHorseRaceDownStamina - Constants.wasStepDownStamina));
        participateHorseRaceSatietyText.setText(withSign(-Constants.participateHorseRaceDownSatiety - Constants.wasStepDownSatiety));
        participateHorseRaceHappinessText.setText(withSign(- Constants.wasStepDownHappiness));
        participateHorseRaceGoldAppleText.setText(withSign(-1));
        participateHorseRaceOtherText.setText(getString(R.string.respect_horses) + " +" + Constants.participateHorseRaceUpRespectHorses + "\n" +
                getString(R.string.respect_peoples) + " +" + Constants.participateHorseRaceUpRespectPeople);
        bobMusclesStaminaText.setText(withSign(-Constants.bobMusclesDownStamina - Constants.wasStepDownStamina));
        bobMusclesSatietyText.setText(withSign(-Constants.bobMusclesDownSatiety - Constants.wasStepDownSatiety));
        bobMusclesHappinessText.setText(withSign( - Constants.wasStepDownHappiness));
        bobMusclesGoldAppleText.setText(withSign(-1));
        bobMusclesOtherText.setText(getString(R.string.max_speed) + " +" + Constants.bobMusclesUpMaxSpeed);
        participateChampionshipStaminaText.setText(withSign(-Constants.participateChampionshipDownStamina - Constants.wasStepDownStamina));
        participateChampionshipSatietyText.setText(withSign(-Constants.participateChampionshipDownSatiety - Constants.wasStepDownSatiety));
        participateChampionshipWinHappinessText.setText(withSign(Constants.participateChampionshipUpHappiness - Constants.wasStepDownHappiness));
        participateChampionshipLoseHappinessText.setText(withSign(-Constants.participateChampionshipDownHappiness - Constants.wasStepDownHappiness));
        participateChampionshipGoldAppleText.setText(withSign(Constants.participateChampionshipUpApples));
        participateChampionshipWinText.setText(getString(R.string.respect_horses) + " +" + Constants.participateChampionshipUpRespectHorses + "\n" +
                getString(R.string.respect_peoples) + " +" + Constants.participateChampionshipUpRespectPeoples);
        participateChampionshipLoseText.setText(getString(R.string.respect_horses) + " -" + Constants.participateChampionshipDownRespectHorses + "\n" +
                getString(R.string.respect_peoples) + " -" + Constants.participateChampionshipDownRespectPeoples);


        buttonFindApple.setOnClickListener(this);
        buttonGetApple.setOnClickListener(this);
        buttonPlowedField.setOnClickListener(this);
        buttonHelpHorses.setOnClickListener(this);
        buttonHelpPeople.setOnClickListener(this);
        buttonKnockCorralGate.setOnClickListener(this);
        buttonParticipateHorseRace.setOnClickListener(this);
        buttonBobMuscles.setOnClickListener(this);
        buttonParticipateChampionship.setOnClickListener(this);


        update();

        return view;
    }

    public String withSign(int value){
        if (value > 0)
            return "+" + value;
        return "" + value;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button_get_apple){
            listener.clickEvent("getApple");
            return;
        }
        listener.clickEvent("wasStep");
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
                    listener.clickEvent("showWinChampionship");
                else
                    listener.clickEvent("showLoseChampionship");
                MainActivity.controller.setTimeToChampionship(Constants.timeToChampionship);
                break;
            }
        }
        listener.clickEvent("updateScore");
        listener.clickEvent("dieCheck");
        update();
        MainActivity.page_4.update();
        MainActivity.page_2.update();
        MainActivity.updateStats();
    }

    public void update() {
        switch (MainActivity.controller.getHorse().getHabitat()){
            case TABOR:{
                buttonPlowedField.setEnabled(false);
                buttonKnockCorralGate.setEnabled(false);

                buttonPlowedField.setText(R.string.need_habitat_ranch);
                buttonKnockCorralGate.setText(R.string.need_habitat_meadows);
                break;
            }
            case PADDOCK:{
                buttonPlowedField.setEnabled(false);
                buttonKnockCorralGate.setEnabled(false);

                buttonPlowedField.setText(R.string.need_habitat_ranch);
                buttonKnockCorralGate.setText(R.string.need_habitat_meadows);
                break;
            }
            case STABLE:{
                buttonPlowedField.setEnabled(false);
                buttonKnockCorralGate.setEnabled(false);

                buttonPlowedField.setText(R.string.need_habitat_ranch);
                buttonKnockCorralGate.setText(R.string.need_habitat_meadows);
                break;
            }
            case RANCH:{
                buttonPlowedField.setEnabled(true);
                buttonKnockCorralGate.setEnabled(false);

                buttonPlowedField.setText(R.string.plowed_field);
                buttonKnockCorralGate.setText(R.string.need_habitat_meadows);
            }
            case HORSE_CLUB:{
                buttonPlowedField.setEnabled(true);
                buttonKnockCorralGate.setEnabled(false);

                buttonPlowedField.setText(R.string.plowed_field);
                buttonKnockCorralGate.setText(R.string.need_habitat_meadows);
                break;
            }
            case PRIVATE_FARM:{
                buttonPlowedField.setEnabled(true);
                buttonKnockCorralGate.setEnabled(false);

                buttonPlowedField.setText(R.string.plowed_field);
                buttonKnockCorralGate.setText(R.string.need_habitat_meadows);
                break;
            }
            case WASTELAND:{
                buttonPlowedField.setEnabled(false);
                buttonKnockCorralGate.setEnabled(false);

                buttonPlowedField.setText(R.string.need_habitat_ranch);
                buttonKnockCorralGate.setText(R.string.need_habitat_meadows);
                break;
            }
            case CLEAR_FIELD:{
                buttonPlowedField.setEnabled(false);
                buttonKnockCorralGate.setEnabled(false);

                buttonPlowedField.setText(R.string.need_habitat_ranch);
                buttonKnockCorralGate.setText(R.string.need_habitat_meadows);
                break;
            }
            case MEADOWS:{
                buttonPlowedField.setEnabled(false);
                buttonKnockCorralGate.setEnabled(true);

                buttonPlowedField.setText(R.string.need_habitat_ranch);
                buttonKnockCorralGate.setText(R.string.knock_corral_gate);
            }
            case PRAIRIE:{
                buttonPlowedField.setEnabled(false);
                buttonKnockCorralGate.setEnabled(true);

                buttonPlowedField.setText(R.string.need_habitat_ranch);
                buttonKnockCorralGate.setText(R.string.knock_corral_gate);
                break;
            }
            case KAZAKHSTAN:{
                buttonPlowedField.setEnabled(false);
                buttonKnockCorralGate.setEnabled(true);

                buttonPlowedField.setText(R.string.need_habitat_ranch);
                buttonKnockCorralGate.setText(R.string.knock_corral_gate);
                break;
            }
            default: return;
        }

        if (MainActivity.controller.getTimeToAdd() != 0) {
            buttonGetApple.setEnabled(false);
            buttonGetApple.setText(""  + getString(R.string.to_add) + " " + MainActivity.controller.getTimeToAdd()
                    + " " + dayString(MainActivity.controller.getTimeToAdd()));
        }
        else {
            buttonGetApple.setEnabled(true);
            buttonGetApple.setText(R.string.get_apple);
        }

        if (MainActivity.controller.getTimeToChampionship() != 0) {
            buttonParticipateChampionship.setEnabled(false);
            buttonParticipateChampionship.setText(""  + getString(R.string.championship) + " " + MainActivity.controller.getTimeToChampionship()
                    + " " + dayString(MainActivity.controller.getTimeToChampionship()));
        }
        else {
            buttonParticipateChampionship.setEnabled(true);
            buttonParticipateChampionship.setText(R.string.participate_championship);
        }

        if (MainActivity.controller.getGoldApple() == 0){
            buttonParticipateHorseRace.setEnabled(false);
            buttonBobMuscles.setEnabled(false);
        }
        else {
            buttonParticipateHorseRace.setEnabled(true);
            buttonBobMuscles.setEnabled(true);
        }
    }

    public String dayString(int days) {
        if (days % 10 > 4 || days % 10 == 0 || (days > 10 && days < 20))
            return getString(R.string.days);
        if (days % 10 == 1)
            return getString(R.string.day);

        return getString(R.string.days1);
    }
}