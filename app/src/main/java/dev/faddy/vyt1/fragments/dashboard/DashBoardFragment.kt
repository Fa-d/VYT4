package dev.faddy.vyt1.fragments.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import dev.faddy.vyt1.MainActivity
import dev.faddy.vyt1.R
import dev.faddy.vyt1.databinding.FragmentDashBoardBinding


open class DashBoardFragment : Fragment() {

    private lateinit var binding: FragmentDashBoardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        return FragmentDashBoardBinding.inflate(layoutInflater).also {
            binding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initClickListener()
    }

    private fun initClickListener() {
        binding.partiesTabCardView.setOnClickListener {
            binding.fragmentsViewPager.currentItem = 0
            backgroundChanger(0)

        }
        binding.transctionsCardView.setOnClickListener {
            binding.fragmentsViewPager.currentItem = 1
            backgroundChanger(1)
        }
        binding.ItemsCardView.setOnClickListener {
            binding.fragmentsViewPager.currentItem = 2
            backgroundChanger(2)
        }

        binding.addBtnCardView.setOnClickListener {
            findNavController().navigate(R.id.dashBoardBottomSheetFragment)
        }
        binding.menuIcon.setOnClickListener {
            (requireActivity() as MainActivity).openDrawerMain()
        }

        binding.takePaymentCardView.setOnClickListener {
            findNavController().navigate(R.id.action_dashBoardFragment_to_paymentInFragment)
        }
    }

    private fun backgroundChanger(pos: Int) {
        when (pos) {
            0 -> {
                binding.partiesTabCardView.foreground =
                    ContextCompat.getDrawable(requireContext(), R.drawable.backgound_recrangle_red)
                binding.transctionsCardView.foreground = ContextCompat.getDrawable(
                    requireContext(), R.drawable.background_gray_fill_none_rectangle
                )
                binding.ItemsCardView.foreground = ContextCompat.getDrawable(
                    requireContext(), R.drawable.background_gray_fill_none_rectangle
                )
                binding.partiesTabText.setTextColor(
                    ContextCompat.getColor(requireContext(), R.color.red)
                )
                binding.TransctionsTabText.setTextColor(
                    ContextCompat.getColor(requireContext(), R.color.default_text_color)
                )
                binding.itemsTabText.setTextColor(
                    ContextCompat.getColor(requireContext(), R.color.default_text_color)
                )
            }
            1 -> {
                binding.partiesTabCardView.foreground = ContextCompat.getDrawable(
                    requireContext(), R.drawable.background_gray_fill_none_rectangle
                )
                binding.transctionsCardView.foreground = ContextCompat.getDrawable(
                    requireContext(), R.drawable.backgound_recrangle_red
                )
                binding.ItemsCardView.foreground = ContextCompat.getDrawable(
                    requireContext(), R.drawable.background_gray_fill_none_rectangle
                )
                binding.partiesTabText.setTextColor(
                    ContextCompat.getColor(requireContext(), R.color.default_text_color)
                )
                binding.TransctionsTabText.setTextColor(
                    ContextCompat.getColor(requireContext(), R.color.red)
                )
                binding.itemsTabText.setTextColor(
                    ContextCompat.getColor(requireContext(), R.color.default_text_color)
                )
            }
            2 -> {
                binding.partiesTabCardView.foreground = ContextCompat.getDrawable(
                    requireContext(), R.drawable.background_gray_fill_none_rectangle
                )
                binding.transctionsCardView.foreground = ContextCompat.getDrawable(
                    requireContext(), R.drawable.background_gray_fill_none_rectangle
                )
                binding.ItemsCardView.foreground = ContextCompat.getDrawable(
                    requireContext(), R.drawable.backgound_recrangle_red
                )

                binding.partiesTabText.setTextColor(
                    ContextCompat.getColor(requireContext(), R.color.default_text_color)
                )
                binding.TransctionsTabText.setTextColor(
                    ContextCompat.getColor(requireContext(), R.color.default_text_color)
                )
                binding.itemsTabText.setTextColor(
                    ContextCompat.getColor(requireContext(), R.color.red)
                )
            }
        }
    }

    private fun initView() {
        val topAdapter = TopAdapter()
        val adapterViewpager =
            FragmentsViewPagerAdapter(activity?.supportFragmentManager!!, lifecycle)
        with(binding.recyclerTop) {
            setHasFixedSize(true)
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = topAdapter
        }
        topAdapter.intiData(mutableListOf("sdifkmsdf", "gfhfg", "dghg", "etyer", "cxvc", "etyry"))

        binding.fragmentsViewPager.adapter = adapterViewpager

        binding.fragmentsViewPager.registerOnPageChangeCallback(object : OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                backgroundChanger(position)
            }
        })

    }

}