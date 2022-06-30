package dev.eldinosaur.practica2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.eldinosaur.practica2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var adapter:PokemonAdapter
    private lateinit var binding:ActivityMainBinding
    private var pokemons:List<Pokemon> = listOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Configurar el adaptador
        configureAdapter()
        //Cargar los datos
        loadData()
        //Ejecucion de eventos
        events()
    }

    private fun events() {

    }

    private fun loadData() {
        //Crear la data estatica
         pokemons = listOf(
            Pokemon("Balbasour","https://cdn.traction.one/pokedex/pokemon/1.png"),
            Pokemon("Yvasour","https://cdn.traction.one/pokedex/pokemon/2.png"),
            Pokemon("Venesour","https://cdn.traction.one/pokedex/pokemon/3.png"),
            Pokemon("Charmander","https://cdn.traction.one/pokedex/pokemon/4.png"),
            Pokemon("Charmeleon","https://cdn.traction.one/pokedex/pokemon/5.png"),
            Pokemon("Balbasour","https://cdn.traction.one/pokedex/pokemon/1.png"),
            Pokemon("Yvasour","https://cdn.traction.one/pokedex/pokemon/2.png"),
            Pokemon("Venesour","https://cdn.traction.one/pokedex/pokemon/3.png"),
            Pokemon("Charmander","https://cdn.traction.one/pokedex/pokemon/4.png"),
            Pokemon("Charmeleon","https://cdn.traction.one/pokedex/pokemon/5.png")
        )
        adapter.updateListPokemon(pokemons)
    }

    private fun configureAdapter() {
        adapter = PokemonAdapter()
        binding.rvPokedex.adapter = adapter

        adapter.setOnclickPokemon ={
            val bundle = Bundle().apply {
                putSerializable(Constantes.KEY_POKEMON, it)
            }
            val intent = Intent(this,DetallePokemonActivity::class.java).apply{
                    putExtras(bundle)
            }
            startActivity(intent)
            }
        }
}