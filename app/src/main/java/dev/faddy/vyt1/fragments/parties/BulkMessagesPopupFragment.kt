package dev.faddy.vyt1.fragments.parties

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import dev.faddy.vyt1.databinding.PopupViewBulkMessagesBinding


class BulkMessagesPopupFragment : DialogFragment() {

    private lateinit var binding: PopupViewBulkMessagesBinding
    private lateinit var customerAdapter: BulkMassagePopupAdapter

    private var isAllSelected = false;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        return PopupViewBulkMessagesBinding.inflate(layoutInflater).also {
            binding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
        initClickListener()
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            (resources.displayMetrics.widthPixels * 0.95).toInt(),
            (resources.displayMetrics.heightPixels * 0.95).toInt()
        )
    }

    private fun setupView() {
        customerAdapter = BulkMassagePopupAdapter()
        with(binding.itemsRecycler) {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(
                requireContext(), LinearLayoutManager.VERTICAL, false
            )
            adapter = customerAdapter
        }
        customerAdapter.intiData(
            mutableListOf(
                "sdifkmsdf", "gfhfg", "dghg", "etyer", "cxvc", "etyry"
            )
        )
    }

    private fun initClickListener() {
        binding.cancelButton.setOnClickListener { findNavController().popBackStack() }
        binding.nextButton.setOnClickListener { findNavController().popBackStack() }
        binding.sele.setOnClickListener {
            isAllSelected = !isAllSelected
            binding.selectAllCheckBox.isChecked = isAllSelected
            customerAdapter.selectAll(isAllSelected)
        }
    }


}