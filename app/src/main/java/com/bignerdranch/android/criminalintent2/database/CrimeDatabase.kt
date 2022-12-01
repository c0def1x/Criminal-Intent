package com.bignerdranch.android.criminalintent2.database

import androidx.room.*
import androidx.room.RoomDatabase
import com.bignerdranch.android.criminalintent2.Crime

@Database(entities = [ Crime::class ], version=1, exportSchema = false)
@TypeConverters(CrimeTypeConverters::class)
abstract class CrimeDatabase : RoomDatabase()
{
    abstract fun crimeDao(): CrimeDao
}