package uk.co.jamiecruwys.domain.retrofit

import retrofit2.http.GET

interface DogImageRetrofitService {
    @GET("doggos")
    suspend fun getRandomImageAsync(): DogImageResponse?
}
