package dev.faddy.vyt1.utils

import android.view.View
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import com.google.android.material.datepicker.MaterialDatePicker
import dev.faddy.vyt1.R
import java.text.SimpleDateFormat
import java.util.*

class DatePickerFactory {
    var selectedDate = ""
    var selectedDateFormatted = ""
    private val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.US)
    private val sdf1 = SimpleDateFormat("dd MMM, yyyy", Locale.US)

    fun showDatePicker(
        childFragmentManager: FragmentManager, editText: View
    ) {
        val builder = MaterialDatePicker.Builder.datePicker()
        builder.setTheme(R.style.CustomMaterialCalendarTheme)
        builder.setTitleText("Select your Date")
        val picker = builder.build()
        picker.show(childFragmentManager, "Picker")
        picker.addOnPositiveButtonClickListener {
            setDateToTextView(
                selectedD = it, editText = editText
            )
        }
    }

    private fun setDateToTextView(
        selectedD: Long = 0, fromInit: Boolean = false, serverDate: String = "", editText: View
    ) {
        if (fromInit) {
            selectedDate = DigitConverter.formatDate(serverDate, "yyyy-MM-dd", "yyyy-MM-dd")
            selectedDateFormatted =
                DigitConverter.formatDate(serverDate, "yyyy-MM-dd", "dd MMM yyyy")
            (editText as TextView).setText(selectedDateFormatted)
        } else {
            selectedDate = sdf.format(selectedD)
            selectedDateFormatted = sdf1.format(selectedD)
            (editText as TextView).setText(selectedDateFormatted)
        }
    }
}