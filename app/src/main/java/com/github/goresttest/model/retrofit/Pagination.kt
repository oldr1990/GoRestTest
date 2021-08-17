package com.github.goresttest.model.retrofit


import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Pagination(
    val limit: Int,
    val page: Int,
    val pages: Int,
    val total: Int
):Parcelable