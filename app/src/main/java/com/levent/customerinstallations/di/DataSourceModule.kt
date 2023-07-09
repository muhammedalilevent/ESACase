package com.levent.customerinstallations.di

import com.levent.customerinstallations.data.source.Api
import com.levent.customerinstallations.data.source.ApiDataSourceImpl
import com.levent.customerinstallations.domain.source.ApiDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DataSourceModule {

    @Provides
    @Singleton
    fun providesWordsDataSource(api: Api): ApiDataSource =
        ApiDataSourceImpl(api)

}
