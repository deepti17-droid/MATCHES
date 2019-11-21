package com.deepti.matches.network

import com.deepti.matches.network.BaseURL.Companion.HostAPI
import com.google.gson.Gson
import okhttp3.ConnectionSpec
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object WebServiceClient {
    private lateinit var interceptor: HttpLoggingInterceptor
    private lateinit var okHttpClient: OkHttpClient
    private var retrofit: Retrofit? = null

    val client: Retrofit
        get() {
            interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            okHttpClient = OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .connectionSpecs(
                        listOf(ConnectionSpec.MODERN_TLS,
                            ConnectionSpec.COMPATIBLE_TLS,
                            ConnectionSpec.CLEARTEXT)
                    )
                    .followRedirects(true)
                    .followSslRedirects(true)
                    .retryOnConnectionFailure(true)
                    .connectTimeout(30 * 3, TimeUnit.SECONDS)
                    .readTimeout(30 * 3, TimeUnit.SECONDS)
                    .writeTimeout(30 * 3, TimeUnit.SECONDS)
                    .cache(null)
                    .build()

            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                        .baseUrl(HostAPI)
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(okHttpClient)
                        .build()
            }
            return retrofit!!
        }

    fun <T> getArray(s: String, clazz: Class<T>): List<T> {
        val arr = Gson().fromJson(s, clazz)
        return listOf(arr)
    }

    fun <T> getObject(response: String, clazz: Class<T>): Any? {
        var model: Any? = null
        try {
            val jsonObject = JSONObject(response)
            model = Gson().fromJson(jsonObject.toString(), clazz)
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return model
    }
}
