package cl.inacap.appparking

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.addCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CrearCuenta : AppCompatActivity() {

    private lateinit var txtrut: EditText
    private lateinit var txtnom: EditText
    private lateinit var txtape: EditText
    private lateinit var txtcor: EditText
    private lateinit var spncar: Spinner
    private lateinit var txtcon: EditText
    private lateinit var txtrep: EditText
    private lateinit var btnreg: Button
    private lateinit var btnvolver: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_crear_cuenta)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        txtrut = findViewById(R.id.txtrut)
        txtnom = findViewById(R.id.txtnom)
        txtape = findViewById(R.id.txtape)
        txtcor = findViewById(R.id.txtcor)
        spncar = findViewById(R.id.spncar)
        txtcon = findViewById(R.id.txtcon)
        txtrep = findViewById(R.id.txtrep)
        btnreg = findViewById(R.id.btnreg)
        btnvolver = findViewById(R.id.btnvolver)

        // Se cargan las opciones del desplegable "Cargo"
        val cargos = listOf("Cargo", "Conductor", "Administrador")
        spncar.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, cargos)

        botonRegistrar()
        botonVolver()
        desactivarFlecha()

    } // Cierra el "onCreate".

    fun botonRegistrar() {
        btnreg.setOnClickListener {
            if (txtrut.getText().toString().trim().isEmpty()
                || txtnom.getText().toString().trim().isEmpty()
                || txtape.getText().toString().trim().isEmpty()
                || txtcor.getText().toString().trim().isEmpty()
                || txtcon.getText().toString().trim().isEmpty()
                || txtrep.getText().toString().trim().isEmpty()) {

                Toast.makeText(
                    this@CrearCuenta,
                    "¡ Complete Los Campos Faltantes !",
                    Toast.LENGTH_LONG
                ).show()

            } else if (spncar.getSelectedItemPosition() == 0) {

                Toast.makeText(
                    this@CrearCuenta,
                    "¡ Seleccione Un Cargo !",
                    Toast.LENGTH_SHORT
                ).show()

            } else if (!txtcon.getText().toString().equals(txtrep.getText().toString())) {

                txtcon.setText("")
                txtrep.setText("")

                Toast.makeText(
                    this@CrearCuenta,
                    "¡ Las Contraseñas No Coinciden !",
                    Toast.LENGTH_SHORT
                ).show()

            } else {

                Toast.makeText(
                    this@CrearCuenta,
                    "¡ Cuenta Creada Con Éxito !",
                    Toast.LENGTH_LONG
                ).show()

                var intent = Intent(this@CrearCuenta, Principal::class.java)
                startActivity(intent)

            } // Cierra el if/else.
        } // Cierra el evento onClick.
    } // Cierra la función "botonRegistrar".

    fun botonVolver() {
        btnvolver.setOnClickListener {
            var intent = Intent(this@CrearCuenta, Principal::class.java)
            startActivity(intent)
        }
    }

    private fun desactivarFlecha() {
        onBackPressedDispatcher.addCallback(this) {
        }
    }

} // Cierra la clase "CrearCuenta".