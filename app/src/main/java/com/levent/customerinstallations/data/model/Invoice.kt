package com.levent.customerinstallations.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Invoice(
    val amount: String,
    val currency: String,
    val documentNumber: String,
    val dueDate: String,
    val installationNumber: String,
    val legacyContractAccountNumber: String
) : Parcelable