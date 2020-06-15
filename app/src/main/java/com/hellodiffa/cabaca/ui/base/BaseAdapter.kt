package com.hellodiffa.cabaca.ui.base
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<DS, VH : BaseViewHolder<DS>, DB : ViewDataBinding> :
    RecyclerView.Adapter<VH>() {


    var dataSource: List<DS> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    protected lateinit var mViewDataBinding: DB

    abstract fun instantiateViewHolder(binding: DB): VH

    @LayoutRes
    abstract fun getLayoutResourceId(): Int

    override fun getItemCount(): Int = dataSource.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val inflater = LayoutInflater.from(parent.context)
        mViewDataBinding =
            DataBindingUtil.inflate<DB>(inflater, getLayoutResourceId(), parent, false)
        return instantiateViewHolder(mViewDataBinding)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(getItem(position))
    }

    protected fun getItem(position : Int) = dataSource[position]

}