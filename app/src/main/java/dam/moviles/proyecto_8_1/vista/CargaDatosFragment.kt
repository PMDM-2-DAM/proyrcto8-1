package dam.moviles.proyecto_8_1.vista

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import dam.moviles.proyecto_8_1.R
import dam.moviles.proyecto_8_1.modelo.Nombre
import dam.moviles.proyecto_8_1.modelo.NombresApi
import dam.moviles.proyecto_8_1.modelo.NombresRepository
import dam.moviles.proyecto_8_1.modelo.Pais
import kotlinx.coroutines.launch
import kotlin.concurrent.thread

class CargaDatosFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        conseguirDatos()
        return inflater.inflate(R.layout.fragment_carga_datos, container, false)
    }

    fun conseguirDatos() {
        val nombre:String = CargaDatosFragmentArgs.fromBundle(requireArguments()).nombre
        lifecycleScope.launch {
            val nombre:Nombre = NombresRepository().consultarNombre(nombre)

            val nav: NavController = findNavController()
            val flecha = CargaDatosFragmentDirections.actionCargaDatosFragmentToResultadoFragment(nombre)
            nav.navigate(flecha)
        }
    }
}