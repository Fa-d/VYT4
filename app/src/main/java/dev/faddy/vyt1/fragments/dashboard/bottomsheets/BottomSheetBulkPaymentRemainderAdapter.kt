package dev.faddy.vyt1.fragments.dashboard.bottomsheets

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.faddy.vyt1.databinding.ItemViewBulkPaymentRecyclerItemsBinding

class BottomSheetBulkPaymentRemainderAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var datalist: MutableList<String> = mutableListOf()
    var onItemClicked: ((item: String) -> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(
            ItemViewBulkPaymentRecyclerItemsBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolder) {
            val model = datalist[position]
            val binding = holder.binding
            //  binding.itemTV.text = model
        }
    }

    override fun getItemCount() = datalist.size

    internal inner class ViewHolder(val binding: ItemViewBulkPaymentRecyclerItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                if (absoluteAdapterPosition != RecyclerView.NO_POSITION) {
                    onItemClicked?.invoke(datalist[absoluteAdapterPosition])
                }
            }
        }
    }

    fun intiData(dataP: MutableList<String>) {
        datalist.clear()
        datalist.addAll(dataP)
        notifyDataSetChanged()
    }
}