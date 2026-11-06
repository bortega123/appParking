package cl.inacap.appparking

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.addCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Menu : AppCompatActivity() {

    // Definir objetos que representan los controles del diseño
    private lateinit var tvusumenu: TextView
    private lateinit var btn1: Button
    private lateinit var btn2: Button
    private lateinit var btn3: Button
    private lateinit var btn4: Button
    private lateinit var btn5: Button

    // Objeto que se recibe desde la actividad anterior
    private var usu: Usuario? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Inicializar objetos
        tvusumenu = findViewById(R.id.tvusumenu)
        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)
        btn4 = findViewById(R.id.btn4)
        btn5 = findViewById(R.id.btn5)

        // Se recibe el objeto enviado desde la actividad anterior.
        usu = intent.getSerializableExtra("usu", Usuario::class.java)

        // Se muestra el dato solo si NO es NULL
        tvusumenu.setText("Bienvenido Usuario : " + usu?.nombre)

        boton1()
        boton2()
        boton3()
        boton4()
        boton5()
        desactivarFlecha()

    } // Cierra el "onCreate".

    fun boton1() {
        btn1.setOnClickListener {
            var intent = Intent(this@Menu, ManipularCircuito::class.java)
            intent.putExtra("usu", usu)
            startActivity(intent)
        }
    } // Cierra la función "boton1".

    fun boton2() {
        btn2.setOnClickListener {
            var intent = Intent(this@Menu, Acciones::class.java)
            intent.putExtra("usu", usu)
            startActivity(intent)
        }
    } // Cierra la función "boton2".

    fun boton3() {
        btn3.setOnClickListener {
            var intent = Intent(this@Menu, Estadisticas::class.java)
            intent.putExtra("usu", usu)
            startActivity(intent)
        }
    } // Cierra la función "boton3".

    fun boton4() {
        btn4.setOnClickListener {
            var intent = Intent(this@Menu, Perfil::class.java)
            intent.putExtra("usu", usu)
            startActivity(intent)
        }
    } // Cierra la función "boton4".

    fun boton5() {
        btn5.setOnClickListener {

            var a = AlertDialog.Builder(this@Menu)
            a.setTitle("Pregunta")
            a.setMessage("¿Desea Cerrar La Sesión?")

            a.setNegativeButton("Cancelar") { dialog, wich ->
                dialog.dismiss()
            }

            a.setPositiveButton("Aceptar") { dialog, wich ->
                var intent = Intent(this@Menu, Principal::class.java)
                startActivity(intent)
            }

            a.setIcon(android.R.drawable.ic_menu_help)

            a.setCancelable(false)
            a.show()

        } // Cierra el evento onClick.
    } // Cierra la función "boton5".

    private fun desactivarFlecha() {
        onBackPressedDispatcher.addCallback(this) {
            // Si dejas vacío, NO hace nada
        }
    }

} // Cierra la clase "Menu".