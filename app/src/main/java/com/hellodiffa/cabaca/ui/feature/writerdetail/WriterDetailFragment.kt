package com.hellodiffa.cabaca.ui.feature.writerdetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.hellodiffa.cabaca.R
import com.hellodiffa.cabaca.ui.feature.bookdetail.BookDetailFragmentArgs
import com.hellodiffa.cabaca.ui.feature.bookdetail.BookDetailViewModel
import org.koin.android.ext.android.inject


class WriterDetailFragment : Fragment() {

    private val viewModel: BookDetailViewModel by inject()
    private val args: BookDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_blank, container, false)
    }


}