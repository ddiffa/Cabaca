package com.hellodiffa.cabaca.ui.feature.writerdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.hellodiffa.cabaca.R
import com.hellodiffa.cabaca.common.ResultState
import com.hellodiffa.cabaca.databinding.FragmentWriterDetailBinding
import com.hellodiffa.cabaca.ui.adapter.CreationAdapter
import com.hellodiffa.cabaca.ui.base.BaseDialogFragmentBinding
import com.hellodiffa.cabaca.utils.logDebbug
import com.hellodiffa.cabaca.utils.toast
import kotlinx.android.synthetic.main.fragment_writer_detail.*
import org.koin.android.ext.android.inject


class WriterDetailFragment : BaseDialogFragmentBinding() {

    private val viewModel: WriterViewModel by inject()
    private val args: WriterDetailFragmentArgs by navArgs()
    private lateinit var binding: FragmentWriterDetailBinding
    private lateinit var creationAdapter: CreationAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        creationAdapter = CreationAdapter {
            val action =
                WriterDetailFragmentDirections.actionWriterDetailFragmentToBookDetailFragment(it.id.toString())
            findNavController().navigate(action)
        }

        binding = binding<FragmentWriterDetailBinding>(
            inflater,
            R.layout.fragment_writer_detail,
            container
        ).apply {
            lifecycleOwner = this@WriterDetailFragment
            adapter = creationAdapter
            executePendingBindings()
            rvCreation.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getWriterDetail(args.writerid)

        observeWriter()
    }

    private fun observeWriter() {
        viewModel.writer.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                ResultState.Status.SUCCESS -> {
                    if (it.data != null) creationAdapter.dataSource = it.data.karya
                    binding.data = it.data
                    progressBar_writer.visibility = View.GONE
                }
                ResultState.Status.ERROR -> {
                    context?.toast(it.message.toString())
                    activity?.logDebbug(it.message.toString())
                    progressBar_writer.visibility = View.GONE
                }

                ResultState.Status.LOADING -> {
                    progressBar_writer.visibility = View.VISIBLE
                }
            }
        })
    }


    override fun getTheme(): Int = R.style.AppTheme


    override fun onDestroyView() {
        super.onDestroyView()
        if (binding.root.parent != null){
            (binding.root.parent as ViewGroup).removeView(binding.root)
        }
    }
}