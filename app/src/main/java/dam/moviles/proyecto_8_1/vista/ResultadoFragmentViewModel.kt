package dam.moviles.proyecto_8_1.vista

import androidx.lifecycle.ViewModel
import dam.moviles.proyecto_8_1.modelo.Pais

class ResultadoFragmentViewModel : ViewModel() {
    lateinit var paises:List<Pais>

    fun asignarPaises(p:List<Pais>) {
        paises = p
    }
}