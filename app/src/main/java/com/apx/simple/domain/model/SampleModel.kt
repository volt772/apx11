package com.apx.simple.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SampleModel(
    val id: Long,
    val name: String,
    val iconResName: String
) : Parcelable