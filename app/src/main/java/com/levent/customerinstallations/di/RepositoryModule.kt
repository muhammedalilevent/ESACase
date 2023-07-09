package com.levent.customerinstallations.di


import com.levent.customerinstallations.data.repository.InvoiceRepositoryImpl
import com.levent.customerinstallations.domain.repository.InvoiceRepository
import com.levent.customerinstallations.domain.source.ApiDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideInvoiceRepository(
        apiDataSource: ApiDataSource
    ): InvoiceRepository = InvoiceRepositoryImpl(apiDataSource)
}