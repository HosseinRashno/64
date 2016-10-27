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

    public String GetName(Declaration.enmGender gender, int nameLenght)
    {
        String nameRet = null;

        SQLiteDatabase db = ConnectionWritable(_context);
        String query = "";
        query += "SELECT name FROM IranianName where ";
        query += gender==null?"":("gender="+gender.getValue()+" and ");
        query += " Length(name) = "+ nameLenght;

        Cursor c = db.rawQuery(query, null);
        if (c.getCount() > 0) {
            int rndRowNumber = new Random().nextInt(c.getCount());
            if (c.moveToPosition(rndRowNumber)) {
                nameRet = c.getString(c.getColumnIndex("name"));
            }
            c.close();
            db.close();
        }
        return nameRet;
    }
}
