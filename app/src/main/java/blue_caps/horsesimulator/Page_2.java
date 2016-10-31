package blue_caps.horsesimulator;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by alexu on 30.10.2016.
 */

public class Page_2 extends StepFragment {
    private Button
        buttonEatGrass,
        buttonStealingFood,
        buttonBeggingSugar,
        buttonAskForFood,
        buttonEatApple;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Random rnd = new Random();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.page_2, null);

        buttonEatGrass     = (Button) view.findViewById(R.id.button_eat_grass);
        buttonStealingFood = (Button) view.findViewById(R.id.button_stealing_food);
        buttonBeggingSugar = (Button) view.findViewById(R.id.button_begging_sugar);
        buttonAskForFood   = (Button) view.findViewById(R.id.button_ask_for_food);
        buttonEatApple     = (Button) view.findViewById(R.id.button_eat_apple);

        buttonEatGrass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                step();
                MainActivity.controller.eatGrass();
            }
        });

        buttonStealingFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                step();
                MainActivity.controller.stealingFood();
            }
        });

        buttonBeggingSugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                step();
                MainActivity.controller.beggingSugar();
            }
        });

        buttonAskForFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                step();
                MainActivity.controller.askForFood();
            }
        });

        buttonEatApple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                step();
                MainActivity.controller.eatApple();
            }
        });

        return view;
    }
}
