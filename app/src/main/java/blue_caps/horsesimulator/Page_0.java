package blue_caps.horsesimulator;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * Created by alexu on 30.10.2016.
 */

public class Page_0 extends Fragment {
    private TextView valueRespectPeople;
    private TextView valueRespectHorses;
    private TextView valueTotalScore;
    private TextView valueLevel;
    private TextView valueHabitat;
    private TextView valueCountRomaAttack;
    private TextView valueTimeToAttack;
    private Button buttonTableLevel;
    private Button buttonHowToPlay;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.page_0, null);

        valueRespectHorses = (TextView) view.findViewById(R.id.value_respect_horses);
        valueRespectPeople = (TextView) view.findViewById(R.id.value_respect_people);
        valueTotalScore = (TextView) view.findViewById(R.id.value_total_score);
        valueLevel = (TextView) view.findViewById(R.id.value_level);
        valueHabitat = (TextView) view.findViewById(R.id.value_habitat);
        valueCountRomaAttack = (TextView) view.findViewById(R.id.value_roma_attack);
        valueTimeToAttack = (TextView) view.findViewById(R.id.value_time_to_attack);
        buttonTableLevel = (Button) view.findViewById(R.id.button_table_level);
        buttonHowToPlay = (Button) view.findViewById(R.id.button_how_to_play);

        switch (MainActivity.controller.getHorse().getHabitat()){
            case TABOR: { valueHabitat.setText(R.string.tabor); break; }
            case WASTELAND: { valueHabitat.setText(R.string.wasteland); break;  }
            case CLEAR_FIELD: { valueHabitat.setText(R.string.clear_field); break; }
            case MEADOWS: { valueHabitat.setText(R.string.meadows); break; }
            case PRAIRIE: { valueHabitat.setText(R.string.prairie); break;  }
            case KAZAKHSTAN: { valueHabitat.setText(R.string.kazakhstan); break;  }
            case PADDOCK: { valueHabitat.setText(R.string.paddock); break;  }
            case STABLE: { valueHabitat.setText(R.string.stable); break; }
            case RANCH: { valueHabitat.setText(R.string.ranch); break;  }
            case HORSE_CLUB: { valueHabitat.setText(R.string.horse_club); break;  }
            case PRIVATE_FARM:{ valueHabitat.setText(R.string.private_farm); break;  }
            default: break;
        }
        switch (MainActivity.controller.getTimeToAttack()){
            case 0:{
                valueTimeToAttack.setText(R.string.war_yet);
                break;
            }
            default:{
                valueTimeToAttack.setText(new String().valueOf(MainActivity.controller.getTimeToAttack()) + " " +
                        getString(R.string.days));
                break;
            }
        }
        valueRespectHorses.setText(new String().valueOf(MainActivity.controller.getHorse().getRespectHorses()));
        valueRespectPeople.setText(new String().valueOf(MainActivity.controller.getHorse().getRespectPeoples()));
        valueTotalScore.setText(" " + new String().valueOf(MainActivity.controller.getTotalScore()));
        valueCountRomaAttack.setText(new String().valueOf(MainActivity.controller.getCountRomaAtack()));

        buttonTableLevel.setText(R.string.table_level);
        buttonTableLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle(R.string.table_level).setCancelable(true);
                View v = LayoutInflater.from(getActivity()).inflate(R.layout.table_level, null);
                builder.setView(v);
                AlertDialog alert = builder.create();
                alert.show();

            }
        });
        buttonHowToPlay.setText(R.string.how_to_play);
        buttonHowToPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.showHowToPlay(getActivity());
            }
        });

        return view;
    }

}
