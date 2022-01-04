package pl.inzynierka.smarthome_moblie_android.data.network.modules

interface TokenManager {

    companion object {

        const val AUTH_TOKEN_TYPE: String = "x-auth-token"
    }

    fun getUserToken(): String

    fun loginUser(token: String)

    fun logoutUser()

    fun isLogged(): Boolean
}