package com.bignerdranch.android.criminalintent2

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment

private const val ARG_DATE = "date"

class DatePickerFragment : DialogFragment()
{
    interface Callbacks
    {
        fun onDateSelected(date: java.util.Date)
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog
    {
        val calendar = java.util.Calendar.getInstance()
        val hour = calendar.get(java.util.Calendar.HOUR_OF_DAY)
        val min = calendar.get(java.util.Calendar.MINUTE)
        val dateListener = DatePickerDialog.OnDateSetListener {
                    _: DatePicker, year: Int,
                    month: Int, day: Int ->
                val resultDate : java.util.Date =
                    java.util.GregorianCalendar(year, month, day, hour, min).time
                targetFragment?.let { fragment ->
                    (fragment as Callbacks).onDateSelected(resultDate)
                }
            }

        val date = arguments?.getSerializable(ARG_DATE) as java.util.Date
        calendar.time = date
        val initialYear = calendar.get(java.util.Calendar.YEAR)
        val initialMonth = calendar.get(java.util.Calendar.MONTH)
        val initialDay = calendar.get(java.util.Calendar.DAY_OF_MONTH)
        return DatePickerDialog(
            requireContext(),
            dateListener,
            initialYear,
            initialMonth,
            initialDay
        )
    }

    companion object
    {
        fun newInstance(date: java.util.Date): DatePickerFragment
        {
            val args = Bundle().apply {
                putSerializable(ARG_DATE, date)
            }
            return DatePickerFragment().apply {
                arguments = args
            }
        }
    }
}
