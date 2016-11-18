package org.rashno.SixtyFour;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.wearable.view.WatchViewStub;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.rashno.SixtyFour.classes.GlobalParams;

/**
 * Created by Hossein on 10/27/2016.
 * This fragment will show the score after game finished
 */

public class FragmentScore extends Fragment {
    TextView txtCorrectWorkCount;
    TextView txtWrongWordCount;
    TextView txtSuccessPercent;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_score, container, false);

        txtCorrectWorkCount = (TextView)rootView.findViewById(R.id.txtCorrectWorkCount);
        txtWrongWordCount = (TextView)rootView.findViewById(R.id.txtWrongWordCount);
        txtSuccessPercent = (TextView)rootView.findViewById(R.id.txtSuccessPercent);

        Typeface typeFaceVazir = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Vazir.ttf");

        txtCorrectWorkCount.setTypeface(typeFaceVazir);
        txtWrongWordCount.setTypeface(typeFaceVazir);
        txtSuccessPercent.setTypeface(typeFaceVazir);



        return rootView;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser && txtCorrectWorkCount!=null && txtWrongWordCount!=null && txtSuccessPercent!=null) {
            double PerfectSuccessWordCount = 35;
            int percentOfSuccess = 100;

            txtCorrectWorkCount.setText(String.valueOf(GlobalParams.correctWordsCount));
            txtWrongWordCount.setText(String.valueOf(GlobalParams.wrongWordsCount));

            long successLong = GlobalParams.correctWordsCount;
            long wrongLong = GlobalParams.wrongWordsCount;

            if (GlobalParams.correctWordsCount != 0){
                percentOfSuccess = (int)(successLong*100/PerfectSuccessWordCount);
                percentOfSuccess -= (wrongLong*100*(1/PerfectSuccessWordCount));
                percentOfSuccess = percentOfSuccess<0?0:percentOfSuccess;
            } else {
                percentOfSuccess = 0;
            }

            txtSuccessPercent.setText(getString(R.string.percenOfSuccess, percentOfSuccess));
        }
    }
}
