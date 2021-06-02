package martialcoder.surajsahani.turbocaretestassignment.Retrofit


import android.util.Log
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.util.concurrent.TimeUnit

class ApiClient {
    companion object{
        var BASE_URL = "https://test.turbocare.app/turbo/care/v1/"
        var retrofit: Retrofit?= null
        fun getClient(): Retrofit?{
            val logging =
                HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
                    override fun log(message: String) {
                        Log.d("Data", "log: $message")
                    }
                })
            logging.setLevel(HttpLoggingInterceptor.Level.BASIC)

            val client: OkHttpClient = OkHttpClient.Builder()
                .connectTimeout(1, TimeUnit.MINUTES)
                .readTimeout(1, TimeUnit.MINUTES)
                .writeTimeout(2, TimeUnit.MINUTES)
                .addInterceptor(object : Interceptor {
                    @Throws(IOException::class)
                    override fun intercept(chain: Interceptor.Chain): Response {
                        val newRequest: Request = chain.request().newBuilder()
                            .addHeader("security_key", "loop@0001") //  .addHeader("X-localization", "en")
                            .build()
                        return chain.proceed(newRequest)
                    }
                })
                .addInterceptor(logging).build()
            if (retrofit == null){
                retrofit = Retrofit.Builder().baseUrl(BASE_URL).client(client).addConverterFactory(
                    GsonConverterFactory.create()).build()
            }
            return retrofit
        }
    }
}