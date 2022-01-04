package pl.inzynierka.smarthome_moblie_android.ui.splashscreen

import androidx.lifecycle.LifecycleObserver
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import pl.inzynierka.smarthome_moblie_android.ui.base.BasePresenter


class SplashscreenActivityPresenter : BasePresenter<SplashscreenActivityContract.View>(),
    SplashscreenActivityContract.Presenter, KoinComponent, LifecycleObserver {

    private val splashscreenDurationTime: Long = 1000

    override fun onNavigateRequest() {
        getView().getLifecycleScope().launch(Dispatchers.Default) {
            delay(splashscreenDurationTime)
            getView().navigateToLogin()
        }
    }
}