package com.ajgroup.challangebinarchapter3

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataParcelable(
    val name: String,
    val age: Int,
    val address: String,
    val job: String
): Parcelable