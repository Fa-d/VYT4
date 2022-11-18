package dev.faddy.vyt1.fragments.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import dev.faddy.vyt1.databinding.FragmentPartyAddtionalFieldsBinding


class PartyAddtionalFieldsFragment : Fragment() {
    private var isAf1Visible = false
    private var isAf2Visible = false
    private var isAf3Visible = false
    private var isAf4Visible = false

    private lateinit var binding: FragmentPartyAddtionalFieldsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        return FragmentPartyAddtionalFieldsBinding.inflate(layoutInflater)
            .also { binding = it }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initClickLister()
    }

    private fun initClickLister() {
        binding.adf1.setOnCheckedChangeListener { compoundButton, b ->
            binding.adf1Layout.isVisible = b
            isAf1Visible = b
        }
        binding.adf2.setOnCheckedChangeListener { compoundButton, b ->
            binding.adf2Layout.isVisible = b
            isAf2Visible = b
        }
        binding.adf3.setOnCheckedChangeListener { compoundButton, b ->
            binding.adf3Layout.isVisible = b
            isAf3Visible = b
        }
        binding.adf4.setOnCheckedChangeListener { compoundButton, b ->
            binding.adf4Layout.isVisible = b
            isAf4Visible = b
        }

    }

    private fun initView() {

    }
}