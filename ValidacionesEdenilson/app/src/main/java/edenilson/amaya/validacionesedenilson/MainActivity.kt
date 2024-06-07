package edenilson.amaya.validacionesedenilson

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //1-Mandar a llamar a todos los elementos de la vista
        val txtNombre = findViewById<EditText>(R.id.txtNombre)
        val txtCorreo = findViewById<EditText>(R.id.txtCorreo)
        val txtPassword = findViewById<EditText>(R.id.txtPassword)
        val txtEdad = findViewById<EditText>(R.id.txtEdad)
        val txtDui = findViewById<EditText>(R.id.txtDui)
        val btnAgregar = findViewById<Button>(R.id.btnAgregar)

        //2-Programamos el boton
        btnAgregar.setOnClickListener {
            //Validamos que los campos no esten vacios
            if (txtNombre.text.isEmpty() || txtCorreo.text.isEmpty() || txtPassword.text.isEmpty() || txtEdad.text.isEmpty() || txtDui.text.isEmpty()) {
                Toast.makeText(this, "Campos Vacios", Toast.LENGTH_SHORT).show()
            } else {
                if (!txtEdad.text.matches("[0-9]+".toRegex())) {
                    Toast.makeText(this, "Ingrese numeros", Toast.LENGTH_SHORT).show()
                } else {
                    //Validamos Correo
                    if (!txtCorreo.text.matches("[a-zA-Z0-9.-_]+@[a-z]+\\.+[a-z]+".toRegex())) {
                        Toast.makeText(this, "Ingrese correo valido", Toast.LENGTH_SHORT).show()
                    } else {
                        //Validamos Contraseña tenga minimo 6 caracteres
                        if (txtPassword.text.length < 6 || txtPassword.text.matches("[0-9]+".toRegex())) {
                            Toast.makeText(
                                this,
                                "La contraseña debe contener mas de 6 digitos",
                                Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            //Validamos DUI
                            if (txtDui.text.length == 10 || txtDui.text.matches("[0-9]+[-]+[0-9]".toRegex())) {
                                Toast.makeText(this,"DUI Invalido",Toast.LENGTH_SHORT).show()
                            }
                        }
                    }

                }

            }
        }
    }
}