package com.jamiescode.showcase.quote.data

import com.jamiescode.showcase.quote.data.datasource.api.response.toDomainModel
import com.jamiescode.showcase.quote.data.datasource.api.service.QuoteRetrofitService
import com.jamiescode.showcase.quote.domain.model.Quote
import javax.inject.Inject

class QuoteRepositoryImpl
    @Inject
    constructor(
        private val service: QuoteRetrofitService,
    ) : QuoteRepository {
        override suspend fun getQuotes(): List<Quote> = service.getQuote().toDomainModel()
    }
