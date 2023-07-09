package com.levent.customerinstallations.domain.source

import com.levent.customerinstallations.data.model.UserInvoices

interface ApiDataSource {
    suspend fun getUserInvoices(): UserInvoices
}