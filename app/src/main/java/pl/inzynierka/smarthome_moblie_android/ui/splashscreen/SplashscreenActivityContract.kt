package pl.inzynierka.smarthome_moblie_android.ui.splashscreen

import pl.inzynierka.smarthome_moblie_android.ui.base.BaseContract

interface SplashscreenActivityContract {

    interface Presenter : BaseContract.Presenter<View> {

        fun onNavigateRequest()
    }

    interface View : BaseContract.View {

        fun navigateToLogin()
    }
}