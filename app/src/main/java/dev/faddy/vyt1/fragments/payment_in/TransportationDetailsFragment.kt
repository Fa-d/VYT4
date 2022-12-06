package dev.faddy.vyt1.fragments.payment_in

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import dev.faddy.vyt1.databinding.FragmentTransportationDetailsBinding


class TransportationDetailsFragment : Fragment() {

    private lateinit var binding: FragmentTransportationDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return FragmentTransportationDetailsBinding.inflate(layoutInflater)
            .also { binding = it }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        intiView()
    }

    private fun intiView() {
        binding.backButton.setOnClickListener {
            findNavController().popBackStack()
        }

    }
}