package blue_caps.horsesimulator;

import android.support.v4.app.Fragment;

/**
 * Created by alex on 31.10.16.
 */

public class StepFragment extends Fragment {
    protected void step() {
        MainActivity.controller.wasStep();
        MainActivity.updateStats();
        if (MainActivity.controller.getHorse().getSatiety() == 0 ||
                MainActivity.controller.getHorse().getStamina() == 0 ||
                MainActivity.controller.getHorse().getHappiness() == 0) {
            if (MainActivity.controller.getDieTime() == 4)
                MainActivity.showDieAlert(getActivity());
            MainActivity.controller.downDieTime();
        }
        if (MainActivity.controller.getDieTime() == 0)
            MainActivity.showDieDialog(getActivity());
    }
}
