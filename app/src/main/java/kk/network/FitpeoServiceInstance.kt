package kk.network

import kk.models.PhotoResponse
import retrofit2.Response
import retrofit2.http.GET

interface FitpeoServiceInstance {

    @GET("photos")
    suspend fun getProducts() : Response<PhotoResponse>
}