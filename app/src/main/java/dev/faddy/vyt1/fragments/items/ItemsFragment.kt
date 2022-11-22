package dev.faddy.vyt1.fragments.items

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import dev.faddy.vyt1.databinding.FragmentItemsBinding


class ItemsFragment : Fragment() {

    private lateinit var binding: FragmentItemsBinding
    private val itemsDashboardAdapter = ItemsDashboardAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        return FragmentItemsBinding.inflate(layoutInflater).also {
            binding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
        initView()
        initClickListener()
    }

    private fun initClickListener() {
    }

    private fun initData() {
        itemsDashboardAdapter.intiData(
            mutableListOf(
                "sdifkmsdf", "gfhfg", "dghg", "etyer", "cxvc", "etyry"
            )
        )
    }

    private fun initView() {
        with(binding.recyclerView) {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(
                requireContext(), androidx.recyclerview.widget.LinearLayoutManager.VERTICAL, false
            )
            adapter = itemsDashboardAdapter
        }
    }

}