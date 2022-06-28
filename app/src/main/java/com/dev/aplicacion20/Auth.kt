package com.dev.aplicacion20

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.android.synthetic.main.activity_auth.*

class Auth : AppCompatActivity() {

    private val googleSigIn = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        Thread.sleep(1000)
        setTheme(R.style.Theme_Aplicacion20)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        setUp()
        sesion()
    }

    override fun onStart() {
        super.onStart()

        authLayout.visibility = View.VISIBLE
    }

    private fun sesion() {
        val estado: SharedPreferences = getSharedPreferences(getString(R.string.prefs_file),Context.MODE_PRIVATE)
        val email: String? = estado.getString("email", null)
        val provider: String? = estado.getString("provider", null)

        if (email != null && provider != null) {
            authLayout.visibility = View.INVISIBLE
            showHome(email, ProviderType.valueOf(provider))
        }
    }

    private fun setUp () {
        title = "Autenticacion"
        btnRegistrate.setOnClickListener {
            if (edtEmail.text.isNotEmpty() && edtPassword.text.isNotEmpty()){
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(edtEmail.text.toString(), edtPassword.text.toString()).addOnCompleteListener {
                    if (it.isSuccessful) {
                        showHome(it.result?.user?.email ?: "", ProviderType.BASIC)
                    }else {
                        showAlert()
                    }
                }
            }
        }

        btnLogin.setOnClickListener {
            if (edtEmail.text.isNotEmpty() && edtPassword.text.isNotEmpty()){
                FirebaseAuth.getInstance().signInWithEmailAndPassword(edtEmail.text.toString(), edtPassword.text.toString()).addOnCompleteListener {
                    if (it.isSuccessful) {
                        showHome(it.result?.user?.email ?: "", ProviderType.BASIC)
                    }else {
                        showAlert()
                    }
                }
            }
        }

        btnGoogle.setOnClickListener {
            val googleConf = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestIdToken("754093233234-vplm80lk6vl126dsrmsd7q5pscljt3ic.apps.googleusercontent.com").requestEmail().build()

            val googleClient: GoogleSignInClient = GoogleSignIn.getClient(this, googleConf)

            googleClient.signOut()

            startActivityForResult(googleClient.signInIntent, googleSigIn)
        }

    }

    private fun showAlert () {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error al momento de autenticar al usuario")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private fun showHome (email: String, provider: ProviderType) {
        val homeIntent = Intent(this, MainActivity::class.java).apply {
            putExtra("email", email)
            putExtra("provider", provider.name)
        }
        startActivity(homeIntent)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == googleSigIn) {
            val task: Task<GoogleSignInAccount> = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                val account: GoogleSignInAccount? = task.getResult(ApiException::class.java)

                if (account != null) {
                    val credential: AuthCredential = GoogleAuthProvider.getCredential(account.idToken, null)
                    FirebaseAuth.getInstance().signInWithCredential(credential).addOnCompleteListener {
                        if (it.isSuccessful) {
                            showHome(account.email ?: "", ProviderType.GOOGLE)
                        }else {
                            showAlert()
                        }
                    }
                }
            } catch (e: ApiException) {
                showAlert()
            }

        }

    }

}