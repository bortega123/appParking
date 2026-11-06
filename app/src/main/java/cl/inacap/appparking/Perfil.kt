package cl.inacap.appparking

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.addCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Perfil : AppCompatActivity() {

    private lateinit var tvusuperfil: TextView
    private lateinit var tvrut: TextView
    private lateinit var tvnom: TextView
    private lateinit var tvape: TextView
    private lateinit var tvcor: TextView
    private lateinit var tvcar: TextView
    private lateinit var tvcon: TextView
    private lateinit var btnvolver: Button

    private var usu: Usuario? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_perfil)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        tvusuperfil = findViewById(R.id.tvusuperfil)
        tvrut = findViewById(R.id.tvrut)
        tvnom = findViewById(R.id.tvnom)
        tvape = findViewById(R.id.tvape)
        tvcor = findViewById(R.id.tvcor)
        tvcar = findViewById(R.id.tvcar)
        tvcon = findViewById(R.id.tvcon)
        btnvolver = findViewById(R.id.btnvolver)

        usu = intent.getSerializableExtra("usu", Usuario::class.java)

        tvusuperfil.setText("Bienvenido Usuario : " + usu?.nombre)
        tvrut.setText("Rut : " + usu?.rut)
        tvnom.setText("Nombre : " + usu?.nombre)
        tvape.setText("Apellido : " + usu?.apellido)
        tvcor.setText("Correo : " + usu?.correo)
        tvcar.setText("Cargo : " + usu?.cargo)
        tvcon.setText("Contraseña : " + usu?.contraseña)

        botonVolver()
        desactivarFlecha()

    } // Cierra el "onCreate".

    fun botonVolver() {
        btnvolver.setOnClickListener {
            var intent = Intent(this@Perfil, Menu::class.java)
            intent.putExtra("usu", usu)
            startActivity(intent)
        }
    }

    private fun desactivarFlecha() {
        onBackPressedDispatcher.addCallback(this) {
        }
    }

} // Cierra la clase "Perfil".