package com.github.goresttest.model.retrofit


import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PostItemNetwork(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
):Parcelable