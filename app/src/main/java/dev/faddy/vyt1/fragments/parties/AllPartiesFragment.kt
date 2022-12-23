package dev.faddy.vyt1.fragments.parties

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import dev.faddy.vyt1.databinding.FragmentAllPartiesBinding

class AllPartiesFragment : Fragment() {

    private lateinit var binding: FragmentAllPartiesBinding
    private var showAllFloatingActionBar = false
    private lateinit var allPartiesAdapter: AllPartiesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        return FragmentAllPartiesBinding.inflate(layoutInflater).also { binding = it }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initData()
        initClickListener()
    }

    private fun initData() {

    }

    private fun initClickListener() {
        binding.addFab.setOnClickListener {
            showAllFloatingActionBar = !showAllFloatingActionBar
            controlChildFlatingActionBars(showAllFloatingActionBar)
        }
    }

    private fun controlChildFlatingActionBars(showAllFloatingActionBar: Boolean) {
        /*if (showAllFloatingActionBar) {
            binding.addNewPartiesToGrpFAB.updateLayoutParams<ConstraintLayout.LayoutParams> {
                bottomToBottom = ConstraintLayout.LayoutParams.UNSET
                bottomToTop = binding.addFab.topc
            }
            binding.createNewGrpFAB.updateLayoutParams<ConstraintLayout.LayoutParams> {
                bottomToBottom = ConstraintLayout.LayoutParams.UNSET
                bottomToTop = binding.addNewPartiesToGrpFAB.top
            }
        } else {
            binding.addNewPartiesToGrpFAB.updateLayoutParams<ConstraintLayout.LayoutParams> {
                bottomToTop = ConstraintLayout.LayoutParams.UNSET
                bottomToBottom = binding.addFab.bottom
            }
            binding.createNewGrpFAB.updateLayoutParams<ConstraintLayout.LayoutParams> {
                bottomToTop = ConstraintLayout.LayoutParams.UNSET
                bottomToBottom = binding.addFab.bottom
            }
        }*/
        binding.addNewPartiesToGrpFAB.isVisible = showAllFloatingActionBar
        binding.createNewGrpFAB.isVisible = showAllFloatingActionBar
        binding.addnewPartiestogrpTxt.isVisible = showAllFloatingActionBar
        binding.createNewGrpText.isVisible = showAllFloatingActionBar
        binding.addFab.rotation = if (showAllFloatingActionBar) 45f else 0f
    }

    private fun initView() {
        allPartiesAdapter = AllPartiesAdapter()
        with(binding.allPartiesRecycler) {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(
                context, LinearLayoutManager.VERTICAL, false
            )
            adapter = allPartiesAdapter
        }
        allPartiesAdapter.intiData(
            mutableListOf(
                "sdifkmsdf", "gfhfg", "dghg", "etyer", "cxvc", "etyry"
            )
        )
    }
}