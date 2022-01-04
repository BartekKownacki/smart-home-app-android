package pl.inzynierka.smarthome_moblie_android.ui.splashscreen


import android.os.Bundle
import org.jetbrains.anko.intentFor
import org.koin.android.ext.android.inject
import pl.inzynierka.smarthome_moblie_android.R
import pl.inzynierka.smarthome_moblie_android.ui.base.BaseActivity
import pl.inzynierka.smarthome_moblie_android.ui.login.LoginActivity


class SplashscreenActivity : BaseActivity(), SplashscreenActivityContract.View {

    private val presenter: SplashscreenActivityPresenter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)
        presenter.attachView(this)
        presenter.onNavigateRequest()
    }

    override fun navigateToLogin() {
        startActivity(intentFor<LoginActivity>())
        finish()
    }
}