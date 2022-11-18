package dev.faddy.vyt1.fragments.drawerComponents

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dev.faddy.vyt1.databinding.FragmentDrawerBinding


class DrawerFragment : Fragment() {


    private lateinit var binding: FragmentDrawerBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        return FragmentDrawerBinding.inflate(inflater, container, false).also { binding = it }.root
    }

}