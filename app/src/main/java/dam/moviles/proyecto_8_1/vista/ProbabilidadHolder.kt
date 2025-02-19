package dam.moviles.proyecto_8_1.vista

import androidx.recyclerview.widget.RecyclerView
import coil3.load
import dam.moviles.proyecto_8_1.databinding.ItemNombreBinding
import dam.moviles.proyecto_8_1.modelo.Nombre
import dam.moviles.proyecto_8_1.modelo.Pais

class ProbabilidadHolder(val binding:ItemNombreBinding) : RecyclerView.ViewHolder(binding.root) {
    lateinit var pais:Pais

    fun mostrarProbabilidad(p:Pais) {
        pais = p
        binding.txtProbabilidad.setText(p.probability.toString())
        var url = "https://flagsapi.com/" + p.id + "/flat/48.png"
        binding.imgPais.load(url)
    }
}