package cl.inacap.appparking

import java.io.Serializable

data class Usuario(
    val rut: String,
    val nombre: String,
    val apellido: String,
    val correo: String,
    val cargo: String,
    val contraseña: Int
): Serializable