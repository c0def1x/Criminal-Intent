package com.bignerdranch.android.criminalintent2

import android.app.Application

class CriminalIntentApplication : Application()
{
    override fun onCreate()
    {
        super.onCreate()
        CrimeRepository.initialize(this)
    }
}