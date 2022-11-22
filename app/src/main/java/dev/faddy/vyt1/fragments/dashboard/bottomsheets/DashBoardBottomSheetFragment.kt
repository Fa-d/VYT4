package dev.faddy.vyt1.fragments.dashboard.bottomsheets

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dev.faddy.vyt1.databinding.FragmentDashBoardBottomSheetListDialogBinding
import kotlin.concurrent.thread


class DashBoardBottomSheetFragment : BottomSheetDialogFragment() {
    val ARG_ITEM_COUNT = "item_count"

    private var _binding: FragmentDashBoardBottomSheetListDialogBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDashBoardBottomSheetListDialogBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onStart() {
        super.onStart()
        val dialog: BottomSheetDialog? = dialog as BottomSheetDialog?
        dialog?.setCanceledOnTouchOutside(true)
        val bottomSheet: FrameLayout? =
            dialog?.findViewById(com.google.android.material.R.id.design_bottom_sheet)
        //val metrics = resources.displayMetrics

        if (bottomSheet != null) {
            BottomSheetBehavior.from(bottomSheet).state = BottomSheetBehavior.STATE_COLLAPSED
            thread {
                activity?.runOnUiThread {
                    val dynamicHeight = binding.root.height
                    BottomSheetBehavior.from(bottomSheet).peekHeight = dynamicHeight
                }
            }
            with(BottomSheetBehavior.from(bottomSheet)) {
                //state = BottomSheetBehavior.STATE_COLLAPSED
                skipCollapsed = true
                isHideable = true
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initView()
        initClickListener()
    }

    private fun initClickListener() {
        binding.closeCardView.setOnClickListener {
            this.dismiss()
        }

    }

    private fun initView() {
        val salesAdapter = BottomSheetDashBoardAdapter()
        val purchaseAdapter = BottomSheetDashBoardAdapter()
        val othersAdapter = BottomSheetDashBoardAdapter()
        with(binding.otherTransactionRecycler) {
            setHasFixedSize(true)
            layoutManager =
                GridLayoutManager(requireContext(), 4, GridLayoutManager.VERTICAL, false)
            adapter = othersAdapter
        }
        with(binding.salesTransactionRecycler) {
            setHasFixedSize(true)
            layoutManager =
                GridLayoutManager(requireContext(), 4, GridLayoutManager.VERTICAL, false)
            adapter = salesAdapter
        }
        with(binding.purchaseTransactionRecycler) {
            setHasFixedSize(true)
            layoutManager =
                GridLayoutManager(requireContext(), 4, GridLayoutManager.VERTICAL, false)
            adapter = purchaseAdapter
        }
        salesAdapter.intiData(
            listOf(
                "Sale Invoice",
                "Payment In",
                "cr. Note Sale Return",
                "Sale Order",
                "Estimate Quotation",
                "Performance Invoice",
                "Delivery Challan",
            ).toMutableList()
        )
        purchaseAdapter.intiData(
            listOf(
                "Purchase", "Payment Out", "Dr. Note Purchase Return", "Purchase Order"
            ).toMutableList()
        )

        othersAdapter.intiData(listOf("Expenses", "Party to Transfer").toMutableList())


    }


    companion object {
        fun newInstance(itemCount: Int): DashBoardBottomSheetFragment =
            DashBoardBottomSheetFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_ITEM_COUNT, itemCount)
                }
            }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}