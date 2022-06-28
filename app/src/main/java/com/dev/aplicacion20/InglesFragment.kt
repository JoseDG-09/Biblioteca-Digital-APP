package com.dev.aplicacion20

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_ingles.*


class InglesFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ingles, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnMenu.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.menuFragment)
        }

        comiXology.setOnClickListener {
            val link = "https://www.comixology.com/free-comics"
            val ir = Intent(activity, Web::class.java).apply {
                putExtra("Link", link)
            }
            startActivity(ir)
        }

        Archive.setOnClickListener {
            val link = "https://archive.org/"
            val ir = Intent(activity, Web::class.java).apply {
                putExtra("Link", link)
            }
            startActivity(ir)
        }

        Gutenberg.setOnClickListener {
            val link = "https://www.gutenberg.org/"
            val ir = Intent(activity, Web::class.java).apply {
                putExtra("Link", link)
            }
            startActivity(ir)
        }

        freeLibrary.setOnClickListener {
            val link = "https://www.thefreelibrary.com/"
            val ir = Intent(activity, Web::class.java).apply {
                putExtra("Link", link)
            }
            startActivity(ir)
        }

    }

}