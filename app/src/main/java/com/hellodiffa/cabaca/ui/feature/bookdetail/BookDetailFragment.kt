package com.hellodiffa.cabaca.ui.feature.bookdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.hellodiffa.cabaca.R
import com.hellodiffa.cabaca.common.ResultState
import com.hellodiffa.cabaca.databinding.FragmentBookDetailBinding
import com.hellodiffa.cabaca.ui.base.BaseDialogFragmentBinding
import com.hellodiffa.cabaca.utils.toast
import org.koin.androidx.viewmodel.ext.android.getViewModel


class BookDetailFragment : BaseDialogFragmentBinding() {
    private lateinit var binding: FragmentBookDetailBinding
    private lateinit var viewModel: BookDetailViewModel
    private val args: BookDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = getViewModel()
        viewModel.getBookDetail(args.bookid)
        binding =
            binding<FragmentBookDetailBinding>(
                inflater,
                R.layout.fragment_book_detail,
                container
            ).apply {
                lifecycleOwner = this@BookDetailFragment
            }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeWriter()
    }

    private fun observeWriter() {
        viewModel.books.observe(this, Observer {
            when (it.status) {
                ResultState.Status.SUCCESS -> {
                    binding.data = it.data?.result
                    loadingVisible(false)
                }

                ResultState.Status.ERROR -> {
                    loadingVisible(false)
                    context?.toast(it.message.toString())
                }

                ResultState.Status.LOADING -> {
                    loadingVisible(true)
                }
            }
        })
    }

    private fun loadingVisible(isLoading: Boolean) {

    }

    override fun getTheme(): Int = R.style.AppTheme
}