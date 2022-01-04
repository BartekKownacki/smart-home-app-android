package pl.inzynierka.smarthome_moblie_android.ui.base

import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.lifecycleScope

abstract class BaseFragment() : Fragment(), BaseContract.View {

    override fun showMessage(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_LONG).show()
    }

    override fun showMessage(stringResId: Int) {
        Toast.makeText(activity, stringResId, Toast.LENGTH_LONG).show()
    }

    override fun getLifecycleScope(): LifecycleCoroutineScope {
        return lifecycleScope
    }
}