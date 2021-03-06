package com.but42.criminalintent.database;

import android.database.Cursor;
import android.database.CursorWrapper;
import com.but42.criminalintent.Crime;
import com.but42.criminalintent.database.CrimeDbSchema.CrimeTable;

import java.util.Date;
import java.util.UUID;

/**
 * Created by but on 05.11.2016.
 */
public class CrimeCursorWrapper extends CursorWrapper {
    public CrimeCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Crime getCrime() {
        String uuidString = getString(getColumnIndex(CrimeTable.Cols.UUID));
        String title = getString(getColumnIndex(CrimeTable.Cols.TITLE));
        long date = getLong(getColumnIndex(CrimeTable.Cols.DATE));
        int isSolved = getInt(getColumnIndex(CrimeTable.Cols.SOLVED));
        String suspectName = getString(getColumnIndex(CrimeTable.Cols.SUSPECT_NAME));
        String suspectNumber = getString(getColumnIndex(CrimeTable.Cols.SUSPECT_NUMBER));

        Crime crime = new Crime(UUID.fromString(uuidString));
        crime.setTitle(title);
        crime.setDate(new Date(date));
        crime.setSolved(isSolved != 0);
        crime.setSuspectName(suspectName);
        crime.setSuspectNumber(suspectNumber);

        return crime;
    }
}
