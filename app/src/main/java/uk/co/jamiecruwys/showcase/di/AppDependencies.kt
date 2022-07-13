package uk.co.jamiecruwys.showcase.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uk.co.jamiecruwys.showcase.data.retrofit.service.DogImageRetrofitService
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppDependencies {

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl("https://random.dog/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(
            HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY)
        )
        .build()

    @Singleton
    @Provides
    fun provideDogImageRetrofitService(retrofit: Retrofit): DogImageRetrofitService =
        retrofit.create(DogImageRetrofitService::class.java)
}
