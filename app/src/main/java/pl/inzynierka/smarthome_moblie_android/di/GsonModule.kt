package pl.inzynierka.smarthome_moblie_android.di

import com.google.gson.*
import org.koin.dsl.module
import org.threeten.bp.Instant
import org.threeten.bp.format.DateTimeFormatter
import java.lang.reflect.Type

val gsonModule = module {

    single { provideGson() }

}

private fun provideGson(): Gson {
    return GsonBuilder()
        .registerTypeAdapter(Instant::class.java, RetrofitDateSerializer())
        .registerTypeAdapter(Instant::class.java, RetrofitDateDeserializer())
        .setDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
        .create()
}

class RetrofitDateSerializer : JsonSerializer<Instant> {

    override fun serialize(
        srcDate: Instant?,
        typeOfSrc: Type?,
        context: JsonSerializationContext?
    ): JsonElement? {
        if (srcDate == null)
            return null
        val formatted = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'").format(srcDate)
        return JsonPrimitive(formatted)
    }
}

class RetrofitDateDeserializer : JsonDeserializer<Instant> {

    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): Instant {
        return Instant.parse(json?.asString)
    }
}