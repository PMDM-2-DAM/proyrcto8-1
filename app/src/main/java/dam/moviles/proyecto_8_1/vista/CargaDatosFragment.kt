package dam.moviles.proyecto_8_1.vista

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import dam.moviles.proyecto_8_1.R
import dam.moviles.proyecto_8_1.databinding.FragmentCargaDatosBinding
import dam.moviles.proyecto_8_1.databinding.FragmentInicioBinding
import dam.moviles.proyecto_8_1.modelo.Nombre
import dam.moviles.proyecto_8_1.modelo.NombresApi
import dam.moviles.proyecto_8_1.modelo.NombresRepository
import dam.moviles.proyecto_8_1.modelo.Pais
import kotlinx.coroutines.launch
import kotlin.concurrent.thread

class CargaDatosFragment : Fragment() {
    var _binding: FragmentCargaDatosBinding? = null
    val binding: FragmentCargaDatosBinding
        get() = checkNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        inicializarBinding(inflater,container)
        cargarDatos()
        return binding.root
    }

    fun cargarDatos() {
        val nombre:String = CargaDatosFragmentArgs.fromBundle(requireArguments()).nombre
        lifecycleScope.launch {
            try {
                val nombre:Nombre = NombresRepository().consultarNombre(nombre)

                val nav: NavController = findNavController()
                val flecha = CargaDatosFragmentDirections.actionCargaDatosFragmentToResultadoFragment(nombre)
                nav.navigate(flecha)
            } catch (e:Exception) {
                Toast.makeText(
                    requireContext(),
                    "No se han podido cargar los datos de forma correcta:\n" + e.message,
                    Toast.LENGTH_SHORT).show()
            }

        }
    }

    private fun inicializarBinding(inflater: LayoutInflater,container: ViewGroup?) {
        _binding = FragmentCargaDatosBinding.inflate(inflater,container,false)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}