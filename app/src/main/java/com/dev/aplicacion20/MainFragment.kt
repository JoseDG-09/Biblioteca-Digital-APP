package com.dev.aplicacion20

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_main.*


class MainFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnMenu.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.menuFragment)
        }

        btnGoogleSchool.setOnClickListener {
            val link = "https://scholar.google.com/"
            val ir = Intent(activity, Web::class.java).apply {
                putExtra("Link", link)
            }
            startActivity(ir)
        }

        btnPaises.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.internacionalesFragment)
        }

        btnTemas.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.tematicasFragment)
        }

        btnIng.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.inglesFragment)
        }

        btnTodas.setOnClickListener {
            Navigation.findNavController(view).navigate((R.id.todasFragment))
        }

    }

}