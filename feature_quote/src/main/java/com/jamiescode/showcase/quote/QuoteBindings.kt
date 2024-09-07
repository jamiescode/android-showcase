package com.jamiescode.showcase.quote

import com.jamiescode.showcase.quote.domain.repository.QuoteRepository
import com.jamiescode.showcase.quote.data.repository.QuoteRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface QuoteBindings {
    @Binds
    fun quoteRepository(impl: QuoteRepositoryImpl): QuoteRepository
}
