package com.levent.customerinstallations.domain.repository

import com.levent.customerinstallations.data.model.UserInvoices

interface InvoiceRepository {
    suspend fun getUserInvoices(): UserInvoices
}