package dev.eldinosaur.practica2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import dev.eldinosaur.practica2.databinding.ActivityContactosBinding

class ContactosActivity : AppCompatActivity() {

    private lateinit var adapter:ContactoAdapter
    private lateinit var binding:ActivityContactosBinding
    private var contactos:List<Contacto> = listOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contactos)

        binding = ActivityContactosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configureAdapter()
        loadData()
        events()
    }
    private fun events() = with(binding){
        edtBuscar.addTextChangedListener(object:TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                TODO("Not yet implemented")
            }

            override fun onTextChanged(filterText: CharSequence?, p1: Int, p2: Int, p3: Int) {

                if(filterText?.length!! >0){
                    val filterListContactos= contactos.filter {
                            contacto->  contacto.nombre.uppercase().contains(filterText.toString().uppercase())
                    }
                    adapter.updateListContacto(filterListContactos)
                }else{
                    loadData()
                }
            }

            override fun afterTextChanged(p0: Editable?) {
                TODO("Not yet implemented")
            }
        })
    }
    private fun loadData(){
        contactos = listOf(
            Contacto("Anahi Naranjo","Android Developer","anaranjo@example.com","https://cdn.traction.one/pokedex/pokemon/1.png"),
            Contacto("Nicole Paredes","Android Developer","anaranjo@example.com","https://cdn.traction.one/pokedex/pokemon/1.png"),
            Contacto("Liz Lop","Android Developer","anaranjo@example.com","https://cdn.traction.one/pokedex/pokemon/1.png"),
            Contacto("Michelle Vega","Android Developer","anaranjo@example.com","https://cdn.traction.one/pokedex/pokemon/1.png"),
            Contacto("Anahi Naranjo","Android Developer","anaranjo@example.com","https://cdn.traction.one/pokedex/pokemon/1.png"),
            Contacto("Nicole Paredes","Android Developer","anaranjo@example.com","https://cdn.traction.one/pokedex/pokemon/1.png"),
            Contacto("Liz Lop","Android Developer","anaranjo@example.com","https://cdn.traction.one/pokedex/pokemon/1.png"),
            Contacto("Michelle Vega","Android Developer","anaranjo@example.com","https://cdn.traction.one/pokedex/pokemon/1.png"),
            Contacto("Anahi Naranjo","Android Developer","anaranjo@example.com","https://cdn.traction.one/pokedex/pokemon/1.png"),
            Contacto("Nicole Paredes","Android Developer","anaranjo@example.com","https://cdn.traction.one/pokedex/pokemon/1.png"),
            Contacto("Liz Lop","Android Developer","anaranjo@example.com","https://cdn.traction.one/pokedex/pokemon/1.png"),
            Contacto("Michelle Vega","Android Developer","anaranjo@example.com","https://cdn.traction.one/pokedex/pokemon/1.png"),
            Contacto("Anahi Naranjo","Android Developer","anaranjo@example.com","https://cdn.traction.one/pokedex/pokemon/1.png"),
            Contacto("Nicole Paredes","Android Developer","anaranjo@example.com","https://cdn.traction.one/pokedex/pokemon/1.png"),
            Contacto("Liz Lop","Android Developer","anaranjo@example.com","https://cdn.traction.one/pokedex/pokemon/1.png"),
            Contacto("Michelle Vega","Android Developer","anaranjo@example.com","https://cdn.traction.one/pokedex/pokemon/1.png")
        )
    }
    private fun configureAdapter(){
        adapter = ContactoAdapter()
        binding.rvContactos.adapter = adapter

        adapter.setOnclickContacto = {
            val bundle = Bundle().apply {
                putSerializable(Constantes.KEY_CONTACTO,it)
            }
            val intent = Intent(this,DetalleContactoActivity::class.java).apply {
                putExtras(bundle)
            }
            startActivity(intent)
        }
    }
}