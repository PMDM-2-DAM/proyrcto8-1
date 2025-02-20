package dam.moviles.proyecto_8_1.modelo

import retrofit2.http.GET
import retrofit2.http.Query

interface NombresApi {
    @GET(".")
    suspend fun consultarNombre(
        @Query("name") name:String
    ):Nombre
}