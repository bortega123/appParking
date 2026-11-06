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

class Estadisticas : AppCompatActivity() {

    private lateinit var tvusuest: TextView
    private lateinit var btnvolver: Button

    private var usu: Usuario? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_estadisticas)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        tvusuest = findViewById(R.id.tvusuest)
        btnvolver = findViewById(R.id.btnvolver)

        usu = intent.getSerializableExtra("usu", Usuario::class.java)

        tvusuest.setText("Bienvenido Usuario : " + usu?.nombre)

        botonVolver()
        desactivarFlecha()

    } // Cierra el "onCreate".

    fun botonVolver() {
        btnvolver.setOnClickListener {
            var intent = Intent(this@Estadisticas, Menu::class.java)
            intent.putExtra("usu", usu)
            startActivity(intent)
        }
    }

    private fun desactivarFlecha() {
        onBackPressedDispatcher.addCallback(this) {
        }
    }

} // Cierra la clase "Estadisticas".