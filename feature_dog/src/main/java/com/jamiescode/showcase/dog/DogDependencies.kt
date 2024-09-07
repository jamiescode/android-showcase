package com.jamiescode.showcase.dog

import com.jamiescode.showcase.dog.data.datasource.api.service.DogImageRetrofitService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier
import javax.inject.Singleton

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class Dog

@InstallIn(SingletonComponent::class)
@Module
object DogDependencies {
    @Singleton
    @Provides
    @DogQualifier
    fun provideRetrofit(
        @DogQualifier okHttpClient: OkHttpClient,
    ): Retrofit =
        Retrofit
            .Builder()
            .baseUrl("https://random.dog/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

    @Singleton
    @Provides
    @DogQualifier
    fun provideOkHttpClient(): OkHttpClient =
        OkHttpClient
            .Builder()
            .addInterceptor(
                HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY),
            ).build()

    @Suppress("MaxLineLength")
    @Singleton
    @Provides
    @DogQualifier
    fun provideDogImageRetrofitService(
        @DogQualifier retrofit: Retrofit,
    ): DogImageRetrofitService =
        retrofit.create(
            DogImageRetrofitService::class.java,
        )
}
