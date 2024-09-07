package com.jamiescode.showcase.dog.data.datasource.api.service

import com.jamiescode.showcase.dog.data.datasource.api.response.DogImageResponse
import retrofit2.http.GET

interface DogImageRetrofitService {
    @GET("doggos")
    suspend fun getRandomImageAsync(): DogImageResponse?
}
