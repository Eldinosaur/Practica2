package dev.eldinosaur.practica2

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import dev.eldinosaur.practica2.databinding.ItemPokedexBinding
import com.squareup.picasso.Picasso

class PokemonAdapter constructor(var pokemons: List<Pokemon> = listOf()) : RecyclerView.Adapter<PokemonAdapter.PokemonAdapterViewHolder>(){

    //Metodo lambda para pasar la responsabilidad del clic al Activity
    lateinit var setOnclickPokemon: (Pokemon) -> Unit
    //Clase interna ViewHolder para manejar DATA y el XML
    inner class PokemonAdapterViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding:ItemPokedexBinding = ItemPokedexBinding.bind(itemView)

        fun bind(pokemon: Pokemon) = with(binding){
            txtNamePokemon.text = pokemon.nombre
            Picasso.get().load(pokemon.url).error(R.drawable.ic_launcher_background).into(imgPokemon)

            root.setOnClickListener{
                setOnclickPokemon(pokemon)
            }
        }
    }

    fun updateListPokemon(pokemons: List<Pokemon>){
        this.pokemons = pokemons
        //notifyDataSetChanged()
    }

    //presentarle la vista con la cual va a trabajar (item_pokedex)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonAdapterViewHolder {
        val view:View = LayoutInflater.from(parent.context).inflate(R.layout.item_pokedex, parent, false)
        return PokemonAdapterViewHolder(view)
    }

    //esta funcion se va a ejecutar tantas veces como elementos existan en la lista
    override fun onBindViewHolder(holder: PokemonAdapterViewHolder, position: Int) {
        val pokemon:Pokemon = pokemons[position]
        holder.bind(pokemon)
    }

    //cuantos elementos tiene la lista
    override fun getItemCount(): Int {
        return pokemons.size
    }

}