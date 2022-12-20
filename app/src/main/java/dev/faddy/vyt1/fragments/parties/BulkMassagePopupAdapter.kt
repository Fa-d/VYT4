package dev.faddy.vyt1.fragments.parties

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.faddy.vyt1.databinding.ItemViewSendMessagesPartiesBinding

class BulkMassagePopupAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var shouldSelectAll = false

    private var datalist: MutableList<String> = mutableListOf()
    var onItemClicked: (() -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(
            ItemViewSendMessagesPartiesBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolder) {
            val model = datalist[position]
            val binding = holder.binding
            binding.cutomnerName.text = model
            binding.selectAllCheckBox.isChecked = shouldSelectAll
        }
    }

    override fun getItemCount() = datalist.size

    internal inner class ViewHolder(val binding: ItemViewSendMessagesPartiesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                if (absoluteAdapterPosition != RecyclerView.NO_POSITION) {
                    onItemClicked?.invoke()
                }
            }
        }
    }

    fun intiData(dataP: MutableList<String>) {
        datalist.clear()
        datalist.addAll(dataP)
        notifyDataSetChanged()
    }

    fun selectAll(isAllSelected: Boolean) {
        shouldSelectAll = isAllSelected
        notifyDataSetChanged()
    }
}