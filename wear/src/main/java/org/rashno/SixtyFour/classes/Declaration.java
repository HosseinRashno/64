package org.rashno.SixtyFour.classes;

import org.rashno.SixtyFour.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by Hossein on 10/27/2016.
 * This class should use for all declarations like enmus
 */

public class Declaration {
    public static ArrayList<String> alphabetkeys = new ArrayList<>(
            Arrays.asList(
                    "ا",
                    "ب",
                    "پ",
                    "ت",
                    "ث",
                    "ج",
                    "چ",
                    "ح",
                    "خ",
                    "د",
                    "ذ",
                    "ر",
                    "ز",
                    "ژ",
                    "س",
                    "ش",
                    "ص",
                    "ض",
                    "ط",
                    "ظ",
                    "ع",
                    "غ",
                    "ف",
                    "ق",
                    "ک",
                    "گ",
                    "ل",
                    "م",
                    "ن",
                    "و",
                    "ه",
                    "ی"
            )
    );
    public static HashMap wordImageMap = new HashMap<String, Integer>() {
        {
            put("ا", R.drawable.ic_word_alef);
            put("ب", R.drawable.ic_word_be);
            put("پ", R.drawable.ic_word_pe);
            put("ت", R.drawable.ic_word_te);
            put("ث", R.drawable.ic_word_se);
            put("ج", R.drawable.ic_word_jim);
            put("چ", R.drawable.ic_word_che);
            put("ح", R.drawable.ic_word_he);
            put("خ", R.drawable.ic_word_khe);
            put("د", R.drawable.ic_word_dal);
            put("ذ", R.drawable.ic_word_zal);
            put("ر", R.drawable.ic_word_re);
            put("ز", R.drawable.ic_word_ze);
            put("ژ", R.drawable.ic_word_zhe);
            put("س", R.drawable.ic_word_sin);
            put("ش", R.drawable.ic_word_shin);
            put("ص", R.drawable.ic_word_sad);
            put("ض", R.drawable.ic_word_zad);
            put("ط", R.drawable.ic_word_ta);
            put("ظ", R.drawable.ic_word_za);
            put("ع", R.drawable.ic_word_ein);
            put("غ", R.drawable.ic_word_ghein);
            put("ف", R.drawable.ic_word_fe);
            put("ق", R.drawable.ic_word_ghaf);
            put("ک", R.drawable.ic_word_kaf);
            put("گ", R.drawable.ic_word_gaf);
            put("ل", R.drawable.ic_word_lam);
            put("م", R.drawable.ic_word_mim);
            put("ن", R.drawable.ic_word_noon);
            put("و", R.drawable.ic_word_vav);
            put("ه", R.drawable.ic_word_he_gerd);
            put("ی", R.drawable.ic_word_ye);
        }
    };
    public enum enmGender
    {
        Boy(0, "پسر"),
        Girl(1, "دختر");

        private int Value;
        private String name;
        enmGender(int value, String name)
        {
            this.Value = value;
            this.name = name;
        }

        public int getValue()
        {
            return this.Value;
        }
        public String toString() {
            return this.name;
        }
    }

    public enum enmPages
    {
        Start(0, "شروع"),
        Game(1, "بازی"),
        Score(2, "نتیجه");

        private int Value;
        private String name;
        enmPages(int value, String name)
        {
            this.Value = value;
            this.name = name;
        }

        public int getValue()
        {
            return this.Value;
        }
        public String toString() {
            return this.name;
        }
    }
}
