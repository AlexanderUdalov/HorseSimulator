package blue_caps.horsesimulator;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by alexu on 30.10.2016.
 */

public class Page_3 extends Fragment implements View.OnClickListener{
    private Button
            buttonTabor,
            buttonClearField,
            buttonMeadows,
            buttonPrairie,
            buttonKazahstan,
            buttonWasteland,
            buttonPaddock,
            buttonStable,
            buttonRanch,
            buttonHorseClub,
            buttonPrivateFarm;
    private TextView
            textTabor,
            textClearField,
            textMeddow,
            textPrairie,
            textKazahstan,
            textWasteland,
            textPaddock,
            textStable,
            textRanch,
            textHorseClub,
            textPrivateFarm;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.page_3, null);

        buttonTabor = (Button) view.findViewById(R.id.button_tabor);
        buttonClearField = (Button) view.findViewById(R.id.button_clear_field);
        buttonMeadows = (Button) view.findViewById(R.id.button_meadows);
        buttonPrairie = (Button) view.findViewById(R.id.button_prairie);
        buttonKazahstan = (Button) view.findViewById(R.id.button_kazahstan);
        buttonWasteland = (Button) view.findViewById(R.id.button_wasteland);
        buttonPaddock = (Button) view.findViewById(R.id.button_paddock);
        buttonStable = (Button) view.findViewById(R.id.button_stable);
        buttonRanch = (Button) view.findViewById(R.id.button_ranch);
        buttonHorseClub = (Button) view.findViewById(R.id.button_horse_club);
        buttonPrivateFarm = (Button) view.findViewById(R.id.button_private_farm);

        textClearField = (TextView) view.findViewById(R.id.text_clear_field);
        textMeddow = (TextView) view.findViewById(R.id.text_meadows);
        textPrairie = (TextView) view.findViewById(R.id.text_prairie);
        textKazahstan = (TextView) view.findViewById(R.id.text_kazahstan);
        textWasteland = (TextView) view.findViewById(R.id.text_wasteland);
        textPaddock = (TextView) view.findViewById(R.id.text_paddock);
        textStable = (TextView) view.findViewById(R.id.text_stable);
        textRanch = (TextView) view.findViewById(R.id.text_ranch);
        textHorseClub = (TextView) view.findViewById(R.id.text_horse_club);
        textPrivateFarm = (TextView) view.findViewById(R.id.text_private_farm);

        textClearField.setText(makeParamString(R.id.text_clear_field));
        textMeddow.setText(makeParamString(R.id.text_meadows));
        textPrairie.setText(makeParamString(R.id.text_prairie));
        textKazahstan.setText(makeParamString(R.id.text_kazahstan));
        textWasteland.setText(makeParamString(R.id.text_wasteland));
        textPaddock.setText(makeParamString(R.id.text_paddock));
        textStable.setText(makeParamString(R.id.text_stable));
        textRanch.setText(makeParamString(R.id.text_ranch));
        textHorseClub.setText(makeParamString(R.id.text_horse_club));
        textPrivateFarm.setText(makeParamString(R.id.text_private_farm));

        buttonTabor.setOnClickListener(this);
        buttonClearField.setOnClickListener(this);
        buttonMeadows.setOnClickListener(this);
        buttonPrairie.setOnClickListener(this);
        buttonKazahstan.setOnClickListener(this);
        buttonWasteland.setOnClickListener(this);
        buttonPaddock.setOnClickListener(this);
        buttonStable.setOnClickListener(this);
        buttonRanch.setOnClickListener(this);
        buttonHorseClub.setOnClickListener(this);
        buttonPrivateFarm.setOnClickListener(this);

        update();

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_clear_field: {
                MainActivity.controller.getHorse().setHabitat(Habitat.CLEAR_FIELD);
                showToast(getString(R.string.clear_field));
                break;
            }
            case R.id.button_meadows: {
                MainActivity.controller.getHorse().setHabitat(Habitat.MEADOWS);

                showToast(getString(R.string.meadows));
                break;
            }
            case R.id.button_prairie: {
                MainActivity.controller.getHorse().setHabitat(Habitat.PRAIRIE);
                showToast(getString(R.string.prairie));
                break;
            }
            case R.id.button_kazahstan: {
                MainActivity.controller.getHorse().setHabitat(Habitat.KAZAKHSTAN);
                showToast(getString(R.string.kazakhstan));
                break;
            }
            case R.id.button_wasteland: {
                MainActivity.controller.getHorse().setHabitat(Habitat.WASTELAND);
                showToast(getString(R.string.wasteland));
                break;
            }
            case R.id.button_paddock: {
                MainActivity.controller.getHorse().setHabitat(Habitat.PADDOCK);
                showToast(getString(R.string.paddock));
                break;
            }
            case R.id.button_stable: {
                MainActivity.controller.getHorse().setHabitat(Habitat.STABLE);
                showToast(getString(R.string.stable));
                break;
            }
            case R.id.button_ranch: {
                MainActivity.controller.getHorse().setHabitat(Habitat.RANCH);
                showToast(getString(R.string.ranch));
                break;
            }
            case R.id.button_horse_club: {
                MainActivity.controller.getHorse().setHabitat(Habitat.HORSE_CLUB);
                showToast(getString(R.string.horse_club));
                break;
            }
            case R.id.button_private_farm: {
                MainActivity.controller.getHorse().setHabitat(Habitat.PRIVATE_FARM);
                showToast(getString(R.string.private_farm));
                break;
            }
        }
        MainActivity.page_3.update();
        //MainActivity.page_4.update();
    }

    public void update(){
        int tmpRespectHorse = MainActivity.controller.getHorse().getRespectHorses();
        int tmpRespectPeople = MainActivity.controller.getHorse().getRespectPeoples();
        buttonTabor.setClickable(false);
        if (tmpRespectHorse  > Constants.wastelandRespect){
            buttonWasteland.setEnabled(true);
            if (tmpRespectHorse  > Constants.clearFieldRespect){
                buttonClearField.setEnabled(true);
                if (tmpRespectHorse  > Constants.meadowsRespect){
                    buttonMeadows.setEnabled(true);
                    if (tmpRespectHorse  > Constants.prairieRespect){
                        buttonPrairie.setEnabled(true);
                        if (tmpRespectHorse  > Constants.kazahstanRespect) {
                            buttonKazahstan.setEnabled(true);
                        } else buttonKazahstan.setEnabled(false);
                    } else{
                        buttonPrairie.setEnabled(false);
                        buttonKazahstan.setEnabled(false);
                    }
                } else {
                    buttonMeadows.setEnabled(false);
                    buttonPrairie.setEnabled(false);
                    buttonKazahstan.setEnabled(false);
                }
            } else {
                buttonClearField.setEnabled(false);
                buttonMeadows.setEnabled(false);
                buttonPrairie.setEnabled(false);
                buttonKazahstan.setEnabled(false);
            }
        } else {
            buttonWasteland.setEnabled(false);
            buttonClearField.setEnabled(false);
            buttonMeadows.setEnabled(false);
            buttonPrairie.setEnabled(false);
            buttonKazahstan.setEnabled(false);
        }
        if (tmpRespectPeople  > Constants.paddockRespect){
            buttonPaddock.setEnabled(true);
            if (tmpRespectPeople  > Constants.stableRespect){
                buttonStable.setEnabled(true);
                if (tmpRespectPeople  > Constants.ranchRespect){
                    buttonRanch.setEnabled(true);
                    if (tmpRespectPeople  > Constants.horseClubRespect) {
                        buttonHorseClub.setEnabled(true);
                        if (tmpRespectPeople  > Constants.privateFarmRespect) {
                            buttonPrivateFarm.setEnabled(true);
                        } else buttonPrivateFarm.setEnabled(false);
                    } else {
                        buttonHorseClub.setEnabled(false);
                        buttonPrivateFarm.setEnabled(false);
                    }
                } else {
                    buttonHorseClub.setEnabled(false);
                    buttonPrivateFarm.setEnabled(false);
                    buttonRanch.setEnabled(false);
                }
            } else {
                buttonStable.setEnabled(false);
                buttonHorseClub.setEnabled(false);
                buttonPrivateFarm.setEnabled(false);
                buttonRanch.setEnabled(false);
            }
        } else {
            buttonPaddock.setEnabled(false);
            buttonStable.setEnabled(false);
            buttonHorseClub.setEnabled(false);
            buttonPrivateFarm.setEnabled(false);
            buttonRanch.setEnabled(false);
        }
    }

    public String makeParamString(int id){
        StringBuilder sb = new StringBuilder();
        String tmpHorseRespect = getActivity().getString(R.string.respect_horses);
        String tmpPeopleREspect = getActivity().getString(R.string.respect_peoples);
        switch (id) {
            case R.id.text_stable: {
                sb.append(tmpPeopleREspect);
                sb.append(" >");
                sb.append(Constants.stableRespect);
                return sb.toString();
            }
            case R.id.text_paddock: {
                sb.append(tmpPeopleREspect);
                sb.append(" >");
                sb.append(Constants.paddockRespect);
                return sb.toString();
            }
            case R.id.text_ranch: {
                sb.append(tmpPeopleREspect);
                sb.append(" >");
                sb.append(Constants.ranchRespect);
                return sb.toString();
            }
            case R.id.text_horse_club: {
                sb.append(tmpPeopleREspect);
                sb.append(" >");
                sb.append(Constants.horseClubRespect);
                return sb.toString();
            }
            case R.id.text_private_farm: {
                sb.append(tmpPeopleREspect);
                sb.append(" >");
                sb.append(Constants.privateFarmRespect);
                return sb.toString();
            }
            case R.id.text_wasteland: {
                sb.append(tmpHorseRespect);
                sb.append(" >");
                sb.append(Constants.wastelandRespect);
                return sb.toString();
            }
            case R.id.text_clear_field: {
                sb.append(tmpHorseRespect);
                sb.append(" >");
                sb.append(Constants.clearFieldRespect);
                return sb.toString();
            }
            case R.id.text_meadows: {
                sb.append(tmpHorseRespect);
                sb.append(" >");
                sb.append(Constants.meadowsRespect);
                return sb.toString();
            }
            case R.id.text_prairie: {
                sb.append(tmpHorseRespect);
                sb.append(" >");
                sb.append(Constants.prairieRespect);
                return sb.toString();
            }
            case R.id.text_kazahstan: {
                sb.append(tmpHorseRespect);
                sb.append(" >");
                sb.append(Constants.kazahstanRespect);
                return sb.toString();
            }
            default: return null;
        }
    }

    public void showToast(String habitat) {
        StringBuilder sb = new StringBuilder();
        sb.append(getString(R.string.now_your_habitat));
        sb.append(" ");
        sb.append(habitat);
        Toast toast = Toast.makeText(getActivity().getApplicationContext(), sb.toString(), Toast.LENGTH_LONG);
        toast.show();
    }
}
