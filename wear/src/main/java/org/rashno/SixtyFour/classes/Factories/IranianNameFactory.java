package org.rashno.SixtyFour.classes.Factories;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import org.rashno.SixtyFour.classes.Declaration;

import java.util.Random;

import static org.rashno.SixtyFour.classes.General.ConnectionWritable;

/**
 * Created by Hossein on 10/27/2016.
 * This is factory class for IranianName table, All database connection for this table should be handle through this class
 */

public class IranianNameFactory {
    private Context _context;

    public IranianNameFactory(Context context)
    {
        _context = context;
    }

    public IranianNameSchema GetName(int nameLenghtMin, int nameLenghtMax)
    {
        IranianNameSchema ret = new IranianNameSchema();

        SQLiteDatabase db = ConnectionWritable(_context);
        String query = "";
        query += "SELECT _id, name, gender FROM IranianName where ";
        query += " Length(name) >= "+ nameLenghtMin;
        query += " and Length(name) <= "+ nameLenghtMax;

        Cursor c = db.rawQuery(query, null);
        if (c.getCount() > 0) {
            int rndRowNumber = new Random().nextInt(c.getCount());
            if (c.moveToPosition(rndRowNumber)) {
                ret._id = c.getInt(c.getColumnIndex("_id"));
                ret.Name = c.getString(c.getColumnIndex("name"));
                ret.Gender = Declaration.enmGender.values()[c.getInt(c.getColumnIndex("gender"))];
            }
            c.close();
            db.close();
        }
        return ret;
    }
}
