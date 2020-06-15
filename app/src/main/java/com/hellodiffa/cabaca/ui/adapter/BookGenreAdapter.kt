package com.hellodiffa.cabaca.ui.adapter

import com.hellodiffa.cabaca.R
import com.hellodiffa.cabaca.data.remote.response.bookbygenre.ResultItem
import com.hellodiffa.cabaca.databinding.ItemListBookBinding
import com.hellodiffa.cabaca.ui.base.BaseAdapter
import com.hellodiffa.cabaca.ui.base.BaseViewHolder

class BookGenreAdapter(private val onListChildClick: OnListChildClick) :
    BaseAdapter<ResultItem, BookGenreAdapter.Holder, ItemListBookBinding>() {


    override fun instantiateViewHolder(binding: ItemListBookBinding): Holder = Holder(binding)

    override fun getLayoutResourceId(): Int = R.layout.item_list_book

    inner class Holder(private val binding: ItemListBookBinding) :
        BaseViewHolder<ResultItem>(binding) {
        override fun onBind(item: ResultItem) = binding.apply {
            data = item
            cardItemListBook.setOnClickListener {
                onListChildClick(item)
            }
            executePendingBindings()
        }

    }

}

typealias OnListChildClick = (ResultItem) -> Unit