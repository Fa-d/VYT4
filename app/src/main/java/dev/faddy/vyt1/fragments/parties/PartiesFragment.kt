package dev.faddy.vyt1.fragments.parties

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import dev.faddy.vyt1.databinding.FragmentPartiesBinding

class PartiesFragment : Fragment() {

    private val partiesAdapter = PartiesDashboardAdapter()

    private lateinit var binding: FragmentPartiesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        return FragmentPartiesBinding.inflate(layoutInflater).also {
            binding = it
        }.root
    }

    companion object {

        fun newInstance(param1: String, param2: String) = PartiesFragment().apply {}
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initData()
    }

    private fun initData() {
        partiesAdapter.intiData(
            mutableListOf(
                "sdifkmsdf", "gfhfg", "dghg", "etyer", "cxvc", "etyry"
            )
        )
    }

    private fun initView() {
        with(binding.partiesRecycler) {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(
                requireContext(), androidx.recyclerview.widget.LinearLayoutManager.VERTICAL, false
            )
            adapter = partiesAdapter
        }
    }
}