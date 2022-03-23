package com.ajgroup.challangebinarchapter3

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataParcelable(
    val price: Int,
    val qty: Int,
    val tax: Double,
    val total: Double
): Parcelable