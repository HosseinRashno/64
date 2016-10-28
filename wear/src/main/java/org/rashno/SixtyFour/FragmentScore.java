package org.rashno.SixtyFour;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.wearable.view.WatchViewStub;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Hossein on 10/27/2016.
 * This fragment will show the score after game finished
 */

public class FragmentScore extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_score, container, false);

        TextView txtCorrectWorkCount = (TextView)rootView.findViewById(R.id.txtCorrectWorkCount);
        TextView txtWrongWordCount = (TextView)rootView.findViewById(R.id.txtWrongWordCount);
        TextView txtSuccessPercent = (TextView)rootView.findViewById(R.id.txtSuccessPercent);

        Typeface typeFaceVazir = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Vazir.ttf");

        txtCorrectWorkCount.setTypeface(typeFaceVazir);
        txtWrongWordCount.setTypeface(typeFaceVazir);
        txtSuccessPercent.setTypeface(typeFaceVazir);



        return rootView;
    }
}
