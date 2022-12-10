package dev.faddy.vyt1.fragments.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import dev.faddy.vyt1.databinding.FragmentPartyDetailsBinding


class PartyDetailsFragment : Fragment() {

    private lateinit var binding: FragmentPartyDetailsBinding
    private lateinit var dataAdapter: PartyDetailsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        return FragmentPartyDetailsBinding.inflate(layoutInflater).also { binding = it }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
        initView()
        initClickListener()
    }

    private fun initData() {
        dataAdapter = PartyDetailsAdapter()
    }

    private fun initClickListener() {
        binding.backButton.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun initView() {
        with(binding.partyDetailsRecyclerView) {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(
                requireContext(), androidx.recyclerview.widget.LinearLayoutManager.VERTICAL, false
            )
            adapter = dataAdapter
        }
        dataAdapter.intiData(
            mutableListOf(
                "Cus1",
                "Cus1",
                "Cus1",
                "Cus1",
                "Cus1",
                "Cus1",
                "Cus1",
                "Cus1",
                "Cus1",
                "Cus1",
                "Cus1",
                "Cus1",
                "Cus1",
                "Cus1",
                "Cus1",
                "Cus1",
                "Cus1",
                "Cus1",
                "Cus1",
                "Cus1",
                "Cus1",
                "Cus1",
                "Cus1",
                "Cus1"
            )
        )
    }
}