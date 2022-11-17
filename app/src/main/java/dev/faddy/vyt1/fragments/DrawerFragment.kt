package dev.faddy.vyt1.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import dev.faddy.vyt1.MainActivity
import dev.faddy.vyt1.databinding.FragmentDrawerBinding


class DrawerFragment : Fragment() {


    private lateinit var binding: FragmentDrawerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        return FragmentDrawerBinding.inflate(inflater, container, false).also { binding = it }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initClicklistener()
    }

    private fun initView() {

    }

    private fun initClicklistener() {
        binding.itemLayout.setOnClickListener {
            (activity as MainActivity).showToast()
            (activity as MainActivity).closeDrawer()
            Toast.makeText(requireContext(), "Clicked on itemLayout", Toast.LENGTH_SHORT).show()
        }
        binding.businessDashbpardLayout.setOnClickListener {
            (activity as MainActivity).showToast()
            (activity as MainActivity).closeDrawer()
            Toast.makeText(
                requireContext(), "Clicked on businessDashbpardLayout", Toast.LENGTH_SHORT
            ).show()
        }
        binding.reportsLayout.setOnClickListener {
            (activity as MainActivity).showToast()
            (activity as MainActivity).closeDrawer()
            Toast.makeText(requireContext(), "Clicked on reportsLayout", Toast.LENGTH_SHORT).show()
        }
        binding.saleslayout.setOnClickListener {
            (activity as MainActivity).showToast()
            (activity as MainActivity).closeDrawer()
            Toast.makeText(requireContext(), "Clicked on saleslayout", Toast.LENGTH_SHORT).show()
        }
        binding.purchaseLayout.setOnClickListener {
            (activity as MainActivity).showToast()
            (activity as MainActivity).closeDrawer()
            Toast.makeText(requireContext(), "Clicked on purchaseLayout", Toast.LENGTH_SHORT).show()
        }
    }
}