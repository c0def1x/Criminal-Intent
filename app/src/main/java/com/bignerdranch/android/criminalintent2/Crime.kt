package com.bignerdranch.android.criminalintent2

import androidx.room.*
import java.util.*

@Entity
data class Crime(@PrimaryKey val id: UUID = UUID.randomUUID(),
                 var title: String = "",
                 var date: Date = Date(),
                 var isSolved: Boolean = false,
                 var requiresPolice: Boolean = false)
{

}