package dev.faddy.vyt1.fragments.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import dev.faddy.vyt1.R
import dev.faddy.vyt1.databinding.FragmentPartiesSettingsBinding


class PartiesSettingsFragment : Fragment() {

    private lateinit var binding: FragmentPartiesSettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        return FragmentPartiesSettingsBinding.inflate(layoutInflater).also { binding = it }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        intiClickListerner()
    }

    private fun initView() {

    }

    private fun intiClickListerner() {
        binding.partyAddtionalFieldsLayout.setOnClickListener {
            findNavController().navigate(R.id.action_partiesSettingsFragment_to_partyAddtionalFieldsFragment)
        }

    }
}