package org.rashno.SixtyFour;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


/**
 * Created by Hossein on 10/27/2016.
 * Here is the adapter pager for the 3 page we need
 */

class ActivitiesPagerAdapter extends FragmentStatePagerAdapter {

    ActivitiesPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0: // Start
                return new FragmentStart();
            case 1: // Game
                return new FragmentGame();
            case 2: // Score
                return new FragmentScore();
            default:
                return new FragmentStart();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}