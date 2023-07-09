package com.levent.customerinstallations.data.source

import com.levent.customerinstallations.data.model.UserInvoices
import com.levent.customerinstallations.domain.source.ApiDataSource

class ApiDataSourceImpl(private val api: Api) : ApiDataSource {
    override suspend fun getUserInvoices(): UserInvoices = api.getUserInvoices()
}