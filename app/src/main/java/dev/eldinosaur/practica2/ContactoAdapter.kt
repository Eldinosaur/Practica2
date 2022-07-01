package dev.eldinosaur.practica2


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import dev.eldinosaur.practica2.databinding.ItemContactoBinding

class ContactoAdapter constructor(var contactos:List<Contacto> = listOf()):RecyclerView.Adapter<ContactoAdapter.ContactoAdapterViewHolder>() {
    //Metodo lambda para pasar la responsabilidad del clic al Activity
    lateinit var setOnclickContacto: (Contacto) -> Unit
    //Clase interna ViewHolder para manejar DATA y el XML
    inner class ContactoAdapterViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding: ItemContactoBinding = ItemContactoBinding.bind(itemView)

        fun bind(contacto:Contacto) = with(binding){
            txtContactoNombre.text = contacto.nombre
            txtContactoTrabajo.text = contacto.trabajo
            txtContactoCorreo.text = contacto.correo
            Picasso.get().load(contacto.url).error(R.drawable.ic_launcher_background).into(imgContacto)

            root.setOnClickListener{
                setOnclickContacto(contacto)
            }
        }
    }

    fun updateListContacto(contactos: List<Contacto>){
        this.contactos = contactos
        notifyDataSetChanged()
    }

    //presentarle la vista con la cual va a trabajar (item_contacto)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactoAdapterViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_contacto, parent, false)
        return ContactoAdapterViewHolder(view)
    }

    //esta funcion se va a ejecutar tantas veces como elementos existan en la lista
    override fun onBindViewHolder(holder: ContactoAdapterViewHolder, position: Int) {
        val contacto:Contacto = contactos[position]
        holder.bind(contacto)
    }

    //cuantos elementos tiene la lista
    override fun getItemCount(): Int {
        return contactos.size
    }
}