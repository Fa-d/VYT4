package dev.faddy.vyt1.di

import android.app.Application
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.haroldadmin.cnradapter.NetworkResponseAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.faddy.vyt1.BuildConfig
import dev.faddy.vyt1.interfaces.ApiService
import dev.faddy.vyt1.utils.Constants
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Provides
    @Singleton
    fun getGson(): Gson {
        return GsonBuilder().setLenient().setPrettyPrinting().create()
    }

    @Provides
    @Singleton
    fun createCache(application: Application): Cache {
        val cacheSize = 5L * 1024L * 1024L //5MB
        return Cache(File(application.cacheDir, "${application.packageName}.cache"), cacheSize)
    }

    @Provides
    @Singleton
    fun createOkHttpClient(cache: Cache?): OkHttpClient {
        return OkHttpClient.Builder().apply {
            if (BuildConfig.DEBUG) {
                val httpLoggingInterceptor = HttpLoggingInterceptor()
                val logging = httpLoggingInterceptor.apply {
                    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
                }
                addInterceptor(logging)
            }
            cache(cache)
            readTimeout(30, TimeUnit.SECONDS)
            writeTimeout(1, TimeUnit.MINUTES)
            connectTimeout(30, TimeUnit.SECONDS)
        }.build()
    }

    private fun retrofitInstance(baseUrl: String, gson: Gson, httpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(NetworkResponseAdapterFactory()).baseUrl(baseUrl)
            .client(httpClient).build()
    }


    @Provides
    @Named("apiBase")
    fun provideBaseUrl() = Constants.BASE_URL

    @Provides
    @Singleton
    fun provideRetrofitInstance(
        @Named("apiBase") BASE_URL: String, gson: Gson, httpClient: OkHttpClient
    ): ApiService = retrofitInstance(
        baseUrl = BASE_URL, gson, httpClient
    ).create(ApiService::class.java)


}