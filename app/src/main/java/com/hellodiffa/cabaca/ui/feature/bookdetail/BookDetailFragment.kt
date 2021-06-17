package com.hellodiffa.cabaca.ui.feature.bookdetail

import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.hellodiffa.cabaca.R
import com.hellodiffa.cabaca.common.ResultState
import com.hellodiffa.cabaca.databinding.FragmentBookDetailBinding
import com.hellodiffa.cabaca.ui.base.BaseDialogFragmentBinding
import com.hellodiffa.cabaca.utils.toast
import kotlinx.android.synthetic.main.fragment_book_detail.*
import org.koin.androidx.viewmodel.ext.android.getViewModel

class BookDetailFragment : BaseDialogFragmentBinding() {
    private lateinit var binding: FragmentBookDetailBinding
    private lateinit var viewModel: BookDetailViewModel
    private val args: BookDetailFragmentArgs by navArgs()
    private lateinit var idWriter: String
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = getViewModel()
        binding = binding<FragmentBookDetailBinding>(
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
        viewModel.getBookDetail(args.bookid)

        binding.detailsToolbar.setNavigationOnClickListener {
            activity?.onBackPressed()
        }

        observeDetail()
        binding.tvWriterDetail.setOnClickListener {
            val action =
                BookDetailFragmentDirections.actionBookDetailFragmentToWriterDetailFragment(writerid = binding.data?.writerByWriterId?.userId.toString())
            findNavController().navigate(action)
        }
    }


    private fun observeDetail() {
        viewModel.books.observe(this, Observer {
            when (it.status) {
                ResultState.Status.SUCCESS -> {
                    binding.data = it.data?.result
                    idWriter = it.data?.result?.writerId.toString()
                    binding.sinopsis = Html.fromHtml(it.data?.result?.synopsis).toString()
                    content.visibility = View.VISIBLE
                    loadingVisible(false)
                }

                ResultState.Status.ERROR -> {
                    content.visibility = View.VISIBLE
                    loadingVisible(false)
                    context?.toast(it.message.toString())
                }

                ResultState.Status.LOADING -> {
                    content.visibility = View.GONE
                    loadingVisible(true)
                }
            }
        })
    }

    private fun loadingVisible(isLoading: Boolean) {
        if (isLoading) progressBar_detail.visibility = View.VISIBLE
        else progressBar_detail.visibility = View.GONE
    }

    override fun getTheme(): Int = R.style.AppTheme


    override fun onDestroyView() {
        super.onDestroyView()
        if (binding.root.parent != null) {
            (binding.root.parent as ViewGroup).removeView(binding.root)
        }
    }
}