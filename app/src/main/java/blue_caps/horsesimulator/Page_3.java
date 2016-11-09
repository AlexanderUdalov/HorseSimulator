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

import com.google.android.gms.ads.InterstitialAd;

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
            participateChampionshipWinHappinessText,
            participateChampionshipLoseHappinessText,
            participateChampionshipGoldAppleText,
            participateChampionshipWinText,
            participateChampionshipLoseText;
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
            participateChampionshipWinHappinessImage,
            participateChampionshipLoseHappinessImage,
            participateChampionshipGoldAppleImage;
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
        participateChampionshipWinHappinessText = (TextView) view.findViewById(R.id.participate_championship_win_happiness_text);
        participateChampionshipLoseHappinessText = (TextView) view.findViewById(R.id.participate_championship_lose_happiness_text);
        participateChampionshipGoldAppleText= (TextView) view.findViewById(R.id.participate_championship_gold_apple_text);
        participateChampionshipWinText = (TextView) view.findViewById(R.id.participate_championship_win_other_text);
        participateChampionshipLoseText = (TextView) view.findViewById(R.id.participate_championship_lose_other_text);

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
        participateChampionshipWinHappinessImage = (ImageView) view.findViewById(R.id.participate_championship_win_happiness_image);
        participateChampionshipLoseHappinessImage = (ImageView) view.findViewById(R.id.participate_championship_lose_happiness_image);
        participateChampionshipGoldAppleImage  = (ImageView) view.findViewById(R.id.participate_championship_gold_apple_image);
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
        participateChampionshipWinHappinessImage.setImageResource(R.drawable.happiness);
        participateChampionshipLoseHappinessImage.setImageResource(R.drawable.happiness);
        participateChampionshipGoldAppleImage.setImageResource(R.drawable.image_goldapple);




        findAppleStaminaText.setText(withSign(-Constants.findAppleDownStamina - Constants.wasStepDownStamina));
        findAppleSatietyText.setText(withSign(-Constants.findAppleDownSatiety - Constants.wasStepDownStamina));
        findAppleHappinessText.setText(withSign(- Constants.wasStepDownStamina));
        plowedFieldStaminaText.setText(withSign(- Constants.plowedFieldDownStamina - Constants.wasStepDownStamina));
        plowedFieldSatietyText.setText(withSign( -Constants.plowedFieldDownSatiety - Constants.wasStepDownStamina));
        plowedFieldHappinessText.setText(withSign(- Constants.wasStepDownStamina));
        plowedFieldOtherText.setText(getString(R.string.respect_horses) + " -" + Constants.plowedFieldDownRespectHorses + "\n" +
                getString(R.string.respect_peoples) + " +" + Constants.plowedFieldUpRespectPeoples);
        helpHorsesStaminaText.setText(withSign(-Constants.helpHorsesDownStamina - Constants.wasStepDownStamina));
        helpHorsesSatietyText.setText(withSign(-Constants.helpHorsesDownSatiety - Constants.wasStepDownStamina));
        helpHorsesHappinessText.setText(withSign(- Constants.wasStepDownStamina));
        helpHorsesOtherText.setText(getString(R.string.respect_horses) + " +" + Constants.helpHorsesUpRespectHorses + "\n" +
                getString(R.string.respect_peoples) + " -" + Constants.helpHorsesDownRespectPeoples);
        helpPeopleStaminaText.setText(withSign(-Constants.helpPeopleDownStamina - Constants.wasStepDownStamina));
        helpPeopleSatietyText.setText(withSign(-Constants.helpPeopleDownSatiety - Constants.wasStepDownStamina));
        helpPeopleHappinessText.setText(withSign( - Constants.wasStepDownStamina));
        helpPeopleOtherText.setText(getString(R.string.respect_horses) + " -" + Constants.helpPeopleDownRespectHorses + "\n" +
                getString(R.string.respect_peoples) + " +" + Constants.helpPeopleUpRespectPeoples);
        knockCorralGateStaminaText.setText(withSign(-Constants.knockCorralGateDownStamina - Constants.wasStepDownStamina));
        knockCorralGateSatietyText.setText(withSign(-Constants.knockCorralGateDownSatiety - Constants.wasStepDownStamina));
        knockCorralGateHappinessText.setText(withSign( - Constants.wasStepDownStamina));
        knockCorralGateOtherText.setText(getString(R.string.respect_horses) + " +" + Constants.knockCorralGateUpRespectHorses + "\n" +
                getString(R.string.respect_peoples) + " -" + Constants.knockCorralGateDownRespectPeoples);
        participateHorseRaceStaminaText.setText(withSign(-Constants.participateHorseRaceDownStamina - Constants.wasStepDownStamina));
        participateHorseRaceSatietyText.setText(withSign(Constants.participateHorseRaceDownSatiety - Constants.wasStepDownStamina));
        participateHorseRaceHappinessText.setText(withSign(- Constants.wasStepDownStamina));
        participateHorseRaceGoldAppleText.setText(withSign(-1));
        participateHorseRaceOtherText.setText(getString(R.string.respect_horses) + " +" + Constants.participateHorseRaceUpRespectHorses + "\n" +
                getString(R.string.respect_peoples) + " +" + Constants.participateHorseRaceUpRespectPeople);
        bobMusclesStaminaText.setText(withSign(-Constants.bobMusclesDownStamina - Constants.wasStepDownStamina));
        bobMusclesSatietyText.setText(withSign(-Constants.bobMusclesDownSatiety - Constants.wasStepDownStamina));
        bobMusclesHappinessText.setText(withSign( - Constants.wasStepDownStamina));
        bobMusclesGoldAppleText.setText(withSign(-1));
        bobMusclesOtherText.setText(getString(R.string.max_speed) + " +" + Constants.bobMusclesUpMaxSpeed);
        participateChampionshipStaminaText.setText(withSign(-Constants.participateChampionshipDownStamina - Constants.wasStepDownStamina));
        participateChampionshipSatietyText.setText(withSign(-Constants.participateChampionshipDownSatiety - Constants.wasStepDownStamina));
        participateChampionshipWinHappinessText.setText(withSign(-Constants.participateChampionshipDownHappiness - Constants.wasStepDownHappiness));
        participateChampionshipLoseHappinessText.setText(withSign(Constants.participateChampionshipUpHappiness - Constants.wasStepDownHappiness));
        participateChampionshipGoldAppleText.setText(withSign(Constants.participateChampionshipUpApples));
        participateChampionshipWinText.setText(getString(R.string.respect_horses) + " +" + Constants.participateChampionshipUpRespectHorses + "\n" +
                getString(R.string.respect_peoples) + " +" + Constants.participateChampionshipUpRespectPeoples);
        participateChampionshipLoseText.setText(getString(R.string.respect_horses) + " -" + Constants.participateChampionshipDownRespectHorses + "\n" +
                getString(R.string.respect_peoples) + " -" + Constants.participateChampionshipDownRespectPeoples);


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
        MainActivity.page_4.update();
        MainActivity.page_2.update();
        MainActivity.updateStats();
    }


    public void update(){
        if (MainActivity.controller.getTimeToChampionship() != 0) {
            buttonParticipateChampionship.setEnabled(false);
            buttonParticipateChampionship.setText(""  + R.string.championship + MainActivity.controller.getTimeToChampionship() + " ДНЕЙ");
        }
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