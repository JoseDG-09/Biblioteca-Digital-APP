package com.dev.aplicacion20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import androidx.core.os.bundleOf
import kotlinx.android.synthetic.main.activity_auth.*
import kotlinx.android.synthetic.main.activity_principal.*
import kotlinx.android.synthetic.main.fragment_todas.*
import org.imaginativeworld.whynotimagecarousel.ImageCarousel
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem

class Principal : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)
    }

}