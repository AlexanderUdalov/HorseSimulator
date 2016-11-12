package blue_caps.horsesimulator;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by alexu on 30.10.2016.
 */

public class Page_2 extends Fragment implements View.OnClickListener {
    private Button
            buttonEatGrass,
            buttonStealingFood,
            buttonBeggingSugar,
            buttonAskForFood,
            buttonEatApple;
    private TextView
            eatGrassStaminaText,
            eatGrassSatietyText,
            eatGrassHappinessText,
            stealingFoodStaminaText,
            stealingFoodSatietyText,
            stealingFoodHappinessText,
            stealingFoodOtherText,
            beggingSugarStaminaText,
            beggingSugarSatietyText,
            beggingSugarHappinessText,
            beggingSugarOtherText,
            askForFoodStaminaText,
            askForFoodSatietyText,
            askForFoodHappinessText,
            eatAppleStaminaText,
            eatAppleSatietyText,
            eatAppleHappinessText,
            eatAppleGoldAppleText;
    private ImageView
            eatGrassStaminaImage,
            eatGrassSatietyImage,
            eatGrassHappinessImage,
            stealingFoodStaminaImage,
            stealingFoodSatietyImage,
            stealingFoodHappinessImage,
            beggingSugarStaminaImage,
            beggingSugarSatietyImage,
            beggingSugarHappinessImage,
            askForFoodStaminaImage,
            askForFoodSatietyImage,
            askForFoodHappinessImage,
            eatAppleStaminaImage,
            eatAppleSatietyImage,
            eatAppleHappinessImage,
            eatAppleGoldAppleImage;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.page_2, null);

        buttonEatGrass = (Button) view.findViewById(R.id.button_eat_grass);
        buttonStealingFood = (Button) view.findViewById(R.id.button_stealing_food);
        buttonBeggingSugar = (Button) view.findViewById(R.id.button_begging_sugar);
        buttonAskForFood = (Button) view.findViewById(R.id.button_ask_for_food);
        buttonEatApple = (Button) view.findViewById(R.id.button_eat_apple);

        eatGrassStaminaText = (TextView) view.findViewById(R.id.eat_grass_stamina_text);
        eatGrassSatietyText = (TextView) view.findViewById(R.id.eat_grass_satiety_text);
        eatGrassHappinessText = (TextView) view.findViewById(R.id.eat_grass_happiness_text);
        stealingFoodStaminaText = (TextView) view.findViewById(R.id.stealing_food_stamina_text);
        stealingFoodSatietyText = (TextView) view.findViewById(R.id.stealing_food_satiety_text);
        stealingFoodHappinessText = (TextView) view.findViewById(R.id.stealing_food_happiness_text);
        stealingFoodOtherText = (TextView) view.findViewById(R.id.stealing_food_other_text);
        beggingSugarStaminaText = (TextView) view.findViewById(R.id.begging_sugar_stamina_text);
        beggingSugarSatietyText = (TextView) view.findViewById(R.id.begging_sugar_satiety_text);
        beggingSugarHappinessText = (TextView) view.findViewById(R.id.begging_sugar_happiness_text);
        beggingSugarOtherText = (TextView) view.findViewById(R.id.begging_sugar_other_text);
        askForFoodStaminaText = (TextView) view.findViewById(R.id.ask_for_food_stamina_text);
        askForFoodSatietyText = (TextView) view.findViewById(R.id.ask_for_food_satiety_text);
        askForFoodHappinessText = (TextView) view.findViewById(R.id.ask_for_food_happiness_text);
        eatAppleStaminaText = (TextView) view.findViewById(R.id.eat_apple_stamina_text);
        eatAppleSatietyText = (TextView) view.findViewById(R.id.eat_apple_satiety_text);
        eatAppleHappinessText = (TextView) view.findViewById(R.id.eat_apple_happiness_text);
        eatAppleGoldAppleText = (TextView) view.findViewById(R.id.eat_apple_gold_apple_text);

        eatGrassStaminaImage = (ImageView) view.findViewById(R.id.eat_grass_stamina_image);
        eatGrassSatietyImage= (ImageView) view.findViewById(R.id.eat_grass_satiety_image);
        eatGrassHappinessImage = (ImageView) view.findViewById(R.id.eat_grass_happiness_image);
        stealingFoodStaminaImage = (ImageView) view.findViewById(R.id.stealing_food_stamina_image);
        stealingFoodSatietyImage = (ImageView) view.findViewById(R.id.stealing_food_satiety_image);
        stealingFoodHappinessImage = (ImageView) view.findViewById(R.id.stealing_food_happiness_image);
        beggingSugarStaminaImage = (ImageView) view.findViewById(R.id.begging_sugar_stamina_image);
        beggingSugarSatietyImage = (ImageView) view.findViewById(R.id.begging_sugar_satiety_image);
        beggingSugarHappinessImage = (ImageView) view.findViewById(R.id.begging_sugar_happiness_image);
        askForFoodStaminaImage = (ImageView) view.findViewById(R.id.ask_for_food_stamina_image);
        askForFoodSatietyImage = (ImageView) view.findViewById(R.id.ask_for_food_satiety_image);
        askForFoodHappinessImage = (ImageView) view.findViewById(R.id.ask_for_food_happiness_image);
        eatAppleStaminaImage = (ImageView) view.findViewById(R.id.eat_apple_stamina_image);
        eatAppleSatietyImage = (ImageView) view.findViewById(R.id.eat_apple_satiety_image);
        eatAppleHappinessImage = (ImageView) view.findViewById(R.id.eat_apple_happiness_image);
        eatAppleGoldAppleImage = (ImageView) view.findViewById(R.id.eat_apple_gold_apple_image);

        eatGrassStaminaImage.setImageResource(R.drawable.stamina);
        eatGrassSatietyImage.setImageResource(R.drawable.satiety);
        eatGrassHappinessImage.setImageResource(R.drawable.happiness);
        stealingFoodStaminaImage.setImageResource(R.drawable.stamina);
        stealingFoodSatietyImage.setImageResource(R.drawable.satiety);
        stealingFoodHappinessImage.setImageResource(R.drawable.happiness);
        beggingSugarStaminaImage.setImageResource(R.drawable.stamina);
        beggingSugarSatietyImage.setImageResource(R.drawable.satiety);
        beggingSugarHappinessImage.setImageResource(R.drawable.happiness);
        askForFoodStaminaImage.setImageResource(R.drawable.stamina);
        askForFoodSatietyImage.setImageResource(R.drawable.satiety);
        askForFoodHappinessImage.setImageResource(R.drawable.happiness);
        eatAppleStaminaImage.setImageResource(R.drawable.stamina);
        eatAppleSatietyImage.setImageResource(R.drawable.satiety);
        eatAppleHappinessImage.setImageResource(R.drawable.happiness);
        eatAppleGoldAppleImage.setImageResource(R.drawable.image_goldapple);

        eatGrassStaminaText.setText(withSign(-Constants.eatGrassDownStamina - Constants.wasStepDownStamina));
        eatGrassSatietyText.setText(withSign(Constants.eatGrassUpSatiety - Constants.wasStepDownSatiety));
        eatGrassHappinessText.setText(withSign(-Constants.wasStepDownHappiness));
        stealingFoodStaminaText.setText(withSign(-Constants.stealingFoodDownStamina - Constants.wasStepDownStamina));
        stealingFoodSatietyText.setText(withSign(Constants.stealingFoodUpSatiety - Constants.wasStepDownSatiety));
        stealingFoodHappinessText.setText(withSign(-Constants.stealingFoodDownHappiness - Constants.wasStepDownHappiness));
        stealingFoodOtherText.setText(getString(R.string.respect_horses) + " +" + Constants.stealingFoodUpRespectHorses + "\n" +
                                        getString(R.string.respect_peoples) + " -" + Constants.stealingFoodDownRespectPeoples);
        beggingSugarStaminaText.setText(withSign(-Constants.beggingSugarDownStamina - Constants.wasStepDownStamina));
        beggingSugarSatietyText.setText(withSign(Constants.beggingSugarUpSatiety - Constants.wasStepDownSatiety));
        beggingSugarHappinessText.setText(withSign(Constants.beggingSugarUpHappiness - Constants.wasStepDownHappiness));
        beggingSugarOtherText.setText(getString(R.string.respect_horses) + " -" + Constants.beggingSugarDownRespectHorses + "\n" +
                                        getString(R.string.respect_peoples) + " +" + Constants.beggingSugarUpRespectPeoples);
        askForFoodStaminaText.setText(withSign(-Constants.askForFoodDownStamina - Constants.wasStepDownStamina));
        askForFoodSatietyText.setText(withSign(Constants.askForFoodUpSatiety - Constants.wasStepDownSatiety));
        askForFoodHappinessText.setText(withSign(Constants.askForFoodUpHappiness - Constants.wasStepDownHappiness));
        eatAppleStaminaText.setText(withSign(-Constants.eatGrassDownStamina - Constants.wasStepDownStamina));
        eatAppleSatietyText.setText(withSign(Constants.eatAppleUpSatiety - Constants.wasStepDownSatiety));
        eatAppleHappinessText.setText(withSign(Constants.eatAppleUpHappiness - Constants.wasStepDownHappiness));
        eatAppleGoldAppleText.setText(withSign(-1));


        buttonEatGrass.setOnClickListener(this);
        buttonStealingFood.setOnClickListener(this);
        buttonBeggingSugar.setOnClickListener(this);
        buttonAskForFood.setOnClickListener(this);
        buttonEatApple.setOnClickListener(this);

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
            case R.id.button_eat_grass:     MainActivity.controller.eatGrass(); break;
            case R.id.button_stealing_food: MainActivity.controller.stealingFood(); break;
            case R.id.button_begging_sugar: MainActivity.controller.beggingSugar(); break;
            case R.id.button_ask_for_food:  MainActivity.controller.askForFood(); break;
            case R.id.button_eat_apple:     MainActivity.controller.eatApple(); break;
        }
        MainActivity.controller.dieCheck(getActivity());
        update();
        MainActivity.page_1.update();
        MainActivity.page_3.update();
        MainActivity.updateStats();
   }

    public void update(){
        switch (MainActivity.controller.getHorse().getHabitat()){
            case TABOR:{
                buttonStealingFood.setEnabled(false);
                buttonBeggingSugar.setEnabled(false);
                buttonAskForFood.setEnabled(false);

                buttonStealingFood.setText(R.string.need_habitat_wasteland);
                buttonBeggingSugar.setText(R.string.need_habitat_paddock);
                buttonAskForFood.setText(R.string.need_habitat_clear_field_or_stable);
                break;
            }
            case PADDOCK:{
                buttonStealingFood.setEnabled(false);
                buttonBeggingSugar.setEnabled(true);
                buttonAskForFood.setEnabled(false);

                buttonStealingFood.setText(R.string.need_habitat_wasteland);
                buttonBeggingSugar.setText(R.string.begging_sugar);
                buttonAskForFood.setText(R.string.need_habitat_clear_field_or_stable);
                break;
            }
            case STABLE:{
                buttonStealingFood.setEnabled(false);
                buttonBeggingSugar.setEnabled(true);
                buttonAskForFood.setEnabled(true);

                buttonStealingFood.setText(R.string.need_habitat_wasteland);
                buttonBeggingSugar.setText(R.string.begging_sugar);
                buttonAskForFood.setText(R.string.ask_for_food);
                break;
            }
            case RANCH:{
                buttonStealingFood.setEnabled(false);
                buttonBeggingSugar.setEnabled(true);
                buttonAskForFood.setEnabled(true);

                buttonStealingFood.setText(R.string.need_habitat_wasteland);
                buttonBeggingSugar.setText(R.string.begging_sugar);
                buttonAskForFood.setText(R.string.ask_for_food);
            }
            case HORSE_CLUB:{
                buttonStealingFood.setEnabled(false);
                buttonBeggingSugar.setEnabled(true);
                buttonAskForFood.setEnabled(true);

                buttonStealingFood.setText(R.string.need_habitat_wasteland);
                buttonBeggingSugar.setText(R.string.begging_sugar);
                buttonAskForFood.setText(R.string.ask_for_food);
                break;
            }
            case PRIVATE_FARM:{
                buttonStealingFood.setEnabled(false);
                buttonBeggingSugar.setEnabled(true);
                buttonAskForFood.setEnabled(true);

                buttonStealingFood.setText(R.string.need_habitat_wasteland);
                buttonBeggingSugar.setText(R.string.begging_sugar);
                buttonAskForFood.setText(R.string.ask_for_food);
                break;
            }
            case WASTELAND:{
                buttonStealingFood.setEnabled(true);
                buttonBeggingSugar.setEnabled(false);
                buttonAskForFood.setEnabled(false);

                buttonStealingFood.setText(R.string.stealing_food);
                buttonBeggingSugar.setText(R.string.need_habitat_paddock);
                buttonAskForFood.setText(R.string.need_habitat_clear_field_or_stable);
                break;
            }
            case CLEAR_FIELD:{
                buttonStealingFood.setEnabled(true);
                buttonBeggingSugar.setEnabled(false);
                buttonAskForFood.setEnabled(true);

                buttonStealingFood.setText(R.string.stealing_food);
                buttonBeggingSugar.setText(R.string.need_habitat_paddock);
                buttonAskForFood.setText(R.string.ask_for_food);
                break;
            }
            case MEADOWS:{
                buttonStealingFood.setEnabled(true);
                buttonBeggingSugar.setEnabled(false);
                buttonAskForFood.setEnabled(true);

                buttonStealingFood.setText(R.string.stealing_food);
                buttonBeggingSugar.setText(R.string.need_habitat_paddock);
                buttonAskForFood.setText(R.string.ask_for_food);
            }
            case PRAIRIE:{
                buttonStealingFood.setEnabled(true);
                buttonBeggingSugar.setEnabled(false);
                buttonAskForFood.setEnabled(true);

                buttonStealingFood.setText(R.string.stealing_food);
                buttonBeggingSugar.setText(R.string.need_habitat_paddock);
                buttonAskForFood.setText(R.string.ask_for_food);
                break;
            }
            case KAZAKHSTAN:{
                buttonStealingFood.setEnabled(true);
                buttonBeggingSugar.setEnabled(false);
                buttonAskForFood.setEnabled(true);

                buttonStealingFood.setText(R.string.stealing_food);
                buttonBeggingSugar.setText(R.string.need_habitat_paddock);
                buttonAskForFood.setText(R.string.ask_for_food);
                break;
            }
            default: return;
        }

        if (MainActivity.controller.getGoldApple() == 0)
            buttonEatApple.setEnabled(false);
        else buttonEatApple.setEnabled(true);
    }
}
