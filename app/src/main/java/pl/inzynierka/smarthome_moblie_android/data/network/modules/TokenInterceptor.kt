package pl.inzynierka.smarthome_moblie_android.data.network.modules

import okhttp3.Interceptor
import okhttp3.Response
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class TokenInterceptor : Interceptor, KoinComponent {

    private val authToken: AuthToken by inject()

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        if (authToken.isLogged()) {
            val newRequest = request.newBuilder()
                .header(TokenManager.AUTH_TOKEN_TYPE, authToken.getUserToken())
                .build()
            return chain.proceed(newRequest)
        }

        return chain.proceed(request)
    }
}