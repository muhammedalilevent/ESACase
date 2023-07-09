package com.levent.customerinstallations.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserInvoices(
    val invoices: List<Invoice>,
    val list: List<Location>,
    val totalPrice: String,
    val totalPriceCount: Int
) : Parcelable