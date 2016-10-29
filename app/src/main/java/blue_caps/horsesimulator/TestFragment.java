package blue_caps.horsesimulator;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;;import java.util.Random;

/**
 * Created by alexu on 28.10.2016.
 */

public class TestFragment extends Fragment {
    int pageNumber;
    int backColor;

    static TestFragment newInstance(){
        TestFragment pageFragment = new TestFragment();
        return pageFragment;
        }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageNumber = 1;
        Random rnd = new Random();
        backColor = Color.argb(40, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.test_fragment, null);
        TextView tvPage = (TextView) view.findViewById(R.id.tvPage);
        tvPage.setText("Page " + pageNumber);
        tvPage.setBackgroundColor(backColor);

        return view;
        }
}
