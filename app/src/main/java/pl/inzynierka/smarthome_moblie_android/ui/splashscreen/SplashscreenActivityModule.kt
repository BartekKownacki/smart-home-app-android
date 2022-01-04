package pl.inzynierka.smarthome_moblie_android.ui.splashscreen

import org.koin.dsl.module

val splashscreenModule = module() {

    factory { SplashscreenActivityPresenter() }

}