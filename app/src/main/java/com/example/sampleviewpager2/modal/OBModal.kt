package com.example.sampleviewpager2.modal

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class OBModal(
    var image: Int = 0,
    var title: String = "",
    var desc: String = ""
): Parcelable
