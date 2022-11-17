package dev.faddy.vyt1.fragments.transactions

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.faddy.vyt1.databinding.ItemviewTransactionsDashboardBinding

class TransactionsDashboardAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var datalist: MutableList<String> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(
            ItemviewTransactionsDashboardBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolder) {
            val model = datalist[position]
            val binding = holder.binding
            binding.cusNameText.text = model
        }
    }

    override fun getItemCount() = datalist.size

    internal inner class ViewHolder(val binding: ItemviewTransactionsDashboardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            /* binding.llRootMain.setOnClickListener {
                 if (absoluteAdapterPosition != RecyclerView.NO_POSITION) {
                     if (binding.rvSearchChild.visibility == View.VISIBLE) {
                         binding.rvSearchChild.visibility = View.GONE
                     } else {
                         binding.rvSearchChild.visibility = View.VISIBLE
                     }
                 }
             }*/
        }
    }

    fun intiData(dataP: MutableList<String>) {
        datalist.clear()
        datalist.addAll(dataP)
        notifyDataSetChanged()
    }
}