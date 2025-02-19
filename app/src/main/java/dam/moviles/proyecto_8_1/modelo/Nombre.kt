package dam.moviles.proyecto_8_1.modelo

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.io.Serializable

@JsonClass(generateAdapter = true)
data class Nombre(
    @Json(name="count") val id:Int,
    val name:String,
    @Json(name = "country") val paises:List<Pais>
): Serializable
