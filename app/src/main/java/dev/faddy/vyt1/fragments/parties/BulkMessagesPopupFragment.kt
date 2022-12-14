package dev.faddy.vyt1.fragments.parties

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import dev.faddy.vyt1.databinding.PopupViewBulkMessagesBinding


class BulkMessagesPopupFragment : DialogFragment() {

    private lateinit var binding: PopupViewBulkMessagesBinding

    private fun initClickListener() {
        binding.cancelButton.setOnClickListener { findNavController().popBackStack() }
        binding.nextButton.setOnClickListener { findNavController().popBackStack() }
    }

    private fun initData() {}
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        return PopupViewBulkMessagesBinding.inflate(layoutInflater).also {
            binding = it
        }.root

    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.window!!.requestFeature(Window.FEATURE_NO_TITLE)
        return dialog.apply {
            this.window?.attributes?.width = WindowManager.LayoutParams.MATCH_PARENT
            this.window?.attributes?.height = WindowManager.LayoutParams.MATCH_PARENT
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
        initClickListener()
    }

    fun Int.toPx(context: Context): Int = (this * context.resources.displayMetrics.density).toInt()

    fun Int.toDp(context: Context): Int = (this / context.resources.displayMetrics.density).toInt()
    override fun onResume() {
        super.onResume()
        dialog!!.window!!.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT
        )
    }

}