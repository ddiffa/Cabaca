package com.hellodiffa.cabaca.ui.feature.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.hellodiffa.cabaca.R
import com.hellodiffa.cabaca.common.ResultState
import com.hellodiffa.cabaca.data.local.entity.book.BookEntity
import com.hellodiffa.cabaca.data.local.entity.genre.GenreEntity
import com.hellodiffa.cabaca.databinding.FragmentMenuBinding
import com.hellodiffa.cabaca.ui.adapter.BookAdapter
import com.hellodiffa.cabaca.ui.adapter.GenreAdapter
import com.hellodiffa.cabaca.ui.base.BaseFragmentBinding
import com.hellodiffa.cabaca.utils.logDebbug
import com.hellodiffa.cabaca.utils.toast
import kotlinx.android.synthetic.main.fragment_menu.*
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MenuFragment : BaseFragmentBinding() {
    private lateinit var binding: FragmentMenuBinding
    private lateinit var viewModel: MenuViewModel
    private lateinit var genreAdapter: GenreAdapter
    private lateinit var bookAdapter: BookAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        genreAdapter = GenreAdapter(this::onChildGenreClick)
        bookAdapter = BookAdapter(this::onChildBookClick)
        viewModel = getViewModel()
        binding = binding<FragmentMenuBinding>(inflater, R.layout.fragment_menu, container).apply {
            lifecycleOwner = this@MenuFragment
            adapterGenre = genreAdapter
            adapterBook = bookAdapter

            rvGenresMenu.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            rvNewBookMenu.layoutManager = GridLayoutManager(context, 2)
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        observeGenre()
        observeBook()
    }

    private fun onChildBookClick(item: BookEntity) {
        val action = MenuFragmentDirections.actionMenuFragmentToBookDetailFragment(item.id.toString())
        findNavController().navigate(action)
    }

    private fun onChildGenreClick(item: GenreEntity) {
        val action =
            MenuFragmentDirections.actionMenuFragmentToListBookFragment(item.genreId.toString())
        findNavController().navigate(action)
    }

    private fun observeBook() {
        viewModel.books.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                ResultState.Status.SUCCESS -> {
                    if (it.data != null) bookAdapter.dataSource = it.data
                    loadingBooksVisible(false)
                    viewBooksVisible(false)
                }
                ResultState.Status.ERROR -> {
                    loadingBooksVisible(false)
                    viewBooksVisible(false)
                    context?.toast(it.message.toString())
                    activity?.logDebbug(it.message.toString())
                }

                ResultState.Status.LOADING -> {
                    loadingBooksVisible(true)
                    viewBooksVisible(true)
                }
            }
        })
    }

    private fun observeGenre() {
        viewModel.genres.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                ResultState.Status.SUCCESS -> {
                    if (it.data != null) genreAdapter.dataSource = it.data
                    loadingGenreVisible(false)
                    viewGenreVisible(false)
                }
                ResultState.Status.ERROR -> {
                    loadingGenreVisible(false)
                    viewGenreVisible(false)
                    context?.toast(it.message.toString())
                    activity?.logDebbug(it.message.toString())
                }

                ResultState.Status.LOADING -> {
                    loadingGenreVisible(true)
                    viewGenreVisible(true)
                }
            }
        })
    }

    private fun loadingBooksVisible(isLoading: Boolean) {
        if (isLoading) rvNewBookMenu.visibility = View.GONE
        else rvNewBookMenu.visibility = View.VISIBLE
    }

    private fun viewBooksVisible(isLoading: Boolean) {
        if (isLoading) shimmerLayoutBooksMenu.visibility = View.VISIBLE
        else shimmerLayoutBooksMenu.visibility = View.GONE
    }

    private fun loadingGenreVisible(isLoading: Boolean) {
        if (isLoading) rvGenresMenu.visibility = View.GONE
        else rvGenresMenu.visibility = View.VISIBLE
    }

    private fun viewGenreVisible(isLoading: Boolean) {
        if (isLoading) shimmerLayoutGenresMenu.visibility = View.VISIBLE
        else shimmerLayoutGenresMenu.visibility = View.GONE
    }

    override fun onDestroyView() {
        super.onDestroyView()
        if (binding.root.parent != null){
            (binding.root.parent as ViewGroup).removeView(binding.root)
        }
    }

}