package pl.inzynierka.smarthome_moblie_android.di

import com.haroldadmin.cnradapter.NetworkResponseAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.scope.Scope
import org.koin.dsl.module
import pl.inzynierka.smarthome_moblie_android.data.network.modules.AuthToken
import pl.inzynierka.smarthome_moblie_android.data.network.modules.TokenInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private const val CONNECT_TIMEOUT = 15L
private const val WRITE_TIMEOUT = 15L
private const val READ_TIMEOUT = 15L

val retrofitModule = module {
    single { retrofitHttpClient() }
    single { retrofitBuilder() }
    single { loggingInterceptor() }
    single { AuthToken() }
}

private fun Scope.retrofitBuilder(): Retrofit {
    return Retrofit.Builder()
        //TODO zmienić adres
        .baseUrl("https://adresbackendu")
        .addConverterFactory(
            GsonConverterFactory.create(
                get()
            )
        )
        .addCallAdapterFactory(NetworkResponseAdapterFactory())
        .client(get())
        .build()
}

private fun Scope.retrofitHttpClient(): OkHttpClient {
    return OkHttpClient.Builder().apply {
        connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
        writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
        readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
        retryOnConnectionFailure(true)
        addInterceptor(TokenInterceptor())
        addInterceptor(get<HttpLoggingInterceptor>())
    }.build()
}

private fun loggingInterceptor(): HttpLoggingInterceptor {
    return HttpLoggingInterceptor().apply {
        setLevel(HttpLoggingInterceptor.Level.BASIC)
    }
}