package pl.inzynierka.smarthome_moblie_android.data.network.modules

import io.paperdb.Paper

class AuthToken : TokenManager {

    private val tokenKey = "authToken"

    private var token: String
        get() = Paper.book().read(tokenKey) ?: ""
        set(value) {
            Paper.book().write(tokenKey, value)
        }

    override fun getUserToken(): String = token

    override fun isLogged(): Boolean = this.token.isNotEmpty()

    override fun loginUser(token: String) {
        this.token = token
    }

    override fun logoutUser() {
        this.token = ""
    }
}