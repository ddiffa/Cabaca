package com.hellodiffa.cabaca.ui.base

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<in DS>(private val DB: ViewDataBinding) : RecyclerView.ViewHolder(DB.root) {

    abstract fun onBind(item : DS) : ViewDataBinding
}