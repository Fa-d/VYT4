package dev.faddy.vyt1.utils

import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*

object DigitConverter {

    val banglaMonth = arrayOf(
        "জানুয়ারী",
        "ফেব্রুয়ারী",
        "মার্চ",
        "এপ্রিল",
        "মে",
        "জুন",
        "জুলাই",
        "আগস্ট",
        "সেপ্টেম্বর",
        "অক্টোবর",
        "নভেম্বর",
        "ডিসেম্বর"
    )
    private var decimalFormat: DecimalFormat? = null

    init {
        decimalFormat = DecimalFormat("#,##,##0")
        //decimalFormat?.isGroupingUsed = true
        //decimalFormat?.groupingSize = 3
    }

    fun toBanglaDigit(digits: Any?, isComma: Boolean = false): String {

        if (digits is String) {
            return engCahrReplacer(digits)
        } else if (digits is Int) {
            return if (isComma) {
                engCahrReplacer(formatNumber(digits))
            } else {
                engCahrReplacer(digits.toString())
            }
        } else if (digits is Double) return if (isComma) {
            engCahrReplacer(formatNumber(digits))
        } else {
            engCahrReplacer(digits.toString())
        }
        else {
            return (digits as? String).toString()
        }

    }

    private fun engCahrReplacer(string: String): String {
        return string.replace('0', '০').replace('1', '১').replace('2', '২').replace('3', '৩')
            .replace('4', '৪').replace('5', '৫').replace('6', '৬').replace('7', '৭')
            .replace('8', '৮').replace('9', '৯')
    }

    private fun formatNumber(digits: Any): String {

        return decimalFormat?.format(digits) ?: digits.toString()
    }

    fun formatDate(inputDate: String?, patternInput: String, patternOutput: String): String {
        if (inputDate == null) return ""
        try {
            val sdf1 = SimpleDateFormat(patternInput, Locale.US)
            val sdf2 = SimpleDateFormat(patternOutput, Locale.US)
            val date = sdf1.parse(inputDate)
            if (date != null) {
                return sdf2.format(date)
            }
            return inputDate
        } catch (e: Exception) {
            e.printStackTrace()
            return inputDate
        }
    }

}