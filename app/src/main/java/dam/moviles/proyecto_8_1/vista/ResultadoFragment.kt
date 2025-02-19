package dam.moviles.proyecto_8_1.vista

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
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
    private lateinit var viewModel: ResultadoFragmentViewModel
    lateinit var nombre: Nombre

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        cargarNombre()
        inicializarViewModel()
        inicializarBinding(inflater,container)
        inicializarBotones()
        inicializarNombre()
        inicializarRecyclerView()
        test()
        return binding.root
    }

    private fun test() {
        nombre.paises.forEach { elemento -> Log.d("Pais", elemento.id +" "+elemento.probability) }
    }

    private fun cargarNombre() {
        nombre = ResultadoFragmentArgs.fromBundle(requireArguments()).nombre
    }

    private fun inicializarRecyclerView() {
        val adapter = ProbabilidadAdapter(nombre.paises) { holder ->
            Toast.makeText(
                requireContext(),
                "Seleccionado ${holder.pais.id}",
                Toast.LENGTH_SHORT
            ).show()
        }
        binding.lstPaises.adapter = adapter
    }

    private fun inicializarNombre() {
        binding.txtResNombre.setText(getString(R.string.resultado,nombre.name))
    }

    private fun inicializarBotones() {
        binding.btnNueva.setOnClickListener{
            val nav: NavController = findNavController()
            nav.popBackStack()
        }
    }

    private fun inicializarViewModel() {
        viewModel = ViewModelProvider(this).get(ResultadoFragmentViewModel::class.java)
        viewModel.asignarPaises(nombre.paises)
    }

    private fun inicializarBinding(inflater: LayoutInflater,container: ViewGroup?) {
        _binding = FragmentResultadoBinding.inflate(inflater,container,false)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}