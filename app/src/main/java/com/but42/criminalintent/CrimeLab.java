package com.but42.criminalintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by mikhail on 17/10/16.
 */
public class CrimeLab {
    private List<Crime> mCrimes;

    private static CrimeLab sCrimeLab;
    private Context mAppContext;

    public static CrimeLab get(Context c) {
        if (sCrimeLab == null) {
            sCrimeLab = new CrimeLab(c.getApplicationContext());
        }
        return sCrimeLab;
    }

    private CrimeLab(Context appContext) {
        this.mAppContext = appContext;
        mCrimes = new ArrayList<>();
    }

    public List<Crime> getCrimes() {
        return mCrimes;
    }

    public Crime getCrime(UUID id) {
        for (Crime c : mCrimes) {
            if (c.getId().equals(id))
                return c;
        }
        return null;
    }

    public void addCrime(Crime c) {
        mCrimes.add(c);
    }

    public void deleteCrime(Crime crime) {
        mCrimes.remove(crime);
    }
}
