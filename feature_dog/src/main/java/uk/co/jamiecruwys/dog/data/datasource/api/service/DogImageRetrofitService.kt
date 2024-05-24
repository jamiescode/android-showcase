package uk.co.jamiecruwys.dog.data.datasource.api.service

import retrofit2.http.GET
import uk.co.jamiecruwys.dog.data.datasource.api.response.DogImageResponse

interface DogImageRetrofitService {
    @GET("doggos")
    suspend fun getRandomImageAsync(): DogImageResponse?
}
