package cl.inacap.appparking

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.addCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Principal : AppCompatActivity() {

    // Definir objetos que representan los controles del diseño
    private lateinit var txtrut: EditText
    private lateinit var txtcon: EditText
    private lateinit var btnini: Button
    private lateinit var btncrear: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_principal)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Inicializar objetos
        txtrut = findViewById(R.id.txtrut)
        txtcon = findViewById(R.id.txtcon)
        btnini = findViewById(R.id.btnini)
        btncrear = findViewById(R.id.btncrear)

        botonLogin()
        botonCrear()
        desactivarFlecha()

    } // Cierra el "onCreate".

    fun botonLogin() {
        btnini.setOnClickListener {
            if (txtrut.getText().toString().trim().isEmpty()
                || txtcon.getText().toString().trim().isEmpty()) {

                Toast.makeText(
                    this@Principal,
                    "¡ Complete Los Campos Faltantes !",
                    Toast.LENGTH_LONG
                ).show()

            } else if (txtrut.getText().toString().equals("11111111-1")
                && txtcon.getText().toString().toInt() == 123) {

                var rut = txtrut.getText().toString()
                var nom = "Brandon".uppercase()
                var ape = "Ortega".uppercase()
                var cor = "bortega@gmail.com"
                var car = "conductor".uppercase()
                var con = txtcon.getText().toString().toInt()

                var usu = Usuario(rut, nom, ape, cor, car, con)

                var intent = Intent(this@Principal, Menu::class.java)
                intent.putExtra("usu", usu)
                startActivity(intent)

            } else {

                txtrut.setText("")
                txtcon.setText("")
                ocultarTeclado()

                Toast.makeText(
                    this@Principal,
                    "¡ Error de Rut y/o Contraseña !",
                    Toast.LENGTH_SHORT
                ).show()

            } // Cierra el if/else.
        } // Cierra el evento onClick.
    } // Cierra la función "botonLogin".

    fun botonCrear() {
        btncrear.setOnClickListener {
            var intent = Intent(this@Principal, CrearCuenta::class.java)
            startActivity(intent)
        }
    } // Cierra la función "botonCrear".

    private fun ocultarTeclado() {
        val view = currentFocus
        if (view != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    private fun desactivarFlecha() {
        onBackPressedDispatcher.addCallback(this) {
            // Si dejas vacío, NO hace nada
            // Si quieres cerrar la app:
            // finish()
        }
    }

} // Cierra la clase "Principal".