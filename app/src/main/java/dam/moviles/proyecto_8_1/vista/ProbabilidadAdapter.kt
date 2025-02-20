package dam.moviles.proyecto_8_1.vista

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dam.moviles.proyecto_8_1.databinding.ItemNombreBinding
import dam.moviles.proyecto_8_1.modelo.Pais

class ProbabilidadAdapter(
    var paises:List<Pais>,
    val lambda: (ProbabilidadHolder) -> Unit
) : RecyclerView.Adapter<ProbabilidadHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProbabilidadHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemNombreBinding.inflate(inflater,parent,false)
        return ProbabilidadHolder(binding)
    }

    override fun getItemCount(): Int = paises.size

    override fun onBindViewHolder(holder: ProbabilidadHolder, position: Int) {
        val pais = paises.get(position)
        holder.mostrarProbabilidad(pais)
        holder.binding.root.setOnClickListener {
            lambda(holder)
        }
    }
}