package dev.faddy.vyt1.fragments.payment_in

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import dev.faddy.vyt1.databinding.FragmentPaymentInBinding
import dev.faddy.vyt1.fragments.payment_in.bottomsheets.PaymentInBottomSheet
import dev.faddy.vyt1.fragments.payment_in.bottomsheets.ShareBottomSheet
import dev.faddy.vyt1.utils.DatePickerFactory

class PaymentInFragment : Fragment() {

    private lateinit var binding: FragmentPaymentInBinding
    private lateinit var selectedDate: DatePickerFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        return FragmentPaymentInBinding.inflate(layoutInflater).also { binding = it }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        intiView()
        initData()
        initClickListener()
    }

    private fun initClickListener() {
        binding.recietNoFromRecylcerTitle.setOnClickListener {
            PaymentInBottomSheet().show(childFragmentManager, "PaymentInBottomSheet")
        }
        binding.recietNoSelectedFromRecylcerTitle.setOnClickListener {
            PaymentInBottomSheet().show(childFragmentManager, "PaymentInBottomSheet")
        }
        binding.recietNoSelectedFromRecylcerCount.setOnClickListener {
            PaymentInBottomSheet().show(childFragmentManager, "PaymentInBottomSheet")
        }
        binding.backButton.setOnClickListener { findNavController().popBackStack() }

        binding.dateTitleTV.setOnClickListener {
            selectedDate.showDatePicker(childFragmentManager, binding.dateValue)
        }
        binding.dateValue.setOnClickListener {
            selectedDate.showDatePicker(childFragmentManager, binding.dateValue)
        }
        binding.buttonShare.setOnClickListener {
            ShareBottomSheet().show(childFragmentManager, "ShareBottomSheet")
        }
    }

    private fun initData() {}

    private fun intiView() {
        selectedDate = DatePickerFactory()
    }
}