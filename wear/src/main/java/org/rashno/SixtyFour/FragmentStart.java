package org.rashno.SixtyFour;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.wearable.view.WatchViewStub;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import org.rashno.SixtyFour.classes.Declaration;
import org.rashno.SixtyFour.classes.GlobalParams;

/**
 * Created by Hossein on 10/27/2016.
 * In this fragment player should press start to start the game
 */

public class FragmentStart extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_start, container, false);
        ImageButton imgBtnPlay = (ImageButton)rootView.findViewById(R.id.imgBtnPlay);
        imgBtnPlay.setOnClickListener(imgBtnPlayListener);

        return rootView;
    }

    View.OnClickListener imgBtnPlayListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            GlobalParams.isGameStartFlag = true;
            ViewPager mPager = (ViewPager) getActivity().findViewById(R.id.pager);
            mPager.setCurrentItem(Declaration.enmPages.Game.getValue());
        }
    };
}
