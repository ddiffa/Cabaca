package com.hellodiffa.cabaca.ui.adapter

import com.hellodiffa.cabaca.R
import com.hellodiffa.cabaca.data.remote.response.detailwriter.KaryaItem
import com.hellodiffa.cabaca.databinding.ItemCreationBinding
import com.hellodiffa.cabaca.ui.base.BaseAdapter
import com.hellodiffa.cabaca.ui.base.BaseViewHolder

class CreationAdapter(private val onChildClick: OnChildCreationClick) :
    BaseAdapter<KaryaItem, CreationAdapter.Holder, ItemCreationBinding>() {


    override fun instantiateViewHolder(binding: ItemCreationBinding): Holder = Holder(binding)

    override fun getLayoutResourceId(): Int = R.layout.item_creation

    inner class Holder(private val binding: ItemCreationBinding) :
        BaseViewHolder<KaryaItem>(binding) {
        override fun onBind(item: KaryaItem) = binding.apply {
            data = item
            cardItemBook.setOnClickListener {
                onChildClick(item)
            }
            executePendingBindings()
        }

    }

}

typealias OnChildCreationClick = (KaryaItem) -> Unit