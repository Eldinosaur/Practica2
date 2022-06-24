package dev.eldinosaur.practica2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import dev.eldinosaur.practica2.databinding.ItemPokedexBinding

class PokemonAdapter constructor(var pokemons:List<Pokemon> = listOf()) : RecyclerView.Adapter<PokemonAdapter.PokemonAdapterViewHolder>(){
    //Clase interna ViewHolder para manejar la data y el xml
    inner class PokemonAdapterViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val bindind:ItemPokedexBinding = ItemPokedexBinding.bind(itemView)

        fun bind(pokemon: Pokemon) = with(bindind){
            txtNamePokemon.text = pokemon.nombre
            Picasso.get().load(pokemon.url).error(R.drawable.ic_launcher_background).into(imgPokemon)
        }
    }
    fun updateListPokemon(pokemons:List<Pokemon>){
        this.pokemons = pokemons
        notifyDataSetChanged()

    }

    //presentarle la vista con la cual va a trabajar (item_pokedex)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonAdapterViewHolder {
        val view:View = LayoutInflater.from(parent.context).inflate(R.layout.item_pokedex,parent,false)
        return PokemonAdapterViewHolder(view)
    }

    //Esta funcion se va a ejecutar tantas veces como elementos exista en la lista
    override fun onBindViewHolder(holder: PokemonAdapterViewHolder, position: Int) {
        val pokemon:Pokemon = pokemons[position]
        holder.bind(pokemon)
    }

    //cuantos elementos tiene la lista
    override fun getItemCount(): Int {
        return pokemons.size
    }
}