package dev.eldinosaur.practica2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.eldinosaur.practica2.databinding.ActivityDetallePokemonBinding
import dev.eldinosaur.practica2.databinding.ActivityMainBinding
import com.squareup.picasso.Picasso

class DetallePokemonActivity : AppCompatActivity() {

    private  lateinit var binding: ActivityDetallePokemonBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_pokemon)
        binding = ActivityDetallePokemonBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras
        bundle?.let{
            val pokemon = it.getSerializable(Constantes.KEY_POKEMON) as Pokemon
            Picasso.get().load(pokemon.url).error(R.drawable.ic_launcher_background).into(binding.imgDetallePokemon)
            binding.txtDellePokemon.text = pokemon.nombre
        }
    }


}