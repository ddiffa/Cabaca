package com.hellodiffa.cabaca.ui.adapter

import com.hellodiffa.cabaca.R
import com.hellodiffa.cabaca.data.local.entity.genre.GenreEntity
import com.hellodiffa.cabaca.databinding.ItemGenreBinding
import com.hellodiffa.cabaca.ui.base.BaseAdapter
import com.hellodiffa.cabaca.ui.base.BaseViewHolder

class GenreAdapter(private val onChildGenreClick: OnChildGenreClick) : BaseAdapter<GenreEntity, GenreAdapter.Holder, ItemGenreBinding>() {

    override fun instantiateViewHolder(binding: ItemGenreBinding): Holder = Holder(binding)

    override fun getLayoutResourceId(): Int = R.layout.item_genre

    inner class Holder(private val binding: ItemGenreBinding) :
        BaseViewHolder<GenreEntity>(binding) {
        override fun onBind(item: GenreEntity) = binding.apply {
            data = item
            parentGenreItem.setOnClickListener {
                onChildGenreClick(item)
            }
            executePendingBindings()
        }

    }

}

typealias OnChildGenreClick = (GenreEntity) -> Unit