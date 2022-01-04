package pl.inzynierka.smarthome_moblie_android.ui.base

import androidx.annotation.StringRes
import androidx.lifecycle.LifecycleCoroutineScope

interface BaseContract {

    interface View {

        fun showMessage(@StringRes stringResId: Int)
        fun showMessage(message: String)
        fun showSnackbar(
            @StringRes message: Int,
            duration: Int,
            @StringRes actionName: Int,
            onClickAction: () -> Unit
        ) {
        }
        fun startLoading() {}
        fun stopLoading() {}
        fun getLifecycleScope(): LifecycleCoroutineScope
    }

    interface Presenter<V : View> {

        fun attachView(view: V)
        fun getView(): V
    }
}