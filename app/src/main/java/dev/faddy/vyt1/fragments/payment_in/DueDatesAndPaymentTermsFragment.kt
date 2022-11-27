package dev.faddy.vyt1.fragments.payment_in

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dev.faddy.vyt1.databinding.FragmentDueDatesAndPaymentTermsBinding


class DueDatesAndPaymentTermsFragment : Fragment() {

    private lateinit var binding: FragmentDueDatesAndPaymentTermsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        return FragmentDueDatesAndPaymentTermsBinding.inflate(layoutInflater)
            .also { binding = it }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initData()
        initClickListener()
    }

    private fun initClickListener() {

    }

    private fun initData() {

    }

    private fun initView() {

    }
}