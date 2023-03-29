package com.my.sealedmultipleitemrecyclerview.viewlayer

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.my.sealedmultipleitemrecyclerview.R
import com.my.sealedmultipleitemrecyclerview.model.view.UIModel


class MultiViewRecyclerAdapter(
    private val context: Context,
    private var arrayList: ArrayList<UIModel> = ArrayList()
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun getItemCount(): Int = arrayList.size

    override fun getItemViewType(position: Int) = when (arrayList[position]) {
        is UIModel.ItemOne -> R.layout.item_view_1
        is UIModel.ItemTwo -> R.layout.item_view_2
        is UIModel.ItemThree -> R.layout.item_view_3
        else -> R.layout.item_view_loader
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val v = layoutInflater.inflate(viewType, parent, false)
        return when (viewType) {
            R.layout.item_view_1 -> ItemOneViewHolder(v)
            R.layout.item_view_2 -> ItemTwoViewHolder(v)
            R.layout.item_view_3 -> ItemThreeViewHolder(v)
            else -> throw IllegalStateException("Unknown view")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val item = arrayList[position]
        when (holder) {
            is ItemOneViewHolder -> holder.onBindView(item as UIModel.ItemOne)
            is ItemTwoViewHolder -> holder.onBindView(item as UIModel.ItemTwo)
            is ItemThreeViewHolder -> holder.onBindView(item as UIModel.ItemThree)
        }

    }

    class ItemOneViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textView = itemView.findViewById<TextView>(R.id.textView)

        fun onBindView(item: UIModel.ItemOne) {
            textView.text = item.title
        }
    }

    class ItemTwoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textView = itemView.findViewById<TextView>(R.id.textView)
        fun onBindView(item: UIModel.ItemTwo) {
            textView.text = item.title
        }

    }

    class ItemThreeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textView = itemView.findViewById<TextView>(R.id.textView)
        fun onBindView(item: UIModel.ItemThree) {
            textView.text = item.title

        }

    }

}