package com.jamiescode.showcase.quote.domain.repository

import com.jamiescode.showcase.quote.domain.model.Quote

interface QuoteRepository {
    suspend fun getQuotes(): List<Quote>
}
