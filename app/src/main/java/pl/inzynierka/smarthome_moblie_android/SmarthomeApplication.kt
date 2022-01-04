package pl.inzynierka.smarthome_moblie_android

import android.app.Application
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import io.paperdb.Paper
import org.koin.core.context.startKoin
import pl.inzynierka.smarthome_moblie_android.di.apiModule
import pl.inzynierka.smarthome_moblie_android.di.gsonModule
import pl.inzynierka.smarthome_moblie_android.di.retrofitModule
import pl.inzynierka.smarthome_moblie_android.ui.splashscreen.splashscreenModule

class SmarthomeApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            this@SmarthomeApplication
            modules(
                listOf(
                    splashscreenModule,
                    retrofitModule,
                    apiModule,
                    gsonModule,
//                    dashboardModule,
//                    loginModule,
//                    registerModule,
//                    settingsModule,
//                    animationModule,
//                    overviewModule,
//                    changeMobileNameModule,
//                    chartsManagerModule,
//                    changeRelayModule,
//                    chartsModule,
//                    forgotPasswordModule,
//                    changePasswordModule
                )
            )
        }

        Paper.init(this)

        Logger.addLogAdapter(AndroidLogAdapter())
        Logger.d("SmarthomeApplication initialized!")
    }
}
