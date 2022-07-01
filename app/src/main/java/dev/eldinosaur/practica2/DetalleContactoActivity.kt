package dev.eldinosaur.practica2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import dev.eldinosaur.practica2.databinding.ActivityDetalleContactoBinding

class DetalleContactoActivity : AppCompatActivity() {

    private lateinit var binding:ActivityDetalleContactoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_contacto)
        binding = ActivityDetalleContactoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras
        bundle?.let{
            val contacto = it.getSerializable(Constantes.KEY_CONTACTO) as Contacto
            Picasso.get().load(contacto.url).error(R.drawable.ic_launcher_background).into(binding.imgDetalleContacto)
            binding.txtDetalleContactoNombre.text = contacto.nombre
            binding.txtDetalleContactoTrabajo.text = contacto.trabajo
            binding.txtDetalleContactoCorreo.text = contacto.correo
        }
    }
}