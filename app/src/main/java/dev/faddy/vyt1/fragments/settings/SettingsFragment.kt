package dev.faddy.vyt1.fragments.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import dev.faddy.vyt1.R
import dev.faddy.vyt1.databinding.FragmentSettingsBinding


class SettingsFragment : Fragment() {
    private lateinit var binding: FragmentSettingsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        return FragmentSettingsBinding.inflate(layoutInflater).also { binding = it }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initClickListener()
    }

    private fun initView() {

    }

    private fun initClickListener() {
        binding.generalLayout.setOnClickListener { }
        binding.transactionLayout.setOnClickListener { }
        binding.invoiceLayout.setOnClickListener { }
        binding.taxesLayout.setOnClickListener { }
        binding.userManagementLayout.setOnClickListener { }
        binding.paymentRemainderLayout.setOnClickListener { }
        binding.partyLayout.setOnClickListener {
            findNavController().navigate(R.id.action_settingsFragment_to_partiesSettingsFragment)
        }
        binding.itemLayout.setOnClickListener { }

    }
}