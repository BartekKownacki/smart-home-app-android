package pl.inzynierka.smarthome_moblie_android.di

import org.koin.core.scope.Scope
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {
//    single { provideMetersService() }
//    single { provideUserService() }
}

//private fun Scope.provideMetersService(): MetersService {
//    return get<Retrofit>().create(MetersService::class.java)
//}
//
//private fun Scope.provideUserService(): UserService {
//    return get<Retrofit>().create(UserService::class.java)
//}