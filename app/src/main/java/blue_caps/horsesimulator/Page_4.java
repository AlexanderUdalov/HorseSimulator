package blue_caps.horsesimulator;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by alexu on 30.10.2016.
 */

public class Page_4 extends Fragment {
    public final static String TITLE = "Pisos_4";
    int backColor;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Random rnd = new Random();
        backColor = Color.argb(40, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.page_4, null);
        TextView tvPage = (TextView) view.findViewById(R.id.tvPage);
        tvPage.setText(TITLE);
        tvPage.setBackgroundColor(backColor);

        return view;
    }
}
