package com.jamiescode.showcase.quote.domain.usecase

import com.jamiescode.showcase.quote.data.QuoteRepository
import com.jamiescode.showcase.quote.domain.model.Quote
import java.io.IOException
import javax.inject.Inject

class GetQuoteUseCase
    @Inject
    constructor(
        private val quoteRepository: QuoteRepository,
    ) {
        sealed class Result {
            data class Success(
                val quote: Quote,
            ) : Result()

            data class Error(
                val e: Throwable,
            ) : Result()
        }

        suspend fun execute(): Result =
            try {
                val quotes = quoteRepository.getQuotes()
                quotes.firstOrNull()?.let { quote ->
                    Result.Success(quote)
                } ?: Result.Error(Exception("No quote found"))
            } catch (e: IOException) {
                Result.Error(e)
            }
    }
