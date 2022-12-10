package dev.faddy.vyt1.fragments.dashboard.bottomsheets

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dev.faddy.vyt1.databinding.FragmentBulkPaymentBottomsheetBinding

class BulkPaymentRemainderBottomSheet : BottomSheetDialogFragment() {

    private lateinit var _binding: FragmentBulkPaymentBottomsheetBinding
    private lateinit var dataAdapter: BottomSheetBulkPaymentRemainderAdapter

    private val binding get() = _binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBulkPaymentBottomsheetBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onStart() {
        super.onStart()
        val dialog: BottomSheetDialog? = dialog as BottomSheetDialog?
        dialog?.setCanceledOnTouchOutside(true)
        val bottomSheet: FrameLayout? =
            dialog?.findViewById(com.google.android.material.R.id.design_bottom_sheet)
        bottomSheet?.layoutParams?.height = ViewGroup.LayoutParams.MATCH_PARENT;

        /* if (bottomSheet != null) {
             BottomSheetBehavior.from(bottomSheet).state = BottomSheetBehavior.STATE_EXPANDED
             *//*thread {
                activity?.runOnUiThread {
                    val dynamicHeight = binding.root.height
                    BottomSheetBehavior.from(bottomSheet).peekHeight = dynamicHeight
                }
            }*//*
            with(BottomSheetBehavior.from(bottomSheet)) {
                skipCollapsed = false
                isHideable = true
            }
        }*/

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initData()
        initView()
        initClickListener()
    }

    private fun initData() {
        dataAdapter = BottomSheetBulkPaymentRemainderAdapter()
    }

    private fun initClickListener() {

    }

    private fun initView() {
        with(binding.bulkPaymentRecycler) {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(
                requireContext(), androidx.recyclerview.widget.LinearLayoutManager.VERTICAL, false
            )
            adapter = dataAdapter
        }
        dataAdapter.intiData(
            mutableListOf(
                "Cus1", "Cus1", "Cus1", "Cus1", "Cus1", "Cus1",
                "Cus1", "Cus1", "Cus1", "Cus1", "Cus1", "Cus1",
                "Cus1", "Cus1", "Cus1", "Cus1", "Cus1", "Cus1",
                "Cus1", "Cus1", "Cus1", "Cus1", "Cus1", "Cus1"
            )
        )
    }

}