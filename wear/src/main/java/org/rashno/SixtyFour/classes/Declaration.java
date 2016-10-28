package org.rashno.SixtyFour.classes;

/**
 * Created by Hossein on 10/27/2016.
 * This class should use for all declarations like enmus
 */

public class Declaration {
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
