package com.levent.customerinstallations.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Location(
    val address: String,
    val amount: String,
    val company: String,
    val contractAccountNumber: String,
    val installationNumber: String
):Parcelable