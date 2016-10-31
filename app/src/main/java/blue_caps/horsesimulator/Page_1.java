package blue_caps.horsesimulator;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * Created by alexu on 30.10.2016.
 */

public class Page_1 extends StepFragment implements View.OnClickListener {
    private Button buttonHaveSleep;
    private Button buttonGoToWatering;
    private Button buttonGoToDrinkers;
    private Button buttonGetMassage;
    private Button buttonSwimInLake;

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

        buttonHaveSleep.setOnClickListener(this);
        buttonGoToWatering.setOnClickListener(this);
        buttonGoToDrinkers.setOnClickListener(this);
        buttonGetMassage.setOnClickListener(this);
        buttonSwimInLake.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        step();

        switch (view.getId()) {
            case R.id.button_have_sleep: MainActivity.controller.haveSleep(); break;
            case R.id.button_go_to_watering: MainActivity.controller.goToWatering(); break;
            case R.id.button_go_to_drinkers: MainActivity.controller.goToDrinkers(); break;
            case R.id.button_get_massage: MainActivity.controller.getMassage(); break;
            case R.id.button_swim_in_lake: MainActivity.controller.swimInLake(); break;
        }
    }
}
