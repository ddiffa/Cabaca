package com.hellodiffa.cabaca.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.hellodiffa.cabaca.R
import com.hellodiffa.cabaca.data.remote.ApiService


@BindingAdapter("loadImage")
fun bindLoadImage(view: ImageView, url: String?) {
    Glide.with(view.context)
        .load(
            "${ApiService.BASE_URL_IMAGE}${url?.replace(
                "%2F",
                "/"
            )}&api_key=32ded42cfffb77dee86a29f43d36a3641849d4b5904aade9a79e9aa6cd5b5948"
        )
        .placeholder(R.drawable.ic_launcher_background)
        .error(R.drawable.ic_launcher_background)
        .into(view)
}

@BindingAdapter("pict")
fun bindPictImage(view : ImageView, url:String?){
    Glide.with(view.context)
        .load(
            "${ApiService.BASE_URL_IMAGE}photo_profiles/38679-ami_shin.jpg?download=false&api_key=32ded42cfffb77dee86a29f43d36a3641849d4b5904aade9a79e9aa6cd5b5948"
        )
        .placeholder(R.drawable.ic_launcher_background)
        .error(R.drawable.ic_launcher_background)
        .into(view)
}