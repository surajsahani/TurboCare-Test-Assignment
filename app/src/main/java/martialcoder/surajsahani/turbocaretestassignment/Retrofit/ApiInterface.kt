package martialcoder.surajsahani.turbocaretestassignment.Retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("makes")
    fun getMakers(@Query("class") classes: String): Call<ArrayList<String>>

    @GET("models")
    fun getModels(
        @Query("class") classes: String,
        @Query("make") make: String
    ): Call<ArrayList<String>>
}