package pl.inzynierka.smarthome_moblie_android.ui.base

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.lifecycleScope
import org.jetbrains.anko.toast

abstract class BaseActivity : AppCompatActivity(), BaseContract.View {

    override fun showMessage(message: String) {
        toast(message)
    }

    override fun showMessage(stringResId: Int) {
        toast(stringResId)
    }

    override fun getLifecycleScope(): LifecycleCoroutineScope {
        return lifecycleScope
    }
}