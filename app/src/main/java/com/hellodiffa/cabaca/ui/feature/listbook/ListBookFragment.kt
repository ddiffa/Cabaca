package com.hellodiffa.cabaca.ui.feature.listbook

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.hellodiffa.cabaca.R
import com.hellodiffa.cabaca.common.ResultState
import com.hellodiffa.cabaca.data.remote.response.bookbygenre.ResultItem
import com.hellodiffa.cabaca.databinding.FragmentListBookBinding
import com.hellodiffa.cabaca.ui.adapter.BookGenreAdapter
import com.hellodiffa.cabaca.ui.base.BaseDialogFragmentBinding
import com.hellodiffa.cabaca.utils.toast
import kotlinx.android.synthetic.main.fragment_list_book.*
import org.koin.androidx.viewmodel.ext.android.getViewModel


class ListBookFragment : BaseDialogFragmentBinding() {
    private lateinit var binding: FragmentListBookBinding
    private lateinit var viewModel: ListBookViewModel
    private lateinit var bookAdapter: BookGenreAdapter
    private val args: ListBookFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bookAdapter = BookGenreAdapter(this::onChildBookClick)
        viewModel = getViewModel()
        viewModel.getBookByGenre(args.genreId)
        binding =
            binding<FragmentListBookBinding>(inflater, R.layout.fragment_list_book, container).apply {
                lifecycleOwner = this@ListBookFragment
                adapterBook = bookAdapter
                rvListBook.layoutManager = GridLayoutManager(context, 2)
            }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        observeBooks()
    }

    private fun observeBooks() {
        viewModel.books.observe(this, Observer {
            when (it.status) {
                ResultState.Status.SUCCESS -> {
                    if (it.data != null) bookAdapter.dataSource = it.data
                    loadingVisible(false)
                    viewVisible(false)
                }
                ResultState.Status.ERROR -> {
                    loadingVisible(false)
                    viewVisible(false)
                    context?.toast(it.message.toString())
                }

                ResultState.Status.LOADING -> {
                    loadingVisible(true)
                    viewVisible(true)
                }
            }
        })
    }

    private fun viewVisible(isLoading: Boolean) {
        if (isLoading) rvListBook.visibility = View.GONE
        else rvListBook.visibility = View.VISIBLE
    }

    private fun loadingVisible(isLoading: Boolean) {
        if (isLoading) shimmerLayoutList.visibility = View.VISIBLE
        else shimmerLayoutList.visibility = View.GONE
    }

    private fun onChildBookClick(item: ResultItem) {
        context?.toast("do Something")
    }


    override fun getTheme(): Int = R.style.AppTheme

}