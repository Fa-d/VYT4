package dev.faddy.vyt1.fragments.parties

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.PopupMenu
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import dev.faddy.vyt1.R
import dev.faddy.vyt1.databinding.FragmentPartiesBinding
import dev.faddy.vyt1.fragments.parties.botttomsheet.FilterPartyBottomSheetDialogFragment

class PartiesFragment : Fragment() {

    private val partiesAdapter = PartiesDashboardAdapter()
    private lateinit var popup: PopupMenu
    private lateinit var binding: FragmentPartiesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        return FragmentPartiesBinding.inflate(layoutInflater).also {
            binding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initData()
        initClickListners()
    }

    private fun initClickListners() {
        binding.filterIcon.setOnClickListener {
            findNavController().navigate(R.id.filterPartyBottomSheetDialogFragment)
        }
        binding.menuIcon.setOnClickListener {
            popup.show()
        }

        popup.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.bulk_paymnet_remainder -> {
                    findNavController().navigate(R.id.bulkPaymentRemainderBottomSheet)
                    true
                }
                R.id.bulk_messages -> true
                R.id.party_grouping -> true
                R.id.sort_by_name -> {
                    item.isChecked = !item.isChecked
                    item.setShowAsAction(MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW)
                    item.actionView = View(context)
                    item.setOnActionExpandListener(object : MenuItem.OnActionExpandListener {
                        override fun onMenuItemActionExpand(p0: MenuItem) = false
                        override fun onMenuItemActionCollapse(p0: MenuItem) = false
                    })
                    false
                }
                else -> false
            }
        }
        binding.newPartyText.setOnClickListener {
            findNavController().navigate(R.id.action_dashBoardFragment_to_addNewPartyFragment)
        }
        partiesAdapter.onItemClicked = {
            findNavController().navigate(R.id.action_dashBoardFragment_to_partyDetailsFragment)
        }
    }

    private fun initData() {
        partiesAdapter.intiData(
            mutableListOf(
                "sdifkmsdf", "gfhfg", "dghg", "etyer", "cxvc", "etyry"
            )
        )
    }

    private fun initView() {
        popup = PopupMenu(requireContext(), binding.menuIcon)
        popup.inflate(R.menu.party_dashboard_menu)

        with(binding.partiesRecycler) {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(
                requireContext(), LinearLayoutManager.VERTICAL, false
            )
            adapter = partiesAdapter
        }
    }
}