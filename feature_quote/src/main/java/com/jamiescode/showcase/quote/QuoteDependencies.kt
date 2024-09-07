package com.jamiescode.showcase.quote

import com.jamiescode.showcase.quote.data.datasource.api.service.QuoteRetrofitService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object QuoteDependencies {
    @Singleton
    @Provides
    @QuoteQualifier
    fun provideRetrofit(
        @QuoteQualifier okHttpClient: OkHttpClient,
    ): Retrofit =
        Retrofit
            .Builder()
            .baseUrl("https://zenquotes.io/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

    @Singleton
    @Provides
    @QuoteQualifier
    fun provideOkHttpClient(): OkHttpClient =
        OkHttpClient
            .Builder()
            .addInterceptor(
                HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY),
            ).build()

    @Singleton
    @Provides
    @QuoteQualifier
    fun provideQuoteRetrofitService(
        @QuoteQualifier retrofit: Retrofit,
    ): QuoteRetrofitService =
        retrofit.create(
            QuoteRetrofitService::class.java,
        )
}
