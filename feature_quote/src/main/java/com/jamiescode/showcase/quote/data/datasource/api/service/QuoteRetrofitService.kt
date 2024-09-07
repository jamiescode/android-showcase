package com.jamiescode.showcase.quote.data.datasource.api.service

import com.jamiescode.showcase.quote.data.datasource.api.response.QuoteResponse
import retrofit2.http.GET

interface QuoteRetrofitService {
    @GET("quotes")
    suspend fun getQuote(): QuoteResponse?
}
