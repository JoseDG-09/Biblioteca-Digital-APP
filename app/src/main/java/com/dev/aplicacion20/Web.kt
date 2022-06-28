package com.dev.aplicacion20

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_web.*

class Web : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

        val bundle: Bundle? = intent.extras
        val Link: String? = bundle?.getString("Link")

        //Cerrar el navegador
        Cerrar.setOnClickListener {
            val exitWebView = Intent(this, Principal::class.java)
            startActivity(exitWebView)
        }

        //Refresh
        refresh.setOnRefreshListener {
            webView.reload()
        }

        //WebView
        webView.webChromeClient = object : WebChromeClient() {

        }

        webView.webViewClient = object : WebViewClient() {

            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                return false
            }

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                refresh.isRefreshing = true
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                refresh.isRefreshing = false
            }

        }

        val settings = webView.settings

        settings.javaScriptEnabled = true

        webView.loadUrl(Link?:"")

    }

    override fun onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack()
        } else {
            super.onBackPressed()
        }
    }

}