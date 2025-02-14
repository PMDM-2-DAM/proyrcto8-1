package dam.moviles.proyecto_8_1.vista

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import dam.moviles.proyecto_8_1.R
import dam.moviles.proyecto_8_1.databinding.FragmentInicioBinding
import dam.moviles.proyecto_8_1.databinding.FragmentResultadoBinding
import dam.moviles.proyecto_8_1.modelo.Nombre

class ResultadoFragment : Fragment() {
    var _binding: FragmentResultadoBinding? = null
    val binding: FragmentResultadoBinding
        get() = checkNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        inicializarBinding(inflater,container)
        inicializarBotones()
        test()
        return binding.root
    }

    private fun test() {
        val nombre:Nombre = ResultadoFragmentArgs.fromBundle(requireArguments()).nombre
        nombre.paises.forEach { elemento -> Log.d("Pais", elemento.id +" "+elemento.probability) }
    }

    private fun inicializarBotones() {
        binding.btnNueva.setOnClickListener{
            val nav: NavController = findNavController()
            nav.popBackStack()
        }
    }

    private fun inicializarBinding(inflater: LayoutInflater,container: ViewGroup?) {
        _binding = FragmentResultadoBinding.inflate(inflater,container,false)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}