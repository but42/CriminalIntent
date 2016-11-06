package com.but42.criminalintent;

import java.util.Date;
import java.util.UUID;

/**
 * Created by mikhail on 17/10/16.
 */
public class Crime {
    private UUID mId;
    private String mTitle;
    private Date mDate;
    private boolean mSolved;
    private String mSuspectName;
    private String mSuspectNumber;

    public Crime() {
        this(UUID.randomUUID());
    }

    public Crime(UUID id) {
        mId = id;
        mDate = new Date();
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }

    public String getSuspectName() {
        return mSuspectName;
    }

    public void setSuspectName(String suspectName) {
        mSuspectName = suspectName;
    }

    public void setSuspectNumber(String suspectNumber) {
        mSuspectNumber = suspectNumber;
    }

    public String getSuspectNumber() {
        return mSuspectNumber;
    }

    @Override
    public String toString() {
        return mTitle;
    }

    private class Suspect {
        private String name;
        private String id;


    }
}
