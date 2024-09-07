package com.jamiescode.showcase.dog.data.datasource.api.service

import retrofit2.http.GET
import com.jamiescode.showcase.dog.data.datasource.api.response.DogImageResponse

interface DogImageRetrofitService {
    @GET("doggos")
    suspend fun getRandomImageAsync(): DogImageResponse?
}
