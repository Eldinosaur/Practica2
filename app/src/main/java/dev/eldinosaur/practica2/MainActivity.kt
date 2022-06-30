package dev.eldinosaur.practica2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.eldinosaur.practica2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private  lateinit var adapter:PokemonAdapter
    private  lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //configurar el adaptador
        ConfigureAdapter()
        //cargar los datos
        LoadData()
    }
    fun ConfigureAdapter(){
        adapter = PokemonAdapter()
        binding.rvPokedex.adapter = adapter
    }
    fun LoadData(){
        //crear la data de forma estatica
        val pokemons:List<Pokemon> = listOf(
            Pokemon("Bulbasour","https://cdn.traction.one/pokedex/pokemon/1.png"),
            Pokemon("Yvasour","https://cdn.traction.one/pokedex/pokemon/2.png"),
            Pokemon("Venesour","https://cdn.traction.one/pokedex/pokemon/3.png"),
            Pokemon("Charmander","https://cdn.traction.one/pokedex/pokemon/4.png"),
            Pokemon("Charmeleon","https://cdn.traction.one/pokedex/pokemon/5.png"),
            Pokemon("Bulbasour","https://cdn.traction.one/pokedex/pokemon/1.png"),
            Pokemon("Yvasour","https://cdn.traction.one/pokedex/pokemon/2.png"),
            Pokemon("Venesour","https://cdn.traction.one/pokedex/pokemon/3.png"),
            Pokemon("Charmander","https://cdn.traction.one/pokedex/pokemon/4.png"),
            Pokemon("Charmeleon","https://cdn.traction.one/pokedex/pokemon/5.png"),
            Pokemon("Bulbasour","https://cdn.traction.one/pokedex/pokemon/1.png"),
            Pokemon("Yvasour","https://cdn.traction.one/pokedex/pokemon/2.png"),
            Pokemon("Venesour","https://cdn.traction.one/pokedex/pokemon/3.png"),
            Pokemon("Charmander","https://cdn.traction.one/pokedex/pokemon/4.png"),
            Pokemon("Charmeleon","https://cdn.traction.one/pokedex/pokemon/5.png"),
            Pokemon("Bulbasour","https://cdn.traction.one/pokedex/pokemon/1.png"),
            Pokemon("Yvasour","https://cdn.traction.one/pokedex/pokemon/2.png"),
            Pokemon("Venesour","https://cdn.traction.one/pokedex/pokemon/3.png"),
            Pokemon("Charmander","https://cdn.traction.one/pokedex/pokemon/4.png"),
            Pokemon("Charmeleon","https://cdn.traction.one/pokedex/pokemon/5.png")
            )
        adapter.updateListPokemon(pokemons)
    }
}