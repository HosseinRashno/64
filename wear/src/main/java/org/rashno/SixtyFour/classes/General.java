package org.rashno.SixtyFour.classes;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.io.IOException;

/**
 * Created by Hossein on 10/27/2016.
 * This class will handle the connection to the database
 */

public class General {
    private static DataBaseHelper MakeConnection(Context context){
        DataBaseHelper myDbHelper = new DataBaseHelper(context);
        try {
            myDbHelper.createDataBase();
        }
        catch (IOException ioe) {
            throw new Error("Unable to create database");
        }

        myDbHelper.openDataBase();
        return myDbHelper;
    }


    public static SQLiteDatabase ConnectionWritable(Context context){
        DataBaseHelper myDbHelper = MakeConnection(context);
        return myDbHelper.getWritableDatabase();
    }
}
