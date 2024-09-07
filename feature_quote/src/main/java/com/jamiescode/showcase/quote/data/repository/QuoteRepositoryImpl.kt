package com.jamiescode.showcase.quote.data.repository

import com.jamiescode.showcase.quote.FeatureQuote
import com.jamiescode.showcase.quote.data.datasource.api.response.toDomainModel
import com.jamiescode.showcase.quote.data.datasource.api.service.QuoteRetrofitService
import com.jamiescode.showcase.quote.domain.model.Quote
import com.jamiescode.showcase.quote.domain.repository.QuoteRepository
import javax.inject.Inject

class QuoteRepositoryImpl
    @Inject
    constructor(
        @FeatureQuote private val service: QuoteRetrofitService,
    ) : QuoteRepository {
        override suspend fun getQuotes(): List<Quote> = service.getQuote().toDomainModel()
    }
