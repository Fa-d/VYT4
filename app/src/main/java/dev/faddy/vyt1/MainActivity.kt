package dev.faddy.vyt1

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.navigation.findNavController
import dev.faddy.vyt1.databinding.ActivityMainBinding
import dev.faddy.vyt1.fragments.drawerComponents.DrawerHandler


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var drawerHandler: DrawerHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        initView()
        initClickListener()
    }

    private fun initView() {
        drawerHandler = DrawerHandler(binding.drawrerInner, this).apply {
            initAdapters()
            initRecyclerViews()
        }
    }

    private fun initClickListener() {
        dwawerClicks()
    }

    private fun dwawerClicks() {
        binding.drawrerInner.saleslayout.setOnClickListener {
            drawerHandler.onRecyclerClicked(DrawerHandler.RecyclerLayout.salesInvoicerecycler)
        }
        binding.drawrerInner.purchaseLayout.setOnClickListener {
            drawerHandler.onRecyclerClicked(DrawerHandler.RecyclerLayout.purchaseRecycler)
        }
        binding.drawrerInner.cashAndBankLayout.setOnClickListener {
            drawerHandler.onRecyclerClicked(DrawerHandler.RecyclerLayout.cashAndBankRecycler)
        }
        binding.drawrerInner.helpAndSupportLayout.setOnClickListener {
            drawerHandler.onRecyclerClicked(DrawerHandler.RecyclerLayout.helpAndSupportRecycler)
        }
        binding.drawrerInner.utilitiesLayout.setOnClickListener {
            drawerHandler.onRecyclerClicked(DrawerHandler.RecyclerLayout.utilitiesRecycler)
        }
        binding.drawrerInner.backupandRestoreLayout.setOnClickListener {
            drawerHandler.onRecyclerClicked(DrawerHandler.RecyclerLayout.backUpandRestoreRecycler)
        }
        binding.drawrerInner.settingsLayout.setOnClickListener {
            closeDrawer()
            findNavController(R.id.fragmentContainerView).navigate(R.id.settingsFragment)
        }
        binding.drawrerInner.itemLayout.setOnClickListener {
            closeDrawer()
            findNavController(R.id.fragmentContainerView).navigate(R.id.action_dashBoardFragment_to_itemsFragment)
        }
        binding.drawrerInner.businessDashbpardLayout.setOnClickListener {
            closeDrawer()
            findNavController(R.id.fragmentContainerView).navigate(R.id.action_dashBoardFragment_to_businessDashboardFragment)
        }
    }

    fun openDrawerMain() {
        binding.drawerLayout.openDrawer(GravityCompat.START)
    }

    private fun closeDrawer() {
        binding.drawerLayout.closeDrawer(GravityCompat.START)
    }

    override fun onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    fun showToast() {
        Toast.makeText(this, "Clicked on reportsLayout", Toast.LENGTH_SHORT).show()
    }

}