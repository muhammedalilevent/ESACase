package com.levent.customerinstallations.data.source

import com.levent.customerinstallations.common.Constants.USER_INVOICES
import com.levent.customerinstallations.data.model.UserInvoices
import retrofit2.http.GET

interface Api {
    @GET(USER_INVOICES)
    suspend fun getUserInvoices(): UserInvoices
}