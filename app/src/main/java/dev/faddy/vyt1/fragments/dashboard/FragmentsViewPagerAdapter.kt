package dev.faddy.vyt1.fragments.dashboard

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import dev.faddy.vyt1.fragments.items.ItemsFragment
import dev.faddy.vyt1.fragments.parties.PartiesFragment
import dev.faddy.vyt1.fragments.transactions.TransactionsFragment


class FragmentsViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {


    override fun getItemCount() = 3
    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> {
                return PartiesFragment()
            }
            1 -> {
                return TransactionsFragment()
            }
            2 -> {
                return ItemsFragment()
            }
        }
        return PartiesFragment()
    }
}