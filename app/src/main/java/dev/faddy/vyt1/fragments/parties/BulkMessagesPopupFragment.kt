package dev.faddy.vyt1.fragments.parties

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import dev.faddy.vyt1.databinding.PopupViewBulkMessagesBinding


class BulkMessagesPopupFragment : DialogFragment() {

    private lateinit var binding: PopupViewBulkMessagesBinding

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

    }

    private fun initClickListener() {
        binding.cancelButton.setOnClickListener { findNavController().popBackStack() }
        binding.nextButton.setOnClickListener { findNavController().popBackStack() }
    }


}