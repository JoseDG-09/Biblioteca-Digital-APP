package com.dev.aplicacion20

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.activity_auth.*
import kotlinx.android.synthetic.main.fragment_menu.*
import kotlinx.android.synthetic.main.fragment_menu.btnLogin


class MenuFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnInicio.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.mainFragment)
        }

        btnLogin.setOnClickListener {

            val enviar = Intent(activity, Auth::class.java)
            startActivity(enviar)
        }
    }
}