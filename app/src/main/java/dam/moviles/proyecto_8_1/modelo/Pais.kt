package dam.moviles.proyecto_8_1.modelo

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.io.Serializable

@JsonClass(generateAdapter = true)
data class Pais(
    @Json(name="country_id") val id:String,
    val probability:Double
):Serializable
