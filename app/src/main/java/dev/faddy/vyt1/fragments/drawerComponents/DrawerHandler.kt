package dev.faddy.vyt1.fragments.drawerComponents

import android.content.Context
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import dev.faddy.vyt1.databinding.FragmentDrawerBinding
import dev.faddy.vyt1.utils.Constants.exhaustive

class DrawerHandler(val binding: FragmentDrawerBinding, val context: Context) {

    private lateinit var salesDrawerAdapter: SalesDrawerAdapter
    private lateinit var purchaseAdapter: SalesDrawerAdapter
    private lateinit var cashAndBankAdapter: SalesDrawerAdapter
    private lateinit var backupandRestoreAdapter: SalesDrawerAdapter
    private lateinit var utilitiesAdapter: SalesDrawerAdapter
    private lateinit var helpAndSupportAdapter: SalesDrawerAdapter

    private var isSalesRecyclerVisible = false
    private var isSCashAndBankRecyclerVisible = false
    private var isPurchaseRecyclerVisible = false
    private var isBackUpAndRestoreRecyclerVisible = false
    private var isUtilitiesRecyclerVisible = false
    private var isHelpAndSupportRecyclerVisible = false


    fun initAdapters() {
        salesDrawerAdapter = SalesDrawerAdapter()
        purchaseAdapter = SalesDrawerAdapter()
        cashAndBankAdapter = SalesDrawerAdapter()
        backupandRestoreAdapter = SalesDrawerAdapter()
        utilitiesAdapter = SalesDrawerAdapter()
        helpAndSupportAdapter = SalesDrawerAdapter()

        initData()
    }

    private fun initData() {
        salesDrawerAdapter.intiData(
            mutableListOf(
                "Sale Invoice",
                "Payment-In",
                "Sale Return",
                "Estimate/Quotation",
                "Estimate/Quotation",
                "Sale Order",
                "Delivery Challan"
            )
        )
        purchaseAdapter.intiData(
            mutableListOf(
                "Purchase bills", "Payment-Out", "Purchase Return", "Purchase Order"
            )
        )
        cashAndBankAdapter.intiData(
            mutableListOf(
                "Bank Accounts", "Cash-In-Hand", "Cheques", "Loan Accounts"
            )
        )
        backupandRestoreAdapter.intiData(
            mutableListOf(
                "Add Backup", "Backup to phone", "Backup to e-mail", "Restore Backup"
            )
        )

        utilitiesAdapter.intiData(
            mutableListOf(
                "Verify my data",
                "Open Calculator",
                "Imported Items",
                "Import Parties",
                "Recycle Bin",
                "Close Financial Year"
            )
        )
        helpAndSupportAdapter.intiData(
            mutableListOf(
                "Customber Care", "Tutorials", "Remote Vyapar Support"
            )
        )
    }

    fun initRecyclerViews() {

        with(binding.salesInvoicerecycler) {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(
                context, LinearLayoutManager.VERTICAL, false
            )
            adapter = salesDrawerAdapter
        }
        with(binding.purchaseRecycler) {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(
                context, LinearLayoutManager.VERTICAL, false
            )
            adapter = purchaseAdapter
        }
        with(binding.cashAndBankRecycler) {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(
                context, LinearLayoutManager.VERTICAL, false
            )
            adapter = cashAndBankAdapter
        }
        with(binding.backUpandRestoreRecycler) {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(
                context, LinearLayoutManager.VERTICAL, false
            )
            adapter = backupandRestoreAdapter
        }
        with(binding.utilitiesRecycler) {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(
                context, LinearLayoutManager.VERTICAL, false
            )
            adapter = utilitiesAdapter
        }
        with(binding.helpAndSupportRecycler) {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(
                context, LinearLayoutManager.VERTICAL, false
            )
            adapter = helpAndSupportAdapter
        }
    }

    enum class RecyclerLayout {
        salesInvoicerecycler, purchaseRecycler, cashAndBankRecycler, helpAndSupportRecycler, utilitiesRecycler, backUpandRestoreRecycler
    }

    fun onRecyclerClicked(typeRecycler: RecyclerLayout) {
        when (typeRecycler) {
            RecyclerLayout.salesInvoicerecycler -> {
                isSalesRecyclerVisible = !isSalesRecyclerVisible
                binding.salesInvoicerecycler.isVisible = isSalesRecyclerVisible
                binding.purchaseRecycler.isVisible = false
                binding.cashAndBankRecycler.isVisible = false
                binding.helpAndSupportRecycler.isVisible = false
                binding.utilitiesRecycler.isVisible = false
                binding.backUpandRestoreRecycler.isVisible = false
            }
            RecyclerLayout.purchaseRecycler -> {
                isPurchaseRecyclerVisible = !isPurchaseRecyclerVisible
                binding.purchaseRecycler.isVisible = isPurchaseRecyclerVisible
                binding.salesInvoicerecycler.isVisible = false
                binding.cashAndBankRecycler.isVisible = false
                binding.helpAndSupportRecycler.isVisible = false
                binding.utilitiesRecycler.isVisible = false
                binding.backUpandRestoreRecycler.isVisible = false
            }
            RecyclerLayout.cashAndBankRecycler -> {
                isSCashAndBankRecyclerVisible = !isSCashAndBankRecyclerVisible
                binding.cashAndBankRecycler.isVisible = isSCashAndBankRecyclerVisible
                binding.purchaseRecycler.isVisible = false
                binding.salesInvoicerecycler.isVisible = false
                binding.helpAndSupportRecycler.isVisible = false
                binding.utilitiesRecycler.isVisible = false
                binding.backUpandRestoreRecycler.isVisible = false

            }
            RecyclerLayout.helpAndSupportRecycler -> {
                isHelpAndSupportRecyclerVisible = !isHelpAndSupportRecyclerVisible
                binding.helpAndSupportRecycler.isVisible = isHelpAndSupportRecyclerVisible
                binding.cashAndBankRecycler.isVisible = false
                binding.purchaseRecycler.isVisible = false
                binding.salesInvoicerecycler.isVisible = false
                binding.utilitiesRecycler.isVisible = false
                binding.backUpandRestoreRecycler.isVisible = false
            }
            RecyclerLayout.utilitiesRecycler -> {
                isUtilitiesRecyclerVisible = !isUtilitiesRecyclerVisible
                binding.utilitiesRecycler.isVisible = isUtilitiesRecyclerVisible
                binding.cashAndBankRecycler.isVisible = false
                binding.purchaseRecycler.isVisible = false
                binding.salesInvoicerecycler.isVisible = false
                binding.helpAndSupportRecycler.isVisible = false
                binding.backUpandRestoreRecycler.isVisible = false

            }
            RecyclerLayout.backUpandRestoreRecycler -> {
                isBackUpAndRestoreRecyclerVisible = !isBackUpAndRestoreRecyclerVisible
                binding.backUpandRestoreRecycler.isVisible = isBackUpAndRestoreRecyclerVisible
                binding.purchaseRecycler.isVisible = false
                binding.salesInvoicerecycler.isVisible = false
                binding.cashAndBankRecycler.isVisible = false
                binding.helpAndSupportRecycler.isVisible = false
            }
        }.exhaustive
    }


}