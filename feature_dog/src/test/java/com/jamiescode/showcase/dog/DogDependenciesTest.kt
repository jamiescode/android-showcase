package com.jamiescode.showcase.dog

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import retrofit2.Retrofit

class DogDependenciesTest {
    @Test
    fun createRetrofit() {
        val retrofit = DogDependencies.provideRetrofit(OkHttpClient())
        assertEquals("https://random.dog/", retrofit.baseUrl().toString())
    }

    @Test
    fun createOkHttpClient() {
        val okHttpClient = DogDependencies.provideOkHttpClient()
        val interceptor = okHttpClient.interceptors.first()
        assertEquals(HttpLoggingInterceptor.Level.BODY, (interceptor as HttpLoggingInterceptor).level)
    }

    @Test
    fun createDogImageRetrofitService() {
        val retrofit = Retrofit.Builder().baseUrl("https://random.dog/").build()
        DogDependencies.provideDogImageRetrofitService(retrofit)
    }
}
