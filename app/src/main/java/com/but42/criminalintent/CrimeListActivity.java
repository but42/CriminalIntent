package com.but42.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by mikhail on 17/10/16.
 */
public class CrimeListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
