package dev.faddy.vyt1.fragments.dashboard.bottomsheets

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dev.faddy.vyt1.R
import dev.faddy.vyt1.databinding.FragmentDashBoardBottomSheetListDialogBinding
import kotlin.concurrent.thread


class DashBoardBottomSheetFragment : BottomSheetDialogFragment() {
    val ARG_ITEM_COUNT = "item_count"

    private lateinit var salesAdapter: BottomSheetDashBoardAdapter
    private lateinit var purchaseAdapter: BottomSheetDashBoardAdapter
    private lateinit var othersAdapter: BottomSheetDashBoardAdapter

    private lateinit var saleRecyclerData: SaleRecyclerData
    private lateinit var purchaseRecyclerData: PurchaseRecyclerData
    private lateinit var otherRecyclerData: OthersRecyclerData

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
        initData()
        initView()
        initClickListener()
    }

    private fun initData() {
        salesAdapter = BottomSheetDashBoardAdapter()
        purchaseAdapter = BottomSheetDashBoardAdapter()
        othersAdapter = BottomSheetDashBoardAdapter()
        saleRecyclerData = SaleRecyclerData()
        purchaseRecyclerData = PurchaseRecyclerData()
        otherRecyclerData = OthersRecyclerData()
    }

    private fun initClickListener() {
        binding.closeCardView.setOnClickListener {
            this.dismiss()
        }
        salesAdapter.onItemClicked = { returnedData ->
            when (returnedData) {
                saleRecyclerData.saleInvoice -> {

                }
                saleRecyclerData.paymentIn -> {
                    findNavController().navigate(R.id.paymentInFragment)
                    this.dismiss()
                }
                saleRecyclerData.crNoteReturn -> {

                }
                saleRecyclerData.saleOrder -> {

                }
                saleRecyclerData.estimateQuotation -> {

                }
                saleRecyclerData.performanceInvoice -> {

                }
                saleRecyclerData.deliveryChallan -> {

                }
            }
        }
        purchaseAdapter.onItemClicked = { returnedData ->
            when (returnedData) {
                purchaseRecyclerData.purchase -> {

                }
                purchaseRecyclerData.paymentOut -> {

                }
                purchaseRecyclerData.drNoteReturn -> {

                }
                purchaseRecyclerData.purchaseOrder -> {

                }
            }
        }
        othersAdapter.onItemClicked = { returnedData ->
            when (returnedData) {
                otherRecyclerData.expenses -> {

                }
                otherRecyclerData.partyToTransfer -> {

                }
            }
        }
    }

    private fun initView() {

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
                saleRecyclerData.saleInvoice,
                saleRecyclerData.paymentIn,
                saleRecyclerData.crNoteReturn,
                saleRecyclerData.saleOrder,
                saleRecyclerData.estimateQuotation,
                saleRecyclerData.performanceInvoice,
                saleRecyclerData.deliveryChallan
            ).toMutableList()
        )
        purchaseAdapter.intiData(
            listOf(
                purchaseRecyclerData.purchase,
                purchaseRecyclerData.paymentOut,
                purchaseRecyclerData.paymentOut,
                purchaseRecyclerData.purchaseOrder
            ).toMutableList()
        )

        othersAdapter.intiData(
            listOf(
                otherRecyclerData.expenses, otherRecyclerData.partyToTransfer
            ).toMutableList()
        )
    }


    companion object {
        fun newInstance(): DashBoardBottomSheetFragment = DashBoardBottomSheetFragment().apply {
            arguments = Bundle().apply {
                putInt(ARG_ITEM_COUNT, 5)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    data class SaleRecyclerData(
        val saleInvoice: String = "Sale Invoice",
        val paymentIn: String = "Payment In",
        val crNoteReturn: String = "cr. Note Sale Return",
        val saleOrder: String = "Sale Order",
        val estimateQuotation: String = "Estimate Quotation",
        val performanceInvoice: String = "Performance Invoice",
        val deliveryChallan: String = "Delivery Challan",
    )

    data class PurchaseRecyclerData(
        val purchase: String = "Purchase",
        val paymentOut: String = "Payment Out",
        val drNoteReturn: String = "Dr. Note Purchase Return",
        val purchaseOrder: String = "Purchase Order"
    )

    data class OthersRecyclerData(
        val expenses: String = "Expenses", val partyToTransfer: String = "Party to Party Transfer"
    )

}