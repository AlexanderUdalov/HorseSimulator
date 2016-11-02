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

public class Page_2 extends Fragment implements View.OnClickListener{
    private Button
            buttonEatGrass,
            buttonStealingFood,
            buttonBeggingSugar,
            buttonAskForFood,
            buttonEatApple;
    private TextView
            textEatGrass,
            textStealingFood,
            textBeggingSugar,
            textAskForFood,
            textEatApple;

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

        textEatGrass = (TextView) view.findViewById(R.id.text_eat_grass);
        textStealingFood = (TextView) view.findViewById(R.id.text_stealing_food);
        textBeggingSugar = (TextView) view.findViewById(R.id.text_begging_sugar);
        textAskForFood = (TextView) view.findViewById(R.id.text_ask_for_food);
        textEatApple = (TextView) view.findViewById(R.id.text_eat_apple);

        textEatGrass.setText(makeParamString(R.id.text_eat_grass));
        textStealingFood.setText(makeParamString(R.id.text_stealing_food));
        textBeggingSugar.setText(makeParamString(R.id.text_begging_sugar));
        textAskForFood.setText(makeParamString(R.id.text_ask_for_food));
        textEatApple.setText(makeParamString(R.id.text_eat_apple));


        buttonEatGrass.setOnClickListener(this);
        buttonStealingFood.setOnClickListener(this);
        buttonBeggingSugar.setOnClickListener(this);
        buttonAskForFood.setOnClickListener(this);
        buttonEatApple.setOnClickListener(this);

        return view;
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
            case R.id.text_eat_grass: {
                sb.append(tmpStamina);
                sb.append(": ");
                sb.append(-Constants.eatGrassDownStamina - Constants.wasStepDownStamina);
                sb.append("; ");
                sb.append(tmpSatiety);
                sb.append(": +");
                sb.append(Constants.eatGrassUpSatiety - Constants.wasStepDownSatiety);
                sb.append("; ");
                sb.append(tmpHappiness);
                sb.append(": ");
                sb.append(- Constants.wasStepDownHappiness);
                return sb.toString();
            }
            case R.id.text_stealing_food:{
                sb.append(tmpStamina);
                sb.append(": ");
                sb.append(-Constants.stealingFoodDownStamina - Constants.wasStepDownStamina);
                sb.append("; ");
                sb.append(tmpSatiety);
                sb.append(": +");
                sb.append(Constants.stealingFoodUpSatiety - Constants.wasStepDownSatiety);
                sb.append("; ");
                sb.append(tmpHappiness);
                sb.append(": ");
                sb.append(-Constants.stealingFoodDownHappiness - Constants.wasStepDownHappiness);
                sb.append("; ");
                sb.append(tmpHorseRespect);
                sb.append(" +");
                sb.append(Constants.stealingFoodUpRespectHorses);
                sb.append("; ");
                sb.append(tmpPeopleREspect);
                sb.append(" ");
                sb.append(-Constants.stealingFoodDownRespectPeoples);
                return sb.toString();
            }
            case R.id.text_ask_for_food:{
                sb.append(tmpStamina);
                sb.append(": ");
                sb.append(-Constants.askForFoodDownStamina - Constants.wasStepDownStamina);
                sb.append("; ");
                sb.append(tmpSatiety);
                sb.append(": +");
                sb.append(Constants.askForFoodUpSatiety - Constants.wasStepDownSatiety);
                sb.append("; ");
                sb.append(tmpHappiness);
                sb.append(": ");
                sb.append(Constants.askForFoodUpHappiness - Constants.wasStepDownHappiness);
                return sb.toString();
            }
            case R.id.text_begging_sugar:{
                sb.append(tmpStamina);
                sb.append(": ");
                sb.append(-Constants.beggingSugarDownStamina - Constants.wasStepDownStamina);
                sb.append("; ");
                sb.append(tmpSatiety);
                sb.append(": +");
                sb.append(-Constants.beggingSugarUpSatiety - Constants.wasStepDownSatiety);
                sb.append("; ");
                sb.append(tmpHappiness);
                sb.append(": +");
                sb.append(Constants.beggingSugarUpHappiness - Constants.wasStepDownHappiness);
                sb.append("; ");
                sb.append(tmpHorseRespect);
                sb.append(" ");
                sb.append(-Constants.beggingSugarDownRespectHorses);
                return sb.toString();
            }
            case R.id.text_eat_apple:{
                sb.append(tmpStamina);
                sb.append(": ");
                sb.append(-Constants.wasStepDownStamina);
                sb.append("; ");
                sb.append(tmpSatiety);
                sb.append(": +");
                sb.append(Constants.eatAppleUpSatiety - Constants.wasStepDownSatiety);
                sb.append("; ");
                sb.append(tmpHappiness);
                sb.append(": +");
                sb.append(Constants.eatAppleUpHappiness - Constants.wasStepDownHappiness);
                return sb.toString();
            }
            default: return null;
        }
    }
}
