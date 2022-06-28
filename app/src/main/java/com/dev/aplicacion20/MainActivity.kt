package com.dev.aplicacion20

import android.app.Activity
import android.content.*
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File
import java.util.jar.Manifest

enum class ProviderType {
    BASIC,
    GOOGLE
}
class MainActivity : AppCompatActivity() {

    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bundle: Bundle? = intent.extras
        val email: String? = bundle?.getString("email")
        val provider: String? = bundle?.getString("provider")
        setUp(email?: "", provider?: "")

        // Guardar estado de la app

        val estado: SharedPreferences.Editor = getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE).edit()
        estado.putString("email", email)
        estado.putString("provider", provider)
        estado.apply()
    }

    private fun setUp (email: String, provider: String) {
        title = "Inicio"
        Email.text = email
        Provider.text = provider

        db.collection("users").document(email).get().addOnSuccessListener {
            edtDireccion.setText(it.get("direccion")as String?)
            edtTelefono.setText(it.get("telefono")as String?)
        }

        btnLogAut.setOnClickListener {
            val estado: SharedPreferences.Editor = getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE).edit()
            estado.clear()
            estado.apply()
            FirebaseAuth.getInstance().signOut()
            onBackPressed()
        }

        btnGuardar.setOnClickListener {
            db.collection("users").document(email).set(
                hashMapOf("provider" to provider,
                "direccion" to edtDireccion.text.toString(),
                "telefono" to edtTelefono.text.toString())
            )
        }

        btnInicio.setOnClickListener {
            val Redireccion = Intent(this, Principal::class.java).apply {
                putExtra("email", email)
                putExtra("provider", provider)
            }
            startActivity(Redireccion)
        }
    }
}