package dev.faddy.vyt1.fragments.transactions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import dev.faddy.vyt1.databinding.FragmentTransactionsBinding


class TransactionsFragment : Fragment() {
    private val transactionsAdapter = TransactionsDashboardAdapter()


    private lateinit var binding: FragmentTransactionsBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        return FragmentTransactionsBinding.inflate(layoutInflater).also {
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
        transactionsAdapter.intiData(
            mutableListOf(
                "sdifkmsdf", "gfhfg", "dghg", "etyer", "cxvc", "etyry"
            )
        )
    }

    private fun initView() {
        with(binding.recyclerView) {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(
                requireContext(), LinearLayoutManager.VERTICAL, false
            )
            adapter = transactionsAdapter
        }
    }

}