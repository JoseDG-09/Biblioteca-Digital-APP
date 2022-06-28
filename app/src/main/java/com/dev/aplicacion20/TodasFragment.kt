package com.dev.aplicacion20

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_todas.*


class TodasFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_todas, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnMenu.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.menuFragment)
        }

        Cervantes.setOnClickListener {
            val link = "https://www.cervantesvirtual.com"
            val ir = Intent(activity, Web::class.java).apply {
                putExtra("Link", link)
            }
            startActivity(ir)
        }

        banRep.setOnClickListener {
            val link = "https://www.banrepcultural.org/biblioteca-virtual"
            val ir = Intent(activity, Web::class.java).apply {
                putExtra("Link", link)
            }
            startActivity(ir)
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

        comikBook.setOnClickListener {
            val link = "https://comicbookplus.com/?cid=1732"
            val ir = Intent(activity, Web::class.java).apply {
                putExtra("Link", link)
            }
            startActivity(ir)
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

        comiXology.setOnClickListener {
            val link = "https://www.comixology.com/free-comics"
            val ir = Intent(activity, Web::class.java).apply {
                putExtra("Link", link)
            }
            startActivity(ir)
        }

        Archive.setOnClickListener {
            val link = "https://archive.org/details/comics"
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