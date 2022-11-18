package dev.faddy.vyt1.fragments.parties.addNewParty

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dev.faddy.vyt1.databinding.FragmentAddNewPartyBinding


class AddNewPartyFragment : Fragment() {

    private lateinit var binding: FragmentAddNewPartyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        return FragmentAddNewPartyBinding.inflate(layoutInflater).also { binding = it }.root
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