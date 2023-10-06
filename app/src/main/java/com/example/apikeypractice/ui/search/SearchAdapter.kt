package com.example.apikeypractice.ui.search

import android.service.autofill.UserData
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.apikeypractice.R
import com.example.apikeypractice.data.model.searchusers.ItemModel
import com.example.apikeypractice.databinding.ItemSearchBinding

class SearchAdapter(
    private val userData: List<ItemModel?>?,
    private val function: (item: ItemModel) -> Unit,
) : RecyclerView.Adapter<SearchAdapter.CustomViewHolder>() {
    inner class CustomViewHolder(val view: View) :RecyclerView.ViewHolder(view){
        val binding = ItemSearchBinding.bind(view)

        fun setupUI(searchData: ItemModel, position: Int) {
            binding.searchName.text = searchData.login
            Glide.with(itemView.context)
                .load(searchData.avatarUrl)
                .error(R.drawable.ic_dashboard_black_24dp)
                .placeholder(R.drawable.ic_dashboard_black_24dp)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(binding.searchImage)
    }
}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
        = CustomViewHolder (
            LayoutInflater.from(parent.context).inflate(R.layout.item_search, parent, false)
        )

    override fun getItemCount() = userData?.size ?:0


    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val senderData = userData?.get(position)
        if (senderData != null) {
            holder.setupUI(senderData, position)
        }

        holder.itemView.setOnClickListener {
            if (senderData != null) {
                function.invoke(senderData)
            }
        }
    }
    }
