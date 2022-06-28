package com.dev.aplicacion20

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_internacionales.*

class InternacionalesFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_internacionales, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnMenu.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.menuFragment)
        }

        Nacional.setOnClickListener {
            val link = "https://bibliotecanacional.gov.co/es-co"
            val ir = Intent(activity, Web::class.java).apply {
                putExtra("Link", link)
            }
            startActivity(ir)
        }

        bn.setOnClickListener {
            val link = "https://catalogo.bn.gov.ar/F/JEBTFU5U3HB3LC3S6P7E2XT23MC7A3AK9KD7N8SA449H46ESYJ-22042?func=find-b-0&local_base=GENER"
            val ir = Intent(activity, Web::class.java).apply {
                putExtra("Link", link)
            }
            startActivity(ir)
        }
    }
}