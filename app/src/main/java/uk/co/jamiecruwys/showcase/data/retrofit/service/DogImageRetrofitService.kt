package uk.co.jamiecruwys.showcase.data.retrofit.service

import retrofit2.http.GET
import uk.co.jamiecruwys.showcase.data.retrofit.response.DogImageResponse

interface DogImageRetrofitService {
    @GET("doggos")
    suspend fun getRandomImageAsync(): DogImageResponse?
}
