package com.hellodiffa.cabaca.ui.feature.bookdetail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.hellodiffa.cabaca.R
import com.hellodiffa.cabaca.common.ResultState
import com.hellodiffa.cabaca.databinding.ActivityDetailBookBinding
import com.hellodiffa.cabaca.ui.base.BaseActivityBinding
import com.hellodiffa.cabaca.utils.toast
import kotlinx.android.synthetic.main.item_shimmer_grid_layout.*
import org.koin.android.ext.android.inject

class DetailBookActivity : AppCompatActivity() {
    private val viewModel : BookDetailViewModel by inject()
    private lateinit var binding : ActivityDetailBookBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail_book)
        binding.apply {
            lifecycleOwner =this@DetailBookActivity

        }
        applicationContext.toast(intent.getStringExtra("bookId"))
        viewModel.getBookDetail(intent.getStringExtra("bookId"))
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
                    applicationContext?.toast(it.message.toString())
                }

                ResultState.Status.LOADING -> {
                    loadingVisible(true)
                }
            }
        })
    }

    private fun loadingVisible(isLoading: Boolean) {

    }

    private fun observeBook() {

    }

}