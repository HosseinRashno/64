package org.rashno.SixtyFour;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.wearable.view.WatchViewStub;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.rashno.SixtyFour.classes.Declaration;
import org.rashno.SixtyFour.classes.Factories.IranianNameFactory;
import org.rashno.SixtyFour.classes.Factories.IranianNameSchema;
import org.rashno.SixtyFour.classes.GlobalParams;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

/**
 * Created by Hossein on 10/27/2016.
 * In this fragment we will create our game
 */

public class FragmentGame extends Fragment {
    boolean isGameRunning;
    TableLayout tlGame;
    TextView txtCounter;
    TextView txtName;
    ImageButton imgBtnWord01;
    ImageButton imgBtnWord02;
    ImageButton imgBtnWord03;
    ImageButton imgBtnWord04;
    ImageButton imgBtnWord05;
    ImageButton imgBtnWord06;
    ImageButton imgBtnWord07;
    ImageButton imgBtnWord08;
    ImageButton imgBtnWord09;
    ArrayList<ImageButton> imgBtnWord;

    int positionOfCharInWord;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_game, container, false);

        // TODO : clean up layout

        imgBtnWord = new ArrayList<>();

        tlGame = (TableLayout)rootView.findViewById(R.id.tlGame);
        txtCounter = (TextView)rootView.findViewById(R.id.txtCounter);
        txtName = (TextView)rootView.findViewById(R.id.txtName);
        imgBtnWord.add((ImageButton)rootView.findViewById(R.id.imgBtnWord01));
        imgBtnWord.add((ImageButton)rootView.findViewById(R.id.imgBtnWord02));
        imgBtnWord.add((ImageButton)rootView.findViewById(R.id.imgBtnWord03));
        imgBtnWord.add((ImageButton)rootView.findViewById(R.id.imgBtnWord04));
        imgBtnWord.add((ImageButton)rootView.findViewById(R.id.imgBtnWord05));
        imgBtnWord.add((ImageButton)rootView.findViewById(R.id.imgBtnWord06));
        imgBtnWord.add((ImageButton)rootView.findViewById(R.id.imgBtnWord07));
        imgBtnWord.add((ImageButton)rootView.findViewById(R.id.imgBtnWord08));
        imgBtnWord.add((ImageButton)rootView.findViewById(R.id.imgBtnWord09));

        imgBtnWord.get(0).setOnClickListener(imgBtnClick);
        imgBtnWord.get(1).setOnClickListener(imgBtnClick);
        imgBtnWord.get(2).setOnClickListener(imgBtnClick);
        imgBtnWord.get(3).setOnClickListener(imgBtnClick);
        imgBtnWord.get(4).setOnClickListener(imgBtnClick);
        imgBtnWord.get(5).setOnClickListener(imgBtnClick);
        imgBtnWord.get(6).setOnClickListener(imgBtnClick);
        imgBtnWord.get(7).setOnClickListener(imgBtnClick);
        imgBtnWord.get(8).setOnClickListener(imgBtnClick);

        Typeface typeFaceVazir = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Vazir.ttf");
        txtName.setTypeface(typeFaceVazir);
        txtCounter.setTypeface(typeFaceVazir);

        return rootView;
    }

    CountDownTimer cdTimer = new CountDownTimer(15000, 1000) {

        public void onTick(long millisUntilFinished) {
            String timeRemain = String.valueOf(millisUntilFinished / 1000);
            timeRemain = timeRemain.length()==1?("0"+timeRemain):timeRemain;
            txtCounter.setText(timeRemain);
        }

        public void onFinish() {
            isGameRunning = false;
            txtCounter.setText(R.string.TimesUp);
            ViewPager mPager = (ViewPager) getActivity().findViewById(R.id.pager);
            mPager.setEnabled(true);
            mPager.setCurrentItem(Declaration.enmPages.Score.getValue());
        }
    };

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser && GlobalParams.isGameStartFlag) {
            isGameRunning = true;
            GlobalParams.isGameStartFlag = false;
            GlobalParams.correctWordsCount = 0;
            GlobalParams.wrongWordsCount = 0;

            ResetControls();
            ShowNewWord();

            cdTimer.start();
        }

        if (isGameRunning == false)
        {
            ResetControls();
        }
    }

    View.OnClickListener imgBtnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (isGameRunning) {
                String charSelected = (String) view.getTag();
                String word = txtName.getText().toString();
                if (charSelected.charAt(0) == word.charAt(positionOfCharInWord)) {
                    // It is ok
                    if (word.length() == (positionOfCharInWord+1)) {
                        ImageButton imgBtn = (ImageButton)view.findViewById(view.getId());
                        imgBtn.setColorFilter( getResources().getColor(R.color.cstmGreenSuccess), PorterDuff.Mode.MULTIPLY );
                        tlGame.setBackgroundColor(getResources().getColor(R.color.cstmGreenSuccess));
                        tlGame.animate().setDuration(250).withEndAction(new Runnable() {
                            @Override
                            public void run() {
                                for (ImageButton img:imgBtnWord) {
                                    img.setColorFilter(null);
                                }
                                tlGame.setBackgroundColor(Color.WHITE);
                                GlobalParams.correctWordsCount++;
                                ShowNewWord();
                            }
                        }).start();
                    }
                    else {
                        ImageButton imgBtn = (ImageButton)view.findViewById(view.getId());
                        imgBtn.setColorFilter( getResources().getColor(R.color.cstmGreenSuccess), PorterDuff.Mode.MULTIPLY );
                        positionOfCharInWord++;
                    }

                } else {
                    // It is wrong
                    for (ImageButton img:imgBtnWord) {
                        img.setColorFilter(null);
                    }
                    positionOfCharInWord = 0;
                    tlGame.setBackgroundColor(getResources().getColor(R.color.cstmRedFaild));
                    tlGame.animate().setDuration(250).withEndAction(new Runnable() {
                        @Override
                        public void run() {
                            tlGame.setBackgroundColor(Color.WHITE);
                            GlobalParams.wrongWordsCount++;
                            ShowNewWord();
                        }
                    }).start();
                }
            }
        }
    };

    private void ShowNewWord()
    {
        // Get a random name
        IranianNameFactory inFactory = new IranianNameFactory(getActivity().getApplicationContext());
        IranianNameSchema row = inFactory.GetName(3, 9);
        txtName.setText(row.Name);

        // Reset the position of selected char
        positionOfCharInWord = 0;

        // Change the color of name text
        if(row.Gender == Declaration.enmGender.Girl)
        {
            txtName.setTextColor(getResources().getColor(R.color.cstmGirlPink));
        }
        else
        {
            txtName.setTextColor(getResources().getColor(R.color.cstmBoyBlue));
        }

        // Set the buttons with the name character
        ArrayList<ImageButton> imgBtnTemp = (ArrayList<ImageButton>) imgBtnWord.clone();
        ArrayList<String> wordsKeyTemp = (ArrayList<String>) Declaration.alphabetkeys.clone();
        for (char c: row.Name.toCharArray()) {
            if (wordsKeyTemp.contains(String.valueOf(c))) {
                int wordIndex = wordsKeyTemp.indexOf(String.valueOf(c));
                wordsKeyTemp.remove(wordIndex);
            }

            int rndIndex = new Random().nextInt(imgBtnTemp.size());
            int res = (int)Declaration.wordImageMap.get(String.valueOf(c));
            imgBtnTemp.get(rndIndex).setImageResource(res);
            imgBtnTemp.get(rndIndex).setTag(String.valueOf(c));
            imgBtnTemp.remove(rndIndex);
        }

        // Fill other buttons with random characters
        for (ImageButton img:imgBtnTemp) {
            int rndIndex = new Random().nextInt(wordsKeyTemp.size());
            int wordIndex = (int)Declaration.wordImageMap.get(wordsKeyTemp.get(rndIndex));
            img.setImageResource(wordIndex);
            img.setTag(wordsKeyTemp.get(rndIndex));
        }
    }


    private void ResetControls()
    {
        // Reset tint color on the buttons
        if(imgBtnWord!=null && txtName!=null && txtCounter!=null) {
            for (ImageButton img : imgBtnWord) {
                img.setColorFilter(null);
                img.setImageResource(R.drawable.ic_word_default);
            }

            // Reset texts colors
            txtName.setTextColor(getResources().getColor(R.color.cstmGreen));
            txtCounter.setTextColor(getResources().getColor(R.color.cstmRed));

            // Reset texts values
            txtName.setText(getResources().getString(R.string.defaultGameWord));
            txtCounter.setText(getResources().getString(R.string.defaultCounter));
        }
    }
}
