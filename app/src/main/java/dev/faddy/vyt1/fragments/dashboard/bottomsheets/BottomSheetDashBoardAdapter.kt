package dev.faddy.vyt1.fragments.dashboard.bottomsheets

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import dev.faddy.vyt1.databinding.ItemViewBottomsheetItemsBinding

class BottomSheetDashBoardAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var datalist: MutableList<DashBoardBottomSheetFragment.ItemDetailsHolder> =
        mutableListOf()
    var onItemClicked: ((item: String) -> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(
            ItemViewBottomsheetItemsBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolder) {
            val model = datalist[position]
            val binding = holder.binding
            binding.itemTV.text = model.itemText
            binding.imageOfItem.setImageDrawable(
                ContextCompat.getDrawable(
                    binding.root.context, model.itemResId
                )
            )
        }
    }

    override fun getItemCount() = datalist.size

    internal inner class ViewHolder(val binding: ItemViewBottomsheetItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                if (absoluteAdapterPosition != RecyclerView.NO_POSITION) {
                    onItemClicked?.invoke(datalist[absoluteAdapterPosition].itemText)
                }
            }
        }
    }

    fun intiData(dataP: MutableList<DashBoardBottomSheetFragment.ItemDetailsHolder>) {
        datalist.clear()
        datalist.addAll(dataP)
        notifyDataSetChanged()
    }
}