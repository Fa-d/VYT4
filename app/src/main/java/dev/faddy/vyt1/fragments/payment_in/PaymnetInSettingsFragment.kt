package dev.faddy.vyt1.fragments.payment_in

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import dev.faddy.vyt1.R
import dev.faddy.vyt1.databinding.*
import dev.faddy.vyt1.utils.Constants.exhaustive
import dev.faddy.vyt1.utils.getDeviceMetrics


class PaymnetInSettingsFragment : Fragment() {

    private lateinit var binding: FragmentPaymnetInSettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        return FragmentPaymnetInSettingsBinding.inflate(layoutInflater).also { binding = it }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initData()
        initClickListener()
    }

    private fun initClickListener() {
        binding.dueDateAndPaymentTermsLayout.setOnClickListener {
            findNavController().navigate(R.id.action_paymnetInSettingsFragment_to_dueDatesAndPaymentTermsFragment)
        }
        binding.additionalFieldsLayout.setOnClickListener {
            findNavController().navigate(R.id.action_paymnetInSettingsFragment_to_additionalFieldsFragment)
        }
        binding.transportationDetailsLayout.setOnClickListener {
            findNavController().navigate(R.id.action_paymnetInSettingsFragment_to_transportationDetailsFragment)
        }
        binding.additionalChargesLayout.setOnClickListener {
            findNavController().navigate(R.id.action_paymnetInSettingsFragment_to_additionalChargesFragment)
        }
        binding.backButton.setOnClickListener { findNavController().popBackStack() }

        binding.invoiceBillNumber.setOnClickListener { thePopUp(InfoButtons.invoiceBillNumber) }
        binding.cashSaleByDefault.setOnClickListener { thePopUp(InfoButtons.cashSaleByDefault) }
        binding.billingNameOfParties.setOnClickListener { thePopUp(InfoButtons.billingNameOfParties) }
        binding.poDetaies.setOnClickListener { thePopUp(InfoButtons.poDetaies) }
        binding.addTimeOnTransactions.setOnClickListener { thePopUp(InfoButtons.addTimeOnTransactions) }
        binding.aietorpu.setOnClickListener { thePopUp(InfoButtons.aietorpu) }
        binding.displayPurchasePrice.setOnClickListener { thePopUp(InfoButtons.displayPurchasePrice) }
        binding.freeItemQuantity.setOnClickListener { thePopUp(InfoButtons.freeItemQuantity) }
        binding.countItem.setOnClickListener { thePopUp(InfoButtons.countItem) }
        binding.barcodeScanningForItems.setOnClickListener { thePopUp(InfoButtons.barcodeScanningForItems) }
        binding.selectBarCodeScanType.setOnClickListener { thePopUp(InfoButtons.selectBarCodeScanType) }
        binding.transactionWiseTax.setOnClickListener { thePopUp(InfoButtons.transactionWiseTax) }
        binding.transactionWiseDiscount.setOnClickListener { thePopUp(InfoButtons.transactionWiseDiscount) }
        binding.roundOffTransactionAmount.setOnClickListener { thePopUp(InfoButtons.roundOffTransactionAmount) }
        binding.shareInvoiceAsImage.setOnClickListener { thePopUp(InfoButtons.shareInvoiceAsImage) }
        binding.passcodeForEditOrDelete.setOnClickListener { thePopUp(InfoButtons.passcodeForEditOrDelete) }
        binding.discountDuringPayment.setOnClickListener { thePopUp(InfoButtons.discountDuringPayment) }
        binding.linkPaymentToInvoices.setOnClickListener { thePopUp(InfoButtons.linkPaymentToInvoices) }
        binding.dueDateAndPaymentTerms.setOnClickListener { thePopUp(InfoButtons.dueDateAndPaymentTerms) }
        binding.enableInvoicePreview.setOnClickListener { thePopUp(InfoButtons.enableInvoicePreview) }
        binding.additionalFieldstitle.setOnClickListener { thePopUp(InfoButtons.additionalFieldstitle) }
        binding.transportationDetails.setOnClickListener { thePopUp(InfoButtons.transportationDetails) }
        binding.additionalCharges.setOnClickListener { thePopUp(InfoButtons.additionalCharges) }
        binding.showProfitWhileMakingSaleInvoice.setOnClickListener { thePopUp(InfoButtons.showProfitWhileMakingSaleInvoice) }
    }

    enum class InfoButtons {
        invoiceBillNumber, cashSaleByDefault, billingNameOfParties, poDetaies, addTimeOnTransactions, aietorpu, displayPurchasePrice, freeItemQuantity, countItem, barcodeScanningForItems, selectBarCodeScanType, transactionWiseTax, transactionWiseDiscount, roundOffTransactionAmount, shareInvoiceAsImage, passcodeForEditOrDelete, discountDuringPayment, linkPaymentToInvoices, dueDateAndPaymentTerms, enableInvoicePreview, additionalFieldstitle, transportationDetails, additionalCharges, showProfitWhileMakingSaleInvoice
    }

    private fun initData() {}

    private fun initView() {}

    private fun thePopUp(pressedButton: InfoButtons) {
        var popUpBinding: Any? = null
        var view: ConstraintLayout? = null
        when (pressedButton) {
            InfoButtons.invoiceBillNumber -> {
                view = PopupViewInvoiceBillNumberBinding.inflate(layoutInflater)
                    .also { popUpBinding = it }.root
            }
            InfoButtons.cashSaleByDefault -> {
                view = PopupViewCashSaleByDefaultBinding.inflate(layoutInflater)
                    .also { popUpBinding = it }.root
            }
            InfoButtons.billingNameOfParties -> {
                view = PopupViewBillingNameOfPartiesBinding.inflate(layoutInflater)
                    .also { popUpBinding = it }.root
            }
            InfoButtons.poDetaies -> {
                view = PopupViewPoDetailsBinding.inflate(layoutInflater)
                    .also { popUpBinding = it }.root
            }
            InfoButtons.addTimeOnTransactions -> {
                view = PopupViewAddTimeOnTransactionsBinding.inflate(layoutInflater)
                    .also { popUpBinding = it }.root
            }
            InfoButtons.aietorpu -> {
                view =
                    PopupViewAietorpuBinding.inflate(layoutInflater).also { popUpBinding = it }.root
            }
            InfoButtons.displayPurchasePrice -> {
                view = PopupViewDisplayPurchasePriceBinding.inflate(layoutInflater)
                    .also { popUpBinding = it }.root
            }
            InfoButtons.freeItemQuantity -> {
                view = PopupViewFreeItemQuantityBinding.inflate(layoutInflater)
                    .also { popUpBinding = it }.root
            }
            InfoButtons.countItem -> {
                view = PopupViewCountItemBinding.inflate(layoutInflater)
                    .also { popUpBinding = it }.root
            }
            InfoButtons.barcodeScanningForItems -> {
                view = PopupViewBarcodeScanningForItemsBinding.inflate(layoutInflater)
                    .also { popUpBinding = it }.root
            }
            InfoButtons.selectBarCodeScanType -> {
                view = PopupViewSelectBarcodeScanTypeBinding.inflate(layoutInflater)
                    .also { popUpBinding = it }.root
            }
            InfoButtons.transactionWiseTax -> {
                view = PopupViewTransactionWiseTaxBinding.inflate(layoutInflater)
                    .also { popUpBinding = it }.root
            }
            InfoButtons.transactionWiseDiscount -> {
                view = PopupViewTransactionWiseDiscountBinding.inflate(layoutInflater)
                    .also { popUpBinding = it }.root
            }
            InfoButtons.roundOffTransactionAmount -> {
                view = PopupViewRoundoffTransactionAmountBinding.inflate(layoutInflater)
                    .also { popUpBinding = it }.root
            }
            InfoButtons.shareInvoiceAsImage -> {
                view = PopupViewShareInvoiceAsImageBinding.inflate(layoutInflater)
                    .also { popUpBinding = it }.root
            }
            InfoButtons.passcodeForEditOrDelete -> {
                view = PopupViewPasscodeForEditOrDeleteBinding.inflate(layoutInflater)
                    .also { popUpBinding = it }.root
            }
            InfoButtons.discountDuringPayment -> {
                view = PopupViewDiscountDuringPaymentBinding.inflate(layoutInflater)
                    .also { popUpBinding = it }.root
            }
            InfoButtons.linkPaymentToInvoices -> {
                view = PopupViewLinkPaymnetToInvoicesBinding.inflate(layoutInflater)
                    .also { popUpBinding = it }.root
            }
            InfoButtons.dueDateAndPaymentTerms -> {
                view = PopupViewDueDateAndPaymnetTermsBinding.inflate(layoutInflater)
                    .also { popUpBinding = it }.root
            }
            InfoButtons.enableInvoicePreview -> {
                view = PopupViewEnableInvoicePreviewBinding.inflate(layoutInflater)
                    .also { popUpBinding = it }.root
            }
            InfoButtons.additionalFieldstitle -> {
                view = PopupViewAdditionalFieldsTitleBinding.inflate(layoutInflater)
                    .also { popUpBinding = it }.root
            }
            InfoButtons.transportationDetails -> {
                view = PopupViewTransportationDetailsBinding.inflate(layoutInflater)
                    .also { popUpBinding = it }.root
            }
            InfoButtons.additionalCharges -> {
                view = PopupViewAdditionalChargesBinding.inflate(layoutInflater)
                    .also { popUpBinding = it }.root
            }
            InfoButtons.showProfitWhileMakingSaleInvoice -> {
                view = PopupViewShowProfitWithMakingSaleInvoiceBinding.inflate(layoutInflater)
                    .also { popUpBinding = it }.root
            }
        }.exhaustive

        val builder = MaterialAlertDialogBuilder(requireContext())
        builder.setView(view)
        val dialog = builder.create()
        dialog.window?.attributes?.width =
            (getDeviceMetrics(requireContext())?.widthPixels?.times(0.95))?.toInt()
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()

        (popUpBinding as PopupViewInvoiceBillNumberBinding).okBtn.setOnClickListener {
            dialog.dismiss()
        }
    }

}