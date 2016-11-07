package blue_caps.horsesimulator;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by alexu on 4.11.2016.
 */

public class Page_3 extends Fragment implements View.OnClickListener {
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
            findAppleStaminaText,
            findAppleSatietyText,
            findAppleHappinessText,
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
            participateChampionshipHappinessText;
    //не забудь добавить то, что хотел
    private ImageView
            findAppleStaminaImage,
            findAppleSatietyImage,
            findAppleHappinessImage,
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
            participateChampionshipHappinessImage;
    //Аналогично

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.page_3, null);

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
        participateChampionshipHappinessText = (TextView) view.findViewById(R.id.participate_championship_happiness_text);

        findAppleStaminaImage = (ImageView) view.findViewById(R.id.find_apple_stamina_image);
        findAppleSatietyImage= (ImageView) view.findViewById(R.id.find_apple_satiety_image);
        findAppleHappinessImage = (ImageView) view.findViewById(R.id.find_apple_happiness_image);
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
        participateChampionshipHappinessImage = (ImageView) view.findViewById(R.id.participate_championship_happiness_image);
        //Участие в чемпионате, аналогично

        findAppleStaminaImage.setImageResource(R.drawable.stamina);
        findAppleSatietyImage.setImageResource(R.drawable.satiety);
        findAppleHappinessImage.setImageResource(R.drawable.happiness);
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
        participateChampionshipHappinessImage.setImageResource(R.drawable.happiness);
        //participateChampionshipGoldAppleImage.setImageResource(R.drawable.image_goldapple);




        findAppleStaminaText.setText(withSign(Constants.goToWateringUpStamina - Constants.wasStepDownStamina));
        findAppleSatietyText.setText(withSign(Constants.goToWateringUpStamina - Constants.wasStepDownStamina));
        findAppleHappinessText.setText(withSign(Constants.goToWateringUpStamina - Constants.wasStepDownStamina));
        plowedFieldStaminaText.setText(withSign(Constants.goToWateringUpStamina - Constants.wasStepDownStamina));
        plowedFieldSatietyText.setText(withSign(Constants.goToWateringUpStamina - Constants.wasStepDownStamina));
        plowedFieldHappinessText.setText(withSign(Constants.goToWateringUpStamina - Constants.wasStepDownStamina));
        plowedFieldOtherText.setText(withSign(Constants.goToWateringUpStamina - Constants.wasStepDownStamina));
        helpHorsesStaminaText.setText(withSign(Constants.goToWateringUpStamina - Constants.wasStepDownStamina));
        helpHorsesSatietyText.setText(withSign(Constants.goToWateringUpStamina - Constants.wasStepDownStamina));
        helpHorsesHappinessText.setText(withSign(Constants.goToWateringUpStamina - Constants.wasStepDownStamina));
        helpHorsesOtherText.setText(withSign(Constants.goToWateringUpStamina - Constants.wasStepDownStamina));
        helpPeopleStaminaText.setText(withSign(Constants.goToWateringUpStamina - Constants.wasStepDownStamina));
        helpPeopleSatietyText.setText(withSign(Constants.goToWateringUpStamina - Constants.wasStepDownStamina));
        helpPeopleHappinessText.setText(withSign(Constants.goToWateringUpStamina - Constants.wasStepDownStamina));
        helpPeopleOtherText.setText(withSign(Constants.goToWateringUpStamina - Constants.wasStepDownStamina));
        knockCorralGateStaminaText.setText(withSign(Constants.goToWateringUpStamina - Constants.wasStepDownStamina));
        knockCorralGateSatietyText.setText(withSign(Constants.goToWateringUpStamina - Constants.wasStepDownStamina));
        knockCorralGateHappinessText.setText(withSign(Constants.goToWateringUpStamina - Constants.wasStepDownStamina));
        knockCorralGateOtherText.setText(withSign(Constants.goToWateringUpStamina - Constants.wasStepDownStamina));
        participateHorseRaceStaminaText.setText(withSign(Constants.goToWateringUpStamina - Constants.wasStepDownStamina));
        participateHorseRaceSatietyText.setText(withSign(Constants.goToWateringUpStamina - Constants.wasStepDownStamina));
        participateHorseRaceHappinessText.setText(withSign(Constants.goToWateringUpStamina - Constants.wasStepDownStamina));
        participateHorseRaceGoldAppleText.setText(withSign(Constants.goToWateringUpStamina - Constants.wasStepDownStamina));
        participateHorseRaceOtherText.setText(withSign(Constants.goToWateringUpStamina - Constants.wasStepDownStamina));
        bobMusclesStaminaText.setText(withSign(Constants.goToWateringUpStamina - Constants.wasStepDownStamina));
        bobMusclesSatietyText.setText(withSign(Constants.goToWateringUpStamina - Constants.wasStepDownStamina));
        bobMusclesHappinessText.setText(withSign(Constants.goToWateringUpStamina - Constants.wasStepDownStamina));
        bobMusclesGoldAppleText.setText(withSign(Constants.goToWateringUpStamina - Constants.wasStepDownStamina));
        bobMusclesOtherText.setText(withSign(Constants.goToWateringUpStamina - Constants.wasStepDownStamina));
        participateChampionshipStaminaText.setText(withSign(Constants.goToWateringUpStamina - Constants.wasStepDownStamina));
        participateChampionshipSatietyText.setText(withSign(Constants.goToWateringUpStamina - Constants.wasStepDownStamina));
        participateChampionshipHappinessText.setText(withSign(Constants.goToWateringUpStamina - Constants.wasStepDownStamina));


        buttonFindApple.setOnClickListener(this);
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
        MainActivity.controller.wasStep(getActivity());
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
        MainActivity.controller.dieCheck(getActivity());
        update();
        MainActivity.page_3.update();
        MainActivity.updateStats();
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