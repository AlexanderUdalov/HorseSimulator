package blue_caps.horsesimulator;

import android.support.v4.app.Fragment;

/**
 * Created by alex on 31.10.16.
 */

public class StepFragment extends Fragment {
    protected void step() {
        MainActivity.controller.wasStep();
        MainActivity.updateStats();
    }
}
