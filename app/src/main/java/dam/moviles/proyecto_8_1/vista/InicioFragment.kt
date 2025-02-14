package dam.moviles.proyecto_8_1.vista

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import dam.moviles.proyecto_8_1.R
import dam.moviles.proyecto_8_1.databinding.FragmentInicioBinding

class InicioFragment : Fragment() {
    var _binding:FragmentInicioBinding? = null
    val binding:FragmentInicioBinding
        get() = checkNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        inicializarBinding(inflater,container)
        iniclializarBoton()
        return binding.root
    }

    private fun iniclializarBoton() {
        binding.btnEnviar.setOnClickListener {
            val nav: NavController = findNavController()
            val flecha = InicioFragmentDirections.actionInicioFragmentToCargaDatosFragment(binding.txtNombre.text.toString())
            nav.navigate(flecha)
        }
    }

    private fun inicializarBinding(inflater: LayoutInflater,container: ViewGroup?) {
        _binding = FragmentInicioBinding.inflate(inflater,container,false)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}