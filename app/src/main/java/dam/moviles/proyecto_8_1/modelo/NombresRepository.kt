package dam.moviles.proyecto_8_1.modelo

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

class NombresRepository {
    val nombresApi:NombresApi
    init {
        nombresApi = Retrofit.Builder()
            .baseUrl("https://api.nationalize.io/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create()
    }
    suspend fun consultarNombre(name:String):Nombre = nombresApi.consultarNombre(name)
}