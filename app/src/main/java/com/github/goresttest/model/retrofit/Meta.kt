package com.github.goresttest.model.retrofit


import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Meta(
    val pagination: Pagination
):Parcelable