package com.levent.customerinstallations.data.repository

import com.levent.customerinstallations.data.model.UserInvoices
import com.levent.customerinstallations.domain.repository.InvoiceRepository
import com.levent.customerinstallations.domain.source.ApiDataSource

class InvoiceRepositoryImpl(private val dataSource: ApiDataSource) : InvoiceRepository {
    override suspend fun getUserInvoices(): UserInvoices = dataSource.getUserInvoices()
}