package dev.eldinosaur.practica2

import java.io.Serializable

data class Contacto (
    val nombre:String,
    val trabajo:String,
    val correo:String,
    val url:String):Serializable

