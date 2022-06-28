package com.dev.aplicacion20

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_tematicas.*

class TematicasFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tematicas, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnMenu.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.menuFragment)
        }

        Juridicas.setOnClickListener {
            val link = "https://biblio.juridicas.unam.mx/bjv"
            val ir = Intent(activity, Web::class.java).apply {
                putExtra("Link", link)
            }
            startActivity(ir)
        }

        econLib.setOnClickListener {
            val link = "https://www.econlib.org/search/"
            val ir = Intent(activity, Web::class.java).apply {
                putExtra("Link", link)
            }
            startActivity(ir)
        }

        bvSalud.setOnClickListener {
            val link = "https://bvsalud.org/es/"
            val ir = Intent(activity, Web::class.java).apply {
                putExtra("Link", link)
            }
            startActivity(ir)
        }

        Loc.setOnClickListener {
            val link = "https://catalog.loc.gov/?__cf_chl_jschl_tk__=J7jJC32QzYFFsleJf0Q_FT6uV.OGgnqGXcGR.8lbq_M-1642871102-0-gaNycGzNCKU"
            val ir = Intent(activity, Web::class.java).apply {
                putExtra("Link", link)
            }
            startActivity(ir)
        }

    }
}