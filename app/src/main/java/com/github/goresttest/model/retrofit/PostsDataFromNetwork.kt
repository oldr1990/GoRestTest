package com.github.goresttest.model.retrofit

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class PostsDataFromNetwork(
    val code: Int,
    val `data`: List<PostItemNetwork>,
    val meta: Meta
):Parcelable