package com.hellodiffa.cabaca.ui.adapter

import com.hellodiffa.cabaca.R
import com.hellodiffa.cabaca.data.local.entity.book.BookEntity
import com.hellodiffa.cabaca.databinding.ItemBookBinding
import com.hellodiffa.cabaca.ui.base.BaseAdapter
import com.hellodiffa.cabaca.ui.base.BaseViewHolder

class BookAdapter(private val onChildClick: OnChildClick) : BaseAdapter<BookEntity, BookAdapter.Holder, ItemBookBinding>() {


    override fun instantiateViewHolder(binding: ItemBookBinding): Holder = Holder(binding)

    override fun getLayoutResourceId(): Int = R.layout.item_book

    inner class Holder(private val binding: ItemBookBinding) :
        BaseViewHolder<BookEntity>(binding) {
        override fun onBind(item: BookEntity) = binding.apply {
            data = item
            cardItemBook.setOnClickListener {
                onChildClick(item)
            }
            executePendingBindings()
        }

    }

}

typealias OnChildClick = (BookEntity) -> Unit