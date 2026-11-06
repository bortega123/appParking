package cl.inacap.appparking

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.addCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ManipularCircuito : AppCompatActivity() {

    private lateinit var tvusucir: TextView
    private lateinit var btnact: Button
    private lateinit var btndes: Button
    private lateinit var btnvolver: Button

    private var usu: Usuario? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_manipular_circuito)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        tvusucir = findViewById(R.id.tvusucir)
        btnact = findViewById(R.id.btnact)
        btndes = findViewById(R.id.btndes)
        btnvolver = findViewById(R.id.btnvolver)

        usu = intent.getSerializableExtra("usu", Usuario::class.java)

        tvusucir.setText("Bienvenido Usuario : " + usu?.nombre)

        botonActivar()
        botonDesactivar()
        botonVolver()
        desactivarFlecha()

    } // Cierra el "onCreate".

    fun botonActivar() {
        btnact.setOnClickListener {
            Toast.makeText(this@ManipularCircuito, "¡ Asistente Activado !", Toast.LENGTH_SHORT).show()
        }
    }

    fun botonDesactivar() {
        btndes.setOnClickListener {
            Toast.makeText(this@ManipularCircuito, "¡ Asistente Desactivado !", Toast.LENGTH_SHORT).show()
        }
    }

    fun botonVolver() {
        btnvolver.setOnClickListener {
            var intent = Intent(this@ManipularCircuito, Menu::class.java)
            intent.putExtra("usu", usu)
            startActivity(intent)
        }
    }

    private fun desactivarFlecha() {
        onBackPressedDispatcher.addCallback(this) {
        }
    }

} // Cierra la clase "ManipularCircuito".